package com.healpal.care

import java.util.Date;

class ProfileCompletionDetail {

	Short profileUpdated
	String goToProfilePage 
	Date rowCreated
	Date rowAltered
	HealpalUser healpalUser
	Patient patient
	String percentage
	
	static mapping = {
		id column: "profile_completion_detail_rowid", generator: "identity"
		healpalUser column : 'user_fk'
		patient column : 'patient_fk'
		rowAltered column :'row_altered'
		goToProfilePage column:'go_to_profile_page'
		version false
	}
	
    static constraints = {
		rowAltered nullable :true
		percentage nullable :true
    }
}
