package com.app;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue( value = "NS" )
public class NonTeachingStaff extends Staff{
		@Column(name = "areaexpertise")
	   private String areaexpertise;

//	   public NonTeachingStaff( int sid, String sname, String areaexpertise ) {
//	      super( sid, sname );
//	      this.areaexpertise = areaexpertise;
//	   }
//
//	   public NonTeachingStaff( ) {
//	      super( );
//	   }

	   public String getAreaexpertise( ) {
	      return areaexpertise;
	   }

	   public void setAreaexpertise( String areaexpertise ){
	      this.areaexpertise = areaexpertise;
	   }
}
