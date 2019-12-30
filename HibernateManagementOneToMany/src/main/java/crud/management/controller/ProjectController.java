package crud.management.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RestController;
import crud.management.business.UserManager;
import crud.management.commons.ProjectInfo;


@RestController
@Path("/project")
public class ProjectController {
	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ProjectInfo login(String json) {
		JSONObject jsonObj;
		System.out.println("am primit " + json);
		try {
			jsonObj = new JSONObject(json);
			String name = jsonObj.getString("name");
			int managerID = jsonObj.getInt("managerID");

			ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
			UserManager manager = (UserManager) context.getBean("userManagerBean");

			return manager.createProject(name, managerID);
		} catch (Exception e) {
			System.out.println("exceptie " + e);
			return null;
		}
	}

	@POST
	@Path("/asign")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ProjectInfo asignUserToProject(String json) {
		JSONObject jsonObj;
		System.out.println("am primit " + json);
		try {
			jsonObj = new JSONObject(json);
			int userID = jsonObj.getInt("userID");
			int projectID = jsonObj.getInt("projectID");

			ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
			UserManager manager = (UserManager) context.getBean("userManagerBean");

			return manager.asignUserToProject(userID, projectID);
		} catch (Exception e) {
			System.out.println("exceptie " + e);
			return null;
		}
	}

	
	
}
