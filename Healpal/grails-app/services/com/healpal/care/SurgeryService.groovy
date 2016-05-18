package com.healpal.care

import grails.transaction.Transactional

@Transactional
class SurgeryService {

	def serviceMethod() {
	}

	/**
	 * save new Surgery
	 * @param surgeryType
	 * @return created surgery
	 */

	Surgery save(params){
		Surgery surgery=new Surgery();
		try{

			if(params!=null && params.surgeryType!=null &&!params.surgeryType.isEmpty()){
				surgery.withTransaction {status->

					surgery.surgeryType = params.surgeryType;
					surgery.rowCreated=new Date();
					surgery.isActive=(short)1;
					surgery.save();
					if(!surgery.validate()){
						status.setRollbackOnly()
					}
				}
			}
		}
		catch(Exception e){
			surgery = null
		}
		return surgery;
	}

	/**
	 * Update existed Surgerys
	 * @param surgeryId
	 * @return updated surgery
	 */

	Surgery update(params){
		Surgery updateSurgeryType=new Surgery();
		try{

			if(params!= null && params.surgeryId!=null && !params.surgeryId.isEmpty() && params.surgerytype!=null && !params.surgerytype.isEmpty()){
				updateSurgeryType=Surgery.get(params.surgeryId);
				updateSurgeryType.withTransaction {status->

					updateSurgeryType.surgeryType = params.surgerytype;
					updateSurgeryType.rowAltered=new Date();
					updateSurgeryType.isActive=params.status.equals("active")?(short)1:(short)0;
					updateSurgeryType.save(flush:true);
					println updateSurgeryType.save(flush:true);
					if(!updateSurgeryType.validate()){
						status.setRollbackOnly()
					}
				}
			}
		}
		catch(Exception e){
			updateSurgeryType = null
		}
		return updateSurgeryType
	}

	/**
	 * Update existed Surgery and made inActive
	 * @param surgeryId
	 * @return updated surgery
	 */

	boolean delete(params){
		boolean deleteSurgeryType=true;
		try{
			if(params!=null && params.surgeryId!=null &&!params.surgeryId.isEmpty()){
				Surgery deleteSurgery=Surgery.get(params.surgeryId);
				deleteSurgery.isActive=(short)0;
				deleteSurgery.save(flush:true);
				if(!deleteSurgery.validate()){
					deleteSurgeryType=false;
				}

				return deleteSurgeryType
			}
		}catch(Exception e){
			deleteSurgeryType=false;
		}
	}
	
	
	def getSurgeryList(params){
		try{
			return Surgery.createCriteria().list(params){
				if(params.sort == null && params.order == null){
					order('rowCreated','desc')
				}
				if(params.searchValue != null && params.searchValue != "") ilike("surgeryType", "%"+params.searchValue+"%")
			}
		}catch(NullPointerException  | ArrayIndexOutOfBoundsException exception){
			throw exception
		}
	}
	def getCount(params){
		try{
			return Surgery.createCriteria().list(){
				if(params.searchValue != null && params.searchValue != "") ilike("surgeryType", "%"+params.searchValue+"%")
			}?.size()
		}catch(NullPointerException  | ArrayIndexOutOfBoundsException exception){
			throw exception
		}
	}
}
