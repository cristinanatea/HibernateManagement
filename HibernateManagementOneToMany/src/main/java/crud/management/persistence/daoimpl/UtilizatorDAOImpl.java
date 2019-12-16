package crud.management.persistence.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import crud.management.persistence.model.Angajat;
import crud.management.persistence.model.Utilizator;
import crud.management.persistence.dao.AngajatDAO;
import crud.management.persistence.dao.RequestStatus;
import crud.management.persistence.dao.UtilizatorDAO;

public class UtilizatorDAOImpl implements UtilizatorDAO {

	private static final Logger logger = LoggerFactory.getLogger(AngajatDAOImpl.class);

	static Session sessionObj;

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;

	}

	public RequestStatus addUtilizator(Utilizator utilizator) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(utilizator);
		logger.info("Person saved successfully, Person Details=" + utilizator);
		return new RequestStatus();

	}

	public RequestStatus updateUtilizator(Utilizator utilizator) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(utilizator);
		logger.info("Utilizator updated successfully, Utilizator Details=" + utilizator);
		return new RequestStatus();
	}

	@SuppressWarnings("unchecked")

	public List<Utilizator> listUtilizatori() {
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();

		List<Utilizator> utilizatoriList = session.createQuery("from Utilizator").list();
		for (Utilizator utilizator : utilizatoriList) {
			logger.info("Person List::" + utilizator);
		}
		return utilizatoriList;
	}

	public Utilizator getUtilizatorById(int utilizatorID) {
		Session session = this.sessionFactory.getCurrentSession();
		Utilizator utilizator = (Utilizator) session.load(Utilizator.class, new Integer(utilizatorID));
		logger.info("Person loaded successfully, Person details=" + utilizator);
		return utilizator;
	}

	public RequestStatus removeUtilizator(int utilizatorID) {
		Session session = this.sessionFactory.getCurrentSession();
		Utilizator utilizator = (Utilizator) session.load(Utilizator.class, new Integer(utilizatorID));
		if (null != utilizator) {
			session.delete(utilizator);
		}
		logger.info("Angajat deleted successfully, angajat details=" + utilizator);
		return new RequestStatus();
	}

	public Utilizator loginUtilizator(String email, String password) {
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();

		List<Utilizator> utilizatoriList = session.createQuery("from Utilizator").list();
		for (Utilizator utilizator : utilizatoriList) {
			
			if (utilizator.getEmail().contentEquals(email) && utilizator.getPassword().contentEquals(password))
			{
				return utilizator;
			}
		}
		
		return null;
	}
	
}