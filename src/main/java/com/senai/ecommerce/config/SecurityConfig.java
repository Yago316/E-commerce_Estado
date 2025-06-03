package com.senai.ecommerce.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import jakarta.servlet.Filter;
@Configuration
public class SecurityConfig {
	
	@Autowired
	Filter securityFilter;
	
	@Bean	//Para encriptar a senha usamos esse método que retorna a senha encriptada.	
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
		}
//	  @Bean //Ele permite que todos façam login, ou seja sem depender do token
//	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
//	    	http.csrf(csrf -> csrf.disable());
//	    	http.authorizeHttpRequests(auth -> auth.anyRequest().permitAll());
//	    	return http.build();
//	    }
	
	  @Bean //Ele permite que todos façam login, ou seja sem depender do token
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		  
		  return http
		  		.csrf(csrf -> csrf.disable()) // aqui agente esta desabilitando a proteção csrf
		  		.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
		  		.authorizeHttpRequests(authorize -> authorize
		  				.requestMatchers(HttpMethod.POST, "/usuario/login").permitAll() // Aqui da permição para as Rotas
		  				.requestMatchers(HttpMethod.POST, "/usuario/salvar").permitAll()
		  				.requestMatchers(HttpMethod.POST, "/usuario/criar").hasRole("ADMIN")
		  				.requestMatchers(HttpMethod.DELETE, "/usuario/{id}").hasRole("ADMIN")
		  				.anyRequest().authenticated()
		  		)
		  		.addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
		  		.build(); // o build e pra dizer que acabou aeeeeeeeeee!
	  }
}
