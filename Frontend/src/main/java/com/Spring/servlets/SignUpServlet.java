package com.Spring.servlets;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import crud.management.commons.SignUpDTO;
import crud.management.commons.UserInfo;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
@WebServlet("/signUp")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SignUpServlet() {
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
		RequestDispatcher requestDispatcher;
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String phoneNumber= request.getParameter("phoneNumber");
		
		
		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/Sample/rest/users/signUp");
		
		SignUpDTO signupInfo = new SignUpDTO();
		signupInfo.setEmail(email);
		signupInfo.setPassword(password);
		signupInfo.setName(name);
		signupInfo.setPhoneNumber(phoneNumber);
		
		ClientResponse status = webResource.post(ClientResponse.class, signupInfo);	
		
		if (status.getStatus() != 200) {
			System.out.println("Error on backend" +  response.getStatus());
		} else {
			String json = status.getEntity(String.class);
			
			ObjectMapper mapper = new ObjectMapper();//creaza obj pe care il indic si asigneaza valoarea cheii respective
			UserInfo userInfo = mapper.readValue(json, UserInfo.class);

			request.setAttribute("user", userInfo);
			request.getRequestDispatcher("/MyLogin.jsp").forward(request, response);
		}
	}
}