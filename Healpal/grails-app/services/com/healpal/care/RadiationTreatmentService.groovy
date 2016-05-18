package com.healpal.care

import grails.transaction.Transactional

@Transactional
class RadiationTreatmentService {

	def serviceMethod() {
	}

	/**
	 * @param params
	 * @return
	 * @throws Exception
	 */
	def viewAll(params)throws Exception {
		try {
			def radiationTreatmentList = RadiationTreatment.createCriteria().list { order("rowCreated","desc") };
		}
		catch(Exception exception) {
			throw exception
		}
	}

	/**
	 * @param params
	 * @return
	 * @throws Exception
	 */
	def saveRadiationTreatment(params)throws Exception {
		def radiationTreatment
		try {
			def radiationTreatmentType=params?.radiationTreatmentType
			if(radiationTreatmentType!=null && radiationTreatmentType!="" ){
				RadiationTreatment radiationTreatmentTypeObj= new RadiationTreatment();
				radiationTreatmentTypeObj.radiationTreatmentType=radiationTreatmentType;
				radiationTreatmentTypeObj.rowCreated=new Date();
				radiationTreatmentTypeObj.isActive=(short)1;
				radiationTreatment=radiationTreatmentTypeObj.save();
				if(!radiationTreatmentTypeObj.validate()) {
					radiationTreatmentTypeObj.errors.each{println it}
				}
			}
		}
		catch(Exception exception) {
			throw exception
		}
		return radiationTreatment
	}

	/**
	 * @param params
	 * @return
	 * @throws Exception
	 */
	def updateRadiationTreatment(params)throws Exception {
		def updateradiationTreatment
		try {
			def updatedId=params?.radiationTreatmentTypeId;
			if(updatedId!=null && updatedId!="") {
				println "updatedId;;;;;;;;;;;;;;"+updatedId
				RadiationTreatment radiationTreatment=RadiationTreatment.get(updatedId);
				radiationTreatment.radiationTreatmentType=params.radiationTreatmentType
				radiationTreatment.rowAltered=new Date();
				updateradiationTreatment=radiationTreatment.save(flush:true);
			}
		}
		catch(Exception exception) {
			throw exception
		}
		return updateradiationTreatment
	}


	/**
	 * @param params
	 * @return
	 */
	def deleteRadiationTreatment(params) {
		def deleteRadiationTreatmentType
		try {
			def deleteStageId=params?.radiationTreatmentTypeId;
			if(deleteStageId!=null && deleteStageId!=" ") {
				RadiationTreatment deleteRadiationTreatment=RadiationTreatment.get(deleteStageId);
				deleteRadiationTreatment.isActive=(short)0;
				deleteRadiationTreatmentType=deleteRadiationTreatment.save(flush:true);
			}
		}
		catch(Exception exception) {
			throw exception
		}
		return  deleteRadiationTreatmentType
	}
}
