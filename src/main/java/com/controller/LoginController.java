package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
 
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		RequestDispatcher rd =null;
		if(userName.equals("tom") && password.equals("jerry")) {
			HttpSession session = request.getSession();
			session.setAttribute("user", userName);
			response.sendRedirect("home.jsp");
		}else {
			rd = request.getRequestDispatcher("index.jsp");
			PrintWriter out = response.getWriter();
		
			rd.include(request, response);
			out.println("<center> <span style='color:red'> Invalid credentials </span></center>");
		
		}
	}
	}


