package com.healpal.care

class Doctor {

	String firstName
	String middleName
	String lastName
	String doctorName
	String phoneNumber
	String degree
	String specialty
	String street1
	String street2
	String zipcode
	Double latitude
	Double longitude
	Short isActive
	Date rowCreated
	Date rowAltered
	Address address
	DoctorAddress doctorAddress

	static belongsTo = [Address, DoctorAddress]

	static mapping = {
		id column: "doctor_rowid", generator: "identity"
		address column: "address_fk"
		doctorAddress column: "doctor_address_fk"
		street1 column :'street_1'
		street2 column :'street_2'
		version false
	}

	static constraints = {
		firstName maxSize: 150
		lastName maxSize: 150
		middleName  nullable: true, maxSize: 150
		doctorName nullable: true, maxSize: 150
		phoneNumber nullable: true, maxSize: 500
		degree  nullable: true, maxSize: 500
		specialty nullable : true, maxSize: 150
		street1  nullable: true, maxSize: 150
		street2 nullable: true, maxSize: 150
		zipcode  nullable: true, maxSize: 150
		latitude nullable: true, maxSize: 150
		longitude nullable : true, maxSize: 150
		rowAltered nullable: true
		address nullable: true
		doctorAddress nullable: true
		
	}
}
