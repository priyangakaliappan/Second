package com.healpal.care

class QuestionCategory {

	String questionCategory
	Short isActive
	Date rowCreated
	Date rowAltered

	static hasMany = [profileQuestionses: ProfileQuestions]

	static mapping = {
		id column: "question_category_row_id", generator: "identity"
		version false
	}

	static constraints = {
		questionCategory maxSize: 150, unique: true
		rowAltered nullable: true
	}
}
