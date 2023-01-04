package com.oto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "EMP1")
public class Empl {
	   @Id
	   @GeneratedValue( strategy= GenerationType.AUTO ) 	
	   private int eid;
	   private String ename;
	   private double salary;
	   private String deg;

	   @OneToOne
	   private Dep department;

	   public Empl(int eid, String ename, double salary, String deg) {
	      super( );
	      this.eid = eid;
	      this.ename = ename;
	      this.salary = salary;
	      this.deg = deg;
	   }

	   public Empl( ) {
	      super();
	   }

	   public int getEid( ) {
	      return eid;
	   }
	   
	   public void setEid(int eid) {
	      this.eid = eid;
	   }

	   public String getEname( ) {
	      return ename;
	   }
	   
	   public void setEname(String ename) {
	      this.ename = ename;
	   }

	   public double getSalary( ) {
	      return salary;
	   }
	   
	   public void setSalary(double salary) {
	      this.salary = salary;
	   }

	   public String getDeg( ) {
	      return deg;
	   }
	   
	   public void setDeg(String deg) {
	      this.deg = deg;
	   }

	   public Dep getDepartment() {
	      return department;
	   }

	   public void setDepartment(Dep department) {
	      this.department = department;
	   }	

}
