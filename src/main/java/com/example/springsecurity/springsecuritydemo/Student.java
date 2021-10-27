package com.example.springsecurity.springsecuritydemo;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private int id;
    private String name;
    private int age;
    private String country;
}
