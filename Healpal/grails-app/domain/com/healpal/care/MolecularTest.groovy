package com.healpal.care

class MolecularTest {

	String molecularTestType
	Short isActive
	Date rowCreated
	Date rowAltered

	static mapping = {
		id column: "molecular_test_rowid", generator: "assigned"
		version false
	}

	static constraints = {
		molecularTestType maxSize: 150, unique: true
		rowAltered nullable: true
	}
}
