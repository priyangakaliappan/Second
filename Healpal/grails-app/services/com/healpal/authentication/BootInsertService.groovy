/*
 * Author    : Manikandan
 * Project   : Healpal
 * Date      : 11/02/2015
 * Description : Inserting record while booting
 *
 * #   Name       Version   Modified-Date      Description
 * -------------------------------------------------------------------------------------
 * 1   Manikandan    1.0    11/03/2015        Initial Creation
 *
 */
package com.healpal.authentication

import java.sql.Savepoint;
import java.util.Date;

import com.healpal.care.HealpalUser;
import com.healpal.care.Person
import com.healpal.care.Role;
import com.healpal.care.UserRole;
import com.healpal.encryptdecrypt.BCrypt;

import grails.transaction.Transactional

@Transactional
class BootInsertService {

    def serviceMethod() {

    }
	
	def bootSave(){
		println "boot save called" 
		if(Role.list()==null || Role.list()?.size() <= 0){ 
			for(int i=0; i<2; i++){
				Role role = new Role()
					if(i == 0){
						role . authority = "Patient"
					}
					if(i == 1){
						role . authority = "Admin"
					}
					role . isActive = 1
					role . rowCreated = new Date()
				role . save(flush : true)
			}
		}
	}
	
	
	def bootUserSave(){
		if(HealpalUser.list() == null || HealpalUser.list()?.size() <= 0){
			
			Person person = new Person()
			person . firstName = "Admin"
			person . lastName = "Admin"
			person . emailAddress = "admin@gmail.com"
			person . isActive = 1
			person . rowCreated = new Date()
			person.save()
			
			if(person.validate()){
				HealpalUser user = new HealpalUser()
				user . userName = "admin@gmail.com"
				
				String pwd = "12345678a"
				
				byte[] password = pwd?.trim().getBytes()
				String encryptPassword = BCrypt.encode_base64(password, pwd?.length())
				user . password = encryptPassword//params.password
				
				user . enabled = true
				user . accountLocked = false
				user . accountExpired = false
				user . passwordExpired = false
				user . isActive = 1
				user . rowCreated = new Date()
				user . person = person
				user.save(flush:true)
				
				if(user.validate()){
					UserRole urole = new UserRole()
					urole . healpalUser = user
					urole . role = Role.findByAuthority("Admin")
					urole . isActive = 1
					urole . rowCreated = new Date()
					urole . save(flush:true)
				}
				
			}
			
		}
	}
	
	
	
	
}
