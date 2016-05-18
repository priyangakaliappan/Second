package com.healpal.care

class AboutYou {

	String aboutYouName
	Short isActive
	Date rowCreated
	Date rowAltered

	static mapping = {
		id column: "about_you_rowid", generator: "identity"
		version false
	}

	static constraints = {
		aboutYouName maxSize: 150, unique: true
		rowAltered nullable: true
	}
}
