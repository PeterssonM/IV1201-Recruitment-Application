package com.kth.iv1201.recruitmentApp.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.kth.iv1201.recruitmentApp.repository.PersonRepository;


@Controller
public class AppController {

    @Autowired
    private PersonRepository personRepository;

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
