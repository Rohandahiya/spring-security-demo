package com.example.springsecurity.springsecuritydemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @GetMapping("/admin")
    public Admin getAdmin(){
        return Admin.builder().name("NoONe").age(23).country("India").id(1).build();
    }
}
