/*
 * Author    : Karthigeyan
 * Project   : Healpal
 * Date      :
 * Description : List  ,Create ,Edit ,Delete of Diagnosis
 *
 * #   Name       Version   Modified-Date      Description
 * -------------------------------------------------------------------------------------
 * 1   Karthigeyan    1.0               Initial Creation
 *
 */

package com.healpal.care

import java.sql.SQLException;

class DiagnosisController {

	def DiagnosisService diagnosisService

	def index() {
	}



	def view(){
		try{
			authorizeMe()
			params.max = Math.min(params.max ? params.int('max') :10, 100)
			[diagnosisList:diagnosisService.getDiagnosisAllList(params),diagnosisListTotal:Diagnosis.list()?.size() ,offset:0 ,max : params.max, searchValue:""]
		}
		catch(NullPointerException e){
			e.printStackTrace()
		}
	}


	def ajaxPaginate(){
		try{
			//def diagnosis = diagnosisService.getDiagnosisAllList(params)
			render (template :'list',
			model:[diagnosisList:diagnosisService.getDiagnosisAllList(params),diagnosisListTotal:diagnosisService.getCount(params) ,offset:0 ,max : params.max, searchValue: params.searchValue])
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

	def add(){

	}

	def cancel(){

		redirect(controller:"diagnosis" , action:"view")
	}



	def create() throws Exception{
		try{
			authorizeMe()

			if(params !=null &&  !params.isEmpty() && params.DiagnosisName !=null &&  !params.DiagnosisName.isEmpty()){
				def AlreadyExist=Diagnosis.findByDiagnosisNameIlike(params.DiagnosisName)
				if(AlreadyExist !=null){
					flash.msg ="Diagnosis Name '"+ params.DiagnosisName+"'"+"  with this name already exists"
					redirect(action:"add")
				}  else{
					Diagnosis diagnosisSave = diagnosisService.doSave(new Diagnosis(),params)
					if(diagnosisSave !=null){
						flash.msg ="Diagnosis Name '"+diagnosisSave.diagnosisName+"'"+"  name created successfully"
						redirect(action:"view")
					}else{
						flash.msg ="save failed due to some error"
					}
				}



			}else{
				//do nothing
			}
		}catch(Exception e){
			e.printStackTrace()
		}
	}







	def delete(){
		try{
			authorizeMe()
			if(params.diagId !=null && !params.diagId.isEmpty()){
				Diagnosis diagnosisDelete = diagnosisService.doDelete(new Diagnosis(),params)
				if(diagnosisDelete !=null){

					//flash.msg =" Diagnosis Name has been made Inactive"
					flash.msg ="Diagnosis Name '"+Diagnosis.get(params.diagId).diagnosisName+"'"+" name has been made Inactive"
				}
				redirect(action:'view')
			}else{
				// do nothing
			}
		}catch(Exception e){
			e.printStackTrace()
		}
	}



	def edit(){
		authorizeMe()
		if(params.diagId != null&& !params.diagId.isEmpty()){
			def getDiagnosisRow=Diagnosis.get(params.diagId)
			if(request.post){
				def alreadyExist=Diagnosis.findByDiagnosisNameIlike(params.DiagnosisName)
				if(alreadyExist){
					if(!alreadyExist.id.toString().equals(params.diagId)){
						flash.msg ="Diagnosis Name'"+ params.DiagnosisName+"'"+"  with this name already exists"
					}else{
					update(params)
					}
				}else{
				update(params)
				}
			}
			[diag:getDiagnosisRow]
		}else{
		// do nothing
		}
	}

	
	def update(params){
		try {
			authorizeMe()
			if(params!=null && params.diagId!=null && params.DiagnosisName!=null && params.DiagnosisName!="" && params.diagId!=""){
					def updatedId=params.diagId
					Diagnosis diagnosisUpdate = diagnosisService.doUpdate(new Diagnosis(),updatedId,params)
					if(diagnosisUpdate!=null && diagnosisUpdate.validate()){
						//auditEventService . save(AuditEventType.updatedMedicalCondition,Role.admin, session)
						flash.msg ="Diagnosis Name '"+diagnosisUpdate.diagnosisName+"'"+"  name updated successfully"
						redirect(action:"view");

					}
					else{
						//do nothing
					}
			
		   }else{
		}
		}
		catch(Exception exception) {
			exception.printStackTrace()
		}
	}
	def searchValues(){
		try{
			params.max = Math.min(params.max ? params.int('max') :10, 100)
			render(template:"list",model:[diagnosisList:diagnosisService.getDiagnosisAllList(params),diagnosisListTotal:diagnosisService.getCount(params),offset:0 ,max : params.max, searchValue: params.searchValue])
		}catch(Exception exception){ exception.printStackTrace() }
	}



}
