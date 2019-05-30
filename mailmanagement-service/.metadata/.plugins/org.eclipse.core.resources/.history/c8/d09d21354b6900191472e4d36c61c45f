package com.twilio.MailManagement.mailmanagementservice.model;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;



public class Customers {

	@NotNull
	private String authToken;
	@NotNull
	private String userName;
	@NotNull
	@Email
	private String emaiId;
	@NotNull
	private String password;
	@NotNull
	@Min(8)
	private List<String> clientEmailIds;
	public Customers(String authToken, String userName, String emaiId, String password, List<String> clientEmailIds) {
		super();
		this.authToken = authToken;
		this.userName = userName;
		this.emaiId = emaiId;
		this.password = password;
		this.clientEmailIds = clientEmailIds;
	}
	public String getAuthToken() {
		return authToken;
	}
	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmaiId() {
		return emaiId;
	}
	public void setEmaiId(String emaiId) {
		this.emaiId = emaiId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<String> getClientEmailIds() {
		return clientEmailIds;
	}
	public void setClientEmailIds(List<String> clientEmailIds) {
		this.clientEmailIds = clientEmailIds;
	}
	
	
}
