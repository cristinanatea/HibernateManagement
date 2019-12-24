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
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import crud.management.business.UserManager;
import crud.management.commons.CreateTeamsDTO;
import crud.management.commons.LoginDTO;
import crud.management.commons.SignUpDTO;
import crud.management.commons.UserDTO;
import crud.management.persistence.dao.EmployeeDAO;
import crud.management.persistence.dao.RequestStatus;
import crud.management.persistence.dao.UserDAO;
import crud.management.persistence.model.Employee;
import crud.management.persistence.model.User;

@RestController
@Path("/User")
public class UserController {
	/*---get all Users---*/
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> listUsers() {
		Resource r = new ClassPathResource("applicationContext.xml");
		BeanFactory factory = new XmlBeanFactory(r);

		UserDAO UserDao = (UserDAO) factory.getBean("UserDAO");

		return UserDao.listUsers();
	}

	/*---get a User by ID---*/
	@GET
	@Path("/User/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public User get(@PathVariable("id") int UserID) {
		Resource r = new ClassPathResource("applicationContext.xml");
		BeanFactory factory = new XmlBeanFactory(r);

		UserDAO UserDao = (UserDAO) factory.getBean("UserDAO");

		return UserDao.getUserById(UserID);
	}

	/*---add a new User---*/
	@POST
	@Path("/User")
	@Consumes(MediaType.APPLICATION_JSON)
	public User save(@RequestBody User User) {
		Resource r = new ClassPathResource("applicationContext.xml");
		BeanFactory factory = new XmlBeanFactory(r);
		UserDAO UserDao = (UserDAO) factory.getBean("UserDAO");
		return UserDao.addUser(User);
	}

	/*---update an User by id---*/
	@PUT
	@Path("/update/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public RequestStatus update(@RequestBody User User) {
		Resource r = new ClassPathResource("applicationContext.xml");
		BeanFactory factory = new XmlBeanFactory(r);
		UserDAO UserDao = (UserDAO) factory.getBean("UserDAO");
		return UserDao.updateUser(User);
	}

	/*---delete an User by id---*/
	@DELETE
	@Path("/delete/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public RequestStatus delete(@RequestBody int UsersD) {
		Resource r = new ClassPathResource("applicationContext.xml");
		BeanFactory factory = new XmlBeanFactory(r);
		UserDAO UserDao = (UserDAO) factory.getBean("UserDAO");
		return UserDao.removeUser(UsersD);
	}

	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public UserDTO login(String json) {
		JSONObject jsonObj;
		System.out.println("am primit " + json);
		try {
			jsonObj = new JSONObject(json);
			String email = jsonObj.getString("email");
			String password = jsonObj.getString("password");

			LoginDTO loginInfo = new LoginDTO(email, password);

			Resource r = new ClassPathResource("applicationContext.xml");
			BeanFactory factory = new XmlBeanFactory(r);
			UserManager userManagement = (UserManager) factory.getBean("userManagement");

			UserDTO response = userManagement.getUserInfo(loginInfo);
			System.out.println("am gasit  " + response);

			return response;
		} catch (Exception e) {
			System.out.println("exceptie " + e);
			return null;
		}
	}

	@POST
	@Path("/signup")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public UserDTO signup(String json) {
		JSONObject jsonObj;
		System.out.println("am primit " + json);
		try {
			jsonObj = new JSONObject(json);
			String email = jsonObj.getString("email");
			String password = jsonObj.getString("password");
			String name = jsonObj.getString("name");
			String phonenumber = jsonObj.getString("phonenumber");
			String username = jsonObj.getString("username");

			SignUpDTO SignUpinfo = new SignUpDTO(name,phonenumber, username, password, email);

			Resource r = new ClassPathResource("applicationContext.xml");
			BeanFactory factory = new XmlBeanFactory(r);
			UserManager signManagement = (UserManager) factory.getBean("signManagement");

			UserDTO response = signManagement.addUser(SignUpinfo);
			System.out.println("am creat  " + response);

			return response;
		} catch (Exception e) {
			System.out.println("exceptie " + e);
			return null;
		}
	}
	@
	@Path("/createTeams")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public UserDTO CreateTeams(String json) {
		JSONObject jsonObj;
		System.out.println("am primit " + json);
		try {
			jsonObj = new JSONObject(json);
		    int teamID = jsonObj.getInt("teamID");
			String teamName = jsonObj.getString("teamName");
			
			CreateTeamsDTO CreateTeamsinfo = new CreateTeamsDTO(teamID, teamName);

			Resource r = new ClassPathResource("applicationContext.xml");
			BeanFactory factory = new XmlBeanFactory(r);
			UserManager signCreate = (UserManager) factory.getBean("signCreate");

			UserDTO response = signCreate.addEmployee(CreateTeams info);
			System.out.println("am creat  " + response);
			
			UserDTO response = signCreate.addManager(CreateTeams info);
			System.out.println("am creat  " + response);
			
		
            
		} catch (Exception e) {
			System.out.println("exceptie " + e);
			return null;
		}
	}

}
