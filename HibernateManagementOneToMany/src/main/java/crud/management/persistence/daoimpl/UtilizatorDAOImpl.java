package crud.management.persistence.daoimpl;

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

import crud.management.persistence.model.Utilizator;
import crud.management.commons.LoginDTO;
import crud.management.commons.SignUpDTO;
import crud.management.commons.UtilizatorDTO;
import crud.management.commons.createTeamsDTO;
import crud.management.persistence.dao.RequestStatus;
import crud.management.persistence.dao.UtilizatorDAO;

public class UtilizatorDAOImpl implements UtilizatorDAO {

	private static final Logger logger = LoggerFactory.getLogger(AngajatDAOImpl.class);

	static Session sessionObj;

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;

	}

	public Utilizator addUtilizator(Utilizator utilizator) {
		Session session = this.sessionFactory.getCurrentSession();
		Transaction tx1 = session.beginTransaction();
		session.saveOrUpdate(utilizator);
		tx1.commit();
		logger.info("Utilizator saved successfully, Utilizator Details=" + utilizator);
		return utilizator;
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

			if (utilizator.getEmail().contentEquals(email) && utilizator.getPassword().contentEquals(password)) {
				return utilizator;
			}
		}
		return null;
	}

	public Utilizator getUser(LoginDTO info) {

		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();

		Query query = (Query) session.createQuery("from Utilizator where email = :email and password = :pass");

		query.setParameter("email", info.getUsername());
		query.setParameter("pass", info.getPassword());

		List<Utilizator> utilizatoriList = query.list();

		for (Utilizator utilizator : utilizatoriList) {
			return utilizator;
		}

		return null;
	}

	public Utilizator getUserByEmail(String email) {

		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();

		Query query = (Query) session.createQuery("from Utilizator WHERE email = :email ");

		List<Utilizator> utilizatoriList = query.list();

		for (Utilizator utilizator : utilizatoriList) {
			return utilizator;
		}

		return null;
	}

	public boolean isDuplicateEntry(String email) {

		Resource r = new ClassPathResource("applicationContext.xml");
		BeanFactory factory = new XmlBeanFactory(r);
		UtilizatorDAO userDAO = (UtilizatorDAO) factory.getBean("utilizatorDAO");

		Utilizator uti = userDAO.getUserByEmail(email);

		if (uti != null) {
			return true;
		} else {
			return false;
		}
	}

	public Utilizator addUtilizator(SignUpDTO info) {

		Utilizator uti = new Utilizator();
		uti.setEmail(info.getEmail());
		uti.setPassword(info.getPassword());
		uti.setNume(info.getNume());
		uti.setUsername(info.getUsername());
		uti.setPhonenumber(info.getPhonenumber());

		return addUtilizator(uti);
	}
	
	public Utilizator createTeamsDTO(createTeamsDTO info)
	{
		int teamID;
		 String teamName = UserInput.readString();
		  int team = new Team(teamName);
			
    }
}