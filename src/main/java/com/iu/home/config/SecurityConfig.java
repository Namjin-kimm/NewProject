package com.iu.home.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	WebSecurityCustomizer webSecurityConfig() {
		return web -> web
				.ignoring()
				.antMatchers("/images/**")
				.antMatchers("/css/**")
				.antMatchers("/js/**")
				.antMatchers("/favicon/**")
				.antMatchers("resources/**");
				
	}
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity httpSecurity)throws Exception{
		httpSecurity
			.cors()
			.and()
			.csrf()
			.disable()
		.authorizeRequests()
			.antMatchers("/admin").hasRole("ADMIN")
			.antMatchers("/manager").hasAnyRole("MANAGER")
			.antMatchers("/board/list").permitAll()
			.antMatchers("/board/**").hasRole("MEMBER")
			.anyRequest().permitAll()
			.and()
		.formLogin()
			.loginPage("/member/login")
			.passwordParameter("pw")
			.usernameParameter("id")
//			.defaultSuccessUrl("/")
			.successHandler(null)
			.failureUrl("/member/login")
			.permitAll()
			.and()
		.logout()
			.logoutUrl("/member/logout")
			.logoutSuccessUrl("/")
			.invalidateHttpSession(true)
			.deleteCookies("JESSIONID")
			.permitAll();
		return httpSecurity.build();
			
	}
	
	//평문(Clear Text)을 암호화 시켜주는 객체 생성
		@Bean
		PasswordEncoder getEncoder() {
			return new BCryptPasswordEncoder();
		}

}
