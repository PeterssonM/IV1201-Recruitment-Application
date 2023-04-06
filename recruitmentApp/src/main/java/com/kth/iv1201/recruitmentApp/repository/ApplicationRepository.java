package com.kth.iv1201.recruitmentApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kth.iv1201.recruitmentApp.domain.Application;

/**
 * Repository interface for managing {@link Application} entities in the database.
 */
@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {
    
    /**
     * Retrieves all {@link Application} entities from the database.
     * @return A list of all {@link Application} entities.
     */
    @Override
    List<Application> findAll();
}

