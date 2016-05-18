package com.healpal.care

class ProfileQuestions {

	Short skip
	Short isActive
	Date rowCreated
	Date rowAltered
	int patientMatchPoints
	Gender gender
	QuestionCategory questionCategory
	QuestionLabel questionLabel
	QuestionOptionsFormat questionOptionsFormat
	Diagnosis diagnosis
	QuestionText questionText

	static hasMany = [profileQuestionsOptionses: ProfileQuestionsOptions]
	static belongsTo = [Diagnosis, Gender, QuestionCategory, QuestionLabel, QuestionOptionsFormat, QuestionText]

	static mapping = {
		id column: "profile_questions_row_id", generator: "identity"
		 gender column :'gender_fk'
		 questionCategory column :'question_category_fk'
		 questionLabel column :'question_label_fk'
		 questionOptionsFormat column :'question_options_format_fk'
		 diagnosis column :'diagnosis_fk'
		 questionText column :'question_text_fk'
		 patientMatchPoints column :'patient_match_points'
		version false
	}

	static constraints = {
		rowAltered nullable: true
		diagnosis nullable : true
		
	}
}
