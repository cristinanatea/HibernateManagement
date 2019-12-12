package crud.management.persistence.model;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "proiect")
public class Proiect implements Serializable {
	private static final long serialVersionUID = 1L;
@Id
 @GeneratedValue
 private int proiectID;
 private int coordonatorID;
 private String descriere;
 private String dataInceput;
 private String dataSfarsit;
 /*
 @JoinColumn(name = "proiectID", referencedColumnName = "proiectID")
 @ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
 private Set<Proiect> proiecte = 
		 new HashSet <Proiect>(0);
*/
 public Proiect() {
  super();
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
	return "Proiect [proiectID=" + proiectID + ", coordonatorID=" + coordonatorID + ", descriere=" + descriere
			+ ", dataInceput=" + dataInceput + ", dataSfarsit=" + dataSfarsit + "]";
}



}



