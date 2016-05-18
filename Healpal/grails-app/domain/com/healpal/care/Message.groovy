package com.healpal.care

class Message {

	String messageText
	Date messageCreated
	Short readReceiptRequested
	Date messageSent
	Date messageViewed
	Short isActive
	Date rowCreated
	Date rowAltered
	Patient patientByPatientFkSender
	MessageGroup messageGroup
	Patient patientByPatientFkReceiver

	static belongsTo = [MessageGroup, Patient]

	static mapping = {
		id column: "message_rowid", generator: "identity"
		messageGroup column: "message_group_fk"
		patientByPatientFkSender column : "patient_fk_sender"
		patientByPatientFkReceiver column : "patient_fk_receiver"
		version false
	}

	static constraints = {
		messageText maxSize: 3000
		messageViewed nullable: true
		patientByPatientFkReceiver nullable: true
		messageGroup nullable: true
		rowAltered nullable: true
	}
}
