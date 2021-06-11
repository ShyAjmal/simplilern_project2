package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.to.Class;
import com.to.Student;
import com.to.Teacher;

/**
 * Servlet implementation class TeacherController
 */
public class TeacherController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherController() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
				
		Query query = session.createQuery("from Teacher");

		List<Teacher> teachers =query.list();
		session.close();

				
		out.println("Hibernate Session opened for learners academy");
	
		out.println("Hibernate Session for academy");
		out.println("</html></body>");

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("teacher.jsp");
		request.setAttribute("teachers", teachers);
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();

	
		Teacher  teacher = new Teacher(request.getParameter("name"));
			session.save(teacher);
			session.close();
			doGet(request, response);
	}
		

}
