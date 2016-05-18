/*
 * Author    : Priyanga K
 * Project   : Healpal
 * File      : DrugsController
 * Date      : 23-10-2015
 * Description : Show all Drugs, Create a Drugs, edit a Drugs
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
class DrugsController{

	def DrugsService drugsService
	def AuditEventService auditEventService

	def index() {

	}

	/**
	 *
	 * @return get all drugs
	 */

	def view(){
		authorizeMe()	//***** Check Authorization
		try
		{
			params.max = Math.min(params.max ? params.int('max') : 10, 100)
			def drugList = drugsService.viewAll(params)
			[drugList:drugList,total:Drugs.list()?.size(),offset:0 ,max : params.max,searchValue:""]
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
	}

	/**
	 *
	 * @return create a drug
	 */

	def create(){
		authorizeMe()	//***** Check Authorization
		render(view:'add')
	}

	/**
	 *
	 * @return save drug
	 */

	def save(){
		authorizeMe()	//***** Check Authorization
		try
		{
			if(params!=null && params.drug !=null && !params.drug.isEmpty()){
				def exist=Drugs.findByDrugNameIlike(params.drug)
				if(exist !=null){
					flash.msg = "Drug '"+params.drug+ "' with this name already exists"
					redirect(action:'create')
					}else{
					Drugs drugs = drugsService.save(params)
					if(drugs != null && drugs.validate()){
						auditEventService . save(AuditEventType.addedDrug,Role.admin, session)
						flash.msg = "Drug '"+drugs?.drugName+ "' name saved successfully"
						log.info("Drug '"+drugs?.drugName+ "' account has been created sucessfully")
						redirect(action:'view')
					}else{
					flash.msg =  "Drug creation failed due to some errors"
					}
					}
				
				}else{
				//do nothing
			}
		}catch(Exception exception)
		{
			exception.printStackTrace();
		}
	}

	/**
	 *
	 * @return edit a drug
	 */


	
	def edit(){
		authorizeMe()
		if(params.drugId != null&& !params.drugId.isEmpty()){
			def drug=Drugs.get(params.drugId)
			if(request.post){
				def alreadyExist=Drugs.findByDrugNameIlike(params.drug)
				if(alreadyExist){
					if(!alreadyExist.id.toString().equals(params.drugId)){
						flash.msg = "Drug '"+params.drug+ "' with this name already exists"
					}else{
					update(params)
					}
				}else{
				update(params)
				}
			}
			[drug:drug]
		}else{
		// do nothing
		}
	}

	/**
	 *
	 * @return update a drug
	 */

	def update(params){
		try {
			authorizeMe()
			if(params!=null && params.drugId!=null && params.drug!=null && params.drug!="" && params.drugId!=""){
					Drugs drugs = drugsService.update(params)
					if(drugs != null && drugs.validate()){
						auditEventService . save(AuditEventType.updatedDrug,Role.admin, session)
						flash.msg = "Drug '"+drugs?.drugName+ "' name updated sucessfully"
						log.info("Drug'"+drugs?.drugName+ "'name updated sucessfully")
						redirect(action:'view')
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
	
	

	/**
	 *
	 * @return delete a drug
	 */

	def delete()
	{
		authorizeMe()	//***** Check Authorization
		try{
			if(params !=null && params.drugId !=null && !params.drugId.isEmpty()){
				def drugs = drugsService.deleteDrugs(params)
				if(drugs){
					auditEventService . save(AuditEventType.deletedDrug,Role.admin, session)
					//flash.msg = "Drug Type has been made inactive"
					flash.msg ="Drug '"+Drugs.get(params.drugId).drugName+"'"+" name has been made Inactive"
					log.info("Drug Type has been made inactive")
				}
				else{
					flash.msg =  "Drug deletion failed due to some errors"
					log.info("Drug deletion failed due to some errors")
				}
			}
		}catch(Exception exception)
		{
			exception.printStackTrace();
		}
		redirect(action:'view')
	}

	def cancel(){
		authorizeMe()	//***** Check Authorization
		redirect(action:'view')}


	def ajaxPaginate(){
		try{
			def drugList = drugsService.viewAll(params)
			render (template :'viewDrugs' ,model:[drugList : drugList ,total:drugsService.getCount(params) ,offset:params.offset ,max :params.max,searchValue:params.searchValue])
		}catch(Exception exception){
			log.error(exception)
		}
	}
	def authorizeMe(){
		if(session.user && session.authority?.equalsIgnoreCase(Role.admin)){
			// do nothing
		}else{
			redirect(controller:'Home', action:'index')
		}
	}
	def searchValues(){
		try{
			params.max = Math.min(params.max ? params.int('max') :10, 100)
			render(template:"viewDrugs",model:[drugList : drugsService.viewAll(params) ,total:drugsService.getCount(params),offset:0 ,max : params.max, searchValue: params.searchValue])
		}catch(Exception exception){ exception.printStackTrace() }
	}
}
