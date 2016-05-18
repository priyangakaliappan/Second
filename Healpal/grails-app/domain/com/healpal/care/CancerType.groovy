package com.healpal.care

class CancerType {

	String cancerTypeName
	Short isActive
	Date rowCreated
	Date rowAltered

	static hasMany = [patientCancerTypes: PatientCancerType]

	static mapping = {
		id column: "cancer_type_rowid", generator: "assigned"
		version false
	}

	static constraints = {
		cancerTypeName maxSize: 150, unique: true
		rowAltered nullable: true
	}
}
