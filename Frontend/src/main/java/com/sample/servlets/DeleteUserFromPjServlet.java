package com.sample.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.map.ObjectMapper;

import com.sample.commons.DeleteUserDTO;
import com.sample.commons.DeleteUserFromPjDTO;
import com.sample.commons.LoginDTO;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

@WebServlet("/deleteUserFromProject")
public class DeleteUserFromPjServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String projectName = request.getParameter("projectName");
		HttpSession session = request.getSession();

		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/HibernateManagement/rest/user/deleteUserFromProject");
	
		DeleteUserFromPjDTO deleteUserInfo = new DeleteUserFromPjDTO();
		deleteUserInfo.setName(name);
		deleteUserInfo.setProjectName(projectName);
		
		ObjectMapper mapper = new ObjectMapper();
		// Java object to JSON string
		String jsonString = mapper.writeValueAsString(deleteUserInfo);

		ClientResponse status = webResource.type(MediaType.APPLICATION_JSON_TYPE).delete(ClientResponse.class,jsonString);

		if (status.getStatus() != 200) {
			System.out.println("Error on backend" + response.getStatus());
		} else {
			request.getRequestDispatcher("/listusers").forward(request, response);
		}
	}
}

