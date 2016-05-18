package com.healpal.care

class PatientEducation {

	Short isActive
	Date rowCreated
	Date rowAltered
	Education education
	Patient patient

	static belongsTo = [Education, Patient]

	static mapping = {
		id column: "patient_education_rowid", generator: "identity"
		education column :"education_fk"
		patient column :"patient_fk"
		version false
	}

	static constraints = {
		rowAltered nullable: true
	}
}
