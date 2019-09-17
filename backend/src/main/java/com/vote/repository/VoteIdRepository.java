
package com.vote.repository;
import com.vote.entity.VoteId;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin(origins = "http://localhost:8080")
@RepositoryRestResource
public
interface VoteIdRepository extends JpaRepository<VoteId, Long> {
    
}