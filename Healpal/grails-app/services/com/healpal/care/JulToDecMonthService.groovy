package com.healpal.care

import grails.transaction.Transactional

@Transactional
class JulToDecMonthService {

    def serviceMethod() {

    }
	
	def getJulToDecMonthList(params){
		try{
			return HealpalUser.createCriteria().list(params){
				def currentYear = Calendar.getInstance().get(Calendar.YEAR);
				def decLastDate = new Date().parse("yyyy/MM/dd", currentYear+"/12/31")
				println "decLastDate"+decLastDate
				def julFirstDate = new Date().parse("yyyy/MM/dd", currentYear+"/07/01")
				between('rowCreated', julFirstDate, decLastDate)
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
				def decLastDate = new Date().parse("yyyy/MM/dd", currentYear+"/12/31")
				println "decLastDate"+decLastDate
				def julFirstDate = new Date().parse("yyyy/MM/dd", currentYear+"/07/01")
				between('rowCreated', julFirstDate, decLastDate)
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
