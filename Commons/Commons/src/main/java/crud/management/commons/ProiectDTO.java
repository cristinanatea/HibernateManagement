package crud.management.commons;
import java.io.Serializable;


public class ProiectDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	 private int proiectID;
	 private int coordonatorID;
	 private String descriere;
	 private String dataInceput;
	 private String dataSfarsit;
	 

	public int getProiectByID() {
		return proiectID;
	}
	public void setProiectByID(int proiectID) {
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