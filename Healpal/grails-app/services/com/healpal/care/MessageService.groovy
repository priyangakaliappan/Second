/*
 * Author      : Arunkumar K
 * Project     : Healpal
 * File        : MessageService
 * Date        : 23-10-2015
 * Description : New Message, Create a Group, Reply Message, Show all messages
 *
 * #   Name           Version           Modified-Date      Description
 * -------------------------------------------------------------------------------------
 * 1   Arunkumar K    1.0               23-10-2015         Initial Creation
 *
 */
package com.healpal.care

import com.healpal.encryptdecrypt.CryptographyUtil;
import grails.orm.HibernateCriteriaBuilder
/**
 * 
 * @author Arunkumar K
 *
 */
class MessageService {

	def serviceMethod() {
	}
	

	/**
	 * Send message
	 * @param params
	 * @param user
	 * @return
	 * @throws Exception
	 */
	def sendMessage(params, HealpalUser user)throws Exception{
		Message msg = null;
		try{
			if(user && params && params.message){
				user = HealpalUser.get(user.id)
				def mailMessage = params.message;
				def to = params.to
				def msgGrpId = params.groupId
				//println "patientId::::::::::::"+to
				if(mailMessage != null && !mailMessage.equals("")
				&& ((to != null && !to.trim().equals(""))
				|| (msgGrpId != null && !msgGrpId.trim().equals("")))){

					Message message = new Message();
					Patient patient = Patient.findByPerson(user?.person);
					//println "patient::::::::::::::::::::::::"+patient
					message.patientByPatientFkSender = patient;
					if(params.to){
						message.patientByPatientFkReceiver = Patient.get(params.to);
					}
					message.messageText= checkNull(CryptographyUtil.encrypt(mailMessage));
					message.isActive=(short)1;
					if(params.groupId){
						message.messageGroup = MessageGroup.get(params.groupId)
					}
					message.messageCreated        =  new Date();
					message.readReceiptRequested  =  (short)0
					message.rowCreated            =  new Date();
					message.messageSent           =  new Date();
					msg  =  message.save();
					if (!message.validate()){
						message.errors.each {println it }
					}else{
						// do nothing
					}
					if(	msg != null ){
						println("Message Inserted");
					}else{
						println("Message Not Inserted");
					}
				}else{
					//do nothing
				}
			}else{
				//do nothing
			}
		}catch(Exception exception){
			throw exception;
		}
		return msg;
	}
	

	/**
	 * Check the given string is null or not
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public String checkNull(String data) throws Exception {
		try{
			if(data!= null){
				return data;
			}else{
				return "";
			}
		}catch(Exception exception){
			throw exception;
		}
	}

	
	/**
	 * Get the messages for current user
	 * @param user
	 * @return
	 */
	def getInboxMessages(HealpalUser user){
		def inboxList = null;
		Map<Patient, ArrayList<Message>> map = new HashMap<Patient, ArrayList<Message>>();
		try{
			if(user){
				inboxList = Message.createCriteria().list {
					eq('patientByPatientFkReceiver', Patient.findByPerson(user?.person))
					order('rowCreated','asc')
				}
				//println "::::::::::::::::::::::::Inbox list size :::::::::::::: "+inboxList.size()
				inboxList.each {
					if(map.containsKey(it?.patientByPatientFkSender)){
						ArrayList<Message> list = (ArrayList<Message>)map.get(it?.patientByPatientFkSender)
						list.add(it);
						map.put(it?.patientByPatientFkSender, list);
					}else{
						ArrayList<Message> list = new ArrayList<Message>();
						list.add(it);
						map.put(it?.patientByPatientFkSender, list);
					}
				}
			}else{
				return map;
			}
			return map;
		}catch(Exception exception){
			throw exception;
		}
	}


