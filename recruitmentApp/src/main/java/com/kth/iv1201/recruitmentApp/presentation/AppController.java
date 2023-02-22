package com.kth.iv1201.recruitmentApp.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kth.iv1201.recruitmentApp.domain.Person;
import com.kth.iv1201.recruitmentApp.domain.UserDTO;
import com.kth.iv1201.recruitmentApp.repository.PersonRepository;

@Controller
public class AppController {

    @Autowired
    private PersonRepository personRepository;

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

}
