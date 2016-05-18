package com.healpal.care

class PersonalInterest {

	String personalInterestType
	Short isActive
	Date rowCreated
	Date rowAltered

	static hasMany = [demographics: Demographic]

	static mapping = {
		id column: "personal_interest_rowid", generator: "identity"
		version false
	}

	static constraints = {
		personalInterestType maxSize: 150, unique: true
		rowAltered nullable: true
	}
}
