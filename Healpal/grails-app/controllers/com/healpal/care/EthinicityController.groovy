/*
 * Author    : Subhapriya M
 * Project   : Healpal
 * File      : EthinicityController
 * Date      : 23-10-2015
 * Description : Show all Ethinicity, Create a Ethinicity, edit a Ethinicity
 *
 * #   Name           Version           Modified-Date      Description
 * -------------------------------------------------------------------------------------
 * 1   Subhapriya M    1.0               23-10-2015         Initial Creation
 *
 */

package com.healpal.care

import com.healpal.care.AuditEventService;
import com.healpal.care.EthnicityService
class EthinicityController {
	/**
	 *
	 * @author Subhapriya M
	 *
	 */
	def EthnicityService ethnicityService;
	def AuditEventService auditEventService
	def index() {
	}
	/**
	 * @return get all Ethnicity
	 */
	def view() {
		
		try{
			authorizeMe()
			params.max = Math.min(params.max ? params.int('max') :10, 100)
			[ethinicityList:ethnicityService.getEthinicityList(params),ethinicityListTotal:Ethnicity.list()?.size() ,offset:0 ,max : params.max, searchValue : ""]
		}
		catch(NullPointerException e){
			e.printStackTrace()
		}
	}

	/**
	 * @return create a Ethnicity
	 */

	def add(){
		authorizeMe() //***** Check Authorization
	}
	def cancel(){
		authorizeMe() //***** Check Authorization
		redirect(controller:"Ethinicity" , action:"view")

	}

	/**
	 *
	 * @return save Ethnicity
	 */

	def create(){
		authorizeMe() //***** Check Authorization
		try{
			if(params != null && params.ethnicityName!= null && !params.ethnicityName.isEmpty()){
				
				def ethExist=Ethnicity.findByEthnicityNameIlike(params.ethnicityName)
				if(ethExist !=null){
					flash.msg ="Ethnicity '"+params.ethnicityName+"'"+" with this name already exists"
					redirect(controller:"Ethinicity" , action:"add");
				}else{
				Ethnicity ethinicity = ethnicityService.save(params)
				if(ethinicity!=null && ethinicity.validate()){
					auditEventService . save(AuditEventType.addedEthinicity, Role.admin, session)
					flash.msg ="Ethnicity '"+ethinicity.ethnicityName+"'"+" name saved successfully"
					
					//flash.msg= "Ethinicity Created Successfully"
					redirect(controller:"Ethinicity" , action:"view");
				}
				else{
					flash.msg= "Ethnicity Creation Failed due to some error"
					redirect(controller:"Ethinicity" , action:"add");
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
	 * @return edit a Ethnicity
	 */


	def edit(){
		authorizeMe()
		if(params.ethinicityId != null&& !params.ethinicityId.isEmpty()){
			def getEthinicityRow=Ethnicity.get(params.ethinicityId);
			if(request.post){
				def alreadyExist=Ethnicity.findByEthnicityNameIlike(params.ethnicityName)
				if(alreadyExist){
					if(!alreadyExist.id.toString().equals(params.ethinicityId)){
						flash.msg ="Ethnicity '"+params.ethnicityName+"'"+" with this name already exists"
					}else{
					update(params)
					}
				}else{
				update(params)
				}
			}
			[ethinicity:getEthinicityRow]
		}else{
		// do nothing
		}
	}
	
	
	/**
	 *
	 * @return update a  Ethnicity
	 */

	def update(params){
		authorizeMe() //***** Check Authorization
		try{
			if(params!= null && params.ethinicityId!=null && !params.ethinicityId.isEmpty() && params.ethnicityName!=null && !params.ethnicityName.isEmpty()){
			
				
				Ethnicity updateEthnicity=ethnicityService.update(params);
				if(updateEthnicity!=null && updateEthnicity.validate()){
					auditEventService . save(AuditEventType.updatedEthinicity, Role.admin, session)
					flash.msg ="Ethnicity '"+updateEthnicity.ethnicityName+"'"+" name updated sucessfully"
					redirect(controller:"Ethinicity" , action:"view");
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
	 * @return delete a Ethnicity
	 */

	def delete(){
		authorizeMe() //***** Check Authorization
		try{
			if(params!=null && params.ethinicityId!=null &&!params.ethinicityId.isEmpty()){
				boolean deleteEthnicity=ethnicityService.delete(params);
				if(deleteEthnicity){
					auditEventService . save(AuditEventType.deletedEthinicity, Role.admin, session)
					flash.msg ="Ethnicity '"+Ethnicity.get(params.ethinicityId).ethnicityName+"'"+" name has been made Inactive"
				}
				else{
					flash.msg= "Ethnicity Type Deletion Failed due to some error"
				}
				redirect(controller:"Ethinicity" , action:"view")
			}
			else{
				//
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	def ajaxPaginate(){
		try{
			render (template :'view',
				
			model:[ethinicityList:ethnicityService.getEthinicityList(params),ethinicityListTotal:ethnicityService.getCount(params) ,offset:0 ,max : params.max,searchValue : params.searchValue])
		}catch(Exception exception){
			exception.printStackTrace()
		}
	}
	
	
	def authorizeMe(){
		if(session.user && session.authority?.equalsIgnoreCase(Role.admin)){
		}
		else{
			redirect(controller:"home",action:"index")
		}
	}
	def searchValues(){
		try{
			params.max = Math.min(params.max ? params.int('max') :10, 100)
			render(template:"view",model:[ethinicityList: ethnicityService.getEthinicityList(params),ethinicityListTotal:ethnicityService.getCount(params),offset:0 ,max : params.max, searchValue: params.searchValue])
		}catch(Exception exception){ exception.printStackTrace() }
	}
}
