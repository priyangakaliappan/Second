package com.healpal.care

import grails.transaction.Transactional

@Transactional
class HormoneTherapyService {

	def serviceMethod() {
	}
	/**
	 *view all hormone therapy
	 * @return
	 */
	def viewAll(params) {
		def hormoneTherapy
		try{
			hormoneTherapy = HormoneTherapy.createCriteria().list(params) {
				if(params.sort == null && params.order == null){
					order('rowCreated','desc')
				}
				if(params.searchValue != null && params.searchValue != "") ilike("hormoneTherapyName", "%"+params.searchValue+"%")
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return hormoneTherapy
	}
	/**
	 *save hormone therapy
	 * @param hormoneTherapyName
	 * @return
	 */
	HormoneTherapy save(params) {
		HormoneTherapy hormoneTherapy = new HormoneTherapy()
		try{
			if(params !=null && params.hormoneTherapyName !=null && !params.hormoneTherapyName.isEmpty()){
				hormoneTherapy.withTransaction {status->
					hormoneTherapy.hormoneTherapyName = params.hormoneTherapyName
					hormoneTherapy.isActive = (short)1
					hormoneTherapy.rowCreated = new Date()
					hormoneTherapy.save(flush:true)
					if(!hormoneTherapy.validate()){
						status.setRollbackOnly()
					}
				}
			}
		}catch(Exception e){
			hormoneTherapy = null
		}

		return hormoneTherapy
	}
	/**
	 * Get details of Hormone Therapy by passing their id's
	 * @param hormoneId
	 * @return
	 */
	HormoneTherapy getDetail(params) {
		HormoneTherapy hormoneTherapy = new HormoneTherapy()
		try{
			if(params !=null && params.hormoneId !=null && !params.hormoneId.isEmpty()){
				hormoneTherapy = HormoneTherapy.get(params.hormoneId.toLong())
			}
		}catch(Exception e){
			hormoneTherapy = null
		}
		return hormoneTherapy
	}
	/**
	 *Update Hormone Therapy Name
	 * @param hormoneTherapyId
	 * @param hormoneTherapyName
	 * @return
	 */
	HormoneTherapy update(params) {
		HormoneTherapy hormoneTherapy = new HormoneTherapy()
		try{
			if(params != null && params.hormoneId !=null && !params.hormoneId.isEmpty() &&
			params.hormoneTherapyName !=null && !params.hormoneTherapyName.isEmpty() && params.status != null && !params.status.isEmpty()){
				hormoneTherapy = HormoneTherapy.get(params.hormoneId)
				
				hormoneTherapy.withTransaction {status->
					hormoneTherapy.hormoneTherapyName = params.hormoneTherapyName
					hormoneTherapy.isActive = params.status.equals("active")?(short)1:(short)0
					hormoneTherapy.rowAltered = new Date()
					hormoneTherapy.save(flush:true)
					if(!hormoneTherapy.validate()){
						status.setRollbackOnly()
					}
				}
			}
		}catch(Exception e){
			hormoneTherapy = null
		}
		return hormoneTherapy
	}
	/**
	 *Delete Hormone Therapy
	 * @param hormoneId
	 * @return
	 */
	def deleteHormoneTherapy(params) {
		def deleteHormone = true
		try{
			if(params !=null && params.hormoneId !=null && !params.hormoneId.isEmpty()){
				deleteHormone = HormoneTherapy.executeUpdate("update HormoneTherapy set isActive=0 where id="+params.hormoneId.toLong())
				if(deleteHormone){
					// do nothing
				}else {
					deleteHormone = false
				}
			}
		}catch(Exception e) {
			deleteHormone = false
		}
		return deleteHormone
	}
	def getCount(params) {
		try{
			HormoneTherapy.createCriteria().list(params) {
				if(params.searchValue != null && params.searchValue != "") ilike("hormoneTherapyName", "%"+params.searchValue+"%")
			}?.size()
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}