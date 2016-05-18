/**
 * Author 		: Ramesh
 * Project 		: HealPal
 * Date			: 06/11/2015
 * Description  : RadiationTreatment
 *
 * #   Name       Version   Modified-Date      Description
 * -------------------------------------------------------------------------------------
 * 1   Ramesh     1.0        06/11/2015        Initial Creation
 *
 * */

package com.healpal.care

class RadiationTreatmentController {

	
	def RadiationTreatmentService radiationTreatmentService
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
			authorizeMe()
			params.max = Math.min(params.max ? params.int('max') : 10, 100)
			def radiationTreatmentList=radiationTreatmentService.viewAll(params)
			[radiationTreatmentList:radiationTreatmentList,total:HormoneTherapy.list()?.size(),offset:0 ,max : params.max]
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
			authorizeMe();
			def addRadiationTreatment=radiationTreatmentService.saveRadiationTreatment(params)
			if(addRadiationTreatment){
				auditEventService . save(AuditEventType.addedRadiationTreatment,Role.admin, session)
				flash.msg ="'"+RadiationTreatment.radiationTreatmentType+"'"+" name saved successfully"
				redirect(action:"view")
			}
			else{
				def AlreadyExist=RadiationTreatment.findAllByRadiationTreatmentType(params.radiationTreatmentType)
				if(AlreadyExist !=null){
					flash.msg ="'"+params.radiationTreatmentType+"'"+" Radiation Treatment Type with this name already exists"
					redirect(action:"view")
				}else{
					//do nothing
				}
			}
			/*else if(addRadiationTreatment) {
				flash.msg="RadiationTreatment created failed"
				redirect(action:"create")
			}
			else {
				//do nothing
			}*/
		}
		catch(Exception exception) {
			exception.printStackTrace()
		}
	}


	/**
	 * @return
	 */
	def edit(){
		try {
			authorizeMe();
			def editRadiationTreatmentTypeId=params.radiationTreatmentTypeId;
			if(editRadiationTreatmentTypeId){
				def getRadiationTreatment=RadiationTreatment.get(editRadiationTreatmentTypeId);
				if(getRadiationTreatment){
					println "Succ"
					[RadiationTreatmentType:getRadiationTreatment];
				}
				else{
					flash.msg="No records for current Id";
					redirect(action:"view");
				}
			}
		}
		catch(Exception exception) {
			exception.printStackTrace()
		}
	}

	/**
	 * @return
	 */
	def update(){
		try {
			authorizeMe();
			def addRadiationTreatment=radiationTreatmentService.updateRadiationTreatment(params)
			if(addRadiationTreatment){
				auditEventService . save(AuditEventType.updatedRadiationTreatment,Role.admin, session)
				flash.msg ="'"+params.radiationTreatmentType+"'"+"  name updated has been changed"
			}
			else{
					def AlreadyExist=RadiationTreatment.findAllByRadiationTreatmentType(params.radiationTreatmentType)
					if(AlreadyExist){
						flash.msg ="'"+ params.radiationTreatmentType+"'"+"  Radiation Treatment Type with this name already exists"
						redirect(action:"view")
					}else{
						flash.msg ="'"+params.radiationTreatmentType+"'"+"  Radiation Treatment Type Name Updated has been changed"
						//do nothing
					}
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
	def delete(){
		try {
			authorizeMe();
			def deleteRadiationTreatment=radiationTreatmentService.deleteRadiationTreatment(params)
			if(deleteRadiationTreatment){
				auditEventService . save(AuditEventType.deletedRadiationTreatment,Role.admin, session)
				flash.msg ="'"+RadiationTreatment.get(params.radiationTreatmentTypeId).radiationTreatmentType+"'"+" name has been made Inactive"
			}
			else{
				flash.msg="RadiationTreatment deletion failed";
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
