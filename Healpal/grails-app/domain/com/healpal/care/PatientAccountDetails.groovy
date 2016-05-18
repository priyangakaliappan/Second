package com.healpal.care

class PatientAccountDetails{

	Short isActive
	Date rowCreated
	Date rowAltered
	Date expireDate
	Patient patient
    String cardName
	String accountHolderName
	String cardNo
	String secureCode
	static belongsTo = [Patient]

	static mapping = {
		id column: "patient_account_details_rowid", generator: "identity"
		patient column :"patient_fk"
		version false
	}

	static constraints = {
		rowAltered nullable: true
		secureCode nullable: true
		cardNo nullable: true
		accountHolderName nullable: true
		cardName nullable: true
	}
}
