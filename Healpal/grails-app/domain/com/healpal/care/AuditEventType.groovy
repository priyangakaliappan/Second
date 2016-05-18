package com.healpal.care

class AuditEventType {

	String auditEventTypeName
	Short auditView = 0
	Short auditAdd = 0
	Short auditUpdate = 0
	Short isActive
	Date rowCreated
	Date rowAltered
	
	static final String newUser ="New User Created Successfully"
	static final String newUserActivated ="New User Activated Successfully"
	
	static final String addedUser ="Added User"
	static final String updatedUser ="Updated User"
	static final String deleteddUser ="Deleted User"
	static final String updatedPasswordU ="Updated Password"
	
	static final String addedRole ="Added Role"
	static final String updatedRole ="Updated Role"
	static final String deletedRole ="Deleted Role"
	
	static final String addedUserRole ="Added UserRole"
	static final String updatedUserRole ="Updated UserRole"
	static final String deletedUserRole ="Deleted UserRole"
	
	static final String successLogin ="Successful Login"
	static final String manLogout ="Manual Logout"
	
	static final String addedCancerStatus ="Added CancerStatus"
	static final String updatedCancerStatus ="Updated CancerStatus"
	static final String deletedCancerStatus ="Deleted CancerStatus"
	
	static final String addedEducation ="Added Education"
	static final String updatedEducation ="Updated Education"
	static final String deletedEducation ="Deleted Education"
	
	static final String addedEthinicity ="Added Ethinicity"
	static final String updatedEthinicity ="Updated Ethinicity"
	static final String deletedEthinicity ="Deleted Ethinicity"
	
	static final String addedHealthInsurance ="Added HealthInsurance"
	static final String updatedHealthInsurance ="Updated HealthInsurance"
	static final String deletedHealthInsurance ="Deleted HealthInsurance"
	
	static final String addedPersonalInterest ="Added PersonalInterest"
	static final String updatedPersonalInterest ="Updated PersonalInterest"
	static final String deletedPersonalInterest ="Deleted PersonalInterest"
	
	static final String addedRace ="Added Race"
	static final String updatedRace ="Updated Race"
	static final String deletedRace ="Deleted Race"
	
	static final String addedSurgery ="Added Surgery"
	static final String updatedSurgery ="Updated Surgery"
	static final String deletedSurgery ="Deleted Surgery"
	
	static final String addedChemotheraphy ="Added Chemotheraphy"
	static final String updatedChemotheraphy ="Updated Chemotheraphy"
	static final String deletedChemotheraphy ="Deleted Chemotheraphy"
	
	static final String addedDrug ="Added Drug"
	static final String updatedDrug ="Updated Drug"
	static final String deletedDrug ="Deleted Drug"
	
	static final String addedHormoneTherapy ="Added HormoneTherapy"
	static final String updatedHormoneTherapy ="Updated HormoneTherapy"
	static final String deletedHormoneTherapy ="Deleted HormoneTherapy"
	
	static final String addedMetastaticBreastCancer ="Added MetastaticBreastCancer"
	static final String updatedMetastaticBreastCance ="Updated MetastaticBreastCancer"
	static final String deletedMetastaticBreastCance ="Deleted MetastaticBreastCancer"
	
	static final String addedSurgicalProcedure ="Added SurgicalProcedure"
	static final String updatedSurgicalProcedure ="Updated SurgicalProcedure"
	static final String deletedSurgicalProcedure ="Deleted SurgicalProcedure"
	
	static final String addedMedicalCondition ="Added MedicalCondition"
	static final String updatedMedicalCondition ="Updated MedicalCondition"
	static final String deletedMedicalCondition ="Deleted MedicalCondition"
	
	static final String addedRadiationTreatment ="Added RadiationTreatment"
	static final String updatedRadiationTreatment ="Updated RadiationTreatment"
	static final String deletedRadiationTreatment ="Deleted RadiationTreatment"
	
	static final String addedTargettedTherapy ="Added TargettedTherapy"
	static final String updatedTargettedTherapy ="Updated TargettedTherapy"
	static final String deletedTargettedTherapy ="Deleted TargettedTherapy"
	
	static final String addedSideEffects ="Added SideEffects"
	static final String updatedSideEffects ="Updated SideEffects"
	static final String deletedSideEffects ="Deleted SideEffects"
	
	static final String addedProfileQuestion ="Added ProfileQuestion"
	static final String updatedProfileQuestion ="Updated ProfileQuestion"
	static final String deletedProfileQuestion ="Deleted ProfileQuestion"
	
	
	static final String addedQuestionOption ="Added Question Option"
	static final String updatedQuestionOption ="Updated Question Option"
	//static final String deletedQuestionOption ="Deleted Question Option"
	
	static final String addedProvidedDocReferral ="Added Provide Doctor Referral"
	static final String addedProvidedCliReferral ="Added Provide Clinical Referral"
	
	static final String addedRequestDocReferral ="Added Request Doctor Referral"
	static final String addedRequestCliReferral ="Added Request Clinical Referral"
	
	static final String addedDoctor ="Added Doctor"
	
	
	static final String addedAboutYou ="Added About You"
	static final String updatedAboutYou ="Updated About You"
	static final String deletedAboutYou ="Deleted About You"
	
	
	static final String addedProfile ="Added Profile Details"
	static final String updatedProfile ="Updated Profile Details"
	static hasMany = [auditEvents: AuditEvent]

	static mapping = {
		id column: "audit_event_type_rowid", generator: "identity"
		table schema:'public'
		version false
	}

	static constraints = {
		auditEventTypeName maxSize: 100, unique: true
		rowAltered nullable: true
	}
}
