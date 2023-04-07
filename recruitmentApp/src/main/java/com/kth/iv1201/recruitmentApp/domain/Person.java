package com.kth.iv1201.recruitmentApp.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;


/**
 * The persistent class for the person database table.
 * A Person has an email, name, password, personal identification number, surname, username
 * A person can also have a role, availabilities and competence profiles.
 * This class implements the UserDetails interface from Spring Security for user authentication and authorization.
 */
@Entity
@Table(name = "person")
public class Person implements Serializable, UserDetails {
	private static final long serialVersionUID = 1L;
	
	/**
	 * The personID of the Person in the database.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="person_id")
	private Integer personId;

	/**
	 * The email address of the Person.
	 */
	@NotBlank(message = "Email is mandatory")
	private String email;

	/**
	 * The first name of the Person.
	 */
	@NotBlank(message = "First name is mandatory")
	private String name;

	/**
	 * The password of the Person.
	 */
	@NotBlank(message = "Password is mandatory")
	private String password;

	/**
	 * The personal identification number of the Person.
	 */
	@NotBlank(message = "Personal identification number is mandatory")
	private String pnr;

	/**
	 * The last name of the Person.
	 */
	@NotBlank(message = "Last name is mandatory")
	private String surname;

	/**
	 * The username of the Person.
	 */
	@NotBlank(message = "Username is mandatory")
	private String username;

	/**
	 * The availabilities of the Person.
	 * bi-directional many-to-one association to Availability
	 */
	@OneToMany(mappedBy="person")
	private List<Availability> availabilities;

	/**
	 * The competence profiles of the Person.
	 * bi-directional many-to-one association to CompetenceProfile
	 */
	@OneToMany(mappedBy="person")
	private List<CompetenceProfile> competenceProfiles;

	/**
	 * The role of the Person.
	 * bi-directional many-to-one association to Role
	 */
	@ManyToOne
	@JoinColumn(name="role_id")
	private Role role;

	/**
     * Required by JPA, should not be used.
     */
	public Person() {}

	/**
	 * Gets the id of the person
	 * @return the id of the person
	 */
	public Integer getPersonId() {
		return this.personId;
	}

	/**
	 * Sets the id of the person
	 * @param personId the id of the person
	 */
	public void setPersonId(Integer personId) {
		this.personId = personId;
	}
	
	/**
	 * Gets the email of the person
	 * @return the email of the person
	 */
	public String getEmail() {
		return this.email;
	}
	
	/**
	 * Sets the email of the person
	 * @param email the email of the person
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Gets the first name of the person
	 * @return the name of the person
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Sets the first name of the person
	 * @param name the first name of the person
	 */
	public void setName(String name) {
		this.name = name;
	}
		
	/**
	 * Gets the password of the person
	 * @return the password of the person
	 */
	@Override
	public String getPassword() {
		return this.password;
	}
	
	/**
	 * Sets the password of the person
	 * @param password the password of the person
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Gets the personal identification number of the person
	 * @return the personal number of the person
	 */
	public String getPnr() {
		return this.pnr;
	}
	
	/**
	 * Sets the personal identification number of the person
	 * @param pnr the personal identification number of the person
	 */
	public void setPnr(String pnr) {
		this.pnr = pnr;
	}
	
	/**
	 * Gets the surname of the person
	 * @return the surname of the person
	 */
	public String getSurname() {
		return this.surname;
	}
	
	/**
	 * Sets the surname of the person
	 * @param surname the surname of the person
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	/**
	 * Gets the username of the person
	 * @return the username of the person
	 */
	@Override
	public String getUsername() {
		return this.username;
	}
	
	/**
	 * Sets the username of the person
	 * @param username the username of the person
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * Gets a list of availability periods associated with this person
	 * @return a list of availability periods associated with this person
	 */
	public List<Availability> getAvailabilities() {
		return this.availabilities;
	}
	
	/**
	 * Sets a list of availability periods associated with this person
	 * @param availabilities a list of availability periods associated with this person
	 */
	public void setAvailabilities(List<Availability> availabilities) {
		this.availabilities = availabilities;
	}
	
	/**
	 * Adds the availability for this person
	 * @param availability the availability for this person
	 * @return the availability 
	 */
	public Availability addAvailability(Availability availability) {
		getAvailabilities().add(availability);
		availability.setPerson(this);

		return availability;
	}
	
	/**
	 * Removes an availability from this instance. 
	 * @param availability The availability that will be removed. 
	 * @return The removed availability. 
	 */
	public Availability removeAvailability(Availability availability) {
		getAvailabilities().remove(availability);
		availability.setPerson(null);

		return availability;
	}
	
	/**
	 * Gets all competences associated with this instance.
	 * @return A list of competences. 
	 */
	public List<CompetenceProfile> getCompetenceProfiles() {
		return this.competenceProfiles;
	}
	
	/**
	 * Adds a list of competences to this instance. 
	 * @param competenceProfiles The competence list that will be added.
	 */
	public void setCompetenceProfiles(List<CompetenceProfile> competenceProfiles) {
		this.competenceProfiles = competenceProfiles;
	}
	
	/**
	 * Add competence to this instance.
	 * @param competenceProfile The competence that will be added.
	 * @return The added competence. 
	 */
	public CompetenceProfile addCompetenceProfile(CompetenceProfile competenceProfile) {
		getCompetenceProfiles().add(competenceProfile);
		competenceProfile.setPerson(this);

		return competenceProfile;
	}
	
	/**
	 * Removes the association between this instance and a given {@competenceProfile}. 
	 * @param competenceProfile The competence that will be removed. 
	 * @return The removed {@competenceProfile}. 
	 */
	public CompetenceProfile removeCompetenceProfile(CompetenceProfile competenceProfile) {
		getCompetenceProfiles().remove(competenceProfile);
		competenceProfile.setPerson(null);

		return competenceProfile;
	}
	
	/**
	 * Get role.
	 * @return This role instance.
	 */
	public Role getRole() {
		return this.role;
	}
	
	/**
	 * Set role.
	 * @param role The role that will be set.
	 */
	public void setRole(Role role) {
		this.role = role;
	}
	
	/**
	 * Returns a persons authorities. 
	 * @return A list of granted authorities. 
	 */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.getName());
        return Collections.singletonList(authority);
    }
	
	/**
	 * By default no account can expire.
	 * @return Whether this instance's account has expired or not.
	 */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
	
	/**
	 * By default all accounts are non locked.
	 * @return Whether this instance's accounts is locked or not. 
	 */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
	
	/**
	 * By default credentials can not expire.
	 * @return Whether this instance's credentials has expired or not. 
	 */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

	/**
	 * All persons are by default enabled.
	 * @return The status of the person. 
	 */
    @Override
    public boolean isEnabled() {
        return true;
    }

	/**
	 * Prints the object to console. 
	 */
	@Override
	public String toString() {
		return "Person [" +
			"personId=" + personId + 
			", email=" + email + 
			", name=" + name + 
			", password=" + password + 
			", pnr=" + pnr + 
			", surname=" + surname + 
			", username=" + username + 
			", " + role.toString() +
		"]";
	}

}
