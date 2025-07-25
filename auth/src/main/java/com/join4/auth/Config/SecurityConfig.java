package com.join4.auth.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable()  
            .cors().disable()  
            .authorizeRequests()
                .requestMatchers("/auth/register").permitAll()  
                .requestMatchers("/auth/login").permitAll()     
                .anyRequest().authenticated()
            .and()
            .formLogin()
                .loginPage("/login")  
                .permitAll()          
            .and()
            .httpBasic().disable();  
            

        return http.build();
    }
}
