package com.healpal.care

import grails.transaction.Transactional

@Transactional
class MetastaticBreastCancerService {

	def serviceMethod() {
	}
	/**
	 *View all metastatic breast cancer
	 * @return
	 */
	def viewAll(params) {
		def metastaticBreastCancer
		try{
			metastaticBreastCancer = MetastaticBreastCancer.createCriteria().list(params) {
				if(params.sort == null && params.order == null){
					order('rowCreated','desc')
				}
				if(params.searchValue != null && params.searchValue != "") ilike("metastaticName", "%"+params.searchValue+"%")
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return metastaticBreastCancer
	}
	/**
	 *save new metastatic breast cancer
	 * @param metastaticName
	 * @return
	 */
	MetastaticBreastCancer save(params) {
		MetastaticBreastCancer metastaticBreastCancer = new MetastaticBreastCancer()
		try{
			if(params !=null && params.metastaticName !=null && !params.metastaticName.isEmpty()){
				metastaticBreastCancer.withTransaction {status->
					metastaticBreastCancer.metastaticName = params.metastaticName
					metastaticBreastCancer.isActive = (short)1
					metastaticBreastCancer.rowCreated = new Date()
					metastaticBreastCancer.save(flush:true)
					if(!metastaticBreastCancer.validate()){
						status.setRollbackOnly()
					}
				}
			}
		}catch(Exception e){
			metastaticBreastCancer = null
		}

		return metastaticBreastCancer
	}
	/**
	 * get details of existing metastatic breast cancer
	 * @param metastaticId
	 * @return
	 */
	MetastaticBreastCancer getDetail(params) {
		MetastaticBreastCancer metastaticBreastCancer = new MetastaticBreastCancer()
		try{
			if(params !=null && params.metastaticId !=null && !params.metastaticId.isEmpty()){
				metastaticBreastCancer = MetastaticBreastCancer.get(params.metastaticId.toLong())
			}
		}catch(Exception e){
			metastaticBreastCancer = null
		}
		return metastaticBreastCancer
	}
	/**
	 *update already existing metastatic breast cancer
	 * @param metastaticBreastCancerId
	 * @param metastaticName
	 * @return
	 */
	MetastaticBreastCancer update(params) {
		MetastaticBreastCancer metastaticBreastCancer = new MetastaticBreastCancer()
		try{
			if(params !=null && params.metastaticId !=null && !params.metastaticId.isEmpty() &&
			params.metastaticName !=null && !params.metastaticName.isEmpty() && params.status != null && !params.status.isEmpty()){
				metastaticBreastCancer = MetastaticBreastCancer.get(params.metastaticId)
				metastaticBreastCancer.withTransaction {status->
					metastaticBreastCancer.metastaticName = params.metastaticName
					metastaticBreastCancer.isActive = params.status.equals("active")?(short)1:(short)0
					metastaticBreastCancer.rowAltered = new Date()
					metastaticBreastCancer.save(flush:true)
					if(!metastaticBreastCancer.validate()){
						status.setRollbackOnly()
					}
				}
			}
		}catch(Exception e){
			metastaticBreastCancer = null
		}
		return metastaticBreastCancer
	}
	/**
	 *Delete metastatic breast cancer
	 * @param metastaticId
	 * @return
	 */
	def deleteMetastaticBreastCancer(params) {
		boolean deleteMetastaticBreastCancer = true;
		try{
			if(params!=null && params.metastaticId !=null && !params.metastaticId.isEmpty()) {
				deleteMetastaticBreastCancer = MetastaticBreastCancer.executeUpdate("update MetastaticBreastCancer set isActive=0 where id="+params.metastaticId.toLong())
				if(deleteMetastaticBreastCancer) {
					// do nothing
				}else{
					deleteMetastaticBreastCancer = false
				}
			}else{
				deleteMetastaticBreastCancer = false
			}
		}catch(Exception e) {
			deleteMetastaticBreastCancer = false
		}
		return deleteMetastaticBreastCancer
	}
	def getCount(params) {
		try{
			return MetastaticBreastCancer.createCriteria().list() {
				if(params.searchValue != null && params.searchValue != "") ilike("metastaticName", "%"+params.searchValue+"%")
			}?.size()
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}