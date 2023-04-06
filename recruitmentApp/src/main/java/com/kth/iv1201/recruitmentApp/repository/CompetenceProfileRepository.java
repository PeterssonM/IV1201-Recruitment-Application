package com.kth.iv1201.recruitmentApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kth.iv1201.recruitmentApp.domain.CompetenceProfile;

/**
 * Repository interface for managing {@link CompetenceProfile} entities in the database.
 */
@Repository
public interface CompetenceProfileRepository extends JpaRepository<CompetenceProfile, Integer> {}

