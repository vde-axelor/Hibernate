package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * Servlet implementation class update
 */
public class update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");//setting the content type  
		PrintWriter pw=response.getWriter();//get the stream to write the data  
		  
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
		 Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
		 SessionFactory factory = meta.getSessionFactoryBuilder().build();  
		 Session session = factory.openSession();  
		 
			 
		 String idvalue = request.getParameter("id");
		 int id = Integer.parseInt(idvalue);
		 String name=request.getParameter("name");
		 String city=request.getParameter("city");
		 String username=request.getParameter("username");
		 String password=request.getParameter("password");
		 Registration r = session.get(Registration.class, new Integer(id));
		 r.setName(name);
		 r.setCity(city);
		 r.setUsername(username);
		 r.setPassword(password);
		 session.beginTransaction();
		 session.update(r);
		 session.getTransaction().commit();
		 pw.print("Updated..");
		 response.sendRedirect("test");
		 
//		 
//		    Scanner sc = new Scanner(System.in);
//			System.out.println("Enter Car Id : ");  
//			int id = sc.nextInt();
//			System.out.println("Enter Car Name : ");  
//			String carname = sc.next();
//			System.out.println("Enter Car Color : ");  
//			String carcolor = sc.next();
//			Car c = (Car) session.get(Car.class, new Integer(id));
//			
//			c.setCarname(carname);
//			c.setCarcolor(carcolor);
//			session.beginTransaction();
//			session.saveOrUpdate(c);
//			session.getTransaction().commit();
//			System.out.println("Record updated succesfully...");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
