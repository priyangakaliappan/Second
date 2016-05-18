package com.healpal.care

class PatientMessageGroup {

	Short isActive
	Date rowCreated
	Date rowAltered
	Patient patient
	MessageGroup messageGroup

	static belongsTo = [MessageGroup, Patient]

	static mapping = {
		id column: "patient_message_group_rowid", generator: "identity"
		messageGroup column:"message_group_fk"
		patient column:"patient_fk"
		version false
	}

	static constraints = {
		rowAltered nullable: true
	}
}
