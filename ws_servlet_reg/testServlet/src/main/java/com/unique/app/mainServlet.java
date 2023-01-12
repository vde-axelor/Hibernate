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
			
	        PrintWriter pw=res.getWriter();
	        pw.print("Hello");
	        System.out.println("Hello");
	    }
	    protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
	        //doGet(req,res);
	    	PrintWriter pw=res.getWriter();
	    	EntityManagerFactory emf=Persistence.createEntityManagerFactory("test");
			EntityManager em=emf.createEntityManager();
			em.getTransaction().begin();
			
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
			
			em.persist(t);
			
			em.getTransaction().commit();
			
			em.close();
			emf.close();
			
			pw.print("Save Successfully...");
	    }
}
