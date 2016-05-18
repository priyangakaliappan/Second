package com.healpal.care

class WriteAReviewComments {

	Patient commentedPatient
	Date rowCreated
	Date rowAltered
	Short isActive
	String comments
	WriteAReview writeReviewFk

	static belongsTo = [WriteAReview,Patient]
	static mapping = {
		id generator: "identity"
		writeReviewFk column :"write_review_fk"
		commentedPatient column: "commented_patient"
		version false
	}

	static constraints = {
		commentedPatient nullable: true
		rowAltered nullable: true
	}
}
