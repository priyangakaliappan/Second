package com.healpal.care

import grails.transaction.Transactional

@Transactional
class PathologyService {

    def serviceMethod() {

    }
	
	
	def getPathologyList(params){
		try{
			return PathologyBiopsyTumorType.createCriteria().list(params){
				if(params.sort == null && params.order == null){
					order('rowCreated','desc')
				}
				if(params.searchValue != null && params.searchValue != "") ilike("tumorTypeName", "%"+params.searchValue+"%")
			}
		}catch(NullPointerException  | ArrayIndexOutOfBoundsException exception){
			throw exception
		}
	}


	PathologyBiopsyTumorType doSave(PathologyBiopsyTumorType tumorType,params){
		try{
			PathologyBiopsyTumorType tumorTypes= new PathologyBiopsyTumorType();
			tumorTypes.tumorTypeName=params.tumorType
			tumorTypes.rowCreated=new Date();
			tumorTypes.isActive=(short)1;
			tumorType=tumorTypes.save();
			return tumorType
		}catch(Exception exception){
		throw exception
		}
	}


	PathologyBiopsyTumorType doUpdate(PathologyBiopsyTumorType tumorTypeUpdate,updated,params){
		try{
			if(updated !=null && !updated.isEmpty()){
			PathologyBiopsyTumorType updatedtumorTypes=PathologyBiopsyTumorType.get(updated);
			updatedtumorTypes.tumorTypeName = params.TumorTypes
			updatedtumorTypes.isActive = params.status.equals("active")?(short)1:(short)0;
			updatedtumorTypes.rowAltered = new Date();
			tumorTypeUpdate = updatedtumorTypes.save();
			return tumorTypeUpdate
			}else{
			// do nothing
			}
		}catch(Exception exception){
			throw exception
		}
	}

	PathologyBiopsyTumorType doDelete(PathologyBiopsyTumorType tumtourTypeDelete,params){
		PathologyBiopsyTumorType deleteStatus = new PathologyBiopsyTumorType()
		deleteStatus.withTransaction {status->
			try{
				if(params.pathologyId !=null && !params.pathologyId.isEmpty()){
					def delete = PathologyBiopsyTumorType.executeUpdate("UPDATE PathologyBiopsyTumorType p SET p.isActive=? WHERE p.id=?",[
						(short)0,
						params.pathologyId.toLong()
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
		try{
			return PathologyBiopsyTumorType.createCriteria().list(){
				if(params.searchValue != null && params.searchValue != "") ilike("tumorTypeName", "%"+params.searchValue+"%")
			}
		}catch(NullPointerException  | ArrayIndexOutOfBoundsException exception){
			throw exception
		}
	}
}
