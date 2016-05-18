package com.healpal.care

class PatientChat {

	Short approveRequest
	Short isActive
	Date rowCreated
	Date rowAltered
	Patient patientByPatientFk1
	Patient patientByPatientFk2
	Patient patientByPatientSendRequest
	Long patientAcceptRequest
	

	static belongsTo = [Patient]

	static mapping = {
		id column: "patient_chat_rowid", generator: "identity"
		patientByPatientFk1 column: "patient_fk1"
		patientByPatientFk2 column: "patient_fk2"
		patientByPatientSendRequest column: "patient_send_request" 
		patientAcceptRequest column : "patient_accept_request"
		version false
	}

	static constraints = {
		rowAltered nullable: true
		patientAcceptRequest nullable : true
	}
}
