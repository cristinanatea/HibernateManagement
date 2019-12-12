package crud.management.persistence.daoimpl;

import crud.management.persistence.dao.ProiectDAO;
import crud.management.persistence.dao.RequestStatus;
import crud.management.persistence.model.Proiect;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProiectDAOImpl implements ProiectDAO {

	private static final Logger logger = LoggerFactory.getLogger(ProiectDAOImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public RequestStatus addProiect(Proiect proiect) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(proiect);
		logger.info("Proiect saved successfully, Proiect Details=" + proiect);
		return new RequestStatus();
	}

	public RequestStatus updateProiect(Proiect proiect) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(proiect);
		logger.info("Proiect updated successfully, Proiect Details=" + proiect);
		return new RequestStatus();
	}

	@SuppressWarnings("unchecked")

	public List<Proiect> listProiecte() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Proiect> proiecteList = session.createQuery("from Proiect").list();
		for (Proiect proiect : proiecteList) {
			logger.info("Proiect List::" + proiect);
		}
		return proiecteList;
	}

	public Proiect getProiectById(int proiectID) {
		Session session = this.sessionFactory.getCurrentSession();
		Proiect proiect = (Proiect) session.load(Proiect.class, new Integer(proiectID));
		logger.info("Proiect loaded successfully, Proiect details=" + proiect);
		return proiect;
	}

	public RequestStatus removeProiect(int proiectID) {
		Session session = this.sessionFactory.getCurrentSession();
		Proiect proiect = (Proiect) session.load(Proiect.class, new Integer(proiectID));
		if (null != proiect) {
			session.delete(proiect);
		}
		logger.info("Angajat deleted successfully, angajat details=" + proiect);
		return new RequestStatus();
	}

}
