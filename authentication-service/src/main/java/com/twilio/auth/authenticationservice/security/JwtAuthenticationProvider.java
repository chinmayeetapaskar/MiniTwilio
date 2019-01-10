package com.twilio.auth.authenticationservice.security;

import java.util.List;

import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.twilio.auth.authenticationservice.model.JwtAuthenticationToken;
import com.twilio.auth.authenticationservice.model.JwtUser;
import com.twilio.auth.authenticationservice.model.JwtUserDetails;


@Component
public class JwtAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

	@Autowired
	private JwtValidator validator;
	
	
	@Override
	public boolean supports(Class<?> aClass) {
		// TODO Auto-generated method stub
		return (JwtAuthenticationToken.class.isAssignableFrom(aClass));
	}

	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken)
			throws AuthenticationException {
		// TODO Auto-generated method stub
		JwtAuthenticationToken jwtAuthenticationtoken = (JwtAuthenticationToken) usernamePasswordAuthenticationToken;
		String token = jwtAuthenticationtoken.getToken();
		
		JwtUser jwtUser = validator.validate(token);
		
		if(jwtUser == null) {
			throw new RuntimeException("JWT Token is incorrect");
		}
		
		
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList(jwtUser.getRole());
		return new JwtUserDetails(jwtUser.getUserName(),jwtUser.getId(),token,grantedAuthorities);
		}

}
