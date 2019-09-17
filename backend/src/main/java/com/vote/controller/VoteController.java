
package com.vote.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.vote.repository.*;
import com.vote.entity.*;
import com.vote.model.*;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class VoteController {

    @Autowired
    private final VoteRepository  voteRepository;
    @Autowired
    private final PeopleRepository  peopleRepository;
    @Autowired
    private final CompetitorRepository  competitorRepository;
    @Autowired
    private final VoteTypeRepository  voteTypeRepository;
    
    @Autowired
    private final VoteIdRepository voteIdRepository;

    public VoteController(VoteRepository  voteRepository,PeopleRepository  peopleRepository,CompetitorRepository  competitorRepository, VoteTypeRepository  voteTypeRepository,VoteIdRepository voteIdRepository) {
            this.voteRepository = voteRepository;
            this.peopleRepository = peopleRepository;
            this.competitorRepository = competitorRepository;
            this.voteTypeRepository = voteTypeRepository;
            this.voteIdRepository = voteIdRepository;
    }
    @PostMapping("/voted")
    public Vote index(@RequestBody BodyVote bodyVote) {
        Vote vote = new Vote();
        People p = peopleRepository.findById(bodyVote.getPrepleid()).get();
        VoteType votetype = voteTypeRepository.findById(bodyVote.getVotetype()).get();
        vote.setVoteType(votetype);
        vote.setPeople(p);
        for(Long comID: bodyVote.getCompetitor()) {  // loop save Competitor 
            System.out.println("==========================================================");
            System.out.print("Competitor ID\t");
            System.out.println(comID);
            System.out.println();
            Competitor com = competitorRepository.findById(comID).get();
            VoteId vid = new VoteId();
            vid.setVote(vote);
            vid.setCompetitor(com);
            voteIdRepository.save(vid);
        }

        return voteRepository.save(vote);
    }
    @GetMapping("/vote")
    public Collection<Vote> getVoteAll() {
        return voteRepository.findAll().stream().collect(Collectors.toList());
    }
}