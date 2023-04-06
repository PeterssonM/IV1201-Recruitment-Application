package com.kth.iv1201.recruitmentApp.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kth.iv1201.recruitmentApp.domain.Application;
import com.kth.iv1201.recruitmentApp.repository.ApplicationRepository;
import com.kth.iv1201.recruitmentApp.repository.AvailabilityRepository;
import com.kth.iv1201.recruitmentApp.repository.CompetenceProfileRepository;
import com.kth.iv1201.recruitmentApp.repository.CompetenceRepository;
import com.kth.iv1201.recruitmentApp.repository.PersonRepository;
import com.kth.iv1201.recruitmentApp.repository.RoleRepository;

import java.util.List;

/**
 * This class provides methods for managing job applications.
 */
@Service
public class ApplicationService {

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

    @Autowired
    private ApplicationRepository applicationRepository;
    
    /**
     * Returns a list of all job applications found in the database
     * 
     * @return a list of all job applications found in the database
     */
    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }    
}
