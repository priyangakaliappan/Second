package com.healpal.care

import grails.transaction.Transactional

@Transactional
class SideEffectService {

	
    def serviceMethod() {

    }
	/**
	 * @param params
	 * @return
	 * @throws Exception
	 */
	def viewAll(params)throws Exception
	{
		/*try
		{
			def sideEffectsList = SideEffects.createCriteria().list {
				order("rowCreated","desc")
			};
		}
		catch(Exception exception)
		{
			throw exception
		}*/
		try{
			return SideEffects.createCriteria().list(params){
				if(params.sort == null && params.order == null){
					order('rowCreated','desc')
				}
				if(params.searchValue != null && params.searchValue != "") ilike("sideEffectsType", "%"+params.searchValue+"%")
			}
		}catch(NullPointerException  | ArrayIndexOutOfBoundsException exception){
			throw exception
		}
	}
	
	/**
	 * @param params
	 * @return
	 * @throws Exception
	 */
	def saveSideEffects(params)throws Exception
	{
		def sideEffects
		try
		{
			def sideEffectsType=params?.sideEffectsType
			if(sideEffectsType!=null && sideEffectsType!=""){
				SideEffects sideEffectsTypeObj= new SideEffects();
				sideEffectsTypeObj.sideEffectsType=sideEffectsType;
				sideEffectsTypeObj.rowCreated=new Date();
				sideEffectsTypeObj.isActive=(short)1;
				sideEffects=sideEffectsTypeObj.save();
			}
		}
		catch(Exception exception)
		{
			throw exception
		}
		return sideEffects
	}
	
	
	/**
	 * @param params
	 * @return
	 * @throws Exception
	 */
	def updateSideEffects(params)throws Exception
	{
		def sideEffectsReturn
		try
		{
			def updatedId=params?.sideEffectsId;
			if(updatedId!=null && updatedId!="")
			{
			SideEffects sideEffects=SideEffects.get(updatedId);
			sideEffects.sideEffectsType=params.sideEffectsType
			sideEffects.isActive=params.status.equals("active")?(short)1:(short)0;
			sideEffects.rowAltered=new Date();
		sideEffectsReturn=	sideEffects.save(flush:true);
			}
			
		}
		catch(Exception exception)
		{
			throw exception
		}
		return sideEffectsReturn
	}
	
	/**
	 * @param params
	 * @return
	 * @throws Exception
	 */
	def deleteSideEffects(params)throws Exception
	{
		def deleteSideEffectsReturn
		try{
			def deleteStageId=params?.sideEffectsId;
			if(deleteStageId!=null && deleteStageId!=""){
			SideEffects deleteSideEffects=SideEffects.get(deleteStageId);
			deleteSideEffects.isActive=(short)0;
		deleteSideEffectsReturn=deleteSideEffects.save(flush:true);
			}
		}
		catch(Exception exception)
		{
			throw exception
		}
		return deleteSideEffectsReturn
	}
	def getCount(params)throws Exception
	{
		try{
			return SideEffects.createCriteria().list(){
				if(params.searchValue != null && params.searchValue != "") ilike("sideEffectsType", "%"+params.searchValue+"%")
			}?.size()
		}catch(NullPointerException  | ArrayIndexOutOfBoundsException exception){
			throw exception
		}
	}
}
