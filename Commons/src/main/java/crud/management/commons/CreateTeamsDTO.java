package crud.management.commons;

public class CreateTeamsDTO {
	 private int angajatID;
	 private int functieID;
	 private int proiectID;
	 private int managerID;
	 private String numeManager;
	 private int coordonatorID;
	 private String numeAngajat;
     private String prenumeAngajat;
     private int teamID;
     private String teamName;
     
     
	public int getAngajatID() {
		return angajatID;
	}
	public void setAngajatID(int angajatID) {
		this.angajatID = angajatID;
	}
	public int getFunctieID() {
		return functieID;
	}
	public void setFunctieID(int functieID) {
		this.functieID = functieID;
	}
	public int getProiectID() {
		return proiectID;
	}
	public void setProiectID(int proiectID) {
		this.proiectID = proiectID;
	}
	public int getManagerID() {
		return managerID;
	}
	public void setManagerID(int managerID) {
		this.managerID = managerID;
	}
	public String getNumeManager() {
		return numeManager;
	}
	public void setNumeManager(String numeManager) {
		this.numeManager = numeManager;
	}
	public int getCoordonatorID() {
		return coordonatorID;
	}
	public void setCoordonatorID(int coordonatorID) {
		this.coordonatorID = coordonatorID;
	}
	public String getNumeAngajat() {
		return numeAngajat;
	}
	public void setNumeAngajat(String numeAngajat) {
		this.numeAngajat = numeAngajat;
	}
	public String getPrenumeAngajat() {
		return prenumeAngajat;
	}
	public void setPrenumeAngajat(String prenumeAngajat) {
		this.prenumeAngajat = prenumeAngajat;
	}
	public int getTeamID() {
		return teamID;
	}
	public void setTeamID(int teamID) {
		this.teamID = teamID;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	@Override
	public String toString() {
		return "CreateTeamsDTO [angajatID=" + angajatID + ", functieID=" + functieID + ", proiectID=" + proiectID
				+ ", managerID=" + managerID + ", numeManager=" + numeManager + ", coordonatorID=" + coordonatorID
				+ ", numeAngajat=" + numeAngajat + ", prenumeAngajat=" + prenumeAngajat + ", teamID=" + teamID
				+ ", teamName=" + teamName + "]";
	}
     
}