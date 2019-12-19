package crud.management.persistence.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import crud.management.persistence.model.Utilizator;
import crud.management.commons.LoginDTO;
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

			if (utilizator.getEmail().contentEquals(email) && utilizator.getPassword().contentEquals(password)) {
				return utilizator;
			}
		}
		return null;
	}

	public Utilizator getUser(LoginDTO info) {
		
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();

		Query query = (Query) session.createQuery("from Utilizator WHERE email = :email and password = :pass");

		query.setParameter("email", info.getUsername());
		query.setParameter("pass", info.getPassword());
		
		List<Utilizator> utilizatoriList = query.list();
		
		for (Utilizator utilizator : utilizatoriList) {
				return utilizator;
		}
		
		return null;
	}
	
	/*public UtilizatorDTO  signupUtilizator(String nume, String companyName, String phoneNumber, String password)
	{
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		String Nume = sessionObj.getNume();
		 String email = sessionObj.getEmail();
		 String userName = sessionObj.getUserName();
		 String Password = sessionObj.getPassword();
		 String phonenumber = sessionObj.getPhonenumber();
		 
		
		 
		 try
		 {
		 con = DBConnection.createConnection();
		 String query = "insert into utilizatori(utilizatorID,nume,email,username,password, phoneNumber) values (?,?,?,?,?)"; //Insert user details into the table 'USERS'
		 preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
		 preparedStatement.setString(1, fullName);
		 preparedStatement.setString(2, email);
		 preparedStatement.setString(3, userName);
		 preparedStatement.setString(4, password);
		 
		 int i= preparedStatement.executeUpdate();
		 
		 if (i!=0)  //Just to ensure data has been inserted into the database
		 return "SUCCESS"; 
		 }
		 catch(SQLException e)
		 {
		 e.printStackTrace();
		 }
		 
		 return "Oops.. Something went wrong there..!";  // On failure, send a message from here.
		 }
		}
	}*/

}