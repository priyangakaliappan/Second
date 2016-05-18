/*
 * Author      : Arunkumar
 * Project     : Healpal
 * Date        : 11/17/2015
 * Description : Dashboadrd viewing
 *
 * #   Name         Version   Modified-Date      Description
 * -------------------------------------------------------------------------------------
 * 1   Arunkumar    1.0       11/17/2015         Initial Creation
 */

package com.healpal.care

import org.springframework.core.io.ResourceLoader;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import grails.transaction.Transactional
import com.healpal.care.Patient
import com.healpal.care.Person

/**
 * 
 * @author Arunkumar K
 *
 */
@Transactional
class DashboardService implements org.springframework.context.ResourceLoaderAware{
	def ResourceLoader resourceLoader
	def serviceMethod() {
	}

	/**
	 * Get all the patient messages which is not viewed
	 * @param patientId
	 * @return
	 */
	def getPatientMessages(def patientId) throws Exception {
		LinkedHashMap<Patient, List<Message>> messageMap = new LinkedHashMap<Patient, List<Message>>();
		try{
			if(patientId){
				def messageList = Message.createCriteria().list {
					eq("patientByPatientFkReceiver", Patient.get(patientId))
					isNull("messageViewed")
					order("messageSent", "desc")
				}

				if(messageList){
					messageList?.each {
						if(messageMap.containsKey(it?.patientByPatientFkSender)){
							List<Message> arrayList = messageMap.get(it?.patientByPatientFkSender)
							if(arrayList){
								arrayList.add(it);
							}else{
								arrayList = new ArrayList<Message>();
								arrayList.add(it);
							}
							messageMap.put(it?.patientByPatientFkSender, arrayList);
						}else{
							List<Message> arrayList = new ArrayList<Message>();
							arrayList.add(it);
							messageMap.put(it?.patientByPatientFkSender, arrayList);
						}
					}
				}
			}else{
				//do nothing
			}
			return messageMap
		}catch(Exception exception){
			throw exception;
		}
	}
	
	
	def getPatientMessageCount(def patientId) throws Exception {
		LinkedHashMap<Patient, List<Message>> messageMaps = new LinkedHashMap<Patient, List<Message>>();
		try{
			if(patientId){
				def messageList = Message.createCriteria().list {
					eq("patientByPatientFkReceiver", Patient.get(patientId))
					//order("messageViewed" , "desc")
					order("messageSent", "desc")
					
				}

				if(messageList){
					messageList?.each {
						if(messageMaps.containsKey(it?.patientByPatientFkSender)){
							List<Message> arrayList = messageMaps.get(it?.patientByPatientFkSender)
							if(arrayList){
								arrayList.add(it);
							}else{
								arrayList = new ArrayList<Message>();
								arrayList.add(it);
							}
							messageMaps.put(it?.patientByPatientFkSender, arrayList);
						}else{
							List<Message> arrayList = new ArrayList<Message>();
							arrayList.add(it);
							messageMaps.put(it?.patientByPatientFkSender, arrayList);
						}
					}
				}
			}else{
				//do nothing
			}
			
			return messageMaps
		}catch(Exception exception){
			throw exception;
		}
	}


	/**
	 * Get all the patient messages
	 * @param patientId
	 * @return
	 */
	def getAllMessages(def patientId) throws Exception {
		LinkedHashMap<Patient, List<Message>> messageMap = new LinkedHashMap<Patient, List<Message>>();
		try{
			if(patientId){
				def messageList = Message.createCriteria().list {
					eq("patientByPatientFkReceiver", Patient.get(patientId))
					isNull("messageGroup")
					order("messageSent", "desc")
				}

				if(messageList){
					messageList?.each {
						if(messageMap.containsKey(it?.patientByPatientFkSender)){
							List<Message> arrayList = messageMap.get(it?.patientByPatientFkSender)
							if(arrayList){
								arrayList.add(it);
							}else{
								arrayList = new ArrayList<Message>();
							}
							messageMap.put(it?.patientByPatientFkSender, arrayList);
						}else{
							List<Message> arrayList = new ArrayList<Message>();
							arrayList.add(it);
							messageMap.put(it?.patientByPatientFkSender, arrayList);
						}
					}
				}else{
					//do nothing
				}
				
				def messageSentList = Message.createCriteria().list {
					eq("patientByPatientFkSender", Patient.get(patientId))
					isNull("messageGroup")
					order("messageSent", "desc")
				}
				
				messageSentList?.each {
					if(messageMap.containsKey(it?.patientByPatientFkReceiver)){
						//do nothing
					}else{
						List<Message> arrayList = new ArrayList<Message>();
						arrayList.add(it);
						messageMap.put(it?.patientByPatientFkReceiver, arrayList);
					}
				}
				
			}else{
				//do nothing
			}
			return messageMap
		}catch(Exception exception){
			throw exception;
		}
	}

	
	
