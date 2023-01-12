package com.unique.app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class crudOperation {

	public void updateEntity() {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("test");
		EntityManager em=emf.createEntityManager();
		
		em.getTransaction().begin();
		
		
		test t=new test();
		t.getId();
		t.getName();
		t.getCountry();
		t.getEmail();
		t.getUsername();
		t.getPassword();
		
		//t.setName();
		
	}
}
