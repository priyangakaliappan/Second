package com.healpal.care

class SurgicalProcedure {

	String surgicalProcedureType
	Short isActive
	Date rowCreated
	Date rowAltered

	static mapping = {
		id column: "surgical_procedure_rowid", generator: "identity"
		version false
	}

	static constraints = {
		surgicalProcedureType maxSize: 150, unique: true
		rowAltered nullable: true
	}
}
