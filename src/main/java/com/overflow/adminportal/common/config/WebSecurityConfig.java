package com.overflow.adminportal.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
        .withUser("user").password(passwordEncoder().encode("123456")).roles("USER")
        .and()
        .withUser("user2").password(passwordEncoder().encode("123456")).roles("USER")
        .and()
        .withUser("admin").password(passwordEncoder().encode("123456")).roles("ADMIN");
    }
 
    @Override
    protected void configure(final HttpSecurity http) throws Exception {
    	
    	http.authorizeRequests().mvcMatchers("/static/**").permitAll();
        http.authorizeRequests().mvcMatchers("/login").permitAll();
        
    	http
    	.csrf().disable()
    	.authorizeRequests().anyRequest().authenticated()
    	.and()
    	.formLogin() //.successForwardUrl("/")
				.loginPage("/login")
    	.and()
        .logout().invalidateHttpSession(true).deleteCookies("JSESSIONID");
    }
    
    @Bean
	public PasswordEncoder passwordEncoder() { 
	    return new BCryptPasswordEncoder(); 
	}

}
