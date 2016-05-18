package com.healpal.care

class Education {

	String educationType
	Short isActive
	Date rowCreated
	Date rowAltered

	static hasMany = [demographics: Demographic]

	static mapping = {
		id column: "education_rowid", generator: "identity"
		version false
	}

	static constraints = {
		educationType maxSize: 150, unique: true
		rowAltered nullable: true
	}
}
