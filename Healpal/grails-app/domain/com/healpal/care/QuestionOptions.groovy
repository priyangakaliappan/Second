package com.healpal.care

class QuestionOptions {

	String questionOptions
	Short isActive
	Date rowCreated
	Date rowAltered

	static hasMany = [profileQuestionsOptionses: ProfileQuestionsOptions]

	static mapping = {
		id column: "question_options_row_id", generator: "identity"
		version false
	}

	static constraints = {
		questionOptions maxSize: 150, unique: true
		rowAltered nullable: true
	}
}
