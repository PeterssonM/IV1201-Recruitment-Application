package com.kth.iv1201.recruitmentApp.presentation;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
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
    public String submitRegisterForm(@ModelAttribute("person") @Valid Person person, BindingResult result){
        if (result.hasErrors()) {
            return "register";
        } 
        else{
            System.out.println("\n 1) " + person.toString());
            personService.saveUser(person);
            return "loginSuccess";
        }
    }

    @GetMapping("/application")
    public String showApplicationForm() {
        return "application";
    }

    @GetMapping("/viewApplications")
    public String showViewApplicationsForm() {
        return "viewApplications";
    }

    @GetMapping("/mylogout")
    public String showLogoutForm() {
        return "logout";
    }

    @GetMapping("/error")
    public String showErrorForm() {
        return "error";
    }

    /*---Used only for testing---*/

    @GetMapping("/loginSuccess")
    public String showLoginSuccessPage() {
        return "loginSuccess";
    }

    @GetMapping("/secret")
    public String showSecretForm() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        System.out.println("\n \n " + "User authorities2222: " + authorities + "\n \n ");
        // rest of your code


        return "secret";
    }

    


}
