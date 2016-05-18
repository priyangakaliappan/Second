package com.healpal.care

class JulToDecMonthController {
   def JulToDecMonthService julToDecMonthService
   def UserService userService
    def index() { }
	
	def view(){
		authorizeMe()
		def currentYear = Calendar.getInstance().get(Calendar.YEAR);
		def julFirstDate=currentYear+"-07-01"
		def decLastDate=currentYear+"-12-31"
		def julToDecMonthCount = HealpalUser.executeQuery("select ae from HealpalUser ae  where DATE(ae.rowCreated) between DATE('"+julFirstDate+"') and DATE('"+decLastDate+"')");
		params.max = Math.min(params.max ? params.int('max') : 10, 100)
		println "test"+julToDecMonthService.getJulToDecMonthList(params)
		[julToDecMonthCount:julToDecMonthCount,users :julToDecMonthService.getJulToDecMonthList(params) ,total:julToDecMonthCount?.size() ,offset:0 ,max : params.max,searchValue:""]
	}
	
	def ajaxPaginate(){
		try{
		println "dfdf"+julToDecMonthService.getCount(params)
			render (template :'julToDecList' ,model:[users : julToDecMonthService.getJulToDecMonthList(params) ,total:julToDecMonthService.getCount(params) ,offset:params.offset ,max :params.max,searchValue:params.searchValue])
		}catch(Exception exception){
			exception.printStackTrace()
		}
	}
	
	def searchValues(){
		try{
			params.max = Math.min(params.max ? params.int('max') :10, 100)
			render(template:"julToDecList",model:[users : julToDecMonthService.getJulToDecMonthList(params) ,total:julToDecMonthService.getCount(params),offset:0 ,max : params.max, searchValue: params.searchValue])
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
