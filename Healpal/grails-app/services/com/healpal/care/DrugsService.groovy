package com.healpal.care

import grails.transaction.Transactional

@Transactional
class DrugsService {

	def serviceMethod() {
	}
	/**
	 * view all drugs
	 * @return
	 */
	def viewAll(params) {
		def drugs
		try{
			drugs = Drugs.createCriteria().list(params) {
				if(params.sort == null && params.order == null){
					order('rowCreated','desc')
				}
				if(params.searchValue != null && params.searchValue != "") ilike("drugName", "%"+params.searchValue+"%")
			}
		}catch(Exception exception) {
			exception.printStackTrace();
		}
		return drugs
	}
	/**
	 * save drug details
	 * @param drug
	 * @return
	 */
	Drugs save(params) {
		Drugs drugs = new Drugs()
		try {
			drugs.withTransaction {status->
				if(params !=null && params.drug !=null && !params.drug.isEmpty()){
					drugs.drugName = params.drug
					drugs.isActive = (short)1
					drugs.rowCreated = new Date()
					drugs.save()
					if(!drugs.validate()){
						status.setRollbackOnly()
					}
				}
			}
		}catch(Exception exception) {
			drugs = null
		}
		return drugs
	}
	/**
	 * Get drug details
	 * @param drugId
	 * @return
	 */
	Drugs getDetail(params) {
		Drugs drugs = new Drugs()
		try{
			if(params!=null && params.drugId !=null && !params.drugId.isEmpty()){
				drugs = Drugs.get(params.drugId.toLong())
			}
		}catch(Exception e) {
			drugs = null
		}
		return drugs
	}
	/**
	 * Update drug
	 * @param drugId
	 * @return
	 */
	Drugs update(params) {
		Drugs drugs = new Drugs()
		try{
			if(params !=null && params.drugId !=null && !params.drugId.isEmpty() &&
			params.drug !=null && !params.drug.isEmpty() && params.status != null && !params.status.isEmpty()) {
				drugs = Drugs.get(params.drugId.toLong())
				drugs.withTransaction {status->
					drugs.drugName = params.drug
					drugs.isActive = params.status.equals("active")?(short)1:(short)0
					drugs.rowAltered = new Date()
					drugs.save(flush:true)
					if(!drugs.validate()) {
						status.setRollbackOnly()
					}
				}
			}
		}catch(Exception e){
			drugs = null
		}
		return drugs
	}
	/**
	 *Delete drug by changing the state of isActive
	 * @param drugId
	 * @return
	 */
	def deleteDrugs(params) {
		boolean deleteDrug = true
		try{
			if(params !=null && params.drugId !=null && !params.drugId.isEmpty()) {
				def delete = Drugs.executeUpdate("update Drugs set isActive=0 where id="+params.drugId.toLong())
				if(delete) {
					//do nothing
				}else{
					deleteDrug = false
				}
			}
		}catch(Exception e) {
			deleteDrug = false
		}
		return deleteDrug
	}
	def getCount(params) {
		try{
			return Drugs.createCriteria().list() {
				if(params.searchValue != null && params.searchValue != "") ilike("drugName", "%"+params.searchValue+"%")
			}?.size()
		}catch(Exception exception) {
			exception.printStackTrace();
		}
	}
}
