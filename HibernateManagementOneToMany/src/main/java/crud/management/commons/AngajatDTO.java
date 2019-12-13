package crud.management.commons;

import java.io.Serializable;

import crud.management.persistence.model.Angajat;
import crud.management.persistence.model.Manager;

public class AngajatDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private int angajatID;
	private int functieID;
	private int proiectID;
	private String dataAngajarii;
	private String norma;
	private int managerID;
	private String nume;
	private String prenume;
	private String adresa;
	private String telefon;
	private int nrZileConcediuMedicalLuat;
	private String cnp;
	
	 public AngajatDTO() {
			super();
		}
	 
	 public AngajatDTO(Angajat angajat) {
			
			this.angajatID = angajat.getAngajatID();
			this.functieID = angajat.getFunctieID();
			this.proiectID = angajat.getProiectID();
			this.dataAngajarii =angajat.getDataAngajarii();
			this.norma = angajat.getNorma();
			this.managerID =angajat.getManagerID();
			this.nume = angajat.getNume();
			this.prenume = angajat.getPrenume();
			this.adresa = angajat.getAdresa();
			this.telefon = angajat.getTelefon();
			this.nrZileConcediuMedicalLuat = angajat.getNrZileConcediuMedicalLuat();
			this.cnp =angajat.getCnp();
		}
		
		
		public AngajatDTO(int angajatID, int functieID, int proiectID, String dataAngajarii, String norma,
				int managerID, String nume, String prenume, String adresa, String telefon,
				int nrZileConcediuMedicalLuat, String cnp) {
			super();
			this.angajatID = angajatID;
			this.functieID = functieID;
			this.proiectID = proiectID;
			this.dataAngajarii = dataAngajarii;
			this.norma = norma;
			this.managerID = managerID;
			this.nume = nume;
			this.prenume = prenume;
			this.adresa = adresa;
			this.telefon = telefon;
			this.nrZileConcediuMedicalLuat = nrZileConcediuMedicalLuat;
			this.cnp = cnp;
		}

	
	
	

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

	public String getDataAngajarii() {
		return dataAngajarii;
	}

	public void setDataAngajarii(String dataAngajarii) {
		this.dataAngajarii = dataAngajarii;
	}

	public String getNorma() {
		return norma;
	}

	public void setNorma(String norma) {
		this.norma = norma;
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

	public String getPrenume() {
		return prenume;
	}

	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public int getNrZileConcediuMedicalLuat() {
		return nrZileConcediuMedicalLuat;
	}

	public void setNrZileConcediuMedicalLuat(int nrZileConcediuMedicalLuat) {
		this.nrZileConcediuMedicalLuat = nrZileConcediuMedicalLuat;
	}

	public String getCnp() {
		return cnp;
	}

	public void setCnp(String cnp) {
		this.cnp = cnp;
	}

	@Override
	public String toString() {
		return "AngajatDTO [angajatID=" + angajatID + ", functieID=" + functieID + ", proiectID=" + proiectID
				+ ", dataAngajarii=" + dataAngajarii + ", norma=" + norma + ", managerID=" + managerID + ", nume="
				+ nume + ", prenume=" + prenume + ", adresa=" + adresa + ", telefon=" + telefon
				+ ", nrZileConcediuMedicalLuat=" + nrZileConcediuMedicalLuat + ", cnp=" + cnp + "]";
	}
	
	

}
