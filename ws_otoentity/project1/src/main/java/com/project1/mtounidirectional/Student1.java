package com.project1.mtounidirectional;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT1")
public class Student1 {
	 @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     private int sid;
     private String sname;
     @ManyToOne(cascade = CascadeType.ALL)
     @JoinColumn(name= "AID")
     private Address address;

     public int getSid() {
             return sid;
     }

     public void setSid(int sid) {
             this.sid = sid;
     }

     public String getSname() {
             return sname;
     }

     public void setSname(String sname) {
             this.sname = sname;
     }

     public Address getAddress() {
             return address;
     }

     public void setAddress(Address address) {
             this.address = address;
     }

}
