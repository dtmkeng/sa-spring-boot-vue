package com.vote.entity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.FetchType;

import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import com.fasterxml.jackson.annotation.*;
@Data
@Entity
@NoArgsConstructor
@Table(name="VoteId")
public class VoteId {
	@Id
	@SequenceGenerator(name="voteid_seq",sequenceName="voteid_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="voteid_seq")
	@Column(name="voteid_ID",unique = true, nullable = true)
	private @NotNull Long id;
	// private @NotNull String name;

	@ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name="voteId")
    @JsonIgnore
    private Vote vote;


	@ManyToOne(fetch = FetchType.EAGER )
    @JoinColumn(name="competitorId")
    @JsonIgnore
    private Competitor competitor;
}