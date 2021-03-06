package com.sample.commons;

import java.util.List;

public class UserInfo {


	@Override
	public String toString() {
		return "UserInfo [userID=" + userID + ", name=" + name + ", phoneNumber=" + phoneNumber + ", email=" + email
				+ ", acces=" + acces + ", managerEmail=" + managerEmail + ", asignedProjects=" + asignedProjects
				+ ", status=" + status + "]";
	}

	int userID;
	String name;
	String phoneNumber;
	String email;
	int acces;
	String managerEmail;
	List<String> asignedProjects;
	String status = "OK";
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
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
	public int getAcces() {
		return acces;
	}
	public void setAcces(int acces) {
		this.acces = acces;
	}
	public String getManagerEmail() {
		return managerEmail;
	}
	public void setManagerEmail(String managerEmail) {
		this.managerEmail = managerEmail;
	}
	public List<String> getAsignedProjects() {
		return asignedProjects;
	}
	public void setAsignedProjects(List<String> asignedProjects) {
		this.asignedProjects = asignedProjects;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}


	
}
