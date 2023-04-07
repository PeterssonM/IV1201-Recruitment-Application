package com.kth.iv1201.recruitmentApp.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * This class represents the availability of a user/person in the database 
 */
@Entity
@Table(name = "availability")
public class Availability implements Serializable {
	private static final long serialVersionUID = 1L;

    /**
     * The availability ID.
     */
	@Id
	@Column(name="availability_id")
	private Integer availabilityId;

    /**
     * The starting date of the person's availability.
     */
	@Temporal(TemporalType.DATE)
	@Column(name="from_date")
	private Date fromDate;


    /**
     * The end date of the person's availability.
     */
	@Temporal(TemporalType.DATE)
	@Column(name="to_date")
	private Date toDate;

	/**
     * Bi-directional many-to-one association to Person
     */
	@ManyToOne
	@JoinColumn(name="person_id")
	private Person person;

    /**
     * Required by JPA, should not be used.
     */
	public Availability() {}

    /**
     * Gets the availability ID.
     * 
     * @return the availability ID
     */
	public Integer getAvailabilityId() {
		return this.availabilityId;
	}

    /**
     * Sets the availability ID.
     * 
     * @param availabilityId the availability ID to set
     */
	public void setAvailabilityId(Integer availabilityId) {
		this.availabilityId = availabilityId;
	}

    /**
     * Gets the start date of the availability period.
     * 
     * @return the start date of the availability period
     */
	public Date getFromDate() {
		return this.fromDate;
	}

    /**
     * Sets the start date of the availability period.
     * 
     * @param fromDate the start date of the availability period to set
     */
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

    /**
     * Gets the end date of the availability period.
     * 
     * @return the end date of the availability period
     */
	public Date getToDate() {
		return this.toDate;
	}

    /**
     * Sets the end date of the availability period.
     * 
     * @param toDate the end date of the availability period to set
     */
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

    /**
     * Gets the person associated with this availability.
     * 
     * @return the person associated with this availability
     */
	public Person getPerson() {
		return this.person;
	}

    /**
     * Sets the person associated with this availability.
     * 
     * @param person the person to set
     */
	public void setPerson(Person person) {
		this.person = person;
	}

}
