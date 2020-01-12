package com.sample.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.map.ObjectMapper;

import com.sample.commons.CreateProjectDTO;
import com.sample.commons.ProjectInfo;
import com.sample.commons.SignUpDTO;
import com.sample.commons.UserInfo;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

@WebServlet("/deleteProject")
public class DeleteProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");

		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/HibernateManagement/rest/project/delete");


		ObjectMapper mapper = new ObjectMapper();
		// Java object to JSON string
		String jsonString = "{'projectName': '"+name +"'}";

		ClientResponse status = webResource.type(MediaType.APPLICATION_JSON_TYPE).delete(ClientResponse.class,jsonString);

		if (status.getStatus() != 200) {
			System.out.println("Error on backend" + response.getStatus());
		} else {
			request.getRequestDispatcher("/listusers").forward(request, response);
		}
	}
}

