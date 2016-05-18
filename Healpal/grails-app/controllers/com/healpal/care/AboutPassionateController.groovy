package com.healpal.care

class AboutPassionateController {
def AboutPassionateService aboutPassionateService
    def index() { }
	
	def view(){
		try{
			authorizeMe()
			params.max = Math.min(params.max ? params.int('max') :10, 100)
			[aboutPassionateList:aboutPassionateService.aboutPassionateList(params),aboutPassionateListTotal:Person.list()?.size() ,offset:0 ,max : params.max,searchValue:""]
		}
		catch(NullPointerException e){
			e.printStackTrace()
		}
	}
	
	def ajaxPaginate(){
		try{
			//def hormoneTherapy = aboutYouService.getAboutYouList(params)
			
			render (template :'list',
			model:[aboutPassionateList:aboutPassionateService.aboutPassionateList(params),aboutPassionateListTotal:aboutPassionateService.getCount(params) ,offset:0 ,max : params.max, searchValue: params.searchValue])
		}catch(Exception exception){
			exception.printStackTrace()
		}
	}
	
	def edit(){
		authorizeMe()
		if(params.abtpassId != null&& !params.abtpassId.isEmpty()){
			def aboutYouPass=Person.get(params.abtpassId)
			if(request.post){
				update(params)
				}
			
				[aboutPass:aboutYouPass]
			}else{
		// do nothing
		}
			
		
	}

	def update(params){
		try {
			authorizeMe()
			if(params!=null && params.abtpassId!=null && params.abtpassId!=null){
					Person passionateUpdate = aboutPassionateService.doUpdate(new Person() ,params)
					if(passionateUpdate !=null){
						flash.msg =passionateUpdate.fullName+" updated successfully"
					}
					redirect(action:"view");
		   }else{
		}
		}
		catch(Exception exception) {
			exception.printStackTrace()
		}
	}
	def cancel(){
		authorizeMe() //***** Check Authorization
		redirect(controller:"aboutPassionate" , action:"view")

	}
	
	def authorizeMe(){
		if(session.user && session.authority.equalsIgnoreCase(Role.admin)){
			//do nothing
		}else{
			redirect controller :'home' ,action :'index'
		}
	}
	def searchValues(){
		try{
			params.max = Math.min(params.max ? params.int('max') :10, 100)
			render(template:"list",model:[aboutPassionateList:aboutPassionateService.aboutPassionateList(params),aboutPassionateListTotal:aboutPassionateService.getCount(params),offset:0 ,max : params.max, searchValue: params.searchValue])
		}catch(Exception exception){
			exception.printStackTrace()
		}
	}

}
