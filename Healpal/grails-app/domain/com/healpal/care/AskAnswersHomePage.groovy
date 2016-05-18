package com.healpal.care

class AskAnswersHomePage {

	String yourQuestionIsRelatedTo
	String yourQuestion
	String fileName
	String yourLocation
	Date rowCreated
	Date rowAltered
	Short isActive
	String filePath
	String answers
	Patient patientFk
	Integer approved
	
	static belongsTo = [Patient]
	
	static mapping = {
		id column: "ask_answers_home_page_id", generator: "identity"
		patientFk column: "patient"
		version false
	}

	static constraints = {
		yourQuestionIsRelatedTo nullable: true, maxSize: 200
		yourQuestion nullable: true, maxSize: 200
		fileName nullable: true, maxSize: 200
		yourLocation nullable: true, maxSize: 200
		rowAltered nullable: true
		filePath nullable: true, maxSize: 200
		answers nullable: true,maxSize: 2000
		approved nullable: true
	}
}
