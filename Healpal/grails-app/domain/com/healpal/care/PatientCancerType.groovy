package com.healpal.care

class PatientCancerType {

	Short isActive
	Date rowCreated
	Date rowAltered
	CancerType cancerType
	Patient patient

	static belongsTo = [CancerType, Patient]

	static mapping = {
		id column: "patient_cancer_type_rowid", generator: "assigned"
		cancerType column :"cancer_type_fk"
		patient column :"patient_fk"
		version false
	}

	static constraints = {
		rowAltered nullable: true
	}
}
