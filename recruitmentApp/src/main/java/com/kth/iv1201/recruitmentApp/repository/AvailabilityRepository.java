package com.kth.iv1201.recruitmentApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kth.iv1201.recruitmentApp.domain.Availability;

/**
 * Repository interface for managing {@link Availability} entities in the database.
 */
@Repository
public interface AvailabilityRepository extends JpaRepository<Availability, Integer> {}

