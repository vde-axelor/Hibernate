package com.app;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue( value="TS" )
public class TeachingStaff extends Staff{
	@Column(name = "qualification")
	   private String qualification;
	@Column(name = "subjectexpertise")
	   private String subjectexpertise;

//	   public TeachingStaff( int sid, String sname, 
//	   
//	   String qualification,String subjectexpertise ) {
//	      super( sid, sname );
//	      this.qualification = qualification;
//	      this.subjectexpertise = subjectexpertise;
//	   }
//
//	   public TeachingStaff( ) {
//	      super( );
//	   }

	   public String getQualification( ){
	      return qualification;
	   }

	   public void setQualification( String qualification ){
	      this.qualification = qualification;
	   }

	   public String getSubjectexpertise( ) {
	      return subjectexpertise;
	   }

	   public void setSubjectexpertise( String subjectexpertise ){
	      this.subjectexpertise = subjectexpertise;
	   }
}
