package com.healpal.care

class Ethnicity {

	String ethnicityName
	Short isActive
	Date rowCreated
	Date rowAltered

	static hasMany = [demographics: Demographic ,persons : Person]

	static mapping = {
		id column: "ethnicity_rowid", generator: "identity"
		version false
	}

	static constraints = {
		ethnicityName maxSize: 35, unique: true
		rowAltered nullable: true
	}
}
