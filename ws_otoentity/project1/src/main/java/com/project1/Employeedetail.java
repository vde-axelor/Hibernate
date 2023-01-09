package com.project1;
import javax.persistence.*;

@Entity
@Table(name = "empdetail")
public class Employeedetail {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int detailid;
	private int age;
	private String city;
	private int empid;
	
	public int getDetailid() {
		return detailid;
	}
	public void setDetailid(int detailid) {
		this.detailid = detailid;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}

}
