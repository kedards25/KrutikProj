package com.jobportal.project;

public class Model {
	int seekerid;
	String fname;
	String lname;
	String age;
	String email;
	String password;
	String confirmpassword;
	String usertype;

	int psid;
	String address;
	String city;
	String zip;
	String qualification;
	String extra_certificate;
	String expierence;
	String earlier_comapny;
	float tenth_marks;
	float twelve_marks;
	String hobbies;
	String blood_group;
	int contact_number;

	public Model() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public Model(int seekerid, String fname, String lname, String age, String email, String password,
			String confirmpassword, String usertype, int psid, String address, String city, String zip,
			String qualification, String extra_certificate, String expierence, String earlier_comapny,
			float tenth_marks, float twelve_marks, String hobbies, String blood_group, int contact_number) {
		super();
		this.seekerid = seekerid;
		this.fname = fname;
		this.lname = lname;
		this.age = age;
		this.email = email;
		this.password = password;
		this.confirmpassword = confirmpassword;
		this.usertype = usertype;
		this.psid = psid;
		this.address = address;
		this.city = city;
		this.zip = zip;
		this.qualification = qualification;
		this.extra_certificate = extra_certificate;
		this.expierence = expierence;
		this.earlier_comapny = earlier_comapny;
		this.tenth_marks = tenth_marks;
		this.twelve_marks = twelve_marks;
		this.hobbies = hobbies;
		this.blood_group = blood_group;
		this.contact_number = contact_number;
	}



	public int getSeekerid() {
		return seekerid;
	}

	public void setSeekerid(int seekerid) {
		this.seekerid = seekerid;
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

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public int getPsid() {
		return psid;
	}

	public void setPsid(int psid) {
		this.psid = psid;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getExtra_certificate() {
		return extra_certificate;
	}

	public void setExtra_certificate(String extra_certificate) {
		this.extra_certificate = extra_certificate;
	}

	public String getExpierence() {
		return expierence;
	}

	public void setExpierence(String expierence) {
		this.expierence = expierence;
	}

	public String getEarlier_comapny() {
		return earlier_comapny;
	}

	public void setEarlier_comapny(String earlier_comapny) {
		this.earlier_comapny = earlier_comapny;
	}

	public String getBlood_group() {
		return blood_group;
	}

	public void setBlood_group(String blood_group) {
		this.blood_group = blood_group;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getHobbies() {
		return hobbies;
	}

	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getContact_number() {
		return contact_number;
	}

	public void setContact_number(int contact_number) {
		this.contact_number = contact_number;
	}

	public float getTenth_marks() {
		return tenth_marks;
	}

	public void setTenth_marks(float tenth_marks) {
		this.tenth_marks = tenth_marks;
	}

	public float getTwelve_marks() {
		return twelve_marks;
	}

	public void setTwelve_marks(float twelve_marks) {
		this.twelve_marks = twelve_marks;
	}

	/*
	 * public String toString() {
	 * 
	 * }
	 */
}
