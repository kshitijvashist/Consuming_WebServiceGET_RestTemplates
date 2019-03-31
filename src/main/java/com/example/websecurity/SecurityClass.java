package com.example.websecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityClass extends WebSecurityConfigurerAdapter {

	@Autowired
	AuthenticationEntryPoint authEntryPoint;
	
	
	@Override
	public void configure(HttpSecurity httpSecurity) throws Exception
	{
		
		httpSecurity.cors().and().csrf().disable().authorizeRequests()
		
		.anyRequest().authenticated()
		.and().httpBasic()
		.authenticationEntryPoint(authEntryPoint);
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	
	auth.inMemoryAuthentication().withUser("root").password("root").roles("USER");
	}
}
