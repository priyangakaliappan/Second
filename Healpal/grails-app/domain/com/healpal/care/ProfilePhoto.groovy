package com.healpal.care

class ProfilePhoto {

	String profilePhotoPath
	Short isActive
	Date rowCreated
	Date rowAltered
	Patient patient

	static belongsTo = [Patient]

	static mapping = {
		id column: "profile_photo_rowid", generator: "identity"
		patient column:"patient_fk"
		version false
	}

	static constraints = {
		profilePhotoPath maxSize: 200, unique: true
		rowAltered nullable: true
	}
}
