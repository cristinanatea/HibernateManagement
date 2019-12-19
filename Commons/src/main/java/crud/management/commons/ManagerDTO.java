package crud.management.commons;

import java.io.Serializable;


public class ManagerDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	 private int managerID;
	 private String nume;
	 private String dataAngajarii;
	 
	
	public int getManagerID() {
		return managerID;
	}
	public void setManagerID(int managerID) {
		this.managerID = managerID;
	}
	public String getNume() {
		return nume;
	}
	public void setNume(String nume) {
		this.nume = nume;
	}
	public String getDataAngajarii() {
		return dataAngajarii;
	}
	public void setDataAngajarii(String dataAngajarii) {
		this.dataAngajarii = dataAngajarii;
	}
	@Override
	public String toString() {
		return "ManagerDTO [managerID=" + managerID + ", nume=" + nume + ", dataAngajarii=" + dataAngajarii + "]";
	}
	
	
	
}
