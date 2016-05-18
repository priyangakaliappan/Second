package com.healpal.care

import java.util.Date;

class PatientTreatment {

    Short isActive
	Date rowCreated
	Date rowAltered
	Patient patient
	Treatment treatment

	static belongsTo = [Patient, Treatment]

	static mapping = {
		id column: "patient_treatment_rowid", generator: "identity"
		treatment column: "treatment_fk"
		patient column:"patient_fk"
		version false
	}

	static constraints = {
		rowAltered nullable: true
	}
}
