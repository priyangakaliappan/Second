package com.healpal.care

class RadiationTreatment {

	String radiationTreatmentType
	Short isActive
	Date rowCreated
	Date rowAltered

	static mapping = {
		id column: "radiation_treatment_rowid", generator: "identity"
		version false
	}

	static constraints = {
		radiationTreatmentType maxSize: 150, unique: true
		rowAltered nullable: true
	}
}
