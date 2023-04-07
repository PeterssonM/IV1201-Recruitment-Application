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
public class CompetenceProfile implements Serializable {
	private static final long serialVersionUID = 1L;

    /**
     * The competence profile ID.
     */
	@Id
	@Column(name="competence_profile_id")
	private Integer competenceProfileId;

    /**
     * The number of years of experience.
     */
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


	/**
	 * Required by JPA, should not be used.
	 */
	public CompetenceProfile() {}

	/**
	 * Gets the competence profile id of this CompetenceProfile.
	 *
	 * @return the competence profile id of this CompetenceProfile
	 */
	public Integer getCompetenceProfileId() {
		return this.competenceProfileId;
	}

	/**
	 * Sets the competence profile id of this CompetenceProfile.
	 *
	 * @param competenceProfileId the new competence profile id for this CompetenceProfile
	 */
	public void setCompetenceProfileId(Integer competenceProfileId) {
		this.competenceProfileId = competenceProfileId;
	}

	/**
	 * Gets the years of experience of this CompetenceProfile.
	 *
	 * @return the years of experience of this CompetenceProfile
	 */
	public BigDecimal getYearsOfExperience() {
		return this.yearsOfExperience;
	}

	/**
	 * Sets the years of experience of this CompetenceProfile.
	 *
	 * @param yearsOfExperience the new years of experience for this CompetenceProfile
	 */
	public void setYearsOfExperience(BigDecimal yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}

	/**
	 * Gets the competence of this CompetenceProfile.
	 *
	 * @return the competence of this CompetenceProfile
	 */
	public Competence getCompetence() {
		return this.competence;
	}

	/**
	 * Sets the competence of this CompetenceProfile.
	 *
	 * @param competence the new competence for this CompetenceProfile
	 */
	public void setCompetence(Competence competence) {
		this.competence = competence;
	}

	/**
	 * Gets the person of this CompetenceProfile.
	 *
	 * @return the person of this CompetenceProfile
	 */
	public Person getPerson() {
		return this.person;
	}

	/**
	 * Sets the person of this CompetenceProfile.
	 *
	 * @param person the new person for this CompetenceProfile
	 */
	public void setPerson(Person person) {
		this.person = person;
	}

}
