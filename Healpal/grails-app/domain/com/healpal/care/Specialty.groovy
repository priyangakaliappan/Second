package com.healpal.care

import java.util.Date;

class Specialty {

    String specialty
	Short isActive
	Date rowCreated
	Date rowAltered

	//static hasMany = [patientTreatment: PatientTreatment]

	
	static mapping = {
		id column: "specialty_rowid", generator: "identity"
		version false
	}

	static constraints = {
		specialty maxSize: 150, unique: true
		rowAltered nullable: true
	}
}
