/*
 * Author    : Subhapriya M
 * Project   : Healpal
 * File      : PersonalInterestController
 * Date      : 23-10-2015
 * Description : Show all PersonalInterest, Create a PersonalInterest, edit a PersonalInterest
 *
 * #   Name           Version           Modified-Date      Description
 * -------------------------------------------------------------------------------------
 * 1   Subhapriya M    1.0               23-10-2015         Initial Creation
 *
 */
package com.healpal.care
import com.healpal.care.PersonalInterestService
import com.healpal.care.AuditEventService
class PersonalInterestController {

	/**
	 *
	 * @author Subhapriya M
	 *
	 */

	def PersonalInterestService personalInterestService
	def AuditEventService auditEventService;
	def index() {
	}

	/**
	 * @return get all Personal Interest
	 */

	def view() {
		
		try{
			authorizeMe()
			params.max = Math.min(params.max ? params.int('max') :10, 100)
			[personalInterestList:personalInterestService.getPersonalInterestList(params),personalInterestListTotal:PersonalInterest.list()?.size() ,offset:0 ,max : params.max]
		}
		catch(NullPointerException e){
			e.printStackTrace()
		}
	}

	/**
	 * @return create a Personal Interest
	 */

	def add(){
		authorizeMe() //***** Check Authorization
	}
	def cancel(){
		authorizeMe() //***** Check Authorization
		redirect(controller:"PersonalInterest" , action:"view")

	}

	/**
	 *
	 * @return save Personal Interest
	 */

	def create(){
		try{
			authorizeMe() //***** Check Authorization
			if(params != null && params.personalInterest!= null && !params.personalInterest.isEmpty()){
				
				def personalExist=PersonalInterest.findByPersonalInterestTypeIlike(params.personalInterest)
				
				if(personalExist !=null){
					flash.msg ="Personal Interest Type '"+params.personalInterest+"'"+" with this name already exists"
					redirect(controller:"PersonalInterest" , action:"add")
				}else{
				PersonalInterest personalInterests=personalInterestService.save(params);
				if(personalInterests!=null && personalInterests.validate()){
					auditEventService . save(AuditEventType.addedPersonalInterest, Role.admin, session)
					flash.msg ="Personal Interest Type '"+personalInterests.personalInterestType+"'"+" name saved successfully"
					
					redirect(controller:"PersonalInterest" , action:"view")
				}
				else{
					
					flash.msg="Personal Interest Type Creation Failed due to some error"
					redirect(controller:"PersonalInterest" , action:"add")
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
	 * @return edit a Personal Interest
	 */

	/*def edit(){
		try{
			authorizeMe() //***** Check Authorization
			if(params!=null && params.personalInterestId!=null &!params.personalInterestId.isEmpty()){
				def getPersonalInterestRow=PersonalInterest.get(params.personalInterestId);
				if(getPersonalInterestRow){
					[personalInterest:getPersonalInterestRow];
				}
				else{
					flash.msg="No records for current Id";
					redirect(controller:"PersonalInterest" , action:"view");
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}*/
	def edit(){
		authorizeMe()
		if(params.personalInterestId != null&& !params.personalInterestId.isEmpty()){
			def getPersonalInterestRow=PersonalInterest.get(params.personalInterestId);
			if(request.post){
				def alreadyExist=PersonalInterest.findByPersonalInterestTypeIlike(params.personalInterest)
				if(alreadyExist){
					if(!alreadyExist.id.toString().equals(params.personalInterestId)){
						flash.msg ="Personal Interest Type '"+params.personalInterest+"'"+"  with this name already exists"
					}else{
					update(params)
					}
				}else{
				update(params)
				}
			}
			[personalInterest:getPersonalInterestRow]
		}else{
		// do nothing
		}
	}
	/**
	 *
	 * @return update a  Personal Interest
	 */

	def update(params){
		try{
			authorizeMe() //***** Check Authorization
			def updatedId=params.personalInterestId;
			if(params!= null && params.personalInterestId!=null && !params.personalInterestId.isEmpty() && params.personalInterest!=null && !params.personalInterest.isEmpty()){
				
				
				PersonalInterest updatePersonalInterest=personalInterestService.update(params);
				if(updatePersonalInterest!=null && updatePersonalInterest.validate()){
					auditEventService . save(AuditEventType.updatedPersonalInterest, Role.admin, session)
					
					flash.msg ="Personal Interest Type '"+updatePersonalInterest.personalInterestType+"'"+" name updated successfully"
					redirect(controller:"PersonalInterest" , action:"view")
				}
				else{
					flash.msg="Personal Interest Updation Failed due to some error"
					redirect(controller:"PersonalInterest" , action:"view")
					
					}
				
				}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * @return delete a Personal Interest
	 */

	def delete(){
		try{
			authorizeMe() //***** Check Authorization
			def deletePersonalInterestId=params.personalInterestId;
			if(params!=null && params.personalInterestId!=null &&!params.personalInterestId.isEmpty()){
				boolean deletePersonalInterest=personalInterestService.delete(params)
				if(deletePersonalInterest){
					auditEventService . save(AuditEventType.deletedPersonalInterest, Role.admin, session)
					flash.msg ="Personal Interest Type '"+PersonalInterest.get(params.personalInterestId).personalInterestType+"'"+" name has been made Inactive"
				}
				else{
					flash.msg= "PersonalInterest Type Deletion Failed due to some error"
				}
				redirect(controller:"PersonalInterest" , action:"view")
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	def ajaxPaginate(){
		try{
			render (template :'view',
			model:[personalInterestList:personalInterestService.getPersonalInterestList(params),personalInterestListTotal:PersonalInterest.list()?.size() ,offset:0 ,max : params.max])
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
}
