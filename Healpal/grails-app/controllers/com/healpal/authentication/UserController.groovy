/*
 * Author    : Manikandan
 * Project   : Healpal
 * Date      : 10/01/2015
 * Description : List  ,Create ,Edit ,Delete of Healpal User
 *
 * #   Name       Version   Modified-Date      Description
 * -------------------------------------------------------------------------------------
 * 1   Manikandan    1.0    10/05/2015         Initial Creation
 *
 */

package com.healpal.authentication

import org.codehaus.groovy.grails.web.context.ServletContextHolder;

import com.healpal.care.AuditEventService
import com.healpal.care.AuditEventType;
import com.healpal.care.HealpalUser
import com.healpal.care.Patient;
import com.healpal.care.PatientMedicalDocument;
import com.healpal.care.Person;
import com.healpal.care.ProfilePhoto;
import com.healpal.care.ProfileService;
import com.healpal.care.Role;
import com.healpal.care.UserService

class UserController {

	
	def UserService userService
	def AuditEventService auditEventService
	
    def index() { }
	
	def view(){
		try{
			authorizeMe() //*****  Authorization checking
			params.max = Math.min(params.max ? params.int('max') : 10, 100)
			[users : userService.getList(params) ,total:HealpalUser.list()?.size() ,offset:0 ,max : params.max,searchValue:""]
		}catch(Exception exception){
			//exception.printStackTrace()
			log.error(exception)
		}
	}
	
	
	def create(){
		try{
		
			authorizeMe() //***** Authorization checking
				
					switch(request.method){
						case 'GET':
							[action:'create']
						break
						case 'POST':
						
						if(params != null && params.email != null && !params.email.isEmpty()
							&& params.password != null && !params.password.toString().isEmpty()
							&& params.username != null && !params.username.isEmpty()
							){
									println"UserController . create = user creation initiated" 						////Debug code
																	//**** user create 
									HealpalUser user = userService . doSave(params ,new HealpalUser() ,new Person() ,"create",request)
									
									if(user != null && user.validate()){
										//******* audit save
										auditEventService . save(AuditEventType.addedUser, Role.admin, session) 
										flash.msg = "User '"+user?.person?.fullName + "' account has been created sucessfully"
										println"UserController . create = "+user?.person?.fullName + " account has been created sucessfully"		//Debug code
										redirect action:'view'
									}else if(user == null){
										flash.msg = "User creation failed due to some errors"
									}else{
										flash.msg = ""
										[user:user,action:'create']
									}
						}else{
							//do nothing
						}
							
						break
					}
		}catch(Exception exception){
			//exception.printStackTrace()
			log.error(exception)
		}
	}
	
	def edit(){
		try{
		
			authorizeMe() //*****  Authorization checking
			
				switch(request.method){
					case 'GET':
						HealpalUser user = null
						if(params.userId != null && params.personId != null){
								user = HealpalUser . get(params.userId)
								
						}else{
							//do nothing
						}
						def profilePhoto = ProfilePhoto.findByPatient(Patient.findByPerson(user?.person))
						
						//def patientName=Person.get(user?.person?.id)
						[action:'edit' ,user : user,profilePhoto:profilePhoto]
					break
					case 'POST':
						if(params.hiddenUserId != null && !params.hiddenUserId.toString().isEmpty() 
								&& params.hiddenPersonId != null && !params.hiddenPersonId.toString().isEmpty()
							&&	params != null && params.email != null && !params.email.isEmpty()
							&& params.password != null && !params.password.toString().isEmpty()
							&& params.username != null && !params.username.isEmpty()){	
								println"UserController . create = user edit initiated" 						////Debug code
								//**** user update
								println "params.uploadPhoto;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;"+params.hiddenUserId
							HealpalUser user = userService . doSave(params ,HealpalUser.get(params.hiddenUserId) ,Person.get(params.hiddenPersonId) ,"",request)
							
							if(user != null && user.validate()){  
								if(user.password){
									auditEventService . save(AuditEventType.updatedPasswordU, Role.admin, session) // audit save
								}
								auditEventService . save(AuditEventType.updatedUser, Role.admin, session) // audit save
								flash.msg = "User "+user?.person?.fullName + " name updated successfully"
								println"UserController . edit = "+user?.person?.fullName + " details has been changed"		//Debug code
								redirect action:'view'
							}else if(user == null){
								flash.msg = "User creation failed due to errors"
							}else{
								flash.msg = ""
								[user:user,action:'edit']
							}
						}else{
							//do nothing	
						}
					break
				}
				
		}catch(Exception exception){
			log.error(exception)
			//exception.printStackTrace()
		}
	}
	
	
	
