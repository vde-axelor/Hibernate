package com.project1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Test {

	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("oto_entity");
		EntityManager em=emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Employee emp=new Employee();
		emp.setName("ABC");
		emp.setEmpid(4);
		
		Employeedetail empdetail=new Employeedetail();
		empdetail.setAge(25);
		empdetail.setCity("Valsad");
		empdetail.setEmpid(4);
		
		emp.setEmpdetail(empdetail);
		em.persist(emp);
		
		Employee e =em.find(Employee.class, 4);
		System.out.println(e.getName());
		System.out.println(e.getEmpdetail().getCity());
		
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}

}
