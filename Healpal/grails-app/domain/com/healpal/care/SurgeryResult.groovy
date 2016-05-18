package com.healpal.care

class SurgeryResult {

	String surgeryResultType
	Short isActive
	Date rowCreated
	Date rowAltered

	static mapping = {
		id column: "surgery_result_rowid", generator: "assigned"
		version false
	}

	static constraints = {
		surgeryResultType maxSize: 150, unique: true
		rowAltered nullable: true
	}
}
