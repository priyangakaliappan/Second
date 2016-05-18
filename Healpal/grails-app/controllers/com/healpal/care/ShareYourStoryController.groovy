package com.healpal.care

class ShareYourStoryController {
 def ShareYourStoryService shareYourStoryService
	
    def index() { }
	
	def view()
	{
		authorizeMe()   //***** Check Authorization
		try{
			params.max = Math.min(params.max ? params.int('max') : 10, 100)
			def shareYourStory = shareYourStoryService.viewAll()
			println "shareYourStory;;;;;;;;;;;;;;;;"+shareYourStory
			[shareYourStory:shareYourStory,total:ShareYourStory.list()?.size(),offset:0 ,max : params.max]
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	def edit()
	{
		println "inside edit;;;;;;;;;;;;;;;shareYourStoryId;;;;;"+params. shareYourStoryId
		authorizeMe()
			def shareYourStory = ShareYourStory.get(params.shareYourStoryId)
			println "params.shareYourStoryId;;;;;"+params.shareYourStoryId
			
			
			
			
			if(params.shareYourStoryId !=null && !params.shareYourStoryId.isEmpty() &&
			 params.status != null && !params.status.isEmpty()
		&&	params.storyTitle!= null && !params.storyTitle.isEmpty() && params.yourStory != null && !params.yourStory.isEmpty() ){
			if(request.post){
				println "request.post;;;;;;;;;;;;;;;;"
				update(params)
				//update(params)
				//def alreadyExist=ShareYourStory.findByPatientFkIlike(params.patientName)
				/*if(alreadyExist){
					if(!alreadyExist.id.toString().equals(params.shareYourStoryId)){
						flash.msg = "Hormone therapy drug '"+params.hormoneTherapyName+ "' with this name already exists"
					}else{
					update(params)
					}
				}else{
				update(params)
				}*/
			}
			else
			{
				println "request.not ...post;;;;;;;;;;;;;;;;"
			}
	}
		
			[shareYourStory:shareYourStory,shareYourStoryId:params.shareYourStoryId]
		
	}
	
	
	
	def update(params){
		println "params;;;;;;;;;;;;;;;;;"+params
		authorizeMe() //***** Check Authorization
		
		try{
			if(params.shareYourStoryId !=null && !params.shareYourStoryId.isEmpty() &&
				 params.status != null && !params.status.isEmpty()
			&&	params.storyTitle!= null && !params.storyTitle.isEmpty() && params.yourStory != null && !params.yourStory.isEmpty() ){
			
				println "inside update;;;;if loop;;;;;;;;;;;;;"+params.shareYourStoryId
				ShareYourStory shareYourStory = shareYourStoryService.update(new ShareYourStory() ,params)
				println "shareYourStory;;;;;;;;;;;;;"+shareYourStory
				if(shareYourStory != null && shareYourStory.validate()){
					//auditEventService . save(AuditEventType.updatedHormoneTherapy,Role.admin, session)
					flash.msg = "Share your Story '"+shareYourStory?.storyTitle+ "' updated successfully"
					redirect(action:'view')
				}
				else{
					
					}
				}
		}
				
			catch(Exception e){
			e.printStackTrace();
		}
		
		}
	
	
	def approve()
	{
		authorizeMe()
		println "inside approve"
		
		ShareYourStory shareYourStory = shareYourStoryService.approve(new ShareYourStory() ,params)
		flash.msg = "Share your Story approved successfully"
		println "shareYourStory"+shareYourStory
		redirect(action:'view')
		
		
	}
	
	def cancel()
	{
		try
		{
			redirect(action:'view')
		}
		catch(Exception exception)
		{
			exception.printStackTrace()
		}
	}
	
	def ajaxPaginate(){
		try{
			def shareYourStory = shareYourStoryService.viewAll(params)
			render (template :'list' ,model:[shareYourStory : shareYourStory ,total:params.size ,offset:params.offset ,max :params.max])
		}catch(Exception exception){
			exception.printStackTrace()
		}
	}
	def authorizeMe(){
		if(session.user && session.authority?.equalsIgnoreCase(Role.SuperAdmin)){
			// do nothing
		}else{
			flash.msg ="Sorry! you have not authorize to view this page"
			redirect(controller:'Home', action:'index')}
	}
}
