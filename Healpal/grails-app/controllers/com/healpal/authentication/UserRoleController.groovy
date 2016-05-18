/*
 * Author    : Manikandan
 * Project   : Healpal
 * Date      : 10/06/2015
 * Description : view , assign userroles
 *
 * #   Name       Version   Modified-Date      Description
 * -------------------------------------------------------------------------------------
 * 1   Manikandan    1.0    10/09/2015         Initial Creation
 *
 */
package com.healpal.authentication

import com.healpal.care.AuditEventService;
import com.healpal.care.AuditEventType;
import com.healpal.care.HealpalUser;
import com.healpal.care.Role;
import com.healpal.care.RoleService
import com.healpal.care.UserRole;
import com.healpal.care.UserRoleService
import com.healpal.care.UserService

class UserRoleController {

	
	def UserService userService
	def RoleService roleService
	def UserRoleService userRoleService
	def AuditEventService auditEventService
	
    def index() { }
	
	
	def view(){
		try{
			authorizeMe() //***** Check Authorization
			params.max = Math.min(params.max ? params.int('max') : 10, 100)
			[userroles : userRoleService.getList(params) ,total:UserRole.list()?.size() ,offset:0 ,max : params.max,searchValue:""]
		}catch(Exception exception){
			//exception . printStackTrace()
			log.error(exception)
		}
	}
	
	
	
	def create(){
		try{
			authorizeMe() //***** Check Authorization
			
			switch(request.method){
				case 'GET':
					[action:'create' ,usersList : userService.getUserList("create") ,roleList : roleService.getRoleList("create")]
				break
				case 'POST':
				
				if(params != null && params.healpalUser != null && !params.healpalUser.isEmpty()
					&& params.role != null && !params.role.isEmpty()){
							println "UserRoleController . create = create initiated"			//Debug
							// user role creation
							UserRole urole = userRoleService . save(params ,new UserRole() ,"create")
							
							if(urole != null && urole.validate()){
								auditEventService . save(AuditEventType.updatedUserRole, Role.admin, session) // audit save
								println "UserRoleController . create = "  +"Role "+Role.get(params.role.toLong())?.authority + " added to "+HealpalUser.get(params.healpalUser.toLong())?.userName +" sucessfully"			//Debug
								flash.msg = "Role '"+Role.get(params.role.toLong())?.authority + " added to "+HealpalUser.get(params.healpalUser.toLong())?.userName +"'saved sucessfully"
								redirect action:'view'
							}else if(urole == null){
								flash.msg = "User creation failed due to some errors"
							}else{
								flash.msg = ""
								[urole:urole,action:'create',usersList : userService.getUserList("create") ,roleList : roleService.getRoleList("create")]
							}
				}else{
					//do nothing
				}
					
				break
			}
		}catch(Exception exception){
			//exception . printStackTrace()
			log.error(exception)
		}
	}
	
	
	def edit(){
		try{
			authorizeMe() //***** Check Authorization
			switch(request.method){
				case 'GET':
					UserRole userrole = null
					if(params.id != null && params.id != null){
							userrole = UserRole . get(params.id)
					}else{
						//do nothing
					}
					[action:'edit' ,userrole : userrole ,usersList : userService.getUserList("edit") ,roleList : roleService.getRoleList("edit")]
				break
				case 'POST':
					if(params.hiddenId != null && !params.hiddenId.toString().isEmpty()
							&& params.role != null && !params.role.isEmpty()){
						println "UserRoleController . edit = edit initiated"			//Debug
						// user role changing 
						UserRole urole = userRoleService . save(params ,UserRole.get(params.hiddenId) ,"")
						
						if(urole != null && urole.validate()){
							auditEventService . save(AuditEventType.updatedUserRole, Role.admin, session) // audit save
							flash.msg = "Role "+Role.get(params.role.toLong())?.authority + " added to '"+UserRole.get(params.hiddenId?.toLong())?.healpalUser?.userName +"'updated sucessfully"
							println "UserRoleController . edit =" +"Role "+Role.get(params.role.toLong())?.authority + " added to "+UserRole.get(params.hiddenId?.toLong())?.healpalUser?.userName +" sucessfully"			//Debug
							redirect action:'view'
						}else if(urole == null){
							flash.msg = "User creation failed due to some errors"
						}else{
							flash.msg = ""
							[userrole:urole,action:'edit' ,usersList : userService.getUserList("edit") ,roleList : roleService.getRoleList("edit")]
						}
						
					}else{
						//do nothing
					}
				break
			}
			
			
			
		}catch(Exception exception){
			//exception . printStackTrace()
			log.error(exception)
		}
	}
	
	
	def delete(){
		try{
			authorizeMe() //***** Check Authorization
			if(params.id != null && !params.id.toString().isEmpty()){
				// user role make inactive for the user
				int updateCount = userRoleService . delete(params)
				if(updateCount > 0){
					auditEventService . save(AuditEventType.deletedUserRole, Role.admin, session) // audit save
					flash.msg = 'UserRole'+"'"+HealpalUser.get(params.id)?.userName+"'"+'has been made inactive'
					//flash.msg ="HealthInsurance Type '"+PersonalInterest.get(params.personalInterestId).personalInterestType+"'"+" name has been made Inactive"
					println "UserRoleController . delete = UserRole has been made inactive"			//Debug
				}
			}else{
			//do nothing
			}
			redirect action:'view'
		}catch(Exception exception){
			//exception . printStackTrace()
			log.error(exception)
		}
	}
	
	
	def ajaxPaginate(){
		try{ 
			if(session.user && session.authority?.equalsIgnoreCase(Role.admin) || session.authority?.equalsIgnoreCase(Role.SuperAdmin)){
					render (template :'list' ,model:[userroles : userRoleService.getList(params) ,total:userRoleService.getCount(params) ,offset:params.offset ,max :params.max,searchValue:params.searchValue])
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
			 render(template:"list",model:[userroles : userRoleService.getList(params) ,total:userRoleService.getCount(params),offset:0 ,max : params.max, searchValue: params.searchValue])
		 }catch(Exception exception){ exception.printStackTrace() }
	 }
}
