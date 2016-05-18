package com.healpal.care

import java.util.Date;

import com.healpal.care.MailboxType;

class Referrals {

	String message
	MailboxType mailboxTypeByReceiverMaiboxTypeFk
	MailboxType mailboxTypeBySenderMaiboxTypeFk
	String referralsDoctors
	String reasonForReferrals
	ClinicalTrial clinicalTrial
	Patient patientByPatientFkSender
	Patient patientByPatientFkReceiver
	ReferralCategory referralCategory
	Short isActive
	Date rowCreated
	Date rowAltered
	String referralType
	Short viewed = 0
	
	static final String request = "request"
	static final String provide = "provide"

	static belongsTo = [ClinicalTrial, Patient, ReferralCategory ,MailboxType]

	static mapping = {
		id column: "referrals_rowid", generator: "identity"
		mailboxTypeByReceiverMaiboxTypeFk column:'receiver_maibox_type_fk'
		mailboxTypeBySenderMaiboxTypeFk column:'sender_maibox_type_fk'
		 clinicalTrial column:'clinical_trial_fk'
		 patientByPatientFkSender column:'patient_fk_sender'
		 patientByPatientFkReceiver column:'patient_fk_receiver'
		 referralCategory column :'referral_category_fk'
		version false
	}

	static constraints = {
		message maxSize: 500
		referralsDoctors nullable: true, maxSize: 30
		reasonForReferrals nullable: true, maxSize: 200
		clinicalTrial nullable : true
		rowAltered nullable: true
		referralType nullable : true
	}
}
