package com.healpal.care

class CancerContentComment {

	String contentSection
	String contentPage
	String cancerType
	String comment
	Date rowCreated
	Date rowAltered
	Patient patient
	HealpalUser healpalUser

	static belongsTo = [HealpalUser, Patient]

	static mapping = {
		id column: "cancer_content_comment_rowid", generator: "identity"
		contentSection column:'content_section'
		contentPage column:'content_page'
		patient column:'patient_fk'
		healpalUser column:'user_fk'
		version false
	}

	static constraints = {
		contentSection maxSize: 70
		contentPage maxSize: 70
		cancerType maxSize: 100
		comment maxSize: 500
		rowAltered nullable: true
	}
}
