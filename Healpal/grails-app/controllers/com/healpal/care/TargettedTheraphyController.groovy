/**
 * Author 		: Ramesh
 * Project 		: HealPal
 * Date			: 11/06/2015
 * Description  : TargettedTerapy
 *
 * #   Name       Version   Modified-Date      Description
 * -------------------------------------------------------------------------------------
 * 1   Ramesh      1.0       11/06/2015       Initial Creation
 *
 * */
package com.healpal.care
class TargettedTheraphyController {

	def TargetedTherapyService targetedTherapyService
	def AuditEventService auditEventService
	def index() {
	}


	/**
	 * Check Authorize whether the user is admin or not. If admin allow to access else logout
	 * @return
	 */
	def authorizeMe(){
		if(session.user && session.authority?.equalsIgnoreCase(Role.admin)){
			//do nothing
		}else{
			redirect controller :'auth' ,action :'doLogout'
		}
	}


	/**
	 * @return
	 */
	def view(){
		try {
			authorizeMe();
			params.max = Math.min(params.max ? params.int('max') : 10, 100)
			def therapyList = targetedTherapyService.viewAll(params)
			println "therapyList;;;;;;;;;;;;;"+therapyList
			[therapyList:therapyList,total:TargetedTheropy.list()?.size(),offset:0 ,max : params.max]
		}
		catch(Exception exception) {
			exception.printStackTrace()
		}
	}

	def add(){
	}


	/**
	 * @return
	 */
	def create(){
		try {
			authorizeMe();
			def saveTargettedTerapy=targetedTherapyService.saveTargettedTerapy(params)
			if(saveTargettedTerapy){
				auditEventService . save(AuditEventType.addedHormoneTherapy,Role.admin, session)
				flash.msg ="'"+TargetedTheropy.targetedTheropyName+"'"+" name saved successfully"
				redirect(action:"view")
			}
			else{
				def AlreadyExist=TargetedTheropy.findAllByTargetedTheropyName(params.targetedTheropy)
				if(AlreadyExist !=null){
					flash.msg ="'"+params.targetedTheropy+"'"+" Targetted Theropy with this name already exists"
					redirect(action:"view")
				}else{
					//do nothing
				}
			}
			/*else if(!saveTargettedTerapy) {
				flash.msg =  "Hormone therapy creation failed due to some errors"
				redirect(action:'create')
			}
			else {
				//do nothing
			}*/
		}
		catch(Exception e) {
			e.printStackTrace()
		}
	}


	/**
	 * @return
	 */
	def edit(){
		try {
			authorizeMe();
			def editTherapy=params.therapyId;
			if(editTherapy){
				def getTargetedTheropy=TargetedTheropy.get(editTherapy);
				if(getTargetedTheropy){
					println "Succ"
					[TargetedTheropy:getTargetedTheropy];
				}
				else{
					flash.msg="No records for current Id";
					redirect(action:"view");
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace()
		}
	}

	/**
	 * @return
	 */
	def update(){
		try{
			authorizeMe();
			def saveTargettedTerapy=targetedTherapyService.updateTargettedTerapy(params)

			if(saveTargettedTerapy){
				auditEventService . save(AuditEventType.addedHormoneTherapy,Role.admin, session)
				flash.msg ="'"+params.targetedTheropy+"'"+"  name updated has been changed"
			}
			else{
					def AlreadyExist=TargetedTheropy.findAllByTargetedTheropyName(params.targetedTheropy)
					if(AlreadyExist){
						flash.msg ="'"+ params.targetedTheropy+"'"+"  Targetted Theropy Name with this name already exists"
						redirect(action:"view")
					}else{
						flash.msg ="'"+params.targetedTheropy+"'"+"  Targetted Theropy Name Updated has been changed"
						//do nothing
					}
				}
			redirect(action:"view");
		}
		catch(Exception e) {
			e.printStackTrace()
		}
	}

	/**
	 * @return
	 */
	def delete(){
		try {
			authorizeMe();
			def saveTargettedTerapy=targetedTherapyService.deleteTargettedTerapy(params)

			if(saveTargettedTerapy){
				auditEventService . save(AuditEventType.addedHormoneTherapy,Role.admin, session)
				flash.msg ="'"+TargetedTheropy.get(params.therapyId).targetedTheropyName+"'"+" name has been made Inactive"
			}
			else if(!saveTargettedTerapy){
				flash.msg="Targetted Therapy deletion failed";
			}
			else {
				// do nothing
			}
			redirect(action:"view");
		}
		catch(Exception exception) {
			exception.printStackTrace()
		}
	}
	
	/**
	 * @return
	 */
	def cancel()
	{
		redirect(action:"view");
	}
}
