package com.kth.iv1201.recruitmentApp.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.kth.iv1201.recruitmentApp.application.ApplicationService;


@Controller
public class AppController {

    @Autowired
    private ApplicationService applicationService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String submitLoginForm() {
            return "loginSuccess";
        
    }

    @GetMapping("/register")
    public String showRegisterForm() {
        return "register";
    }

    
    @PostMapping("/register")
    public String submitRegisterForm(){
        return "loginSuccess";
    }

}
