package com.vote.entity;
import lombok.*;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.FetchType;

import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity
@NoArgsConstructor
@Table(name="Competitor")
public class Competitor {
	@Id
	@SequenceGenerator(name="competitor_seq",sequenceName="competitor_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="competitor_seq")
	@Column(name="competitor_ID",unique = true, nullable = true)
	private @NotNull Long id;
	private @NotNull String name;
    private @NotNull String school;

	@OneToMany(fetch = FetchType.EAGER ,mappedBy="competitor")
    // @JsonManagedReference
    private Collection<VoteId> voteId;

}