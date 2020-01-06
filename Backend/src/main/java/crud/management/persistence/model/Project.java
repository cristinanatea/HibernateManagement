package crud.management.persistence.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "project")
public class Project implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int projectID;
	private int managerID;
	private String name;
	

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "Organisation", joinColumns = { @JoinColumn(name = "projectID") }, inverseJoinColumns = {
			@JoinColumn(name = "userID") })
	private Set<User> users = new HashSet<User>();


	public Set<User> getUsers() {
		return users;
	}

	public void addUser(User user) {
		users.add(user);
	}
	
	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getProjectID() {
		return projectID;
	}
	public void setProjectID(int projectID) {
		this.projectID = projectID;
	}
	public int getManagerID() {
		return managerID;
	}
	public void setManagerID(int managerID) {
		this.managerID = managerID;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}

	@Override
	public String toString() {
		return "Project [projectID=" + projectID + ", managerID=" + managerID + ", name=" + name+"]";
	}
	
}


