package com.kth.iv1201.recruitmentApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.kth.iv1201.recruitmentApp.domain.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
    
    Person findByName(@Param("name") String name);
    
    Person findByUsernameAndPassword(String username, String password);

    Person findByUsername(String username);
}

