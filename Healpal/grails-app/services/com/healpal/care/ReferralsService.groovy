/*
 * Author    : Manikandan
 * Project   : Healpal
 * Date      :
 * Description :
 *
 * #   Name       Version   Modified-Date      Description
 * -------------------------------------------------------------------------------------
 * 1   Manikandan    1.0               Initial Creation
 *
 */
package com.healpal.care

import java.util.Date;

import grails.transaction.Transactional

@Transactional
class ReferralsService {

    def serviceMethod() {

    }
	
	Referrals save(params ,String senderType , String receiverType ,String category ,String wayOfReferral ,session ,String doctors){
		try{
		
		Referrals referral = new Referrals()
		if(session.user){
			HealpalUser user = session.user
			referral . patientByPatientFkSender = Patient.findByPerson(user?.person)
			referral . patientByPatientFkReceiver = Patient.get(params.patient?.toLong()) //TODO
			referral . referralCategory = ReferralCategory.findByCategoryNameIlike(category)
			referral . mailboxTypeByReceiverMaiboxTypeFk = MailboxType.findByMailboxTypeNameIlike(receiverType)
			referral . mailboxTypeBySenderMaiboxTypeFk = MailboxType.findByMailboxTypeNameIlike(senderType)
			referral . message = params.message
			if(wayOfReferral.equalsIgnoreCase(Referrals.provide) && category.equalsIgnoreCase(ReferralCategory.expert)){
				String rate = params.rateId1?.toString()+","+params.rateId2?.toString()+","+params.rateId3?.toString()+","+params.rateId4?.toString()+","+params.rateId5?.toString()    
				referral . referralsDoctors = doctors
				referral . reasonForReferrals = rate }
			if(category.equalsIgnoreCase(ReferralCategory.trial)){
				//referral . clinicalTrial = ClinicalTrial.get(params.clinicalTrial?.toLong())
			}
			referral.referralType = wayOfReferral.equalsIgnoreCase(Referrals.provide)?Referrals.provide:Referrals.request
			referral . isActive = (short)1
			referral . rowCreated = new Date()
			referral . save(flush : true)
			if(!referral .validate()){
				referral .errors.each {
					println it
				}
			}
		 }	
		return referral
		}catch(Exception exception){
		
		}
	}
	
	def addressSave(params){
		try{
			Address address = new Address()
			if(params){
				address . street1 = params.street1?:''
				address . street2 = params.street2?:''
				address . city = params.city?:''//City.get(params.city?.toLong())
				address . state = params.state?:''//State.get(params.state?.toLong())
				address . zipcode = params.zipcode?:''
				address . county = params.county?:''//County.get(params.county?.toLong())
				address . isActive = (short)1
				address . rowCreated = new Date()
				address . save(flush:true)
				if(!address.validate()){
					address.errors.each {
						println it
					}
				}
				return address
			}else{
				//do nothing
			}
			return address
		}catch(Exception exception){
			throw exception
		}
	}
	
	
	def getReceived(session ,params){
		try{
			HealpalUser user = session.user
			def list  = Referrals.createCriteria().list(params){
				eq('patientByPatientFkReceiver',Patient.findByPerson(user?.person))
				eq('mailboxTypeByReceiverMaiboxTypeFk' ,MailboxType.findByMailboxTypeName(MailboxType.inbox))
				if(params.from?.toString()?.equalsIgnoreCase("dashboard")){ //println "----dashboard"
					if(params.referralCategory?.toString()?.equalsIgnoreCase(ReferralCategory.expert)){ //println "----expert"
						eq('referralCategory',ReferralCategory.findByCategoryName(ReferralCategory.expert))
					}else if(params.referralCategory?.toString()?.equalsIgnoreCase(ReferralCategory.trial)){ //println "----clinic"
						eq('referralCategory',ReferralCategory.findByCategoryName(ReferralCategory.trial))
					}
				}
				eq('isActive',(short)1)
				if(params.sort == null && params.order == null){
					order('rowCreated','desc')
				}
			}
			return list
		}catch(Exception exception){
			throw exception 
		}
	}
	
	static def getNotifications(HealpalUser user){
		try{
			//println "ReferralsService . getNotifications :"+user
			def list
			if(user){
				list = Referrals.createCriteria().list(){
					eq('patientByPatientFkReceiver',Patient.findByPerson(user?.person))
					eq('isActive',(short)1)
					eq('viewed',(short)0)
					maxResults(5)
					order('rowCreated','desc')
				}
			}
			//println "ReferralsService . getNotifications list :" + list
			return list
		}catch(Exception exception){
			exception.printStackTrace()
		}
	}
	
	def getReceivedCount(session ,params){ //println("----count")
		try{
			HealpalUser user = session.user
			def list  = Referrals.createCriteria().list(){
				eq('patientByPatientFkReceiver',Patient.findByPerson(user?.person))
				eq('mailboxTypeByReceiverMaiboxTypeFk' ,MailboxType.findByMailboxTypeName(MailboxType.inbox))
				eq('isActive',(short)1)
				if(params.from?.toString()?.equalsIgnoreCase("dashboard")){ //println "----dashboard"
					if(params.referralCategory?.toString()?.equalsIgnoreCase(ReferralCategory.expert)){ //println "----expert"
						eq('referralCategory',ReferralCategory.findByCategoryName(ReferralCategory.expert))
					}else if(params.referralCategory?.toString()?.equalsIgnoreCase(ReferralCategory.trial)){ //println "----clinic"
						eq('referralCategory',ReferralCategory.findByCategoryName(ReferralCategory.trial))
					}
				}
			}
			return list?.size()
		}catch(Exception exception){
			throw exception
		}
	}
	
	def getProvided(session ,params){
		try{
			HealpalUser user = session.user 
			def list  = Referrals.createCriteria().list(params){
				eq('patientByPatientFkSender',Patient.findByPerson(user?.person))
				eq('mailboxTypeBySenderMaiboxTypeFk' ,MailboxType.findByMailboxTypeName(MailboxType.sent))
				eq('isActive',(short)1)
				if(params.sort == null && params.order == null){
					order('rowCreated','desc')
				}
			}
			return list
		}catch(Exception exception){
			throw exception
		}
	}
	
	def getProvidedCount(session){
		try{
			HealpalUser user = session.user
			def list  = Referrals.createCriteria().list(){
				eq('patientByPatientFkSender',Patient.findByPerson(user?.person))
				eq('mailboxTypeBySenderMaiboxTypeFk' ,MailboxType.findByMailboxTypeName(MailboxType.sent))
				eq('isActive',(short)1)
			}
			return list?.size()
		}catch(Exception exception){
			throw exception
		}
	}
	
	def isDoctorExist(params){
		try{
			return Doctor.createCriteria().list(){
					eq('firstName',params.firstName)
					eq('lastName',params.lastName)
					eq('specialty',params.specialty)
					eq('phoneNumber',params.phoneNumber)
					
			}
		}catch(Exception exception){
			throw exception
		}
	}
	
	def getClinics(){
		try{
			return ClinicalTrial.createCriteria().list(){
				eq('isActive' ,(short)1)
				//order('name','asc')
			} 
		}catch(Exception exception){
			throw exception
		}
	}
	
	def getDoctors(){
		try{
			return Doctor.createCriteria().list(){
				eq('isActive' ,(short)1)
				order('doctorName','asc')
			}
		}catch(Exception exception){
			throw exception
		}
	}
	
}
