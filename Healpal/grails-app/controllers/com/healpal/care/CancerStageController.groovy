/*
 * Author    : Karthigeyan
 * Project   : Healpal
 * Date      :
 * Description : List  ,Create ,Edit ,Delete of Cancer Stage
 *
 * #   Name       Version   Modified-Date      Description
 * -------------------------------------------------------------------------------------
 * 1   Karthigeyan    1.0               Initial Creation
 *
 */

package com.healpal.care

import java.sql.SQLException;

class CancerStageController {

	def CancerStageService cancerStageService

	def index() {
	}

	def view(){
		try{
			authorizeMe()
			params.max = Math.min(params.max ? params.int('max') :10, 100)
			[cancerStage:cancerStageService.getCancerStageList(params),cancerStageTotal:CancerStage.list()?.size() ,offset:0 ,max : params.max, searchValue:""]
		}
		catch(NullPointerException e){
			e.printStackTrace()
		}
	}

	def add(){
		authorizeMe()	//***** Check Authorization
		render(view:'add')
	}

	def cancel(){

		redirect(controller:"cancerStage" , action:"view")
	}

	def create(){

		try{
			authorizeMe()

			if(params !=null &&  !params.isEmpty() && params.cancerStage !=null &&  !params.cancerStage.isEmpty()){

				def alreadyExist=CancerStage.findByCancerStageLevelIlike(params.cancerStage)
				if(alreadyExist !=null){

					flash.msg ="Cancer Stage '"+params.cancerStage+"'"+" with this name already exists"
					redirect(action:"add")
				}else{
					CancerStage cancerStageSave = cancerStageService.doSave(new CancerStage(),params)

					if(cancerStageSave !=null){
						//auditEventService . save(AuditEventType.addedAboutYou, Role.admin, session)
						flash.msg ="Cancer Stage'"+cancerStageSave.cancerStageLevel+"'"+" name saved successfully"
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



	def edit(){
		authorizeMe()
		if(params.stageId != null&& !params.stageId.isEmpty()){
			def getStageRow=CancerStage.get(params.stageId);
			if(request.post){
				def alreadyExist=CancerStage.findByCancerStageLevelIlike(params.cancerStage)
				if(alreadyExist){
					if(!alreadyExist.id.toString().equals(params.stageId)){
						flash.msg ="Cancer Stage '"+params.cancerStage+"'"+" with this name already exists"
					}else{
					update(params)
					}
				}else{
				update(params)
				}
			}
			[cancerStage:getStageRow]
		}else{
		// do nothing
		}
	}

	def update(params){

		try {
			authorizeMe()
			if(params!=null && params.stageId!=null && params.cancerStage!=null && params.cancerStage!=""
			&& params.stageId!=""){
				def updated=params.stageId;
					CancerStage cancerStageUpdate = cancerStageService.doUpdate(new CancerStage(),updated,params)
					if(cancerStageUpdate!=null && cancerStageUpdate.validate()){
						//auditEventService . save(AuditEventType.updatedMedicalCondition,Role.admin, session)
						flash.msg ="Cancer Stage '"+params.cancerStage+"'"+"  name updated successfully"
						redirect(action:"view");
				}
			}
			else{
				//do nothing
			}
		}
		catch(Exception exception) {
			exception.printStackTrace()
		}
	}




	def delete() throws SQLException{
		try{
			authorizeMe()
			if(params.stageId !=null && !params.stageId.isEmpty()){
				CancerStage cancerStageDelete =cancerStageService.doDelete(new CancerStage(),params)
				if(cancerStageDelete !=null){
					flash.msg ="Cancer Stage '"+CancerStage.get(params.stageId).cancerStageLevel+"'"+" name has been made Inactive"
					//flash.msg = " has been made Inactive"
				}
				redirect(action:'view')
			}else{
				// do nothing
			}
		}catch(SQLException | Exception e){
			e.printStackTrace()
		}
	}
	def ajaxPaginate(){
		try{
			def cancerStageLevel = cancerStageService.getCancerStageList(params)
			render (template :'list',
			model:[cancerStage:cancerStageService.getCancerStageList(params),cancerStageTotal:cancerStageService.getCount(params) ,offset:0 ,max : params.max, searchValue: params.searchValue])
		}catch(Exception exception){
			exception.printStackTrace()
		}
	}


	//******************************************
	def authorizeMe(){
		if(session.user && session.authority.equalsIgnoreCase(Role.admin)){
			//do nothing
		}else{
			redirect controller :'home' ,action :'index'
		}
	}
	def searchValues(){
		try{
			params.max = Math.min(params.max ? params.int('max') :10, 100)
			render(template:"list",model:[cancerStage: cancerStageService.getCancerStageList(params),cancerStageTotal:cancerStageService.getCount(params),offset:0 ,max : params.max, searchValue: params.searchValue])
		}catch(Exception exception){ exception.printStackTrace() }
	}


}
