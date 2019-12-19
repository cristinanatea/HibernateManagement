package crud.management;

import java.util.List;

import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import crud.management.businessimpl.UtilizatorManagerImpl;
import crud.management.commons.ProiectDTO;
import crud.management.commons.UtilizatorDTO;
import crud.management.persistence.dao.AngajatDAO;
import crud.management.persistence.dao.ManagerDAO;
import crud.management.persistence.dao.ProiectDAO;
import crud.management.persistence.dao.UtilizatorDAO;
import crud.management.persistence.model.Proiect;
import crud.management.persistence.model.Utilizator;
import crud.management.persistence.util.HibernateUtil;

public class AppMain {
/*
	public static void main(String[] args) {

		final ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		AngajatDAO angajatDao = appContext.getBean(AngajatDAO.class);
		ManagerDAO managerDao = appContext.getBean(ManagerDAO.class);
		ProiectDAO proiectDao = appContext.getBean(ProiectDAO.class);
		UtilizatorDAO utilizatorDao = appContext.getBean(UtilizatorDAO.class);

		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();
		
		
		System.out.println(utilizatorDao.loginUtilizator("cristina.natea4@gmail.com", "Ausy").toString());
	
		UtilizatorManagerImpl us = new UtilizatorManagerImpl();
		System.out.println(us.getUtilizatorById(1));
		session.getTransaction().commit();
		System.out.println("Done");
	}
	*/
	/*
		public UtilizatorDTOE getUtilizatori(String username)
		{
			UtilizatorDTOE utilizatorDTO = new UtilizatorDTOE();
			Utilizator utilizator1 = utilizatorDAO.getUtilizatorById();
			utilizatorDTO.setEmail(utilizator1.getEmail());
			return utilizatorDTO;
		}
		
		 public ProiectDTO getProiecte(String descriere)
		 {
			 ProiectDTO proiectDTO = new ProiectDTO();
			 Proiect proiect1 = proiectDAO.getProiectById();
			 proiectDTO.setCoordonatorID(proiect1.getCoordonatorID());
			 return proiectDTO;
		 }
		
		 public ManagerDTO getManagers(String nume )
		 {
			 ManagerDTO managerDTO = new ManagerDTO();
			 Manager manager1 = managerDAO.getManagerById();
			 managerDTO.setNume( manager1.getNume());
			 return managerDTO;
		 }
		*/

}

