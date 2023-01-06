package com.unique.apps;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

/**
 * Servlet implementation class dbStore
 */
public class dbStore extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dbStore() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");//setting the content type  
		PrintWriter pw=response.getWriter();//get the stream to write the data  
		//pw.write("hello");
		
		pw.println("<html><body align='center'>");
		pw.println("<h1>Register Form</h1>");
		pw.print("<form action='' method='post'>");
		pw.print("<input type='text' name='name' placeholder='Enter Name'> &nbsp;");
		pw.print("<input type='text' name='course' placeholder='Enter Course'> &nbsp;");
		pw.print("<input type='submit' name='submit'>");
		pw.print("</form>");
		
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
        SessionFactory factory = meta.getSessionFactoryBuilder().build();  
        Session session = factory.openSession();  
        Transaction t = session.beginTransaction();  
        
        Query query = session.createQuery("FROM Student");
        List<Student> std = query.list();
        
        pw.println("<h1>");
        pw.print("<table align='center' border >");
        pw.print("<thead>");
        pw.print("<th>Id</th>");
        pw.print("<th> Name</th>");
        pw.print("<th>Course</th>");
        pw.print("<th>Operation</th>");
        pw.print("</thead>");
        
        
        pw.print("<tbody>");
        //
        for (Student stuObj : std) {
        pw.print("<tr>");
        pw.print("<td>" + stuObj.getId()+ "</td>");
        pw.print("<td>" + stuObj.getName() + "</td>");
        pw.print("<td>" + stuObj.getCourse() + "</td>");
        pw.print("<td><a>Delete</a></td>");
        pw.print("</tr>");
        }
        pw.print("</tbody>");
        
        pw.print("<table>");
        pw.println("</h1>");
		pw.print("</html></body>");
		
		 if(request.getParameter("submit")!=null)
	        {
	            String name = request.getParameter("name");
	            String course = request.getParameter("course");
	             Student s = new Student();
	             s.setName(name);
	             s.setCourse(course);
	             session.save(s);
	             t.commit();
	             session.close();
	             pw.print("SuccessFully Saved");
	             //response.sendRedirect("db");
	        }
			
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}






//pw.print("<tbody>");
//
//for (Student stuObj : std) {
//pw.print("<tr>");
//pw.print("<td>" + stuObj.getId() + "</td>");
//pw.print("<td>" + stuObj.getName() + "</td>");
//pw.print("<td>" + stuObj.getCourse() + "</td>");
////pw.print("<td><a href='delete?id="+stuObj.getId()+"'>Delete</a></td>");
//pw.print("</tr>");
//}
//pw.print("</tbody>");