	def doDelete(){
		try{
			authorizeMe() //***** Authorization Checking
				if(params.userId != null && !params.userId.toString().isEmpty()
					&& params.personId != null && !params.personId.toString().isEmpty()){
						// user account make inactive when click delete 
						int updateCount = userService . disableAccount(params)
						if(updateCount > 0){
							auditEventService . save(AuditEventType.deleteddUser, Role.admin, session) // audit save
							flash.msg ="User '"+HealpalUser.get(params.userId)?.userName+"'"+" name has been made Inactive"
							println"UserController . edit = "+HealpalUser.get(params.userId)?.userName + ' account has been made inactive'	//Debug code
						}
					}else{
					//do nothing
				}	
			redirect action:'view'
		}catch(Exception exception){
			log.error(exception)
			//exception.printStackTrace()
		}
	}
	/**
	 * Get patient medical documents
	 * @return
	 */
	def userDocuments(){
		try{
			authorizeMe()
			def documents=""
			if(params.personId != null && !params.personId.toString().isEmpty()){
				documents = PatientMedicalDocument.createCriteria().list(){
				patient{
					eq("person",Person.get(params.personId.toLong()))}
				}
			}
			render(view:'documents',model:[documents:documents])
		}catch(Exception exception){
			exception.printStackTrace()
		}
	}
	/**
	 * download patient documents
	 * @return
	 */
	def downloadDoc(){
		try{
			authorizeMe()
			if(params.personId !=null && params.personId !=""){
				def serveletContext = ServletContextHolder.servletContext
					def storagePath =serveletContext.getRealPath(params.filePath) 
					def file = new File(storagePath+"/"+params.fileName)
					if (file.exists()) {
						response.setContentType("application/octet-stream")
						response.setHeader("Content-disposition", "filename=${file.name}")
						response.outputStream << file.bytes
					}else{
						//do nothing
					}
			redirect(action:'userDocuments',params:[personId:params.personId])
			}
		}catch(Exception exception){
			exception.printStackTrace()
		}
	}
	/**
	 *  Sending email to registered user to verify document
	 * @return
	 */
	def sendmail(){
		try{
				authorizeMe()
				if(params.personId !=null && params.personId !=""){
					def person = Person.get(params.personId.toLong())
					if(person!=null && person !=""){
						userService.sendMail(person?.emailAddress, person?.fullName)
					}else{
						//do nothing
					}
					flash.msg="Mail sent successfully"
					redirect(action:'userDocuments',params:[personId:params.personId])
				}
			}catch(Exception exception){
				exception.printStackTrace()}
	}
	def ajaxPaginate(){
		try{
			if(session.user && session.authority?.equalsIgnoreCase(Role.admin) || session.authority?.equalsIgnoreCase(Role.SuperAdmin)){
					render (template :'list' ,model:[users : userService.getList(params) ,total:userService.getCount(params) ,offset:params.offset ,max :params.max,searchValue:params.searchValue])
			}else{
					//do nothing
			}
		}catch(Exception exception){
			exception.printStackTrace()
			log.error(exception)
		}
	}
	
	
	def photo(){
		try{
			authorizeMe()
			if(params !=null){
			println"inside photo"+params.profilePhoto
			
			[action:'edit']
			def photos=userService.photoSave(params ,HealpalUser.get(params.hiddenUserId) ,Person.get(params.hiddenPersonId),request,"")
			
			redirect(action:'edit',params:[personId:params.hiddenPersonId,userId:params.hiddenUserId])
			}
		}catch(Exception e){
		e.printStackTrace()
		}
	}
	
	//******************************************
	def authorizeMe(){
		if(session.user && session.authority?.equalsIgnoreCase(Role.admin) || session.authority?.equalsIgnoreCase(Role.SuperAdmin)){
			//do nothing
		}else{
			redirect controller :'auth' ,action :'doLogout'
		}
	}
	def searchValues(){
		try{
			params.max = Math.min(params.max ? params.int('max') :10, 100)
			render(template:"list",model:[users : userService.getList(params) ,total:userService.getCount(params),offset:0 ,max : params.max, searchValue: params.searchValue])
		}catch(Exception exception){ exception.printStackTrace() }
	}
}
