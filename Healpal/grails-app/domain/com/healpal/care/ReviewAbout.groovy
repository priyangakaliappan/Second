package com.healpal.care

import java.util.Date;

class ReviewAbout {
	String reviewAbout
	Short isActive
	Date rowCreated
	Date rowAltered
	
	static mapping = {
		id column: "review_about_rowid", generator: "identity"
		version false
	}
	
    static constraints = {
		reviewAbout maxSize: 35, unique: true
		rowAltered nullable: true
    }
}
