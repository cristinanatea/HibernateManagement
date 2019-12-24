package crud.management.persistence.dao;


import java.util.List;

import crud.management.persistence.model.Project;

public interface ProjectDAO {

	public RequestStatus addProject(Project Project);
	public RequestStatus updateProject(Project Project);
	public List<Project> listProjects();
	public Project getProjectById(int ProjectID);
	public RequestStatus removeProject(int ProjectID);
}
