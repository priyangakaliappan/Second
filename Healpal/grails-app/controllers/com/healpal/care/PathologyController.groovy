/*
 * Author    : Karthigeyan
 * Project   : Healpal
 * Date      :
 * Description : List  ,Create ,Edit ,Delete of Pathology
 *
 * #   Name       Version   Modified-Date      Description
 * -------------------------------------------------------------------------------------
 * 1   Karthigeyan    1.0               Initial Creation
 *
 */

package com.healpal.care

import java.sql.SQLException;

class PathologyController {

	def AuditEventService auditEventService
	def PathologyService pathologyService
     def index() { }
	
	
	
	def view(){
		try{
			authorizeMe()
			params.max = Math.min(params.max ? params.int('max') :10, 100)
			[pathologyList:pathologyService.getPathologyList(params),pathologyListTotal:PathologyBiopsyTumorType.list()?.size() ,offset:0 ,max : params.max,searchValue:""]
		}
		catch(NullPointerException e){
			e.printStackTrace()
		}
	}
	
	
	def add(){
		authorizeMe()
	}
	
	def cancel(){
		
		redirect(controller:"pathology" , action:"view")
	}
	
	def create() throws Exception{
		
		
		try{
			authorizeMe()

			if(params !=null &&  !params.isEmpty() && params.tumorType !=null &&  !params.tumorType.isEmpty()){
				 
				def alreadyExist=PathologyBiopsyTumorType.findByTumorTypeNameIlike(params.tumorType)
				if(alreadyExist !=null){
					
					flash.msg ="Pathology  '"+params.tumorType+"'"+" with this name already exists"
					redirect(action:"add")
				}else{
				  PathologyBiopsyTumorType tumorType = pathologyService.doSave(new PathologyBiopsyTumorType(),params)

				if(tumorType !=null){
					//auditEventService . save(AuditEventType.addedAboutYou, Role.admin, session)
					flash.msg ="Pathology'"+tumorType.tumorTypeName+"'"+" name saved successfully"
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
	
	
	def delete() throws SQLException{
		try{
			authorizeMe()
			if(params.pathologyId !=null && !params.pathologyId.isEmpty()){
				PathologyBiopsyTumorType tumtourTypeDelete = pathologyService.doDelete(new PathologyBiopsyTumorType(),params)
				if(tumtourTypeDelete !=null){
					flash.msg ="Pathology '"+PathologyBiopsyTumorType.get(params.pathologyId).tumorTypeName+"'"+" name has been made Inactive"
					//flash.msg =" Tumor Type Name has been made Inactive"
				}
				redirect(action:'view')
			}else{
				// do nothing
			}
		}catch(SQLException | Exception e){
			e.printStackTrace()
		}
	}
	
	
	
	
	def edit(){
		authorizeMe()
		if(params.pathologyId != null&& !params.pathologyId.isEmpty()){
			def getPathologyRow=PathologyBiopsyTumorType.get(params.pathologyId);
			if(request.post){
				def alreadyExist=PathologyBiopsyTumorType.findByTumorTypeNameIlike(params.TumorTypes)
				if(alreadyExist){
					if(!alreadyExist.id.toString().equals(params.pathologyId)){
							flash.msg ="Pathology'"+ params.TumorTypes+"'"+"  with this name already exists"
					}else{
					update(params)
					}
				}else{
				update(params)
				}
			}
			[patho:getPathologyRow]
		}else{
		// do nothing
		}
	}

	
	def update(params){
		try{
			authorizeMe()
			if(params.pathologyId !=null && !params.pathologyId.isEmpty()){
				
			
				def updated=params.pathologyId
				
				PathologyBiopsyTumorType tumorTypeUpdate = pathologyService.doUpdate(new PathologyBiopsyTumorType(),updated,params)
				if(tumorTypeUpdate !=null){
					flash.msg ="Pathology'"+tumorTypeUpdate.tumorTypeName+"'"+"  name updated Successfully"
					redirect(action:"view")
				}else{
				flash.msg="error occured while saving"
				redirect(action:"view")
				}
				
			
				
				}else{
				//do nothing
			}
		}catch(NullPointerException e){

			e.printStackTrace()
		}
	}
	
	
	def ajaxPaginate(){
		try{
			
			render (template :'list',
			model:[pathologyList:pathologyService.getPathologyList(params),pathologyListTotal:pathologyService.getCount(params),offset:0 ,max : params.max,searchValue:params.searchValue])
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
			render(template:"list",model:[pathologyList:pathologyService.getPathologyList(params),pathologyListTotal:pathologyService.getCount(params),offset:0 ,max : params.max, searchValue: params.searchValue])
		}catch(Exception exception){
			exception.printStackTrace()
		}
	}
}
