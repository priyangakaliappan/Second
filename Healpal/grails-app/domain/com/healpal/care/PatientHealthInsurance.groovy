package com.healpal.care

class PatientHealthInsurance {

	Short isActive
	Date rowCreated
	Date rowAltered
	HealthInsurance healthInsurance
	Patient patient

	static belongsTo = [HealthInsurance, Patient]

	static mapping = {
		id column: "patient_health_insurance_rowid", generator: "identity"
		healthInsurance column :"health_insurance_fk"
		patient column :"patient_fk"
		version false
	}

	static constraints = {
		rowAltered nullable: true
	}
}
