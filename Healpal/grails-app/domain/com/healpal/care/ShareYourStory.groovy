package com.healpal.care

class ShareYourStory {
	Diagnosis diagnosis
	Date narrationDate
	String storyTitle
	String yourStory
	String filePath
	String fileName
	String yourStatus
	Date rowCreated
	Date rowAltered
	Short isActive
	Patient patientFk
	Integer approved
	
	static belongsTo = [Diagnosis,Patient]

	static mapping = {
		id column: "share_your_story_id", generator: "identity"
		diagnosis column :"diagnosis_fk"
		patientFk column: "patient_fk"
		version false
	}

	static constraints = {
		narrationDate nullable: true
		yourStatus nullable: true, maxSize: 200
		storyTitle maxSize: 200
		yourStory maxSize: 2000
		filePath nullable: true, maxSize: 200
		fileName nullable: true, maxSize: 200
		rowAltered nullable: true
	}
}
