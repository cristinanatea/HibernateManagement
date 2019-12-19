package crud.management.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONObject;
import org.hibernate.Session;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import crud.management.persistence.model.Angajat;
import crud.management.persistence.util.HibernateUtil;
import crud.management.persistence.dao.AngajatDAO;
import crud.management.persistence.dao.RequestStatus;

@RestController
@Path("/users")
public class AngajatController {
	Resource r = new ClassPathResource("applicationContext.xml");
	BeanFactory factory = new XmlBeanFactory(r);
	/*---get all angajati---*/
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Angajat> listUsers() {
		

		AngajatDAO angajatDao = (AngajatDAO) factory.getBean("angajatDAO");

		return angajatDao.listAngajati();
	}

	/*---get a book by ID---*/
	@GET
	@Path("/angajat/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Angajat get(@PathVariable("id") int angajatID) {
		Resource r = new ClassPathResource("applicationContext.xml");
		BeanFactory factory = new XmlBeanFactory(r);

		AngajatDAO angajatDao = (AngajatDAO) factory.getBean("angajatDAO");

		return angajatDao.getAngajatById(angajatID);
	}

	/*---add a new angajat---*/
	@POST
	@Path("/angajat")
	@Consumes(MediaType.APPLICATION_JSON)
	public RequestStatus save(@RequestBody Angajat angajat) {
		Resource r = new ClassPathResource("applicationContext.xml");
		BeanFactory factory = new XmlBeanFactory(r);
		AngajatDAO angajatDao = (AngajatDAO) factory.getBean("angajatDAO");
		return angajatDao.addAngajat(angajat);
	}

	/*---update an angajat by id---*/
	@PUT
	@Path("/update/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public RequestStatus update(@RequestBody Angajat angajat) {
		Resource r = new ClassPathResource("applicationContext.xml");
		BeanFactory factory = new XmlBeanFactory(r);
		AngajatDAO angajatDao = (AngajatDAO) factory.getBean("angajatDAO");
		return angajatDao.updateAngajat(angajat);
	}
	
	/*---delete an angajat by id---*/
	@DELETE
	@Path("/delete/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public RequestStatus delete(@RequestBody int angajatID) {
		Resource r = new ClassPathResource("applicationContext.xml");
		BeanFactory factory = new XmlBeanFactory(r);
		AngajatDAO angajatDao = (AngajatDAO) factory.getBean("angajatDAO");
		return angajatDao.removeAngajat(angajatID);
	}
	
}
