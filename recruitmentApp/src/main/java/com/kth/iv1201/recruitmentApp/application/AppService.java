package com.kth.iv1201.recruitmentApp.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kth.iv1201.recruitmentApp.domain.Application;
import com.kth.iv1201.recruitmentApp.repository.ApplicationRepository;

import java.util.List;

@Service
public class AppService {
    
    @Autowired
    private ApplicationRepository applicationRepository;
    
    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }
    

    
}
