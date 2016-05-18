package com.healpal.care

import grails.transaction.Transactional

@Transactional
class AboutPassionateService {

    def serviceMethod() {

    }
	
	def aboutPassionateList(params){
		
		try{
			return Person.createCriteria().list(params){
				if(params.sort == null && params.order == null){
					order('rowCreated','desc')
				}
				if(params.searchValue != null && params.searchValue != ""){ 
					or{
						and{ ilike("fullName", "%"+params.searchValue+"%")}
						and{ ilike("describeAboutYourself", "%"+params.searchValue+"%") }
						and{ ilike("passionateAbout", "%"+params.searchValue+"%") }
					}
				}
			}
		}catch(NullPointerException){
			throw exception
		}
	}
	
	
	Person doUpdate(Person passionateUpdate ,params){
		try{
			Person update=Person.get(params.abtpassId.toLong());
			update.describeAboutYourself = params.describeAboutYourself
			update.passionateAbout = params.passionateAbout
			update.rowAltered = new Date();
			passionateUpdate = update.save();
			return passionateUpdate
		}catch(Exception exception){
			throw exception
		}
	}
	def getCount(params){
		return Person.createCriteria().list() {
			if(params.searchValue != null && params.searchValue != ""){
				or{
					and{ ilike("fullName", "%"+params.searchValue+"%")}
					and{ ilike("describeAboutYourself", "%"+params.searchValue+"%") }
					and{ ilike("passionateAbout", "%"+params.searchValue+"%") }
				}
			}
		}?.size()
	}
}
