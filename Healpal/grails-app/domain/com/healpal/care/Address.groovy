package com.healpal.care

class Address {

	String street1
	String street2
	String city
	String state
	String zipcode
	String county
	Short isActive
	Date rowCreated
	Date rowAltered

	//static belongsTo = [City, County, State]
	
	static hasMany = [doctors: Doctor]

	static mapping = {
		id column: "address_rowid", generator: "identity"
		/*city column: "city_fk"
		state column: "state_fk"
		county column: "county_fk"*/
		street1 column :'street_1'
		street2 column :'street_2'
		version false
	}

	static constraints = {
		street1 nullable: true, maxSize: 80
		street2 nullable: true, maxSize: 80
		city nullable: true,maxSize: 50
		state nullable: true,maxSize: 50
		county nullable: true,maxSize: 50
		zipcode nullable: true ,maxSize: 10
		rowAltered nullable: true
	}
}
