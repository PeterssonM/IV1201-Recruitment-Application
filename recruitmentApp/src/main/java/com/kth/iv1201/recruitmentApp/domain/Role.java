package com.kth.iv1201.recruitmentApp.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the role database table.
 * 
 */
@Entity
@Table(name = "role")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="role_id")
	private Integer roleId;

	private String name;

	//bi-directional many-to-one association to Person
	@OneToMany(mappedBy="role")
	private List<Person> persons;

	/**
	 * Required by JPA should not be used. 
	 */
	public Role() {}

	/**
	 * Get role ID.
	 * @return The ID of the role. 
	 */
	public Integer getRoleId() {
		return this.roleId;
	}

	/**
	 * Set role ID.
	 * @param roleId The ID that will be set.
	 */
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	/**
	 * Get role name.
	 * @return The name of the role.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Prints the object to console. 
	 */
	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", name=" + name + "]";
	}

	/**
	 * Set role name. 
	 * @param name The name that will be set.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get all persons with associated with this role instance.
	 * @return A list of all persons associated with this role instance.
	 */
	public List<Person> getPersons() {
		return this.persons;
	}

	/**
	 * Set a list of persons to be associated with this role instance.
	 * @param persons A list of persons which will have their role set. 
	 */
	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	/**
	 * Adds a single person to be associated with this role instance.
	 * @param person The person which will have their role set. 
	 * @return The person with a new role. 
	 */
	public Person addPerson(Person person) {
		getPersons().add(person);
		person.setRole(this);

		return person;
	}

	/**
	 * Removes a single person's association to this role instance. 
	 * @param person The person which will no longer be associated to this role. 
	 * @return The person with no role associated to it. 
	 */
	public Person removePerson(Person person) {
		getPersons().remove(person);
		person.setRole(null);

		return person;
	}
}
