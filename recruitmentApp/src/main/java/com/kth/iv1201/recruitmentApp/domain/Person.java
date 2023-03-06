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
 * 
 */
@Entity
@NamedQuery(name="Person.findAll", query="SELECT p FROM Person p")
public class Person implements Serializable, UserDetails {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="person_id")
	private Integer personId;

	@NotBlank(message = "Email is mandatory")
	private String email;

	@NotBlank(message = "First name is mandatory")
	private String name;

	@NotBlank(message = "Password is mandatory")
	private String password;

	@NotBlank(message = "Personal identification number is mandatory")
	private String pnr;

	@NotBlank(message = "Last name is mandatory")
	private String surname;

	@NotBlank(message = "Username is mandatory")
	private String username;

	//bi-directional many-to-one association to Availability
	@OneToMany(mappedBy="person")
	private List<Availability> availabilities;

	//bi-directional many-to-one association to CompetenceProfile
	@OneToMany(mappedBy="person")
	private List<CompetenceProfile> competenceProfiles;

	//bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name="role_id")
	private Role role;

	public Person() {
	}

	public Integer getPersonId() {
		return this.personId;
	}

	public void setPersonId(Integer personId) {
		this.personId = personId;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPnr() {
		return this.pnr;
	}

	public void setPnr(String pnr) {
		this.pnr = pnr;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Availability> getAvailabilities() {
		return this.availabilities;
	}

	public void setAvailabilities(List<Availability> availabilities) {
		this.availabilities = availabilities;
	}

	public Availability addAvailability(Availability availability) {
		getAvailabilities().add(availability);
		availability.setPerson(this);

		return availability;
	}

	public Availability removeAvailability(Availability availability) {
		getAvailabilities().remove(availability);
		availability.setPerson(null);

		return availability;
	}

	public List<CompetenceProfile> getCompetenceProfiles() {
		return this.competenceProfiles;
	}

	public void setCompetenceProfiles(List<CompetenceProfile> competenceProfiles) {
		this.competenceProfiles = competenceProfiles;
	}

	public CompetenceProfile addCompetenceProfile(CompetenceProfile competenceProfile) {
		getCompetenceProfiles().add(competenceProfile);
		competenceProfile.setPerson(this);

		return competenceProfile;
	}

	public CompetenceProfile removeCompetenceProfile(CompetenceProfile competenceProfile) {
		getCompetenceProfiles().remove(competenceProfile);
		competenceProfile.setPerson(null);

		return competenceProfile;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.getName());
        return Collections.singletonList(authority);
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

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
