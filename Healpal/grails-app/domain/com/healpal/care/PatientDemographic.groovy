package com.healpal.care

class PatientDemographic {

	Short isActive
	Date rowCreated
	Date rowAltered
	Patient patient
	Demographic demographic

	static belongsTo = [Demographic, Patient]

	static mapping = {
		id column: "patient_demographic_rowid", generator: "assigned"
		version false
	}

	static constraints = {
		rowAltered nullable: true
	}
}
