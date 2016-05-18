package com.healpal.care

import grails.transaction.Transactional

@Transactional
class ProfileQuestionAnswerService {

    def serviceMethod() {

    }
	
	ProfileQuestionAnswer save(def profileQuestion,String answer,HealpalUser user ){
		ProfileQuestionAnswer saveProfile=new ProfileQuestionAnswer();
		saveProfile.profileQuestions=ProfileQuestions.get(profileQuestion.toLong())
		saveProfile.answer=answer
		saveProfile.patient=Patient.findByPerson(user?.person);
		saveProfile.rowCreated=new Date();
		saveProfile.isActive=(short)1;
		saveProfile.save();	
		return saveProfile
	}
	
	boolean updateProfile(params, HealpalUser user) throws Exception{
		try{
			boolean deleteStatus=false
			if(params && params.profileQuestion!=null && !params.profileQuestion.isEmpty() && user){
				def deleteExistsprofileQuestion=ProfileQuestionAnswer.createCriteria().list {
					eq("profileQuestions",ProfileQuestions.get(params.profileQuestion.toLong()))
					eq("patient",Patient.findByPerson(user?.person))
				}
				if(deleteExistsprofileQuestion){
					deleteExistsprofileQuestion.each{
						def deleteProfile=ProfileQuestionAnswer.get(it?.id);
						if(deleteProfile){
							deleteProfile.delete();
							if(!deleteProfile . validate()){
								deleteProfile . errors . each {  println it  }
							}
							else{
								deleteStatus=true
							}
						}
					}
				}
				else{
					deleteStatus=true
				}
			}
			return deleteStatus
		}catch(Exception exception){
			throw exception
		}
	}
	
	
	
	
	
	
	
}
