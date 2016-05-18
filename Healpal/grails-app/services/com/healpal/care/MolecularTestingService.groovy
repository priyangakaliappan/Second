package com.healpal.care

import grails.transaction.Transactional

@Transactional
class MolecularTestingService {

    def serviceMethod() {

    }
	
	def getMolecularList(params){
		try{
			return MolecularForCancer.createCriteria().list(params){
				if(params.sort == null && params.order == null){
					order('rowCreated','desc')
				}
				if(params.searchValue != null && params.searchValue != "") ilike("molecularForCancerName", "%"+params.searchValue+"%")
			}
		}catch(NullPointerException  | ArrayIndexOutOfBoundsException exception){
			throw exception
		}
	}
	
	
	def update(params){
		MolecularForCancer updatedMolecularForCancer=new MolecularForCancer();
		try{
			if(params!= null && params.molecularId!=null && !params.molecularId.isEmpty() && params.molecularCancerName!=null && !params.molecularCancerName.isEmpty()){
				updatedMolecularForCancer=MolecularForCancer.get(params.molecularId);
				updatedMolecularForCancer.withTransaction {status->

					updatedMolecularForCancer.molecularForCancerName = params.molecularCancerName;
					updatedMolecularForCancer.rowAltered=new Date();
					updatedMolecularForCancer.isActive=params.status.equals("active")?(short)1:(short)0;
					updatedMolecularForCancer.save(flush:true);
					if(!updatedMolecularForCancer.validate()){
						status.setRollbackOnly()
					}
				}
			}
		}
		catch(Exception e){
			updatedMolecularForCancer = null
		}
		return updatedMolecularForCancer
	}
	def getCount(params){
		try{
			return MolecularForCancer.createCriteria().list(){
				if(params.searchValue != null && params.searchValue != "") ilike("molecularForCancerName", "%"+params.searchValue+"%")
			}?.size()
		}catch(NullPointerException  | ArrayIndexOutOfBoundsException exception){
			throw exception
		}
	}
}
