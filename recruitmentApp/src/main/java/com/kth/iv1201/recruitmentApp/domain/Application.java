package com.kth.iv1201.recruitmentApp.domain;

import java.util.Date;

import javax.persistence.*;
/**
 * This class is the Application class contains information about the application
 * This class represents an application submitted by a person
 */

@Entity
@Table(name = "application")
public class Application {

    /**
     * The id of the application.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "application_id")
    private Integer id;
    
    /**
     * The first name of the person who submitted the application.
     */
    @Column(name = "name")
    private String name;

    /**
     * The surname of the person who submitted the application.
     */
    @Column(name = "surname")
    private String surname;

    /**
     * The starting date of the person's availability.
     */
    @Column(name = "from_date")
    private Date fromDate;

    /**
     * The end date of the person's availability.
     */
    @Column(name = "to_date")
    private Date toDate;

    /**
     * The number of years of experience the person has in the competence related to the application.
     */
    @Column(name = "years_of_experience")
    private float yearsOfExperience;

    /**
     * The id of the competence related to the application.
     */
    @Column(name = "competence_id")
    private Integer competenceId;

    /**
     * The id of the person who submitted the application.
     */
    @Column(name = "person_id")
    private Integer personId;

    /**
     * The current status of the application.
     */
    @Column(name = "status")
    private String status;

    //Constructor required by JPA.
    public Application() {}

    /**
     * Constructor that sets all the attributes of the application.
     * @param name The first name of the person who submitted the application.
     * @param surname The surname of the person who submitted the application.
     * @param fromDate The starting date of the person's availability.
     * @param toDate The ending date of the person's availability.
     * @param yearsOfExperience The number of years of experience the person has in the competence related to the application.
     * @param competenceId The id of the competence related to the application.
     * @param personId The id of the person who submitted the application.
     * @param status The current status of the application.
     */
    public Application(String name, String surname, Date fromDate, Date toDate, float yearsOfExperience, Integer competenceId, Integer personId, String status) {
        this.name = name;
        this.surname = surname;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.yearsOfExperience = yearsOfExperience;
        this.competenceId = competenceId;
        this.personId = personId;
        this.status = status;
    }
        
    /**
     * Gets the id of the application.
     * @return The id of the application.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the id of the application.
     * @param id The id of the application.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the first name of the person who submitted the application.
     * @return The name of the person who submitted the application.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the first name of the person who submitted the application.
     * @param id the first name of the person who submitted the application.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the surname of the person who submitted the application.
     * @return The surname of the person who submitted the application.
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Sets the surname of the person who submitted the application.
     * @param surname the surname of the person who submitted the application.
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Gets the start date of the period the applicant is available from.
     * @return the start date of the period the applicant is available from.
     */
    public Date getFromDate() {
        return fromDate;
    }

    /**
     * Sets the start date of the period the applicant is available from.
     * @param fromDate the start date of the period the applicant is available from.
     */
    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    /**
     * Gets the end date of the period the applicant is available to.
     * @return the end date of the period the applicant is available to.
     */
    public Date getToDate() {
        return toDate;
    }

    /**
     * Sets the end date of the period the applicant is available to.
     * @param toDate the end date of the period the applicant is available to.
     */
    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    /**
     * Gets the years of experience of the applicant
     * @return the years of experience of the applicant
     */
    public float getYearsOfExperience() {
        return yearsOfExperience;
    }

    /**
     * Sets the years of experience of the applicant
     * @param yearsOfExperience the years of experience of the applicant 
     */
    public void setYearsOfExperience(float yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    /**
     * Gets the ID of the competence the applicant has applied for.
     * @return the ID of the competence the applicant has applied for.
     */
    public Integer getCompetenceId() {
        return competenceId;
    }

    /**
     * Sets the ID of the competence the applicant has applied for.
     * @param competenceId the ID of the competence the applicant has applied for.
     */
    public void setCompetenceId(Integer competenceId) {
        this.competenceId = competenceId;
    }

    /**
     * Gets the ID of the person who has submitted the application.
     * @return the ID of the person who has submitted the application.
     */
    public Integer getPersonId() {
        return personId;
    }

    /**
     * Sets the ID of the person who has submitted the application.
     * @param personId the ID of the person who has submitted the application. 
     */
    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    /**
     * Gets the status of the application.
     * @return the status of the application
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status of the application.
     * @param status the status of the application. 
     */
    public void setStatus(String status) {
        this.status = status;
    }
}
