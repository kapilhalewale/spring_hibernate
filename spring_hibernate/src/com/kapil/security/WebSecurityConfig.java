package com.kapil.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.bind.annotation.SessionAttributes;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter
{

	@Autowired
    private AuthenticationHandler authenticationHandler;
	/*@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception
    {
		 auth.userDetailsService(userDetailsService);
	     auth.authenticationProvider(authenticationProvider());     
    }
     
    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
    	http.authorizeRequests()
    	.antMatchers("/", "/employee") .access("hasRole('USER') or hasRole('ADMIN')")
        .antMatchers("/user/**", "/add-user/***").access("hasRole('ADMIN')")
        .antMatchers("/drop-employee/*", "/drop-user/*") .access("hasRole('ADMIN").and().formLogin().loginPage("/login")
        .loginProcessingUrl("/login").usernameParameter("kapil").passwordParameter("admin");
    	
        http.logout().logoutUrl("/logout").invalidateHttpSession(true).logoutSuccessUrl("/login");

    }   */
    
	    @Autowired
	    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception 
	    {
	        auth.inMemoryAuthentication().withUser("kapil").password("123").roles("EMP");
	        auth.inMemoryAuthentication().withUser("admin").password("123").roles("ADMIN");
	    }

	    @Override
	    protected void configure(HttpSecurity http) throws Exception
	    {
	      http.authorizeRequests()
			.antMatchers("/").permitAll() 
			.antMatchers("/users/**").access("hasRole('ADMIN')")
			.antMatchers("/employee/**").access("hasRole('EMP')")
			.and().formLogin().loginPage("/login")
			.successHandler(authenticationHandler) 
			.usernameParameter("username")
			.passwordParameter("password")
	        .and().exceptionHandling().accessDeniedPage("/denied");     
	      
	      http.logout().logoutUrl("/logout").invalidateHttpSession(true).logoutSuccessUrl("/login");
	    }
}
