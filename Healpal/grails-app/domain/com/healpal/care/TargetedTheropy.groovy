package com.healpal.care

class TargetedTheropy {

	String targetedTheropyName
	Short isActive
	Date rowCreated
	Date rowAltered

	static mapping = {
		id column: "targeted_theropy_rowid", generator: "identity"
		version false
	}

	static constraints = {
		targetedTheropyName maxSize: 150, unique: true
		rowAltered nullable: true
	}
}
