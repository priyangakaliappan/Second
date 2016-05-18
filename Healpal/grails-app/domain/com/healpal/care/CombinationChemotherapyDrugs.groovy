package com.healpal.care

class CombinationChemotherapyDrugs {

	String combinationChemotherapyDrugsName
	Short isActive
	Date rowCreated
	Date rowAltered

	static mapping = {
		id column: "combination_chemotherapy_drugs_rowid", generator: "assigned"
		version false
	}

	static constraints = {
		combinationChemotherapyDrugsName maxSize: 150, unique: true
		rowAltered nullable: true
	}
}
