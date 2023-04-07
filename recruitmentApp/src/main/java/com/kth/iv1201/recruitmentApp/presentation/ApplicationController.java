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
public class ApplicationController {

    @Autowired
    private PersonService personService;

    @Autowired
    private ApplicationService applicationService;

    /**
     * No view is specifically requested, serve home page.
     * @return The home page URL. 
     */
    @GetMapping("/")
    public String serveHomePage() {
        return "index";
    }

    /**
     * Handles login request. 
     * @return The login view. 
     */
    @GetMapping("/login")
    public String serveLoginPage() {
        return "login";
    }
    /**
     * The login form has been submitted.
     * Spring security will override what view is returned based of the context. 
     * @return Home page URL. 
     */
    @PostMapping("/login")
    public String retriveLoginPage() {
        return "redirect:/index";
    }

    /**
     * Handles register request.
     * @param model Object used to populate the new user account. 
     * @return The register view URL. 
     */
    @GetMapping("/register")
    public String serveRegisterPage(Model model){
        model.addAttribute("person", new Person());
        return "register";
    }
    /**
     * The register form has been submitted. 
     * @param person A populated person object.
     * @param result Validation result for the register form. 
     * @return A redirect to the login page URL. 
     * @throws UserAlreadyExistException If its thrown in 'personService.saveUser()'.
     */
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

    /**
     * Serves the create application form view. 
     * @return The application page URL. 
     */
    @GetMapping("/application")
    public String serveApplicationPage() {
        return "application";
    }

    /**
     * Displays all excisting applications. 
     * @param model Object used to pass the applications to the client. 
     * @return The view all applications URL.
     */
    @GetMapping("/viewApplications")
    public String serveViewApplicationsPage(Model model) {

        List<Application> applications = applicationService.getAllApplications();
        model.addAttribute("applications", applications);

        return "viewApplications";
    }

    /**
     * Handles logout request.
     * @param request request the HTTP servlet request for the logout operation
     * @return The login view with the parameter 'logout'. 
     * @throws ServletException If an error occurs during the logout process.
     */
    @GetMapping("/logout")
    public String logout(HttpServletRequest request) throws ServletException {
        request.logout();
        return "redirect:/login?logout";
    }

    /**
     * Serves the error view. 
     * @return The error page URL. 
     */
    @GetMapping("/error")
    public String serveErrorPage() {
        return "error";
    }

}
