package com.healpal.care

import grails.transaction.Transactional

@Transactional
class ShareYourStoryService {

    def serviceMethod() {
    }
	
	def viewAll(params)
	{
		def shareYourStory
		try{
			shareYourStory = ShareYourStory.createCriteria().list() {
				println "shareYourStory;;;;;;;;;;;;;;"+shareYourStory
				//if(params.sort == null && params.order == null){
					println "inside if loop"
					order('rowCreated','desc')
				//}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return shareYourStory
	}
	
	
	
	
	
	ShareYourStory update(ShareYourStory storyUpdate ,params){
		try{
			ShareYourStory shareYourStory=ShareYourStory.get(params.shareYourStoryId);
			//shareYourStory.patientFk = params.patientName
					shareYourStory.storyTitle = params.storyTitle
					shareYourStory.yourStory = params.yourStory
					shareYourStory.isActive = params.status.equals("active")?(short)1:(short)0
					shareYourStory.rowAltered = new Date()
			storyUpdate = shareYourStory.save();
			return storyUpdate
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
		shareYourStory.rowAltered=new Date();
		storyUpdate = shareYourStory.save();
		return storyUpdate
		}
		catch(Exception exception){
			throw exception
		}
	}
	
	
	/*ShareYourStory update(params) {
		ShareYourStory shareYourStory = new ShareYourStory()
		try{
			println "Service Call"
			println "params.shareYourStoryId;;;;;;;;;"+params.storyId
			println "params.patientName;;;;;;;;;;;;;;"+params.patientName
			println "params.shareYourStoryId;;;;;;;;;;;;"+params.shareYourStoryId
			println "params.storyTitle;;;;;;;;;;;;;;;;;;"+params.storyTitle
			
			if(params.shareYourStoryId !=null && !params.shareYourStoryId.isEmpty() &&
			params.patientName !=null && !params.patientName.isEmpty() && params.status != null && !params.status.isEmpty()
		&&	params.storyTitle!= null && !params.storyTitle.isEmpty() && params.yourStory != null && !params.yourStory.isEmpty() ){
		println "inside service if loop;;;;;;;;;;;;;;;;"
				shareYourStory = ShareYourStory.get(params.shareYourStoryId)
				
				shareYourStory.withTransaction {status->
					shareYourStory.patientFk = params.patientName
					shareYourStory.storyTitle = params.storyTitle
					shareYourStory.yourStory = params.yourStory
					shareYourStory.isActive = params.status.equals("active")?(short)1:(short)0
					shareYourStory.rowAltered = new Date()
					shareYourStory.save(flush:true)
					if(!shareYourStory.validate()){
						status.setRollbackOnly()
					}
				}
			}
		}catch(Exception e){
			shareYourStory = null
		}
		return shareYourStory
	}*/
	
	
	
}
