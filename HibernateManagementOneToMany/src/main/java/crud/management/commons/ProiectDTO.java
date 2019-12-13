package crud.management.commons;
import java.io.Serializable;

import crud.management.persistence.model.Angajat;
import crud.management.persistence.model.Proiect;

public class ProiectDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	 private int proiectID;
	 private int coordonatorID;
	 private String descriere;
	 private String dataInceput;
	 private String dataSfarsit;
	 
	 
	 
	 public ProiectDTO() {
			super();
		}
	 
	 public ProiectDTO(Proiect proiect) {
			
			this.proiectID = proiect.getProiectID();
			this.coordonatorID = proiect.getCoordonatorID();
			this.descriere = proiect.getDescriere();
			this.dataInceput =proiect.getDataInceput();
			this.dataSfarsit = proiect.getDataSfarsit();
			
		}
	 
	 
	public ProiectDTO(int proiectID, int coordonatorID, String descriere, String dataInceput, String dataSfarsit) {
		super();
		this.proiectID = proiectID;
		this.coordonatorID = coordonatorID;
		this.descriere = descriere;
		this.dataInceput = dataInceput;
		this.dataSfarsit = dataSfarsit;
	}
	public int getProiectID() {
		return proiectID;
	}
	public void setProiectID(int proiectID) {
		this.proiectID = proiectID;
	}
	public int getCoordonatorID() {
		return coordonatorID;
	}
	public void setCoordonatorID(int coordonatorID) {
		this.coordonatorID = coordonatorID;
	}
	public String getDescriere() {
		return descriere;
	}
	public void setDescriere(String descriere) {
		this.descriere = descriere;
	}
	public String getDataInceput() {
		return dataInceput;
	}
	public void setDataInceput(String dataInceput) {
		this.dataInceput = dataInceput;
	}
	public String getDataSfarsit() {
		return dataSfarsit;
	}
	public void setDataSfarsit(String dataSfarsit) {
		this.dataSfarsit = dataSfarsit;
	}
	@Override
	public String toString() {
		return "ProiectDTO [proiectID=" + proiectID + ", coordonatorID=" + coordonatorID + ", descriere=" + descriere
				+ ", dataInceput=" + dataInceput + ", dataSfarsit=" + dataSfarsit + "]";
	}
	 	 
	
}