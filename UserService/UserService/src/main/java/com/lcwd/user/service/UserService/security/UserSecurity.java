package com.lcwd.user.service.UserService.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;



@EnableWebSecurity
@Configuration
public class UserSecurity extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/ratings/**", "/foods/**", "/hotels/**", "/orders/**").permitAll()
				.anyRequest().authenticated().and().httpBasic();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.inMemoryAuthentication().withUser("Akanksha").password(this.passwordEncoder().encode("newpassword"))
				.roles("ADMIN");
		auth.inMemoryAuthentication().withUser("Jayraj").password(this.passwordEncoder().encode("newpassword"))
				.roles("ADMIN");

	}

	/*
	 * protected void configure(AuthenticationManagerBuilder auth) throws Exception
	 * {
	 * 
	 * auth.inMemoryAuthentication().withUser("Akanksha").password("newpassword").
	 * roles("ADMIN");
	 * auth.inMemoryAuthentication().withUser("Jayraj").password("newpassword").
	 * roles("ADMIN");
	 * 
	 * }
	 */

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(10);
	}

}

