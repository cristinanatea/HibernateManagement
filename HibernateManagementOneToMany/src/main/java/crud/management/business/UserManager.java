package crud.management.business;

import crud.management.commons.ProjectInfo;
import crud.management.commons.UserInfo;

public interface UserManager
{
	public UserInfo login(String email, String password);
	public UserInfo signUp(String nume, String phoneNumber, String email,String password);
	public ProjectInfo createProject(String nume, int managerID);
	public ProjectInfo asignUserToProject(int userID, int projectID);
}
