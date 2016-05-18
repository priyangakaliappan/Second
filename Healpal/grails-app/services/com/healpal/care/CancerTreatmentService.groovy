package com.healpal.care

import grails.transaction.Transactional
import java.text.SimpleDateFormat
import java.util.Date;

@Transactional
class CancerTreatmentService {

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
				CancerTreatmentRate check = CancerTreatmentRate.find("from CancerTreatmentRate c where to_char(c.rowCreated,'yyyy-MM-dd')=:date and c.cancerType=:title"
					,[date: new SimpleDateFormat("yyyy-MM-dd").format(new Date()) ,title:params.title ])
				println "CancerContentService . save . is Patient already given rate :" + check
				
				CancerTreatmentRate rate = new CancerTreatmentRate()
				if(check != null){
					rate = check
				}
				
				rate . cancerType = params.title
			
				
				if(params.type.equalsIgnoreCase(CancerTreatmentRate.satisfactory)){
					rate . satisfactoryCount = check != null ?(check.satisfactoryCount>0?check.satisfactoryCount+1:1):1
				}
				
				if(params.type.equalsIgnoreCase(CancerTreatmentRate.perfect)){
				rate . perfectCount = check != null ?(check.perfectCount>0?check.perfectCount+1:1):1 }
				
				if(params.type.equalsIgnoreCase(CancerTreatmentRate.notClear)){
				rate . notClearCount = check != null ? (check.notClearCount>0?check.notClearCount+1:1):1}
				
				if(params.type.equalsIgnoreCase(CancerTreatmentRate.wanted)){
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
	
}
