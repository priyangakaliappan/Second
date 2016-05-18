package com.healpal.care

import org.apache.naming.factory.SendMailFactory;
import org.springframework.core.io.ResourceLoader
import org.springframework.core.io.Resource
import com.healpal.encryptdecrypt.BCrypt;
import com.healpal.encryptdecrypt.CryptographyUtil;
import com.healpal.care.PatientMessageService;
import com.healpal.date.DateConvention
import grails.transaction.Transactional

@Transactional
class ForgotPasswordService implements org.springframework.context.ResourceLoaderAware{

	def PatientMessageService patientMessageService
	def ResourceLoader resourceLoader
	
	def groovyPageRenderer
	
/*
 * Forgot passord sending mail to your registered email ID
 * 
 */
	def resetPassword(params,request,session)throws Exception{
		def user = null
		try{
			if(params.email){
				user = HealpalUser.findByUserName(params.email)

				if( user != null ){
					session.mailSend = "0"
					def mail = user?.person?.emailAddress?.toString()
					def name = user?.person?.fullName.toString()
					def userId = user?.id
					def encryptedId = "KV/9E"+userId+"M8H5AI"
					DateConvention convert = new DateConvention()
					def date = CryptographyUtil.encrypt(convert.convertUtilDateToString(new Date()))
					this.sendMail(mail,name,encryptedId,date,request)
					session.mailSend = "1"
				}else{
					//do nothing
				}
			}
		}catch(Exception exception){
			exception.printStackTrace()
		}
	}

	/*
	 * Reset your password
	 * 
	 */
	def updatePassword(params,session)throws Exception{
		try{
			println "updatePassword"
			int i=0
			if(session.resetUserId && params != null && params.confirmPassword != null && !params.confirmPassword?.trim()?.isEmpty()){
				println "inside ifff"
				byte[] updatePassword = params.confirmPassword?.trim().getBytes()
				def password = BCrypt.encode_base64(updatePassword, params.confirmPassword?.length())
				println "pass "+password
				i=HealpalUser.executeUpdate("update HealpalUser u set u.password=? where u.id=?",[
					password,
					session.resetUserId?.toLong()
				])
				println "iiiiiiiii "+i
				return i
			}else{
			// do something
			}
		}
		catch(Exception exception){
			throw exception
		}
	}


	
	/*
	 * 
	 * To get url
	 * 
	 */
	def getWebAppUrl(request)throws Exception{
		def contexturl = null
		try{
			def path = request.getHeader("Referer")
			def webUrl =path.toString().substring(0,path.toString().indexOf("/",path.toString().indexOf("//")+2))
			contexturl = webUrl + request.getContextPath()
		}catch(Exception exception){
			throw exception
		}
		return contexturl
	}

/*
 * 
 * Checking username is valid in the healpaluser table
 * 
 */
	def getUserEmail(def email,session){
		boolean isUser = false;
		if(email){
			def list=HealpalUser.createCriteria().list {
				eq('userName',email)
				eq('isActive',(short)1)
				eq('accountLocked',false)
			}

			if(list){
				isUser = true;
				if(list != null && list.size() > 0){
					return isUser
				}
			}else{
				// do nothing
			}
		}else{
			//do nothing
		}
		return isUser
	}

	
	/*
	 *
	 * Checking current user in a healpaluser table
	 *
	 */
	
