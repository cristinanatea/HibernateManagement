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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "manager")
public class Manager implements Serializable {
	private static final long serialVersionUID = 1L;
@Id
 @GeneratedValue
 private int managerID;
 private String nume;
 private String dataAngajarii;
 
 /*
 @JoinColumn(name = "managerID", referencedColumnName = "managerID")
 @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
 private Set<Manager> manageri = 
		 new HashSet <Manager>(0);
*/
 
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

@Override
public String toString() {
	return "Manager [managerID=" + managerID + ", nume=" + nume + ", dataAngajarii=" + dataAngajarii + "]";
}


}



