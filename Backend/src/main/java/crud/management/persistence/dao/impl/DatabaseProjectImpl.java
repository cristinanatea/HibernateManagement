package crud.management.persistence.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import crud.management.persistence.model.Project;
import crud.management.persistence.model.User;
import crud.management.persistence.dao.DatabaseProjectInterface;

public class DatabaseProjectImpl implements DatabaseProjectInterface {

	static Session sessionObj;

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	public Project addProject(Project project) {
		Session session = this.sessionFactory.getCurrentSession();
		Transaction tx1 = session.beginTransaction();
		session.persist(project);
		tx1.commit();
		return project;
	}

	public Project updateProject(Project project) {
		Session session = this.sessionFactory.getCurrentSession();
		Transaction tx1 = session.beginTransaction();
		session.update(project);
		tx1.commit();
		return project;
	}

	public List<Project> listProjects() {
		Session session = this.sessionFactory.getCurrentSession();
		Transaction tx1 = session.beginTransaction();
		List<Project> projectsList = session.createQuery("from Project").list();
		tx1.commit();
		return projectsList;
	}

	public Project getProjectById(int projectID) {
		Session session = this.sessionFactory.getCurrentSession();
		Transaction tx1 = session.beginTransaction();
		Project proj = (Project) session.get(Project.class, new Integer(projectID));
		tx1.commit();
		return proj;
	}

	public boolean deleteProject(int projectID) {
		Session session = this.sessionFactory.getCurrentSession();
		Transaction tx1 = session.beginTransaction();
		Project proj = (Project) session.get(Project.class, new Integer(projectID));
		if (null != proj) {
			//sterge relatia dintre proiectul curent si utilizatori din tabela Organisation
			proj.getUsers().clear();

			session.delete(proj);
			tx1.commit();
			return true;
		}

		tx1.commit();
		return false;
	}

	@Override
	public Project getProjectByName(String projectName) {
		Session session = this.sessionFactory.getCurrentSession();
		Transaction tx1 = session.beginTransaction();
		Query query = (Query) session.createQuery("from Project WHERE name = :name");
		query.setParameter("name", projectName);
		
		List<Project> ProjectsList = query.list();
		tx1.commit();
		for (Project project : ProjectsList) {
			return project;
		}
		return null;

	}

}
