package com.project1;
import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
	@Id
	@Column(name = "empid")
	
	private int empid;
	private String name;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn
	private Employeedetail empdetail;

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Employeedetail getEmpdetail() {
		return empdetail;
	}

	public void setEmpdetail(Employeedetail empdetail) {
		this.empdetail = empdetail;
	}
	
	
}
