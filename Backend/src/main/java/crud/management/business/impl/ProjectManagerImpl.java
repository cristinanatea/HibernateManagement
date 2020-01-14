package crud.management.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sample.commons.ProjectInfo;

import crud.management.business.ProjectManager;
import crud.management.persistence.dao.DatabaseProjectInterface;
import crud.management.persistence.dao.DatabaseUserInterface;
import crud.management.persistence.model.Project;
import crud.management.persistence.model.User;

public class ProjectManagerImpl implements ProjectManager{
	static Session sessionObj;

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;

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
	public ProjectInfo createProject(String name, String managerEmail) {
		ProjectInfo status;
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		DatabaseProjectInterface db = (DatabaseProjectInterface) context.getBean("databaseProjectBean");
		DatabaseUserInterface db1 = (DatabaseUserInterface) context.getBean("databaseUserBean");
		User user = db1.getUserByEmail(managerEmail);

		if (user != null) {
			Project project = new Project();
			project.setName(name);
			project.setManagerID(user.getUserID());
			db.addProject(project);

			return getProjectInfo(project, user);
		} else {
			status = new ProjectInfo();
			status.setStatus("Userul nu exista");
		}

		return status;
	}

	@Override
	public ProjectInfo asignUserToProject(String userEmail, String projectName) {
		ProjectInfo status;
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		DatabaseUserInterface db = (DatabaseUserInterface) context.getBean("databaseUserBean");
		DatabaseProjectInterface db1 = (DatabaseProjectInterface) context.getBean("databaseProjectBean");
		User user = db.getUserByEmail(userEmail);
		Project project = db1.getProjectByName(projectName);
		if (user != null && project != null) {
			project.addUser(user);
			db1.updateProject(project);
			status = getProjectInfo(project, user);
		} else {
			status = new ProjectInfo();
			status.setStatus("Userul nu exista");
		}

		return status;
	}
	
	public List<ProjectInfo> listProjects() {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		DatabaseProjectInterface db = (DatabaseProjectInterface) context.getBean("databaseProjectBean");

		try {
			List<ProjectInfo> projectsInfo = new ArrayList<ProjectInfo>();

			List<Project> projectsList = db.listProjects();
			for (Project project : projectsList) {
				ProjectInfo projectInfo = new ProjectInfo();
				projectInfo.setProjectID(project.getProjectID());
				projectInfo.setProjectName(project.getName());
				projectInfo.setManagerName(project.getName());

				List<String> users = new ArrayList<String>();

				for (User user : project.getUsers()) {
					users.add(user.getName());
				}

				projectInfo.setEmployeeNames(users);

				projectsInfo.add(projectInfo);
			}

			return projectsInfo;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public boolean deleteProject(String projectName) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		DatabaseProjectInterface db = (DatabaseProjectInterface) context.getBean("databaseProjectBean");
		Project project = db.getProjectByName(projectName);
		if (project != null) {
			db.deleteProject(project.getProjectID());
		}

		return true;
	}
	

}
