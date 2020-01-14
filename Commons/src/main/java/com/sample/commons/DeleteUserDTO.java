package com.sample.commons;

public class DeleteUserDTO {
	
	@Override
	public String toString() {
		return "DeleteUserDTO [name=" + name + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	String name;
}
