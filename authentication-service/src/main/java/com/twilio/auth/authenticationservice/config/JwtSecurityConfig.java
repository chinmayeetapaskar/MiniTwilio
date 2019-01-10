package com.twilio.auth.authenticationservice.config;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.twilio.auth.authenticationservice.security.JwtAuthenticationEntryPoint;
import com.twilio.auth.authenticationservice.security.JwtAuthenticationProvider;
import com.twilio.auth.authenticationservice.security.JwtAuthenticationTokenFilter;
import com.twilio.auth.authenticationservice.security.JwtSuccessHandler;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
@Configuration
public class JwtSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private JwtAuthenticationProvider authenticationProvider;
	@Autowired
	private JwtAuthenticationEntryPoint entryPoint;

	//Injected provider manager in authentication manager
	
	@Bean
	public AuthenticationManager authenticationManager() {
		return new ProviderManager(Collections.singletonList(authenticationProvider));
	}
	
	
	//to check with authentication token has been provided
	@Bean
	public JwtAuthenticationTokenFilter  authenticationTokenFilter( ) {
	
		JwtAuthenticationTokenFilter filter = new JwtAuthenticationTokenFilter( );
		filter.setAuthenticationManager(authenticationManager());
		filter.setAuthenticationSuccessHandler(new JwtSuccessHandler());
		return filter;
	}
	
	
	//If exception redirect it to authentication entry point
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.csrf().disable().
		authorizeRequests().antMatchers("**/rest/").
		authenticated().and()
		.exceptionHandling()
		.authenticationEntryPoint(entryPoint)
		.and()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		http.addFilterBefore(authenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
		http.headers().cacheControl();
	}
}
