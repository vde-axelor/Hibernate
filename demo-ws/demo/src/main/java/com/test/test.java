package com.test;

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

import com.test.Registration;

/**
 * Servlet implementation class test
 */
public class test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter pw=response.getWriter();//get the stream to write the data  
		//pw.write("hello");

		pw.println("<html><body align='center'>");
		pw.println("<h1>Register Form</h1>");
		pw.print("<form action='' method='post'>");
		pw.print("<input type='text' name='name' placeholder='Enter Name'> &nbsp;");
		pw.print("<br/>");
		pw.print("<input type='text' name='city' placeholder='Enter City'> &nbsp;");
		pw.print("<br/>");
		pw.print("<input type='text' name='username' placeholder='Enter User Name'> &nbsp;");
		pw.print("<br/>");
		pw.print("<input type='text' name='password' placeholder='Enter Password'> &nbsp;");
		pw.print("<br/>");
		pw.print("<input type='submit' name='submit'>");
		pw.print("</form>");
		
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
        SessionFactory factory = meta.getSessionFactoryBuilder().build();  
        Session session = factory.openSession();  
        Transaction t = session.beginTransaction();  
//        Registration r=new Registration();
//        r.setId(2);
//        r.setName("abc");
//        r.setCity("abc");
//        r.setUsername("abc");
//        r.setPassword("abc");
//        session.save(r);
//        t.commit();
//        session.close();
//        pw.print("SuccessFully Saved");
        
        Query query = session.createQuery("FROM Registration");
        List<Registration> reg = query.list();
        
        pw.println("<h1>");
        pw.print("<table align='center'>");
        pw.print("<thead>");
        pw.print("<th>Id</th>");
        pw.print("<th> Name</th>");
        pw.print("<th>Course</th>");
        pw.print("<th>User Name</th>");
        pw.print("<th>Password</th>");
        pw.print("<th>Operation</th>");
        pw.print("</thead>");
        
        
        pw.print("<tbody>");
        //
        for (Registration regObj : reg) {
        pw.print("<tr>");
        pw.print("<td>" + regObj.getId()+ "</td>");
        pw.print("<td>" + regObj.getName() + "</td>");
        pw.print("<td>"+regObj.getCity()+"</td>");
        pw.print("<td>" + regObj.getUsername() + "</td>");
        pw.print("<td>" + regObj.getPassword() + "</td>");
        pw.print("<td><a href='delete?id="+regObj.getId()+"'>Delete</a></td>");
        pw.print("<td><a href='update?id="+regObj.getId()+"'>Update</a></td>");
        pw.print("</tr>");
        }
        pw.print("</tbody>");
        
        pw.print("</table>");
        pw.println("</h1>");
		pw.print("</html></body>");
		
		 if(request.getParameter("submit")!=null)
	        {
	            String name = request.getParameter("name");
	            String city = request.getParameter("city");
	            String username = request.getParameter("username");
	            String password = request.getParameter("password");
	             Registration r = new Registration();
	             r.setName(name);
	             r.setCity(city);
	             r.setUsername(username);
	             r.setPassword(password);
	             session.save(r);
	             t.commit();
	             session.close();
	             pw.print("SuccessFully Saved");
	             response.sendRedirect("test");
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
