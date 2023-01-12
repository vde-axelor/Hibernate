package com.unique.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.unique.app.mainServlet;

@WebServlet(urlPatterns = ("/me"))
public class editServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{
		PrintWriter pw=res.getWriter();
    	EntityManagerFactory emf=Persistence.createEntityManagerFactory("test");
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		
		String id=req.getParameter("id");
		int id1=Integer.parseInt(id);
		String name=req.getParameter("name");
		String country=req.getParameter("country");
		String email=req.getParameter("email");
		String username=req.getParameter("username");
		String password=req.getParameter("password");
			

		test t=new test();
		t.getId();
		t.setName(name);
		t.setCountry(country);
		t.setEmail(email);
		t.setUsername(username);
		t.setPassword(password);
		
		em.persist(t);
		
		em.getTransaction().commit();
		
		em.close();
		emf.close();
//		test t=em.find(test.class,25);  
//        System.out.println("Before Updation");  
//        System.out.println("Name = "+t.getName());  
//        System.out.println("Country = "+t.getCountry());  
//        System.out.println("Email = "+t.getEmail()); 
//        System.out.println("Username = "+t.getUsername());
//        System.out.println("Password = "+t.getPassword()); 
//          
//       t.setUsername("pqr1"); 
//          
//        System.out.println("After Updation");  
//        System.out.println("Name = "+t.getName());  
//        System.out.println("Country = "+t.getCountry());  
//        System.out.println("Email = "+t.getEmail()); 
//        System.out.println("Username = "+t.getUsername());
//        System.out.println("Password = "+t.getPassword()); 
//        
//        em.persist(t);
//		
//		em.getTransaction().commit();
//		
//		em.close();
//		emf.close();
//		String id1=req.getParameter("id");
//		int id=Integer.parseInt(id1);
//		
////		Query query = (Query) em.createQuery("Select id from test t");  
//		Query query = (Query) em.createQuery("Select t from mainServlet t");  
//        @SuppressWarnings("unchecked")  
//        List<test> l1=(List<test>)((javax.persistence.Query) query).getResultList();
////        List<String> list =((javax.persistence.Query) query).getResultList();
//       
//        for(test t:l1) {  
//              
//           System.out.print(t.getId());
//          
//        
//             
//        }  	
//        em.remove(l1);
//        em.getTransaction().commit();
//		test t=new test();
//		t.getName();
//		t.getCountry();
//		t.getEmail();
//		t.getUsername();
//		t.getPassword();
//		em.remove(t);
		
		
		
//		em.getTransaction().commit();
		
//		em.close();
//		emf.close();
		
		pw.print("Delete Successfully...");
	}

}
