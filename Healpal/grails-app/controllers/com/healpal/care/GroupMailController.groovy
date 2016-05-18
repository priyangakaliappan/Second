package com.healpal.care

import com.healpal.date.DateConvention

class GroupMailController {
def GroupMailService groupMailService

    def index() {
		//flash.msg ="Mail has been sent "
		redirect(controller:"groupMail" , action:"view")
	}
	
	def create() {
		println("inside")
		def cancer = params.name
		def email = params.process
		println ";;;cancer;;;;;;;"+cancer
		try {
			if(params !=null &&  !params.isEmpty() && params.name !=null &&  !params.name.isEmpty() && params.process !=null &&  !params.process.isEmpty()){
				GroupMail groupMail= new GroupMail();
				groupMail.emailAddress=params.process;
				groupMail.rowCreated=new Date();
				groupMail.isActive=(short)1;
				groupMail.cancerType=params.name;
				groupMail.save(flush:true);
				println"groupMail"+groupMail
				//redirect(controller:'home' , action:'learn')
				if (!groupMail.save()) {
					groupMail.errors.each {
						println it
					}
				}
					if(groupMail.save())
					{
						println "inside groupMail.validate"
						redirect(controller:'home' , action:'learn')
					}
					
				
			
			}
			else {
				// do nothing
			}
		}
		catch(Exception e){
			e.printStackTrace()
		}
	}
	
	def view()
	{
		authorizeMe()   //***** Check Authorization
		try{
			params.max = Math.min(params.max ? params.int('max') : 10, 100)
			println "test"+groupMailService.viewAll(params)
			[groupMail:groupMailService.viewAll(params),total:GroupMail.list()?.size(),offset:0 ,max : params.max,searchValue:""]
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	def sendMail() 
	{  
		
		try{
			def checkedMails = params.emailAddress
			println "mails"+checkedMails
			String[] emailAddressArr = checkedMails.split(",");
			for(int i=0;i<emailAddressArr.length;i++){
				String email = emailAddressArr[i];
				if(email!=null && !email.isEmpty()){
			  def content=null;
			 content = 'Hi Welcome!<br></br><br></br>You could login to www.healpal.me and check our pages for the type of Cancer you have selected.<br><br><b>Thanks,</b><br></br><b>The Healpal Team</b>'
				  sendMail {
						multipart true
						to email
						subject "Welcome to Healpal"
						html content
					}
			flash.msg ="Mail has been sent "
			redirect(controller:"groupMail",action:"view")
				}
			}
			
		}
		catch(Exception exception){
			exception.printStackTrace()
		}
		
	}
	
	
	def ajaxPaginate(){
		try{
			println "hi"+groupMailService.viewAll(params)
			render (template :'list' ,model:[groupMail:groupMailService.viewAll(params) ,total:groupMailService.getCount(params) ,offset:params.offset ,max :params.max,searchValue:params.searchValue])
		}catch(Exception exception){
			exception.printStackTrace()
		}
	}
	
	def searchValues(){
		try{
		
			params.max = Math.min(params.max ? params.int('max') :10, 100)
			println "search"+groupMailService.getCount(params)
			println "search"+groupMailService.viewAll(params)
			
			render(template:"list" ,model:[groupMail:groupMailService.viewAll(params) ,total:groupMailService.getCount(params),offset:0 ,max : params.max, searchValue: params.searchValue])
		}catch(Exception exception){ exception.printStackTrace() }
	}
	
	def authorizeMe(){
		if(session.user && session.authority?.equalsIgnoreCase(Role.admin) || session.authority?.equalsIgnoreCase(Role.SuperAdmin)){
			// do nothing
		}else{
			flash.msg ="Sorry! you have not authorize to view this page"
			redirect(controller:'auth', action:'doLogout')}
	}
}
