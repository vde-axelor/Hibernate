package com.app.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.app.Staff;
import com.app.NonTeachingStaff;
import com.app.TeachingStaff;

public class SaveClient {

	public static void main(String[] args) {
		  EntityManagerFactory emf = Persistence.createEntityManagerFactory( "jpa_i" );
	      EntityManager em = emf.createEntityManager( );
	      em.getTransaction( ).begin( );
	      
	      Staff s=new Staff();
	      s.setSid(101);
	      s.setSname("TechingStaff");
	      //Teaching staff entity 
	      TeachingStaff ts1=new TeachingStaff();
//	      ts1.setSid(1);
//	      ts1.setSname("ABC");
	      ts1.setQualification("Msc MEd");
	      ts1.setSubjectexpertise("Maths");
	      
//	      TeachingStaff ts2=new TeachingStaff();
//	      ts2.setSid(2);
//	      ts2.setSname("XYZ");
//	      ts2.setQualification("BSc BEd");
//	      ts2.setSubjectexpertise("English");
	      
	      //Non-Teaching Staff entity
	      NonTeachingStaff nts1=new NonTeachingStaff();
//	      nts1.setSid(3);
//	      nts1.setSname("PQR");
	      nts1.setAreaexpertise("Accounts");
//	      NonTeachingStaff nts2=new NonTeachingStaff();
//	      nts2.setSid(4);
//	      nts2.setSname("DEF");
//	      nts2.setAreaexpertise("Office Admin");
	      //storing all entities
	      em.persist(s);
	      em.persist(ts1);
//	      em.persist(ts2);
	      em.persist(nts1);
//	      em.persist(nts2);
	      
	      em.getTransaction().commit();
	      
	      em.close();
	      emf.close();
	}

}
