package com.jpa.app.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.jpa.app.Employee;
import com.jpa.app.ActiveEmployee;
import com.jpa.app.RetiredEmployee;

public class EmployeeMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Employee_detail");  
	    EntityManager em=emf.createEntityManager();  
	      
	    em.getTransaction().begin();  
	      
	      
	    ActiveEmployee ae1=new ActiveEmployee(101,"Karun",10000,5);  
	    ActiveEmployee ae2=new ActiveEmployee(102,"Rishab",12000,7);  
	  
	    RetiredEmployee re1=new RetiredEmployee(103,"Ramesh",5000);  
	    RetiredEmployee re2=new RetiredEmployee(104,"Raj",4000);  
	  
	    em.persist(ae1);  
	    em.persist(ae2);  
	      
	    em.persist(re1);  
	    em.persist(re2);  
	      
	    em.getTransaction().commit();  
	      
	    em.close();  
	    emf.close();
	}

}
