package com.sample.commons;

public class DeleteUserFromPjDTO {
	
	@Override
	public String toString() {
		return "DeleteUserDTO [name=" + name + " projectName=" + projectName + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	String name;
	String projectName;
}
