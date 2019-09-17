package com.vote.entity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.FetchType;
import com.fasterxml.jackson.annotation.*;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity
@NoArgsConstructor
@Table(name="Vote")
public class Vote {
	@Id
	@SequenceGenerator(name="vote_seq",sequenceName="vote_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="vote_seq")
	@Column(name="vote_ID",unique = true, nullable = true)
	private @NotNull Long id;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = VoteType.class)
    @JoinColumn(name = "voteTypeId", insertable = true)
    @JsonManagedReference
	private @NotNull VoteType voteType;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "people")
    @JsonManagedReference
	private People people;

    @OneToMany(fetch = FetchType.EAGER ,mappedBy="vote")
    @JsonManagedReference
    private Collection<VoteId> voteId;

}