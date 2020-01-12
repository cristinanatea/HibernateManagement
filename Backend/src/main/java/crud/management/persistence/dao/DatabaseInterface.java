package crud.management.persistence.dao;


import java.util.List;

import crud.management.persistence.model.Project;
import crud.management.persistence.model.User;

public interface DatabaseInterface {
	
	//user management
	public User addUser(User user);
	public User updateUser(User user);
	public List<User> listUsers();
	public User getUserById(int UserID);
	public boolean removeUser(int UserID);
    public User getUserByEmail(String email);
    public boolean isDuplicateEntry(String email);
    
    //project management
    public Project addProject(Project project);
	public Project updateProject(Project project);
	public List<Project> listProjects();
	public Project getProjectById(int ProjectID);
	public boolean deleteProject(int ProjectID);
	public Project getProjectByName(String projectName);


}
