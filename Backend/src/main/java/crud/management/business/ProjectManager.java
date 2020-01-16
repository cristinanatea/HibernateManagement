package crud.management.business;

import java.util.List;

import com.sample.commons.ProjectInfo;

import crud.management.persistence.model.Project;
import crud.management.persistence.model.User;

public interface ProjectManager {
	public ProjectInfo createProject(String nume, String managerEmail);
	public ProjectInfo asignUserToProject(String userEmail, String projectName);
	public List<ProjectInfo> listProjects();
	public boolean deleteProject(String projectName);
	public ProjectInfo getProjectInfo(Project project, User user);

}
