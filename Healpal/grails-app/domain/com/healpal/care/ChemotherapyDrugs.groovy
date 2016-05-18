package com.healpal.care

class ChemotherapyDrugs {

	String chemotherapyDrugsType
	Short isActive
	Date rowCreated
	Date rowAltered

	static mapping = {
		id column: "chemotherapy_drugs_rowid", generator: "identity"
		version false
	}

	static constraints = {
		chemotherapyDrugsType maxSize: 150, unique: true
		rowAltered nullable: true
	}
}
