package com.unique.app.main;
import java.io.IOError;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.management.Query;
import javax.servlet.*;
import javax.servlet.http.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
public class Demo extends HttpServlet{
	public Demo() {
		
	}
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		
        PrintWriter pw=res.getWriter();			
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
      Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
      SessionFactory factory = meta.getSessionFactoryBuilder().build();  
      Session session = factory.openSession();  
      Transaction t = session.beginTransaction();  
      
      
     
      String name=req.getParameter("name");
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		
		Student s=new Student();
		s.setName(name);
		s.setUsername(username);
		s.setPassword(password);
		
		session.save(s);
		t.commit();
      session.close();
        pw.print("SuccessFully Saved");
//        res.sendRedirect("Demo");
        }
		
	
	
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		doGet(req,res);
	}
}
