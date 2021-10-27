package com.example.springsecurity.springsecuritydemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class UserConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserService userService;

    // For Authentication
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);

    }

    // For Authorization
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin/**").hasAuthority("admin")
                .antMatchers("/student/**").hasAnyAuthority("admin","student")
                .antMatchers("/**").permitAll()
                .and()
                .formLogin();
    }

    //We need to have password encoder here
    @Bean
    PasswordEncoder getEncoder(){
        return NoOpPasswordEncoder.getInstance();

    }

//    @Bean
//    PasswordEncoder encode(){
//        return new BCryptPasswordEncoder();
//    }
}
