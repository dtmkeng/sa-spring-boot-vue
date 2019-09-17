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
@Table(name="VoteType")
public class VoteType {
	@Id
	@SequenceGenerator(name="voteType_seq",sequenceName="voteType_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="voteType_seq")
	@Column(name="voteType_ID",unique = true, nullable = true)
	private @NotNull Long id;
	private @NotNull String name;

}