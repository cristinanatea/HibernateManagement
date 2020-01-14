package crud.management.business;

import java.util.List;

import com.sample.commons.ProjectInfo;

public interface ProjectManager {
	public ProjectInfo createProject(String nume, String managerEmail);
	public ProjectInfo asignUserToProject(String userEmail, String projectName);
	public List<ProjectInfo> listProjects();
	public boolean deleteProject(String projectName);

}
