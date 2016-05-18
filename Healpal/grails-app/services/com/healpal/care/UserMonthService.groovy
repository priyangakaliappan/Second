package com.healpal.care

import grails.transaction.Transactional
import java.text.SimpleDateFormat

@Transactional
class UserMonthService {

    def serviceMethod() {

    }
	
	
	//last month user details//
	def getLastMonthList(params){
		def test
		try{
			test = HealpalUser.createCriteria().list(params){
				def lastMonthCount=HealpalUser.all
						Calendar aCalendar = Calendar.getInstance();
						aCalendar.add(Calendar.MONTH, -1);
						aCalendar.set(Calendar.DATE, 1);
						Date firstDateOfPreviousMonth = aCalendar.getTime();
						// set actual maximum date of previous month
						aCalendar.set(Calendar.DATE,     aCalendar.getActualMaximum(Calendar.DAY_OF_MONTH));
						//read it
						Date lastDateOfPreviousMonth = aCalendar.getTime();
						
						
						def firstDateOfPreviousMonth1 = new SimpleDateFormat("yyyy-MM-dd").format(firstDateOfPreviousMonth)
						//println "firstDateOfPreviousMonth1"+firstDateOfPreviousMonth
						def	 lastDateOfPreviousMonth2= new SimpleDateFormat("yyyy-MM-dd").format(lastDateOfPreviousMonth);
						//println "lastDateOfPreviousMonth2"+lastDateOfPreviousMonth
						
				between('rowCreated', firstDateOfPreviousMonth, lastDateOfPreviousMonth)
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
			println "test;;;;;;;;;;;;;;;;;"+test?.person?.fullName
			return test
		}catch(Exception exception){
			throw exception
		}
	}
	
	def getCount(params){
		try{
			return HealpalUser.createCriteria().list(){
				
				order('rowCreated','desc')
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
