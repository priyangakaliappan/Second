/*
 * Author    : Manikandan
 * Project   : Healpal
 * Date      : 10/19/2015
 * Description : Service for the Audit Controller
 *
 * #   Name       Version   Modified-Date      Description
 * -------------------------------------------------------------------------------------
 * 1   Manikandan    1.0               Initial Creation
 *
 */

package com.healpal.care

import java.util.Date;

import com.sun.org.apache.xpath.internal.objects.EqualComparator;

import grails.transaction.Transactional

@Transactional
class AuditEventService {

    def serviceMethod() {

    }
	
	def save(String auditTypeName ,String whoAmI ,session){
		try{
			if(session.user != null && auditTypeName != null && !auditTypeName.isEmpty()){
				HealpalUser user = session.user
				AuditEvent audit = new AuditEvent()
				audit . auditEventType = this.auditTypeSave(auditTypeName)
				if(whoAmI?.equalsIgnoreCase(Role.patient)){ 
					audit . patient = Patient.get(user?.person?.id)
				}
				audit . healpalUser = user
				println  audit . healpalUser
				audit . auditEventTime = new Date()
				audit . isActive = (short)1
				println audit . isActive
				audit . rowCreated = new Date()
				audit . rowCreated
				audit . save(flush:true)
//				if(!audit.validate()){
//					audit.errors.each {
//						println it
//					}
//				}
			}else{
				//do nothing
			}
		}catch(Exception exception){
			throw exception
		}
	}
	
	
	def userSave(String auditTypeName ,String whoAmI ,user){
		try{
			println "inside userSave"
			if(user != null && auditTypeName != null && !auditTypeName.isEmpty()){
				HealpalUser user1 = user
				AuditEvent audit = new AuditEvent()
				audit . auditEventType = this.auditTypeSave(auditTypeName)
				if(whoAmI?.equalsIgnoreCase(Role.patient)){
					audit . patient = Patient.get(user?.person?.id)
				}
				audit . healpalUser = user1
				println  audit . healpalUser
				audit . auditEventTime = new Date()
				audit . isActive = (short)1
				println audit . isActive
				audit . rowCreated = new Date()
				audit . rowCreated
				audit . save(flush:true)
//				if(!audit.validate()){
//					audit.errors.each {
//						println it
//					}
//				}
			}else{
				//do nothing
			}
		}catch(Exception exception){
			throw exception
		}
	}
	
	
	def auditTypeSave(String auditTypeName){
		try{
			AuditEventType type = new AuditEventType()
			AuditEventType isExist = AuditEventType.findByAuditEventTypeNameAndIsActive(auditTypeName ,(short)1) // Checking is Type is already have
			if(isExist){ 
				type = isExist 
			}else{
					println "AuditEventService . auditTypeSave ." + auditTypeName +" not available"
					/*AuditEventType type1 = new AuditEventType()
					type1 . auditEventTypeName = auditTypeName
					type1 . isActive = (short)1 
					type1 . rowCreated = new Date()
					type1 . save(flush : true)
					if(!type1.validate()){
						type1.errors.each{
							println it
						} 	
					}else{
						type = type1
					}*/	
			}	
			return type
		}catch(Exception exception){
			throw exception
		}
	}
		
	
	
	def getList(params){
		try{
			return AuditEvent.createCriteria().list(params){
				if(params.sort == null && params.order == null){
					order('rowCreated','desc')
				}
				if(params.searchValue != null && params.searchValue != ""){
					or{
						and{ilike('auditEventTypeName',"%"+params.searchValue+"%")}
						and{
							healpalUser{
							ilike('userName',"%"+params.searchValue+"%")}}
					}
				}
			} 
		}catch(Exception exception){
			throw exception
		}
	} 
	def getCount(params){
		try{
			return AuditEvent.createCriteria().list(){
				if(params.searchValue != null && params.searchValue != ""){
					or{
						and{ilike('auditEventTypeName',"%"+params.searchValue+"%")}
						and{
							healpalUser{
							ilike('userName',"%"+params.searchValue+"%")}}
					}
				}
			}?.size()
		}catch(Exception exception){
			throw exception
		}
	}
}
