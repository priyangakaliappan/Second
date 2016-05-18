package com.healpal.care

class Demographic {

	Short isActive
	Date rowCreated
	Date rowAltered
	Ethnicity ethnicity
	PersonalInterest personalInterest
	HealthInsurance healthInsurance
	Race race
	Education education

	static hasMany = [patientDemographics: PatientDemographic]
	static belongsTo = [Education, Ethnicity, HealthInsurance, PersonalInterest, Race]

	static mapping = {
		id column: "demographic_rowid", generator: "assigned"
		ethnicity column :'ethnicity_fk'
		personalInterest column : 'personal_interest_fk'
		healthInsurance column : 'health_insurance_fk'
		race column : 'race_fk'
		education column : 'education_fk'
		version false
	}

	static constraints = {
		rowAltered nullable: true
	}
}
