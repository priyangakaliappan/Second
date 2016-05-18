package com.healpal.care

class MessageGroup {

	String messageGroupName
	String groupPhotoName
	Patient createdPatient
	Short isActive
	Date rowCreated
	Date rowAltered

	static hasMany = [messages: Message,
	                  patientMessageGroups: PatientMessageGroup]
	
	static belongsTo = [Patient]

	static mapping = {
		id column: "message_group_rowid", generator: "identity"
		groupPhotoName column:"group_photo_name"
		createdPatient column: "patient_fk"
		version false
	}

	static constraints = {
		messageGroupName maxSize: 300
		rowAltered nullable: true
		groupPhotoName nullable: true
	}
}
