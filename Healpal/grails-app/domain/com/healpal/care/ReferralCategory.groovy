package com.healpal.care

class ReferralCategory {

	String categoryName
	Short isActive
	Date rowCreated
	Date rowAltered

	static final String expert ="Experts"
	static final String trial ="Clinic Trial"
	
	static hasMany = [referralses: Referrals]

	static mapping = {
		id column: "referral_category_rowid", generator: "assigned"
		version false
	}

	static constraints = {
		categoryName maxSize: 50, unique: true
		rowAltered nullable: true
	}
}
