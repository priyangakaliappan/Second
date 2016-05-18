package com.healpal.care

class TempQuestionOption {
	
	String questionName
	String value
	Patient patient
	
	static mapping = {
		id column: "question_row_id", generator: "identity"
		patient column:"patient_fk"
		version false
	}


    static constraints = {
		    }
}
