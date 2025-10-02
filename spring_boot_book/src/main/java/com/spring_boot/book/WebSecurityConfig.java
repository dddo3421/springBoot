package com.spring_boot.book;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {		
		return new BCryptPasswordEncoder(); //BCrypt라는 해시 알고리즘을 이용해서 비밀번호 암호화하는 구현체
	}
	
	//스프링 기본 인증 작업끄기 
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
			http
				.csrf(csrf->csrf.disable()) //csrf 토큰 없이도 로그인 가능
				.formLogin(formLogin->formLogin.disable()) //스프링시큐리티 제공 기본 로그인 사용종료
				.headers(headerConfig-> //iframe페이지는 허가하지 않음(X-Frame-Options 응답헤더 : DENY로 설정)
							headerConfig.frameOptions(frameOptionsConfig-> 
														frameOptionsConfig.disable())); 
		return http.build();
	}
}
