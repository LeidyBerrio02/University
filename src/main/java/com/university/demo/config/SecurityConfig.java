package com.university.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter{

	//need for css, images, etc
	String[] resources = new String[] {
			 "/include/**","/css/**","/icons/**","/images/**","/js/**","/layer/**"  
	};
	
	
	 @Autowired
	 private UserDetailsService userDetailsService;
	 
	 @Bean
	 public BCryptPasswordEncoder passwordEncoder() {
	    	return new BCryptPasswordEncoder();
	    }
	 
	 @Autowired
	 public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception { 
	    	build.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	    }
	 
	 @Override
	 protected void configure(HttpSecurity http) throws Exception {
		 http
		 	.authorizeRequests().antMatchers(resources).permitAll()
		 	.antMatchers("/login").permitAll()
		 	.antMatchers("/saving/", "/update/**", "/delete/**" ).hasAnyRole("ADMIN")
		 	.antMatchers("/User/**").hasAnyRole("USER").and()
		 	
		 	.formLogin()
		 	.loginPage("/login")
		 	.permitAll()
		 	.defaultSuccessUrl("/")
		 	.failureUrl("/login?error=true")
		 
		 
		 
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
}




