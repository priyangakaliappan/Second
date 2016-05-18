package com.healpal.care


import grails.transaction.Transactional
import com.healpal.care.Diagnosis
import com.healpal.care.TempQuestionOption

@Transactional
class StageOfCancerService {

    def serviceMethod() {

    }
	
	def viewAll(params)throws Exception
	{
		try
		{
			println "inside view All"
			
			def tempQuestion=TempQuestionOption.createCriteria().list() {
				eq("questionName","Stage of cancer")
		}
			
			println "tempQuestion;;;;;;;;;;;;;;;;"+tempQuestion
			return tempQuestion
		}
		catch(Exception exception){
			throw exception
			
		}
		
	}
	
	def getBreastCancerList(params){
		def test
		try{
			def value = "Breast"
		test = Diagnosis.createCriteria().list(){
			eq("diagnosisName",value)
		}
		 for(int j=0;j<test.size();j++){
   def diag =test.get(j);
   def BreastId=diag.id
  test = PatientDiagnosis.createCriteria().list(params){
   eq("diagnosis",Diagnosis.get(BreastId))
   if(params.searchValue != null && params.searchValue != ""){
	   or{
		   //and{ ilike('userName',"%"+params.searchValue+"%")}
		   and{ patient {person{like('fullName',"%"+params.searchValue+"%")}
		   }}
		   and{ patient {person{like('emailAddress',"%"+params.searchValue+"%")}
		   }}
	   }
   }
   }
  println "test;;;;;;;;;;;;;;;;;"+test?.patient?.person?.fullName
  return test
		}
		}catch(Exception exception){
			throw exception
		}
		
	}
	
	def getCount(params){
		try{
			return PatientDiagnosis.createCriteria().list(){
				if(params.searchValue != null && params.searchValue != ""){
					 or{
		   //and{ ilike('userName',"%"+params.searchValue+"%")}
		   and{ patient {person{like('fullName',"%"+params.searchValue+"%")}
		   }}
		   and{ patient {person{like('emailAddress',"%"+params.searchValue+"%")}
		   }}
	   }
						
				}
			}?.size()
		}catch(Exception exception){
			throw exception
		}
	}
}
