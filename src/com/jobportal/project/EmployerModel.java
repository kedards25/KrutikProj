package com.jobportal.project;

public class EmployerModel 
{
	String employer_id;
	String fname;
	String lname;
	String age;
	String email;
	String password;
	String confirmpassword;
	String contactno;
	String comapny_name;
	String usertype;
	
	public String getEmployer_id() {
		return employer_id;
	}
	public void setEmployer_id(String employer_id) {
		this.employer_id = employer_id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
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
	public String getConfirmpassword() {
		return confirmpassword;
	}
	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}
	public String getContactno() {
		return contactno;
	}
	public void setContactno(String contactno) {
		this.contactno = contactno;
	}
	public String getComapny_name() {
		return comapny_name;
	}
	public void setComapny_name(String comapny_name) {
		this.comapny_name = comapny_name;
	}
	
	
	
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	@Override
	public String toString() {
		return "EmployerModel [employer_id=" + employer_id + ", fname=" + fname + ", lname=" + lname + ", age=" + age
				+ ", email=" + email + ", password=" + password + ", confirmpassword=" + confirmpassword
				+ ", contactno=" + contactno + ", comapny_name=" + comapny_name + ",usertype=" + usertype + "]";
	}

	
	
	
}
