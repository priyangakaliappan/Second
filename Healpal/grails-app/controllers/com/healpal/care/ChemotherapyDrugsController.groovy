/*
 * Author    : Priyanga K
 * Project   : Healpal
 * File      : ChemotherapyDrugsController
 * Date      : 23-10-2015
 * Description : Show all Chemotherapydrugs, Create a Chemotherapydrugs, edit a Chemotherapydrugs
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
class ChemotherapyDrugsController {

	def ChemotherapyDrugsService chemotherapyDrugsService
	def AuditEventService auditEventService

	def index() {
	}

	/**
	 *
	 * @return get all chemotheraphydrugs
	 */

	def view() {
		authorizeMe()	//***** Check Authorization
		try{
			params.max = Math.min(params.max ? params.int('max') : 10, 100)
			def chemotherapyDrugs = chemotherapyDrugsService.viewAll(params)
			[chemotherapyDrugs:chemotherapyDrugs,total:ChemotherapyDrugs.list()?.size(),offset:0 ,max : params.max,searchValue:"" ]

		}catch(Exception exception)
		{
			exception.printStackTrace();
		}
	}

	/**
	 *
	 * @return create a chemotheraphydrugs
	 */

	def create()
	{
		authorizeMe()
		render(view:'add')
	}

	/**
	 *
	 * @return saved chemotheraphydrugs
	 */ 
	def save()
	{
		authorizeMe()    //***** Check Authorization
		try
		{
			if(params!=null && params.chemotherapyDrugs !=null && !params.chemotherapyDrugs.toString().isEmpty())
			{

				def exist=ChemotherapyDrugs.findByChemotherapyDrugsTypeIlike(params.chemotherapyDrugs)
				if(exist !=null){
					flash.msg = "Chemotherapy drug '"+params.chemotherapyDrugs+ "'  with this name already exists"
					redirect(action:'create')
				}else{
					ChemotherapyDrugs chemotherapyDrugs = new ChemotherapyDrugs()
					chemotherapyDrugs = chemotherapyDrugsService.save(params)
					if(chemotherapyDrugs != null && chemotherapyDrugs.validate())
					{
						auditEventService . save(AuditEventType.addedChemotheraphy,Role.admin, session)
						flash.msg = "Chemotherapy drug '"+chemotherapyDrugs?.chemotherapyDrugsType+ "' name saved successfully"
						redirect(action:'view')

					}else{
						flash.msg ="Cancer Status Failed due to some error"
					}
				}


			}else
			{
				// do nothing
			}
		}catch(Exception exception)
		{
			exception.printStackTrace();
		}
	}

	/**
	 *
	 * @return edit chemotheraphydrugs
	 */

	
	
	def edit(){
		authorizeMe()
		if(params.chemotherapyDrugsId != null&& !params.chemotherapyDrugsId.isEmpty()){
			def chemotherapyDrugs=ChemotherapyDrugs.get(params.chemotherapyDrugsId)
			if(request.post){
				def alreadyExist=ChemotherapyDrugs.findByChemotherapyDrugsTypeIlike(params.chemotherapyDrugs)
				if(alreadyExist){
					if(!alreadyExist.id.toString().equals(params.chemotherapyDrugsId)){
						flash.msg ="Chemotherapy drug '"+params.chemotherapyDrugs+"'"+" with this name already exists"
					}else{
					update(params)
					}
				}else{
				update(params)
				}
			}
			[chemotherapyDrugs:chemotherapyDrugs]
		}else{
		// do nothing
		}
	}
	
	/**
	 *
	 * @return update chemotheraphydrugs
	 */


	def update(params){
		try {
			authorizeMe()
			if(params!=null && params.chemotherapyDrugsId!=null && params.chemotherapyDrugs!=null && params.chemotherapyDrugs!="" && params.chemotherapyDrugsId!=""){
					ChemotherapyDrugs chemotherapyDrugs= chemotherapyDrugsService.update(params)
					if(chemotherapyDrugs!=null && chemotherapyDrugs.validate()){
						auditEventService . save(AuditEventType.updatedChemotheraphy, Role.admin, session)
						flash.msg = "Chemotherapy drug '"+chemotherapyDrugs?.chemotherapyDrugsType+ "' updated sucessfully"
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
	
	/**
	 *
	 * @return delete chemotheraphydrugs
	 */

	def delete(){
		authorizeMe()  //***** Check Authorization
		if(params!=null && params.chemotherapyDrugsId !=null && !params.chemotherapyDrugsId.isEmpty())
		{
			def chemotherapyDrugs = chemotherapyDrugsService.deleteChemotherapyDrugs(params)
			if(chemotherapyDrugs)
			{
				auditEventService . save(AuditEventType.deletedChemotheraphy, Role.admin, session)
				//flash.msg = "Chemotherapy drug has been made inactive"
				flash.msg ="Chemotherapy drug '"+ChemotherapyDrugs.get(params.chemotherapyDrugsId).chemotherapyDrugsType+"'"+" name has been made Inactive"
			}
			else
			{
				flash.msg =  "chemotherapy drug deletion failed due to some errors"
			}
		}
		redirect(action:'view')
	}
	def cancel(){
		authorizeMe()   //***** Check Authorization
		redirect(action:'view')
	}

	def ajaxPaginate(){
		try{
			def chemotherapyDrugs = chemotherapyDrugsService.viewAll(params)
			render (template :'viewChemotheraphy' ,model:[chemotherapyDrugs : chemotherapyDrugs ,total: chemotherapyDrugsService.getCount(params),offset:params.offset ,max :params.max,searchValue:params.searchValue])
		}catch(Exception exception)
		{
			exception.printStackTrace()
		}
	}

	def authorizeMe()
	{
		if(session.user && session.authority?.equalsIgnoreCase(Role.admin))
		{
			// do nothing
		}else{
			redirect(controller:"home",action:"index")
		}
	}
	def searchValues(){
		try{
			params.max = Math.min(params.max ? params.int('max') :10, 100)
			render(template:"viewChemotheraphy",model:[chemotherapyDrugs : chemotherapyDrugsService.viewAll(params) ,total: chemotherapyDrugsService.getCount(params),offset:0 ,max : params.max, searchValue: params.searchValue])
		}catch(Exception exception){ exception.printStackTrace() }
	}
}
