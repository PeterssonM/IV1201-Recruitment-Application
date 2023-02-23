package com.kth.iv1201.recruitmentApp.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kth.iv1201.recruitmentApp.domain.Person;
import com.kth.iv1201.recruitmentApp.domain.User;
import com.kth.iv1201.recruitmentApp.domain.UserDTO;
import com.kth.iv1201.recruitmentApp.repository.PersonRepository;


@Controller
public class AppController {

    @Autowired
    private PersonRepository personRepository;
    //private PersonRepository personRepository;
/* 
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        Person person = personRepository.findByUsernameAndPassword(username, password);

        if (person != null && person.getPassword().equals(password)) {
            return "redirect:/index";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }
    
    @GetMapping("/person")
    public String findJoelleWilkinson(Model model) {
        Person person = personRepository.findByName("MP");
        model.addAttribute("person", person);
        return "person";
    }
*/
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
    public String submitRegisterForm(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("email") String email,
            @RequestParam("username") String username,
            @RequestParam("password") String password) {
        try {
            //User user = new User(902, firstName, lastName, "", email, password, 2, username);
            //personRepository.save(user);

            Person person = new Person();
            //person.setPersonId(902);
            person.setName(firstName);
            person.setSurname(lastName);
            person.setEmail(email);
            person.setUsername(username);
            person.setPassword(password);
            personRepository.save(person);
        } catch (Exception e) {
            System.out.println("\n \n \n");
            System.out.println(e);
            System.out.println("\n \n \n");

            System.out.println("Something wrong here 12345!!");
        }
        return "loginSuccess";
    }
}
