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

import com.to.Subject;
import com.to.Teacher;
import com.to.Class;
import com.to.Student;

/**
 * Servlet implementation class ClassDetailsController
 */
public class ClassDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassDetailsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	@SuppressWarnings("deprecation")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
				
		Class level = session.get(Class.class,Integer.parseInt(request.getParameter("id")));


//		List<Class> subjectList =level.getSubjectList();
//		
		
		
		
		@SuppressWarnings("deprecation")
		Query query = session.createQuery("from Subject where level=:level ");

		query.setParameter("level", level);

		List<Subject> subjectList =query.list();
		Query queryStudent = session.createQuery("from Student where level=:level ");

		queryStudent.setParameter("level", level);

		List<Student> students =queryStudent.list();

		session.close();

				
		out.println("Hibernate Session opened for learners academy");
	
		out.println("Hibernate Session for academy");
		out.println("</html></body>");

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("classDetails.jsp");

		request.setAttribute("level", level);
		request.setAttribute("subjects", subjectList);
		request.setAttribute("students", students);
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
