package com.healpal.care

class QuestionOptionsFormat {

	String questionOptionsFormat
	Short isActive
	Date rowCreated
	Date rowAltered
	
	static final String textField ="TextField"

	static hasMany = [profileQuestionses: ProfileQuestions]

	static mapping = {
		id column: "question_options_format_row_id", generator: "identity"
		version false
	}

	static constraints = {
		questionOptionsFormat maxSize: 150, unique: true
		rowAltered nullable: true
	}
}
