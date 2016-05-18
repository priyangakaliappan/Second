package com.healpal.care

import grails.transaction.Transactional

@Transactional
class EducationService {

	def serviceMethod() {
	}
	/**
	 * save new Education type
	 * @param educationType
	 * @return created Education type
	 */
	Education save(params){
		Education educationType=new Education();
		try{
			if(params != null && params.educationType!= null && !params.educationType.isEmpty()){
				educationType.withTransaction {status->
					educationType.educationType = params.educationType;
					educationType.rowCreated=new Date();
					educationType.isActive=(short)1;
					educationType.save();
					if(!educationType.validate()){
						status.setRollbackOnly()
					}
				}
			}
		}
		catch(Exception e){
			educationType = null
		}
		return educationType;
	}
	/**
	 * Update existed Education
	 * @param educationId
	 * @return updated Education type
	 */

	Education update(params){
		Education updatedEducationType=new Education();
		try{
			if(params!= null && params.educationId!=null && !params.educationId.isEmpty() && params.educationType!=null && !params.educationType.isEmpty()){
				updatedEducationType=Education.get(params.educationId);
				updatedEducationType.withTransaction {status->

					updatedEducationType.educationType = params.educationType;
					updatedEducationType.rowAltered=new Date();
					updatedEducationType.isActive=params.status.equals("active")?(short)1:(short)0;
					updatedEducationType.save(flush:true);
					if(!updatedEducationType.validate()){
						status.setRollbackOnly()
					}
				}
			}
		}
		catch(Exception e){
			updatedEducationType = null
		}
		return updatedEducationType
	}

	/**
	 * Update existed EducationType and made inActive
	 * @param educationId
	 * @return updated Education type
	 */

	boolean delete(params){
		boolean deleteEducationType=true;
		try{
			if(params!=null && params.educationId!=null &&!params.educationId.isEmpty()){
				Education deleteEducation=Education.get(params.educationId);
				deleteEducation.isActive=(short)0;
				deleteEducation.save(flush:true);
				if(!deleteEducation.validate()){
					deleteEducationType=false;
				}
			}
		}catch(Exception e){
			deleteEducationType=false;
		}
		return deleteEducationType
	}
	
	
	def getEducationList(params){
		try{
			return Education.createCriteria().list(params){
				if(params.sort == null && params.order == null){
					order('rowCreated','desc')
				}
				if(params.searchValue != null && params.searchValue != "") ilike("educationType", "%"+params.searchValue+"%")
			}
		}catch(NullPointerException  | ArrayIndexOutOfBoundsException exception){
			throw exception
		}
    }
	def getCount(params){
		try{
			return Education.createCriteria().list(){
				if(params.searchValue != null && params.searchValue != "") ilike("educationType", "%"+params.searchValue+"%")
			}?.size()
		}catch(Exception exception){
			throw exception
		}
	}
	
}



