package com.sample.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.sample.commons.ProjectInfo;
import com.sample.commons.UserInfo;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

@WebServlet("/listusers")
public class ListUsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		boolean isAdmin = false;

		HttpSession session = request.getSession();
		UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
		if (userInfo == null) {
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		} else {
			isAdmin = (userInfo.getAcces() != 0);
		}

		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/HibernateManagement/rest/user/listusers");
		ClientResponse statusUsers = webResource.type(MediaType.APPLICATION_JSON_TYPE).post(ClientResponse.class);

		WebResource webResource2 = client.resource("http://localhost:8080/HibernateManagement/rest/project/listprojects");
		ClientResponse statusProjects = webResource2.type(MediaType.APPLICATION_JSON_TYPE).post(ClientResponse.class);

		if ((statusUsers.getStatus() != 200) || (statusProjects.getStatus() != 200)) {
			System.out.println("Error on backend" + response.getStatus());
		} else {
			ObjectMapper mapper = new ObjectMapper();

			String json = statusUsers.getEntity(String.class);
			List<UserInfo> userList = mapper.readValue(json, new TypeReference<List<UserInfo>>() {
			});
			request.setAttribute("userList", userList);

			json = statusProjects.getEntity(String.class);
			List<ProjectInfo> projectList = mapper.readValue(json, new TypeReference<List<ProjectInfo>>() {
			});
			request.setAttribute("projectList", projectList);
			request.setAttribute("admin", isAdmin);

			request.getRequestDispatcher("/listusers.jsp").forward(request, response);
		}
	}
}