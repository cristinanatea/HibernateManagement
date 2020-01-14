package crud.management.persistence.dao;

import java.util.List;

import crud.management.persistence.model.User;

public interface DatabaseUserInterface {
	
	//user management
		public User addUser(User user);
		public User updateUser(User user);
		public List<User> listUsers();
		public User getUserById(int UserID);
		public boolean deleteUser(int UserID);
	    public User getUserByEmail(String email);
	    public boolean isDuplicateEntry(String email);

}
