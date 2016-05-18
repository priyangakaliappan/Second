package com.healpal.care

class QuestionLabel {

	String questionLabel
	Short isActive
	Date rowCreated
	Date rowAltered

	static hasMany = [profileQuestionses: ProfileQuestions]

	static mapping = {
		id column: "question_label_row_id", generator: "identity"
		version false
	}

	static constraints = {
		questionLabel maxSize: 150, unique: true
		rowAltered nullable: true
	}
}
