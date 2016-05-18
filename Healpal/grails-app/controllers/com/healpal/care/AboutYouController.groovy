/*
 * Author    : Karthigeyan
 * Project   : Healpal
 * Date      :
 * Description : List  ,Create ,Edit ,Delete of About  You
 *
 * #   Name       Version   Modified-Date      Description
 * -------------------------------------------------------------------------------------
 * 1   Karthigeyan    1.0               Initial Creation
 *
 */

package com.healpal.care

import java.sql.SQLException;

class AboutYouController {
	def AuditEventService auditEventService
	def AboutYouService aboutYouService

	def index() {
	}

	def view(){
		try{
			authorizeMe()
			params.max = Math.min(params.max ? params.int('max') :10, 100)
			[aboutYouList:aboutYouService.getAboutYouList(params),aboutYouListTotal:AboutYou.list()?.size() ,offset:0 ,max : params.max,searchValue: ""]
		}
		catch(NullPointerException e){
			e.printStackTrace()
		}
	}

	def add(){
		authorizeMe()
	}

	def create(){
		try{
			authorizeMe()

			if(params !=null &&  !params.isEmpty() && params.aboutyou !=null &&  !params.aboutyou.isEmpty()){

				def alreadyExist=AboutYou.findByAboutYouNameIlike(params.aboutyou)
				if(alreadyExist !=null){

					flash.msg ="About You '"+params.aboutyou+"'"+" with this name already exists"
					redirect(action:"add")
				}else{
					AboutYou aboutYouSave = aboutYouService.doSave(new AboutYou(),params)

					if(aboutYouSave !=null){
						auditEventService . save(AuditEventType.addedAboutYou, Role.admin, session)
						flash.msg ="About You '"+aboutYouSave.aboutYouName+"'"+" name saved successfully"
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
			if(params.aboutId !=null && !params.aboutId.isEmpty()){
				AboutYou aboutYouDelete = aboutYouService.doDelete(new AboutYou(),params)
				if(aboutYouDelete !=null){
					auditEventService . save(AuditEventType.deletedAboutYou, Role.admin, session)
					flash.msg ="About You '"+AboutYou.get(params.aboutId).aboutYouName+"'"+" name has been made Inactive"
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
		if(params.aboutId != null&& !params.aboutId.isEmpty()){
			def aboutYou=AboutYou.get(params.aboutId)
			if(request.post){
				def alreadyExist=AboutYou.findByAboutYouNameIlike(params.aboutyou)
				if(alreadyExist){
					if(!alreadyExist.id.toString().equals(params.aboutId)){
						flash.msg ="About You '"+params.aboutyou+"'"+" with this name already exists"
					}else{
					update(params)
					}
				}else{
				update(params)
				}
			}
			[about:aboutYou]
		}else{
		// do nothing
		}
	}

	def update(params){
		try {
			authorizeMe()
			if(params!=null && params.aboutId!=null && params.aboutyou!=null && params.aboutyou!="" && params.aboutId!=""){
					AboutYou aboutYouUpdate = aboutYouService.doUpdate(new AboutYou() ,params)
					if(aboutYouUpdate!=null && aboutYouUpdate.validate()){
						auditEventService . save(AuditEventType.updatedMedicalCondition,Role.admin, session)
						flash.msg ="About You '"+aboutYouUpdate.aboutYouName+"'"+"  name updated successfully"
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



	def ajaxPaginate(){
		try{
			def aboutYouList = AboutYou.createCriteria().list() { if(params.searchValue != null && params.searchValue != "") ilike("aboutYouName", "%"+params.searchValue+"%")}
			render (template :'list',
			model:[aboutYouList:aboutYouService.getAboutYouList(params),aboutYouListTotal:aboutYouService.getCount(params) ,offset:0 ,max : params.max, searchValue: params.searchValue])
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

	def cancel(){
		authorizeMe() //***** Check Authorization

		redirect(controller:"aboutYou" , action:"view")

	}
	
	def searchValues(){
		try{
			params.max = Math.min(params.max ? params.int('max') :10, 100)
			render(template:"list",model:[aboutYouList:aboutYouService.getAboutYouList(params),aboutYouListTotal:aboutYouService.getCount(params),offset:0 ,max : params.max, searchValue: params.searchValue])
		}catch(Exception exception){ exception.printStackTrace() }
	}

}