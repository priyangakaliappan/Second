package com.healpal.care

import grails.transaction.Transactional

@Transactional
class GroupMailService {

    def serviceMethod() {
    }
	
	GroupMail doSave(GroupMail groupMailSave,params){
		try{
			GroupMail groupMail= new GroupMail();
			groupMail.emailAddress=params.email;
			groupMail.rowCreated=new Date();
			groupMail.isActive=(short)1;
			groupMail.cancerType=params.emailAddress;
			groupMailSave=groupMail.save(flush:true);
			return groupMailSave
		}catch(Exception e){
		throw e
		}
	}
	
	def viewAll(params)
	{
		
		
		try{
			return GroupMail.createCriteria().list(params) {
				
					if(params.sort == null && params.order == null){
					order('rowCreated','desc')
				}
					if(params.searchValue != null && params.searchValue != "") { 
						ilike("emailAddress", "%"+params.searchValue+"%")
					}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	def getCount(params){
		try{
			return GroupMail.createCriteria().list() {
				if(params.searchValue != null && params.searchValue != "") ilike("emailAddress", "%"+params.searchValue+"%")
			}?.size()
		}catch(Exception e){
		throw e
	}
	}
}
