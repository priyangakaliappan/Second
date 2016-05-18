package com.healpal.care

import java.util.Date;

class PatientReviewAnswers {
	String answer
	QuestionsAboutReview questionsAboutReview
	Patient patient
	Short isActive
	Date rowCreated
	Date rowAltered
	WriteAReview writeAReview
	
	static belongsTo = [QuestionsAboutReview,Patient,WriteAReview]
	static mapping = {
		id column: "patient_review_rowid", generator: "identity"
		questionsAboutReview column:"question_about_fk"
		patient column:"patient_fk"
		writeAReview column:"write_a_review_fk"
		version false
	}
	
    static constraints = {
		rowAltered nullable: true
    }
}
