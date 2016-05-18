package com.healpal.care

class Timezone {

	String timezoneName
	Short isActive
	Date rowCreated
	Date rowAltered

	static hasMany = [persons: Person]

	static mapping = {
		id column: "timezone_rowid", generator: "identity"
		version false
	}

	static constraints = {
		timezoneName maxSize: 100
		rowAltered nullable: true
	}
}
