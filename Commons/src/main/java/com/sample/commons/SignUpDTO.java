package com.sample.commons;

public class SignUpDTO {

	@Override
	public String toString() {
		return "SignUpDTO [name=" + name + ", phoneNumber=" + phoneNumber + ", email=" + email + ", password="
				+ password + "]";
	}

	String name;
	String phoneNumber;
	String email;
	String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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

}
