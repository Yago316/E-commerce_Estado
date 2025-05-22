package com.senai.ecommerce.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
public class SecurityConfig {
	@Bean	//Para encriptar a senha usamos esse método que retorna a senha encriptada.	
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
		}
	  @Bean //Ele permite que todos façam login, ou seja sem depender do token
	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
	    	http.csrf(csrf -> csrf.disable());
	    	http.authorizeHttpRequests(auth -> auth.anyRequest().permitAll());
	    	return http.build();
	    }

}
