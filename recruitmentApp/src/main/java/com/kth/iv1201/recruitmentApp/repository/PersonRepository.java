package com.kth.iv1201.recruitmentApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.kth.iv1201.recruitmentApp.domain.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
    
    
    /*@Query(value = "SELECT name FROM person WHERE name = ':name'")
    Person findByName(String name);*/

    //@Query(value = "SELECT * FROM person WHERE name = :name", nativeQuery = true)
    Person findByName(@Param("name") String name);

    
    Person findByUsernameAndPassword(String username, String password);
}

