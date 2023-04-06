package com.kth.iv1201.recruitmentApp.presentation;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.kth.iv1201.recruitmentApp.domain.Person;
import com.kth.iv1201.recruitmentApp.util.UserAlreadyExistException;

/**
 * Contains all exception handler methods. 
 */
@ControllerAdvice
public class ErrorController {

    /**
     * Handles a UserAlreadyExistException by returning the view register with an error mesage attached to its model. 
     * @param e The error instance.
     * @param model The model instance.
     * @return The name of the view. 
     */
    @ExceptionHandler(UserAlreadyExistException.class)
    public String handleUAEException(UserAlreadyExistException e, Model model) {
        model.addAttribute("errorMsg", e.getMessage());
        model.addAttribute("fieldName", e.getFieldName());
        model.addAttribute("person", new Person());
        return "register";
    }

    /**
     * A generic error handler method that will display a generic error view. 
     * @param e An error instance.
     * @return The name of the view. 
     */
    @ExceptionHandler(Exception.class)
    public String handleBCException(Exception e) {
        return "error";
    }

}
