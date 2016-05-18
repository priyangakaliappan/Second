/*
 * Author      : Arunkumar K
 * Project     : Healpal
 * File        : MessageController
 * Date        : 23-10-2015
 * Description : New Message, Create a Group, Reply Message, Show all messages
 *
 * #   Name           Version           Modified-Date      Description
 * -------------------------------------------------------------------------------------
 * 1   Arunkumar K    1.0               23-10-2015         Initial Creation
 *
 */
package com.healpal.care

/**
 * 
 * @author Arunkumar K
 *
 */
class MessageController {
	static MessageService messageService

	/**
	 * 
	 * @return to message page
	 */
	def index(){
		authorizeMe();
		render(view:'message',model:[patientList:Patient.all]);
	}

	/**
	 * Sending message
	 * @return
	 */
	def message(){
		try{
			authorizeMe();
			if(params?.to){
				HealpalUser user = session.user
				//println "inside message>>>>  "+params.to
				def status = messageService.sendMessage(params, user);
				if(status){
					render(view:'message',model:[addStatus:"message has been sent successfully!!!!!!",patientList:Patient.all]);
				}else{
					render(view:'message',model:[addStatus:"message not sent!!!!!!",patientList:Patient.all]);
				}
			}else{
				//do nothing
			}
		}catch(Exception exception){
			exception.printStackTrace();
		}
	}


	/**
	 * Inbox messaged
	 * @return
	 */
	def inbox(){
		try{
			authorizeMe();
			HealpalUser user = session.user
			//println "::::::username::::::"+user?.userName
			def inboxList = messageService.getInboxMessages(HealpalUser.get(user.id));
			render(view:'inbox',model:[inboxList:inboxList]);
		}catch(Exception exception){
			exception.printStackTrace();
		}
	}

	/**
	 * Get the patient messages
	 * @return
	 */
	def getMessages(){
		try{
			authorizeMe();
			//println ":::::::params patientid::::::::"+params.patientId
			if(params?.patientId){
				HealpalUser user = session.user
				def patientMessages = messageService.getPatientMessages(params.patientId, Patient.findByPerson(HealpalUser.get(user.id)?.person)?.id);
				//println ":::::::::msg size:::::::"+patientMessages.size()
				render(template:'replyMessages',model:[patientMessages:patientMessages,patientTo:params.patientId,msgGroupId : null]);
			}else{
				redirect controller :'message' ,action :'inbox'
			}
		}catch(Exception exception){
			exception.printStackTrace();
		}
	}

	/**
	 * Reply message
	 * @return
	 */
	def replyMessage(){
		//println ":::::::::::::::::  Inside reply messages   :::::::::::"+session.messageId
		try{
			authorizeMe();
			HealpalUser user = session.user
			if(session.messageId && user){
				def patientMessages
				if(session.isPatient){
					params.to = session.messageId
					messageService.sendMessage(params, user);
					//patientMessages = messageService.getPatientMessages(params.to, Patient.findByPerson(HealpalUser.get(user.id)?.person)?.id);
				}else if(session.isGroup){
					params.groupId = session.messageId
					messageService.sendMessage(params, user);
					//patientMessages = messageService.getPatientGroupMessages(params.groupId);
				}
				//render(template:'replyMessages',model:[patientMessages:patientMessages]);
			}else{
				redirect controller :'message' ,action :'inbox'
			}
		}catch(Exception exception){
			exception.printStackTrace()
		}
	}


	/**
	 * Create a Message group
	 * @return
	 */
	def makeGroup(){
		try{
			authorizeMe();
			HealpalUser user = session.user
			def status = messageService.makeGroup(params, user);
			redirect controller :'patientMatch' ,action :'patientMatch'
		}catch(Exception exception){
			exception.printStackTrace()
		}
	}


