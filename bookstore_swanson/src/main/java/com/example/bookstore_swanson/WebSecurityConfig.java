package com.example.bookstore_swanson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.bookstore_swanson.web.UserDetailServiceImpl;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	@Autowired
	private UserDetailServiceImpl userDetailsService;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}
	
	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception{
		http
			.authorizeHttpRequests(authorize -> authorize.anyRequest().authenticated()) 
			.headers(headers -> headers.frameOptions(frameOptions -> frameOptions.disable()))
			.formLogin(formLogin -> formLogin.loginPage("/login").defaultSuccessUrl("/booklist", true).permitAll()) 
			.logout(logout -> logout.logoutSuccessUrl("/login").permitAll());
		
		return http.build();
	}
}