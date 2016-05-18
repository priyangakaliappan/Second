package com.healpal.care

import grails.transaction.Transactional

@Transactional
class GetAnswersService {

    def serviceMethod() {

    }
	
	def viewAll(params)
	{
		def getAnswers
		try{
			getAnswers = AskAnswersHomePage.createCriteria().list() {
				println "getAnswers;;;;;;;;;;;;;;"+getAnswers
				//if(params.sort == null && params.order == null){
					println "inside if loop"
					order('rowCreated','desc')
				//}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return getAnswers
	}
	
	
	
	
	
	AskAnswersHomePage update(AskAnswersHomePage getAnswersUpdate ,params){
		try{
			AskAnswersHomePage getAnswers=AskAnswersHomePage.get(params.getAnswerID);
					getAnswers.yourQuestion = params.yourQuestion
                    getAnswers.answers = params.answers
			getAnswersUpdate = getAnswers.save();
			return getAnswersUpdate
		}catch(Exception exception){
			throw exception
		}
	}
	
	def approve(ShareYourStory storyUpdate,params)throws Exception
	{
		try{
		println "service;;;;;;;;;;;;;;"
		ShareYourStory shareYourStory=ShareYourStory.get(params.shareYourStoryId);
		shareYourStory.approved = 1
		storyUpdate = shareYourStory.save();
		return storyUpdate
		}
		catch(Exception exception){
			throw exception
		}
	}
	
}
