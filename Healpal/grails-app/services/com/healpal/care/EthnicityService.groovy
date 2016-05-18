package com.healpal.care

import grails.transaction.Transactional

@Transactional
class EthnicityService {

	def serviceMethod() {
	}

	/**
	 * save new Ethnicity
	 * @param ethnicityName
	 * @return created ethnicity
	 */

	Ethnicity save(params){
		Ethnicity ethnicity=new Ethnicity();
		try{

			if(params != null && params.ethnicityName!= null && !params.ethnicityName.isEmpty()){
				ethnicity.withTransaction {status->

					ethnicity.ethnicityName = params.ethnicityName;
					ethnicity.rowCreated=new Date();
					ethnicity.isActive=(short)1;
					ethnicity.save();
					if(!ethnicity.validate()){
						status.setRollbackOnly()
					}
				}
			}
		}
		catch(Exception e){
			ethnicity = null
		}
		return ethnicity;
	}

	/**
	 * Update existed Ethnicity
	 * @param ethinicityId
	 * @return updated ethnicity
	 */

	Ethnicity update(params){
		Ethnicity updatedEthnicity=new Ethnicity();
		try{
			if(params!= null && params.ethinicityId!=null && !params.ethinicityId.isEmpty() && params.ethnicityName!=null && !params.ethnicityName.isEmpty()){
				updatedEthnicity=Ethnicity.get(params.ethinicityId);
				updatedEthnicity.withTransaction {status->
					updatedEthnicity.ethnicityName = params.ethnicityName;
					updatedEthnicity.rowAltered=new Date();
					updatedEthnicity.isActive=params.status.equals("active")?(short)1:(short)0;
					updatedEthnicity.save(flush:true);
					if(!updatedEthnicity.validate()){
						status.setRollbackOnly()
					}
				}
			}
		}
		catch(Exception e){
			updatedEthnicity = null
		}
		return updatedEthnicity
	}

	/**
	 * Update existed Ethinicity and made inActive
	 * @param ethinicityId
	 * @return updated ethnicity
	 */

	boolean delete(params){
		boolean deleteEthinicityType=true;
		try{
			if(params!=null && params.ethinicityId!=null &&!params.ethinicityId.isEmpty()){
				Ethnicity deleteEthnicity=Ethnicity.get(params.ethinicityId);

				deleteEthnicity.isActive=(short)0;
				deleteEthnicity.save(flush:true);
				if(!deleteEthnicity.validate()){
					deleteEthinicityType=false;
				}
			}
		}catch(Exception e){
			deleteEthinicityType=false;
		}
		return deleteEthinicityType
	}
	
	
	def getEthinicityList(params){
		try{
			return Ethnicity.createCriteria().list(params){
				if(params.sort == null && params.order == null){
					order('rowCreated','desc')
				}
				if(params.searchValue != null && params.searchValue != "") ilike("ethnicityName", "%"+params.searchValue+"%")
			}
		}catch(NullPointerException  | ArrayIndexOutOfBoundsException exception){
			throw exception
		}
	}
	
	def getCount(params){
		try{
			return Ethnicity.createCriteria().list(){
				if(params.searchValue != null && params.searchValue != "") ilike("ethnicityName", "%"+params.searchValue+"%")
			}?.size()
		}catch(Exception exception){
			throw exception
		}
	}
	
	
}
