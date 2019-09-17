package com.vote;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;

import com.vote.repository.*;
import com.vote.entity.*;

import java.util.stream.Stream;
@SpringBootApplication
public class VoteApplication {

	public static void main(String[] args) {
		SpringApplication.run(VoteApplication.class, args);
	}
	@Bean
	ApplicationRunner init(CompetitorRepository competitorRepository,PeopleRepository peopleRepository,VoteTypeRepository voteTypeRepository) {
		return args -> {
			Stream.of("Competitor-1","Competitor-2","Competitor-3","Competitor-4").forEach(name ->{ 
					Competitor com = new Competitor();
					com.setName(name);
					com.setSchool("TH-OP");
					competitorRepository.save(com);
			});
			Stream.of("people-1","people-2","people-3","people-4").forEach(name ->{ 
					People peo = new People();
					peo.setName(name);
					peopleRepository.save(peo);
			});
			Stream.of("VoteType-A","VoteType-B","VoteType-C","VoteType-D").forEach(name ->{ 
					VoteType vote = new VoteType();
					vote.setName(name);
					voteTypeRepository.save(vote);
			});
		
		};
	}
}
