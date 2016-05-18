package com.healpal.care

import grails.transaction.Transactional

@Transactional
class MedicalConditionService {

	def serviceMethod() {
	}
	/**
	 * @param params
	 * @return
	 * @throws Exception
	 */
	def viewAll(params)throws Exception {
		try{
			return MedicalCondition.createCriteria().list(params){
				if(params.sort == null && params.order == null){
					order('rowCreated','desc')
				}
				if(params.searchValue != null && params.searchValue != "") ilike("medicalConditionType", "%"+params.searchValue+"%")
			}
		}catch(NullPointerException  | ArrayIndexOutOfBoundsException exception){
			throw exception
		}
	}

	/**
	 * @param params
	 * @return
	 * @throws Exception
	 */
	def saveMedicalCondition(params)throws Exception {
		def medicalConditionType
		println "inside save;;;;;;;;;;;;"
		try {
			def medicalCondition=params?.medicalCondition
			println "medicalCondition"+medicalCondition 
			
			if(medicalCondition !=null && medicalCondition!=""){
				MedicalCondition medicalConditionObj= new MedicalCondition();
				medicalConditionObj.medicalConditionType=medicalCondition;
				medicalConditionObj.rowCreated=new Date();
				medicalConditionObj.isActive=(short)1;
				medicalConditionType=medicalConditionObj.save(flush:true);
			}
		}
		catch(Exception exception) {
			throw exception
		}
		return medicalConditionType
	}


	/**
	 * @param params
	 * @return
	 * @throws Exception
	 */
	def updateMedicalCondition(params)throws Exception {
		def update
		MedicalCondition medicalCondition=new MedicalCondition();
		try {
			if(params !=null && params.medicalConditionId !=null && !params.medicalConditionId.isEmpty() &&
				params.medicalConditionType !=null && !params.medicalConditionType.isEmpty()){
					medicalCondition = MedicalCondition.get(params.medicalConditionId.toLong())
					medicalCondition.withTransaction {status->
						medicalCondition.medicalConditionType=params.medicalConditionType
						medicalCondition.isActive = params.status.equals("active")?(short)1:(short)0
						medicalCondition.rowAltered = new Date()
						medicalCondition.save(flush:true)
						if(!medicalCondition.validate()){
							status.setRollbackOnly()
						}
					}
		}
		}
		catch(Exception exception) {
			medicalCondition= null
		}
		return medicalCondition
	}

	/**
	 * @param params
	 * @return
	 * @throws Exception
	 */
	def deleteMedicalCondition(params)throws Exception {
		def deleteMedicalConditionreturn
		try{
			def deleteStageId=params?.medicalConditionId;
			if(deleteStageId!=null && deleteStageId!="") {
				MedicalCondition deleteMedicalCondition=MedicalCondition.get(deleteStageId);
				deleteMedicalCondition.isActive=(short)0;
				deleteMedicalConditionreturn=deleteMedicalCondition.save(flush:true);
			}
		}
		catch(Exception exception) {
			throw exception
		}
		return deleteMedicalConditionreturn
	}
	def getCount(params)throws Exception {
		try{
			return MedicalCondition.createCriteria().list(){
				if(params.searchValue != null && params.searchValue != "") ilike("medicalConditionType", "%"+params.searchValue+"%")
			}?.size()
		}catch(NullPointerException  | ArrayIndexOutOfBoundsException exception){
			throw exception
		}
	}

}
