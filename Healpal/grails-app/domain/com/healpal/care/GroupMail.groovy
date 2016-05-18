package com.healpal.care

import java.util.Date;

class GroupMail {
	
	String emailAddress
	Short isActive
	Date rowCreated
	Date rowAltered
	String cancerType
	
    static mapping = {
		id column: "groupmail_rowid", generator: "identity"
		version false
	}

	static constraints = {
		emailAddress maxSize: 128 
		rowAltered nullable: true
		cancerType maxSize: 20, nullable: false
	}
}
