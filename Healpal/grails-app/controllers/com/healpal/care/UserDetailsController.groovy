package com.healpal.care

import java.text.DateFormat
import java.text.SimpleDateFormat

class UserDetailsController {

    def index() { }
	
	def UserDetailsService userDetailsService 
	
	def list(){
		
		try{
			authorizeMe() //*****  Authorization checking
			params.max = Math.min(params.max ? params.int('max') : 10, 100)
			
			if(params.searchValue !=null){
			render (template :'view' ,model:[userDetails : userDetailsService.getList(params),total:HealpalUser.list()?.size() ,offset:0 ,max : params.max])
			
			}else{
			[userDetails : userDetailsService.getList(params) ,total:HealpalUser.list()?.size() ,offset:0 ,max : params.max]
			}
		}catch(Exception exception){
			//exception.printStackTrace()
			log.error(exception)
		}
	}
	
	
	def ajaxPaginate(){
		authorizeMe()
		try{
			println"inside ajax"
			if(session.user && session.authority?.equalsIgnoreCase(Role.SuperAdmin)){
					render (template :'view' ,model:[userDetails : userDetailsService.getList(params) ,total:HealpalUser.list()?.size() ,offset:0 ,max : params.max])
			}else{
					//do nothing
			}
		}catch(Exception exception){
			exception.printStackTrace()
			log.error(exception)
		}
	}
	
	
	
	def cancelist(){
		authorizeMe() //*****  Authorization checking
		def diagnosis=Diagnosis.createCriteria().list(){
			order('diagnosisName','asc')
		}
		
		 params.max = Math.min(params.max ? params.int('max') : 10, 100)
		
		
		 if(params.cancerId !=null){
			 
			 render (template :'cancerView' ,model:[cancerType:userDetailsService.cancerType(params),total:HealpalUser.list()?.size() ,offset:0 ,max : params.max])
		 }else{
		 [diagnosis:diagnosis,cancerType:userDetailsService.cancerType(params),total:HealpalUser.list()?.size() ,offset:0 ,max : params.max]
		 }
		 
		
	}
	
	def cancerAjaxPaginate(){
		authorizeMe()
		
			if(session.user && session.authority?.equalsIgnoreCase(Role.SuperAdmin)){ 
				render (template :'cancerView' ,model:[cancerType:userDetailsService.cancerType(params),total:HealpalUser.list()?.size() ,offset:0 ,max : params.max])
				}
			else{
				//do nothing
				}
			}
				
	
	def loginCount(){
		authorizeMe()
		def today = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String format = formatter.format(today);
		def List=AuditEvent.executeQuery("select DISTINCT healpalUser, h from AuditEvent h where  to_char(h.auditEventTime,'yyyy-MM-dd') = '"+format+"'")
		[loginCountToday: List]
		
		
	}
	
	def authorizeMe(){
		if(session.authority?.equalsIgnoreCase(Role.SuperAdmin)){
			println"inside authroize me"
			//do nothing
		}else{
			redirect controller :'auth' ,action :'doLogout'
		}
	}
}
