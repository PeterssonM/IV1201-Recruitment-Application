package com.kth.iv1201.recruitmentApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kth.iv1201.recruitmentApp.domain.Role;

/**
 * Repository interface for managing {@link Role} entities in the database.
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    /**
     * Retrieves a specific {@link Role} entity from the database.
     * @param name Is the name of the {@link Role}. 
     * @return The found {@link Role} entity or null if no {@link Role} was found.
     */
    Role findByName(String name);
}

