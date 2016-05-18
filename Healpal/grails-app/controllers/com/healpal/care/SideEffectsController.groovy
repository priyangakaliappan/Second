/**
 * Author 		: Ramesh
 * Project 		: HealPal
 * Date			: 11/06/2015 
 * Description  : SideEffects
 *
 * #   Name       Version   Modified-Date      Description
 * -------------------------------------------------------------------------------------
 * 1   Ramesh      1.0       11/06/2015         Initial Creation
 *
 * */
package com.healpal.care

class SideEffectsController {

	def SideEffectService sideEffectService
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
			def sideEffectsList = sideEffectService.viewAll(params)
			[sideEffectsList:sideEffectsList,total:SideEffects.list()?.size(),offset:0 ,max : params.max,searchValue:""]
		}
		catch(Exception exception) {
			exception.printStackTrace()
		}
	}
	
	
	def ajaxPaginate(){
		try{
			authorizeMe();
			render (template :'viewSideEffects',
			model:[sideEffectsList:sideEffectService.viewAll(params),total:sideEffectService.getCount(params),offset:0 ,max : params.max,searchValue:params.searchValue])
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
		authorizeMe()
		try {
			
			def AlreadyExist=SideEffects.findBySideEffectsTypeIlike(params.sideEffectsType)
			if(AlreadyExist !=null){
				flash.msg ="SideEffects '"+params.sideEffectsType+"'"+"  with this name already exists"
				redirect(action:"add")
			}else{
				def saveSideEffects=sideEffectService.saveSideEffects(params)
			if(saveSideEffects){
				auditEventService . save(AuditEventType.addedHormoneTherapy,Role.admin, session)
				flash.msg ="SideEffects '"+saveSideEffects.sideEffectsType+"'"+" name saved successfully"
				redirect(action:"view")
			}
			else{
				flash.msg="Race Creation Failed due to some error"
				redirect(controller:"SideEffects" , action:"add")
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
	

	def edit(){
		authorizeMe()
		if(params.sideEffectsId != null&& !params.sideEffectsId.isEmpty()){
			def getSideEffects=SideEffects.get(params.sideEffectsId);
			if(request.post){
				def alreadyExist=SideEffects.findBySideEffectsTypeIlike(params.sideEffectsType)
				if(alreadyExist){
					if(!alreadyExist.id.toString().equals(params.sideEffectsId)){
						flash.msg ="SideEffects '"+ params.sideEffectsType+"'"+"with this name already exists"
					}else{
					update(params)
					}
				}else{
				update(params)
				}
			}
			[SideEffectsType:getSideEffects]
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
			
			def updateSideEffects=sideEffectService.updateSideEffects(params)
			if(updateSideEffects){
				//auditEventService . save(AuditEventType.addedHormoneTherapy,Role.admin, session)
				flash.msg ="SideEffects '"+params.sideEffectsType+"'"+"  name updated successfully"
			}
			else{
				
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
		authorizeMe()
		try {
			def deleteSideEffects=sideEffectService.deleteSideEffects(params)
			if(deleteSideEffects){
				//auditEventService . save(AuditEventType.addedHormoneTherapy,Role.admin, session)
				flash.msg ="SideEffects '"+SideEffects.get(params.sideEffectsId).sideEffectsType+"'"+" name has been made Inactive"
			}
			else{
				flash.msg="Side Effects deletion failed";
			}
			redirect(action:"view");
		}

		catch(Exception exception) {
			exception.printStackTrace()
		}
	}
	def cancel()
	{
		redirect(action:"view");
	}
	def searchValues(){
		try{
			params.max = Math.min(params.max ? params.int('max') :10, 100)
			render(template:"viewSideEffects",model:[sideEffectsList:sideEffectService.viewAll(params),total:sideEffectService.getCount(params),offset:0 ,max : params.max, searchValue: params.searchValue])
		}catch(Exception exception){
			exception.printStackTrace()
		}
	}
}
