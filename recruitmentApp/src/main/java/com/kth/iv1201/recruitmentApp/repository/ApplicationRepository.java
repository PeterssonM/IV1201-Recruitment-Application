package com.kth.iv1201.recruitmentApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kth.iv1201.recruitmentApp.domain.Application;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {
    @Override
    List<Application> findAll();
}

