package com.healpal.care

class JanToJunMonthController {
	def JanToJunMonthService janToJunMonthService
	def UserService userService
    def index() { }
	
	def view(){
		try {
			authorizeMe()
			//JAN-JUN Month Count
			//def sixMonth = Patient.executeQuery("select ae from Patient ae  where DATE(ae.rowCreated) between DATE('"+firstDateOfPreviousMonth1+"') and DATE('"+lastDateOfPreviousMonth2+"')");
			def currentYear = Calendar.getInstance().get(Calendar.YEAR);
			def janFirstDate=currentYear+"-01-01"
			def JunLastDate=currentYear+"-06-30"
			def janToJunMonthCount = HealpalUser.executeQuery("select ae from HealpalUser ae  where DATE(ae.rowCreated) between DATE('"+janFirstDate+"') and DATE('"+JunLastDate+"')");
			 
			
			params.max = Math.min(params.max ? params.int('max') : 10, 100)
			println "test"+janToJunMonthService.getList(params)?.size()
			
			[janToJunMonthCount:janToJunMonthCount,users : janToJunMonthService.getList(params),total:janToJunMonthCount?.size() ,offset:0 ,max : params.max,searchValue:""]
			}
			catch(Exception exception){
				//exception.printStackTrace()
				log.error(exception)
			}
	}
	
	def ajaxPaginate(){
		try{
			println"hiii"+userService.getCount(params)
			render (template :'janToJulList' ,model:[users : janToJunMonthService.getList(params) ,total:janToJunMonthService.getCount(params) ,offset:params.offset ,max :params.max,searchValue:params.searchValue])
		}catch(Exception exception){
			exception.printStackTrace()
		}
	}
	
	def searchValues(){
		try{
			params.max = Math.min(params.max ? params.int('max') :10, 100)
			render(template:"janToJulList",model:[users : janToJunMonthService.getList(params) ,total:janToJunMonthService.getCount(params),offset:0 ,max : params.max, searchValue: params.searchValue])
		}catch(Exception exception){ exception.printStackTrace() }
	}
	
	def authorizeMe(){
		if(session.user && session.authority !=null && (session.authority?.equalsIgnoreCase(Role.admin) || session.authority.equalsIgnoreCase(Role.SuperAdmin))){
			// do nothing
		}else{
			redirect(controller:'Home', action:'index')
		}
	}
}
