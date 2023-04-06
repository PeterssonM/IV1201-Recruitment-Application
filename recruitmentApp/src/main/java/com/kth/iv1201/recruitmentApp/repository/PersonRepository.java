package com.kth.iv1201.recruitmentApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kth.iv1201.recruitmentApp.domain.Person;

/**
 * Repository interface for managing {@link Person} entities in the database.
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
    
    /**
     * Retrieves a specific {@link Person} entity from the database.
     * @param pnr A persons associated personal number. 
     * @return The found {@link Person} entity or null if no {@link Person} was found.
     */
    Person findByPnr(String pnr);

    /**
     * Retrieves a specific {@link Person} entity from the database.
     * @param email A persons associated email. 
     * @return The found {@link Person} entity or null if no {@link Person} was found.
     */
    Person findByEmail(String email);

    /**
     * Retrieves a specific {@link Person} entity from the database.
     * @param username A persons associated username. 
     * @return The found {@link Person} entity or null if no {@link Person} was found.
     */
    Person findByUsername(String username);

}

