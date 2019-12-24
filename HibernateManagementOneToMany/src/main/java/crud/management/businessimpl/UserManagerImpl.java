package crud.management.businessimpl;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import crud.management.business.CreateTeamsDTO;
import crud.management.business.UserManager;
import crud.management.commons.LoginDTO;
import crud.management.commons.SignUpDTO;
import crud.management.commons.UserDTO;
import crud.management.persistence.dao.UserDAO;
import crud.management.persistence.model.User;

public class UserManagerImpl implements UserManager {


	static Session sessionObj;

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;

	}
	/*
	UserDTOep UserDTO;

	
	public UserDTOep getUserById(int UserID) {
		User User = UserDao.getUserById(UserID);
		UserDTO.setEmail(User.getEmail());
		return UserDTO;
	}
	

	public List<User> listUseri() {
	
		return UserDao.listUseri();
	}

	@Override
	public UserDTOep addUser(User User) {
		UserDTO.setEmail(User.getEmail());
		return UserDTO;
	}
	
	public UserDTOep loginUser(String email, String password) {
		UserDTOep UserDTO = new UserDTOep();
		UserDTOep userLogin = UserDao.loginUser(email, password);
		UserDTO.setEmail(userLogin.getEmail());
		return UserDTO;
	}
*/

	public UserDTO getUserInfo(LoginDTO loginInfo) {

		Resource r = new ClassPathResource("applicationContext.xml");
		BeanFactory factory = new XmlBeanFactory(r);
		UserDAO userDAO = (UserDAO) factory.getBean("UserDAO");
		
		User uti = userDAO.getUser(loginInfo);
		
		if (uti != null) {
			return new UserDTO(uti.getEmail(), uti.getName());
		}
		
		return null;
	}
	
	public UserDTO addUser(SignUpDTO SignUpInfo) {

		Resource r = new ClassPathResource("applicationContext.xml");
		BeanFactory factory = new XmlBeanFactory(r);
		UserDAO userDAO = (UserDAO) factory.getBean("UserDAO");
		
		User uti = userDAO.addUser(SignUpInfo);
		
		if (uti != null) {
			return  new UserDTO(uti.getEmail(), uti.getName());
		}
		
		return null;
	}
	
	public User createTeamsDTO(CreateTeamsDTO info)
	{
		return null;
	}
}
