package com.unique.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/mo" })
public class crudOpt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
		EntityManager em = emf.createEntityManager();
		
	
		 String delete = "/opt.jsp";
		String forward="";
        String action = req.getParameter("action");
        test t1 =new test(); 
        if (action.equalsIgnoreCase("delete")){
        	String id = req.getParameter("id");
    		int id1 = Integer.parseInt(id);
            deleteServlet(req,res);
            forward = delete ;
           
        } else if (action.equalsIgnoreCase("edit")){
           
            int id = Integer.parseInt(req.getParameter("id"));
            test t = em.find(test.class, id);
            updateServlet(req,res);
        } else if (action.equalsIgnoreCase("display")) {
        	int id = Integer.parseInt(req.getParameter("id"));
            test t = em.find(test.class, id);
            listServlet(req,res);
        }

        RequestDispatcher view = req.getRequestDispatcher(forward);
        view.forward(req, res);
	}

	private void deleteServlet(HttpServletRequest req, HttpServletResponse res) throws IOException,ServletException{
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
		EntityManager em = emf.createEntityManager();
		PrintWriter pw=res.getWriter();
		em.getTransaction().begin();

		String id = req.getParameter("id");
		int id1 = Integer.parseInt(id);
		test t = em.find(test.class, id1);
		em.remove(t);
		em.getTransaction().commit();
		emf.close();
		em.close();
		pw.print("delete Successfully...");
	}

	private void updateServlet(HttpServletRequest req, HttpServletResponse res) throws IOException,ServletException{

		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
		EntityManager em = emf.createEntityManager();
		PrintWriter pw=res.getWriter();
		em.getTransaction().begin();

		String id = req.getParameter("id");
		int id1 = Integer.parseInt(id);
		String name = req.getParameter("name");
		String country = req.getParameter("country");
		String email = req.getParameter("email");
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		test t = em.find(test.class, id1);
		t.setName(name);
		t.setCountry(country);
		t.setEmail(email);
		t.setUsername(username);
		t.setPassword(password);

		em.persist(t);

		em.getTransaction().commit();

		em.close();
		emf.close();
		pw.print("update Successfully...");
	}

	private void addServlet(HttpServletRequest req, HttpServletResponse res) throws IOException,ServletException {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
		EntityManager em = emf.createEntityManager();
		PrintWriter pw=res.getWriter();
		em.getTransaction().begin();

		String name = req.getParameter("name");
		String country = req.getParameter("country");
		String email = req.getParameter("email");
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		test t = new test();
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

	private void listServlet(HttpServletRequest req, HttpServletResponse res) throws IOException,ServletException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		PrintWriter pw = res.getWriter();
		String id = req.getParameter("id");
		int id1 = Integer.parseInt(id);
		test t = em.find(test.class, id1);
						
		pw.print("<html><body align='center'>");
		pw.print("<table align='center'>");
		pw.print("<tr>" + t.getName() + "</tr>");
		pw.print("<br>");
		pw.print("<tr>" + t.getCountry() + "</tr>");
		pw.print("<br>");
		pw.print("<tr>" + t.getEmail() + "</tr>");
		pw.print("<br>");
		pw.print("<tr>" + t.getUsername() + "</tr>");
		pw.print("<br>");
		pw.print("<tr>" + t.getPassword() + "</tr>");
		pw.print("</table>");
		pw.print("</body></html>");

	}				

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String action = req.getParameter("action");
		if (action.equalsIgnoreCase("add")){
			addServlet(req,res);
         
      } else if (action.equalsIgnoreCase("display")){
    	  listServlet(req,res);
      }
      else {
    	  doGet(req,res);
      }
		
		 //doGet(req,res);
    	//addServlet(req,res);
    	//listServlet(req,res);
	}
}
