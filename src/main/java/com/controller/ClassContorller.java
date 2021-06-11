package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.to.Class;
/**
 * Servlet implementation class ClassContorller
 */
public class ClassContorller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassContorller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
				
		Query query = session.createQuery("from Class");

		List<Class> classLevels =query.list();

		for(Class level: classLevels) {
			out.println(level);
		}
				
		out.println("Hibernate Session opened for learners academy");
		session.close();
		out.println("Hibernate Session for academy");
		out.println("</html></body>");

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("class.jsp");
		request.setAttribute("classDeails", classLevels);
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
		System.out.println("mode"+request.getParameter("mode"));

			
			Class  classLevel = new Class(request.getParameter("name"));
			session.save(classLevel);
			session.close();
	
		doGet(request, response);
	}

}
