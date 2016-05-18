package com.healpal.care

class PatientDrugs {

	Short isActive
	Date rowCreated
	Date rowAltered
	Drugs drugs
	Patient patient

	static belongsTo = [Drugs, Patient]

	static mapping = {
		id column: "patient_drugs_rowid", generator: "assigned"
		version false
	}

	static constraints = {
		rowAltered nullable: true
	}
}
