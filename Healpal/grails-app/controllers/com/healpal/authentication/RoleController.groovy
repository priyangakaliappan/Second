/*
 * Author    : Manikandan
 * Project   : Healpal
 * Date      : 10/05/2015
 * Description : List  ,Create ,Edit ,Delete of Roles
 *
 * #   Name       Version   Modified-Date      Description
 * -------------------------------------------------------------------------------------
 * 1   Manikandan    1.0    10/05/2015         Initial Creation
 *
 */
package com.healpal.authentication

import com.healpal.care.AuditEventService
import com.healpal.care.AuditEventType;
import com.healpal.care.Role;
import com.healpal.care.RoleService
import com.healpal.care.UserRoleService

class RoleController {
	
	def AuditEventService auditEventService
	def RoleService roleService
	def UserRoleService userRoleService

    def index() { }
	
	def view(){
		try{
			authorizeMe() //***** Check Authorization
			params.max = Math.min(params.max ? params.int('max') : 10, 100)
			[roles : roleService.getList(params) ,total:Role.list()?.size() ,offset:0 ,max : params.max,searchValue:""]
		}catch(Exception exception){
			//exception.printStackTrace()
			log.error(exception)
		}
	}
	
	
	def create(){
		try{
			authorizeMe() //***** Check Authorization
			
			switch(request.method){
				case 'GET':
					[action:'create']
				break
				case 'POST':
				
				if(params != null && params.authority != null && !params.authority.isEmpty()){
							println "RoleController . create = role create initiated"			//Debug
							// new role save
							Role role = roleService . save(params ,new Role() ,"create")
							
							if(role != null && role.validate()){
								auditEventService . save(AuditEventType.addedRole, Role.admin, session) 	// audit save
								flash.msg = "Role '"+role?.authority + "' name saved successfully"
								println "RoleController . create = Role "+role?.authority + " has been created sucessfully"			//Debug
								redirect action:'view'
							}else if(role == null){
								flash.msg = "User creation failed due to some errors"
							}else{
								flash.msg = ""
								[role:role,action:'create']
							}
				}else{
					//do nothing
				}
					
				break
			}
		}catch(Exception exception){
			//log.info (">>>>>>>>>>>>> Insid elogger >>>>>>>>>>>>>>>>")
			log.error(exception.getMessage())
			//exception.printStackTrace()
		}
	}
	
	def edit(){
		try{
			authorizeMe() //***** Check Authorization
			
			
			switch(request.method){
				case 'GET':
					Role role = null
					if(params.id != null && params.id != null){
							role = Role . get(params.id)
					}else{
						//do nothing
					}
					[action:'edit' ,role : role]
				break
				case 'POST':
					if(params.hiddenId != null && !params.hiddenId.toString().isEmpty()
							&& params.authority != null && !params.authority.toString().isEmpty()){
						println "RoleController . edit = role edit initiated"			//Debug
						// already exist role edit and update
						Role role = roleService . save(params , Role.get(params.hiddenId) ,"")
						if(role != null && role.validate()){
							// based on the role active & inactive make 'user role'   
							userRoleService.update(role ,params) 												// while make ROLE inactive Updating UserRole Also 
							auditEventService . save(AuditEventType.updatedRole, Role.admin, session) 	// audit save
							flash.msg = "Role '"+role?.authority + "' name updated successfully"
							println "RoleController . edit = Role "+role?.authority + " name updated successfully"			//Debug
							redirect action:'view'
						}else if(role == null){
							flash.msg = "User creation failed due to some errors"
						}else{
							flash.msg = ""
							[role:role,action:'edit']
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
	
	def delete(){
		try{
			authorizeMe() //***** Check Authorization
			if(params.id != null && !params.id.toString().isEmpty()){
					// soft delete of role
					int updateCount = roleService . delete(params)
					if(updateCount > 0){
						auditEventService . save(AuditEventType.deletedRole, Role.admin, session) 	// audit save
						println "RoleController . delete = "+Role.get(params.id)?.authority + " has been made inactive"			//Debug
						
						flash.msg ="Role '"+Role.get(params.id)?.authority+"'"+" name has been made Inactive"
					}
				}else{
				//do nothing
			}
		redirect action:'view'
			
		}catch(Exception exception){
			//exception.printStackTrace()
			log.error(exception)
		}
	}
	
	// role list ajax paginate
	def ajaxPaginate(){
		try{
			if(session.user && session.authority?.equalsIgnoreCase(Role.admin) || session.authority?.equalsIgnoreCase(Role.SuperAdmin)){
					render (template :'list' ,model:[roles : roleService.getList(params) ,total: roleService.getCount(params), offset:params.offset ,max :params.max,searchValue:params.searchValue])
			}else{
					//do nothing
			}
		}catch(Exception exception){
			//exception.printStackTrace()
			log.error(exception)
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
			 render(template:"list",model:[roles : roleService.getList(params),total: roleService.getCount(params),offset:0 ,max : params.max, searchValue: params.searchValue])
		 }catch(Exception exception){ exception.printStackTrace() }
	 }
}
