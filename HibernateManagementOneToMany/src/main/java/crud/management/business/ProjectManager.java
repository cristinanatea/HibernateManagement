package crud.management.business;

import java.util.List;

import crud.management.commons.ProjectDTO;
import crud.management.persistence.dao.RequestStatus;
import crud.management.persistence.model.Project;

public interface ProjectManager {
	
	ProjectDTO getProjectById(int ProjectID);
	List<Project> listProjects();
	public ProjectDTO addProject(Project Project);

}



