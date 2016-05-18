package com.healpal.care

class SecurityQAndA {

	String securityAnswer
	Short isActive
	Date rowCreated
	Date rowAltered
	SecurityQuestion securityQuestion
	HealpalUser healpalUser

	static belongsTo = [HealpalUser, SecurityQuestion]

	static mapping = {
		id column: "security_q_and_a_rowid", generator: "assigned"
		table name:'security_q_and_a'
		securityQuestion column:'security_question_fk'
		healpalUser column:'healpal_user_fk'
		version false
	}

	static constraints = {
		securityAnswer maxSize: 150
		rowAltered nullable: true
	}
}
