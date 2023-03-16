package com.kth.iv1201.recruitmentApp.presentation;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kth.iv1201.recruitmentApp.application.PersonService;
import com.kth.iv1201.recruitmentApp.domain.Person;


@Controller
public class AppController {

    @Autowired
    private PersonService personService;

    @GetMapping("/")
    public String serveHomePage() {
        return "index";
    }

    @GetMapping("/login")
    public String serveLoginPage() {
        return "login";
    }
    @PostMapping("/login")
    public String retriveLoginPage() {
            return "loginSuccess";
    }

    @GetMapping("/register")
    public String serveRegisterPage(Model model){
        model.addAttribute("person", new Person());
        return "register";
    }
    @PostMapping("/register")
    public String retriveRegisterPage(@ModelAttribute("person") @Valid Person person, BindingResult result){
        if (result.hasErrors()) {
            return "register";
        } 
        else{
            personService.saveUser(person);
            return "login";
        }
    }

    @GetMapping("/application")
    public String serveApplicationPage() {
        return "application";
    }

    @GetMapping("/viewApplications")
    public String serveViewApplicationsPage() {
        return "viewApplications";
    }

    @GetMapping("/error")
    public String serveErrorPage() {
        return "error";
    }

    /*---Used only for testing---*/

    @GetMapping("/loginSuccess")
    public String serveLoginSuccessPage() {
        return "loginSuccess";
    }

    @GetMapping("/secret")
    public String serveSecretPage() {
        return "secret";
    }


}
