/*
 * Author    : Manikandan
 * Project   : Healpal
 * Date      : 10/05/2015
 * Description : Service for the User Controller
 *
 * #   Name       Version   Modified-Date      Description
 * -------------------------------------------------------------------------------------
 * 1   Manikandan    1.0    10/05/2015         Initial Creation
 *
 */
package com.healpal.care

import java.util.Date;

import grails.transaction.Transactional

@Transactional
class RoleService {

    def serviceMethod() {

    }
	
	Role save(params ,Role role ,String action){
		try{
			role . authority = params.authority?.trim()
			role . isActive = params.isActive?(params.isActive?.toString()?.toInteger()==1)?1:0:1
			if(action.equalsIgnoreCase("create")){
				role . rowCreated = new Date() }else{
				role . rowAltered = new Date()
			}
			role.save(flush:true)
			return role
		}catch(Exception exception){
			throw exception
		}
	}
	
	int delete(params){
		try{
			return Role.executeUpdate("update Role r set r.isActive=0 where r.id=?",[params.id.toLong()])
		}catch(Exception exception){
			throw exception
		}
	}
	
	
	def getList(params){
		try{
			return Role.createCriteria().list(params){
				if(params.sort == null && params.order == null){
					order('rowCreated','desc')
				}
				if(params.searchValue != null && params.searchValue != ""){
					ilike('authority',"%"+params.searchValue+"%")
				}
			} 
		}catch(Exception exception){
			throw exception
		}
	} 
	
	
	def getRoleList(String action){
		return Role.createCriteria().list{
			eq('isActive' ,(short)1)
			if(action.equalsIgnoreCase("create")){
				not{
					ilike('authority',Role.patient)
				}
			}
		}
	}
	def getCount(params){
		try{
			return Role.createCriteria().list(params){
				if(params.searchValue != null && params.searchValue  != ""){
					ilike('authority',"%"+params.searchValue+"%")
				}
			}?.size()
		}catch(Exception exception){
			throw exception
		}
	}
}
