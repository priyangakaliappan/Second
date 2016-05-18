package com.healpal.care

class PatientViewGroupMessage {

	Date messageViewed
	Patient patient
	Message message

	static belongsTo = [Message, Patient]

	static mapping = {
		id column: "patient_view_group_message_rowid", generator: "identity"
		patient column: "patient_fk"
		message column: "message_fk"
		version false
	}
}
