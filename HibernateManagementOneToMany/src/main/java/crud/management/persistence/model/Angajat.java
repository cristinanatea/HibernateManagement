package crud.management.persistence.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "angajat")
public class Angajat implements Serializable {

 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@Id
 @GeneratedValue
 private int angajatID;
 private int functieID;
 private int proiectID;
 private String  dataAngajarii;
 private String norma;
 private int managerID;
 private String nume;
 private String prenume;
 private String adresa;
 private String telefon;
 private int  nrZileConcediuMedicalLuat;
 private String cnp;
 

 //@JoinColumn(name = "managerID", referencedColumnName = "managerID")
 @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
 @Column(name = "manager_ID")
 private Set<Manager> manageri = 
		 new HashSet <Manager>(0);

 //@JoinColumn(name = "proiectID", referencedColumnName = "proiectID")
 @ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
 @Column(name = "proiect_ID")
 private Set<Proiect> proiecte = 
		 new HashSet <Proiect>(0);

 
 public Angajat() {
  super();
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


public void setProiectID(int proiectId) {
	this.proiectID = proiectId;
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

public Set<Manager> getManageri() 
{
	return manageri;
} 

public Set<Proiect> getProiecte() 
{
	return proiecte;
}


@Override
public String toString() {
	return "Angajat [angajatID=" + angajatID + ", functieID=" + functieID + ", proiectID=" + proiectID
			+ ", dataAngajarii=" + dataAngajarii + ", norma=" + norma + ", managerID=" + managerID + ", nume=" + nume
			+ ", prenume=" + prenume + ", adresa=" + adresa + ", telefon=" + telefon + ", nrZileConcediuMedicalLuat="
			+ nrZileConcediuMedicalLuat + ", cnp=" + cnp + ", manageri=" + manageri + ", proiecte=" + proiecte + "]";
} 


}



