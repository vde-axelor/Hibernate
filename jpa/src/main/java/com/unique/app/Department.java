package com.unique.app;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "department")
public class Department{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String deptname;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getDeptname() {
		return deptname;
	}
	public void setName(String deptname) {
		this.deptname = deptname;
	}
}