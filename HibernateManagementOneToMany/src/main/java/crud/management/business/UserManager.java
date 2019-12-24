package crud.management.business;

import crud.management.commons.LoginDTO;
import crud.management.commons.SignUpDTO;
import crud.management.commons.UserDTO;
import crud.management.persistence.daoimpl.CreateTeamsDTO;
import crud.management.persistence.model.User;

public interface UserManager {
	/*
	UserDTOep getUserById(int UserID);
	List<User> listUseri();
	public UserDTOep  addUser(User User);
	public UserDTOep loginUser(String email, String password);

*/

	public UserDTO getUserInfo(LoginDTO loginInfo);
	public UserDTO addUser(SignUpDTO SignUpinfo);
	public User createTeamsDTO(CreateTeamsDTO info);
}
