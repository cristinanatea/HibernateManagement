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

import crud.management.business.UtilizatorManager;
import crud.management.commons.LoginDTO;
import crud.management.commons.SignUpDTO;
import crud.management.commons.UtilizatorDTO;
import crud.management.persistence.dao.AngajatDAO;
import crud.management.persistence.dao.RequestStatus;
import crud.management.persistence.dao.UtilizatorDAO;
import crud.management.persistence.model.Angajat;
import crud.management.persistence.model.Utilizator;

@RestController
@Path("/utilizator")
public class UtilizatorController {
	/*---get all utilizatori---*/
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Utilizator> listUtilizatori() {
		Resource r = new ClassPathResource("applicationContext.xml");
		BeanFactory factory = new XmlBeanFactory(r);

		UtilizatorDAO utilizatorDao = (UtilizatorDAO) factory.getBean("utilizatorDAO");

		return utilizatorDao.listUtilizatori();
	}

	/*---get a utilizator by ID---*/
	@GET
	@Path("/utilizator/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Utilizator get(@PathVariable("id") int utilizatorID) {
		Resource r = new ClassPathResource("applicationContext.xml");
		BeanFactory factory = new XmlBeanFactory(r);

		UtilizatorDAO utilizatorDao = (UtilizatorDAO) factory.getBean("utilizatorDAO");

		return utilizatorDao.getUtilizatorById(utilizatorID);
	}

	/*---add a new utilizator---*/
	@POST
	@Path("/utilizator")
	@Consumes(MediaType.APPLICATION_JSON)
	public Utilizator save(@RequestBody Utilizator utilizator) {
		Resource r = new ClassPathResource("applicationContext.xml");
		BeanFactory factory = new XmlBeanFactory(r);
		UtilizatorDAO utilizatorDao = (UtilizatorDAO) factory.getBean("utilizatorDAO");
		return utilizatorDao.addUtilizator(utilizator);
	}

	/*---update an utilizator by id---*/
	@PUT
	@Path("/update/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public RequestStatus update(@RequestBody Utilizator utilizator) {
		Resource r = new ClassPathResource("applicationContext.xml");
		BeanFactory factory = new XmlBeanFactory(r);
		UtilizatorDAO utilizatorDao = (UtilizatorDAO) factory.getBean("utilizatorDAO");
		return utilizatorDao.updateUtilizator(utilizator);
	}

	/*---delete an utilizator by id---*/
	@DELETE
	@Path("/delete/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public RequestStatus delete(@RequestBody int utilizatorID) {
		Resource r = new ClassPathResource("applicationContext.xml");
		BeanFactory factory = new XmlBeanFactory(r);
		UtilizatorDAO utilizatorDao = (UtilizatorDAO) factory.getBean("utilizatorDAO");
		return utilizatorDao.removeUtilizator(utilizatorID);
	}

	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public UtilizatorDTO login(String json) {
		JSONObject jsonObj;
		System.out.println("am primit " + json);
		try {
			jsonObj = new JSONObject(json);
			String email = jsonObj.getString("email");
			String password = jsonObj.getString("password");

			LoginDTO loginInfo = new LoginDTO(email, password);

			Resource r = new ClassPathResource("applicationContext.xml");
			BeanFactory factory = new XmlBeanFactory(r);
			UtilizatorManager userManagement = (UtilizatorManager) factory.getBean("userManagement");

			UtilizatorDTO response = userManagement.getUserInfo(loginInfo);
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
	public UtilizatorDTO signup(String json) {
		JSONObject jsonObj;
		System.out.println("am primit " + json);
		try {
			jsonObj = new JSONObject(json);
			String email = jsonObj.getString("email");
			String password = jsonObj.getString("password");
			String nume = jsonObj.getString("nume");
			String phonenumber = jsonObj.getString("phonenumber");
			String username = jsonObj.getString("username");

			SignUpDTO SignUpinfo = new SignUpDTO( username, nume, phonenumber, email, password);

			Resource r = new ClassPathResource("applicationContext.xml");
			BeanFactory factory = new XmlBeanFactory(r);
			UtilizatorManager signManagement = (UtilizatorManager) factory.getBean("signManagement");

			UtilizatorDTO response = signManagement.addUtilizator(SignUpinfo);
			System.out.println("am creat  " + response);

			return response;
		} catch (Exception e) {
			System.out.println("exceptie " + e);
			return null;
		}
	}

}
