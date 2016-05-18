package com.healpal.care

class CancerStage {

	String cancerStageLevel
	Short isActive
	Date rowCreated
	Date rowAltered

	static hasMany = [patientCancerStages: PatientCancerStage]

	static mapping = {
		id column: "cancer_stage_rowid", generator: "identity"
		version false
	}

	static constraints = {
		cancerStageLevel maxSize: 150, unique: true
		rowAltered nullable: true
	}
}
