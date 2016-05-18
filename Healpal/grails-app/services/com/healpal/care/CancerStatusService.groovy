package com.healpal.care

import grails.transaction.Transactional

@Transactional
class CancerStatusService {

	def serviceMethod() {
	}

	/**
	 * save new cancer status
	 * @param cancerStatus
	 * @return created cancer status
	 */
	CancerStatus save(params){
		CancerStatus cancerstatus=new CancerStatus();
		try{

			if(params != null && params.cancerStatus!= null && !params.cancerStatus.isEmpty()){
				cancerstatus.withTransaction {status->

					cancerstatus.cancerStatusType = params.cancerStatus;
					cancerstatus.rowCreated=new Date();
					cancerstatus.isActive=(short)1;
					cancerstatus.save();
					if(!cancerstatus.validate()){
						status.setRollbackOnly()
					}
				}
			}
		}
		catch(Exception e){
			cancerstatus = null
		}
		return cancerstatus;
	}

	/**
	 * Update existed cancer status
	 * @param cancerstatusId
	 * @return updated cancer status
	 */

	CancerStatus update(params){
		CancerStatus updatedCancerstatus=new CancerStatus();
		try{

			if(params!= null && params.statusId!=null && !params.statusId.isEmpty() && params.cancerStatus!=null && !params.cancerStatus.isEmpty()){
				updatedCancerstatus=CancerStatus.get(params.statusId);
				updatedCancerstatus.withTransaction {status->

					updatedCancerstatus.cancerStatusType = params.cancerStatus;
					updatedCancerstatus.rowAltered=new Date();
					updatedCancerstatus.isActive=params.status.equals("active")?(short)1:(short)0;
					updatedCancerstatus.save(flush:true);
					if(!updatedCancerstatus.validate()){
						status.setRollbackOnly()
					}
				}
			}
		}
		catch(Exception e){
			updatedCancerstatus = null
		}
		return updatedCancerstatus
	}

	/**
	 * Update existed cancer status and made inActive
	 * @param statusId
	 * @return updated cancer status
	 */


	boolean delete(params){
		boolean deleteCancerStatus=true;
		try{
			if(params!=null && params.statusId!=null &&!params.statusId.isEmpty()){
				CancerStatus deleteStatus=CancerStatus.get(params.statusId.toLong());
				deleteStatus.isActive=(short)0;
				deleteStatus.save(flush:true);
				if(!deleteStatus.validate()){
					deleteCancerStatus=false;
				}
			}
		}catch(Exception e){
			deleteCancerStatus=false;
		}
		return deleteCancerStatus
	}

	/**
	 * get all cancer status list those are active
	 * @return
	 */
	def getCancerStatusList(params){
		try{
			return CancerStatus.createCriteria().list(params){
				if(params.sort == null && params.order == null){
					order('rowCreated','desc')
				}
				if(params.searchValue != null && params.searchValue != "") ilike("cancerStatusType", "%"+params.searchValue+"%")
			}	
		}catch(NullPointerException  | ArrayIndexOutOfBoundsException exception){
			throw exception
		}
	}

	/**
	 * update cancer status
	 * @return
	 */
	def updateStatus(params, HealpalUser user){

		try{
			if(params.value && user){
				Person person = Person.get(user?.person?.id);
				def value=params.value
				println"value:::::::::::::"+value
				if(person){
					person.cancerStatus= CancerStatus.get(value)
					person.save(flush:true)
				}
			}else{
				log.info("params values or user is null")
			}
		}catch(Exception exception){
			throw exception
		}
	}
	def getCount(params){
		return CancerStatus.createCriteria().list() {
			if(params.searchValue != null && params.searchValue != "") ilike("cancerStatusType", "%"+params.searchValue+"%")
		}?.size()
	}
}