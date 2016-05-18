package com.healpal.care

class Patient {

	Short isActive
	Date rowCreated
	Date rowAltered
	Person person

	static hasMany = [mailboxes: Mailbox,
	                  messagesForPatientFkReceiver: Message,
	                  messagesForPatientFkSender: Message,
	                  patientAddresses: PatientAddress,
	                  patientCancerStages: PatientCancerStage,
	                  patientCancerTypes: PatientCancerType,
	                  patientDemographics: PatientDemographic,
	                  patientDrugses: PatientDrugs,
	                  patientSurgeries: PatientSurgery,
					  patientPathologyBiopsyTumorType: PatientPathologyBiopsyTumorType,
	                  profilePhotos: ProfilePhoto,
					  patientTreatment: PatientTreatment,
					  auditEvents: AuditEvent,
					  profileCompletionDetails:ProfileCompletionDetail,
					  patientMedicalDocuments: PatientMedicalDocument,
					  witeReviews: WriteAReview,
					  patientReviewAnwers: PatientReviewAnswers ,
					  cancerContentRates: CancerContentRate ,
					  cancerContentComments: CancerContentComment
					  ] //creditCardDetailses: CreditCardDetails
	static belongsTo = [Person]

	// TODO you have multiple hasMany references for class(es) [Message] 
	//      so you'll need to disambiguate them with the 'mappedBy' property:
	
	static mappedBy = [messagesForPatientFkReceiver: "patientByPatientFkSender",
		messagesForPatientFkSender: "patientByPatientFkReceiver" ,
		referralsesForPatientFkReceiver: "patientByPatientFkSender",
	                   referralsesForPatientFkSender: "patientByPatientFkReceiver"]

	static mapping = {
		id column: "patient_rowid", generator: "identity"
		person column :'person_fk'
		version false
	}

	static constraints = {
		rowAltered nullable: true
	}
}
