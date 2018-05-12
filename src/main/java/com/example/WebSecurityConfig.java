package com.example;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	DataSource dataSource;

	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		http
		.csrf().disable()
		.httpBasic()
		.and()
		 .authorizeRequests()
		 .antMatchers("/resource/**","/api/ruang/view/**").permitAll()
		 .antMatchers("/peminjaman/*/konfirmasi", "/peminjaman/viewall").hasRole("STAF")
		 .antMatchers("/peminjaman/riwayat", "/peminjaman/tambah").hasRole("MAHASISWA")
		 .antMatchers("/ruang/viewall").hasAnyRole("STAF","MAHASISWA")
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
	
	/*@Autowired
	public void configureGlobal (AuthenticationManagerBuilder auth) throws Exception
	{
		BCryptPasswordEncoder encoder = passwordEncoder();
		 auth.inMemoryAuthentication()
		 .withUser("admin").password(encoder.encode("admin"))
		 .roles("ADMIN");
		 auth.inMemoryAuthentication()
		 .withUser("user").password(encoder.encode("user"))
		 .roles("USER");
	}*/
	
	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws
	Exception
	{
		 auth.jdbcAuthentication().dataSource(dataSource)
		 .passwordEncoder(passwordEncoder())
		.usersByUsernameQuery("select username,password,1 from user_account where username=?")
		.authoritiesByUsernameQuery("select username, role from user_account where username=?");
	}

	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring()
				.antMatchers("/build/**")
				.antMatchers("/css/**")
				.antMatchers("/images/**")
				.antMatchers("/js/**")
				.antMatchers("/vendors/**");
	}
	

}
