package com.kth.iv1201.recruitmentApp.presentation;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.kth.iv1201.recruitmentApp.application.ApplicationService;
import com.kth.iv1201.recruitmentApp.domain.Person;


@Controller
public class AppController {

    @Autowired
    private ApplicationService applicationService;

    @GetMapping("/")
    public String serveHomePage() {
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
    public String showRegisterForm(Model model){
        model.addAttribute("person", new Person());
        return "register";
    }
    @PostMapping("/register")
    public String submitRegisterForm(@Valid Person person, BindingResult result){
        if (result.hasErrors()) {
            // Handle validation errors
            return "register";
        } else{
            System.out.println("\n\n\n1) " + person.toString() + "\n\n");
            applicationService.createPerson(person);
            return "loginSuccess";
        }
    }

}
