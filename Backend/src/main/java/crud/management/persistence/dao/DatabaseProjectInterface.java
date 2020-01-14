package crud.management.persistence.dao;


import java.util.List;

import crud.management.persistence.model.Project;
import crud.management.persistence.model.User;

public interface DatabaseProjectInterface {
	
	
    
    //project management
    public Project addProject(Project project);
	public Project updateProject(Project project);
	public List<Project> listProjects();
	public Project getProjectById(int ProjectID);
	public boolean deleteProject(int ProjectID);
	public Project getProjectByName(String projectName);
	


}
