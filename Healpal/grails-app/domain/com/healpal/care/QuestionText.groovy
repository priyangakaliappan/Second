package com.healpal.care

class QuestionText {

	String questionText
	Short isActive
	Date rowCreated
	Date rowAltered

	static hasMany = [profileQuestionses: ProfileQuestions]

	static mapping = {
		id column: "question_text_row_id", generator: "identity"
		version false
	}

	static constraints = {
		questionText maxSize: 150, unique: true
		rowAltered nullable: true
	}
}
