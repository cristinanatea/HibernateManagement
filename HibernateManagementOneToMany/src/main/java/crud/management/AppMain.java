package crud.management;


import org.hibernate.Session;

import crud.management.persistence.model.Angajat;
import crud.management.persistence.model.Manager;
import crud.management.persistence.util.HibernateUtil;

public class AppMain {

	public static void main(String[] args) {
	
        System.out.println("Hibernate one to many (XML Mapping)");
	Session session = HibernateUtil.getSessionFactory().openSession();

	session.beginTransaction();

	Angajat angajat = new Angajat();
        angajat.setFunctieID(1);
        angajat.setProiectID(1);
        angajat.setDataAngajarii("1988-07-05");
        angajat.setNorma("8");
        angajat.setManagerID(1);
        angajat.setNume("Ionescu");
        angajat.setPrenume("Adriana");
        angajat.setAdresa("Ferdinand");
        angajat.setTelefon("0744609330");
        angajat.setNrZileConcediuMedicalLuat(0);
        angajat.setCnp("2889705345123");
        session.save(angajat);
        
        Manager manageri = new Manager();
        manageri.setNume(new String("Popescu"));
        manageri.setDataAngajarii("1988-07-05");
       
               
        angajat.getManageri().add(manageri);

        session.save(manageri);

	session.getTransaction().commit();
	System.out.println("Done");
	}
}