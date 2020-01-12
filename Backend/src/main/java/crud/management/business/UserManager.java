package crud.management.business;

import java.util.List;

import com.sample.commons.ProjectInfo;
import com.sample.commons.UserInfo;


public interface UserManager
{
	public UserInfo login(String email, String password);
	public UserInfo signUp(String nume, String phoneNumber, String email,String password);
	public ProjectInfo createProject(String nume, String managerEmail);
	public ProjectInfo asignUserToProject(String userEmail, String projectName);
	public UserInfo setPassword(String email, String newPassword, String oldPassword);
	public List<UserInfo> listUsers();
	public List<ProjectInfo> listProjects();
	public boolean deleteProject(String projectName);
}
