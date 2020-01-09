package com.sample.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.map.ObjectMapper;

import com.sample.commons.AsignUsersToProjectDTO;
import com.sample.commons.CreateProjectDTO;
import com.sample.commons.ProjectInfo;
import com.sample.commons.SignUpDTO;
import com.sample.commons.UserInfo;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

@WebServlet("/asignuserstoproject")
public class AsignUsersToProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String  projectName = request.getParameter("projectName");


		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/HibernateManagement/rest/project/asign");

		AsignUsersToProjectDTO asignInfo = new AsignUsersToProjectDTO();
		asignInfo.setEmail(email);
		asignInfo.setProjectName(projectName);
	    

		ObjectMapper mapper = new ObjectMapper();
		// Java object to JSON string
		String jsonString = mapper.writeValueAsString(asignInfo);

		ClientResponse status = webResource.type(MediaType.APPLICATION_JSON_TYPE).post(ClientResponse.class,jsonString);

		if (status.getStatus() != 200) {
			System.out.println("Error on backend " + status.getStatus());
		} else {
			String json = status.getEntity(String.class);

			ProjectInfo projectInfo = mapper.readValue(json, ProjectInfo.class);

			request.setAttribute("project", projectInfo);
			request.getRequestDispatcher("/listusers").forward(request, response);
		}
	}
}
