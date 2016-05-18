package com.healpal.care

class PatientDiagnosis{

	Short isActive
	Date rowCreated
	Date rowAltered
	int ageOfDiagnosis
	Diagnosis diagnosis
	Patient patient
	Date dateOfCancerDiagnosis
	static belongsTo = [Diagnosis, Patient]

	static mapping = {
		id column: "patient_diagnosis_rowid", generator: "identity"
		diagnosis column :"diagnosis_fk"
		patient column :"patient_fk"
		version false
	}

	static constraints = {
		rowAltered nullable: true
		dateOfCancerDiagnosis nullable: true
		ageOfDiagnosis  nullable: true
	}
}
