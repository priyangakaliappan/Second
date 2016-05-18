package com.healpal.care

import java.util.Date;

class CancerTreatmentRate {

	
	Integer satisfactoryCount
	Integer perfectCount
	Integer notClearCount
	Integer notWhatIWantedCount
	Date rowCreated
	Date rowAltered
	Patient patient
	HealpalUser healpalUser
	String cancerType
	
	static belongsTo = [HealpalUser, Patient]
	
	static mapping = {
		id column: "cancer_treatment_rate_rowid", generator: "identity"
	 satisfactoryCount column:'satisfactory_count'
	 perfectCount column:'perfect_count'
	 notClearCount column:'not_clear_count'
	 notWhatIWantedCount column:'not_what_i_wanted_count'
	 patient column:'patient_fk'
	 healpalUser column :'user_fk'
		version false
	}

	
    static constraints = {
		rowAltered nullable: true
		 satisfactoryCount nullable : true
		 perfectCount nullable : true
		 notClearCount nullable : true
		 notWhatIWantedCount nullable : true
		  healpalUser nullable : true
		  patient nullable : true
		  cancerType nullable : true
	}
	//****************** Slider COUNT
	static final String satisfactory="satisfactoryCount"
	static final String perfect="perfectCount"
	static final String notClear="notClearCount"
	static final String wanted="notWhatIWantedCount"
	
	static final String angiogenesis ="AngiogenesisInhibitors"
	static final String biological ="BiologicalAgents"
	static final String chemotherapy ="Chemotherapy"
	static final String hormone ="HormoneTherapy"
	static final String immunotherapy ="Immunotherapy"
	static final String radiation ="RadiationTherapy"
	static final String stereoactive ="StereoactiveAblativeBodyRadiotherapy(SABR)"
	static final String surgery ="Surgery"
	static final String targetted ="TargetedTherapy"
	
}
