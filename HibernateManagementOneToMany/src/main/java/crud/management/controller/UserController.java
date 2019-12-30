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
import crud.management.commons.UserInfo;


@RestController
@Path("/user")
public class UserController {
	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public UserInfo login(String json) {
		JSONObject jsonObj;
		System.out.println("am primit " + json);
		try {
			jsonObj = new JSONObject(json);
			String email = jsonObj.getString("email");
			String password = jsonObj.getString("password");

			ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
			UserManager manager = (UserManager) context.getBean("userManagerBean");

			return manager.login(email, password);
		} catch (Exception e) {
			System.out.println("exceptie " + e);
			return null;
		}
	}

	@POST
	@Path("/signup")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public UserInfo signup(String json) {
		JSONObject jsonObj;
		System.out.println("am primit " + json);
		try {
			jsonObj = new JSONObject(json);
			String email = jsonObj.getString("email");
			String password = jsonObj.getString("password");
			String name = jsonObj.getString("name");
			String phonenumber = jsonObj.getString("phonenumber");
		

			ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
			UserManager manager = (UserManager) context.getBean("userManagerBean");
			
            return manager.signUp(name, phonenumber, email, password);
		} catch (Exception e) {
			System.out.println("exceptie " + e);
			return null;
		}
	}
	@POST
	@Path("/password")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public UserInfo setPassword(String json) {
		JSONObject jsonObj;
		System.out.println("am primit " + json);
		try {
			jsonObj = new JSONObject(json);
			String email = jsonObj.getString("email");
			String oldPassword = jsonObj.getString("oldPassword");
			String newPassword = jsonObj.getString("newPassword");

			ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
			UserManager manager = (UserManager) context.getBean("userManagerBean");

			return manager.setPassword(email,newPassword,oldPassword);
		} catch (Exception e) {
			System.out.println("exceptie " + e);
			return null;
		}
	}

}
