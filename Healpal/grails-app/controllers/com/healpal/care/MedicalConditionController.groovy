/**
 * Author 		: Ramesh
 * Project 		: HealPal
 * Date			: 11/06/2015
 * Description  : MedicalCondition
 *
 * #   Name       Version   Modified-Date      Description
 * -------------------------------------------------------------------------------------
 * 1   Ramesh      1.0       11/06/2015        Initial Creation
 *
 * */

package com.healpal.care

class MedicalConditionController {

	def MedicalConditionService medicalConditionService
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
		authorizeMe()
		params.max = Math.min(params.max ? params.int('max') : 10, 100)
		[medicalConditionList:medicalConditionService.viewAll(params),total:MedicalCondition.list()?.size(),offset:0 ,max : params.max ,searchValue:""]
	}

	
	def ajaxPaginate(){
		try{
			authorizeMe()
			render (template :'view',
			model:[medicalConditionList:medicalConditionService.viewAll(params),total:medicalConditionService.getCount(params),offset:0 ,max : params.max,,searchValue:params.searchValue])
		}catch(Exception exception){
			exception.printStackTrace()
		}
	}
	
	/**
	 * @return
	 */
	def add(){
		authorizeMe()
	}
	/**
	 * @return
	 */
	def create(){
		
		
		try{
			authorizeMe()

			if(params !=null &&  !params.isEmpty() && params.medicalCondition !=null &&  !params?.medicalCondition.isEmpty()){
				 
				def alreadyExist=MedicalCondition.findByMedicalConditionTypeIlike(params.medicalCondition)
				if(alreadyExist !=null){
					
					flash.msg ="Medical Condition Type '"+params.medicalCondition+"'"+" with this name already exists"
					redirect(action:"add")
				}else{
				  def saveMedicalCondition=medicalConditionService.saveMedicalCondition(params)

				if(saveMedicalCondition !=null){
					auditEventService . save(AuditEventType.addedMedicalCondition, Role.admin, session)
					flash.msg ="Medical Condition Type'"+saveMedicalCondition.medicalConditionType+"'"+" name saved successfully"
					redirect(action:"view")
				}else{
					 
				}
				}
				
				
			}else{
				//do nothing
			}
		}catch(Exception e){
			e.printStackTrace()
		}
		
	}

	/**
	 * @return
	 */
	/*def edit(){
		try {
			authorizeMe()
			def medicalConditionId=params.medicalConditionId;
			if(medicalConditionId){
				def getMedicalCondition=MedicalCondition.get(medicalConditionId);
				if(getMedicalCondition){
					println "Succ"
					[medicalCondition:getMedicalCondition];
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
	}*/

	
	def edit(){
		authorizeMe()
		if(params.medicalConditionId != null&& !params.medicalConditionId.isEmpty()){
			def getMedicalCondition=MedicalCondition.get(params.medicalConditionId);
			if(request.post){
				def alreadyExist=MedicalCondition.findByMedicalConditionTypeIlike(params.medicalConditionType)
			if(alreadyExist !=null){
					if(!alreadyExist.id.toString().equals(params.medicalConditionId)){
						flash.msg ="Medical Condition Type '"+ params.medicalConditionType+"'"+" with this name already exists"
					}else{
					update(params)
					}
				}else{
				update(params)
				}
			}
			[medicalCondition:getMedicalCondition]
		}else{
		// do nothing
		}
	}
	
	
	/**
	 * @return
	 */
	def update(params){
		authorizeMe()
		try {

			if(params!=null && params.medicalConditionId!=null && params.medicalConditionType!=null && params.medicalConditionType!=""
			&& params.medicalConditionId!=""){
			
			
			
			MedicalCondition updateMedicalCondition=medicalConditionService.updateMedicalCondition(params)
			if(updateMedicalCondition!=null && updateMedicalCondition.validate()){
				auditEventService . save(AuditEventType.updatedMedicalCondition,Role.admin, session)
				flash.msg ="Medical Condition Type '"+params.medicalConditionType+"'"+"  name updated successfully"
				redirect(action:"view");

			}
			else{
				
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
	def delete(){
		authorizeMe()
		try {
			def deleteMedicalCondition=medicalConditionService.deleteMedicalCondition(params)
			if(deleteMedicalCondition){
				auditEventService . save(AuditEventType.deletedMedicalCondition,Role.admin, session)
				flash.msg ="Medical Condition Type '"+MedicalCondition.get(params.medicalConditionId).medicalConditionType+"'"+" name has been made Inactive"
			}
			else{
				flash.msg="Medical Condition deletion failed";
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
	def cancel() {
		redirect(action:"view");
	}
	def searchValues(){
		try{
			params.max = Math.min(params.max ? params.int('max') :10, 100)
			render(template:"view",model:[medicalConditionList:medicalConditionService.viewAll(params),total:medicalConditionService.getCount(params),offset:0 ,max : params.max, searchValue: params.searchValue])
		}catch(Exception exception){
			exception.printStackTrace()
		}
	}
}
