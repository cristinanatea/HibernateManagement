package crud.management.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RestController;

import com.sample.commons.ProjectInfo;
import com.sample.commons.UserInfo;

import crud.management.business.UserManager;


@RestController
@Path("/project")
public class ProjectController {
	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ProjectInfo create(String json, @Context HttpServletRequest req) {
		JSONObject jsonObj;
		System.out.println("am primit " + json);
		try {
			HttpSession session= req.getSession(true);
		
			UserInfo userInfo = (UserInfo)session.getAttribute("userInfo");
			if (userInfo == null) 
			{
				ProjectInfo z = new ProjectInfo();
				z.setStatus("You must be logged in!");
				return z; 
			}
			else if (userInfo.getAcces() == 0)
			{
				ProjectInfo z = new ProjectInfo();
				z.setStatus("No rights!");
				return z; 
			} else {
				System.out.println("Utilizatorul curent: " + userInfo);
				
				jsonObj = new JSONObject(json);
				String name = jsonObj.getString("name");
				String managerEmail = jsonObj.getString("managerEmail");

				ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
				UserManager manager = (UserManager) context.getBean("userManagerBean");

				return manager.createProject(name, managerEmail);
			}
			
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
			String userEmail = jsonObj.getString("userEmail");
			String projectName = jsonObj.getString("projectName");

			ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
			UserManager manager = (UserManager) context.getBean("userManagerBean");

			return manager.asignUserToProject(userEmail, projectName);
		} catch (Exception e) {
			System.out.println("exceptie " + e);
			return null;
		}
	}

	
	
}
