package com.healpal.care

import java.util.Date;

class Email {
	String subject
	String bodyText
	Short isActive
	Date rowCreated
	Date rowAltered

  static mapping = {
		id column: "email_rowid", generator: "identity"
		version false
	}

	static constraints = {
		subject nullable: true
		rowAltered nullable: true
	}
}
