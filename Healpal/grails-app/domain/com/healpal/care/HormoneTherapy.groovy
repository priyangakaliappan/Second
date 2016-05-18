package com.healpal.care

class HormoneTherapy {

	String hormoneTherapyName
	Short isActive
	Date rowCreated
	Date rowAltered

	static mapping = {
		id column: "hormone_therapy_rowid", generator: "identity"
		version false
	}

	static constraints = {
		hormoneTherapyName maxSize: 150, unique: true
		rowAltered nullable: true
	}
}
