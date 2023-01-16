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



@WebServlet(urlPatterns = ("/md"))
public class deleteServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public deleteServlet() {

	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		PrintWriter pw = res.getWriter();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		String id=req.getParameter("id");
		int id1=Integer.parseInt(id);
		test t = em.find(test.class, id1);
		em.remove(t);
		em.getTransaction().commit();
		emf.close();
		em.close();
//    	EntityManagerFactory emf=Persistence.createEntityManagerFactory("test");
//		EntityManager em=emf.createEntityManager();
//		em.getTransaction().begin();
//		String id=req.getParameter("id");
//		int id1=Integer.parseInt(id);
//		String name=req.getParameter("name");
//		String country=req.getParameter("country");
//		String email=req.getParameter("email");
//		String username=req.getParameter("username");
//		String password=req.getParameter("password");
//				
//		test t=new test();
//		t.setId(id1);
//		t.setName(name);
//		t.setCountry(country);
//		t.setEmail(email);
//		t.setUsername(username);
//		t.setPassword(password);
//		
//		//em.persist(t);
//		em.remove(t);
//		em.detach(t);
//		em.getTransaction().commit();
//		
//		em.close();
//		emf.close();

		pw.print("delete Successfully...");
	}

}
