package com.kth.iv1201.recruitmentApp.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kth.iv1201.recruitmentApp.repository.AvailabilityRepository;

@Service
public class ApplicationService {

    @Autowired
    private AvailabilityRepository availabilityRepository;
    
}
