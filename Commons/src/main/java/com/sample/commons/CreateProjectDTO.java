package com.sample.commons;

public class CreateProjectDTO {
	@Override
	public String toString() {
		return "CreateProjectDTO [name=" + name + ", ManagerEmail=" + managerEmail + "]";
	}
	
	String name;
	String managerEmail;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getManagerEmail() {
		return managerEmail;
	}
	public void setManagerEmail(String managerEmail) {
		this.managerEmail = managerEmail;
	}
	
   
}