	/**
	 * Get the patient messages
	 * @param patientId
	 * @param loginPatient
	 * @return
	 */
	def getPatientMessages(def patientId, def loginPatient){
		def inboxList = null;
		try{
			if(patientId){
				inboxList = Message.createCriteria().list {
					or {
						and{
							eq('patientByPatientFkReceiver', Patient.get(patientId))
							eq('patientByPatientFkSender', Patient.get(loginPatient))
						}

						and {
							eq('patientByPatientFkReceiver', Patient.get(loginPatient))
							eq('patientByPatientFkSender', Patient.get(patientId))
						}
					}
					//isNull("messageViewed")
					order('rowCreated','asc')
				}
			}else{
				//do nothing
			}
			return inboxList;
		}catch(Exception exception){
			throw exception;
		}
	}

	
	/**
	 * Make a message group and store the patients to the group
	 * @param params
	 * @param user
	 * @return
	 */
	def makeGroup(params, HealpalUser user){
		try{
			if(user && params && params.patientIds){
				def patientIds = params.patientIds
				if(patientIds){
					def groupName = ""
					patientIds.each {
						groupName = groupName +" "+ Patient.get(it)?.person?.firstName
					}
					if(Patient.findByPerson(user?.person)){
						groupName = user?.person?.firstName +" "+ groupName
					}
					MessageGroup group 		= 	new MessageGroup();
					group.messageGroupName 	= 	groupName
					group.isActive			=	(short)1;
					group.rowCreated		=	new Date();
					
					def msgGroup = group.save(flush:true)
					if (!group.validate()){
						group.errors.each {println it }
					}else{
						patientIds.each {
							PatientMessageGroup patientMsgGrp = new PatientMessageGroup()
							patientMsgGrp.messageGroup 	=	msgGroup
							patientMsgGrp.patient 		=	Patient.get(it)
							patientMsgGrp.isActive		=	(short)1;
							patientMsgGrp.rowCreated	=	new Date();
							
							patientMsgGrp.save(flush:true)
							if (!patientMsgGrp.validate()){
								patientMsgGrp.errors.each {println it }
							}else{
								//do nothing
							}
						}

						PatientMessageGroup patientMsgGrp = new PatientMessageGroup()
						patientMsgGrp.messageGroup 		= 	msgGroup
						patientMsgGrp.patient 			= 	Patient.findByPerson(HealpalUser.get(user?.id)?.person)
						patientMsgGrp.isActive			=	(short)1;
						patientMsgGrp.rowCreated		=	new Date();
						
						patientMsgGrp.save(flush:true)
						if (!patientMsgGrp.validate()){
							patientMsgGrp.errors.each {println it }
						}else{
							//do nothing
						}
					}
				}else{
					//do nothing
				}
			}else{
				//do nothing
			}
		}catch(Exception exception){
			throw exception;
		}
	}


	/**
	 * Get the Message Group list for current user
	 * @param user
	 * @return
	 */
	def getGroupList(HealpalUser user){
		def messageGroupList = null;
		try{
			if(user){
				messageGroupList = PatientMessageGroup.findAllByPatient(Patient.findByPerson(HealpalUser.get(user.id)?.person))
			}else{
				//do nothing
			}
			return messageGroupList;
		}catch(Exception exception){
			throw exception;
		}
	}


	/**
	 * Get the group messages
	 * @param params
	 * @param user
	 * @return
	 */
	def getGroupMessages(params, HealpalUser user){
		def groupMessagesList = null;
		try{
			if(user && params && params.messageGroupId){
				groupMessagesList = Message.createCriteria().list {
					eq("messageGroup",MessageGroup.get(params.messageGroupId))
					order("rowCreated", "asc")
				}
			}else{
				//do nothing
			}
			return groupMessagesList
		}catch(Exception exception){
			throw exception;
		}
	}


