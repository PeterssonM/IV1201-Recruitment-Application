package com.kth.iv1201.recruitmentApp.domain;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "application")
public class Application {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "application_id")
    private Integer id;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "surname")
    private String surname;

    @Column(name = "from_date")
    private Date fromDate;
    
    @Column(name = "to_date")
    private Date toDate;
    
    @Column(name = "years_of_experience")
    private Integer yearsOfExperience;
    
    @Column(name = "competence_id")
    private Integer competenceId;

    @Column(name = "person_id")
    private Integer personId;

    public Application() {}
    
    public Application(String name, String surname, Date fromDate, Date toDate, Integer yearsOfExperience, Integer competenceId, Integer personId) {
        this.name = name;
        this.surname = surname;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.yearsOfExperience = yearsOfExperience;
        this.competenceId = competenceId;
        this.personId = personId;
    }
        
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public Integer getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(Integer yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public Integer getCompetenceId() {
        return competenceId;
    }

    public void setCompetenceId(Integer competenceId) {
        this.competenceId = competenceId;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }
}
