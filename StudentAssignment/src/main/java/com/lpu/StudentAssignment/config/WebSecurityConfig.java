package com.lpu.StudentAssignment.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableMethodSecurity
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

	    http.cors(c -> {});

 	    http.csrf(c -> c.disable());

	    http.authorizeHttpRequests(req ->

	        req.requestMatchers("/register", "/error","/image/**","/actuator/**").permitAll()
	        .requestMatchers("/all").hasRole("ADMIN")
	           .requestMatchers("/delete/**").hasRole("ADMIN")
	           .requestMatchers("/update/**").hasAnyRole("ADMIN", "USER")
 	           .requestMatchers("/**").authenticated()

	           .anyRequest().authenticated()
	    );

	    http.formLogin(Customizer.withDefaults());
	    http.httpBasic(Customizer.withDefaults());

	    return http.build();
	}
	
	@Bean
	public PasswordEncoder encoder() {
		
		return new BCryptPasswordEncoder();
		
	}

}
