package com.healpal.care

class WriteAReviewController {

	def WriteAReviewService writeAReviewService
    def index() { }
	
	def view()
	{
		authorizeMe()   //***** Check Authorization
		try{
			params.max = Math.min(params.max ? params.int('max') : 10, 100)
			def writeAreview = writeAReviewService.viewAll()
			println "writeAreview;;;;;;;;;;;;;;;;"+writeAreview
			[writeAreview:writeAreview,total:ShareYourStory.list()?.size(),offset:0 ,max : params.max]
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	
	def edit()
	{
		println "inside edit;;;;;;;;;;;;;;;writeAReviewId;;;;;"+params.writeAReviewId
		authorizeMe()
			def writeAreview = WriteAReview.get(params.writeAReviewId)
			println "params.writeAReviewId;;;;;"+params.writeAReviewId
			
			
			
			
			if(params.writeAReviewId !=null && !params.writeAReviewId.isEmpty() &&
			 params.status != null && !params.status.isEmpty()
		&&	params.storyTitle!= null && !params.storyTitle.isEmpty() && params.yourReview != null && !params.yourReview.isEmpty() 
		){
			if(request.post){
				println "request.post;;;;;;;;;;;;;;;;"
				update(params)
			}
			else
			{
				println "request.not ...post;;;;;;;;;;;;;;;;"
			}
	}
		
			[writeAreview:writeAreview,writeAReviewId:params.writeAReviewId]
		
	}
	
	
	def update(params){
		println "params;;;;;;;;;;;;;;;;;"+params
		authorizeMe() //***** Check Authorization
		try{
			if(params.writeAReviewId !=null && !params.writeAReviewId.isEmpty() &&
			 params.status != null && !params.status.isEmpty()
		&&	params.storyTitle!= null && !params.storyTitle.isEmpty() && params.yourReview != null && !params.yourReview.isEmpty() )
		{
			
				println "inside update;;;;if loop;;;;;;;;;;;;;"+params.writeAReviewId
				WriteAReview writeAReview = writeAReviewService?.update(new WriteAReview(),params)
				println "writeAReview;;;;;;;;;;;;;"+writeAReview
				if(writeAReview != null && writeAReview.validate()){
					//auditEventService . save(AuditEventType.updatedHormoneTherapy,Role.admin, session)
					flash.msg = "Share your Story '"+writeAReview?.reviewTitle+ "' updated successfully"
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
		WriteAReview writeAReview = writeAReviewService.approve(new WriteAReview() ,params)
		println "writeAReview?.approved;;;;;;;;;;;;;;;;"+writeAReview?.approved
		//if(writeAReview?.approved==null){
		flash.msg = "Write A Review approved successfully"
		println "writeAReview;;;;;;;;;;;;;;;;;;;;;;;"+writeAReview
		redirect(action:'view')
	}
	
	
	def ajaxPaginate(){
		try{
			def shareYourStory = writeAReviewService.viewAll(params)
			render (template :'list' ,model:[writeAreview : writeAreview ,total:params.size ,offset:params.offset ,max :params.max])
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
