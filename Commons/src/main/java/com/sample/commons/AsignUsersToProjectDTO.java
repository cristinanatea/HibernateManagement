package com.sample.commons;

public class AsignUsersToProjectDTO {

	
	@Override
	public String toString() {
		return "AsignUsersToProjectDTO [email=" + email + ", projectName=" + projectName + "]";
	}
	String email;
	String projectName;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
		
}


