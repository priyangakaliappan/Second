package com.healpal.care

import java.text.SimpleDateFormat
import com.healpal.care.AuditEventService
import com.healpal.care.AuditEventType;
import com.healpal.care.HealpalUser
import com.healpal.care.Patient;
import com.healpal.care.PatientMedicalDocument;
import com.healpal.care.Person;
import com.healpal.care.ProfilePhoto;
import com.healpal.care.ProfileService;
import com.healpal.care.Role;
import com.healpal.care.UserMonthService

class UserMonthController {
	def UserService userService
	def UserMonthService userMonthService
	
    def index() { }
	
	
	def view (){
		
		authorizeMe()
						//LastMonth Count
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
						def	 lastDateOfPreviousMonth2= new SimpleDateFormat("yyyy-MM-dd").format(lastDateOfPreviousMonth);
						def lastMonth = HealpalUser.executeQuery("select ae from HealpalUser ae  where DATE(ae.rowCreated) between DATE('"+firstDateOfPreviousMonth+"') and DATE('"+lastDateOfPreviousMonth+"')");
						params.max = Math.min(params.max ? params.int('max') : 10, 100)
						println "test"+userMonthService.getLastMonthList(params)
						
						[lastMonth:lastMonth,users : userMonthService.getLastMonthList(params) ,total:lastMonth?.size() ,offset:0 ,max : params.max,searchValue:""]
			
					
				}
			
		
	def ajaxPaginate(){
		try{
			authorizeMe()
			println "params"+params.offset
			println "params"+params.max
			println "userMonthService.getLastMonthList(params)"+userMonthService.getLastMonthList(params)
			
			render (template :'list' ,model:[users : userMonthService.getLastMonthList(params)  ,total:userMonthService.getCount(params) ,offset:params.offset ,max :params.max,searchValue:params.searchValue])
           
					}catch(Exception exception){
			exception.printStackTrace()
		}
	}
	
	def searchValues(){
		try{
			println "userMonthService.getLastMonthList(params)"+userMonthService.getLastMonthList(params)
			println "userMonthService.getLastMonthList(params)"+userMonthService.getCount(params)
			params.max = Math.min(params.max ? params.int('max') :10, 100)
			render(template:"list",model:[users : userMonthService.getLastMonthList(params) ,total:userMonthService.getCount(params),offset:0 ,max : params.max, searchValue: params.searchValue])
		}catch(Exception exception){ exception.printStackTrace() }
	}
	
	def authorizeMe(){
		if(session.user && session.authority !=null && (session.authority?.equalsIgnoreCase(Role.admin) || session.authority.equalsIgnoreCase(Role.SuperAdmin))){
			// do nothing
		}else{
			redirect(controller:'Home', action:'index')
		}
	}
	}

