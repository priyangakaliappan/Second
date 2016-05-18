package com.healpal.care

import com.opensymphony.module.sitemesh.html.rules.TagReplaceRule;

import grails.transaction.Transactional

@Transactional
class TargetedTherapyService {

	def serviceMethod() {
	}

	/**
	 * @param params
	 * @return
	 */
	def viewAll(params) {
		try {
			def therapyList = TargetedTheropy.createCriteria().list { order("rowCreated","desc") };
		}
		catch(Exception exception) {
			exception.printStackTrace();
		}
	}

	/**
	 * @param params
	 * @return
	 * @throws Exception
	 */
	def saveTargettedTerapy(params)throws Exception {
		def tTheraphy
		try {
			def targetedTheropy=params?.targetedTheropy
			if(targetedTheropy !=null && targetedTheropy!=""){
				TargetedTheropy targettedTheraphy= new TargetedTheropy();
				targettedTheraphy.targetedTheropyName=targetedTheropy;
				targettedTheraphy.rowCreated=new Date();
				targettedTheraphy.isActive=(short)1;
				tTheraphy = targettedTheraphy.save(flush:true);
				if (!targettedTheraphy.validate()) {
					targettedTheraphy.errors.each { println it }
				}
			}
		}
		catch(Exception e) {
			throw e
		}
		return tTheraphy;
	}

	/**
	 * @param params
	 * @return
	 * @throws Exception
	 */
	def updateTargettedTerapy(params)throws Exception {
		def targetTerapy
		try {
			def updatedId=params?.targetedTheropyId;
			if(updatedId!=null && updatedId!="") {
				TargetedTheropy targettedTerapy=TargetedTheropy.get(updatedId);
				targettedTerapy.targetedTheropyName=params.targetedTheropy
				//updatedStage.isActive=(short)params.isActive.toInteger();
				targettedTerapy.rowAltered=new Date();
				targetTerapy=targettedTerapy.save(flush:true);
				if(!targettedTerapy.validate())
				{
					targettedTerapy.errors.each{println it}
				}
			}
		}
		catch(Exception exception)
		{
			throw exception
		}
		return targetTerapy
	}

	/**
	 * @param params
	 * @return
	 * @throws Exception
	 */
	def deleteTargettedTerapy(params)throws Exception
	{
		def deleteTherapy
		try
		{
			def deleteStageId=params?.therapyId;
			if(deleteStageId!=null && deleteStageId!="")
			{
				TargetedTheropy deleteStage=TargetedTheropy.get(deleteStageId);
				deleteStage.isActive=(short)0;
				deleteTherapy=deleteStage.save(flush:true);
			}
		}
		catch(Exception exception)
		{
			throw Exception
		}
		return deleteTherapy
	}

}
