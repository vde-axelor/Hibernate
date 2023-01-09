package com.project1.otobidirectional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Test1 {

	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("oto_entity");
		EntityManager em=emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Citizen c=new Citizen();
		c.setCname("ABC");
		
		Passport p=new Passport();
		p.setPnumber("123456");
		p.setCitizen(c);
		
		c.setPassport(p);
		
		em.persist(p);
		em.getTransaction().commit();
	
		
		em.close();
		emf.close();
	}

}
