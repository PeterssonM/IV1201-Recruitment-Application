package com.kth.iv1201.recruitmentApp.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kth.iv1201.recruitmentApp.application.ApplicationService;
import com.kth.iv1201.recruitmentApp.domain.Person;


@Controller
public class AppController {

    @Autowired
    private ApplicationService applicationService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        System.out.println("\n \n @GetMapping(/login)");
        System.out.println("\n \n Received login request for username: ");

        model.addAttribute("person", new Person());
        return "login";
    }

    @PostMapping("/login")
    //public String login(@RequestParam String username, @RequestParam String password) {
    public String login(Person person) {
        System.out.println("\n \n @PostMapping(/login)");
        //System.out.println("\n \n Received login request for username: " + username);
       // System.out.println("Password: " + password);

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
