package com.app;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "STAFF")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type")
public class Staff{
	   @Id
	   @Column(name = "id")
	   @GeneratedValue( strategy = GenerationType.AUTO )
	   
	   private int sid;
	   @Column(name = "sname")
	   private String sname;
	   
//	   public Staff( int sid, String sname ) {
//	      super( );
//	      this.sid = sid;
//	      this.sname = sname;
//	   }
//	   
//	   public Staff( ) {
//	      super( );
//	   }
	   
	   public int getSid( ) {
	      return sid;
	   }
	   
	   public void setSid( int sid ) {
	      this.sid = sid;
	   }
	   
	   public String getSname( ) {
	      return sname;
	   }
	   
	   public void setSname( String sname ) {
	      this.sname = sname;
	   }
}
