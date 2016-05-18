package com.healpal.care

class PatientPathologyBiopsyTumorType {

	Short isActive
	Date rowCreated
	Date rowAltered
	PathologyBiopsyTumorType pathologyBiopsyTumorType
	Patient patient

	static belongsTo = [PathologyBiopsyTumorType, Patient]

	static mapping = {
		id column: "patient_pathology_biopsy_rowid", generator: "identity"
		pathologyBiopsyTumorType column :"pathology_biopsy_tumor_type_fk"
		patient column :"patient_fk"
		version false
	}

	static constraints = {
		rowAltered nullable: true
	}
}
