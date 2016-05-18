/*
 * Author    : Manikandan
 * Project   : Healpal
 * Date      : 10/02/2015
 * Description : Service for the Auth Controller
 *
 * #   Name       Version   Modified-Date      Description
 * -------------------------------------------------------------------------------------
 * 1   Manikandan    1.0    10/03/2015        Initial Creation
 *
 */
package com.healpal.authentication

import com.healpal.care.HealpalUser
import com.healpal.care.UserRole;
import com.healpal.encryptdecrypt.BCrypt
import grails.transaction.Transactional

//@Transactional
class AuthService {

    def serviceMethod() {

    }
	
	
	HealpalUser checkLogin(params){
		try{
			HealpalUser user = null
			if(params != null && params.username != null && !params.username.isEmpty() && params.password && !params.password.isEmpty()){
				byte[] password = params.password?.trim().getBytes()
				String encryptPassword = BCrypt.encode_base64(password, params.password?.length())
				user = HealpalUser.findByUserNameAndPassword(params.username,encryptPassword)
			}
			return user
		}catch(Exception ex){
			ex.printStackTrace()
		}
	}
	
	
	
	UserRole checkUserRole(user){
		
		UserRole userRole=null
		println"user inside service"+user
		userRole = UserRole.findByHealpalUser(user)
	}
	
	String getAuthority(HealpalUser user){
		try{
			String authority
			if(user != null){
				authority  = UserRole.findByHealpalUserAndIsActive(user ,(short)1)?.role?.authority
			}
			return authority
		}catch(Exception ex){
			ex.printStackTrace()
		}
	}
	
//	def isLocked(){
//		try{
//		}catch(Exception ex){
//			
//		}
//	}
//	
//	
//	def isEnabled(){
//		try{
//		}catch(Exception ex){
//			
//		}
//	}
//	
//	def isPasswordExpired(){
//		try{
//		}catch(Exception ex){
//			
//		}
//	}
}
