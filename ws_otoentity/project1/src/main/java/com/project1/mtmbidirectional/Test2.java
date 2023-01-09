package com.project1.mtmbidirectional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashSet;
import java.util.Set;

public class Test2 {

	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("oto_entity");
		EntityManager em=emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Course c1 = new Course();
        c1.setCname("JAVA");

        Course c2 = new Course();
        c2.setCname("SERVLET");

        Course c3 = new Course();
        c3.setCname("JSP");

        Student s1 = new Student();
        s1.setSname("XYZ");

        Student s2 = new Student();
        s2.setSname("ABC");

        Set<Course> sc = new HashSet<>();

        sc.add(c1);
        sc.add(c2);
        sc.add(c3);

        Set<Student> ss = new HashSet<>();

        ss.add(s1);
        ss.add(s2);

        c1.setStudents(ss);
        c2.setStudents(ss);
        c3.setStudents(ss);

        s1.setCourses(sc);
        s2.setCourses(sc);

        em.persist(s1);
        em.persist(s2);
        em.getTransaction().commit();
        
       
	}

}
