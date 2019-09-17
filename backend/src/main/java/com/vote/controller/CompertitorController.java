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
public class CompertitorController {

    @Autowired
    private final CompetitorRepository  competitorRepository;

    public CompertitorController(CompetitorRepository  competitorRepository) {
            this.competitorRepository = competitorRepository;
    }
    @GetMapping("/competitor")
    public Collection<Competitor> getCompetitorAll() {
        return competitorRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping("/competitor/{id}")
    public Competitor getCompetitorById(@PathVariable("id") Long id) {
        return competitorRepository.findById(id).get();
    }
}