package com.healpal.care

class ClinicalTrial {

	String name
	Short isActive
	Date rowCreated
	Date rowAltered

	static hasMany = [referralses: Referrals]

	static mapping = {
		id column: "clinical_trial_rowid", generator: "assigned"
		version false
	}

	static constraints = {
		name maxSize: 70, unique: true
		rowAltered nullable: true
	}
}
