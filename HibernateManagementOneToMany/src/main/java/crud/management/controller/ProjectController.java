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

import crud.management.persistence.model.Project;
import crud.management.persistence.dao.ProjectDAO;
import crud.management.persistence.dao.RequestStatus;

@RestController
@Path("/Project")
public class ProjectController {

	/*---get all projects---*/
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Project> listUsers() {
		Resource r = new ClassPathResource("applicationContext.xml");
		BeanFactory factory = new XmlBeanFactory(r);

		ProjectDAO ProjectDao = (ProjectDAO) factory.getBean("ProjectDAO");

		return ProjectDao.listProjects();
	}

	/*---get a project by ID---*/
	@GET
	@Path("/Project/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Project get(@PathVariable("id") int ProjectID) {
		Resource r = new ClassPathResource("applicationContext.xml");
		BeanFactory factory = new XmlBeanFactory(r);

		ProjectDAO ProjectDao = (ProjectDAO) factory.getBean("ProjectDAO");

		return ProjectDao.getProjectById(ProjectID);
	}

	/*---add a new project---*/
	@POST
	@Path("/Project")
	@Consumes(MediaType.APPLICATION_JSON)
	public RequestStatus save(@RequestBody Project Project) {
		Resource r = new ClassPathResource("applicationContext.xml");
		BeanFactory factory = new XmlBeanFactory(r);
		ProjectDAO ProjectDao = (ProjectDAO) factory.getBean("ProjectDAO");
		return ProjectDao.addProject(Project);
	}

	/*---update an project by id---*/
	@PUT
	@Path("/update/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public RequestStatus update(@RequestBody Project Project) {
		Resource r = new ClassPathResource("applicationContext.xml");
		BeanFactory factory = new XmlBeanFactory(r);
		ProjectDAO ProjectDao = (ProjectDAO) factory.getBean("ProjectDAO");
		return ProjectDao.updateProject(Project);
	}

	/*---delete an project by id---*/
	@DELETE
	@Path("/delete/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public RequestStatus delete(@RequestBody int ProjectID) {
		Resource r = new ClassPathResource("applicationContext.xml");
		BeanFactory factory = new XmlBeanFactory(r);
		ProjectDAO ProjectDao = (ProjectDAO) factory.getBean("ProjectDAO");
		return ProjectDao.removeProject(ProjectID);
	}

}
