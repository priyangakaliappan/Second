package com.healpal.care

class PatientCancerStage {

	Short isActive
	Date rowCreated
	Date rowAltered
	CancerStage cancerStage
	Patient patient

	static belongsTo = [CancerStage, Patient]

	static mapping = {
		id column: "patient_cancer_stage_rowid", generator: "assigned"
		cancerStage column :"cancer_stage_fk"
		patient column :"patient_fk"
		version false
	}

	static constraints = {
		rowAltered nullable: true
	}
}
