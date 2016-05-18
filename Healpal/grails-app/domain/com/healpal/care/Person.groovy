package com.healpal.care

class Person {

	String lastName
	String firstName
	String fullName
	String phoneNumber
	String companyName
	String describeAboutYourself
	String passionateAbout
	String herStatusPositive
	String herStatusNegative
	String erStatusPositive
	String erStatusNegative
	String prStatusPositive
	String prStatusNegative
	Date dob
	String emailAddress
	Short isActive
	Date rowCreated
	Date rowAltered
	Gender gender
	Language language
	Timezone timezone
	Race race
	Ethnicity ethnicity
	CancerStatus cancerStatus
	Integer goodWillPoints
	static hasMany = [healpalUsers: HealpalUser]
	static belongsTo = [Gender, Language, Timezone]

	static mapping = {
		id column: "person_rowid", generator: "identity"
		 gender column :'gender_fk'
		 language column :'language_fk'
		 timezone column :'timezone_fk'
		 race column :'race_fk'
		 ethnicity column : 'ethnicity_fk'
		 cancerStatus column : "cancer_status_fk"
		version false
	}

	static constraints = {
		lastName nullable : true, maxSize: 60
		firstName nullable : true, maxSize: 60
		fullName maxSize: 100
		phoneNumber maxSize: 30
		companyName nullable: true, maxSize: 128
		describeAboutYourself nullable: true
		emailAddress maxSize: 128
		rowAltered nullable: true
		dob nullable : true
		phoneNumber nullable : true
		fullName nullable : true
		gender nullable : true
		language nullable : true
		timezone nullable : true
		race nullable : true
		ethnicity nullable : true
		passionateAbout nullable : true
		herStatusPositive nullable : true
		herStatusNegative nullable : true
		erStatusPositive nullable : true
		erStatusNegative nullable : true
		prStatusPositive nullable : true
		prStatusNegative nullable : true
		cancerStatus nullable :true
		goodWillPoints nullable : true
	}
}
