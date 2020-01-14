package com.sample.commons;

import java.util.List;

public class ProjectInfo {
    
	int projectID;
	String projectName;
	String managerName;
	String userName;
	String  userEmail;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	List<String>employeeNames;
	String status = "";
	
	public String getStatus() {
		return status;
	}
	public int getProjectID() {
		return projectID;
	}
	public void setProjectID(int projectID) {
		this.projectID = projectID;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public List<String> getEmployeeNames() {
		return employeeNames;
	}
	public void setEmployeeNames(List<String> employeeNames) {
		this.employeeNames = employeeNames;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
