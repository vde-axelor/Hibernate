package com.app.main;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.app.Dept;
import com.app.Emp;

public class OneToMany {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory( "jpa_r" );
		EntityManager em = emf.createEntityManager( );
		em.getTransaction( ).begin( );

		   //Create Employee1 Entity
		   Emp e = new Emp();
		   e.setEname("ABC");
		   e.setSalary(45000.0);
		   e.setDeg("Technical");
		   
		   //Store Employee
		   em.persist(e);
		   
		   //Create Employeelist
		   List<Emp> emplist = new ArrayList();
		   emplist.add(e);
		   

		   //Create Department Entity
		   Dept d = new Dept();
		   d.setName("Development");
		   d.setEmployeelist(emplist);

		   //Store Department
		   em.persist(d);

		   em.getTransaction().commit();
		   em.close();
		   emf.close();
	}

}
