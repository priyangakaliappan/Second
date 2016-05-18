package com.healpal.care

class GetAnswersController {

	def GetAnswersService getAnswersService
    def index() { }
	
	def view()
	{
		authorizeMe()   //***** Check Authorization
		try{
			params.max = Math.min(params.max ? params.int('max') : 10, 100)
			def getAnswers = getAnswersService.viewAll()
			println "getAnswers;;;;;;;;;;;;;;;;"+getAnswers
			[getAnswers:getAnswers,total:AskAnswersHomePage.list()?.size(),offset:0 ,max : params.max]
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	def edit()
	{
		println "inside edit;;;;;;;;;;;;;;;getAnswerID;;;;;"+params. getAnswerID
		authorizeMe()
			def getAnswers = AskAnswersHomePage.get(params.getAnswerID)
			println "params.getAnswerID;;;;;"+params.getAnswerID
			
			
			
			
			if(params.getAnswerID !=null && !params.getAnswerID.isEmpty() && params.yourQuestion != null && !params.yourQuestion.isEmpty() && params.answers != null && !params.answers.isEmpty() ){
		println "check all params;;;"
			if(request.post){
				println "request.post;;;;;;;;;;;;;;;;"
				update(params)
			}
			else
			{
				println "request.not ...post;;;;;;;;;;;;;;;;"
			}
	}
		
			[getAnswers:getAnswers,getAnswerID:params.getAnswerID]
		
	}
	
	
	
	def update(params){
		println "params;;;;;;;;;;;;;;;;;"+params
		authorizeMe() //***** Check Authorization
		
		try{
			if(params.getAnswerID !=null && !params.getAnswerID.isEmpty() &&
				  params.yourQuestion != null && !params.yourQuestion.isEmpty() && params.answers != null && !params.answers.isEmpty() ){
			
				println "inside update;;;;if loop;;;;;;;;;;;;;"+params.getAnswerID
				AskAnswersHomePage getAnswers = getAnswersService.update(new AskAnswersHomePage() ,params)
				println "shareYourStory;;;;;;;;;;;;;"+ getAnswers
				if(getAnswers != null && getAnswers.validate()){
					//auditEventService . save(AuditEventType.updatedHormoneTherapy,Role.admin, session)
					flash.msg = "Answers updated successfully"
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
		
		ShareYourStory shareYourStory = getAnswersService.approve(new ShareYourStory() ,params)
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
			def getAnswers = getAnswersService.viewAll(params)
			render (template :'list' ,model:[getAnswers : getAnswers ,total:params.size ,offset:params.offset ,max :params.max])
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