	def isUser(session){
		boolean isUser = false;
		if(session.resetUserId){
			def list=HealpalUser.createCriteria().list {
				eq('id',session.resetUserId?.toLong())
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

	
	
	/*
	 *
	 * Checking current user accpont is in active or not
	 *
	 */
	
	def isAccountActive(session){
		boolean isAccountActive = false;
		if(session.resetUserId){
			def list=HealpalUser.createCriteria().list {
				eq('id',session.resetUserId.toLong())
				eq('isActive',(short)1)
			}
			if(list){
				isAccountActive = true;
				return isAccountActive
			}else{
				// do nothing
			}
		}else{
			//do nothing
		}
		return isAccountActive
	}

	
	/*
	 *
	 * Sending email to registered user with url to redirect to change password screen
	 *
	 */
	def sendMail(String toMail,String name,String userId,def date ,request)throws Exception{
		def strSubject = null
		def content = null
		def list = null
		try{
			def webUrl = this.getWebAppUrl(request)
			if(webUrl != null){
				//def image='<img src="cid:Logo" />'
				
				String dateStr = '&nbsp;<b>'+new Date().toString()+'</b>'
				def resetURL = '<a href="'+webUrl.toString()+'/forgotPassword/reset?id='+ userId +'&date='+date+'" class="table-sign-btn" style="background:#f15922; text-align:center; color:#fff; text-decoration:none; font-size:16px; border:1px solid #f15922; border-radius:3px; width:135px; padding:0px 20px; margin:14px 0px; height:35px; line-height:35px; display:inline-block; font-weight:bold;">Reset Password</a>'
				
				
				strSubject = "Reset Password"
				
				
				
				//content = 'Hi <b>'+name+'</b><br></br><br>'+image+'<br/><p>Please reset your password here :<br><br/> '+resetURL+'<br></br><br></br>if you did not request this. Please ignore this message.<br></br><br></br> Thanks,<br></br><br></br>The HealPal Team</p>'
				
				
				content= '<body><table width="100%" bgcolor="#fff" cellpadding="0" cellspacing="0" border="0" id="backgroundTable" st-sortable="header">'+
		                 '<tbody><tr><td><table width="860" cellpadding="0" cellspacing="0" border="0" align="center" class="devicewidth"><tbody><tr><td width="100%">'+
						 '<table width="860" cellpadding="0" cellspacing="0" border="0" align="center" class="devicewidth" bgcolor="#f0eeee">'+
						 '<tbody><tr><td><table bgcolor="#f0eeee" width="860" align="center" border="0" cellpadding="0" cellspacing="0" class="devicewidth"><tbody><tr>'+
						 '<td width="100%" height="30px" align="center" style="padding:20px 0px 0px; font-size:11px; color:#a0a0a0; text-decoration:underline;"> View this email in your browser'+
						 '<div class="text-center"><a target="_blank" href="#"><img src="cid:Logo" alt="" border="0" style="display:block; border:none; outline:none; text-decoration:none; text-align:center; margin:14px 0px;"></a> </div></td></tr>'+
						 '<tr><td width="100%"><table id="mobile-device" bgcolor="#fff" width="600" align="center"  bordercolor="#d7d7d7" cellpadding="0" cellspacing="0" class="devicewidth"><tbody><tr>'+
						 '<td height="100%" width="600"  align="left" style="border:1px solid #d7d7d7; font-size:14px; line-height:20px; color:#484848; padding:20px; font-weight:normal; font-family:Opensans Semibold;">'+
						 'Hi '+name+',<br/><br/>Please reset your password here :<br/>'+resetURL+'<br/>'+
						 'If you did not request this, please ignore this message.<br/> <br/> Thanks,<BR/> The HealPal Team </td> </tr></tbody> </table> </td> </tr>'+
						 '<tr><td width="100%">'+
						 '<table bgcolor="#f0eeee" width="600" align="center"  cellpadding="0" cellspacing="0" class="devicewidth">'+
						'<tbody><tr><td align="center">	<div class="text-center"><a href="#"><img src="cid:fb" align="center" alt="image" border="0" style="display:inline-block; border:none; outline:none; text-decoration:none; text-align:center; margin:10px 5px 5px;">'+
						'</a><a href="#"><img src="cid:linkedin" align="center" alt="image" border="0" style="display:inline-block; border:none; outline:none; text-decoration:none; text-align:center; margin:10px 5px 5px;">'+
						'</a><a href="#"><img src="cid:pinterest" align="center" alt="image" border="0" style="display:inline-block; border:none; outline:none; text-decoration:none; text-align:center; margin:10px 5px 5px;"></a><a href="#">'+
						'<img src="cid:twitter" align="center" alt="image" border="0" style="display:inline-block; border:none; outline:none; text-decoration:none; text-align:center; margin:10px 5px 5px;"></a><p style="font-size:12px; color:#8f8f8f; line-height:20px; margin-top:0px;">'+
						'This email was sent to <a href="#" style="color:#8f8f8f; text-decoration:none;">'+toMail+'.</a><br/> '+
						'We value your privacy and will never share your email without your permission.</p><p style="font-size:12px; color:#5a5a5a">©2016 HealPal Inc. All rights reserved.</p></div><br/></td></tr></tbody></table></td></tr></tbody></table></td></tr></tbody></table></td></tr></tbody></table></body>'
						 
									
														
				if(strSubject != null && content!= null){
					sendMail {
						multipart true
						to toMail
						subject strSubject
						html content
                        inline 'Logo', 'image/png', resourceLoader.getResource("/assets/new-design/img/logo.png").getFile()
						inline 'fb', 'image/png', resourceLoader.getResource("/assets/new-design/img/fb-icon.png").getFile()
						inline 'linkedin', 'image/png', resourceLoader.getResource("/assets/new-design/img/linkedin-icon.png").getFile()
						inline 'pinterest', 'image/png', resourceLoader.getResource("/assets/new-design/img/pinterest-icon.png").getFile()
						inline 'twitter', 'image/png', resourceLoader.getResource("/assets/new-design/img/twitter-icon.png").getFile()
						
						//new File('./assets/images/mailLogo.png')						//inline 'Logo', 'image/jpg', resourceLoader.getResource("/assets/image/mailLogo.png").getFile()
						return
					}
					
				}
			}else{
				//do nothing
			}
		}
		catch(Exception exception){
			throw exception
		}
	}
}
