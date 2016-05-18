
/*
 * Author    : Subhapriya M
 * Project   : Healpal
 * File      : RaceController
 * Date      : 23-10-2015
 * Description : Show all Race, Create a Race, edit a Race
 *
 * #   Name           Version           Modified-Date      Description
 * -------------------------------------------------------------------------------------
 * 1   Subhapriya M    1.0               23-10-2015         Initial Creation
 *
 */
package com.healpal.care
import com.healpal.care.RaceService
import com.healpal.care.AuditEventService
class RaceController {

	/**
	 *
	 * @author Subhapriya M
	 *
	 */

	def RaceService raceService;
	def AuditEventService auditEventService;
	def index() {
	}

	/**
	 * @return get all Race
	 */


	
	def view(){
		try{
			authorizeMe()
			params.max = Math.min(params.max ? params.int('max') :10, 100)
			[race:raceService.getRaceList(params),total:Race.list()?.size() ,offset:0 ,max : params.max, searchValue : ""]
		}
		catch(NullPointerException e){
			e.printStackTrace()
		}
	}

	
	def ajaxPaginate(){
		try{
			render (template :'view',
			model:[race:raceService.getRaceList(params),total:raceService.getCount(params) ,offset:0 ,max : params.max, searchValue: params.searchValue])
		}catch(Exception exception){
			exception.printStackTrace()
		}
	}
	
	
	
	/**
	 * @return create a Race
	 */

	def add(){
		authorizeMe() //***** Check Authorization
	}
	def cancel(){
		authorizeMe() //***** Check Authorization
		redirect(controller:"Race" , action:"view")

	}

	/**
	 *
	 * @return save Race
	 */

	def create(){
		try{
			authorizeMe() //***** Check Authorization
			def raceName=params.raceName
			if(params != null && params.raceName!= null && !params.raceName.isEmpty()){
				
				
				def raceExist=Race.findByRaceNameIlike(params.raceName)
				if(raceExist !=null){
					flash.msg ="Race '"+params.raceName+"'"+" with this name already exists"
					redirect(controller:"Race" , action:"add")
				}else{
				Race race=raceService.save(params);
				if(race!=null && race.validate()){
					auditEventService . save(AuditEventType.addedRace, Role.admin, session)
					//flash.msg="Race Created Successfully"
					flash.msg ="Race '"+race.raceName+"'"+" name saved successfully"
					redirect(controller:"Race" , action:"view")
				}
				else{
					flash.msg="Race Creation Failed due to some error"
					redirect(controller:"Race" , action:"add")
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
	 * @return edit a Race
	 */
	
	def edit(){
		authorizeMe()
		if(params.raceId != null&& !params.raceId.isEmpty()){
			def getRaceRow=Race.get(params.raceId);
			if(request.post){
				def alreadyExist=Race.findByRaceNameIlike(params.raceName)
				if(alreadyExist){
					if(!alreadyExist.id.toString().equals(params.raceId)){
						flash.msg ="Race Name '"+params.raceName+"'"+" with this name already exists"
					}else{
					update(params)
					}
				}else{
				update(params)
				}
			}
			[race:getRaceRow]
		}else{
		// do nothing
		}
	}

	/*def edit(){
		try{
			authorizeMe() //***** Check Authorization
			def editRace=params.raceId;
			if(params!=null && params.raceId!=null &!params.raceId.isEmpty()){
				def getRaceRow=Race.get(editRace);
				if(getRaceRow){
					[race:getRaceRow];
				}
				else{
					flash.msg="No records for current Id";
					redirect(controller:"Race" , action:"view");
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}*/

	/**
	 *
	 * @return update a  Race
	 */
	
	def update(params){
		try{
			authorizeMe() //***** Check Authorization
			
			if(params!= null && params.raceId!=null && !params.raceId.isEmpty() && params.raceName!=null && !params.raceName.isEmpty()){
					Race updateRace=raceService.update(params);
					if(updateRace!=null && updateRace.validate()){
						auditEventService . save(AuditEventType.updatedRace, Role.admin, session)
						flash.msg ="Race '"+updateRace.raceName+"'"+" name updated sucessfully"
						redirect(controller:"Race" , action:"view")
					}
					else{
						
				}

			}else{
			// do nothing
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * @return delete a Race
	 */


	def delete(){
		try{
			authorizeMe() //***** Check Authorization
			if(params!=null && params.raceId!=null &&!params.raceId.isEmpty()){
				boolean deleteRace=raceService.delete(params)
				if(deleteRace){
					auditEventService . save(AuditEventType.deletedRace, Role.admin, session)
					//flash.msg= "Race Deleted Successfully"
					flash.msg ="Race '"+Race.get(params.raceId).raceName+"'"+" name has been made Inactive"
				}
				else{
					flash.msg= "Race Deletion Failed due to some error"
				}
				redirect(controller:"Race" , action:"view")
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
	def searchValues(){
		try{
			params.max = Math.min(params.max ? params.int('max') :10, 100)
			render(template:"view",model:[race:raceService.getRaceList(params),total:raceService.getCount(params) ,offset:0 ,max : params.max, searchValue: params.searchValue])
		}catch(Exception exception){ exception.printStackTrace() }
	}
}
