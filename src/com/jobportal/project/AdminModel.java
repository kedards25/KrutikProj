package com.jobportal.project;

public class AdminModel 
{
	String email;
	String password;
	String usertype;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	public String toString()
	{
		return"AdminModel [email=" + email + ", password=" + password + ", usertype=" + usertype + "]";
	}
	
}
