package com.healpal.care

import grails.transaction.Transactional

@Transactional
class ChemotherapyDrugsService {

	def serviceMethod() {
	}
	/**
	 *view all Chemotherapy Drugs
	 * @return
	 */
	def viewAll(params) {
		def chemotherapyDrugs
		try {
			chemotherapyDrugs = ChemotherapyDrugs.createCriteria().list(params) {
				if(params.sort == null && params.order == null){
					order('rowCreated','desc')
				}
				if(params.searchValue != null && params.searchValue != "") ilike("chemotherapyDrugsType", "%"+params.searchValue+"%")
			}
		}catch(Exception exception) {
			exception.printStackTrace();
		}
		return chemotherapyDrugs
	}
	/**
	 * save Chemotherapy Drugs
	 * @param chemotherapyDrugs
	 * @return
	 */
	ChemotherapyDrugs save(params) {
		ChemotherapyDrugs chemotherapyDrugs = new ChemotherapyDrugs()
		try {
			if(params != null && params.chemotherapyDrugs !=null && !params.chemotherapyDrugs.toString().isEmpty()) {
				chemotherapyDrugs.withTransaction{status->
					chemotherapyDrugs.chemotherapyDrugsType = params.chemotherapyDrugs
					chemotherapyDrugs.isActive = (short)1
					chemotherapyDrugs.rowCreated = new Date()
					chemotherapyDrugs.save()
					if(!chemotherapyDrugs.validate()) {
						status.setRollbackOnly()
					}
				}
			}
		}catch(Exception exception) {
			chemotherapyDrugs = null
		}
		return chemotherapyDrugs
	}
	/**
	 * get each Chemotherapy Drug details
	 * @param chemotherapyDrugsId
	 * @return
	 */
	ChemotherapyDrugs getDetail(params) {
		ChemotherapyDrugs chemotherapyDrugs = new ChemotherapyDrugs()
		try {
			if(params !=null && params.chemotherapyDrugsId !=null &&  !params.chemotherapyDrugsId.isEmpty()) {
				chemotherapyDrugs = ChemotherapyDrugs.get(params.chemotherapyDrugsId.toLong())
			}
		}catch(Exception e) {
			chemotherapyDrugs = null
		}
		return chemotherapyDrugs
	}
	/**
	 * Update Chemotherapy Drugs
	 * @param chemotherapyDrugsId
	 * @return
	 */
	ChemotherapyDrugs update(params) {
		ChemotherapyDrugs chemotherapyDrugs = new ChemotherapyDrugs()
		try{
			chemotherapyDrugs.withTransaction {status->
				if(params !=null && params.chemotherapyDrugsId !=null && !params.chemotherapyDrugsId.isEmpty() &&
				params.chemotherapyDrugs !=null && !params.chemotherapyDrugs.isEmpty() && params.status !=null && !params.status.isEmpty()) {
					chemotherapyDrugs = ChemotherapyDrugs.get(params.chemotherapyDrugsId.toLong())
					if(chemotherapyDrugs) {
						chemotherapyDrugs.chemotherapyDrugsType = params.chemotherapyDrugs
						chemotherapyDrugs.isActive = params.status.equals("active")?(short)1:(short)0
						chemotherapyDrugs.rowAltered = new Date()
						chemotherapyDrugs.save(flush:true)
						if(!chemotherapyDrugs.validate()) {
							status.setRollbackOnly()
						}
					}
				}
			}
		}catch(Exception e){
			chemotherapyDrugs = null
		}
		return chemotherapyDrugs
	}
	/**
	 * delete Chemotherapy Drugs
	 * @param chemotherapyDrugsId
	 * @return
	 */
	def deleteChemotherapyDrugs(params) {
		boolean deleteChemotherapthy = true;
		try{
			if(params!=null && params.chemotherapyDrugsId !=null && !params.chemotherapyDrugsId.isEmpty()) {
				deleteChemotherapthy = ChemotherapyDrugs.executeUpdate("update ChemotherapyDrugs set isActive=0 where id="+params.chemotherapyDrugsId.toLong())
				if(deleteChemotherapthy) {
					// do nothing
				}else{
					deleteChemotherapthy = false
				}
			}else{
				deleteChemotherapthy = false
			}
		}catch(Exception e) {
			deleteChemotherapthy = false
		}
		return deleteChemotherapthy
	}
	def getCount(params) {
		try {
			return ChemotherapyDrugs.createCriteria().list() {
				if(params.searchValue != null && params.searchValue != "") ilike("chemotherapyDrugsType", "%"+params.searchValue+"%")
			}?.size()
		}catch(Exception exception) {
			exception.printStackTrace();
		}
	}
}