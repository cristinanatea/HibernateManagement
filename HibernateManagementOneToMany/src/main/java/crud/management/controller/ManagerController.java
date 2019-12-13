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

import crud.management.persistence.model.Manager;
import crud.management.persistence.util.HibernateUtil;
import crud.management.persistence.dao.ManagerDAO;
import crud.management.persistence.dao.RequestStatus;

@RestController
@Path("/manageri")
public class ManagerController {

	/*---get all manageri---*/
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Manager> listUsers() {
		Resource r = new ClassPathResource("applicationContext.xml");
		BeanFactory factory = new XmlBeanFactory(r);

		ManagerDAO managerDao = (ManagerDAO) factory.getBean("managerDAO");

		return managerDao.listManageri();
	}

	/*---get a manager by ID---*/
	@GET
	@Path("/manager/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Manager get(@PathVariable("id") int managerID) {
		Resource r = new ClassPathResource("applicationContext.xml");
		BeanFactory factory = new XmlBeanFactory(r);

		ManagerDAO managerDao = (ManagerDAO) factory.getBean("managerDAO");

		return managerDao.getManagerById(managerID);
	}

	/*---add a new manager---*/
	@POST
	@Path("/manager")
	@Consumes(MediaType.APPLICATION_JSON)
	public RequestStatus save(@RequestBody Manager manager) {
		Resource r = new ClassPathResource("applicationContext.xml");
		BeanFactory factory = new XmlBeanFactory(r);
		ManagerDAO managerDao = (ManagerDAO) factory.getBean("managerDAO");
		return managerDao.addManager(manager);
	}

	/*---update an manager by id---*/
	@PUT
	@Path("/update/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public RequestStatus update(@RequestBody Manager manager) {
		Resource r = new ClassPathResource("applicationContext.xml");
		BeanFactory factory = new XmlBeanFactory(r);
		ManagerDAO managerDao = (ManagerDAO) factory.getBean("managerDAO");
		return managerDao.updateManager(manager);
	}
	
	/*---delete an manager by id---*/
	@DELETE
	@Path("/delete/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public RequestStatus delete(@RequestBody int managerID) {
		Resource r = new ClassPathResource("applicationContext.xml");
		BeanFactory factory = new XmlBeanFactory(r);
		ManagerDAO managerDao = (ManagerDAO) factory.getBean("managerDAO");
		return managerDao.removeManager(managerID);
	}
	
}

