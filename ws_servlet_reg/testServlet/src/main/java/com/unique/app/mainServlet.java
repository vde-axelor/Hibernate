package com.unique.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/ms"})
public class mainServlet extends HttpServlet{
	
	 private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException
	    {
		
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
			EntityManager em = emf.createEntityManager();
//			String id=req.getParameter("id");
//			int id1=Integer.parseInt(id);
//			test t3 = em.find(test.class, id1);
//			Methods m3=new Methods();
//			m3.deletestudent(t3);
//			em.remove(m3);
//			
//	        PrintWriter pw=res.getWriter();
//	        pw.print("Hello");
//	        System.out.println("Hello");
			
			
			
//			PrintWriter pw=res.getWriter();
//			String id11=req.getParameter("id");
//			int id2=Integer.parseInt(id11);
//			test t = em.find(test.class, id11);
//			Methods m4=new Methods();
//			m4.displaystudent(t);
	    }
	    protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
	        //doGet(req,res);
	    	PrintWriter pw=res.getWriter();
	    	String name=req.getParameter("name");
			String country=req.getParameter("country");
			String email=req.getParameter("email");
			String username=req.getParameter("username");
			String password=req.getParameter("password");
	    	test t=new test();
	    	t.setName(name);
			t.setCountry(country);
			t.setEmail(email);
			t.setUsername(username);
			t.setPassword(password);
	    	Methods m=new Methods();
	    	m.addstudent(t);
	    	pw.print("save sucressfully..");
	    	
	    	EntityManagerFactory emf=Persistence.createEntityManagerFactory("test");
			EntityManager em=emf.createEntityManager();
			String id=req.getParameter("id");
			int id1=Integer.parseInt(id);
	    	String name1=req.getParameter("name");
			String country1=req.getParameter("country");
			String email1=req.getParameter("email");
			String username1=req.getParameter("username");
			String password1=req.getParameter("password");
			test t1 = em.find(test.class, id1);
	    	t1.setName(name1);
			t1.setCountry(country1);
			t1.setEmail(email1);
			t1.setUsername(username1);
			t1.setPassword(password1);
	    	Methods m1=new Methods();
	    	m1.editstudent(t1);
	    	
	    	pw.print("update succesfully..");
//	    	EntityManagerFactory emf=Persistence.createEntityManagerFactory("test");
//			EntityManager em=emf.createEntityManager();
//			em.getTransaction().begin();
//			
//			String name=req.getParameter("name");
//			String country=req.getParameter("country");
//			String email=req.getParameter("email");
//			String username=req.getParameter("username");
//			String password=req.getParameter("password");
//					
//			test t=new test();
//			t.setName(name);
//			t.setCountry(country);
//			t.setEmail(email);
//			t.setUsername(username);
//			t.setPassword(password);
//			
//			em.persist(t);
//			//em.remove(t);
//			
//			em.getTransaction().commit();
//			
//			em.close();
//			emf.close();
			
			//pw.print("Save Successfully...");
	    }
}
