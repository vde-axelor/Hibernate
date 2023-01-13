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

@WebServlet(urlPatterns = ("/mdi"))
public class displayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public displayServlet() {

	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		PrintWriter pw=res.getWriter();
		String id=req.getParameter("id");
		int id1=Integer.parseInt(id);
		test t = em.find(test.class, id1);
		pw.print("<html><body align='center'>");
		pw.print("<table align='center'>");
		pw.print("<tr>"+t.getName()+"</tr>");
		pw.print("<br>");
		pw.print("<tr>"+t.getCountry()+"</tr>");
		pw.print("<br>");
		pw.print("<tr>"+t.getEmail()+"</tr>");
		pw.print("<br>");
		pw.print("<tr>"+t.getUsername()+"</tr>");
		pw.print("<br>");
		pw.print("<tr>"+t.getPassword()+"</tr>");
		pw.print("</table>");
		pw.print("</body></html>");
		
//		t.getName();
//		t.getCountry();
//		t.getEmail();
//		t.getUsername();
//		t.getPassword();
//		System.out.println("Student id = " + s.getS_id());
//		System.out.println("Student Name = " + s.getS_name());
//		System.out.println("Student Age = " + s.getS_age());
	}

}
