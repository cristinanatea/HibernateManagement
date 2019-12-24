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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonManagedReference;

@Entity
@Table(name = "employee")
public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int employeeID;
	private int positionID;
	private int projectID;
	private String employmentDate;
	private String workingHours;
	private int managerID;
	private String name;
	private String forname;
	private String adress;
	private String telephone;
	private int nrDaysOfMedicalLeaveTaken;
	private String personalNumber;


 
 //@JoinColumn(name = "managerID", referencedColumnName = "managerID")
 @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
 @Column(name = "managerID")
 private Set<Manager> manageri = 
		 new HashSet <Manager>(0);

	// @JoinColumn(name = "proiectID", referencedColumnName = "proiectID")
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Column(name = "project_ID")
	private Set<Project> projects = new HashSet<Project>(0);

	public Employee() {
		super();
	}

	
	public int getEmployeeID() {
		return employeeID;
	}


	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}


	public int getPositionID() {
		return positionID;
	}


	public void setPositionID(int positionID) {
		this.positionID = positionID;
	}


	public int getProjectID() {
		return projectID;
	}


	public void setProjectID(int projectID) {
		this.projectID = projectID;
	}


	public String getEmploymentDate() {
		return employmentDate;
	}


	public void setEmploymentDate(String employmentDate) {
		this.employmentDate = employmentDate;
	}


	public String getWorkingHours() {
		return workingHours;
	}


	public void setWorkingHours(String workingHours) {
		this.workingHours = workingHours;
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


	public String getForname() {
		return forname;
	}


	public void setForname(String forname) {
		this.forname = forname;
	}


	public String getAdress() {
		return adress;
	}


	public void setAdress(String adress) {
		this.adress = adress;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	public int getNrDaysOfMedicalLeaveTaken() {
		return nrDaysOfMedicalLeaveTaken;
	}


	public void setNrDaysOfMedicalLeaveTaken(int nrDaysOfMedicalLeaveTaken) {
		this.nrDaysOfMedicalLeaveTaken = nrDaysOfMedicalLeaveTaken;
	}


	public String getPersonalNumber() {
		return personalNumber;
	}


	public void setPersonalNumber(String personalNumber) {
		this.personalNumber = personalNumber;
	}


	public Set<Manager> getManageri() {
		return manageri;
	}


	public void setManageri(Set<Manager> manageri) {
		this.manageri = manageri;
	}


	public Set<Project> getProjects() {
		return projects;
	}


	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}




	
	@Override
	public String toString() {
		return "Employee [employeeID=" + employeeID + ", positionID=" + positionID + ", projectID=" + projectID
				+ ", employmentDate=" + employmentDate + ", workingHours=" + workingHours + ", managerID=" + managerID
				+ ", name=" + name + ", forname=" + forname + ", adress=" + adress + ", telephone=" + telephone
				+ ", nrDaysOfMedicalLeaveTaken=" + nrDaysOfMedicalLeaveTaken + ", personalNumber=" + personalNumber
				+ ", manageri=" + manageri + "]";
	}



}
