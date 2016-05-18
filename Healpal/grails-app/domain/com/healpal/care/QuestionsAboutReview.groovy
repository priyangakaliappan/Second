package com.healpal.care

import java.util.Date;

class QuestionsAboutReview {
	String questions
	Short isActive
	ReviewAbout reviewAbout
	String optionType
	Date rowCreated
	Date rowAltered
	
	static belongsTo = [ReviewAbout]
	static hasMany = [patientReviews:PatientReviewAnswers]
	
	static mapping = {
		id column: "review_questions_rowid", generator: "identity"
		version false
	}
	
    static constraints = {
		questions unique: true
		rowAltered nullable: true
    }
}
