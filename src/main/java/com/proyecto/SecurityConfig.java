package com.proyecto;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.proyecto.security.Security;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig{
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		http.csrf().disable().authorizeHttpRequests().
		requestMatchers("/ingresar/**","/static/**","/resources/img/**","/resources/css/**").permitAll().
		and().authorizeHttpRequests().
		requestMatchers("/usuario/**","/cliente/**","/bus/**","/pasaje/**","/ubigeo/**","/ruta/**","/itinerario/**").authenticated().
		and().formLogin().loginPage("/ingresar/login").
		defaultSuccessUrl("/ingresar/index");

		return http.build();
	}
	
	
	//Autentificador del usuario
	@Bean
	public UserDetailsService userDetailsService() {
		return new Security();
	}
	
	//@Bean es para que se coloque en el contenedor del spring boot
	@Bean
	public AuthenticationProvider authenticationProvider() {
		
		DaoAuthenticationProvider dao = new DaoAuthenticationProvider();
		dao.setUserDetailsService(userDetailsService());
		dao.setPasswordEncoder(password());
		
		return dao;
		
	}
	
	@Bean
	public BCryptPasswordEncoder password () {
		return new BCryptPasswordEncoder();
	}
}
