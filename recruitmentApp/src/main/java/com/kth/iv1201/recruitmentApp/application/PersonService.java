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


/**
 * This class provides methods for managing user accounts.
 */
@Service
public class PersonService implements UserDetailsService {

    @Autowired
    private PersonRepository personRepository;

    /**
     * Saves a new user account to the database.
     * Checks that user details are not already in use. 
     * Encrypts the password. 
     * 
     * @param person The person object representing the new user account.
     * @return The saved person object.
     * @throws UserAlreadyExistException If a user with the same pnr, email, or username already exists.
     */
    public Person saveUser(Person person) throws UserAlreadyExistException {

        if(personRepository.findByPnr(person.getPnr()) != null)
            throw new UserAlreadyExistException("Personal number: '" + person.getPnr() + "', is already in use.", "pnr");

        if(personRepository.findByEmail(person.getEmail()) != null)
            throw new UserAlreadyExistException("Email: '" + person.getEmail() + "', is already in use.", "email");
 
        if(personRepository.findByUsername(person.getUsername()) != null)
            throw new UserAlreadyExistException("Username: '" + person.getUsername() + "', is already in use.", "username");
        

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        person.setPassword(encoder.encode(person.getPassword()));
        
        Role role = new Role();
        role.setRoleId(2);
        person.setRole(role);

        personRepository.save(person);
        return person;
    }

    /**
     * Loads the user account from the database based on the specified username.
     * 
     * @param username The username of the user account to load.
     * @return The UserDetails object representing the loaded user account.
     * @throws UsernameNotFoundException If no user account with the specified username is found.
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Person person = personRepository.findByUsername(username);
        
        if(person == null)
            throw new UsernameNotFoundException(username);
        else{
            return person; 
        }
    }

    /**
     * Returns a list of all user accounts in the database.
     * 
     * @return A list of all user accounts in the database.
     */
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }
}
