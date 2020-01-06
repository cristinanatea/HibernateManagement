package com.Spring.servlets;
import java.io.IOException;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.map.ObjectMapper;

import crud.management.commons.LoginDTO;
import crud.management.commons.UserInfo;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
	}
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
 	 
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String parola = request.getParameter("password");

		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/Frontend/rest/users/login");

		LoginDTO loginInfo = new LoginDTO();
		loginInfo.setEmail(email);
		loginInfo.setPassword(parola);

		ObjectMapper mapper = new ObjectMapper();
		// Java object to JSON string
		String jsonString = mapper.writeValueAsString(loginInfo);

		ClientResponse status = webResource.type(MediaType.APPLICATION_JSON_TYPE).post(ClientResponse.class,
				jsonString);

		if (status.getStatus() != 200) {
			System.out.println("Error on backend" + response.getStatus());
		} else {
			String json = status.getEntity(String.class);

			UserInfo userInfo = mapper.readValue(json, UserInfo.class);

			request.setAttribute("user", userInfo);
			request.getRequestDispatcher("/home.jsp").forward(request, response);
		}
	}
}