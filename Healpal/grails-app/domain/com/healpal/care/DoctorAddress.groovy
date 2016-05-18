package com.healpal.care

import java.util.Date;

class DoctorAddress {

	String city
	String state
	String county
	Double latitude
	Double longitude
	Short isActive
	Date rowCreated
	Date rowAltered

	
	static hasMany = [doctors: Doctor]

	static mapping = {
		id column: "doctor_address_rowid", generator: "identity"
		version false
	}

	static constraints = {
		city nullable: true,maxSize: 50
		state nullable: true,maxSize: 50
		county nullable: true,maxSize: 50
		rowAltered nullable: true
		latitude nullable: true, maxSize: 150
		longitude nullable : true, maxSize: 150
	}
}
