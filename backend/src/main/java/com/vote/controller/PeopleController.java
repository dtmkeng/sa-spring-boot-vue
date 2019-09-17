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
public class PeopleController {

    @Autowired
    private final PeopleRepository  peopleRepository;

    public PeopleController(PeopleRepository  peopleRepository) {
            this.peopleRepository = peopleRepository;
    }
    @GetMapping("/people")
    public Collection<People> getPeopleAll() {
        return peopleRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping("/people/{id}")
    public People getPeopleById(@PathVariable("id") Long id) {
         return peopleRepository.findById(id).get();
    }
}