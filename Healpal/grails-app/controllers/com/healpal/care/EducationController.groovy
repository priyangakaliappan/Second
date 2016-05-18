
/*
 * Author    : Subhapriya M
 * Project   : Healpal
 * File      : EducationController
 * Date      : 23-10-2015
 * Description : Show all Education, Create a Education, edit a Education
 *
 * #   Name           Version           Modified-Date      Description
 * -------------------------------------------------------------------------------------
 * 1   Subhapriya M    1.0               23-10-2015         Initial Creation
 *
 */

package com.healpal.care
import com.healpal.care.EducationService;
import com.healpal.care.AuditEventService;
class EducationController {
	/**
	 *
	 * @author Subhapriya M
	 *
	 */
	def EducationService educationService;
	def AuditEventService auditEventService
	def index() {
	}
	/**
	 * @return get all Education
	 */
	def view() {
		try{
			authorizeMe()
			params.max = Math.min(params.max ? params.int('max') :10, 100)
			[educationLists:educationService.getEducationList(params),educationListTotal:Education.list()?.size() ,offset:0 ,max : params.max, searchValue:""]
		}
		catch(NullPointerException e){
			e.printStackTrace()
		}
	}
	/**
	 * @return create a Education
	 */
	def add(){
		authorizeMe() //***** Check Authorization
	}
	def cancel(){
		authorizeMe() //***** Check Authorization
		redirect(controller:"Education" , action:"view")

	}

	/**
	 *
	 * @return save Education
	 */
	def create(){
		try{
			authorizeMe() //***** Check Authorization
			def educationType=params.educationType
			if(params != null && params.educationType!= null && !params.educationType.isEmpty()){


				def eduExist=Education.findByEducationTypeIlike(params.educationType)
				if(eduExist !=null){
					flash.msg ="Education Type '"+params.educationType+"'"+" with this name already exists"
					redirect(controller:"Education" , action:"add")
				}else{
					Education status=educationService.save(params);
					if(status!=null && status.validate()){
						auditEventService . save(AuditEventType.addedEducation, Role.admin, session)
						flash.msg ="Education Type '"+status.educationType+"'"+" name saved successfully"
						//flash.msg= "Education Type Created Successfully"
						redirect(controller:"Education" , action:"view")
					}
					else{
						flash.msg= "Education Type Creation Failed due to some error"
						redirect(controller:"Education" , action:"add")
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
	 * @return edit a Education
	 */


	def edit(){
		authorizeMe()
		if(params.educationId != null&& !params.educationId.isEmpty()){
			def getEducationRow=Education.get(params.educationId);
			if(request.post){
				def alreadyExist=Education.findByEducationTypeIlike(params.educationType)
				if(alreadyExist){
					if(!alreadyExist.id.toString().equals(params.educationId)){
						flash.msg ="Education Type '"+params.educationType+"'"+" with this name already exists"
					}else{
					update(params)
					}
				}else{
				update(params)
				}
			}
			[education:getEducationRow]
		}else{
		// do nothing
		}
	}
	
	/**
	 *
	 * @return update a  Education
	 */

	def update(params){
		try{
			authorizeMe() //***** Check Authorization
			
			if(params!= null && params.educationId!=null && !params.educationId.isEmpty() && params.educationType!=null && !params.educationType.isEmpty()){
					Education updateEducation=educationService.update(params);
					if(updateEducation!=null && updateEducation.validate()){
						auditEventService . save(AuditEventType.updatedEducation, Role.admin, session)
						flash.msg ="Education Type '"+updateEducation.educationType+"'"+" name updated sucessfully"
						redirect(controller:"Education" , action:"view")
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
	 * @return delete a Education
	 */	

	def delete(){
		try{
			authorizeMe() //***** Check Authorization
			def deleteEducationId=params.educationId;
			if(params!=null && params.educationId!=null &&!params.educationId.isEmpty()){
				boolean deleteEducation=educationService.delete(params);
				if(deleteEducation){
					auditEventService . save(AuditEventType.deletedEducation, Role.admin, session)
					//flash.msg= "Education Type Deleted Successfully"
					flash.msg ="Education Type '"+Education.get(params.educationId).educationType+"'"+" name has been made Inactive"
				}
				else{
					flash.msg= "Education Type Deletion Failed due to some error"
				}
				redirect(controller:"Education" , action:"view")
			}
		}catch(Exception e){
			e.printStackTrace();
		}

	}


	def ajaxPaginate(){
		try{
			render (template :'view',
			model:[educationLists:educationService.getEducationList(params),educationListTotal:educationService.getCount(params), offset:0 ,max : params.max, searchValue: params.searchValue])
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
			render(template:"view",model:[educationLists:educationService.getEducationList(params),educationListTotal:educationService.getCount(params),offset:0 ,max : params.max, searchValue: params.searchValue])
		}catch(Exception exception){ exception.printStackTrace() }
	}
}