	/**
	 * @return
	 */
	def getProfileCompletion(def patientId) {
		try
		{
			
		if(patientId!=null)
		{
		def pcd=ProfileCompletionDetail.findByHealpalUser(patientId)
		return pcd;
		}
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
		
	}
	
	
	
	/**
	 * Get the connection list which is not approved
	 * @param patientId
	 * @return
	 */
	def getConnectionList(def patientId) throws Exception {
		def connectionList = null
		try{
			if(patientId){
				connectionList = PatientChat.createCriteria().list {
					eq("patientByPatientFk2", Patient.get(patientId))
					eq("approveRequest", (short)0)
					ne("patientByPatientSendRequest", Patient.get(patientId))
					order("rowCreated", "desc")
				}
			}else{
				//do nothing
			}
			return connectionList
		}catch(Exception exception){
			throw exception;
		}
	}

	/**
	 * @param patientId
	 * @return
	 */
	def getAcceptList(def patientId) throws Exception {
		def acceptList = null
		try{
			 if(patientId)
			{
				 acceptList=PatientChat.createCriteria().list {
					eq("patientByPatientFk1", Patient.get(patientId))
					eq("approveRequest", (short)1)
					ne("patientAcceptRequest", patientId)
					ne("patientAcceptRequest",(long)0)
					isNotNull("rowAltered")
					order("rowCreated", "desc")
				}
			}
			else{
				//do nothing
			}
			return acceptList
		}catch(Exception exception){
			throw exception;
		}
	}
	
	/**
	 * Get the person photo
	 * @param personId
	 * @return
	 * @throws Exception
	 */
	def getPhoto(def personId) throws Exception {
		def photoName = "";
		def getPatientList=null;
		try {
			if(personId!=null && personId!=""){
				def person = Person.get(personId?.toString().toLong());
				//println "person;;;;;;;;;;;;;;;;;"+person
				if(person){
					def patient = Patient.findByPersonAndIsActive(person,Short.valueOf("1"));
					//println "patient;;;;;;;;;;;;;;;"+patient
					if(patient){
						photoName = ProfilePhoto.findByPatientAndIsActive(patient,Short.valueOf("1"))?.profilePhotoPath;
						//println "photoName;;;;;;;;;;;;;;;"+photoName
					}
				}
			}
		} catch(Exception exception) {
			throw exception
		}
		return photoName
	}

	/**
	 * Approve the requested connections
	 * @param user
	 * @param params
	 * @return
	 */
	def approveConnection(HealpalUser user, params) throws Exception {
		try{
			if(user && params.connectionId && params.state){
				Patient patient = Patient.findByPerson(HealpalUser.get(user?.id)?.person)
				if(params.state != null && params.state == "approve" && patient){
					println "inside approve"
					goodwillpointsUpdate(Person.get(user.person?.id))
					PatientChat chat = PatientChat.get(params.connectionId);
					//chat = null;
					//def acceptPatient=chat.patientByPatientFk2.id
					if(chat){
						chat.approveRequest = (short)1
						chat.patientAcceptRequest=chat.patientByPatientFk2.id
						chat.rowAltered = new Date()
						chat.save(flush:true);
						if (!chat.validate()){
							chat.errors.each {println it }
						}else{
							// do nothing
						}
					}
				}else if(params.state != null && params.state == "ignore" && patient){
					 PatientChat.get(params.connectionId)?.delete();
				}
				else if(params.state != null && params.state == "ok" && patient){
					/*PatientMedicalCondition.executeUpdate("delete from PatientMedicalCondition p where p.patient="+patient?.id);*/
					def patientAcceptRequestId= PatientChat.get(params.connectionId)
					println "patientAcceptRequestId;;;;;;;;;;;;;;"+patientAcceptRequestId
					if(patientAcceptRequestId)
					{
						println "inside if loop"
						PatientChat patientChat=patientAcceptRequestId 
						patientChat.patientAcceptRequest=0
					}
				}
				else{
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
	 * @param personId
	 * @return
	 * @throws Exception
	 */
	def goodwillpointsUpdate(def person) throws Exception {
		try {
			println "inside goodwillpoints"+person
			if(person)
				println "personId"+person
			person.goodWillPoints=person.goodWillPoints
			person.save(flush:true)
		} catch(Exception exception) {
			throw exception;
		}
	}

	/**
	 * Update the message as viewed
	 * @param messageId
	 * @return
	 */
	def updateMessage(def patientId, def loginPatientId) throws Exception {
		try{
			if(patientId != null && patientId != "" && loginPatientId != null && loginPatientId != ""){
				def messageList = Message.createCriteria().list {
					and {
						eq('patientByPatientFkReceiver', Patient.get(loginPatientId))
						eq('patientByPatientFkSender', Patient.get(patientId))
					}
					isNull('messageViewed')
				}
				if(messageList){
					messageList.each {
						Message message = it;
						if(message){
							message.messageViewed = new Date();
							message.rowAltered = new Date();
							message.save(flush:true);
							if (!message.validate()){
								message.errors.each {println it }
							}else{
								// do nothing
							}
						}else{
							//do nothing
						}
					}
				}
			}else{
				//do nothing
			}
		}catch(Exception exception){
			throw exception;
		}
	}

	/**
	 * Get the message list for a patient
	 * @param patientId
	 * @param loginPatient
	 * @return
	 */
	def getMessageList(def patientId, def loginPatient) throws Exception {
		def messageList = null;
		try{
			if(patientId && loginPatient){
				messageList = Message.createCriteria().list {
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
					order('rowCreated','asc')
				}
			}
			return messageList;
		} catch(Exception exception) {
			throw exception;
		}
	}


	/**
	 * Send message
	 * @param params
	 * @param user
	 * @return
	 * @throws Exception
	 */
	def sendMessage(params, HealpalUser user) throws Exception {
		Message msg = null;
		try{
			if(user && params && params.message && (params.patientId || params.groupId)){
				Message message 						= 	new Message();
				Patient patient 						= 	Patient.findByPerson(user?.person);
				message.patientByPatientFkSender 		= 	patient;
				if(params.patientId){
					message.patientByPatientFkReceiver 	= 	Patient.get(params.patientId);
				}else if(params.groupId){
					message.messageGroup 				= 	MessageGroup.get(params.groupId)
				}
				message.messageText			 	 		= 	params.message?.toString().trim();
				message.isActive			  			=	(short)1;
				message.messageCreated        			=  	new Date();
				message.readReceiptRequested  			=  	(short)0
				message.rowCreated            			=  	new Date();
				message.messageSent           			=  	new Date();
				msg  									=  	message.save(flush:true);

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
		}catch(Exception exception){
			throw exception;
		}
		return msg;
	}

	/**
	 * Get message group list
	 * @param patientId
	 * @return
	 */
	def getGroupList(def patientId) throws Exception {
		def groupList = null;
		try{
			if(patientId){
				groupList = newMessageFromGroup(patientId)
			}else{
				//do nothing
			}
			return groupList;
		}catch(Exception exception){
			throw exception;
		}
	}
	
	
	/**
	 * Get message group list
	 * @param patientId
	 * @return
	 */
	def getAllGroupList(def patientId) throws Exception {
		def groupList = null;
		try{
			if(patientId){
				//groupList = PatientMessageGroup.findAllByPatient(Patient.get(patientId))//?.messageGroup
				groupList = PatientMessageGroup.createCriteria().list{
					eq('patient',Patient.get(patientId))
					order('rowCreated', 'desc')
				}
			}else{
				//do nothing
			}
			
			return groupList;
		}catch(Exception exception){
			throw exception;
		}
	}
	/**
	 * Get all groups of patient
	 * @param patientId
	 * @param loginPatient
	 * @return
	 */
	def getAllGroups(def patientId,params) throws Exception {
		def groupList = null;
		Set<MessageGroup> msgGroups = new LinkedHashSet<MessageGroup>();
		try{
			if(patientId){
				groupList = PatientMessageGroup.createCriteria().list{
					eq('patient',Patient.get(patientId))
					if(params.searchValue!=null && params.searchValue !="" && params.searchValue!='undefined'){
					messageGroup{
						ilike('messageGroupName',"%"+params.searchValue+"%")}}
					order('rowCreated', 'desc')
				}
				if(groupList.size()>0){
					def msg = Message.createCriteria().list{
						'in'('messageGroup',groupList?.messageGroup)
						order('rowCreated','desc')
					}
					Set<Long> ids = new LinkedHashSet<Long>();
					msg.each{ids.add(it.messageGroup?.id);}
					groupList.each{
						ids.add(it.messageGroup?.id);
					}
					ids.each{msgGroups.add(MessageGroup.get(it))}
					return msgGroups
				}else{
					return groupList
				}
			}else{
				//do nothing
			}

		}catch(Exception exception){
			throw exception;
		}
	}
	
	/**
	 * Get all the new Group Messages
	 * @param patientId
	 * @return
	 */
	def newMessageFromGroup(def patientId) throws Exception {
		ArrayList<MessageGroup> groupList = new ArrayList<MessageGroup>();
		try{
			if(patientId){
				def groupMessageList = PatientMessageGroup.findAllByPatient(Patient.get(patientId))
				if(groupMessageList != null && groupMessageList.size() > 0){
					groupMessageList?.each {
						//println ":::::::::::::MessageGroup>>>>>>>>>>>>>>>>>>>>>"+it?.messageGroup?.id
						MessageGroup msgGrp = it?.messageGroup
						def messageList = Message.createCriteria().list {
							eq('messageGroup', msgGrp)
							ne('patientByPatientFkSender', Patient.get(patientId))
							order('rowCreated', 'desc')
						}
						if(messageList != null && messageList.size() > 0){
							def patientViewGroupMessage = PatientViewGroupMessage.findByMessageAndPatient(messageList?.get(0), Patient.get(patientId))
							if(!patientViewGroupMessage){
								groupList.add(msgGrp);
							}else{
								//do nothing
							}
						}else{
							//do nothing
						}
						//println ":MessageList>>>>>>>>>>>>>>>>>>>>>>>>"+messageList
					}
				}else{
					//do nothing
				}
			}else{
				//do nothing
			}
			return groupList;
		}catch(Exception exception){
			throw exception;
		}
	}
	

	/**
	 * View group messages
	 * @param messageGroupId
	 * @return
	 * @throws Exception
	 */
	def viewGroupMessage(def messageGroupId) throws Exception {
		def groupMessageList = null;
		try{
			if(messageGroupId){
				MessageGroup msgGrp = MessageGroup.get(messageGroupId)
				groupMessageList = Message.createCriteria().list {
					eq("messageGroup", msgGrp)
					order("messageCreated", "asc")
				}
			}else{
				//do nothing
			}
			return groupMessageList;
		}catch(Exception exception){
			throw exception;
		}
	}
	
	
	/**
	 * Update the Group message viewed status
	 * @param patientId
	 * @return
	 */
	def updatePatientViewGroupMessage(def msgGrpId, def patientId) throws Exception {
		try{
			if(patientId && msgGrpId){
				def messageList = Message.createCriteria().list {
					ne('patientByPatientFkSender', Patient.get(patientId))
					eq('messageGroup', MessageGroup.get(msgGrpId))
				}
				
				messageList?.each {
					def patientViewGroupMessage = PatientViewGroupMessage.findByPatientAndMessage(Patient.get(patientId), it)
					if(!patientViewGroupMessage){
						patientViewGroupMessage 				= 	new PatientViewGroupMessage();
						patientViewGroupMessage.patient 		= 	Patient.get(patientId);
						patientViewGroupMessage.message			=	it;
						patientViewGroupMessage.messageViewed	=	new Date();
						patientViewGroupMessage.save(flush:true);
						
						if (!patientViewGroupMessage.validate()){
							patientViewGroupMessage.errors.each {println it }
						}else{
							// do nothing
						}
					}
				}
			}else{
				//do nothing
			}
		}catch(Exception exception){
			throw exception;
		}
	}
	
	def static isReadMessge(def msgGroupId, HealpalUser user) throws Exception {
		boolean isRead = true;
		try{
			if(msgGroupId && user){
				def messageList = Message.createCriteria().list {
					eq("messageGroup", MessageGroup.get(msgGroupId))
					order("rowCreated", "asc")
				}
				
				if(messageList){
					if(messageList?.get(0)?.patientByPatientFkSender?.id != Patient.findByPerson(user?.person)?.id){
						def messageViewed = PatientViewGroupMessage.findByPatientAndMessage(Patient.findByPerson(user?.person), messageList?.get(0));
						println "::::::::::messageViewed::::::::::::::::"+messageViewed
						if(!messageViewed){
							isRead = false;
						}else{
						//	do nothing
						}
					}else{
						//do nothing
					}
				}
			}else{
				//do nothing
			}
			return isRead;
		}catch(Exception exception){
			throw exception;
		}
	}
	def getGroupMessages(def patientId) throws Exception {
		try{
			LinkedHashMap<MessageGroup, List<Message>> messageMap = new LinkedHashMap<MessageGroup, List<Message>>();
			def group = newMessageFromGroup(patientId)
			if(group){
				for(int j=0;j<group?.size();j++){
					List<Message> test =  new ArrayList<Message>();
					MessageGroup msg = MessageGroup.get(group[j]?.id)
					def messages = Message.createCriteria().list {
						eq('messageGroup',msg)
						order('rowCreated', 'desc')
						ne('patientByPatientFkSender',Patient.get(patientId))
					}
					for(int i=0;i<messages?.size();i++){
						def check = PatientViewGroupMessage.createCriteria().list{
							eq('message',Message.get(messages[i]?.id))
							eq('patient',Patient.get(patientId))
						}
						if(!check){
							test.add(messages[i])
						}
					}
					messageMap.put(msg, test);
				}//group
			}//if
			return messageMap
		}catch(Exception exception){
			throw exception;
		}
	}
	def searchPatients(def patientId,params,List connectedperson) throws Exception {
		LinkedHashMap<Patient, List<Message>> messageMaps = new LinkedHashMap<Patient, List<Message>>();
		try{
			if(patientId){
				def messageList = Message.createCriteria().list
				{
					or{
						and{
							eq("patientByPatientFkReceiver", Patient.get(patientId))
							patientByPatientFkSender{
								person{
									ilike("fullName","%"+params.searchValue+"%")}
							}
						}
						and{
							eq("patientByPatientFkSender", Patient.get(patientId))
							isNull("messageGroup")
							patientByPatientFkReceiver{
								person{
									ilike("fullName","%"+params.searchValue+"%")}
							}
						}
					}
					order("messageSent", "desc")
				}
				def sender
				if(messageList){
					messageList?.each {
						if(it?.patientByPatientFkSender?.id == Patient.get(patientId)?.id)
						{
							sender = it?.patientByPatientFkReceiver
						}else
						{
							sender = it?.patientByPatientFkSender
						}
						if(messageMaps.containsKey(sender)){
							List<Message> arrayList = messageMaps.get(sender)
							if(arrayList){
								arrayList.add(it);
							}else{
								arrayList = new ArrayList<Message>();
								arrayList.add(it);
							}
							messageMaps.put(sender, arrayList);
						}else{
							List<Message> arrayList = new ArrayList<Message>();
							arrayList.add(it);
							messageMaps.put(sender, arrayList);
						}
					}
				}
				if(connectedperson.size()>0 && params.searchValue !=""){
					connectedperson.each{
						def patientid = it?.id
						def searchPerson = Patient.createCriteria().list{
							eq('id',patientid)
							person{
								ilike("fullName","%"+params.searchValue+"%")
							}
						}
						if(searchPerson.size()>0){
							messageMaps.put(it, new ArrayList<Message>());
						}
					}
				}
			}else{
				//do nothing
			}
			return messageMaps
		}catch(Exception exception){
			throw exception;
		}
	}
	def searchGroups(def patientId,params) throws Exception {
		def groupList = null;
		Set<MessageGroup> msgGroups = new LinkedHashSet<MessageGroup>();
		try{
			if(patientId){
				groupList = PatientMessageGroup.createCriteria().list {
					eq('patient',Patient.get(patientId))
					messageGroup{
						ilike('messageGroupName',"%"+params.searchValue+"%")}
					order('rowCreated','desc')
				}
				if(groupList.size()>0){
					def msg = Message.createCriteria().list{
						'in'('messageGroup',groupList?.messageGroup)
						order('rowCreated','desc')
						}
					Set<Long> ids = new LinkedHashSet<Long>();
					msg.each{ids.add(it.messageGroup?.id);}
					ids.each{msgGroups.add(MessageGroup.get(it))}
				return msgGroups
				}
				else{
					return groupList
				}
			}else{
				//do nothing
			}
		}catch(Exception exception){
			throw exception;
		}
	}
	/**
	 * Get all the patient messages
	 * @param patientId
	 * @return
	 */
	def getPatientMessage(def patientId) throws Exception {
		LinkedHashMap<Patient, List<Message>> messageMaps = new LinkedHashMap<Patient, List<Message>>();
		try{
			def sender;
			if(patientId){
				def messageList = Message.createCriteria().list {
					or{
						and{
							eq("patientByPatientFkReceiver", Patient.get(patientId))
						}
						and{
							eq("patientByPatientFkSender", Patient.get(patientId))
							isNull("messageGroup")
						}
					}
					order("messageSent", "desc")
				}
				if(messageList){
					messageList?.each {

						if(it?.patientByPatientFkSender?.id == Patient.get(patientId)?.id)
						{
							sender = it?.patientByPatientFkReceiver
						}else
						{
							sender = it?.patientByPatientFkSender
						}
						if(messageMaps.containsKey(sender)){
							List<Message> arrayList = messageMaps.get(sender)
							if(arrayList){
								arrayList.add(it);
							}else{
								arrayList = new ArrayList<Message>();
								arrayList.add(it);
							}
							messageMaps.put(sender, arrayList);
						}else{
							List<Message> arrayList = new ArrayList<Message>();
							arrayList.add(it);
							messageMaps.put(sender, arrayList);
						}
					}
				}
			}else{
				//do nothing
			}
			return messageMaps
		}catch(Exception exception){
			throw exception;
		}
	}
	/**
	 * Get connected members
	 * @param user
	 * @param params
	 * @return
	 */
	def connectionList(def patientId) throws Exception {
		LinkedHashMap<Patient, List<Message>> messageMaps = new LinkedHashMap<Patient, List<Message>>();
		try{
			List messagedPatient = new ArrayList()
			List connectedPatients = new ArrayList()
			def sender
			def chatList = PatientChat.createCriteria().list() {
				or{
					and{
						eq('patientByPatientFk2', Patient.get(patientId))
					}
					and{
						eq('patientByPatientFk1', Patient.get(patientId))
					}
				}
				order("rowCreated", "desc")
			}
			def messageList = Message.createCriteria().list {
				or{
					and{
						eq("patientByPatientFkReceiver", Patient.get(patientId))
					}
					and{
						eq("patientByPatientFkSender", Patient.get(patientId))
						isNull("messageGroup")
					}
				}
				order("messageSent", "desc")
			}
			messageList.each{
				if(it?.patientByPatientFkSender?.id == Patient.get(patientId)?.id)
				{
					sender = it?.patientByPatientFkReceiver
				}else{
					sender = it?.patientByPatientFkSender}
				if(!messagedPatient.contains(sender)){
					messagedPatient.add(sender)}
			}
			for(int i=0;i<chatList.size();i++)
			{
				if(chatList[i]?.patientByPatientFk1 != Patient.get(patientId) || chatList[i]?.patientByPatientFk2 !=Patient.get(patientId)){
					if(!messagedPatient.contains(chatList[i]?.patientByPatientFk1) || !messagedPatient.contains(chatList[i]?.patientByPatientFk2) )
					{
						if(!connectedPatients.contains(chatList[i]?.patientByPatientFk1))
						{
							connectedPatients.add(chatList[i]?.patientByPatientFk1)
						}
						if(!connectedPatients.contains(chatList[i]?.patientByPatientFk2))
						{
							connectedPatients.add(chatList[i]?.patientByPatientFk2)
						}
					}
				}
			}
			if(connectedPatients.contains(Patient.get(patientId)))
			{
				connectedPatients.remove(Patient.get(patientId))
			}
			return connectedPatients
		}catch(Exception exception){
			throw exception;
		}
	}
	
	
	static def getPhoto(HealpalUser user){
		try{
			return ProfilePhoto.findByPatient(Patient.findByPerson(user?.person))?.profilePhotoPath
		}catch(Exception ex){
			ex.printStackTrace()
		}
	}
	void shareLink(def recipients,params){
		try{
		List<String> list1 = new ArrayList<String>();
		list1 = recipients
		if(recipients && recipients!=null && !recipients.isEmpty()){
		def content='<head></head><body><table width="100%" bgcolor="#fff" cellpadding="0" cellspacing="0" border="0" id="backgroundTable" st-sortable="header">'+
						'<tbody><tr><td<table width="860" cellpadding="0" cellspacing="0" border="0" align="center" class="devicewidth"><tbody><tr><td width="100%">'+
						'<table width="860" cellpadding="0" cellspacing="0" border="0" align="center" class="devicewidth" bgcolor="#f0eeee" id="mobile-device">'+
						'<tbody><tr><td><table bgcolor="#f0eeee" width="100%" align="center" border="0" cellpadding="0" cellspacing="0" class="devicewidth">'+
						'<tbody><tr><td width="100%" height="30px" align="center" style="padding:20px 0px 0px; font-size:11px; color:#a0a0a0; text-decoration:underline;">'+
						'<div class="text-center"><a target="_blank" href="#"><img src="cid:Logo" alt="" border="0" style="display:block;'+
						' border:none; outline:none; text-decoration:none; text-align:center; margin:14px 0px;"></a></div></td></tr><tr><td width="100%">'+
						'<table id="mobile-device" bgcolor="#fff" width="600" align="center"  bordercolor="#d7d7d7" cellpadding="0" cellspacing="0" class="devicewidth">'+
						'<tbody><tr><td height="100%" width="600"  align="left" style="border:1px solid #d7d7d7; font-size:14px; line-height:20px; color:#484848; padding:20px; font-weight:normal;  font-family:Arial;">'+
						'Hi All, <br/> <br/>'+params.body+
						'<br/><br/><br/>Thanks,<BR/>The HealPal Team</td></tr></tbody></table></td></tr><tr><td width="100%">'+
						'<table bgcolor="#f0eeee" width="600" align="center"  cellpadding="0" cellspacing="0" class="devicewidth">'+
						'<tbody><tr><td align="center">	<div class="text-center"><a href="#"><img src="cid:fb" align="center" alt="image" border="0" style="display:inline-block; border:none; outline:none; text-decoration:none; text-align:center; margin:10px 5px 5px;">'+
						'</a><a href="#"><img src="cid:linkedin" align="center" alt="image" border="0" style="display:inline-block; border:none; outline:none; text-decoration:none; text-align:center; margin:10px 5px 5px;">'+
						'</a><a href="#"><img src="cid:pinterest" align="center" alt="image" border="0" style="display:inline-block; border:none; outline:none; text-decoration:none; text-align:center; margin:10px 5px 5px;"></a><a href="#">'+
						'<img src="cid:twitter" align="center" alt="image" border="0" style="display:inline-block; border:none; outline:none; text-decoration:none; text-align:center; margin:10px 5px 5px;"></a><p style="font-size:12px; color:#8f8f8f; line-height:20px; margin-top:0px;">'+
						'We value your privacy and will never share your email without your permission.</p><p style="font-size:12px; color:#5a5a5a">©2016 HealPal Inc. All rights reserved.</p></div><br/></td></tr></tbody></table></td></tr></tbody></table></td></tr></tbody></table></td></tr></tbody></table></body>'
				sendMail {
						multipart true
						to list1
						subject params.subject
						html content
						inline 'Logo', 'image/png', resourceLoader.getResource("/assets/new-design/img/logo.png").getFile()
						inline 'fb', 'image/png', resourceLoader.getResource("/assets/new-design/img/fb-icon.png").getFile()
						inline 'linkedin', 'image/png', resourceLoader.getResource("/assets/new-design/img/linkedin-icon.png").getFile()
						inline 'pinterest', 'image/png', resourceLoader.getResource("/assets/new-design/img/pinterest-icon.png").getFile()
						inline 'twitter', 'image/png', resourceLoader.getResource("/assets/new-design/img/twitter-icon.png").getFile()
							}
		
		}
		}catch(Exception exception){
		throw exception
		}
		
		
	}
	def getEmailList(params){
		try{
			return Email.createCriteria().list(params) {
				if(params.sort == null && params.order == null){
					order('rowCreated','desc')
				}
				if(params.searchValue != null && params.searchValue != ""){
					or{
						and{ilike("subject","%"+params.searchValue+"%")}
						and{ilike("bodyText","%"+params.searchValue+"%")}}
				}
			}
		}catch(Exception exception){
			exception.printStackTrace()
		}
	}
	def getMailSearchCount(params){
		try{
			return Email.createCriteria().list() {
				if(params.searchValue != null && params.searchValue != ""){
					or{
						and{ilike("subject","%"+params.searchValue+"%")}
						and{ilike("bodyText","%"+params.searchValue+"%")}
						}
					}
				}?.size()
		}catch(Exception exception){
			exception.printStackTrace()
		}
	}
}
