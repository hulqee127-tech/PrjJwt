package com.green.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	// 인가작업
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http
		// session 방식 활성화
			.csrf(auth -> auth.disable());	
		
		http
		// form login 기능 비활성화
			.formLogin((auth)->auth.disable())
			.httpBasic((auth)->auth.disable())
			.authorizeRequests((auth)-> auth
					.requestMatchers("/login","/","/join").permitAll()
					.requestMatchers("/admin").hasRole("ADMIN")
					.anyRequest().authenticated()
					)
			.sessionManagement( (session) -> session
					.sessionCreationPolicy(SessionCreationPolicy.STATELESS) 
					);
		
		return http.build();
	}
	
	// 암호화에 필요한 클래스
	@Bean
	 public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	 }

}
