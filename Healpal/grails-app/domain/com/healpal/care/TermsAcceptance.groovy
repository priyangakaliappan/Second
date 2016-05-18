package com.healpal.care

import java.util.Date;

class TermsAcceptance {

	Patient patientFk
	Date rowCreated
	Date rowAltered
	Short isActive
	
	static belongsTo = [Patient]
	
	static mapping = {
		id column: "terms_acceptance_rowid", generator: "identity"
		patientFk column: "patient"
		version false
	}
    static constraints = {
		rowAltered nullable: true
		patientFk nullable: true
    }
}
