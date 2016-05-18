package com.healpal.care

class SecurityQuestion {

	String securityQuestionName
	Short isActive
	Date rowCreated
	Date rowAltered

	static hasMany = [securityQAndAs: SecurityQAndA]

	static mapping = {
		id column: "security_question_rowid", generator: "assigned"
		version false
	}

	static constraints = {
		securityQuestionName maxSize: 150, unique: true
		rowAltered nullable: true
	}
}
