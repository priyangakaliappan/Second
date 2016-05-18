/*
 * Author    : Manikandan
 * Project   : Healpal
 * Date      : 10/01/2015
 * Description : User Authentication and Authorization
 *
 * #   Name       Version   Modified-Date      Description
 * -------------------------------------------------------------------------------------
 * 1   Manikandan    1.0    10/02/2015        Initial Creation
 *
 */

package com.healpal.authentication

import com.healpal.authentication.AuthService;
import com.healpal.care.AuditEventService;
import com.healpal.care.AuditEventType;
import com.healpal.care.HealpalUser;
import com.healpal.care.ProfileCompletionService
import com.healpal.care.Role;
import com.healpal.care.UserRole;

class AuthController {

	def AuditEventService auditEventService
	def AuthService authService
	def ProfileCompletionService profileCompletionService
    def index() { }
	
	
	
	/*
	 * Form Login
	 * 
	 * **/
	def doLogin(){
		try{
			if(request.post){
			HealpalUser user = null
			String authMsg
			// Authenticating the user using given Username and password
			user = authService.checkLogin(params)
			if(user != null){
				// verifying account is activated or locked or expired 
				authMsg = authVerify(user)
				// based on the role of user redirecting
				if(authMsg != ""){
					flash.msg=authMsg
					redirect controller :'home' ,action :'index'
				}else if(authMsg.equals("")){// Check role and redirect
					session.user = user
					session.personName = user?.person?.fullName
					auditEventService . save(AuditEventType.successLogin, authService.getAuthority(user), session) // audit save
					println "AuthController.doLogin = Login Success"
					roleCheck(user)
				}
			}else{
					flash.msg="Sorry, we were not able to find a user with that username and password."
					redirect controller :'home' ,action :'index'
			}
		}
		}catch(Exception e){
			e.printStackTrace()
		}
	}
	
	
	/*
	 * Ajax Login
	 * 
	 * **/
	def ajaxLogin(){
		try{
			def msg
			switch(request.method){
				case 'POST':
					println "AuthController . ajaxLogin = login initiated"
						HealpalUser user = null
						UserRole userRole = null
						String authMsg
						// Authenticating the user using given Username and password
						user = authService.checkLogin(params)
						println"user:::::::::::::::::::::"+user
						userRole=authService.checkUserRole(user)
						if(user != null){
							println"yes user"
							// verifying account is activated or locked or expired
							authMsg = authVerify(user)
							// based on the role of user result return to Ajax call
							if(authMsg != ""){
								println"yes authMsg"
								msg = authMsg
							}else if(userRole==null){
							println"yes  userrole"
							msg = 'No role for this user'
							}
							else if(authMsg.equals("")){// Check role
								session.user = user
								session.personName = user?.person?.fullName
								println "AuthController . ajaxLogin = login success"
								auditEventService . save(AuditEventType.successLogin, authService.getAuthority(user), session) // audit save
								msg = 'login success'
							}
						}else{
							msg = "Sorry, we were not able to find a user with that username and password."
						}
				break;
				
				case 'GET':
				break
			}
			render msg
		}catch(Exception e){
			e.printStackTrace()
		}
	}
	
	def authVerify(HealpalUser user){
		String msg = ""
		if(user != null){
			if(!user.enabled){
				msg = "Sorry, your account is disabled."
			}else if(user.accountLocked){
				msg = "Sorry, your account is locked."
			}else if(user.accountExpired){
				msg = "Sorry, your account is expired."
			}else if(user.passwordExpired){
				msg = "Sorry, your account password is expired."
			}
			return msg
		}else{	//do nothing
		}
	}
	
	def jsRoleCheck(){
		println "JS role check initialized"
		if(session.user){
			roleCheck(session.user)
		}
	}
	
	
	// based on the role of user redirecting from JavaSript call
	def roleCheck(HealpalUser user){
		String authority = authService.getAuthority(user)
		session.authority = authority
		if(authority != null && authority.equalsIgnoreCase(Role.patient)){
			String profile = profileCompletionService . check(session)
			if(profile?.equalsIgnoreCase("updated")){ 
				redirect controller :'dashboard' ,action :'view'
			}else if(profile?.equalsIgnoreCase("not updated")){ 
				redirect controller :'profile' ,action :'a0'
			}else if(profile?.split(":")[0].toString().equalsIgnoreCase("go")){ 
				redirect controller :'profile' ,action : profile?.split(":")[1]
			}		
		}else if(authority != null && authority.equalsIgnoreCase(Role.expert)){
			redirect controller :'dashboard' ,action :'view'
		}else if(authority != null && authority.equalsIgnoreCase(Role.admin) ){
		println"admin"
			redirect controller :'dashboard' ,action :'adminDashboard'	
		}
		else if(authority != null && authority.equalsIgnoreCase(Role.SuperAdmin)){
			println"superadmin"
				redirect controller :'dashboard' ,action :'adminDashboard'
			}
		else{
			doLogout()
		}
	}
	
	def getSessionStatus(){
		if(session.user){
			render true
		}
		else{
			render false
		}
		
	}
	
	def doLogout(){
		HealpalUser user = session.user
		auditEventService . save(AuditEventType.manLogout, authService.getAuthority(user), session) // audit save
		session.user = null
		session.getDOB=null
		session.getDateOfDiagnosis=null
		redirect controller :'home' ,action :'index'
	}
	
	//***********************
	
	
	
}
