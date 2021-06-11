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
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.to.Class;
import com.to.Subject;
import com.to.Teacher;

/**
 * Servlet implementation class TeacherDetailsController
 */
public class TeacherDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherDetailsController() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
				
		Teacher teacher = session.get(Teacher.class,Integer.parseInt(request.getParameter("id")));
	

		List<Subject> subjectList =teacher.getSubjectList();
		
		System.out.println("subjects "+subjectList);

		session.close();

				
		out.println("Hibernate Session opened for learners academy");
	
		out.println("Hibernate Session for academy");
		out.println("</html></body>");

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("teacherDeatils.jsp");
		request.setAttribute("teacher", teacher);
	
		request.setAttribute("teacherSubjectList", subjectList);
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
