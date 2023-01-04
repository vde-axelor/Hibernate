package com.oto.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.oto.Dep;
import com.oto.Empl;

public class OneToOne {

	public static void main(String[] args) {
		   EntityManagerFactory emf = Persistence.createEntityManagerFactory( "jpa_r" );
		   EntityManager em = emf.createEntityManager( );
		   em.getTransaction( ).begin( );

		   //Create Department Entity
		   Dep d = new Dep();
		   d.setName("Development");

		   //Store Department
		   em.persist(d);

		   //Create Employee Entity
		   Empl e = new Empl();
		   e.setEname("Satish");
		   e.setSalary(10000.0);
		   e.setDeg("Mechanical");
		   e.setDepartment(d);

		   //Store Employee
		   em.persist(e);

		   em.getTransaction().commit();
		   em.close();
		   emf.close();
	}

}
