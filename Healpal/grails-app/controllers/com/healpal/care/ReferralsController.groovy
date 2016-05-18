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

class ReferralsController {

	def ReferralsService referralsService
	def ProfileService profileService
	def ConnectionService connectionService
	def AuditEventService auditEventService
	
    def index() { }
	
	def received(){
		try{
			authorizeMe()		//**** Check Authorization
			params.max = Math.min(params.max ? params.int('max') : 20, 100)
			
			if(params.refId != null && !params.refId.toString().isEmpty()){
				//update- once referrals message was viewed by patient
				Referrals  ref = Referrals.get(params.refId.toString().toLong())
				ref . viewed = (short)1
				ref . save(flush:true)
			}
			
			[reActive:'active',referActive:'active' ,received:referralsService.getReceived(session, params) ,total:referralsService.getReceivedCount(session ,params),offset:0 ,max : params.max]//photo:ProfilePhoto.findByPatient(Patient.findByPerson(HealpalUser.get(session.user?.id)?.person))?.profilePhotoPath
		}catch(Exception exception){
			exception.printStackTrace()
		}
	}
	
	def ajaxPaginateReceived(){
		try{
			if(session.user && session.authority?.equalsIgnoreCase(Role.patient)){
					render (template :'received' ,model:[received:referralsService.getReceived(session, params) ,total:params.size ,offset:params.offset ,max :params.max])
			}else{
					//do nothing
			}
		}catch(Exception exception){
			exception.printStackTrace()
			log.error(exception)
		}
	}
	
	
	def provided(){
		try{
			authorizeMe()		//**** Check Authorization
			params.max = Math.min(params.max ? params.int('max') : 20, 100)
			[proActive:'active',referActive:'active' ,provided:referralsService.getProvided(session, params) ,total:referralsService.getProvidedCount(session),offset:0 ,max : params.max]//photo:ProfilePhoto.findByPatient(Patient.findByPerson(HealpalUser.get(session.user?.id)?.person))?.profilePhotoPath
		}catch(Exception exception){
			exception.printStackTrace()
		}
	}
	
	def ajaxPaginateProvided(){
		try{
			if(session.user && session.authority?.equalsIgnoreCase(Role.patient)){
					render (template :'provided' ,model:[provided:referralsService.getProvided(session, params) ,total:params.size ,offset:params.offset ,max :params.max])
			}else{
					//do nothing
			}
		}catch(Exception exception){
			exception.printStackTrace()
			log.error(exception)
		}
	}
	
	
	// inbox referrals message view
	def viewMessage(){
		try{
			println "ReferralsController . viewMessage = initiated" + params.referralId 
			if(session.user && session.authority?.equalsIgnoreCase(Role.patient)){
				if(params.referralId != null && !params.referralId.toString().isEmpty()){
					Referrals ref = Referrals.get(params.referralId?.toLong())
					render(template:'viewMessage',model:[referral:ref 
						,clicnics : referralsService . getClinics() ,doctor:Doctor.get(ref?.referralsDoctors?.toString()?.toLong())])
				}else{
					render(template:'viewMessage',model:[referral:null])
				}	
			}
		}catch(Exception exception){
			exception.printStackTrace()
		}
	}
	
	
	def request(){
		try{
			authorizeMe() //**** Check Authorization
			switch(request.method){
				case 'GET':
					HealpalUser user = session.user
					// getting conencted patient list
					List<Patient> list1 = connectionService.getConnectionList(user,params)
					list1.remove(Patient.findByPerson(user?.person)) // remove current user from the list
					def list = Patient.createCriteria().list(){
						'in'('id',list1?.id)
						person{
							order('fullName','asc')
						}
					}
					[clicnics : referralsService . getClinics() ,reqActive:'active' ,referActive:'active' ,connections:list]//photo:ProfilePhoto.findByPatient(Patient.findByPerson(HealpalUser.get(session.user?.id)?.person))?.profilePhotoPath
				break;
				case 'POST':
						// expert category referrals request message save
						if(params != null && params.category != null && params.category.toString().equalsIgnoreCase(ReferralCategory.expert)
							&& params.message != null && !params.message.toString().isEmpty()
							&& params.patient != null && !params.patient.toString().isEmpty()){
							println "ReferralsController . request = request provider initiated"
							
							Referrals referral = referralsService . save(params ,MailboxType.sent ,MailboxType.inbox ,ReferralCategory.expert ,Referrals.request ,session ,"")
							if(referral.validate()){
								auditEventService . save(AuditEventType.addedRequestDocReferral, Role.patient, session) // audit save
								println "ReferralsController . request = request provider saved successfully"
								render "Your recommendation request has been sent to the patient : "+referral?.patientByPatientFkReceiver?.person?.fullName
							}else{
								render "Request sent failed"	
							}
						}
						// Clinical trial category referrals request message save 
						if(params != null && params.category != null && params.category.toString().equalsIgnoreCase(ReferralCategory.trial)
							&& params.message != null && !params.message.toString().isEmpty()
							//&& params.clinicalTrial != null && !params.clinicalTrial.toString().isEmpty()
							&& params.patient != null && !params.patient.toString().isEmpty()){
							println "ReferralsController . request = request clinics trial initiated"
							Referrals referral = referralsService . save(params ,MailboxType.sent ,MailboxType.inbox ,ReferralCategory.trial ,Referrals.request ,session ,"")
							if(referral.validate()){
								auditEventService . save(AuditEventType.addedRequestCliReferral, Role.patient, session) // audit save
								println "ReferralsController . request = request clinic saved successfully"
								render "Your recommendation request has been sent to the patient : "+referral?.patientByPatientFkReceiver?.person?.fullName
							}else{
								render "Request sent failed"
							}
						}
				break;
			}
		}catch(Exception exception){
			exception . printStackTrace()
		}
	}
	
	
	def provide(){
		try{
			authorizeMe()			//**** Check Authorization
			switch(request.method){
				case 'GET':
					HealpalUser user = session.user
					List<Patient> list1 = connectionService.getConnectionList(user,params)
					list1.remove(Patient.findByPerson(user?.person))
					def list = Patient.createCriteria().list(){
						'in'('id',list1?.id)
						person{
							order('fullName','asc')
						}
					}
					[clicnics : referralsService . getClinics() , provActive:'active' ,referActive:'active' ,connections:list ,doctors:referralsService.getDoctors()]//photo:ProfilePhoto.findByPatient(Patient.findByPerson(HealpalUser.get(session.user?.id)?.person))?.profilePhotoPath
				break;
				case 'POST':
						//Expert category referrals provide message save
						if(params != null && params.category != null && params.category.toString().equalsIgnoreCase(ReferralCategory.expert)
							&& params.message != null && !params.message.toString().isEmpty()){
							println "ReferralsController . request = request provider initiated"
							
							String doctors = params.doctor?.toString()//profileService . add(params ,session ,referralsService.addressSave(params))?.id.toString()
							
							Referrals referral = referralsService . save(params ,MailboxType.sent ,MailboxType.inbox ,ReferralCategory.expert ,Referrals.provide ,session ,doctors)
							if(referral.validate()){
								//goodwillpointsUpdate(Person.get(user.person?.id))
								auditEventService . save(AuditEventType.addedProvidedDocReferral, Role.patient, session) // audit save
								println "ReferralsController . provide = provider saved successfully"
								render "Recommendation has been sent to the Patient : "+referral?.patientByPatientFkReceiver?.person?.fullName
							}else{
								render "Request sent failed"
							}
						}
						// Clinical trial category referrals provide message save
						if(params != null && params.category != null && params.category.toString().equalsIgnoreCase(ReferralCategory.trial)
							&& params.message != null && !params.message.toString().isEmpty()
							//&& params.clinicalTrial != null && !params.clinicalTrial.toString().isEmpty()
							){
							println "ReferralsController . provide = provide clinics trial initiated"
							Referrals referral = referralsService . save(params ,MailboxType.sent ,MailboxType.inbox ,ReferralCategory.trial ,Referrals.provide ,session ,"")
							if(referral.validate()){
								//goodwillpointsUpdate(Person.get(user.person?.id))
								auditEventService . save(AuditEventType.addedProvidedCliReferral, Role.patient, session) // audit save
								println "ReferralsController . provide = provide clinic saved successfully"
								render "Recommendation has been sent to the Patient : "+referral?.patientByPatientFkReceiver?.person?.fullName
							}else{
								render "Request sent failed"
							}
						}
				break;
			}
			
			
		}catch(Exception exception){
			exception . printStackTrace()
		}
	}
	
