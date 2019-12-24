package crud.management.persistence.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import crud.management.persistence.model.Employee;
import crud.management.persistence.dao.EmployeeDAO;
import crud.management.persistence.dao.RequestStatus;

public class EmployeeDAOImpl implements EmployeeDAO {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeDAOImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public RequestStatus addEmployee(Employee Employee) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(Employee);
		logger.info("Person saved successfully, Person Details=" + Employee);
		return new RequestStatus();

	}

	public RequestStatus updateEmployee(Employee Employee) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(Employee);
		logger.info("Employee updated successfully, Employee Details=" + Employee);
		return new RequestStatus();
	}

	@SuppressWarnings("unchecked")

	public List<Employee> listEmployees() {
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();

		List<Employee> EmployeesList = session.createQuery("from Employee").list();
		for (Employee Employee : EmployeesList) {
			logger.info("Person List::" + Employee);
		}
		return EmployeesList;
	}

	public Employee getEmployeeById(int EmployeeID) {
		Session session = this.sessionFactory.getCurrentSession();
		Employee Employee = (Employee) session.load(Employee.class, new Integer(EmployeeID));
		logger.info("Person loaded successfully, Person details=" + Employee);
		return Employee;
	}

	public RequestStatus removeEmployee(int EmployeeID) {
		Session session = this.sessionFactory.getCurrentSession();
		Employee Employee = (Employee) session.load(Employee.class, new Integer(EmployeeID));
		if (null != Employee) {
			session.delete(Employee);
		}
		logger.info("Employee deleted successfully, Employee details=" + Employee);
		return new RequestStatus();
	}

}