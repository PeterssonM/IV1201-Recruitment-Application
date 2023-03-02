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
    public String submitRegisterForm(@ModelAttribute("person") @Valid Person person, BindingResult result){
        if (result.hasErrors()) {
            return "register";
        } 
        else{
            System.out.println("\n1) " + person.toString());
            personService.saveUser(person);
            return "login";
        }
    }

    @GetMapping("/apply")
    public String showApplyForm() {
        return "apply";
    }

    @GetMapping("/error")
    public String showErrorForm() {
        return "error";
    }
    @PostMapping("/error")
    public String submitErrorForm() {
            return "error";
    }

    /*@GetMapping(value = {"/css/recruitment.css", "/loginSuccess"})
    public String showLoginSuccessForm() {
        return "loginSuccess";
    }*/

    @GetMapping("/css/recruitment.css")
    public String showLoginSuccessForm() {
        return "loginSuccess";
    }


}
