/**
 * Author    : Thirumal R
 * Project   : HealPal
 * Date      : 11/02/2015
 * FileName  : PatientMatch
 *
 * #      Name         Version   Modified-Date      Description
 * -------------------------------------------------------------------------------------
 * 1      Thirumal R     1.0       11/02/2015      Initial Creation
 *
 *
 **/
package com.healpal.care

class PatientMatch {

	Short isActive
	Date rowCreated
	Date rowAltered
	double percentage
	Patient patient
	Patient currentPatient

	static belongsTo = [Patient]

	static mapping = {
		id column: "patient_match_rowid", generator: "identity"
		patient column :"patient_fk"
		currentPatient column :"current_patient_fk"
		version false
	}

	static constraints = {
		rowAltered nullable: true
	}
}
