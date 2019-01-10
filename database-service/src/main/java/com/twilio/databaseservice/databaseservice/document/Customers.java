package com.twilio.databaseservice.databaseservice.document;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Customers {


	@Id
	private String authToken;
	private String userName;
	private String emaiId;
	private String password;
	private List<String> clientEmailIds;
	
	
	public Customers() {
		
	}
	public Customers(String authToken, String userName, String emaiId, String password, List<String> clientEmailIds) {
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
