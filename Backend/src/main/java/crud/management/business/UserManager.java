package crud.management.business;

import java.util.List;


import com.sample.commons.UserInfo;

public interface UserManager {
	public UserInfo login(String email, String password);

	public UserInfo signUp(String nume, String phoneNumber, String email, String password, String company);

	public UserInfo setPassword(String email, String newPassword, String oldPassword);

	public List<UserInfo> listUsers();

	public boolean deleteUser(String name);
}
