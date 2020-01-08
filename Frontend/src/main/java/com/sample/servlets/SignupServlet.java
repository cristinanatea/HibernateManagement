package com.sample.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.map.ObjectMapper;

import com.sample.commons.SignUpDTO;
import com.sample.commons.UserInfo;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String parola = request.getParameter("password");
		String name = request.getParameter("name");
		String phoneNumber = request.getParameter("phoneNumber");


		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/HibernateManagement/rest/user/signup");

		SignUpDTO signUpInfo = new SignUpDTO();
	    signUpInfo.setEmail(email);
	    signUpInfo.setPassword(parola);
	    signUpInfo.setName(name);
	    signUpInfo.setPhoneNumber(phoneNumber);

		ObjectMapper mapper = new ObjectMapper();
		// Java object to JSON string
		String jsonString = mapper.writeValueAsString(signUpInfo);

		ClientResponse status = webResource.type(MediaType.APPLICATION_JSON_TYPE).post(ClientResponse.class,jsonString);

		if (status.getStatus() != 200) {
			System.out.println("Error on backend" + response.getStatus());
		} else {
			String json = status.getEntity(String.class);

			UserInfo userInfo = mapper.readValue(json, UserInfo.class);

			request.setAttribute("user", userInfo);
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}
}

