package crud.management.persistence.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "proiect")
public class Proiect {

 @Id
 @GeneratedValue
 private int proiectID;
 private int coordonatorID;
 private String descriere;
 private String dataInceput;
 private String dataSfarsit;

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

}



