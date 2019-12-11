package crud.management.persistence.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "manager")
public class Manager {

 @Id
 @GeneratedValue
 private int managerID;
 private String nume;
 private String dataAngajarii;

 public Manager() {
  super();
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


}



