package com.project1.otmunidirectional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class Test3 {

	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("oto_entity");
		EntityManager em=emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Phoneuser phoneUser = new Phoneuser();
        phoneUser.setUsername("AAA");
        phoneUser.setUseremail("AAA@mail.com");
        phoneUser.setUserid(1);

        Phone phone1=new Phone();
        phone1.setPhoneno(111111);
        phone1.setPhonetype("Mobile");
        phone1.setUserid(1);

        Phone phone2=new Phone();
        phone2.setPhoneno(1111);
        phone2.setPhonetype("LandLine");
        phone2.setUserid(1);

        List<Phone> list = new ArrayList<>();
        list.add(phone1);
        list.add(phone2);

        phoneUser.setPhoneTables(list);

        em.persist(phoneUser);
        em.getTransaction().commit();
        
        em.close();
        emf.close();
	}

}
