/*
 * Author    : Manikandan
 * Project   : Healpal
 * Date      :
 * Description : service for the profile completion details save
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
class ProfileCompletionService {

    def serviceMethod() {

    }
	
	def saveMe(String action ,int completed ,session,percentage){
		try{
			println  "ProfileCompletionService . save = profile completion save initiated"
			ProfileCompletionDetail profile
			if(action != null && !action.isEmpty()
				&& completed != null && session.user != null){
				
				HealpalUser user = session.user
				if(user){
						if(ProfileCompletionDetail.findByPatient(Patient.findByPerson(user?.person))){
							if(!ProfileCompletionDetail.findByPatientAndProfileUpdated(Patient.findByPerson(user?.person) ,(short)1)){
							
								profile = ProfileCompletionDetail.findByPatient(Patient.findByPerson(user?.person))
								profile . rowAltered = new Date()
							
							}else{
								println  "ProfileCompletionService . save = profile already updated"
								return
							}
							
						}else{
							profile = new ProfileCompletionDetail()
							profile . rowCreated = new Date()
						}
					
						profile . profileUpdated = (short)completed
						profile . goToProfilePage = action
						profile . percentage = percentage
						profile . healpalUser = user
						profile . patient = Patient.findByPerson(user?.person)
						profile . save(flush:true)
						if(!profile.validate()){
							profile.errors.each {
								println it
							}
						}else{
							println  "ProfileCompletionService . save = profile saved successfully"
						}
				}
			}
				println "profile;;;;;;;;;;;;;;;;;;;"+profile
			return profile
		}catch(Exception exception){
			throw exception
		}
	}
	
	
	String check(session){
		try{
			def msg
			if(session.user != null){
				HealpalUser user = session.user
				if(ProfileCompletionDetail.findByPatient(Patient.findByPerson(user?.person))){
					ProfileCompletionDetail profile = ProfileCompletionDetail.findByPatientAndProfileUpdated(Patient.findByPerson(user?.person) ,(short)0)
					if(profile){
						println  "ProfileCompletionService . check = profile not updated"
							msg = 'go:'+profile?.goToProfilePage 
					}else{
						println  "ProfileCompletionService . check = profile updated"
							msg = "updated"
					}
				}else{
							msg = "not updated"
				}
			}else{
				//do nothing
			}
			return msg
		}catch(Exception exception){
			exception . printStackTrace()
		}
	}
	
}
