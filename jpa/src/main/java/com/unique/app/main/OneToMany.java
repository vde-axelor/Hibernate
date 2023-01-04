//package com.unique.app.main;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//
//import com.unique.app.Dept;
//import com.unique.app.Emp;
//
//public class OneToMany {
//	public static void main(String[] args) {
//		EntityManagerFactory emf=Persistence.createEntityManagerFactory("jpa");
//		EntityManager em=emf.createEntityManager();
//		
//		em.getTransaction().begin();
//		
//		Emp e=new Emp();
//		e.setEname("ABC");
//		e.setSalary(30000.0);
//		e.setDeg("Technical");
//		
//		em.persist(e);
//		List<Emp> emplist=new ArrayList();
//		emplist.add(e);
//		
//		Dept d=new Dept();
//		d.setName("Development");
//		d.setEmplist(emplist);
//		em.persist(d);
//		
//		em.getTransaction().commit();
//		em.close();
//		emf.close();
//	}
//
//}
