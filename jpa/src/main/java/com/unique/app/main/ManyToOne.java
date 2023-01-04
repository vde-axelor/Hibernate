package com.unique.app.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.unique.app.Department;
import com.unique.app.Employee;

public class ManyToOne {

	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("jpa_r");
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		Department d=new Department();
		d.setName("Development");
		em.persist(d);
		
		Employee e=new Employee();
		e.setEname("TEST1");
		e.setSalary(15000.0);
		e.setDeg("Technical");
		e.setDepartment(d);
		em.persist(e);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}

}
