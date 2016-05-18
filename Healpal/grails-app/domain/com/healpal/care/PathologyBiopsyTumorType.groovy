package com.healpal.care

class PathologyBiopsyTumorType {

	String tumorTypeName
	Short isActive
	Date rowCreated
	Date rowAltered
	static hasMany = [patientPathologyBiopsyTumorType: PatientPathologyBiopsyTumorType]
	static mapping = {
		id column: "tumor_type_rowid", generator: "identity"
		version false
	}

	static constraints = {
		tumorTypeName maxSize: 150, unique: true
		rowAltered nullable: true
	}
}
