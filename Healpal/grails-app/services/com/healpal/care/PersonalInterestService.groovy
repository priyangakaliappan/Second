package com.healpal.care

import grails.transaction.Transactional

@Transactional
class PersonalInterestService {

	def serviceMethod() {
	}

	/**
	 * save new Personal Interest
	 * @param personalInterest
	 * @return created personal interest
	 */

	PersonalInterest save(params){
		PersonalInterest personalInterestType=new PersonalInterest();
		try{
			if(params != null && params.personalInterest!= null && !params.personalInterest.isEmpty()){
				personalInterestType.withTransaction {status->
					personalInterestType.personalInterestType = params.personalInterest;
					personalInterestType.rowCreated=new Date();
					personalInterestType.isActive=(short)1;
					personalInterestType.save();
					if(!personalInterestType.validate()){
						status.setRollbackOnly()
					}
				}
			}
		}
		catch(Exception e){
			personalInterestType = null
		}
		return personalInterestType;
	}
	/**
	 * Update existed Personal Interest
	 * @param personalInterestId
	 * @return updated Personal Interest
	 */

	PersonalInterest update(params){
		PersonalInterest updatePersonalInterestType=new PersonalInterest();
		try{
			if(params!= null && params.personalInterestId!=null && !params.personalInterestId.isEmpty() && params.personalInterest!=null && !params.personalInterest.isEmpty()){
				updatePersonalInterestType=PersonalInterest.get(params.personalInterestId);
				updatePersonalInterestType.withTransaction {status->
					updatePersonalInterestType.personalInterestType = params.personalInterest;
					updatePersonalInterestType.rowAltered=new Date();
					updatePersonalInterestType.isActive=params.status.equals("active")?(short)1:(short)0;
					updatePersonalInterestType.save(flush:true);
					println updatePersonalInterestType.save(flush:true);
					if(!updatePersonalInterestType.validate()){
						status.setRollbackOnly()
					}
				}
			}
		}
		catch(Exception e){
			updatePersonalInterestType = null
		}
		return updatePersonalInterestType
	}

	/**
	 * Update existed PersonalInterest and made inActive
	 * @param personalInterestId
	 * @return updated Personal Interest
	 */

	boolean delete(params){
		boolean deletePersonalInterestType=true;
		try{
			if(params!=null && params.personalInterestId!=null &&!params.personalInterestId.isEmpty()){
				PersonalInterest deletePersonalInterest=PersonalInterest.get(params.personalInterestId);
				deletePersonalInterest.isActive=(short)0;
				deletePersonalInterest.save(flush:true);
				if(!deletePersonalInterest.validate()){
					deletePersonalInterestType=false;
				}
			}
		}catch(Exception e){
			deletePersonalInterestType=false;
		}
		return deletePersonalInterestType
	}
	
	
	
	def getPersonalInterestList(params){
		try{
			return PersonalInterest.createCriteria().list(params){
				if(params.sort == null && params.order == null){
					order('rowCreated','desc')
				}
			}
		}catch(NullPointerException  | ArrayIndexOutOfBoundsException exception){
			throw exception
		}
		
	}
}
