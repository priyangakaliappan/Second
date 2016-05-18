/*
 * Author    : Manikandan
 * Project   : Healpal
 * Date      : 10/01/2016
 * Description : User Authentication and Authorization
 *
 * #   Name       Version   Modified-Date      Description
 * -------------------------------------------------------------------------------------
 * 1   Manikandan    1.0    10/02/2016        Initial Creation
 *
 */
package com.healpal.care

import grails.transaction.Transactional
import java.text.SimpleDateFormat
import java.util.Date;

//@Transactional
class CancerContentService {

    def serviceMethod() {

    }
	
	
	def save(params ,session){
		try{
			//if(session != null && session.user != null){
				println "----------->>>>>> params.type" + params.type
				HealpalUser user = session.user
				
				//*** Checking is ueser already given rate for the day
//				CancerContentRate check = CancerContentRate.find("from CancerContentRate c where c.healpalUser=:user and patient=:patient and to_char(c.rowCreated,'yyyy-MM-dd')=:date and c.cancerContentSection=:section and c.cancerContentPage=:page" 
//					,[user:user ,patient:Patient.findByPerson(user?.person) , date: new SimpleDateFormat("yyyy-MM-dd").format(new Date()) ,section:params.section ,page:params.page])
				
				// not check user and patient
				CancerContentRate check = CancerContentRate.find("from CancerContentRate c where to_char(c.rowCreated,'yyyy-MM-dd')=:date and c.cancerContentSection=:section and c.cancerContentPage=:page"
					,[date: new SimpleDateFormat("yyyy-MM-dd").format(new Date()) ,section:params.section ,page:params.page])
				println "CancerContentService . save . is Patient already given rate :" + check
				
				CancerContentRate rate = new CancerContentRate()
				if(check != null){
					rate = check
				}
				
				rate . cancerContentSection = params.section
				rate . cancerContentPage = params.page
				rate . cancerType = CancerContentRate.cancerTypes
				
				if(params.type.equalsIgnoreCase(CancerContentRate.satisfactory)){	
					rate . satisfactoryCount = check != null ?(check.satisfactoryCount>0?check.satisfactoryCount+1:1):1 
				}
				
				if(params.type.equalsIgnoreCase(CancerContentRate.perfect)){
				rate . perfectCount = check != null ?(check.perfectCount>0?check.perfectCount+1:1):1 }
				
				if(params.type.equalsIgnoreCase(CancerContentRate.notClear)){
				rate . notClearCount = check != null ? (check.notClearCount>0?check.notClearCount+1:1):1}
				
				if(params.type.equalsIgnoreCase(CancerContentRate.wanted)){
				rate . notWhatIWantedCount = check != null ?(check.notWhatIWantedCount>0?check.notWhatIWantedCount+1:1):1}
				
				rate . rowCreated = new Date()
				//Date rowAltered
//				rate . patient = Patient.findByPerson(user?.person)
//				rate . healpalUser = user
				rate . save()
				if(!rate.validate()){
					rate . errors.each {
						println it
					}
				}
				return rate
			//}
		}catch(Exception exception){
			throw exception
		}
	}
	
	
	
	def saveComment(session ,params){
		try{
			CancerContentComment com = new CancerContentComment()
			if(session != null && session.user != null){
				
				HealpalUser user = session.user
				com.contentSection = params.section
				com.contentPage = params.page
				com.cancerType = CancerContentRate.cancerTypes
				com.comment = params.message
				com.rowCreated = new Date()
				//com.rowAltered
				com.patient = Patient.findByPerson(user?.person)
				com.healpalUser = user
				com.save(flush:true)
				
					if(!com.validate()){
						com . errors.each {
							println it
						}
					}
					
			}else{
			//do
			}
			return com
		}catch(Exception exception){
		
		}
	}
	
	
	def commentList(session ,String section ,String page){
		try{
			def list = null
			if(session != null && session.user != null){
				HealpalUser user = session.user
				list = CancerContentComment.createCriteria().list(){
					eq('healpalUser' ,user)
					eq('patient' ,Patient.findByPerson(user?.person))
					eq('contentSection' ,section)
					eq('contentPage' ,page)
					eq('cancerType' ,CancerContentRate.cancerTypes)
					order('rowCreated','desc')
				} 
			}else{
				//do nothing	
			}
			return list
		}catch(Exception exception){
			throw exception
		}
	}
	
	
	def getList(){
		try{
			
			
			
		}catch(Exception exception){
			throw exception
		}
	}
	
}
