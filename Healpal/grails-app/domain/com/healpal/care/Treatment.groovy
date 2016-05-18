package com.healpal.care

import java.util.Date;

class Treatment {

    String treatmentName
	Short isActive
	Date rowCreated
	Date rowAltered

	static hasMany = [patientTreatment: PatientTreatment]

	
	static mapping = {
		id column: "treatment_rowid", generator: "identity"
		version false
	}

	static constraints = {
		treatmentName maxSize: 150, unique: true
		rowAltered nullable: true
	}
}
