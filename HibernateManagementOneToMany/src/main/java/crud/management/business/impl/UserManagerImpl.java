package crud.management.business.impl;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import crud.management.business.UserManager;
import crud.management.commons.ProjectInfo;
import crud.management.commons.UserInfo;
import crud.management.persistence.dao.DatabaseInterface;
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
			List<String> projects = new ArrayList<String>();
	
			for (Project project : user.getProjects()) {
				projects.add(project.getName());
			}
	
			userInfo.setAsignedProjects(projects);
		}
		else
		{
			userInfo.setStatus("User does not exist");
		}

		return userInfo;
	}

	private ProjectInfo getProjectInfo(Project project, User user) {
		String managerName = user.getName();
		ProjectInfo projectInfo = new ProjectInfo();
		projectInfo.setProjectID(project.getProjectID());
		projectInfo.setProjectName(project.getName());
		projectInfo.setManagerName(managerName);

		List<String> employees = new ArrayList<String>();

		for (User employee : project.getUsers()) {
			employees.add(employee.getName());
		}

		projectInfo.setEmployeeNames(employees);

		return projectInfo;

	}

	@Override
	public UserInfo login(String email, String password) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		DatabaseInterface db = (DatabaseInterface) context.getBean("databaseBean");

		User user = db.getUserByEmail(email);

		return getUserInfo(user);
	}

	@Override
	public UserInfo signUp(String name, String phoneNumber, String email, String password) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		DatabaseInterface db = (DatabaseInterface) context.getBean("databaseBean");
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
		db.addUser(user);

		return getUserInfo(user);
	}

	@Override
	public ProjectInfo createProject(String name, int managerID) {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		DatabaseInterface db = (DatabaseInterface) context.getBean("databaseBean");
		User user = db.getUserById(managerID);

		if (user != null) {
			Project project = new Project();
			project.setName(name);
			project.setManagerID(managerID);
			db.addProject(project);

			return getProjectInfo(project, user);
		}
		return null;
	}

	@Override
	public ProjectInfo asignUserToProject(int userID, int projectID) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		DatabaseInterface db = (DatabaseInterface) context.getBean("databaseBean");
		User user = db.getUserById(userID);
		Project project = db.getProjectById(projectID);
		if (user != null && project != null) {
			project.addUser(user);
			db.updateProject(project);
			return getProjectInfo(project, user);
		}
		return null;
	}
}
