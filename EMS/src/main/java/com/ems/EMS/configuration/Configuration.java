package com.ems.EMS.configuration;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
public class Configuration extends WebSecurityConfigurerAdapter {
	
	 @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http
	        .csrf()
	        . disable()
	        .authorizeRequests()
	                .antMatchers(
	                		 "/v2/api-docs", 
	                         "/swagger-resources/**",  
	                         "/swagger-ui.html", 
	                         "/webjars/**"
	                		).permitAll()
	                .anyRequest().authenticated()
	                .and()
	                .httpBasic() ;
	                
	                
	    }

	 
	    @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.inMemoryAuthentication()
	                .withUser("admin")
	                .password(passwordEncoder().encode("admin123"))
	                .authorities("ADMIN");
	        		
	    }

	    
	    @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	

}
