package com.healpal.care


class ProfileQuestionAnswer {
	String answer
	Patient patient
	ProfileQuestions profileQuestions
	Short isActive
	Date rowCreated
	Date rowAltered
	static belongsTo = [ProfileQuestions]
	

    static mapping = {
		id column: "profile_questions_answer_row_id", generator: "identity"
		patient column :'patient_fk'
		profileQuestions column :'profile_questions_fk'
		version false
    }
	
	static constraints = {
		rowAltered nullable: true
	}
	
	
	
}
