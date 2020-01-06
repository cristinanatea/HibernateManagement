package crud.management.persistence.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "user")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue 
    private int userID;
	private String password;
	private String email;
	private String name;
	private String phoneNumber;
	private int acces;
	
	
	public int getAcces() {
		return acces;
	}

	public void setAcces(int acces) {
		this.acces = acces;
	}

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "Organisation", joinColumns = { @JoinColumn(name = "userID") }, inverseJoinColumns = {
			@JoinColumn(name = "projectID") })
	private Set<Project> projects = new HashSet<Project>();

	public Set<Project> getProjects() {
		return projects;
	}

	public User() {
		super();
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}



	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "User [userID=" + userID + ", password=" + password + ", email=" + email
				+ ", name=" + name + ", phoneNumber=" + phoneNumber + "]";
	}

	
}