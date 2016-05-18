package com.healpal.care

import grails.transaction.Transactional

@Transactional
class HealthInsuranceService {

	def serviceMethod() {
	}

	/**
	 * save new Health Insurance
	 * @param healthInsurance
	 * @return created Health Insurance
	 */

	HealthInsurance save(params){
		HealthInsurance healthInsuranceType=new HealthInsurance();
		try{
			if(params != null && params.healthInsurance!= null && !params.healthInsurance.isEmpty()){
				healthInsuranceType.withTransaction {status->
					healthInsuranceType.healthInsuranceType = params.healthInsurance;
					healthInsuranceType.rowCreated=new Date();
					healthInsuranceType.isActive=(short)1;
					healthInsuranceType.save();
					if(!healthInsuranceType.validate()){
						status.setRollbackOnly()
					}
				}
			}
		}
		catch(Exception e){
			healthInsuranceType = null
		}
		return healthInsuranceType;
	}

	/**
	 * Update existed Health Insurance
	 * @param healthInsuranceId
	 * @return updated Health Insurance
	 */

	HealthInsurance update(params){
		HealthInsurance updateHealthInsuranceType=new HealthInsurance();
		try{
			if(params!= null && params.healthInsuranceId!=null && !params.healthInsuranceId.isEmpty() && params.healthInsurance!=null && !params.healthInsurance.isEmpty()){
				updateHealthInsuranceType=HealthInsurance.get(params.healthInsuranceId);
				updateHealthInsuranceType.withTransaction {status->

					updateHealthInsuranceType.healthInsuranceType = params.healthInsurance;
					updateHealthInsuranceType.rowAltered=new Date();
					updateHealthInsuranceType.isActive=params.status.equals("active")?(short)1:(short)0;
					updateHealthInsuranceType.save(flush:true);
					println updateHealthInsuranceType.save(flush:true);
					if(!updateHealthInsuranceType.validate()){
						status.setRollbackOnly()
					}
				}
			}
		}
		catch(Exception e){
			updateHealthInsuranceType = null
		}
		return updateHealthInsuranceType
	}

	/**
	 * Update existed Health Insurance and made inActive
	 * @param healthInsuranceId
	 * @return updated Health Insurance
	 */


	boolean delete(params){
		boolean deleteHealthInsuranceType=true;
		try{
			if(params!=null && params.healthInsuranceId!=null &&!params.healthInsuranceId.isEmpty()){
				HealthInsurance deleteHealthInsurance=HealthInsurance.get(params.healthInsuranceId);

				deleteHealthInsurance.isActive=(short)0;
				deleteHealthInsurance.save(flush:true);
				if(!deleteHealthInsurance.validate()){
					deleteHealthInsuranceType=false;
				}
			}
		}catch(Exception e){
			deleteHealthInsuranceType=false;
		}
		return deleteHealthInsuranceType
	}
	
	
	def getHealthInsuranceList(params){
		try{
			return HealthInsurance.createCriteria().list(params){
				if(params.sort == null && params.order == null){
					order('rowCreated','desc')
				}
				if(params.searchValue != null && params.searchValue != "") ilike("healthInsuranceType", "%"+params.searchValue+"%")
			}
		}catch(NullPointerException  | ArrayIndexOutOfBoundsException exception){
			throw exception
		}
	}
	def getCount(params){
		try{
			return HealthInsurance.createCriteria().list(){
				if(params.searchValue != null && params.searchValue != "") ilike("healthInsuranceType", "%"+params.searchValue+"%")
			}?.size()
		}catch(Exception exception){
			throw exception
		}
	}
	
}