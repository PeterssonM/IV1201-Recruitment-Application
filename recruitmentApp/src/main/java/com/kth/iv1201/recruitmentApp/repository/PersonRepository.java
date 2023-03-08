package com.kth.iv1201.recruitmentApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kth.iv1201.recruitmentApp.domain.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
    
    Person findByUsername(String username);

    Person findByPassword(String password);
    
    Person findByUsernameAndPassword(String username, String password);

    Person findByEmail(String email);

}

