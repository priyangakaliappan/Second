package com.healpal.care

import java.util.Date;

import com.healpal.date.DateConvention;

class WriteAReview {
	Diagnosis diagnosis
	Patient patient
	Date reviewDate
	String reviewTitle
	String yourReview
	String filePath
	String fileName
	String cancerExpert
	String clinicLocation
	String reviewAboutExpert		
	Short isActive
	Date rowCreated
	Date rowAltered
	String rating
    Integer approved
	static belongsTo = [Diagnosis, Patient]
	
	static mapping = {
		id column: "write_a_review_rowid", generator: "identity"
		diagnosis column :"diagnosis_fk"
		patient column: "patient_fk"
		version false
	}
	
    static constraints = {
		rowAltered nullable: true
		filePath nullable: true
		fileName nullable: true
		reviewDate nullable: true
		reviewAboutExpert nullable: true
		cancerExpert nullable: true
		clinicLocation nullable: true
		rating nullable: true
		approved nullable: true
    }
}