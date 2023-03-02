package com.kth.iv1201.recruitmentApp.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.kth.iv1201.recruitmentApp.domain.Person;
import com.kth.iv1201.recruitmentApp.domain.Role;

import com.kth.iv1201.recruitmentApp.repository.PersonRepository;
import com.kth.iv1201.recruitmentApp.util.UserAlreadyExistException;

@Service
public class PersonService implements UserDetailsService {

    @Autowired
    private PersonRepository personRepository;


    public Person saveUser(Person person) throws UserAlreadyExistException {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        person.setPassword(encoder.encode(person.getPassword()));
        
        Role role = new Role();
        role.setRoleId(2);
        person.setRole(role);

        System.out.println("\n2) " + person.toString());
        personRepository.save(person);
        return person;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Person person = personRepository.findByUsername(username);
        if(person == null)
            throw new UsernameNotFoundException(username);
        else{
            System.out.println("returned this person: " + person.toString());
            return person;
        }
             
    }

    
    
}
