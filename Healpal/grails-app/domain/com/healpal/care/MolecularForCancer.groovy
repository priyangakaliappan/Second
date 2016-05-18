package com.healpal.care

class MolecularForCancer {

	String molecularForCancerName
	Short isActive
	Date rowCreated
	Date rowAltered

	static mapping = {
		id column: "molecular_for_cancer_rowid", generator: "identity"
		version false
	}

	static constraints = {
		molecularForCancerName maxSize: 150, unique: true
		rowAltered nullable: true
	}
}
