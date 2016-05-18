package com.healpal.care

import com.healpal.date.DateConvention
import java.text.SimpleDateFormat
import com.healpal.encryptdecrypt.CryptographyUtil;
class AccountActiveController {
	
	 def ForgotPasswordService forgotPasswordService
	 def AccountActiveService accountActiveService
	 def AuditEventService auditEventService
	def active()throws Exception{
		
		boolean canReset = false
		boolean ignoreExpired = false
		boolean isValidUser = false
		
		
		try{
			if(params.id != null && !params.id?.trim().isEmpty()){
				session.accountAcctive = params.id?.substring(params.id?.lastIndexOf('E')+1,params.id?.indexOf('M'))
				println "session.accountAcctive"+session.accountAcctive
				
				isValidUser = accountActiveService.isUser(session)
				
				if(isValidUser){
					
						def i= accountActiveService.updateActiveAccount(params,session)
						if(i && i==1){
							HealpalUser user=HealpalUser.get(session.accountAcctive)
							auditEventService . userSave(AuditEventType.newUserActivated, Role.patient, user)
							session.invalidate()
							flash.msg="Your account has been activated successfully. Please sign in to access your account"
							
							ignoreExpired = true
							render(view:'active',model:[ignoreExpired:ignoreExpired])
						}else{
							flash.msg="account activated failur"
						}
					
				}else{
					// do nothing
				}
				}else{
				
				if(params.id != null && !params.id?.trim().isEmpty()){
					
					Date date1 ,date2
					if(params.date != null && !params.date?.trim()?.isEmpty()){
						SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
						date1 = sdf.parse(new DateConvention().convertUtilDateToString(new Date()));
						date2 = sdf.parse(CryptographyUtil.decrypt(params.date?.replace(" ","+")));
						if(date1.compareTo(date2)==0){
							ignoreExpired = true
						}else{
							ignoreExpired = false
						}
					}else{ 
						ignoreExpired = true
					}

					render(view:'active',model:[ignoreExpired:ignoreExpired ])
				}else{
					ignoreExpired = true
					render(view:'active',model:[ignoreExpired:ignoreExpired ])
				}
			
				}
			}catch(Exception exception){
			exception.printStackTrace()
		}
	}

}
