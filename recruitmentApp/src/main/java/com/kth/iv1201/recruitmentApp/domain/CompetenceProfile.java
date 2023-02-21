package com.kth.iv1201.recruitmentApp.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the competence_profile database table.
 * 
 */
@Entity
@Table(name="competence_profile")
@NamedQuery(name="CompetenceProfile.findAll", query="SELECT c FROM CompetenceProfile c")
public class CompetenceProfile implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="competence_profile_id")
	private Integer competenceProfileId;

	@Column(name="years_of_experience")
	private BigDecimal yearsOfExperience;

	//bi-directional many-to-one association to Competence
	@ManyToOne
	@JoinColumn(name="competence_id")
	private Competence competence;

	//bi-directional many-to-one association to Person
	@ManyToOne
	@JoinColumn(name="person_id")
	private Person person;

	public CompetenceProfile() {
	}

	public Integer getCompetenceProfileId() {
		return this.competenceProfileId;
	}

	public void setCompetenceProfileId(Integer competenceProfileId) {
		this.competenceProfileId = competenceProfileId;
	}

	public BigDecimal getYearsOfExperience() {
		return this.yearsOfExperience;
	}

	public void setYearsOfExperience(BigDecimal yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}

	public Competence getCompetence() {
		return this.competence;
	}

	public void setCompetence(Competence competence) {
		this.competence = competence;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}
