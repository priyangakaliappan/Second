package com.healpal.care


import com.healpal.date.DateConvention
import grails.transaction.Transactional
import java.text.DateFormat
import java.text.SimpleDateFormat

@Transactional
class UserDetailsService {

    def serviceMethod() {

    }
	
	
	def getList(params){
		try{
			
			 def dateList=params.searchValue
			if(dateList !=null){
			Date date = new SimpleDateFormat("MM/dd/yyyy").parse(dateList);
			String dateString2 = new SimpleDateFormat("yyyy-MM-dd").format(date);
			
			def List=HealpalUser.executeQuery("select h from HealpalUser h where h.enabled = true and to_char(h.rowCreated,'yyyy-MM-dd') = '"+dateString2 +"' order by rowCreated desc")
			
			return List
			}else{
			def go= HealpalUser.createCriteria().list(params){
				if(params.sort == null && params.order == null){
					order('rowCreated','desc')
					eq('enabled',true)
				}
			}
			return go
			
			}
		}catch(Exception exception){
			throw exception
		}
		
	}
	
	def getSearchList(params){
		try{
			def dateList=params.searchValue
			Date date = new SimpleDateFormat("MM/dd/yyyy").parse(dateList);
			String dateString2 = new SimpleDateFormat("yyyy-MM-dd").format(date);
			
			def List=HealpalUser.executeQuery("select h from HealpalUser h where h.enabled = true and to_char(h.rowCreated,'yyyy-MM-dd') = '"+dateString2 +"' order by rowCreated desc")
			
			return List
		}catch(Exception exception){
			throw exception
		}
	
		
	}
	
	
	def cancerType(params){
		try{
			def cancerTypes=params.cancerId
			
			if(cancerTypes !=null){
				ArrayList list1 = new ArrayList();
				
				def diag=Diagnosis.findByDiagnosisName(cancerTypes)
				
				def patientDiagnosis = PatientDiagnosis.createCriteria().list{
					eq('diagnosis',diag)
				}
				if(patientDiagnosis){
					for(int i=0;i<patientDiagnosis.size;i++){
						def diagnosis = patientDiagnosis.get(i);
						def person = diagnosis?.patient?.person;
						list1.add(person);
					}
				}
		
				def healpalUser = HealpalUser.createCriteria().list(params){
					'in'('person',list1)
				}
				return healpalUser
				
			}else{
			
			def cancerList=HealpalUser.createCriteria().list(params){
				if(params.sort == null && params.order == null){
					order('rowCreated','desc')
					eq('enabled',true)
				
				}
			}
			println"cancerList:::::::::::"+cancerList
			return cancerList
			}
			/*return HealpalUser.createCriteria().list(params){
				if(params.sort == null && params.order == null){
					order('rowCreated','desc')
					eq('enabled',true)
				}
			}*/
		}catch(Exception exception){
			throw exception
		}
		
		
	}
	
	
	def getCancerSearchList(params){
		try{
			
			
		def cancerTypes=params.cancerId
		ArrayList list1 = new ArrayList();
		
		def diag=Diagnosis.findByDiagnosisName(cancerTypes)
		
		def patientDiagnosis = PatientDiagnosis.createCriteria().list{
			eq('diagnosis',diag)
		}
		if(patientDiagnosis){
			for(int i=0;i<patientDiagnosis.size;i++){
				def diagnosis = patientDiagnosis.get(i);
				def person = diagnosis?.patient?.person;
				list1.add(person);
			}
		}
		def healpalUser = HealpalUser.createCriteria().list(params){
			'in'('person',list1)
		}
		
		return healpalUser
		}catch(Exception e){
		throw e
	    }
		
	}
	
	
	
	def getCancerPatient(def personId){
		def cancers;
		try{
			if(personId!=null && !personId.equals("")){
				def patient = Patient.findByPerson(Person.get(personId))
				def diagnosisName=PatientDiagnosis.findByPatient(patient)?.diagnosis?.diagnosisName
				cancers=diagnosisName
			}else{
			  //do nothing
			}
			
		}catch(Exception exception){
		  exception.printStackTrace();
		}
		return cancers;
	}
	
	
	
	
	
	
}
