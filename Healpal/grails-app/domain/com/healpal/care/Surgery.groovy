package com.healpal.care

class Surgery {

	String surgeryType
	Short isActive
	Date rowCreated
	Date rowAltered

	static hasMany = [patientSurgeries: PatientSurgery]

	static mapping = {
		id column: "surgery_rowid", generator: "identity"
		version false
	}

	static constraints = {
		surgeryType maxSize: 150, unique: true
		rowAltered nullable: true
	}
}
