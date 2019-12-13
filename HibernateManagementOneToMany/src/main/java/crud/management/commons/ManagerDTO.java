package crud.management.commons;

import java.io.Serializable;

import crud.management.persistence.model.Manager;

public class ManagerDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	 private int managerID;
	 private String nume;
	 private String dataAngajarii;
	 
	 public ManagerDTO() {
			super();
		}
		
		public ManagerDTO (Manager manager) {
			this.managerID = manager.getManagerID();
			this.nume = manager.getNume();
			this.dataAngajarii = manager.getDataAngajarii();
		}
		
		public ManagerDTO(int managerID, String nume, String dataAngajarii) {
			// TODO Auto-generated constructor stub
			this.managerID = managerID;
			this.nume = nume;
			this.dataAngajarii = dataAngajarii;
		}
	 
	 
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
