/*
 * Author    : Karthigeyan
 * Project   : Healpal
 * Date      :
 * Description : Forgot,Reset  of ForgotPassword
 *
 * #   Name       Version   Modified-Date      Description
 * -------------------------------------------------------------------------------------
 * 1   Karthigeyan    1.0               Initial Creation
 *
 */


package com.healpal.care
import com.healpal.care.PatientMessageService;
import com.healpal.date.DateConvention
import com.healpal.encryptdecrypt.BCrypt;
import com.healpal.encryptdecrypt.CryptographyUtil;

import java.text.SimpleDateFormat

class ForgotPasswordController {


	def ForgotPasswordService forgotPasswordService
	def PatientMessageService patientMessageService
	def index() {

		redirect(controller:"home" , action:"index")
	}

	/*
	 * To send link to mail to reset your forgot password
	 *
	 */
	
	def forgot()throws Exception{
		boolean isValidUser = false
		boolean isAccountActive = false
		try{
			if(request.post){

				isAccountActive=forgotPasswordService.getUserEmail(params.email,session)
				if(isAccountActive){
					forgotPasswordService.resetPassword(params,request,session)
					if(session.mailSend == "1") {
						//flash.msg="Please check your email for password reset link"
						//redirect action:'forgot'
						render(template:'../home/resetMailSend')
						
					}
				}else{
					flash.msg="The email address is not registered for a Healpal account.Please try again"
					redirect action:'forgot'
				}
			}
		}catch(Exception e){
		}
	}
	
	
	
	/*
	 * Reset your password
	 *
	 */

	def reset()throws Exception{
		boolean isValidUser = false
		boolean accountActive = false
		boolean canReset = false
		boolean ignoreExpired = false
		try{
			if(request.post){
				if(params.hiddenUserId){
					session.resetUserId = params.hiddenUserId?.substring(params.hiddenUserId?.lastIndexOf('E')+1, params.hiddenUserId?.indexOf('M'))
				}
				isValidUser = forgotPasswordService.isUser(session)
				accountActive = forgotPasswordService.isAccountActive(session)
				if(isValidUser){
					if(accountActive){
						def i= forgotPasswordService.updatePassword(params,session)
						if(i && i==1){
							session.invalidate()
							flash.reset="Your password has been changed successfully"
							ignoreExpired = true
							render(view:'reset',model:[ignoreExpired:ignoreExpired])
						}else{
							flash.reset="password reset failur"
						}
					}else{
						//do nothing
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
							canReset = true
						}else{
							canReset = false
							ignoreExpired = false
						}
					}else{
						ignoreExpired = true
					}

					render(view:'reset',model:[resetUserId:params.id ,canReset:canReset ,ignoreExpired:ignoreExpired ])
				}else{
					ignoreExpired = true
					render(view:'reset',model:[ignoreExpired:ignoreExpired ])
				}
			}
		}catch(Exception exception){
			exception.printStackTrace()
		}
	}
	
	def changeAdminPassword(){
		if(session.user && session.authority !=null && (session.authority?.equalsIgnoreCase(Role.admin) || session.authority.equalsIgnoreCase(Role.SuperAdmin))){
			
		def oldPassword=params.oldPassword
		def newPassword=params.newPassword
		def confirmPassword=params.confirmPassword
		println oldPassword
		println newPassword
		println confirmPassword
		session.resetUserId=params.resetUserId
		byte[] updatePassword = params.oldPassword?.trim().getBytes()
		def password = BCrypt.encode_base64(updatePassword, params.oldPassword?.length())
		println session.user
		if(password.equalsIgnoreCase(HealpalUser.get(session.user?.id)?.password)){
			def i= forgotPasswordService.updatePassword(params,session)
			if(i && i==1){
				session.resetUserId=null;
								render "Your password has been changed successfully"
							}else{
								render  "Password reset failure"
							}
		}
		else{			
		render "Sorry, Old password you have entered is wrong"
			}
		
		}
		else{
			redirect controller :'auth' ,action :'doLogout'
		}
		
		
		
	}
	
}
