package crud.management.persistence.dao;


import java.util.List;

import crud.management.commons.LoginDTO;
import crud.management.commons.SignUpDTO;
import crud.management.commons.CreateTeamsDTO;
import crud.management.persistence.model.User;

public interface UserDAO {

	public User addUser(User User);
	public RequestStatus updateUser(User User);
	public List<User> listUsers();
	public User getUserById(int UserID);
	public RequestStatus removeUser(int UserID);
	public User loginUser(String email, String password);
	public User getUser(LoginDTO info);
    public User addUser(SignUpDTO info);
    public User getUserByEmail(String email);
    public boolean isDuplicateEntry(String email);
    public User CreateTeamsDTO(CreateTeamsDTO info);

}
