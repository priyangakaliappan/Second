package com.healpal.care

class ProfileQuestionsOptions {

	Short isActive
	Date rowCreated
	Date rowAltered
	QuestionOptions questionOptions
	ProfileQuestions profileQuestions

	static belongsTo = [ProfileQuestions, QuestionOptions]

	static mapping = {
		id column: "profile_questions_options_row_id", generator: "identity"
		questionOptions column :'question_options_fk'
		profileQuestions column :'profile_questions_fk'
		version false
	}

	static constraints = {
		rowAltered nullable: true
	}
}
