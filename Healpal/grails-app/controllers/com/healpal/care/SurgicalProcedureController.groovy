/*
 * Author    : Priyanga K
 * Project   : Healpal
 * File      : SurgicalProcedureController
 * Date      : 23-10-2015
 * Description : Show all SurgicalProcedure, Create a SurgicalProcedure, edit a SurgicalProcedure
 *
 * #   Name           Version           Modified-Date      Description
 * -------------------------------------------------------------------------------------
 * 1   Priyanga K    1.0               23-10-2015         Initial Creation
 *
 */
package com.healpal.care
/**
 *
 *
 * @author Priyanga K
 *
 */

class SurgicalProcedureController {

	def SurgicalProcedureService surgicalProcedureService
	def AuditEventService auditEventService

	def index() {
	}
	
	/**
	 *
	 * @return all surgical procedure type
	 */
	def view(){
		authorizeMe()	//***** Check Authorization
		try{
			params.max = Math.min(params.max ? params.int('max') : 10, 100)
			def surgicalProcedureType = surgicalProcedureService.viewAll(params)
			[surgicalProcedureType:surgicalProcedureType,total:SurgicalProcedure.list()?.size(),offset:0 ,max : params.max,searchValue:"" ]
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	 *
	 * @return create surgical procedure type
	 */
	def create(){
		authorizeMe()	//***** Check Authorization
		render(view:'add')
	}
	/**
	 *
	 * @return save new surgical procedure type
	 */
	def save(){
		authorizeMe()	//***** Check Authorization
		try{
			if(params !=null && params.surgicalProcedure !=null && !params.surgicalProcedure.isEmpty()){
				
				def surgicalProcedureExist=SurgicalProcedure.findBySurgicalProcedureTypeIlike(params.surgicalProcedure)
				if(surgicalProcedureExist !=null){
					
					flash.msg = "SurgicalProcedure type '"+params.surgicalProcedure+ "' with this name already exists"
					redirect(action:'create')
					
				}else{
				SurgicalProcedure surgicalProcedure = surgicalProcedureService.save(params)
				if(surgicalProcedure != null && surgicalProcedure.validate()){
					auditEventService . save(AuditEventType.addedSurgicalProcedure,Role.admin, session)
					flash.msg = "SurgicalProcedure type '"+surgicalProcedure?.surgicalProcedureType+ "'name saved successfully"
					redirect(action:'view')
				}else{
					flash.msg =  "Surgical procedure creation failed due to some errors"
					redirect(action:'create')
				}
				}
			
				}else{
				//do nothing
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	 *
	 * @return edit already existing surgical procedure type
	 */
	
	
	def edit(){
		authorizeMe()
		if(params.surgicalProcedureTypeId != null&& !params.surgicalProcedureTypeId.isEmpty()){
			def surgicalProcedure=SurgicalProcedure.get(params.surgicalProcedureTypeId);
			if(request.post){
				def alreadyExist=SurgicalProcedure.findBySurgicalProcedureTypeIlike(params.surgicalProcedure)
				if(alreadyExist){
					if(!alreadyExist.id.toString().equals(params.surgicalProcedureTypeId)){
						flash.msg = "SurgicalProcedure type '"+params.surgicalProcedure+ "' with this name already exists"
					}else{
					update(params)
					}
				}else{
				update(params)
				}
			}
			[surgicalProcedure:surgicalProcedure]
		}else{
		// do nothing
		}
	}
	
	/**
	 *
	 * @return delete surgical procedure type
	 */
	def delete(){
		authorizeMe()	//***** Check Authorization
		try{
			if(params !=null && params.surgicalProcedureTypeId !=null && !params.surgicalProcedureTypeId.isEmpty()){
				def  surgicalProcedure = surgicalProcedureService.deleteSurgicalProcedure(params)
				if(surgicalProcedure !=null){
					auditEventService . save(AuditEventType.deletedSurgicalProcedure,Role.admin, session)
					//flash.msg = "SurgicalProcedure type has been made inactive"
					flash.msg ="SurgicalProcedure Type '"+SurgicalProcedure.get(params.surgicalProcedureTypeId).surgicalProcedureType+"'"+" name has been made Inactive"
				}
				else if(surgicalProcedure == null){
					flash.msg =  "SurgicalProcedure deletion failed due to some errors"
				}
			}
			else{

			}
		}catch(Exception e){
			e.printStackTrace();
		}
		redirect(action:'view')
	}

	def cancel(){
		authorizeMe()	//***** Check Authorization
		redirect(action:'view')}
	/**
	 *
	 * @return update name of existing surgical procedure type
	 */
	def update(params){
		authorizeMe()	//***** Check Authorization
		try{
			if(params !=null && params.surgicalProcedureTypeId !=null && !params.surgicalProcedureTypeId.isEmpty() &&
			params.surgicalProcedure !=null && !params.surgicalProcedure.isEmpty() && params.status !=null && !params.status.isEmpty()){
			
			SurgicalProcedure surgicalProcedure = surgicalProcedureService.update(params)
			if(surgicalProcedure != null && surgicalProcedure.validate()){
				auditEventService . save(AuditEventType.updatedSurgicalProcedure,Role.admin, session)
				flash.msg = "SurgicalProcedure type '"+surgicalProcedure?.surgicalProcedureType+ "'name updated sucessfully"
				redirect(action:'view')
			}else{
				flash.msg =  "Surgical procedure updation failed due to some errors"
				redirect(action:'edit')
			}
			
			
			
			
			
			}else{
				//do nothing
			}
		}catch(Exception e){
			e.printStackTrace();
		}

	}
	def ajaxPaginate(){
		try{
			def surgicalProcedureType = surgicalProcedureService.viewAll(params)
			render (template :'viewSurgical' ,model:[surgicalProcedureType : surgicalProcedureType ,total: surgicalProcedureService.getCount(params),offset:params.offset ,max :params.max,searchValue:params.searchValue])
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
	def searchValues(){
		try{
			params.max = Math.min(params.max ? params.int('max') :10, 100)
			render(template:"viewSurgical",model:[surgicalProcedureType : surgicalProcedureService.viewAll(params) ,total: surgicalProcedureService.getCount(params),offset:0 ,max : params.max, searchValue: params.searchValue])
		}catch(Exception exception){
			exception.printStackTrace()
		}
	}
}
