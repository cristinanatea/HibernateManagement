package crud.management.persistence.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import crud.management.persistence.model.Manager;
import crud.management.persistence.dao.ManagerDAO;
import crud.management.persistence.dao.RequestStatus;


public class ManagerDAOImpl implements ManagerDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(ManagerDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	
	public RequestStatus addManager(Manager manager) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(manager);
		logger.info("Manager saved successfully, Manager Details="+manager);
		return  new  RequestStatus() ;
	}

	
	public RequestStatus updateManager(Manager manager) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(manager);
		logger.info("Manager updated successfully, Manager Details="+manager);
		return  new  RequestStatus() ;
	}

	@SuppressWarnings("unchecked")
	
	public List<Manager> listManagers() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Manager> manageriList = session.createQuery("from Manager").list();
		for(Manager manager : manageriList){
			logger.info("Manager List::"+manager);
		}
		return manageriList;
	}

	
	public Manager getManagerById(int managerID) {
		Session session = this.sessionFactory.getCurrentSession();		
		Manager manager = (Manager) session.load(Manager.class, new Integer(managerID));
		logger.info("Manager loaded successfully, Manager details="+manager);
		return manager;
	}

	
	public RequestStatus removeManager(int managerID) {
		Session session = this.sessionFactory.getCurrentSession();
		Manager manager = (Manager) session.load(Manager.class, new Integer(managerID));
		if(null != manager){
			session.delete(manager);
		}
		logger.info("Angajat deleted successfully, angajat details="+manager);
		return  new  RequestStatus() ;
	}


	

}
