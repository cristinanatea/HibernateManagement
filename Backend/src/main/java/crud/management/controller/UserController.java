package crud.management.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RestController;

import com.sample.commons.UserInfo;

import crud.management.business.UserManager;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

@RestController
@Path("/user")
public class UserController {
	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public UserInfo login(String json, @Context HttpServletRequest req) {
		JSONObject jsonObj;
		System.out.println("login: am primit " + json);

//		HttpSession session = req.getSession(true);

		try {
			jsonObj = new JSONObject(json);
			String email = jsonObj.getString("email");
			String password = jsonObj.getString("password");

			ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
			UserManager manager = (UserManager) context.getBean("userManagerBean");

			UserInfo userInfo = manager.login(email, password);
/*
			if (userInfo != null) {
				System.out.println("User logged in: " + userInfo);
				session.setAttribute("userInfo", userInfo);
			}
*/
			return userInfo;
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
		System.out.println("signup: am primit " + json);
		try {
			jsonObj = new JSONObject(json);
			String email = jsonObj.getString("email");
			String password = jsonObj.getString("password");
			String name = jsonObj.getString("name");
			String phoneNumber = jsonObj.getString("phoneNumber");
			String company = jsonObj.getString("company");

			ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
			UserManager manager = (UserManager) context.getBean("userManagerBean");

			return manager.signUp(name, phoneNumber, email, password, company);
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
		System.out.println("setPassword: am primit " + json);
		try {
			jsonObj = new JSONObject(json);
			String email = jsonObj.getString("email");
			String oldPassword = jsonObj.getString("oldPassword");
			String newPassword = jsonObj.getString("newPassword");

			ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
			UserManager manager = (UserManager) context.getBean("userManagerBean");

			return manager.setPassword(email, newPassword, oldPassword);
		} catch (Exception e) {
			System.out.println("exceptie " + e);
			return null;
		}
	}

	@POST
	@Path("/listusers")
	@Produces(MediaType.APPLICATION_JSON)
	public List<UserInfo> listUsers() {
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
			UserManager manager = (UserManager) context.getBean("userManagerBean");

			return manager.listUsers();
		} catch (Exception e) {
			System.out.println("exceptie " + e);
			return null;
		}
	}
	@DELETE
	@Path("/deleteUser")

	@Produces(MediaType.APPLICATION_JSON)
	public boolean deleteUser(String json) {
		JSONObject jsonObj;
		System.out.println("deleteUser: am primit " + json);
		
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
			UserManager manager = (UserManager) context.getBean("userManagerBean");
			
			jsonObj = new JSONObject(json);
			String name = jsonObj.getString("name"); 
			
			return manager.deleteUser(name);
		} catch (Exception e) {
			System.out.println("exceptie " + e);
			return false;
		}
	}
	

}
