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

import crud.management.persistence.model.Employee;
import crud.management.persistence.util.HibernateUtil;
import crud.management.persistence.dao.EmployeeDAO;
import crud.management.persistence.dao.RequestStatus;

@RestController
@Path("/users")
public class EmployeeController {
	Resource r = new ClassPathResource("applicationContext.xml");
	BeanFactory factory = new XmlBeanFactory(r);
	/*---get all Employees---*/
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employee> listUsers() {
		

		EmployeeDAO EmployeeDao = (EmployeeDAO) factory.getBean("EmployeeDAO");

		return EmployeeDao.listEmployees();
	}

	/*---get a book by ID---*/
	@GET
	@Path("/Employee/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Employee get(@PathVariable("id") int EmployeeID) {
		Resource r = new ClassPathResource("applicationContext.xml");
		BeanFactory factory = new XmlBeanFactory(r);

		EmployeeDAO EmployeeDao = (EmployeeDAO) factory.getBean("EmployeeDAO");

		return EmployeeDao.getEmployeeById(EmployeeID);
	}

	/*---add a new Employee---*/
	@POST
	@Path("/Employee")
	@Consumes(MediaType.APPLICATION_JSON)
	public RequestStatus save(@RequestBody Employee Employee) {
		Resource r = new ClassPathResource("applicationContext.xml");
		BeanFactory factory = new XmlBeanFactory(r);
		EmployeeDAO EmployeeDao = (EmployeeDAO) factory.getBean("EmployeeDAO");
		return EmployeeDao.addEmployee(Employee);
	}

	/*---update an Employee by id---*/
	@PUT
	@Path("/update/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public RequestStatus update(@RequestBody Employee Employee) {
		Resource r = new ClassPathResource("applicationContext.xml");
		BeanFactory factory = new XmlBeanFactory(r);
		EmployeeDAO EmployeeDao = (EmployeeDAO) factory.getBean("EmployeeDAO");
		return EmployeeDao.updateEmployee(Employee);
	}
	
	/*---delete an Employee by id---*/
	@DELETE
	@Path("/delete/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public RequestStatus delete(@RequestBody int EmployeeID) {
		Resource r = new ClassPathResource("applicationContext.xml");
		BeanFactory factory = new XmlBeanFactory(r);
		EmployeeDAO EmployeeDao = (EmployeeDAO) factory.getBean("EmployeeDAO");
		return EmployeeDao.removeEmployee(EmployeeID);
	}
	
}
