package crud.management.business.impl;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.sample.commons.UserInfo;
import crud.management.business.UserManager;
import crud.management.persistence.dao.DatabaseUserInterface;
import crud.management.persistence.model.Project;
import crud.management.persistence.model.User;

public class UserManagerImpl implements UserManager {

	static Session sessionObj;

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;

	}

	private UserInfo getUserInfo(User user) {
		UserInfo userInfo = new UserInfo();

		if (user != null) {
			userInfo.setUserID(user.getUserID());
			userInfo.setPhoneNumber(user.getPhoneNumber());
			userInfo.setName(user.getName());
			userInfo.setEmail(user.getEmail());
			userInfo.setAcces(user.getAcces());
			List<String> projects = new ArrayList<String>();

			for (Project project : user.getProjects()) {
				projects.add(project.getName());
			}

			userInfo.setAsignedProjects(projects);
		} else {
			userInfo.setStatus("User does not exist");
		}

		return userInfo;
	}

	@Override
	public UserInfo login(String email, String password) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		DatabaseUserInterface db = (DatabaseUserInterface) context.getBean("databaseUserBean");

		User user = db.getUserByEmail(email);
		if (user.getPassword().equals(password)) {
			return getUserInfo(user);
		} else {
			return getUserInfo(null);

		}

	}

	@Override
	public UserInfo signUp(String name, String phoneNumber, String email, String password, String company) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		DatabaseUserInterface db = (DatabaseUserInterface) context.getBean("databaseUserBean");
		boolean isDuplicate = db.isDuplicateEntry(email);

		if (isDuplicate == true) {
			UserInfo userInfo = new UserInfo();
			userInfo.setStatus("Email already exists");
			return userInfo;
		}

		User user = new User();
		user.setName(name);
		user.setPhoneNumber(phoneNumber);
		user.setEmail(email);
		user.setPassword(password);
		user.setAcces(0);
		db.addUser(user);

		return getUserInfo(user);
	}

	public UserInfo setPassword(String email, String newPassword, String oldPassword) {
		UserInfo status;
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		DatabaseUserInterface db = (DatabaseUserInterface) context.getBean("databaseUserBean");
		User user = db.getUserByEmail(email);
		if (user != null) {
			if (user.getPassword().equals(oldPassword)) {
				user.setPassword(newPassword);
				db.updateUser(user);
				status = getUserInfo(user);
			} else {

				status = new UserInfo();
				status.setStatus(" Passwords do not match!");
			}
		} else {
			status = new UserInfo();
			status.setStatus("Userul nu exista");
		}

		return status;
	}

	@Override
	public List<UserInfo> listUsers() {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		DatabaseUserInterface db = (DatabaseUserInterface) context.getBean("databaseUserBean");

		try {
			List<UserInfo> usersInfo = new ArrayList<UserInfo>();

			List<User> usersList = db.listUsers();
			for (User user : usersList) {
				UserInfo userInfo = new UserInfo();
				userInfo.setEmail(user.getEmail());
				userInfo.setName(user.getName());
				userInfo.setPhoneNumber(user.getPhoneNumber());
				userInfo.setUserID(user.getUserID());
				userInfo.setAcces(user.getAcces());

				usersInfo.add(userInfo);
			}

			return usersInfo;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public boolean deleteUser(String name) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		DatabaseUserInterface db = (DatabaseUserInterface) context.getBean("databaseUserBean");
		User user = db.getUserByEmail(name);
		if (user != null) {
			db.deleteUser(user.getUserID());
		}

		return true;
	}
}
