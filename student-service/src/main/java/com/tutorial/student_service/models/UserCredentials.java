package com.tutorial.student_service.models;

public class UserCredentials {

	String userName;
	String password;
	String token;
	
	public UserCredentials() {
	}
	
	public String getUserName() {
		return userName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getToken() {
		return token;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
}
