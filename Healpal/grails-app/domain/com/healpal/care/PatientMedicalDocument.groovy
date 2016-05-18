package com.healpal.care

class PatientMedicalDocument {

	String fileName
	String filePath
	String fileFormat
	Date rowCreated
	Date rowAltered
	Patient patient
	HealpalUser healpalUser

	static belongsTo = [HealpalUser, Patient]

	static mapping = {
		id column: "med_doc_rowid", generator: "identity"
		patient column :'patient_fk'
		healpalUser column :'user_fk'
		version false
	}

	static constraints = {
		fileName maxSize: 100
		filePath maxSize: 100
		fileFormat maxSize: 15
		rowAltered nullable : true
	}
}
