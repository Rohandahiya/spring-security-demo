package com.example.springsecurity.springsecuritydemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class SpringSecurityDemoApplication implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;

//	@Autowired
//	PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user1 = User.builder()
					.username("Rohan")
					.password("dahiyarohan784")
				//	.password(passwordEncoder.encode("dahiyarohan784")) For Bcrypting the password
					.authorities("student")
					 .build();

		User user2 = User.builder()
				.username("James Harden")
				.password("hardenJames")
				.authorities("student:admin")
				.build();

		userRepository.saveAll(Arrays.asList(user1,user2));
	}
}
