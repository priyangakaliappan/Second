package com.healpal.care

import grails.transaction.Transactional

@Transactional
class CancerStageService {

    def serviceMethod() {

    }
	
	
	def getCancerStageList(params){
		try{
			return CancerStage.createCriteria().list(params){
				if(params.sort == null && params.order == null){
					order('rowCreated','desc')
				}
				if(params.searchValue != null && params.searchValue != "") ilike("cancerStageLevel", "%"+params.searchValue+"%")
			}
		}catch(NullPointerException  | ArrayIndexOutOfBoundsException exception){
			throw exception
		}
	}


	CancerStage doSave(CancerStage cancerStageSave,params){
		try{
			CancerStage cancerStage= new CancerStage();
			cancerStage.cancerStageLevel=params.cancerStage
			println"cancerStage.cancerStageLevel"+cancerStage.cancerStageLevel
			cancerStage.rowCreated=new Date();
			cancerStage.isActive=(short)1;
			cancerStageSave=cancerStage.save(flush:true);
			return cancerStageSave
		}catch(Exception e){
		}
	}


	CancerStage doUpdate(CancerStage cancerStageUpdate,updated,params){
		try{
			CancerStage updateStage=CancerStage.get(updated);
			updateStage.cancerStageLevel = params.cancerStage
			updateStage.isActive = params.status.equals("active")?(short)1:(short)0;
			updateStage.rowAltered = new Date();
			cancerStageUpdate = updateStage.save();
			return cancerStageUpdate
		}catch(Exception exception){
			throw exception
		}
	}

	CancerStage doDelete(CancerStage cancerStageDelete,params){
		CancerStage deleteStatus = new CancerStage()
		deleteStatus.withTransaction {status->
			try{
				if(params.stageId !=null && !params.stageId.isEmpty()){
					def delete = CancerStage.executeUpdate("UPDATE CancerStage p SET p.isActive=? WHERE p.id=?",[
						(short)0,
						params.stageId.toLong()
					])
					if(delete){
						return deleteStatus
					}
				}
			}catch(Exception e){
				throw e
			}
		}
	}
def getCount(params){
	return CancerStage.createCriteria().list() {
		if(params.searchValue != null && params.searchValue != "") ilike("cancerStageLevel", "%"+params.searchValue+"%")
	}?.size()
	
	}
}
