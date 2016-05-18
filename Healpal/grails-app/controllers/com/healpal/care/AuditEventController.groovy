/*
 * Author    : Manikandan
 * Project   : Healpal
 * Date      : 10/19/2015
 * Description : AuditEvents listing 
 *
 * #   Name       Version   Modified-Date      Description
 * -------------------------------------------------------------------------------------
 * 1   Manikandan    1.0               Initial Creation
 *
 */

package com.healpal.care

class AuditEventController {

	def AuditEventService auditEventService
	
	
    def index() { }
	
	def view(){
		try{
			authorizeMe() //***** Check Authorization
			params.max = Math.min(params.max ? params.int('max') : 10, 100)
			[logs : auditEventService.getList(params) ,total:AuditEvent.list()?.size() ,offset:0 ,max : params.max,searchValue:""]
		}catch(Exception exception){
			exception . printStackTrace()
		}
	}
	
	
	def ajaxPaginate(){
		try{
			if(session.user && session.authority?.equalsIgnoreCase(Role.admin)){
					render (template :'list' ,model:[logs : auditEventService.getList(params) ,total:auditEventService.getCount(params) ,offset:params.offset ,max :params.max,searchValue:params.searchValue])
			}else{
					//do nothing
			}
		}catch(Exception exception){
			exception.printStackTrace()
		}
	}
	
	def clearAll(){
		def clear=AuditEvent.executeUpdate("delete  from  AuditEvent")
		redirect(action:'view')
	}
	
	
	//******************************************
	 def authorizeMe(){
		 if(session.user && session.authority?.equalsIgnoreCase(Role.admin)){
			 //do nothing
		 }else{
			 redirect controller :'auth' ,action :'doLogout'
		 }
	 }
	 def searchValues(){
		 try{
			 params.max = Math.min(params.max ? params.int('max') :10, 100)
			 def searchList = auditEventService.getList(params)
			 render(template:"list",model:[logs :searchList ,total:auditEventService.getCount(params) ,offset:0 ,max : params.max, searchValue: params.searchValue])
		 }catch(Exception exception){ exception.printStackTrace() }
	 }
}
