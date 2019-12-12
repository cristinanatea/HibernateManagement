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

import org.hibernate.Session;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import crud.management.persistence.model.Proiect;
import crud.management.persistence.dao.ProiectDAO;
import crud.management.persistence.dao.RequestStatus;

@RestController
@Path("/proiect")
public class ProiectController {

	/*---get all projects---*/
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Proiect> listUsers() {
		Resource r = new ClassPathResource("applicationContext.xml");
		BeanFactory factory = new XmlBeanFactory(r);

		ProiectDAO proiectDao = (ProiectDAO) factory.getBean("proiectDAO");

		return proiectDao.listProiecte();
	}

	/*---get a project by ID---*/
	@GET
	@Path("/proiect/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Proiect get(@PathVariable("id") int proiectID) {
		Resource r = new ClassPathResource("applicationContext.xml");
		BeanFactory factory = new XmlBeanFactory(r);

		ProiectDAO proiectDao = (ProiectDAO) factory.getBean("proiectDAO");

		return proiectDao.getProiectById(proiectID);
	}

	/*---add a new project---*/
	@POST
	@Path("/proiect")
	@Consumes(MediaType.APPLICATION_JSON)
	public RequestStatus save(@RequestBody Proiect proiect) {
		Resource r = new ClassPathResource("applicationContext.xml");
		BeanFactory factory = new XmlBeanFactory(r);
		ProiectDAO proiectDao = (ProiectDAO) factory.getBean("proiectDAO");
		return proiectDao.addProiect(proiect);
	}

	/*---update an project by id---*/
	@PUT
	@Path("/proiect/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public RequestStatus update(@RequestBody Proiect proiect) {
		Resource r = new ClassPathResource("applicationContext.xml");
		BeanFactory factory = new XmlBeanFactory(r);
		ProiectDAO proiectDao = (ProiectDAO) factory.getBean("proiectDAO");
		return proiectDao.updateProiect(proiect);
	}

	/*---delete an project by id---*/
	@DELETE
	@Path("/proiect/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public RequestStatus delete(@RequestBody int proiectID) {
		Resource r = new ClassPathResource("applicationContext.xml");
		BeanFactory factory = new XmlBeanFactory(r);
		ProiectDAO proiectDao = (ProiectDAO) factory.getBean("proiectDAO");
		return proiectDao.removeProiect(proiectID);
	}

}