	/**
	 * @param person
	 * @return
	 */
	def goodwillpointsUpdate(def person)
	{
		try
		{
			if(person)
			{
				if(person.goodWillPoints=="" || person.goodWillPoints==null)
				{
					person.goodWillPoints=0
				}
				person.goodWillPoints=person.goodWillPoints + 200
				person.save(flush:true)
			}
		}
		catch(Exception exception){
			exception.printStackTrace();}
	}

	def doctor(){
		try{
			switch(request.method){
				case 'GET':
				break;
				case 'POST':
				if(params != null){
					if(referralsService . isDoctorExist(params)){
						render(template:'doctors',model:[doctors:referralsService.getDoctors() ,msg:'Doctor already exist choose here'])
					}else{
						Doctor doctor = profileService . add(params ,session ,referralsService.addressSave(params))
						if(doctor.validate()){
							auditEventService . save(AuditEventType.addedDoctor, Role.patient, session) // audit save
							println "ReferralsController . doctor = doctor saved successfully" 
							render(template:'doctors',model:[doctors:referralsService.getDoctors() ,msg:'Doctor added successfully choose here'])
						}
					}
				}
				break;
			}
		}catch(Exception exception){
			exception.printStackTrace()
		}
	}
	
	
	def viewDoctor(){
		try{
			println "ReferralsController . viewDoctor = view doctor initiated"
			if(session.user && session.authority?.equalsIgnoreCase(Role.patient)){
					if(params.patientId!=null && !params.patientId.toString().isEmpty()){
						println "ReferralsController . viewDoctor = id :" + params.patientId
						render(template:'viewDoctor' ,model:[doctor:Doctor.get(params.patientId?.toLong()) ,clicnics : referralsService . getClinics()])
					}
			}
		}catch(Exception exception){
			exception . printStackTrace()
		}
	}
	
	//******************************************
	 def authorizeMe(){
		 if(session.user && session.authority?.equalsIgnoreCase(Role.patient)){
			 //do nothing
		 }else{
			 redirect controller :'auth' ,action :'doLogout'
		 }
	 }
}
