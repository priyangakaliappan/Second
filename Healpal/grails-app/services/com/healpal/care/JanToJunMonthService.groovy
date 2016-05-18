package com.healpal.care

import grails.transaction.Transactional

@Transactional
class JanToJunMonthService {

    def serviceMethod() {

    }
	
	def getList(params){
		try{
			return HealpalUser.createCriteria().list(params){
				def currentYear = Calendar.getInstance().get(Calendar.YEAR);
				def JunLastDate = new Date().parse("yyyy/MM/dd", currentYear+"/06/30")
				println "JunLastDate"+JunLastDate
				def janFirstDate = new Date().parse("yyyy/MM/dd", currentYear+"/01/01")
				between('rowCreated', janFirstDate, JunLastDate)
				if(params.sort == null && params.order == null){
					order('rowCreated','desc')
				}
				if(params.searchValue != null && params.searchValue != ""){
					or{
						and{ ilike('userName',"%"+params.searchValue+"%")}
						and{ person{ ilike('fullName',"%"+params.searchValue+"%") }
						}
					}
				}
			}
		}catch(Exception exception){
			throw exception
		}
	}
	
	def getCount(params){
		try{
			return HealpalUser.createCriteria().list(){
				def currentYear = Calendar.getInstance().get(Calendar.YEAR);
				def JunLastDate = new Date().parse("yyyy/MM/dd", currentYear+"/06/30")
				println "JunLastDate"+JunLastDate
				def janFirstDate = new Date().parse("yyyy/MM/dd", currentYear+"/01/01")
				between('rowCreated', janFirstDate, JunLastDate)
				order("rowCreated", "desc")
				if(params.searchValue != null && params.searchValue != ""){
					or{
						and{ ilike('userName',"%"+params.searchValue+"%")}
						and{ person{ ilike('fullName',"%"+params.searchValue+"%") }
						}
					}
				}
			}?.size()
		}catch(Exception exception){
			throw exception
		}
		
	}
}
