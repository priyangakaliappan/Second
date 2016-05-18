package com.healpal.care

class PatientSurgery {

	Short isActive
	Date rowCreated
	Date rowAltered
	Patient patient
	Surgery surgery

	static belongsTo = [Patient, Surgery]

	static mapping = {
		id column: "patient_surgery_rowid", generator: "assigned"
		version false
	}

	static constraints = {
		rowAltered nullable: true
	}
}
