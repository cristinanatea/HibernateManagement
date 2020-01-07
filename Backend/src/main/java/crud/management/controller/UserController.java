package crud.management.controller;

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

import com.sample.commons.UserInfo;

import crud.management.business.UserManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@RestController
@Path("/user")
public class UserController {
	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public UserInfo login(String json, @Context HttpServletRequest req) {
		JSONObject jsonObj;
		System.out.println("am primit " + json);
		
		HttpSession session= req.getSession(true);
		
		try {
			jsonObj = new JSONObject(json);
			String email = jsonObj.getString("email");
			String password = jsonObj.getString("password");

			ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
			UserManager manager = (UserManager) context.getBean("userManagerBean");

			UserInfo userInfo = manager.login(email, password);
			
			if (userInfo != null)
			{
				System.out.println("User logged in: " + userInfo);
				session.setAttribute("userInfo", userInfo);
			}
			
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
