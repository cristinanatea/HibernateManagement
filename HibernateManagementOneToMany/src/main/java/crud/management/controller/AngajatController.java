package crud.management.controller;


import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.Session;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.RestController;

import crud.management.persistence.model.Angajat;
import crud.management.persistence.util.HibernateUtil;
import crud.management.persistence.dao.AngajatDAO;

@RestController
@Path("/users")
public class AngajatController {
		
	   /*---get all angajati---*/
		@GET
		@Path("/list")
		@Produces(MediaType.APPLICATION_JSON)
	   public List<Angajat> listUsers() {
		    Resource r=new ClassPathResource("applicationContext.xml");  
		    BeanFactory factory=new XmlBeanFactory(r);  
		      
		    AngajatDAO angajatDao=(AngajatDAO)factory.getBean("angajatDAO");  
		    
	      return angajatDao.listAngajati();
	   }
/*
		@GET
		@Path("/get3/{alternativ}")
		@Produces(MediaType.APPLICATION_JSON)
	   public SomeResponse de_sters_la_un_moment_dat(@PathParam("alternativ") String alternativ) {
	      return new SomeResponse(alternativ);
	   }
*/
}
