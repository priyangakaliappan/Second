package com.healpal.care

import grails.transaction.Transactional

@Transactional
class RaceService {

	def serviceMethod() {
	}

	/**
	 * save new Race
	 * @param raceName
	 * @return created race
	 */

	Race save(params){
		Race race=new Race();
		try{
			if(params!=null && params.raceName!=null &&!params.raceName.isEmpty()){
				race.withTransaction {status->
					race.raceName = params.raceName;
					race.rowCreated=new Date();
					race.isActive=(short)1;
					race.save();
					if(!race.validate()){
						status.setRollbackOnly()
					}
				}
			}
		}
		catch(Exception e){
			race = null
		}
		return race;
	}

	/**
	 * Update existed Race
	 * @param raceId
	 * @return updated race
	 */

	Race update(params){
		Race updateRace=new Race();
		try{
			if(params!= null && params.raceId!=null && !params.raceId.isEmpty() && params.raceName!=null && !params.raceName.isEmpty()){
				updateRace=Race.get(params.raceId);
				updateRace.withTransaction {status->
					updateRace.raceName = params.raceName;
					updateRace.rowAltered=new Date();
					updateRace.isActive=params.status.equals("active")?(short)1:(short)0;
					updateRace.save(flush:true);
					println updateRace.save(flush:true);
					if(!updateRace.validate()){
						status.setRollbackOnly()
					}
				}
			}
		}
		catch(Exception e){
			updateRace = null
		}
		return updateRace
	}

	/**
	 * Update existed race and made inActive
	 * @param raceId
	 * @return updated race
	 */

	boolean delete(params){
		boolean deleteRaceName=true;
		try{
			if(params!=null && params.raceId!=null &&!params.raceId.isEmpty()){
				Race deleteRace=Race.get(params.raceId);
				deleteRace.isActive=(short)0;
				deleteRace.save(flush:true);
				if(!deleteRace.validate()){
					deleteRaceName=false;
				}
			}
		}catch(Exception e){
			deleteRaceName=false;
		}

		return deleteRaceName
	}
	
	
	def getRaceList(params){
		try{
			return Race.createCriteria().list(params){
				if(params.sort == null && params.order == null){
					order('rowCreated','desc')
				}
				if(params.searchValue != null && params.searchValue != "") ilike("raceName", "%"+params.searchValue+"%")
			}
		}catch(NullPointerException  | ArrayIndexOutOfBoundsException exception){
			throw exception
		}
	}
	def getCount(params){
		try{
			return Race.createCriteria().list(){
				if(params.searchValue != null && params.searchValue != "") ilike("raceName", "%"+params.searchValue+"%")
			}?.size()
		}catch(Exception exception){
			throw exception
		}
	}
}
