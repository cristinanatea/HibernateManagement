package com.sample.commons;

public class CreateProjectDTO {
	@Override
	public String toString() {
		return "CreateProjectDTO [name=" + name + ", ManagerEmail=" + ManagerEmail + "]";
	}
	
	String name;
	String ManagerEmail;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getManagerEmail() {
		return ManagerEmail;
	}
	public void setManagerEmail(String managerEmail) {
		ManagerEmail = managerEmail;
	}
	
   
}
