package com.kth.iv1201.recruitmentApp.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * This class represents a competence in the recruitment application.
 * 
 */
@Entity
@Table(name = "competence")
public class Competence implements Serializable {
	private static final long serialVersionUID = 1L;

    /**
     * The competence ID.
     */
	@Id
	@Column(name="competence_id")
	private Integer competenceId;

    /**
     * The name of the role.
     */
	private String name;

	//bi-directional many-to-one association to CompetenceProfile
	@OneToMany(mappedBy="competence")
	private List<CompetenceProfile> competenceProfiles; 

	/**
     * Required by JPA, should not be used.
     */
	public Competence() {}

	/**
	 * Gets the ID of the competence.
	 * 
	 * @return the ID of the competence.
	 */
	public Integer getCompetenceId() {
		return this.competenceId;
	}

	/**
	 * Sets the ID of the competence.
	 * 
	 * @param competenceId the ID to set for the competence.
	 */
	public void setCompetenceId(Integer competenceId) {
		this.competenceId = competenceId;
	}

	/**
	 * Gets the name of the job role.
	 * 
	 * @return the name of the job role.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Sets the name of the job role.
	 * 
	 * @param name the name to set for the job role.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the list of competence profiles associated with this competence.
	 * 
	 * @return the list of competence profiles associated with this competence.
	 */
	public List<CompetenceProfile> getCompetenceProfiles() {
		return this.competenceProfiles;
	}

	/**
	 * Sets the list of competence profiles associated with this competence.
	 * 
	 * @param competenceProfiles the list of competence profiles to set for this competence.
	 */
	public void setCompetenceProfiles(List<CompetenceProfile> competenceProfiles) {
		this.competenceProfiles = competenceProfiles;
	}

	/**
	 * Adds a competence profile to this competence.
	 * 
	 * @param competenceProfile the competence profile to add to this competence.
	 * @return the added competence profile.
	 */
	public CompetenceProfile addCompetenceProfile(CompetenceProfile competenceProfile) {
		getCompetenceProfiles().add(competenceProfile);
		competenceProfile.setCompetence(this);

		return competenceProfile;
	}

	/**
	 * Removes a competence profile from this competence.
	 * 
	 * @param competenceProfile the competence profile to remove from this competence.
	 * @return the removed competence profile.
	 */
	public CompetenceProfile removeCompetenceProfile(CompetenceProfile competenceProfile) {
		getCompetenceProfiles().remove(competenceProfile);
		competenceProfile.setCompetence(null);

		return competenceProfile;
	}

}
