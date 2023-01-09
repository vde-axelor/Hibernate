package com.project1.mtounidirectional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Test4 {

	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("oto_entity");
		EntityManager em=emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Address add1 = new Address();
        add1.setCity("BANGALORE");
        add1.setZipcode("560010");
        add1.setAid(1);
        
        Student1 stu = new Student1();
        stu.setSname("XYZ");
        stu.setAddress(add1);

        em.persist(stu);

        em.getTransaction().commit();
        
        em.close();
        emf.close();
	}

}
