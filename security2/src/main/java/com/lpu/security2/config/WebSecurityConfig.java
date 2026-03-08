package com.lpu.security2.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@EnableMethodSecurity
@Configuration
@EnableWebSecurity

public class WebSecurityConfig {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		
		http.cors(c->{});
		
		http.csrf((c)->c.disable());   // To use CSRF we have to disable it first
		//http.sessionManagement((s)->s.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		http.authorizeHttpRequests((req)->
		
		req.requestMatchers("/customer/register","/customer/public","/error").permitAll()
		.requestMatchers("/customer/delete").hasRole("ADMIN")
		.requestMatchers("/customer/update").hasAnyRole("ADMIN","USER")
		
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
	
	@Bean
    public CorsConfigurationSource corsConfigurationSource() {

        CorsConfiguration config = new CorsConfiguration();

        // CHANGED THIS LINE ONLY
        config.setAllowedOrigins(List.of("http://localhost:5173"));

        config.setAllowedMethods(List.of("GET","POST","PUT","DELETE"));
        config.setAllowedHeaders(List.of("*"));

        UrlBasedCorsConfigurationSource source =
                new UrlBasedCorsConfigurationSource();

        source.registerCorsConfiguration("/**", config);

        return source;
    }

}

/*
 * Session  like never, stateless, if_required, Always
 * never-> created only one session
 * Stateless -> it will not created any session
 * Always -> It will always created a session
 * If_required -> it will created     session only when required
 */