package com.apps.main;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.apps.Clas;
import com.apps.Teacher;

public class ManyToMany {

	public static void main(String[] args) {
		   EntityManagerFactory emf = Persistence.createEntityManagerFactory( "jpa_r" );
		   EntityManager em = emf.createEntityManager( );
		   em.getTransaction( ).begin( );

		   //Create Clas Entity
		   Clas c1 = new Clas(0, "1st", null);
		   Clas c2 = new Clas(0, "2nd", null);
		   Clas c3 = new Clas(0, "3rd", null);

		   //Store Clas
		   em.persist(c1);
		   em.persist(c2);
		   em.persist(c3);

		   //Create Clas Set1
		   Set<Clas> classSet1 = new HashSet();
		   classSet1.add(c1);
		   classSet1.add(c2);
		   classSet1.add(c3);

		   //Create Clas Set2
		   Set<Clas> classSet2 = new HashSet();
		   classSet2.add(c3);
		   classSet2.add(c1);
		   classSet2.add(c2);

		   //Create Clas Set3
		   Set<Clas> classSet3 = new HashSet();
		   classSet3.add(c2);
		   classSet3.add(c3);
		   classSet3.add(c1);

		   //Create Teacher Entity
		   Teacher t1 = new Teacher(0, "Satish","Java",classSet1);
		   Teacher t2 = new Teacher(0, "Krishna","Adv Java",classSet2);
		   Teacher t3 = new Teacher(0, "Masthanvali","DB2",classSet3);

		   //Store Teacher
		   em.persist(t1);
		   em.persist(t2);
		   em.persist(t3);


		   em.getTransaction( ).commit( );
		   em.close( );
		   emf.close( );
	}

}
