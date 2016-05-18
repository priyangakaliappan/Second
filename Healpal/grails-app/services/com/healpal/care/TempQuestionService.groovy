package com.healpal.care

import grails.transaction.Transactional

@Transactional
class TempQuestionService {

	def serviceMethod() {
	}
	def save(String question, String Value, HealpalUser user) {
		TempQuestionOption tempQues=new TempQuestionOption()
		tempQues.questionName=question
		tempQues.value=Value
		tempQues.patient=Patient.findByPerson(user?.person)
		tempQues.save()
	}

	boolean updateProfile(String question, HealpalUser user) throws Exception{
		try{
			boolean deleteStatus=false
			if(question!=null && !question.isEmpty() && user){
				def deleteExistsTempQuestion=TempQuestionOption.createCriteria().list {
					eq("patient",Patient.findByPerson(user?.person))
					eq("questionName",question)
				}
				if(deleteExistsTempQuestion){
					deleteExistsTempQuestion.each{
						def deleteProfile=TempQuestionOption.get(it?.id);
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
