package com.rks.student.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.rks.student.security.filter.JwtAuthenticationEntryPoint;
import com.rks.student.security.filter.JwtFilter;
import com.rks.student.security.service.UserService;
import com.rks.student.security.service.impl.UserInfoServiceImpl;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

	@Autowired
	private JwtFilter jwtFilter;

	@Bean
	UserDetailsService userDetailsService() {
		return new UserService();
	}

//	@Bean
//	SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//		return httpSecurity.csrf(csrf -> csrf.disable()).cors(cors -> cors.disable())
//				.authorizeHttpRequests(auth -> auth
//						.antMatchers("/auth/**", "/v2/api-docs", "/configuration/ui", "/swagger-resources/**",
//								"/configuration/security", "/swagger-ui.html", "/webjars/**")
//						.permitAll().anyRequest().authenticated())
//				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//				.authenticationProvider(auththenticationProvider())
//				.exceptionHandling(
//						exceptionHandleing -> exceptionHandleing.authenticationEntryPoint(jwtAuthenticationEntryPoint))
//				.addFilterBefore(this.jwtFilter, UsernamePasswordAuthenticationFilter.class).build();
//	}
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		return httpSecurity.csrf(csrf -> csrf.disable()).cors(cors -> cors.disable())
				.authorizeHttpRequests(auth -> auth.antMatchers("/auth/**", "/v3/api-docs/**", "/swagger-resources/**",
						"/swagger-ui/**", "/swagger-ui.html", "/webjars/**").permitAll().anyRequest().authenticated())
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.authenticationProvider(auththenticationProvider())
				.exceptionHandling(
						exceptionHandling -> exceptionHandling.authenticationEntryPoint(jwtAuthenticationEntryPoint))
				.addFilterBefore(this.jwtFilter, UsernamePasswordAuthenticationFilter.class).build();
	}

	@Bean
	AuthenticationProvider auththenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService());
		authenticationProvider.setPasswordEncoder(PasswordEncoder());
		return authenticationProvider;
	}

	@Bean
	PasswordEncoder PasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}

}
