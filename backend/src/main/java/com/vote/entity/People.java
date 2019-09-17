package com.vote.entity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.FetchType;

import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import com.fasterxml.jackson.annotation.*;
@Data
@Entity
@NoArgsConstructor
@Table(name="People")
public class People {
	@Id
	@SequenceGenerator(name="People_seq",sequenceName="People_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="People_seq")
	@Column(name="People_ID",unique = true, nullable = true)
	private @NotNull Long id;
	private @NotNull String name;

	@OneToOne(mappedBy = "people")
	// @JoinColumn(name = "voteId")
	@JsonIgnore
	private Vote vote;
}