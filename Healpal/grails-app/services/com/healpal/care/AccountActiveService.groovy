package com.healpal.care

import grails.transaction.Transactional

@Transactional
class AccountActiveService {

	def isUser(session){
		boolean isUser = false;
		if(session.accountAcctive){
			def list=HealpalUser.createCriteria().list {
				eq('id',session.accountAcctive?.toLong())
				eq('isActive',(short)1)
			}
			if(list){
				isUser = true;
				return isUser
			}else{
				// do nothing
			}
		}else{
			//do nothing
		}
		return isUser
	}
	
	
	def updateActiveAccount(params,session)throws Exception{
		try{
			int i=0
			if(session.accountAcctive){
				i=HealpalUser.executeUpdate("update HealpalUser u set u.enabled=? where u.id=?",[
					true,
					session.accountAcctive?.toLong()
				])
				return i
			}else{
			// do something
			}
		}
		catch(Exception exception){
			throw exception
		}
		
	}
	
}
