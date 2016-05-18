/*
 * Author    : Priyanga K
 * Project   : Healpal
 * File      : HormoneTherapyController
 * Date      : 23-10-2015
 * Description : Show all HormoneTherapy, Create a HormoneTherapy, edit a HormoneTherapy
 *
 * #   Name           Version           Modified-Date      Description
 * -------------------------------------------------------------------------------------
 * 1   Priyanga K    1.0               23-10-2015         Initial Creation
 *
 */
package com.healpal.care

/**
 *
 *
 * @author Priyanga K
 *
 */
class HormoneTherapyController{

	def HormoneTherapyService hormoneTherapyService
	def AuditEventService auditEventService

	def index() {
	}

	/**
	 *
	 * @return view hormone theraphy
	 */

	def view(){
		authorizeMe()   //***** Check Authorization
		try{
			params.max = Math.min(params.max ? params.int('max') : 10, 100)
			def hormoneTherapy = hormoneTherapyService.viewAll(params)
			[hormoneTherapy:hormoneTherapy,total:HormoneTherapy.list()?.size(),offset:0 ,max : params.max,searchValue:""]
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 *
	 * @return create an hormone theraphy
	 */

	def create(){
		authorizeMe()	//***** Check Authorization
		render(view:'add')
	}

	/**
	 *
	 * @return save hormone theraphy
	 */

	def save(){
		authorizeMe()
		try{
			if(params !=null && params.hormoneTherapyName !=null && !params.hormoneTherapyName.isEmpty())
			{

				def hormonExist=HormoneTherapy.findByHormoneTherapyNameIlike(params.hormoneTherapyName)

				if(hormonExist !=null){
					flash.msg = "Hormone therapy drug '"+params.hormoneTherapyName+ "' with this name already exists"
					redirect(action:'create')

				}else{
					HormoneTherapy hormoneTherapy = hormoneTherapyService.save(params)
					if(hormoneTherapy != null && hormoneTherapy.validate()){
						auditEventService . save(AuditEventType.addedHormoneTherapy,Role.admin, session)
						flash.msg = "Hormone therapy drug '"+hormoneTherapy?.hormoneTherapyName+ "' name saved sucessfully"
						redirect(action:'view')
					}else{
						flash.msg =  "Hormone therapy creation failed due to some errors"
						redirect(action:'create')

					}
				}


			}else{
				//do nothing
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}

	}

	/**
	 *
	 * @return edit hormone theraphy
	 */

	
	
	def edit(){
		authorizeMe()
		if(params.hormoneId != null&& !params.hormoneId.isEmpty()){
			def hormoneTherapy = HormoneTherapy.get(params.hormoneId.toLong())
			if(request.post){
				def alreadyExist=HormoneTherapy.findByHormoneTherapyNameIlike(params.hormoneTherapyName)
				if(alreadyExist){
					if(!alreadyExist.id.toString().equals(params.hormoneId)){
						flash.msg = "Hormone therapy drug '"+params.hormoneTherapyName+ "' with this name already exists"
					}else{
					update(params)
					}
				}else{
				update(params)
				}
			}
			
			[hormoneTherapy:hormoneTherapy]
		}else{
		// do nothing
		}
	}
	
	
	

	/**
	 *
	 * @return delete hormone theraphy
	 */

	def delete(){
		authorizeMe()	//***** Check Authorization
		try{
			if(params !=null && params.hormoneId !=null && !params.hormoneId.isEmpty()){
				def hormoneTherapy = hormoneTherapyService.deleteHormoneTherapy(params)
				if(hormoneTherapy){
					auditEventService . save(AuditEventType.deletedHormoneTherapy,Role.admin, session)
					//flash.msg = "Hormone therapy has been made inactive"
					flash.msg ="Hormone therapy drug '"+HormoneTherapy.get(params.hormoneId).hormoneTherapyName+"'"+" name has been made Inactive"
				}
				else{
					flash.msg =  "Hormone therapy deeletion failed due to some errors"
				}
			}else{
				//do nothing
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		redirect(action:'view')
	}

	/**
	 *
	 * @return update hormone theraphy
	 */

	def update(params){
		
		authorizeMe() //***** Check Authorization
		try{
			if(params!= null && params.hormoneId!=null && !params.hormoneId.isEmpty() && params.hormoneTherapyName!=null && !params.hormoneTherapyName.isEmpty()){
			
				
				HormoneTherapy hormoneTherapy = hormoneTherapyService.update(params)
				if(hormoneTherapy != null && hormoneTherapy.validate()){
					auditEventService . save(AuditEventType.updatedHormoneTherapy,Role.admin, session)
					flash.msg = "Hormone therapy drug '"+hormoneTherapy?.hormoneTherapyName+ "' name updated successfully"
					redirect(action:'view')
				}
				else{
					
					}
				}
				
			else{
				//do nothing
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		}
	def cancel(){
		authorizeMe()	//***** Check Authorization
		redirect(action:'view')}

	def ajaxPaginate(){
		try{
			def hormoneTherapy = hormoneTherapyService.viewAll(params)
			render (template :'viewHormone' ,model:[hormoneTherapy : hormoneTherapy ,total:hormoneTherapyService.getCount(params) ,offset:params.offset ,max :params.max,searchValue:params.searchValue])
		}catch(Exception exception){
			exception.printStackTrace()
		}
	}
	def authorizeMe(){
		if(session.user && session.authority?.equalsIgnoreCase(Role.admin)){
			// do nothing
		}else{
			flash.msg ="Sorry! you have not authorize to view this page"
			redirect(controller:'Home', action:'index')}
	}
	def searchValues(){
		try{
			params.max = Math.min(params.max ? params.int('max') :10, 100)
			render(template:"viewHormone",model:[hormoneTherapy :  hormoneTherapyService.viewAll(params) ,total:hormoneTherapyService.getCount(params) ,offset:0 ,max : params.max, searchValue: params.searchValue])
		}catch(Exception exception){
			exception.printStackTrace()
		}
	}
}
