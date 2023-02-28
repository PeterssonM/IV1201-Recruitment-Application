package com.kth.iv1201.recruitmentApp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kth.iv1201.recruitmentApp.domain.Person;
import com.kth.iv1201.recruitmentApp.repository.PersonRepository;
import java.util.logging.Logger;


@Service
public class MyUserDetailsService implements UserDetailsService {
    private final Logger logger = Logger.getLogger(MyUserDetailsService.class.getName());

    @Autowired
    private PersonRepository personRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("\n \n Entering the loadUserByUsername method \n \n ");
        logger.info("Attempting to load user with username: " + username);
        System.out.println("\n \n 1111111111111 \n \n ");

        Person person = personRepository.findByUsername(username);
        
        System.out.println("\n \n 22222222222222222222222222222 \n \n ");

        if (person == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        System.out.println("\n \n Person look like " + person.toString());
        logger.info("User with username " + username + " found in the database");

        System.out.println("\n \n 3333333333333333333333333333333 \n \n ");

        return new MyUserDetails(person);
    }
}
