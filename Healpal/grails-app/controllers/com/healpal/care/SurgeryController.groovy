/*
 * Author    : Subhapriya M
 * Project   : Healpal
 * File      : SurgeryController
 * Date      : 23-10-2015
 * Description : Show all Surgery, Create a Surgery, edit a Surgery
 *
 * #   Name           Version           Modified-Date      Description
 * -------------------------------------------------------------------------------------
 * 1   Subhapriya M    1.0               23-10-2015         Initial Creation
 *
 */

package com.healpal.care
import com.healpal.care.RaceService
import com.healpal.care.SurgeryService
class SurgeryController {

	/**
	 *
	 * @author Subhapriya M
	 *
	 */

	def SurgeryService surgeryService;
	def AuditEventService auditEventService;
	def index() {
	}

	/**
	 * @return get all Surgery
	 */

	
	
	def view(){
		try{
			authorizeMe()
			params.max = Math.min(params.max ? params.int('max') :10, 100)
			[surgeryList:surgeryService.getSurgeryList(params),surgeryListTotal:Surgery.list()?.size() ,offset:0 ,max : params.max,searchValue:""]
		}
		catch(NullPointerException e){
			e.printStackTrace()
		}
	}

	/**
	 * @return create a Surgery
	 */

	def add(){

		authorizeMe() //***** Check Authorization
	}
	def cancel(){
		authorizeMe() //***** Check Authorization
		redirect(controller:"Surgery" , action:"view")

	}

	/**
	 *
	 * @return save EduSurgerycation
	 */

	def create(){
		try{
			authorizeMe() //***** Check Authorization
			if(params != null && params.surgeryType!= null && !params.surgeryType.isEmpty()){
				
				def surgeryExist=Surgery.findBySurgeryTypeIlike(params.surgeryType)
				if(surgeryExist !=null){
					flash.msg ="Surgery Type '"+params.surgeryType+"'"+" with this name already exists"
					redirect(controller:"Surgery" , action:"add")
				}else{
				Surgery race=surgeryService.save(params);
				if(race!=null && race.validate()){
					auditEventService . save(AuditEventType.addedSurgery, Role.admin, session)
					//flash.msg="Surgery Type Created Successfully"
					flash.msg ="Surgery Type '"+race.surgeryType+"'"+" name saved successfully"
					redirect(controller:"Surgery" , action:"view")
				}
				else{
					flash.msg= "Surgery Type Creation Failed due to some error"
					redirect(controller:"Surgery" , action:"add")
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
	 * @return edit a Surgery
	 */

	/*def edit(){
		try{
			authorizeMe() //***** Check Authorization
			if(params!=null && params.surgeryId!=null &!params.surgeryId.isEmpty()){
				def getSurgeryRow=Surgery.get(params.surgeryId);
				if(getSurgeryRow){
					[surgery:getSurgeryRow];
				}
				else{
					flash.msg="No records for current Id";
					redirect(controller:"Surgery" , action:"view");
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}

	}*/

	
	def edit(){
		authorizeMe()
		if(params.surgeryId != null&& !params.surgeryId.isEmpty()){
			def getSurgeryRow=Surgery.get(params.surgeryId);
			if(request.post){
				def alreadyExist=Surgery.findBySurgeryTypeIlike(params.surgerytype)
				if(alreadyExist){
					if(!alreadyExist.id.toString().equals(params.surgeryId)){
						flash.msg ="Surgery Type '"+ params.surgerytype +"'"+"  with this name already exists"
					}else{
					update(params)
					}
				}else{
				update(params)
				}
			}
			[surgery:getSurgeryRow]
		}else{
		// do nothing
		}
	}
	
	
	
	/**
	 *
	 * @return update a  Surgery
	 */

	def update(params){
		try{
			authorizeMe() //***** Check Authorization
			def updatedId=params.surgeryId;
			if(params!= null && params.surgeryId!=null && !params.surgeryId.isEmpty() && params.surgerytype!=null && !params.surgerytype.isEmpty()){
				
				
				Surgery updateSurgery=surgeryService.update(params);
				if(updateSurgery!=null && updateSurgery.validate()){
					auditEventService . save(AuditEventType.updatedSurgery, Role.admin, session)
					//flash.msg= "Surgery Type Updated Successfully"
					flash.msg ="Surgery Type '"+updateSurgery.surgeryType+"'"+"  name updated successfully"
					redirect(controller:"Surgery" , action:"view")
				}
				else{
					flash.msg= "Surgery Type Updation Failed due to some error"
					redirect(controller:"Surgery" , action:"edit")
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
	 * @return delete a Surgery
	 */

	def delete(){
		try{
			authorizeMe() //***** Check Authorization
			def deleteSurgeryId=params.surgeryId;
			if(params!=null && params.surgeryId!=null &&!params.surgeryId.isEmpty()){
				boolean deleteRace=surgeryService.delete(params)
				if(deleteRace){
					auditEventService . save(AuditEventType.deletedSurgery, Role.admin, session)
					//flash.msg= "Surgery Type Deleted Successfully"
					flash.msg ="Surgery Type '"+Surgery.get(params.surgeryId).surgeryType+"'"+" name has been made Inactive"
				}
				else{
					flash.msg= "Surgery Type Deletion Failed due to some error"
				}
				redirect(controller:"Surgery" , action:"view")
			}
			else{
				//do nothing
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	def ajaxPaginate(){
		try{
			//def hormoneTherapy = aboutYouService.getAboutYouList(params)
			render (template :'view',
			model:[surgeryList:surgeryService.getSurgeryList(params),surgeryListTotal: surgeryService.getCount(params) ,offset:0 ,max : params.max,searchValue:params.searchValue])
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
			render(template:"view",model:[surgeryList:surgeryService.getSurgeryList(params),surgeryListTotal: surgeryService.getCount(params),offset:0 ,max : params.max, searchValue: params.searchValue])
		}catch(Exception exception){
			exception.printStackTrace()
		}
	}
}
