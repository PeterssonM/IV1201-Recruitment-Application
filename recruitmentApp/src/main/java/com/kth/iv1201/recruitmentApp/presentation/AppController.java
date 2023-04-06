package com.kth.iv1201.recruitmentApp.presentation;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kth.iv1201.recruitmentApp.application.ApplicationService;
import com.kth.iv1201.recruitmentApp.application.PersonService;
import com.kth.iv1201.recruitmentApp.domain.Application;
import com.kth.iv1201.recruitmentApp.domain.Person;
import com.kth.iv1201.recruitmentApp.util.UserAlreadyExistException;

/**
 * Handles all HTTP requests. 
 */
@Controller
public class AppController {

    @Autowired
    private PersonService personService;

    @Autowired
    private ApplicationService applicationService;

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
            return "redirect:/loginSuccess";
    }

    @GetMapping("/register")
    public String serveRegisterPage(Model model){
        model.addAttribute("person", new Person());
        return "register";
    }
    @PostMapping("/register")
    public String retriveRegisterPage(@ModelAttribute("person") @Valid Person person, BindingResult result) throws UserAlreadyExistException{
        if (result.hasErrors()) {
            return "register";
        } 
        else{
            personService.saveUser(person);
            return "redirect:/login";
        }
    }

    @GetMapping("/application")
    public String serveApplicationPage() {
        return "application";
    }

    @GetMapping("/viewApplications")
    public String serveViewApplicationsPage(Model model) {

        List<Application> applications = applicationService.getAllApplications();
        model.addAttribute("applications", applications);

        return "viewApplications";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) throws ServletException {
        request.logout();
        return "redirect:/login?logout";
    }


    @GetMapping("/error")
    public String serveErrorPage() {
        return "error";
    }

}
