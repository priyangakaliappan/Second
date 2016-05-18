package com.healpal.care

import grails.transaction.Transactional

@Transactional
class SurgicalProcedureService {

	def serviceMethod() {
	}
	/**
	 *View all surgical procedure type
	 * @return
	 */
	def viewAll(params) {
		def surgicalProcedureType
		try{
			surgicalProcedureType = SurgicalProcedure.createCriteria().list(params) {
				if(params.sort == null && params.order == null){
					order('rowCreated','desc')
				}
				if(params.searchValue != null && params.searchValue != "") ilike("surgicalProcedureType", "%"+params.searchValue+"%")
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return surgicalProcedureType
	}
	/**
	 * save new surgical procedure type
	 * @param surgicalProcedure
	 * @return
	 */
	SurgicalProcedure save(params) {
		SurgicalProcedure surgicalProcedure = new SurgicalProcedure()
		try{
			surgicalProcedure.withTransaction {status->
				if(params !=null && params.surgicalProcedure !=null && !params.surgicalProcedure.isEmpty()){
					surgicalProcedure.surgicalProcedureType = params.surgicalProcedure
					surgicalProcedure.isActive = (short)1
					surgicalProcedure.rowCreated = new Date()
					surgicalProcedure.save()
					if(!surgicalProcedure.validate()){
						status.setRollbackOnly()
					}
				}
			}
		}catch(Exception e){
			surgicalProcedure = null
		}
		return surgicalProcedure
	}
	/**
	 * get existing surgical procedure type
	 * @param surgicalProcedureTypeId
	 * @return
	 */
	SurgicalProcedure getDetail(params) {
		SurgicalProcedure surgicalProcedure = new SurgicalProcedure()
		try{
			if(params !=null && params.surgicalProcedureTypeId !=null && !params.surgicalProcedureTypeId.isEmpty()){
				surgicalProcedure = SurgicalProcedure.get(params.surgicalProcedureTypeId.toLong())
			}
		}catch(Exception e){
			surgicalProcedure = null
		}
		return surgicalProcedure
	}
	/**
	 * update existing surgical procedure type
	 * @param surgicalProcedureTypeId
	 * @param surgicalProcedure
	 * @return
	 */
	SurgicalProcedure update(params) {
		SurgicalProcedure surgicalProcedure = new SurgicalProcedure()
		try{
			if(params !=null && params.surgicalProcedureTypeId !=null && !params.surgicalProcedureTypeId.isEmpty() &&
			params.surgicalProcedure !=null && !params.surgicalProcedure.isEmpty() && params.status !=null && !params.status.isEmpty()){
				surgicalProcedure = SurgicalProcedure.get(params.surgicalProcedureTypeId.toLong())
				surgicalProcedure.withTransaction {status->
					surgicalProcedure.surgicalProcedureType = params.surgicalProcedure
					surgicalProcedure.isActive = params.status.equals("active")?(short)1:(short)0
					surgicalProcedure.rowAltered = new Date()
					surgicalProcedure.save(flush:true)
					if(!surgicalProcedure.validate()){
						status.setRollbackOnly()
					}
				}
			}
		}catch(Exception e){
			surgicalProcedure = null
		}
		return surgicalProcedure
	}
	/**
	 * delete existing surgical procedure type
	 * @param surgicalProcedureTypeId
	 * @return
	 */
	def deleteSurgicalProcedure(params) {
		boolean deleteSurgicalProcedure = true
		try{
			if(params !=null && params.surgicalProcedureTypeId !=null && !params.surgicalProcedureTypeId.isEmpty()){
				deleteSurgicalProcedure = SurgicalProcedure.executeUpdate("update SurgicalProcedure set isActive=0 where id="+params.surgicalProcedureTypeId.toLong())
				if(delete){
					// do nothing
				}else{
					deleteSurgicalProcedure = false
				}
			}
		}catch(Exception e) {
			deleteSurgicalProcedure = false
		}
		return deleteSurgicalProcedure
	}
	def getCount(params) {
		try{
			return SurgicalProcedure.createCriteria().list() {
				if(params.searchValue != null && params.searchValue != "") ilike("surgicalProcedureType", "%"+params.searchValue+"%")
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
