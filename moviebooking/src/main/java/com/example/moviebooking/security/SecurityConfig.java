package com.example.moviebooking.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.SecurityFilterChain;

//@EnableWebSecurity
@Configuration
public class SecurityConfig {

//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//		http.csrf(csrf -> csrf.disable())
//				.authorizeHttpRequests(
//						auth -> auth.requestMatchers("/api/users/register", "/api/users/login").permitAll()
//								.anyRequest().authenticated() // Protect all other endpoints
//				).httpBasic(httpBasic -> httpBasic.disable()) // Disable HTTP Basic authentication (optional)
//				.formLogin(form -> form.disable()); // Disable default form-based authentication
//
//		return http.build();
//	}

//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}

//	@Bean
//	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
//		return config.getAuthenticationManager();
//	}

}
