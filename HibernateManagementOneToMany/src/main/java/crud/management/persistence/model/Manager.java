package crud.management.persistence.model;


import java.io.Serializable;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name = "manager")
public class Manager implements Serializable {
	private static final long serialVersionUID = 1L;
@Id
 @GeneratedValue
 private int managerID;
 private String name;
 private String employmentDate;
 
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

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getEmploymentDate() {
	return employmentDate;
}

public void setEmploymentDate(String employmentDate) {
	this.employmentDate = employmentDate;
}

@Override
public String toString() {
	return "Manager [managerID=" + managerID + ", name=" + name + ", employmentDate=" + employmentDate + "]";
}


}



