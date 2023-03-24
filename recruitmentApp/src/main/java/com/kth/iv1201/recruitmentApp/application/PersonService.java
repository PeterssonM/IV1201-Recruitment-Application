package com.kth.iv1201.recruitmentApp.application;

import java.util.List;

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

        if(personRepository.findByPnr(person.getPnr()) != null)
            throw new UserAlreadyExistException("Pnr: '" + person.getPnr() + "'. Is already in use.", "pnr");

        if(personRepository.findByEmail(person.getEmail()) != null)
            throw new UserAlreadyExistException("Email: '" + person.getEmail() + "'. Is already in use.", "email");
 
        if(personRepository.findByUsername(person.getUsername()) != null)
            throw new UserAlreadyExistException("Username: '" + person.getUsername() + "'. Is already in use.", "username");
        

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        person.setPassword(encoder.encode(person.getPassword()));
        
        Role role = new Role();
        role.setRoleId(1);
        person.setRole(role);

        //System.out.println("\n2) " + person.toString());
        personRepository.save(person);
        return person;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Person person = personRepository.findByUsername(username);
        
        if(person == null)
            throw new UsernameNotFoundException(username);
        else{
            System.out.println("The person found: " + person.toString());
            return person; 
        }
    }

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }
}
