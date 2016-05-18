package com.healpal.care

class PatientQuestion {

	Short isActive
	Date rowCreated
	Date rowAltered
	ProfileQuestions profileQuestions
	Patient patient
    String tableName
	String fieldName
	static belongsTo = [ProfileQuestions, Patient]

	static mapping = {
		id column: "patient_question_rowid", generator: "identity"
		profileQuestions column :"profile_questions_fk"
		patient column :"patient_fk"
		version false
	}

	static constraints = {
		rowAltered nullable: true
	}
}
