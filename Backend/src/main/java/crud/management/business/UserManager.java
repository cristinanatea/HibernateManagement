package crud.management.business;

import com.sample.commons.ProjectInfo;
import com.sample.commons.UserInfo;

public interface UserManager
{
	public UserInfo login(String email, String password);
	public UserInfo signUp(String nume, String phoneNumber, String email,String password);
	public ProjectInfo createProject(String nume, int managerID);
	public ProjectInfo asignUserToProject(int userID, int projectID);
	public UserInfo setPassword(String email, String newPassword, String oldPassword);
}
