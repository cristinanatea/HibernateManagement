package crud.management.businessimpl;

import java.util.List;

import crud.management.business.ProjectManager;
import crud.management.commons.ProjectDTO;
import crud.management.persistence.dao.ProjectDAO;
import crud.management.persistence.model.Project;

public class ProjectManagerImpl implements ProjectManager {
	
	ProjectDAO ProjectDao;
	ProjectDTO ProjectDTO;

	@Override
	public ProjectDTO getProjectById(int ProjectID) {
		Project Project = ProjectDao.getProjectById(ProjectID);
		ProjectDTO.setManagerID(Project.getManagerID());
		return ProjectDTO;
	}

	public List<Project> listProjects() {
		// TODO Auto-generated method stub
		return ProjectDao.listProjects();
	}

	@Override
	public ProjectDTO addProject(Project Project) {
		ProjectDTO.setManagerID(Project.getManagerID());
		return ProjectDTO;
	}

}
