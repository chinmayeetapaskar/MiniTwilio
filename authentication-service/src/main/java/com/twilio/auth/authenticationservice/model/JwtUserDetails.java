package com.twilio.auth.authenticationservice.model;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class JwtUserDetails implements UserDetails {

	private String userName;
	private String token;
	private Long id;
	private Collection<? extends GrantedAuthority> authorities;



	public JwtUserDetails(String userName, long id, String token, List<GrantedAuthority> grantedAuthorities) {
	// TODO Auto-generated constructor stub

		this.userName=userName;
		this.id=id;
		this.token=token;
		this.authorities=grantedAuthorities;
}



	public String getUserName() {
		return userName;
	}



	public String getToken() {
		return token;
	}





	public Long getId() {
		return id;
	}






	
	

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}



	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

}
