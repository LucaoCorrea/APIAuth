package com.join4.auth.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    // Configuração para as permissões de acesso às rotas
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable()  // Desabilita CSRF (se necessário)
            .cors().disable()  // Desabilita CORS
            .authorizeRequests()
                .requestMatchers("/auth/register").permitAll()  // Permite o acesso sem autenticação à rota de registro
                .requestMatchers("/auth/login").permitAll()     // Permite o acesso sem autenticação à rota de login (se for o caso)
                .anyRequest().authenticated() // Exige autenticação para todas as outras rotas
            .and()
            .formLogin()
                .loginPage("/login")  // Se quiser definir uma página personalizada de login, defina aqui
                .permitAll()           // Permite que todos acessem a página de login
            .and()
            .httpBasic().disable();  // Desabilita autenticação básica (caso você não queira usar)
            

        return http.build();
    }
}
