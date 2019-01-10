package com.twilio.auth.authenticationservice.model;

public class JwtUser {

	private long id;
	private String userName;
	private String role;

	public void setUserName(String userName) {
		this.userName =userName;
	}

	public void setId(long id) {
		// TODO Auto-generated method stub
		this.id=id;
	}

	public void setRole(String string) {
		// TODO Auto-generated method stub
		this.role=role;
	}

	public long  getId() {
		// TODO Auto-generated method stub
		return id;
	}

	public String getUserName() {
		// TODO Auto-generated method stub
		return userName;
	}

	public String getRole() {
		// TODO Auto-generated method stub
		return role;
	}
}
