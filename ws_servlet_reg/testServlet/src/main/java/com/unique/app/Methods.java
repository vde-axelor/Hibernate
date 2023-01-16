package com.unique.app;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Methods {
	public static void addstudent(test t) {
//		PrintWriter pw=res.getWriter();
    	EntityManagerFactory emf=Persistence.createEntityManagerFactory("test");
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		
		String name=t.getName();
		String country=t.getCountry();
		String email=t.getEmail();
		String username=t.getUsername();
		String password=t.getPassword();
				
		test t1=new test();
		t.setName(name);
		t.setCountry(country);
		t.setEmail(email);
		t.setUsername(username);
		t.setPassword(password);
		
		em.persist(t);
		//em.remove(t);
		
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
		//pw.print("Save Successfully...");
	}
	
	public static void editstudent(test t) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("test");
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		
		int id=t.getId();
		String name=t.getName();
		String country=t.getCountry();
		String email=t.getEmail();
		String username=t.getUsername();
		String password=t.getPassword();
			

		test t1 = em.find(test.class, id);
		t1.setName(name);
		t1.setCountry(country);
		t1.setEmail(email);
		t1.setUsername(username);
		t1.setPassword(password);
		
		em.persist(t1);
		
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
	
	public static void deletestudent(test t) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		int id=t.getId();
		test t2 = em.find(test.class, id);
		em.remove(t2);
		em.getTransaction().commit();
		emf.close();
		em.close();
	}
	
	public static void displaystudent(test t) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		List<test> list=new ArrayList<test>();  
		
		int id=t.getId();
		test t3 = em.find(test.class, id);
		t3.getId();
		t3.getName();
		t3.getCountry();
		t3.getEmail();
		t3.getUsername();
		t3.getPassword();
		list.add(t3);
		System.out.println("<html><body align='center'>");
		System.out.println("<table align='center'>");
		System.out.println("<tr>"+t.getName()+"</tr>");
		System.out.println("<br>");
		System.out.println("<tr>"+t.getCountry()+"</tr>");
		System.out.println("<br>");
		System.out.println("<tr>"+t.getEmail()+"</tr>");
		System.out.println("<br>");
		System.out.println("<tr>"+t.getUsername()+"</tr>");
		System.out.println("<br>");
		System.out.println("<tr>"+t.getPassword()+"</tr>");
		System.out.println("</table>");
		System.out.println("</body></html>");
		
	}
}
