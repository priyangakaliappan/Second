package com.healpal.care

class MedicalCondition {

	String medicalConditionType
	Short isActive
	Date rowCreated
	Date rowAltered

	static mapping = {
		id column: "medical_condition_rowid", generator: "identity"
		version false
	}

	static constraints = {
		medicalConditionType maxSize: 150, unique: true
		rowAltered nullable: true
	}
}
