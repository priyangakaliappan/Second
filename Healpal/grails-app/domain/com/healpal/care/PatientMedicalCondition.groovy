package com.healpal.care

class PatientMedicalCondition {

	Short isActive
	Date rowCreated
	Date rowAltered
	MedicalCondition medicalCondition
	Patient patient

	static belongsTo = [MedicalCondition, Patient]

	static mapping = {
		id column: "patient_medical_condition_rowid", generator: "identity"
		medicalCondition column :"medical_condition_fk"
		patient column :"patient_fk"
		version false
	}

	static constraints = {
		rowAltered nullable: true
	}
}
