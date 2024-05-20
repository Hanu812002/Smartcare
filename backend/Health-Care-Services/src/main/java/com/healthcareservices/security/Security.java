package com.healthcareservices.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class Security {

	@Bean
	public InMemoryUserDetailsManager userDetailsManager() {
		
		UserDetails john = User.builder()
				.username("john")
				//here noop means no operation. In this the password is saved as plain text.
				.password("{noop}test123")
				.roles("PATIENT", "DOCTOR")
				.build();
		
		UserDetails mary = User.builder()
				.username("mary")
				.password("{noop}test123")
				.roles("PATIENT", "DOCTOR")
				.build();
		
		UserDetails susan = User.builder()
				.username("susan")
				.password("{noop}test123")
				.roles("PATIENT", "DOCTOR")
				.build();
		
		return new InMemoryUserDetailsManager(john, mary, susan);
	}
	
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http)throws Exception {
		
		http.authorizeHttpRequests(configurer->
				configurer
						.requestMatchers(HttpMethod.GET, "/hospitals").hasRole("PATIENT")
						.requestMatchers(HttpMethod.GET, "/hospitals/**").hasRole("PATIENT")
						.requestMatchers(HttpMethod.POST, "/hospitals").hasRole("DOCTOR")
						.requestMatchers(HttpMethod.PUT, "/hospitals").hasRole("DOCTOR")
						.requestMatchers(HttpMethod.DELETE, "/hospitals/**").hasRole("DOCTOR")
						
						.requestMatchers(HttpMethod.GET, "/patients").hasRole("PATIENT")
						.requestMatchers(HttpMethod.GET, "/patients/**").hasRole("PATIENT")
						.requestMatchers(HttpMethod.POST, "/patients").hasRole("DOCTOR")
						.requestMatchers(HttpMethod.PUT, "/patients").hasRole("DOCTOR")
						.requestMatchers(HttpMethod.DELETE, "/patients/**").hasRole("DOCTOR")
						
						.requestMatchers(HttpMethod.GET, "/doctors").hasRole("PATIENT")
						.requestMatchers(HttpMethod.GET, "/doctors/**").hasRole("PATIENT")
						.requestMatchers(HttpMethod.POST, "/doctors").hasRole("DOCTOR")
						.requestMatchers(HttpMethod.PUT, "/doctors").hasRole("DOCTOR")
						.requestMatchers(HttpMethod.DELETE, "/doctors/**").hasRole("DOCTOR")
						
						
						.requestMatchers(HttpMethod.GET, "/documents").hasRole("PATIENT")
						.requestMatchers(HttpMethod.GET, "/documents/**").hasRole("PATIENT")
						.requestMatchers(HttpMethod.POST, "/documents").hasRole("DOCTOR")
						.requestMatchers(HttpMethod.PUT, "/documents").hasRole("DOCTOR")
						.requestMatchers(HttpMethod.DELETE, "/documents/**").hasRole("DOCTOR")
						
						
						.requestMatchers(HttpMethod.GET, "/medicals").hasRole("PATIENT")
						.requestMatchers(HttpMethod.GET, "/medicals/**").hasRole("PATIENT")
						.requestMatchers(HttpMethod.POST, "/medicals").hasRole("DOCTOR")
						.requestMatchers(HttpMethod.PUT, "/medicals").hasRole("DOCTOR")
						.requestMatchers(HttpMethod.DELETE, "/medicals/**").hasRole("DOCTOR")
				
				);
		// use HTTP basic Authentication.
		http.httpBasic(Customizer.withDefaults());
		
		//Disable Cross Site Request Forgery (CSRF)
		//in general, not required for stateless REST APIs that use POST, PUT, DELETE and/or PATCH.
		http.csrf(csrf-> csrf.disable());
		
		return http.build();
	}
}