	/**
	 * Get all messages for a Group
	 * @return
	 */
	def getGroupMessages(){
		//println "getGroupMessages patient id's >>>>>>> "+params.messageGroupId
		def groupMessagesList
		try{
			authorizeMe();
			HealpalUser user = session.user
			groupMessagesList = messageService.getGroupMessages(params, user);
			render(template:'replyMessages',model:[patientMessages:groupMessagesList,patientTo:null, msgGroupId : params.messageGroupId]);
		}catch(Exception exception){
			exception.printStackTrace()
		}
	}


	/**
	 * Check the chat availability for a particular patient
	 * @param patientId
	 * @return
	 */
	public boolean isChatAvailable(def patientId){
		def isChatEnable = false;
		try{
			authorizeMe();
			HealpalUser user = session.user
			if(patientId != null && !patientId.toString().trim().isEmpty()){
				isChatEnable = messageService.isChatAvailable(patientId, user)
			}
		}catch(Exception exception){
			exception.printStackTrace();
		}
		return isChatEnable;
	}


	/**
	 * Send the chat request to the patient
	 * @return
	 */
	def sendRequest(){
		authorizeMe();
		try{
			HealpalUser user = session.user
			if(params != null && params.patientId != null && params.patientId != ""){
				messageService.sendRequest(params.patientId, user);
			}else{
				//do nothing
			}
		}catch(Exception exception){
			exception.printStackTrace();
		}
		redirect controller :'patientMatch' ,action :'patientMatch'
	}


	/**
	 * Check the patient already send the request for chat or not
	 * @param patientId
	 * @return
	 */
	public boolean isRequestSendAlready(def patientId){
		authorizeMe();
		boolean isRequestSendAlready = false
		try{
			HealpalUser user = session.user
			if(patientId != null && !patientId.toString().trim().isEmpty()){
				isRequestSendAlready = messageService.isRequestSendAlready(patientId, user)
			}
		}catch(Exception exception){
			exception.printStackTrace();
		}
		return isRequestSendAlready;
	}


	/**
	 * Get all the messages and viewed
	 * @return
	 */
	def viewMessage(){
		def patientMessages = null;
		try{
			authorizeMe();
			HealpalUser user = session.user
			if(session.isPatient && session.messageId){
				patientMessages = messageService.getPatientMessages(session.messageId, Patient.findByPerson(HealpalUser.get(user?.id)?.person)?.id);
			}else if(session.isGroup){
				patientMessages = messageService.getPatientGroupMessages(session.messageId);
			}else{
				//do nothing
			}
			[patientMessages:patientMessages]
		}catch(Exception exception){
			exception.printStackTrace()
		}
	}


	/**
	 * Set the session values using ajax
	 * @return
	 */
	def setSessionValues(){
		try{
			authorizeMe();
			if(params.id){
				session.messageId = params.id
			}else{
				//session.messageId = null
			}
			if(params.type){
				if(params.type == "Group"){
					session.isGroup = true
					session.isPatient = false
				}
				if(params.type == "Patient"){
					session.isGroup = false
					session.isPatient = true
				}
			}
			render ""
		}catch(Exception exception){
			exception.printStackTrace()
		}
	}


	/**
	 * Get all messages from database
	 * @return
	 */
	def getAllMessages(){
		try{
			authorizeMe();
			HealpalUser user = session.user
			if(session.messageId && user){
				def patientMessages
				if(session.isPatient && session.messageId){
					patientMessages = messageService.getPatientMessages(session.messageId, Patient.findByPerson(HealpalUser.get(user?.id)?.person)?.id);
				}else if(session.isGroup){
					patientMessages = messageService.getPatientGroupMessages(session.messageId);
				}else{
					//do nothing
				}
				render(template:'getAllMessages',model:[patientMessages:patientMessages]);
			}else{
				//redirect controller :'auth' ,action :'index'
			}
		}catch(Exception exception){
			exception.printStackTrace()
		}
	}


	/**
	 * Check Authorize whether the user is patient or not. If patient allow to access else logout
	 * @return
	 */
	def authorizeMe(){
		if(session.user && session.authority?.equalsIgnoreCase(Role.patient)){
			//do nothing
		}else{
			redirect controller :'auth' ,action :'doLogout'
		}
	}
}
