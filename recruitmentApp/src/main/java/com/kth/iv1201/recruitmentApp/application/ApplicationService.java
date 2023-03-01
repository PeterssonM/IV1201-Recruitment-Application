package com.kth.iv1201.recruitmentApp.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kth.iv1201.recruitmentApp.domain.Person;
import com.kth.iv1201.recruitmentApp.domain.Role;
import com.kth.iv1201.recruitmentApp.repository.AvailabilityRepository;
import com.kth.iv1201.recruitmentApp.repository.CompetenceProfileRepository;
import com.kth.iv1201.recruitmentApp.repository.CompetenceRepository;
import com.kth.iv1201.recruitmentApp.repository.PersonRepository;
import com.kth.iv1201.recruitmentApp.repository.RoleRepository;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class ApplicationService implements UserDetailsService {

    @Autowired
    private AvailabilityRepository availabilityRepository;

    @Autowired
    private CompetenceRepository competenceRepository;
    
    @Autowired
    private CompetenceProfileRepository competenceProfileRepository;
    
    @Autowired
    private PersonRepository personRepository;
    
    @Autowired
    private RoleRepository roleRepository;

    public Person createPerson(Person person){
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
        //flera users kan ha samma username. Ev returnera alla matchande usernames och sedan kolla matchande lösenord?
        Person person = personRepository.findByUsername(username);
        if(person == null){
            throw new UsernameNotFoundException(username);
        }
        UserDetailsPrincipal userDetailsPrincipal = new UserDetailsPrincipal(person);
        return userDetailsPrincipal;
    }
    
    
}
