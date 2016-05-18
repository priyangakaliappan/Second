package com.healpal.care

class DemographicController {

	def DemographicService demographicService
	def AuditEventService auditEventService
	
	def index() {}

	def view(){
		authorizeMe()
		params.max = Math.min(params.max ? params.int('max') : 2, 100)
		def demography = demographicService.viewAll(params)
		[demography:demography,total:Demographic.list()?.size(),offset:0 ,max : params.max]
	}
	
	
	def ajaxPaginate(){
		try{
			def hormoneTherapy = hormoneTherapyService.viewAll(params)
			render (template :'viewHormone' ,model:[hormoneTherapy : hormoneTherapy ,total:params.size ,offset:params.offset ,max :params.max])
		}catch(Exception exception){
			exception.printStackTrace()
		}
	}
	def authorizeMe(){
		if(session.user && session.authority?.equalsIgnoreCase(Role.admin)){
			// do nothing
		}else{
			flash.msg ="Sorry! you have not authorize to view this page"
			redirect(controller:'Home', action:'index')}
	}
	
	
}
