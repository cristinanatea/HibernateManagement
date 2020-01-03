package com.Spring.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;

public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired

	private WebApplicationContext webApplicationContext;
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

    	@SuppressWarnings("resource")
		ApplicationContext context = 
    		new ClassPathXmlApplicationContext("Spring-Module.xml");
    	 

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
		String parola = request.getParameter("password");

		System.out.println("Email: " + email);
	}
}

}
