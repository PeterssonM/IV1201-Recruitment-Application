package com.kth.iv1201.recruitmentApp.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the competence database table.
 * 
 */
@Entity
@NamedQuery(name="Competence.findAll", query="SELECT c FROM Competence c")
public class Competence implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="competence_id")
	private Integer competenceId;

	private String name;

	//bi-directional many-to-one association to CompetenceProfile
	@OneToMany(mappedBy="competence")
	private List<CompetenceProfile> competenceProfiles;

	public Competence() {
	}

	public Integer getCompetenceId() {
		return this.competenceId;
	}

	public void setCompetenceId(Integer competenceId) {
		this.competenceId = competenceId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<CompetenceProfile> getCompetenceProfiles() {
		return this.competenceProfiles;
	}

	public void setCompetenceProfiles(List<CompetenceProfile> competenceProfiles) {
		this.competenceProfiles = competenceProfiles;
	}

	public CompetenceProfile addCompetenceProfile(CompetenceProfile competenceProfile) {
		getCompetenceProfiles().add(competenceProfile);
		competenceProfile.setCompetence(this);

		return competenceProfile;
	}

	public CompetenceProfile removeCompetenceProfile(CompetenceProfile competenceProfile) {
		getCompetenceProfiles().remove(competenceProfile);
		competenceProfile.setCompetence(null);

		return competenceProfile;
	}

}
