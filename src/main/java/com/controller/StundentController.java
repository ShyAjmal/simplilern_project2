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

/**
 * Servlet implementation class StundentController
 */
public class StundentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StundentController() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
				
		Query query = session.createQuery("from Student");

		List<Student> students =query.list();
		session.close();
		session = factory.openSession();
		Query queryClass = session.createQuery("from Class");

		List<Class> departments =queryClass.list();
				
		out.println("Hibernate Session opened for learners academy");
		session.close();
		out.println("Hibernate Session for academy");
		out.println("</html></body>");

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("student.jsp");
		request.setAttribute("students", students);
		request.setAttribute("departments", departments);
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
		Class level = session.get(Class.class,Integer.parseInt(request.getParameter("department")));
			
		Student  student = new Student(request.getParameter("name"),level);
			session.save(student);
			session.close();
	
		doGet(request, response);
	}

}
