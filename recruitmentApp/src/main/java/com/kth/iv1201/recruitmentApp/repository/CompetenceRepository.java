package com.kth.iv1201.recruitmentApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kth.iv1201.recruitmentApp.domain.Competence;

/**
 * Repository interface for managing {@link Competence} entities in the database.
 */
@Repository
public interface CompetenceRepository extends JpaRepository<Competence, Integer> {}

