package crud.management;



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

