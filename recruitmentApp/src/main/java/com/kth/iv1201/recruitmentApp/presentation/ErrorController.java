package com.kth.iv1201.recruitmentApp.presentation;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.kth.iv1201.recruitmentApp.domain.Person;
import com.kth.iv1201.recruitmentApp.util.UserAlreadyExistException;

@ControllerAdvice
public class ErrorController {

    @ExceptionHandler(UserAlreadyExistException.class)
    public String handleUAEException(UserAlreadyExistException e, Model model) {
        model.addAttribute("errorMsg", e.getMessage());
        model.addAttribute("fieldName", e.getFieldName());
        model.addAttribute("person", new Person());
        System.out.println("I was run!, here is the error:" + model.getAttribute("errorMsg"));
        return "register";
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleBCException(Exception e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
    }

}
