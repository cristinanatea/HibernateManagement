package crud.management.persistence.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import crud.management.persistence.model.Employee;
import crud.management.persistence.model.Team;
import crud.management.persistence.model.User;
import crud.management.commons.LoginDTO;
import crud.management.commons.SignUpDTO;
import crud.management.commons.UserDTO;
import crud.management.commons.CreateTeamsDTO;
import crud.management.persistence.dao.RequestStatus;
import crud.management.persistence.dao.UserDAO;

public class UserDAOImpl implements UserDAO {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeDAOImpl.class);

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
		logger.info("User saved successfully, User Details=" + User);
		return User;
	}

	public RequestStatus updateUser(User User) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(User);
		logger.info("User updated successfully, User Details=" + User);
		return new RequestStatus();
	}

	@SuppressWarnings("unchecked")

	public List<User> listUsers() {
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();

		List<User> UsersList = session.createQuery("from User").list();
		for (User User : UsersList) {
			logger.info("Person List::" + User);
		}
		return UsersList;
	}

	public User getUserById(int UsersD) {
		Session session = this.sessionFactory.getCurrentSession();
		User User = (User) session.load(User.class, new Integer(UsersD));
		logger.info("Person loaded successfully, Person details=" + User);
		return User;
	}

	public RequestStatus removeUser(int UsersD) {
		Session session = this.sessionFactory.getCurrentSession();
		User User = (User) session.load(User.class, new Integer(UsersD));
		if (null != User) {
			session.delete(User);
		}
		logger.info("Employee deleted successfully, Employee details=" + User);
		return new RequestStatus();
	}

	public User loginUser(String email, String password) {
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();

		List<User> UsersList = session.createQuery("from User").list();
		for (User User : UsersList) {

			if (User.getEmail().contentEquals(email) && User.getPassword().contentEquals(password)) {
				return User;
			}
		}
		return null;
	}

	public User getUser(LoginDTO info) {

		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();

		Query query = (Query) session.createQuery("from User where email = :email and password = :pass");

		query.setParameter("email", info.getUsername());
		query.setParameter("pass", info.getPassword());

		List<User> UsersList = query.list();

		for (User User : UsersList) {
			return User;
		}

		return null;
	}

	public User getUserByEmail(String email) {

		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();

		Query query = (Query) session.createQuery("from User WHERE email = :email ");

		List<User> UsersList = query.list();

		for (User User : UsersList) {
			return User;
		}

		return null;
	}

	public boolean isDuplicateEntry(String email) {

		Resource r = new ClassPathResource("applicationContext.xml");
		BeanFactory factory = new XmlBeanFactory(r);
		UserDAO userDAO = (UserDAO) factory.getBean("UserDAO");

		User uti = userDAO.getUserByEmail(email);

		if (uti != null) {
			return true;
		} else {
			return false;
		}
	}

	public User addUser(SignUpDTO info) {

		User uti = new User();
		uti.setEmail(info.getEmail());
		uti.setPassword(info.getPassword());
		uti.setName(info.getName());
		uti.setUsername(info.getUsername());
		uti.setPhoneNumber(info.getPhoneNumber());

		return addUser(uti);
	}
	   
	public User createTeamsDTO(CreateTeamsDTO info)
	{
		  int teamID;
		  String teamName;
		  

		   Session session = this.sessionFactory.getCurrentSession();
			session.beginTransaction();

			Query query = (Query) session.createQuery("from User where employeeID = :employeeID");

			query.setParameter("employeeID", info.getEmployeeID());
			

			List<Employee> EmployeesList = query.list();

			for (Employee Employee : EmployeesList) {
				return employees;
			}

			return null;
		}
	Query query = (Query) session.createQuery("from User where managerID = :managerID");

	query.setParameter("managerID", info.getManagerID());
	

	List<Manager> ManagersList = query.list();

	for (Manager Manager : ManagersList) {
		return managers;
	}

	return null;
}
	
	 public Team(String teamName) {
	      this.teamName = teamName;
	      this.employees = new ArrayList<Employee>();
	      this.managers = new ArrayList<Managers>();
	   }

	   public String getteamName() {
	       return teamName;
	   }

	   public List<Employee> getEmployees() {
	       return employees;
	   }

			
    }
