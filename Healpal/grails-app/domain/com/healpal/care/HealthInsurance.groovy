package com.healpal.care

class HealthInsurance {

	String healthInsuranceType
	Short isActive
	Date rowCreated
	Date rowAltered

	static hasMany = [demographics: Demographic]

	static mapping = {
		id column: "health_insurance_rowid", generator: "identity"
		version false
	}

	static constraints = {
		healthInsuranceType maxSize: 150, unique: true
		rowAltered nullable: true
	}
}
