package crud.management.commons;

import java.io.Serializable;


public class ManagerDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	 private int managerID;
	 private String name;
	 private String  employmentDate ;
	public int getManagerID() {
		return managerID;
	}
	public void setManagerID(int managerID) {
		this.managerID = managerID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmploymentDate() {
		return employmentDate;
	}
	public void setEmploymentDate(String employmentDate) {
		this.employmentDate = employmentDate;
	}
	@Override
	public String toString() {
		return "ManagerDTO [managerID=" + managerID + ", name=" + name + ", employmentDate=" + employmentDate + "]";
	}
	 	
	
}
