package com.healpal.care

class Drugs {

	String drugName
	Short isActive
	Date rowCreated
	Date rowAltered

	static hasMany = [patientDrugses: PatientDrugs]

	static mapping = {
		id column: "drugs_rowid", generator: "identity"
		version false
	}

	static constraints = {
		drugName maxSize: 150, unique: true
		rowAltered nullable: true
	}
}
