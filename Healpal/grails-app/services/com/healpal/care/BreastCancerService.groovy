package com.healpal.care

import org.springframework.core.io.ResourceLoader;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import grails.transaction.Transactional
import com.healpal.care.Patient;
import com.healpal.care.TermsAcceptance;
@Transactional
class BreastCancerService implements org.springframework.context.ResourceLoaderAware {
	def ResourceLoader resourceLoader
    def serviceMethod() {

    }
	
	def termsAccept(HealpalUser user) throws Exception
	{
		try {
			TermsAcceptance terms = new TermsAcceptance();
			terms.patientFk = Patient.findByPerson(user?.person);
			terms.rowCreated=new Date();
			terms.isActive=(short)1
			terms.save(flush:true);
			println("inside save ::::"+terms.save(flush:true))
		}
		catch(Exception exception) {
			throw exception
		}
	}
	
	
	def shareLink(String sendToMail,String userName,String url){
		try{
			
		String sentMsg=null;
		if(sendToMail && sendToMail!=null && !sendToMail.isEmpty()){
		def toMail=sendToMail.toString();
		def content='<head></head><body><table width="100%" bgcolor="#fff" cellpadding="0" cellspacing="0" border="0" id="backgroundTable" st-sortable="header">'+
						'<tbody><tr><td<table width="860" cellpadding="0" cellspacing="0" border="0" align="center" class="devicewidth"><tbody><tr><td width="100%">'+
						'<table width="860" cellpadding="0" cellspacing="0" border="0" align="center" class="devicewidth" bgcolor="#f0eeee" id="mobile-device">'+
						'<tbody><tr><td><table bgcolor="#f0eeee" width="100%" align="center" border="0" cellpadding="0" cellspacing="0" class="devicewidth">'+
						'<tbody><tr><td width="100%" height="30px" align="center" style="padding:20px 0px 0px; font-size:11px; color:#a0a0a0; text-decoration:underline;">'+
						'<div class="text-center"><a target="_blank" href="#"><img src="cid:Logo" alt="" border="0" style="display:block;'+
						' border:none; outline:none; text-decoration:none; text-align:center; margin:14px 0px;"></a></div></td></tr><tr><td width="100%">'+
						'<table id="mobile-device" bgcolor="#fff" width="600" align="center"  bordercolor="#d7d7d7" cellpadding="0" cellspacing="0" class="devicewidth">'+
						'<tbody><tr><td height="100%" width="600"  align="left" style="border:1px solid #d7d7d7; font-size:14px; line-height:20px; color:#484848; padding:20px; font-weight:normal;  font-family:Arial;">'+
						'Hi, <br/> <br/>'+userName.capitalize()+' has shared a page with you from HealPal, click on the link below to view it.'+
						'<br/>'+url+'<br/><br/>Thanks,<BR/>The HealPal Team</td></tr></tbody></table></td></tr><tr><td width="100%">'+
						'<table bgcolor="#f0eeee" width="600" align="center"  cellpadding="0" cellspacing="0" class="devicewidth">'+
						'<tbody><tr><td align="center">	<div class="text-center"><a href="#"><img src="cid:fb" align="center" alt="image" border="0" style="display:inline-block; border:none; outline:none; text-decoration:none; text-align:center; margin:10px 5px 5px;">'+
						'</a><a href="#"><img src="cid:linkedin" align="center" alt="image" border="0" style="display:inline-block; border:none; outline:none; text-decoration:none; text-align:center; margin:10px 5px 5px;">'+
						'</a><a href="#"><img src="cid:pinterest" align="center" alt="image" border="0" style="display:inline-block; border:none; outline:none; text-decoration:none; text-align:center; margin:10px 5px 5px;"></a><a href="#">'+
						'<img src="cid:twitter" align="center" alt="image" border="0" style="display:inline-block; border:none; outline:none; text-decoration:none; text-align:center; margin:10px 5px 5px;"></a><p style="font-size:12px; color:#8f8f8f; line-height:20px; margin-top:0px;">'+
						'This email was sent to <a href="#" style="color:#8f8f8f; text-decoration:none;">'+sendToMail+'.</a><br/> '+
						'We value your privacy and will never share your email without your permission.</p><p style="font-size:12px; color:#5a5a5a">©2016 HealPal Inc. All rights reserved.</p></div><br/></td></tr></tbody></table></td></tr></tbody></table></td></tr></tbody></table></td></tr></tbody></table></body>'
		
				sendMail {
						multipart true
						to toMail
						subject "Hello user"    
						html content
						inline 'Logo', 'image/png', resourceLoader.getResource("/assets/new-design/img/logo.png").getFile()
						inline 'fb', 'image/png', resourceLoader.getResource("/assets/new-design/img/fb-icon.png").getFile()
						inline 'linkedin', 'image/png', resourceLoader.getResource("/assets/new-design/img/linkedin-icon.png").getFile()
						inline 'pinterest', 'image/png', resourceLoader.getResource("/assets/new-design/img/pinterest-icon.png").getFile()
						inline 'twitter', 'image/png', resourceLoader.getResource("/assets/new-design/img/twitter-icon.png").getFile()
						//body 'Please click the following link '+params.url
						//sentMsg = "success";
							}
		
		}
		return sentMsg
		}catch(Exception exception){
		throw exception
		}
		
		
	}

	
	
}
