package com.healpal.care

class PatientAddress {

	Address address
	Short isActive
	Date rowCreated
	Date rowAltered
	Patient patient

	static belongsTo = [Patient]

	static mapping = {
		id column: "patient_address_rowid", generator: "identity"
		patient column :"patient_fk"
		address column :"address_fk"
		version false
	}

	static constraints = {
		address maxSize: 40
		rowAltered nullable: true
	}
}
