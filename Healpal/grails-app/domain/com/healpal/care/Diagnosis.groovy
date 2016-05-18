package com.healpal.care

import java.util.Date;

class Diagnosis {

    String diagnosisName
	Short isActive
	Date rowCreated
	Date rowAltered

	//static hasMany = [patientCancerStages: PatientCancerStage]

	static hasMany = [profileQuestionses: ProfileQuestions]
	
	static mapping = {
		id column: "diagnosis_rowid", generator: "identity"
		version false
	}

	static constraints = {
		diagnosisName maxSize: 150, unique: true
		rowAltered nullable: true
	}
}
