/*
 * Author      : Priyanga K
 * Project     : Healpal
 * Date        : 11/17/2015
 * Description : Get the values using tags
 *
 * #   Name           Version   Modified-Date      Description
 * -------------------------------------------------------------------------------------
 * 1   Priyanga K    1.0       08/02/2016         Initial Creation
 */

package com.care.healpal

import com.healpal.care.Doctor;
/**
 * 
 * @author Priyanga K
 *
 */
class DoctorTagLib {
	def doctorSpecialty={attrs->
		def doctorId =attrs.getAt("doctorId");
		String specialty=""
		Set<Long> specialties = new LinkedHashSet<Long>();
		if(doctorId != null && doctorId!="") {
			def doctor =Doctor.get(doctorId);
			if(doctor!=null && doctor!=""){
				specialty = doctor?.specialty
				}
			}
			out << specialty
	}
}

