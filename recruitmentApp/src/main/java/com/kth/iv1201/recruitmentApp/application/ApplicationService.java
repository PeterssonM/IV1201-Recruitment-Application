package com.kth.iv1201.recruitmentApp.application;

import org.springframework.beans.factory.annotation.Autowired;

import com.kth.iv1201.recruitmentApp.domain.Person;
import com.kth.iv1201.recruitmentApp.domain.UserDTO;
import com.kth.iv1201.recruitmentApp.repository.PersonRepository;

public class ApplicationService {

    @Autowired
    private PersonRepository personRepository;
    
    public Person getUser(String username, String password) {
        Person person = personRepository.findByUsernameAndPassword(username, password);
        /*UserDTO userDTO = new UserDTO(
            person.getPersonId(), 
            person.getName(), 
            person.getSurname(), 
            person.getPnr(), 
            person.getEmail(), 
            person.getPassword(), 
            person.getRole().getRoleId(), 
            person.getUsername()
        );*/
        return person;
    }
}
