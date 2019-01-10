package com.twilio.auth.authenticationservice.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import com.twilio.auth.authenticationservice.model.JwtAuthenticationToken;

public class JwtAuthenticationTokenFilter extends AbstractAuthenticationProcessingFilter{

	
	
	public JwtAuthenticationTokenFilter() {
		super("/rest/**");
		// TODO Auto-generated constructor stub
	}

	public Authentication attemptAuthentication(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) {
		
		String header = httpServletRequest.getHeader("Authorisation");
		
		if(header==null || !header.startsWith("Token ")) {
			throw new RuntimeException("JWT Token is missing");
		}	
		
		String authenticationToken = header.substring(6);
		
		JwtAuthenticationToken  token = new JwtAuthenticationToken(authenticationToken);
		
		return getAuthenticationManager().authenticate(token);
		
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		// TODO Auto-generated method stub
		super.successfulAuthentication(request, response, chain, authResult);
		chain.doFilter(request, response);
	
	}

	

}
