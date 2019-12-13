package crud.management.persistence.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import crud.management.persistence.model.Angajat;

import crud.management.persistence.dao.AngajatDAO;
import crud.management.persistence.dao.RequestStatus;

public class AngajatDAOImpl implements AngajatDAO {

	private static final Logger logger = LoggerFactory.getLogger(AngajatDAOImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public RequestStatus  addAngajat(Angajat angajat) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(angajat);
		logger.info("Person saved successfully, Person Details=" + angajat);
		return  new  RequestStatus() ;
			
	}

	public RequestStatus updateAngajat(Angajat angajat) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(angajat);
		logger.info("Angajat updated successfully, Angajat Details=" + angajat);
		return new RequestStatus();
	}

	@SuppressWarnings("unchecked")

	public List<Angajat> listAngajati() {
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		List<Angajat> angajatiList = session.createQuery("from Angajat").list();
		for (Angajat angajat : angajatiList) {
			logger.info("Person List::" + angajat);
		}
		return angajatiList;
	}

	public Angajat getAngajatById(int angajatID) {
		Session session = this.sessionFactory.getCurrentSession();
		Angajat angajat = (Angajat) session.load(Angajat.class, new Integer(angajatID));
		logger.info("Person loaded successfully, Person details=" + angajat);
		return angajat;
	}

	public RequestStatus removeAngajat(int angajatID) {
		Session session = this.sessionFactory.getCurrentSession();
		Angajat angajat = (Angajat) session.load(Angajat.class, new Integer(angajatID));
		if (null != angajat) {
			session.delete(angajat);
		}
		logger.info("Angajat deleted successfully, angajat details=" + angajat);
		return new RequestStatus();
	}
	
	public Angajat logincheck(String email, String password);

}
