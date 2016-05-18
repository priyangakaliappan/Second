package com.healpal.care


class CancerContentRate {

	String cancerContentSection
	String cancerContentPage
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
		id column: "cancer_content_rate_rowid", generator: "identity" 
		cancerContentSection column:'cancer_content_section'
		cancerContentPage column:'cancer_content_page'
	 satisfactoryCount column:'satisfactory_count'
	 perfectCount column:'perfect_count'
	 notClearCount column:'not_clear_count'
	 notWhatIWantedCount column:'not_what_i_wanted_count'
	 patient column:'patient_fk'
	 healpalUser column :'user_fk'
		version false
	}

	static constraints = {
		cancerContentSection maxSize: 70
		cancerContentPage nullable: true, maxSize: 70
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
	static final String cancerTypes ="BreastCancer"
	
	static final String satisfactory="satisfactoryCount"
	static final String perfect="perfectCount"
	static final String notClear="notClearCount"
	static final String wanted="notWhatIWantedCount"
	
	//####### Section 1
	static final String about="AboutBreastCancer"
	
	static final String about_number="UnderstandingNumber"
	static final String about_structure="NormalStructureOfTheBreast"
	static final String about_symptoms="SymptomsAndSigns"
	static final String about_risk="CausesAndRiskFactors"
	static final String about_secondary="SecondaryBreastCancer"
	static final String about_question="QuestionsToAskYourDoctorOnTheFirstVisit"
	
	//####### Section 2
	static final String diagnosis="DiagnosisOfBreastCancer"
	
	static final String diag_test="TheTest"
	static final String diag_confirm="ConfirmationOfDiagnosis"
	static final String diag_tumor="BreastCancerTumor"
	static final String diag_types="UnderStandingTestResult"
	static final String diag_question="TypesAndStagesOfBreastCancer"
	static final String diag_result="Question"
	
	
	//####### Section 3
	static final String treatment="TreatmentOptions"
	
	static final String treat_team="KnowYourBreastCancerCareTeam"
	static final String treat_option="TreatmentOptions"
	static final String treat_medicine="AlternativeMedicine"
	static final String treat_staging="TreatmentBasedOnStaging"
	static final String treat_effects="SideEffectsOfTreatment"
	static final String treat_question="Question"
	
	//####### Section 4
	static final String prevention="PreventionAndEarlyDetection"
	
	static final String prevent_mammogram="Mammogram"
	static final String prevent_screening="AdditionalScreeningTests"
	static final String prevent_aes="aes"
	static final String prevent_question="Question"
	
	//####### Section 5
	static final String clinic="ClinicalTrials"
	
	static final String clinic_understanding="UnderstandingClinicalTrials"
	static final String clinic_where="WhereCanIFindClinicalTrial"
	static final String clinic_question="Question"
	
	//####### Section 6
	static final String lifeStyle="CopyingAndLifeStyleIssues"
	
	static final String style_nutrition="Nutrition"
	static final String style_exercise="RehabilitationAndExercise"
	static final String style_fertility="SexualHealthAndFertility"
	static final String style_stress="CopingWithFatiqueAndStress"
	static final String style_pain="PalliativeCareAndPainManagement"
	static final String style_involved="GettingInvolvedWithHealpal"
	
	
	
	
	//****************** Breast Cancer Sections
	static final String section_about="About Breast Cancer"
	static final String section_diagnosis="Diagnosis of breast cancer"
	static final String section_treatment="Treatment Options"
	static final String section_prevention="Prevention And Early Detection"
	static final String section_clinical="Clinical Trials"
	static final String section_lifestyle="Coping And LifeStyle Issues"
	
	static final String section_about_action="understandingNumber"
	static final String section_diagnosis_action="theTest"
	static final String section_treatment_action="knowYourBreastCancerCareTeam"
	static final String section_prevention_action="mammorgam"
	static final String section_clinical_action="understandingClinicalTrial"
	static final String section_lifestyle_action="nutrition"
}
