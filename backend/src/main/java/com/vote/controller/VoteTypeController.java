package com.vote.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
public class VoteTypeController {

    @Autowired
    private final VoteTypeRepository  voteTypeRepository;

    public VoteTypeController(VoteTypeRepository  voteTypeRepository) {
            this.voteTypeRepository = voteTypeRepository;
    }
    @GetMapping("/votetype")
    public Collection<VoteType> getVoteTypeAll() {
        return voteTypeRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping("/votetype/{id}")
    public VoteType getVoteTypeById(@PathVariable("id") Long id) {
         return voteTypeRepository.findById(id).get();
    }
}