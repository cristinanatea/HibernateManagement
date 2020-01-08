package crud.management.persistence.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import crud.management.persistence.model.Project;
import crud.management.persistence.model.User;
import crud.management.persistence.dao.DatabaseInterface;

public class DatabaseImpl implements DatabaseInterface {

	static Session sessionObj;

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public User addUser(User User) {
		Session session = this.sessionFactory.getCurrentSession();
		Transaction tx1 = session.beginTransaction();
		session.saveOrUpdate(User);
		tx1.commit();
		return User;
	}

	public User updateUser(User user) {
		Session session = this.sessionFactory.getCurrentSession();
		Transaction tx1 = session.beginTransaction();	
		session.update(user);
		tx1.commit();
		return user;
	}

	public List<User> listUsers() {
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<User> usersList = session.createQuery("from User").list();
		return usersList;
	}

	public User getUserById(int UserID) {
		Session session = this.sessionFactory.getCurrentSession();
		Transaction tx1 = session.beginTransaction();
		User user = (User) session.get(User.class, new Integer(UserID));
		tx1.commit();
		return user;
	}

	public boolean removeUser(int UserID) {
		Session session = this.sessionFactory.getCurrentSession();
		User user = (User) session.get(User.class, new Integer(UserID));
		if (null != user) {
			session.delete(user);
			return true;
		}
		return false;
	}

	public User getUserByEmail(String email) {

		Session session = this.sessionFactory.getCurrentSession();
		Transaction tx1 = session.beginTransaction();
		Query query = (Query) session.createQuery("from User WHERE email = :email");
		query.setParameter("email", email);
		
		List<User> UsersList = query.list();
		tx1.commit();
		for (User user : UsersList) {
			return user;
		}
		return null;
	}

	public boolean isDuplicateEntry(String email) {
		User user = getUserByEmail(email);

		if (user != null) {
			return true;
		} else {
			return false;
		}
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

	public boolean removeProject(int projectID) {
		Session session = this.sessionFactory.getCurrentSession();

		Project proj = (Project) session.get(Project.class, new Integer(projectID));
		if (null != proj) {
			session.delete(proj);
			return true;
		}

		return false;
	}

}
