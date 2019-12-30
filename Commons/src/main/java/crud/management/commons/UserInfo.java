package crud.management.commons;

import java.util.List;

public class UserInfo {
	int userID;
	String name;
	String phoneNumber;
	String email;
	List<String> asignedProjects;
	String status = "OK";


	public String getStatus() {
		return status;
	}

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

	public List<String> getAsignedProjects() {
		return asignedProjects;
	}

	public void setAsignedProjects(List<String> asignedProjects) {
		this.asignedProjects = asignedProjects;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
}
