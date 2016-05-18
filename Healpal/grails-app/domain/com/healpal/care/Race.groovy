package com.healpal.care

class Race {

	String raceName
	Short isActive
	Date rowCreated
	Date rowAltered

	static hasMany = [demographics: Demographic,persons : Person]

	static mapping = {
		id column: "race_rowid", generator: "identity"
		version false
	}

	static constraints = {
		raceName maxSize: 45, unique: true
		rowAltered nullable: true
	}
}
