/*
 * Author    : Subhapriya M
 * Project   : Healpal
 * File      : HealthInsuranceController
 * Date      : 23-10-2015
 * Description : Show all HealthInsurance, Create a HealthInsurance, edit a HealthInsurance
 *
 * #   Name           Version           Modified-Date      Description
 * -------------------------------------------------------------------------------------
 * 1   Subhapriya M    1.0               23-10-2015         Initial Creation
 *
 */
package com.healpal.care
import com.healpal.care.HealthInsuranceService
import com.healpal.care.AuditEventService
class HealthInsuranceController {
	/**
	 *
	 * @author Subhapriya M
	 *
	 */
	def HealthInsuranceService healthInsuranceService;
	def AuditEventService auditEventService;
	def index() {
	}
	/**
	 * @return get all Health Insurance
	 */
	def view() {
		try{
			authorizeMe()
			params.max = Math.min(params.max ? params.int('max') :10, 100)
			[healthInsuranceList:healthInsuranceService.getHealthInsuranceList(params),getHealthInsuranceListTotal:HealthInsurance.list()?.size() ,offset:0 ,max : params.max, searchValue : ""]
		}
		catch(NullPointerException e){
			e.printStackTrace()
		}

	}
	/**
	 * @return create a Health Insurance
	 */
	def add(){
		authorizeMe() //***** Check Authorization
	}
	def cancel(){
		authorizeMe() //***** Check Authorization
		redirect(controller:"HealthInsurance" , action:"view")

	}
	/**
	 *
	 * @return save Health Insurance
	 */

	def create(){
		try{
			authorizeMe() //***** Check Authorization
			def healthInsurance=params.healthInsurance
			if(params != null && params.healthInsurance!= null && !params.healthInsurance.isEmpty()){
				
				def healthExist=HealthInsurance.findByHealthInsuranceTypeIlike(params.healthInsurance)
				if(healthExist !=null){
					flash.msg ="Health Insurance Type '"+params.healthInsurance+"'"+" with this name already exists"
					redirect(controller:"HealthInsurance" , action:"add")
				}else{
				HealthInsurance status=healthInsuranceService.save(params);
				if(status!=null && status.validate()){
					auditEventService . save(AuditEventType.addedHealthInsurance, Role.admin, session)
					flash.msg ="Health Insurance Type '"+status.healthInsuranceType+"'"+" name saved successfully"
					redirect(controller:"HealthInsurance" , action:"view")
				}
				else{
					flash.msg="Health Insurance Type Creation Failed due to some error"
					redirect(controller:"HealthInsurance" , action:"add")
					}
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
	 * @return edit a Health Insurance
	 */
	
	
	
	def edit(){
		authorizeMe()
		if(params.healthInsuranceId != null&& !params.healthInsuranceId.isEmpty()){
			def healthInsurance = HealthInsurance.get(params.healthInsuranceId.toLong())
			if(request.post){
				def healthExist=HealthInsurance.findByHealthInsuranceTypeIlike(params.healthInsurance)
				if(healthExist){
					if(!healthExist.id.toString().equals(params.healthInsuranceId)){
						flash.msg ="Health Insurance Type '"+params.healthInsurance+"'"+" with this name already exists"
					}else{
					update(params)
					}
				}else{
				update(params)
				}
			}
			
			[healthInsurance:healthInsurance]
		}else{
		// do nothing
		}
	}
	/**
	 *
	 * @return update a  Health Insurance
	 */
	def update(params){
		try{
			authorizeMe() //***** Check Authorization
			if(params!= null && params.healthInsuranceId!=null && !params.healthInsuranceId.isEmpty() && params.healthInsurance!=null && !params.healthInsurance.isEmpty()){
				
			
				HealthInsurance updateEducation=healthInsuranceService.update(params);
				if(updateEducation!=null && updateEducation.validate()){
					auditEventService . save(AuditEventType.updatedHealthInsurance, Role.admin, session)
					flash.msg ="Health Insurance Type '"+updateEducation.healthInsuranceType+"'"+" name updated sucessfully"
					redirect(controller:"HealthInsurance" , action:"view")
				}
				else{
					
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
	 * @return delete a Health Insurance
	 */
	def delete(){
		try{
			authorizeMe() //***** Check Authorization
			if(params!=null && params.healthInsuranceId!=null &&!params.healthInsuranceId.isEmpty()){
				boolean deleteHealthInsurance=healthInsuranceService.delete(params)
				if(deleteHealthInsurance){
					auditEventService . save(AuditEventType.deletedHealthInsurance, Role.admin, session)
					flash.msg ="Health Insurance Type '"+HealthInsurance.get(params.healthInsuranceId).healthInsuranceType+"'"+" name has been made Inactive"
				}
				else{
					flash.msg= "Health Insurance Type Deletion Failed due to some error"
				}
				redirect(controller:"HealthInsurance" , action:"view")
			}
			else{
				//do nothing
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
			render (template :'view',
			model:[healthInsuranceList:healthInsuranceService.getHealthInsuranceList(params),getHealthInsuranceListTotal:healthInsuranceService.getCount(params) ,offset:0 ,max : params.max, searchValue: params.searchValue])
		}catch(Exception exception){
			exception.printStackTrace()
		}
	}
	def searchValues(){
		try{
			params.max = Math.min(params.max ? params.int('max') :10, 100)
			render(template:"view",model:[healthInsuranceList:healthInsuranceService.getHealthInsuranceList(params),getHealthInsuranceListTotal:healthInsuranceService.getCount(params),offset:0 ,max : params.max, searchValue: params.searchValue])
		}catch(Exception exception){ exception.printStackTrace() }
	}
	
}
