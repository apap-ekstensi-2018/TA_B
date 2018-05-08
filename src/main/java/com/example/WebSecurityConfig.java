package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	
	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		http
		.csrf().disable()
		.httpBasic()
		.and()
		 .authorizeRequests()
		 .antMatchers("/", "/css/*", "/js/*", "/images/*", "/vendors/*").permitAll()
		 .anyRequest().authenticated()
		 .and()
		 .formLogin()
		 .loginPage("/login")
		 .defaultSuccessUrl("/")
		 .permitAll()
		 .and()
		 .logout()
		 .permitAll();

	}
	
	@Autowired
	public void configureGlobal (AuthenticationManagerBuilder auth) throws Exception
	{
		BCryptPasswordEncoder encoder = passwordEncoder();
		 auth.inMemoryAuthentication()
		 .withUser("admin").password(encoder.encode("admin"))
		 .roles("ADMIN");
		 auth.inMemoryAuthentication()
		 .withUser("user").password(encoder.encode("user"))
		 .roles("USER");
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
