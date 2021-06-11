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
import com.to.Subject;
import com.to.Teacher;

/**
 * Servlet implementation class SubjectController
 */
public class SubjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubjectController() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
				
		Query query = session.createQuery("from Subject");

		List<Subject> subjects =query.list();
		Query queryTeacher = session.createQuery("from Teacher");

		List<Teacher> teachers =queryTeacher.list();
		session.close();
		session = factory.openSession();
		Query queryClass = session.createQuery("from Class");

		List<Class> departments =queryClass.list();
				
		out.println("Hibernate Session opened for learners academy");
		session.close();
		out.println("Hibernate Session for academy");
		out.println("</html></body>");

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("subject.jsp");
		request.setAttribute("subjects", subjects);
		request.setAttribute("teachers", teachers);
		request.setAttribute("departments", departments);
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
		RequestDispatcher rd =null;
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		System.out.println("mode"+request.getParameter("mode"));
		if(request.getParameter("department") != null &&request.getParameter("teacher") !=null) {
			Class level = session.get(Class.class,Integer.parseInt(request.getParameter("department")));
			Teacher teacher = session.get(Teacher.class,Integer.parseInt(request.getParameter("teacher")));
			Subject  subject = new Subject(request.getParameter("name"),level);
				subject.setTeacher(teacher);
				session.save(subject);
				session.close();
		
			doGet(request, response);
		}
		else {
			rd = request.getRequestDispatcher("subject.jsp");
			PrintWriter out = response.getWriter();
		
			rd.include(request, response);
			out.println("<center> <span style='color:red'> Please enter all fields </span></center>");
		}
		
	}


}
