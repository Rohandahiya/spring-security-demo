package com.example.springsecurity.springsecuritydemo;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @GetMapping("/student")
    public Student getUser(){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return Student.builder().age(23).name("Rohan").country("India").id(1).build();
    }

}
