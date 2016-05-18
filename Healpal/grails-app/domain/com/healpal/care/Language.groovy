package com.healpal.care

class Language {

	String languageName
	Short isActive
	Date rowCreated
	Date rowAltered

	static hasMany = [persons: Person]

	static mapping = {
		id column: "language_rowid", generator: "identity"
		version false
	}

	static constraints = {
		languageName maxSize: 80
		rowAltered nullable: true
	}
}
