package com.healpal.care

class MetastaticBreastCancer {

	String metastaticName
	Short isActive
	Date rowCreated
	Date rowAltered

	static mapping = {
		id column: "metastatic_rowid", generator: "identity"
		version false
	}

	static constraints = {
		metastaticName maxSize: 150, unique: true
		rowAltered nullable: true
	}
}