	/**
	 * Get the patient group messages
	 * @param groupId
	 * @return
	 */
	def getPatientGroupMessages(def groupId){
		def groupMessagesList = null;
		try{
			if(groupId){
				groupMessagesList = Message.createCriteria().list {
					eq("messageGroup",MessageGroup.get(groupId))
					order("rowCreated", "asc")
				}
			}else{
				//do nothing
			}
			return groupMessagesList
		}catch(Exception exception){
			throw exception;
		}
	}
	
	
	/**
	 * Check the patient has rights to chat or not 
	 * @param patientId
	 * @param user
	 * @return
	 */
	public boolean isChatAvailable(def patientId, HealpalUser user){
		boolean isChatEnable = false
		try{
			if(patientId && user){
				def patientList = PatientChat.createCriteria().list {
					or {
						and{
							eq('patientByPatientFk1', Patient.findByPerson(HealpalUser.get(user?.id)?.person))
							eq('patientByPatientFk2', Patient.get(patientId))
						}

						and {
							eq('patientByPatientFk1', Patient.get(patientId))
							eq('patientByPatientFk2', Patient.findByPerson(HealpalUser.get(user?.id)?.person))
						}
					}
					eq("approveRequest", (short)1)
				}
				if(patientList != null && patientList?.size() > 0){
					isChatEnable = true
				}else{
					//do nothing
				}
			}else{
				//do nothing
			}
		}catch(Exception exception){
			throw exception;
		}
		return isChatEnable
	}
	
	
	/**
	 * Check the patient already send request or not
	 * @param patientId
	 * @param user
	 * @return
	 */
	public boolean isRequestSendAlready(def patientId, HealpalUser user){
		boolean isRequestSentAlready = false
		try{
			if(patientId && user){
				def patientList = PatientChat.createCriteria().list {
					or {
						and{
							eq('patientByPatientFk1', Patient.get(patientId))
							eq('patientByPatientSendRequest', Patient.findByPerson(HealpalUser.get(user?.id)?.person))
						}

						and {
							eq('patientByPatientSendRequest', Patient.findByPerson(HealpalUser.get(user?.id)?.person))
							eq('patientByPatientFk2', Patient.get(patientId))
						}
					}
					eq("approveRequest", (short)0)
				}
				if(patientList != null && patientList?.size() > 0){
					isRequestSentAlready = true
				}else{
					//do nothing
				}
			}else{
				//do nothing
			}
		}catch(Exception exception){
			throw exception;
		}
		return isRequestSentAlready
	}
	
	
	/**
	 * Store the patient request into PatientChat table
	 * @param patientId
	 * @param user
	 * @return
	 */
	def sendRequest(def patientId, HealpalUser user){
		try{
			if(patientId && user){
				def patientChatList = PatientChat.createCriteria().list {
					or {
						and{
							eq('patientByPatientFk1', Patient.get(patientId))
							eq('patientByPatientFk2', Patient.findByPerson(HealpalUser.get(user?.id)?.person))
						}

						and {
							eq('patientByPatientFk1', Patient.findByPerson(HealpalUser.get(user?.id)?.person))
							eq('patientByPatientFk2', Patient.get(patientId))
						}
					}
				}
				
				if(patientChatList == null || patientChatList?.size() == 0){
					PatientChat patientChat          			=	new PatientChat();
					patientChat.patientByPatientFk1  			=	Patient.findByPerson(HealpalUser.get(user?.id)?.person)
					patientChat.patientByPatientFk2  			=	Patient.get(patientId)
					patientChat.patientByPatientSendRequest  	=	Patient.findByPerson(HealpalUser.get(user?.id)?.person)
					patientChat.isActive             			=	(short)1;
					patientChat.rowCreated           			=	new Date();
					patientChat.approveRequest		 			=	(short)0;
					
					patientChat.save(flush:true)
					goodwillpointsUpdate(Person.get(user.person?.id))
					if (!patientChat.validate()){
						patientChat.errors.each {println it }
					}else{
						// do nothing
					}
				}else{
					log.info("MessageService-sendRequest() : The patient already has a connection");
				}
			}else{
				//do nothing
			}
		}catch(Exception exception){
			throw exception;
		}
	}
	
	/**
	 * @param personId
	 * @return
	 * @throws Exception
	 */
	def goodwillpointsUpdate(def person)throws Exception
	{
		try
		{
			if(person){
				println "inside goodwillpoints"+person
			    println "personId"+person
				if(person.goodWillPoints == null || person.goodWillPoints == ""){
					person.goodWillPoints = 0;
				}else{
				  //do nothing
				}
				person.goodWillPoints=person.goodWillPoints + 200
				person.save(flush:true)
			}
		}
		catch(Exception exception)
		{
			throw exception;
		}
	}
}
