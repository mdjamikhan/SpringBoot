package com.lpu.demo_Security1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class webSecurityConfig {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) {
		
//		http.authorizeHttpRequests((req)->
//		
//		req.requestMatchers("/reg").permitAll().anyRequest().authenticated());
////		req.anyRequest().authenticated());
//		
////		req.anyRequest().denyAll());  //It will deny all the request
//		
//		//req.anyRequest().permitAll());
//		
//		http.formLogin(Customizer.withDefaults()); // This is for webPage
//		
//		http.httpBasic(Customizer.withDefaults()); // for PostMan Login 
//		
//		return http.build();
		
		
		
		http.authorizeHttpRequests((req)->
		req.requestMatchers("/reg").permitAll().anyRequest().authenticated()
		);
		http.formLogin(Customizer.withDefaults());
		
		return http.build();
	}
	
	
	@Bean
	
	public UserDetailsService detailsService() {
	    
	    UserDetails user1 = User.withUsername("khan")
	            .password("{noop}12345")
	            .roles("User")
	            .build();

	    UserDetails user2 = User.withUsername("zahir")
	            .password("{noop}123")
	            .roles("User")
	            .build();

	    return new InMemoryUserDetailsManager(user1, user2);
	}

}
