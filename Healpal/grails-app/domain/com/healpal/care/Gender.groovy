package com.healpal.care

class Gender {

	String genderCode
	String genderName
	Short isActive
	Date rowCreated
	Date rowAltered

	static hasMany = [persons: Person ,profileQuestionses: ProfileQuestions]
	

	static mapping = {
		id column: "gender_rowid", generator: "identity"
		version false
	}

	static constraints = {
		genderCode maxSize: 1, unique: true
		genderName maxSize: 10, unique: true
		rowAltered nullable: true
	}
}
