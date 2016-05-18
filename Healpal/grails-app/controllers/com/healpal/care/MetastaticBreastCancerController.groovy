/*
 * Author    : Priyanga K
 * Project   : Healpal
 * File      : MetastaticBreastCancerController
 * Date      : 23-10-2015
 * Description : Show all MetastaticBreastCancer, Create a MetastaticBreastCancer, edit a MetastaticBreastCancer
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
class MetastaticBreastCancerController{

	def MetastaticBreastCancerService metastaticBreastCancerService
	def AuditEventService auditEventService

	def index() {
	}
	/**
	 *
	 * @return get all metastatic breast cancer
	 */
	def view(){
		authorizeMe()	//***** Check Authorization
		try{
			params.max = Math.min(params.max ? params.int('max') : 10, 100)
			def metastaticBreastCancer =metastaticBreastCancerService.viewAll(params)
			[metastaticBreastCancer:metastaticBreastCancer,total:MetastaticBreastCancer.list()?.size(),offset:0 ,max : params.max,searchValue:""]
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	 *
	 * @return create metastatic breast cancer
	 */
	def create(){
		authorizeMe()	//***** Check Authorization
		render(view:'add')
	}
	/**
	 *
	 * @return save metastatic breast cancer
	 */
	def save(){
		authorizeMe()	//***** Check Authorization
		
		
		try{
			authorizeMe()

			if(params !=null && params.metastaticName !=null && !params.metastaticName.isEmpty()){
				 
				def alreadyExist=MetastaticBreastCancer.findByMetastaticNameIlike(params.metastaticName)
				if(alreadyExist !=null){
					
					flash.msg ="Metastatic Breast Cancer '"+params.metastaticName+"'"+"with this name already exist"
					redirect(action:"create")
				}else{
				  MetastaticBreastCancer metastaticBreastCancer = metastaticBreastCancerService.save(params)
				if(metastaticBreastCancer != null && metastaticBreastCancer.validate()){
					auditEventService . save(AuditEventType.addedMetastaticBreastCancer,Role.admin, session)
					flash.msg = "Metastatic Breast Cancer '"+metastaticBreastCancer?.metastaticName+ "'name created sucessfully"
					redirect(action:'view')
				}else{
					flash.msg =  "Metastatic Breast Cancer creation failed due to some errors"
					redirect(action:'create')
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
	 *
	 * @return edit metastatic breast cancer
	 */
	
	
	
	
	def edit(){
		authorizeMe()
		if(params.metastaticId != null&& !params.metastaticId.isEmpty()){
			def metastaticBreastCancer=MetastaticBreastCancer.get(params.metastaticId);
			if(request.post){
				def alreadyExist=MetastaticBreastCancer.findByMetastaticNameIlike(params.metastaticName)
				if(alreadyExist){
					if(!alreadyExist.id.toString().equals(params.metastaticId)){
						flash.msg = "Metastatic Breast Cancer '"+params.metastaticName+ "'name already exist"
					}else{
					update(params)
					}
				}else{
				update(params)
				}
			}
			[metastaticBreastCancer:metastaticBreastCancer]
		}else{
		// do nothing
		}
	}
	
	
	
	/**
	 *
	 * @return delete metastatic breast cancer
	 */
	def delete(){
		authorizeMe()	//***** Check Authorization
		try{
			if(params !=null && params.metastaticId !=null && !params.metastaticId.isEmpty()){
				def metastaticBreastCancer = metastaticBreastCancerService.deleteMetastaticBreastCancer(params)
				if(metastaticBreastCancer){
					auditEventService . save(AuditEventType.deletedMetastaticBreastCance,Role.admin, session)
					//flash.msg = "Metastatic Breast Cancer has been made inactive"
					flash.msg ="Metastatic Breast Cancer '"+MetastaticBreastCancer.get(params.metastaticId).metastaticName+"'"+" name has been made Inactive"
				}
				else{
					flash.msg =  "Metastatic Breast Cancer Inactivation failed due to some errors"
				}
			}else{ // do nothing
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		redirect(action:'view')

	}
	def cancel(){
		authorizeMe()	//***** Check Authorization
		redirect(action:'view')}
	/**
	 *
	 * @return update name of metastatic breast cancer
	 */
	def update(params){
		authorizeMe()	//***** Check Authorization
		try{
			if(params !=null &&params.metastaticId !=null && !params.metastaticId.isEmpty() &&
			params.metastaticName !=null && !params.metastaticName.isEmpty() && params.status != null && !params.status.isEmpty()){
				MetastaticBreastCancer metastaticBreastCancer = metastaticBreastCancerService.update(params)
				if(metastaticBreastCancer != null && metastaticBreastCancer.validate()){
					auditEventService . save(AuditEventType.updatedMetastaticBreastCance,Role.admin, session)
					flash.msg = "Metastatic Breast Cancer '"+metastaticBreastCancer?.metastaticName+ "'name updated sucessfully"
					redirect(action:'view')
				}else{
					flash.msg =  "Metastatic Breast Cancer updation failed due to some errors"
					
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}

	}

	def ajaxPaginate(){
		try{
			def metastaticBreastCancer = metastaticBreastCancerService.viewAll(params)
			render (template :'viewMetastatic' ,model:[metastaticBreastCancer : metastaticBreastCancer ,total:metastaticBreastCancerService.getCount(params) ,offset:params.offset ,max :params.max,searchValue:params.searchValue])
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
			render(template:"viewMetastatic",model:[metastaticBreastCancer : metastaticBreastCancerService.viewAll(params) ,total:metastaticBreastCancerService.getCount(params),offset:0 ,max : params.max, searchValue: params.searchValue])
		}catch(Exception exception){
			exception.printStackTrace()
		}
	}
}
