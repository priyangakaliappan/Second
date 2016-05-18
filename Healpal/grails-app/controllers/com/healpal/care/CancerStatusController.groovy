/*
 * Author    : Subhapriya M
 * Project   : Healpal
 * File      : CancerStatusController
 * Date      : 23-10-2015
 * Description : Show all CancerStatus, Create a CancerStatus, edit a CancerStatus
 *
 * #   Name           Version           Modified-Date      Description
 * -------------------------------------------------------------------------------------
 * 1   Subhapriya M    1.0               23-10-2015         Initial Creation
 *
 */
package com.healpal.care
import java.sql.SQLException;

import com.healpal.care.AuditEventService;
class CancerStatusController {
	/**
	 *
	 * @author Subhapriya M
	 *
	 */
	def CancerStatusService cancerStatusService;
	def AuditEventService auditEventService

	def index() {
	}

	/**
	 * @return get all Cancer status
	 */

	def view() {
		try{
			authorizeMe() //***** Check Authorization
			params.max = Math.min(params.max ? params.int('max') :10, 100)
			[statusList:cancerStatusService.getCancerStatusList(params),cancerStatusTotal:CancerStatus.list()?.size() ,offset:0 ,max : params.max, searchValue:""];
		}catch(Exception e){
			e.printStackTrace();
		}

	}

	/**
	 * @return create a Cancer status
	 */

	def add(){
		authorizeMe() //***** Check Authorization

	}
	def cancel(){
		authorizeMe() //***** Check Authorization
		redirect(controller:"CancerStatus" , action:"view")

	}
	/**
	 *
	 * @return save Cancer status
	 */

	def create(){
		authorizeMe()
		try
		{
			if(params != null && params.cancerStatus!= null && !params.cancerStatus.isEmpty()){
				
				
				def exist=CancerStatus.findByCancerStatusTypeIlike(params.cancerStatus)
				if(exist !=null){
					flash.msg ="Cancer Status '"+params.cancerStatus+"'"+" with this name already exists"
					redirect(controller:"CancerStatus" , action:"add")
				}else{
				CancerStatus status=cancerStatusService.save(params);
				if(status!=null && status.validate()){
					auditEventService . save(AuditEventType.addedCancerStatus, Role.admin, session)
					//flash.msg="Cancer Status Created Successfully"
					
					flash.msg ="Cancer Status '"+status.cancerStatusType+"'"+" name saved successfully"
					redirect(controller:"CancerStatus" , action:"view")
				}else{
				flash.msg ="Cancer Status Failed due to some error"
				}
				}
			}else{
			flash.msg ="Cancer Status Failed due to some error"
			}
			
			
			
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}

	/**
	 * @return edit a Cancer status
	 */

	/*def edit(){
		try
		{
			authorizeMe() //***** Check Authorization
			if(params!=null && params.statusId!=null &!params.statusId.isEmpty()){
				def getStatusRow=CancerStatus.get(params.statusId);
				if(getStatusRow){
					[cancerStatus:getStatusRow];
				}
				else{
					flash.msg="No records for current Id";
					redirect(controller:"CancerStatus" , action:"view");
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}*/
	def edit(){
		authorizeMe()
		if(params.statusId != null&& !params.statusId.isEmpty()){
			def getStatusRow=CancerStatus.get(params.statusId);
			if(request.post){
				def alreadyExist=CancerStatus.findByCancerStatusTypeIlike(params.cancerStatus)
				if(alreadyExist){
					if(!alreadyExist.id.toString().equals(params.statusId)){
						flash.msg ="Cancer Status '"+ params.cancerStatus +"'"+"  with this name already exists"
					}else{
					update(params)
					}
				}else{
				update(params)
				}
			}
			[cancerStatus:getStatusRow]
		}else{
		// do nothing
		}
	}
	/**
	 *
	 * @return update a  Cancer status
	 */

	def update(params){
		try
		{
			authorizeMe() //***** Check Authorization
			def updatedId=params.statusId;
			if(params!= null && params.statusId!=null && !params.statusId.isEmpty() && params.cancerStatus!=null && !params.cancerStatus.isEmpty()){
				CancerStatus updateStatus=cancerStatusService.update(params);
				if(updateStatus!=null && updateStatus.validate()){
					auditEventService . save(AuditEventType.updatedCancerStatus, Role.admin, session)
					flash.msg ="Cancer Status'"+updateStatus.cancerStatusType+"'"+"  name updated successfully"
					//flash.msg="Cancer Status Updated Successfully"
					redirect(controller:"CancerStatus" , action:"view")
				}
				


			}
			else{
				//do nothing
			}
		}catch(Exception e){
			e.printStackTrace();

		}
	}

	/**
	 *
	 * @return delete a Cancer status
	 */

	def delete(){
		try
		{
			authorizeMe() //***** Check Authorization
			//def deleteStatusId=params.statusId;
			if(params!=null && params.statusId!=null &&!params.statusId.isEmpty()){
				boolean updateStatus=cancerStatusService.delete(params);
				if(updateStatus){
					auditEventService . save(AuditEventType.deletedCancerStatus, Role.admin, session)
					//flash.msg= "Cancer Status Deleted Successfully"
					flash.msg ="Cancer Status '"+CancerStatus.get(params.statusId).cancerStatusType+"'"+" name has been made Inactive"
					
					}
				
				else{
					flash.msg= "Cancer Status Deletion Failed due to some error"
				}
				redirect(action:'view')
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	def authorizeMe(){
		if(session.user && session.authority?.equalsIgnoreCase(Role.admin)){
		}
		else{
			redirect(controller:"home",action:"index")
		}
	}
	
	def ajaxPaginate(){
		try{
			def cancerStageLevel = cancerStatusService.getCancerStatusList(params)
			render (template :'view',
			model:[statusList:cancerStatusService.getCancerStatusList(params),cancerStatusTotal:cancerStatusService.getCount(params) ,offset:0 ,max : params.max, searchValue: params.searchValue])
		}catch(Exception exception){
			exception.printStackTrace()
		}
	}
	def searchValues(){
		try{
			params.max = Math.min(params.max ? params.int('max') :10, 100)
			render(template:"view",model:[statusList:cancerStatusService.getCancerStatusList(params),cancerStatusTotal:cancerStatusService.getCount(params),offset:0 ,max : params.max, searchValue: params.searchValue])
		}catch(Exception exception){ exception.printStackTrace() }
	}
}
