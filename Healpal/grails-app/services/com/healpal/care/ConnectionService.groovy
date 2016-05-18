/*
 * Author      : Arunkumar K
 * Project     : Healpal
 * File        : ConnectionService
 * Date        : 13-11-2015
 * Description : Get connection list, send message to a connection, remove connection
 *
 * #   Name           Version           Modified-Date      Description
 * -------------------------------------------------------------------------------------
 * 1   Arunkumar K    1.0               13-11-2015         Initial Creation
 *
 */

package com.healpal.care

import grails.transaction.Transactional
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.codehaus.groovy.grails.web.context.ServletContextHolder
/**
 * 
 * @author Arunkumar K
 *
 */
@Transactional
class ConnectionService {

	def serviceMethod() {
	}

	/**
	 * Get the message list
	 * @param user
	 * @return
	 */
	def getMessageList(HealpalUser user)throws Exception{
		def messageList
		try{
			if(user?.person){
				messageList = Message.createCriteria().list {
					eq("patientByPatientFkReceiver",Patient.findByPerson(user?.person))
					isNull("messageViewed")
					order("messageCreated", "asc")
				}
			}else{
				//do nothing
			}
		}catch(Exception exception){
			throw exception;
		}
		return messageList;
	}

	/**
	 * Get all the connections for the current user
	 * @param user
	 * @return
	 */
	def getConnectionList(HealpalUser user, params)throws Exception{
		ArrayList<Patient> connectionList = new ArrayList<Patient>();
		try{
			if(user?.person && params){
				def chatList = PatientChat.createCriteria().list(params) {
					or{
						eq('patientByPatientFk1', Patient.findByPerson(user?.person))
						eq('patientByPatientFk2', Patient.findByPerson(user?.person))
					}
					eq("approveRequest",(short)1)
					order("rowCreated", "desc")
				}
				chatList?.each {
					if(Patient.findByPerson(user?.person)?.id == it?.patientByPatientFk1?.id){
						connectionList.add(it?.patientByPatientFk2)
					}else{
						 connectionList.add(it?.patientByPatientFk1)
					}
				}
			}else{
				//do nothing
			}
		}catch(Exception exception){
			throw exception;
		}
		return connectionList;
	}
	
	
	/**
	 * Get Total connection list
	 * @param user
	 * @return
	 */
	def getTotalConnectionList(HealpalUser user){
		ArrayList<Patient> connectionList = new ArrayList<Patient>();
		try{
			if(user?.person){
				def chatList = PatientChat.createCriteria().list {
					or{
						eq('patientByPatientFk1', Patient.findByPerson(user?.person))
						eq('patientByPatientFk2', Patient.findByPerson(user?.person))
					}
					eq("approveRequest",(short)1)
				}
				chatList?.each {
					if(Patient.findByPerson(user?.person)?.id == it?.patientByPatientFk1?.id){
						connectionList.add(it?.patientByPatientFk2)
					}else{
						connectionList.add(it?.patientByPatientFk1)
					}
				}
			}else{
				//do nothing
			}
		}catch(Exception exception){
			throw exception;
		}
		return connectionList;
	}


	/**
	 * Remove the particular connection
	 * @param patientId
	 * @param user
	 * @return
	 */
	def removeConnection(def patientId, HealpalUser user)throws Exception{
		try{
			if(patientId && user?.person){
				def chatList = PatientChat.createCriteria().list {
					or{
						and{
							eq('patientByPatientFk1', Patient.findByPerson(user?.person))
							eq('patientByPatientFk2', Patient.get(patientId))
						}

						and{
							eq('patientByPatientFk1', Patient.get(patientId))
							eq('patientByPatientFk2', Patient.findByPerson(user?.person))
						}
					}
				}
				if(chatList != null && chatList?.size() > 0){
					def patientChat = chatList.get(0)
					if(patientChat){
						PatientChat.get(patientChat?.id)?.delete()
					}else{
						//do nothing
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
	 * Get the days or month for a connection
	 * @param user
	 * @param patientId
	 * @return
	 */
	def static getDays(HealpalUser user, def patientId)throws Exception{
		def dayString = "";
		try{
			if(user && patientId){
				def patientChatList = PatientChat.createCriteria().list {
					or{
						and{
							eq('patientByPatientFk1', Patient.findByPerson(user?.person))
							eq('patientByPatientFk2', Patient.get(patientId))
						}

						and{
							eq('patientByPatientFk1', Patient.get(patientId))
							eq('patientByPatientFk2', Patient.findByPerson(user?.person))
						}
					}
				}
				if(patientChatList){
					Date rowCreated = patientChatList.get(0)?.rowAltered
					if(rowCreated){
						Calendar startCalendar = new GregorianCalendar();
						startCalendar.setTime(rowCreated);
						Calendar endCalendar = new GregorianCalendar();
						endCalendar.setTime(new Date());
						int diffYear = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
						int diffMonth = diffYear * 12 + endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH);
						final long DAY_IN_MILLIS = 1000 * 60 * 60 * 24;
						int diffInDays = (int) ((new Date().getTime() - rowCreated.getTime())/ DAY_IN_MILLIS );
						int days = daysBetween(rowCreated, new Date())
						if(diffYear > 0){
							if(diffYear > 1){
								dayString = diffYear + " years ago"
							}else{
								dayString = "a year ago"
							}
						}else if(diffMonth > 0){
							if(diffMonth > 1){
								dayString = diffMonth + " months ago";
							}else{
								dayString = "a month ago";
							}
						}else if(days > 0){
							if(days > 1){
								dayString = days+" days ago";
							}else{
								dayString = "a day ago";
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
			exception.printStackTrace();
		}
		return dayString
	}

	/**
	 * Get the no of days between two dates
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static int daysBetween(Date d1, Date d2){
		return (int)( (d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
	}


	/**
	 * Search the connection list
	 * @param user
	 * @param params
	 * @return
	 */
	def searchConnectionList(HealpalUser user, params, session)throws Exception{
		ArrayList<Patient> connectionList = new ArrayList<Patient>();
		try{
			if(user){
				if(user?.person){
					connectionList = getTotalSearchConnectionList(user, params)
					session.searchConnection = connectionList
					session.searchType = params.selectValue
					def patientList
					if(connectionList != null && connectionList.size() > 0){
						patientList = Patient.createCriteria().list(params) {
							'in'('id', connectionList?.id)
							if(session.searchType != null && session.searchType != "New") {
								person{
									if(session.searchType != null && session.searchType == "First"){
										order('firstName','asc')
									}else if(session.searchType != null && session.searchType == "Last"){
										order('lastName','asc')
									}else{
										//do nothing
									}
								}
							}
						}
					}
					return patientList;
				}else{
					//do nothing
				}
			}
			//return connectionList;
		}catch(Exception exception){
			throw exception;
		}
	}
	
	/**
	 * Get the searched total connection
	 * @param user
	 * @param params
	 * @return
	 */
	def getTotalSearchConnectionList(HealpalUser user, params){
		ArrayList<Patient> connectionList = new ArrayList<Patient>();
		try{
			if(user){
				if(user?.person){
					def chatList = PatientChat.createCriteria().list {
						if(user?.person){
							or{
								eq('patientByPatientFk1', Patient.findByPerson(user?.person))
								eq('patientByPatientFk2', Patient.findByPerson(user?.person))
							}
						}
						eq("approveRequest",(short)1)
						if(params.selectValue != null && params.selectValue == "New"){
							
							order("rowAltered", "desc")
						}
					}

					ArrayList<Patient> patientListExist = new ArrayList<Patient>();
					chatList?.each {
						if(Patient.findByPerson(user?.person)?.id == it?.patientByPatientFk1?.id){
							patientListExist.add(it?.patientByPatientFk2)
						}else{
							patientListExist.add(it?.patientByPatientFk1)
						}
					}
					
					def personList = Person.createCriteria().list {
						if(params.searchValue != null){
							ilike('fullName',"%"+params.searchValue+"%")
						}
						if(params.selectValue != null && params.selectValue == "First") {
							order("firstName", "asc")
						} else if(params.selectValue != null && params.selectValue == "Last") {
							order("lastName", "asc")
						}
					}
										
					if(params.selectValue != null && params.selectValue == "New"){
						patientListExist?.each { patient ->
							personList?.each { person ->
								if(person){
									def newPatient = Patient.findByPerson(person)
									if(patient?.id == newPatient?.id){
										connectionList.add(patient);
									}
								}
							}
						}
					}else{
						personList?.each {
							def patient = Patient.findByPerson(it)
							if(patient){
								patientListExist?.each { curPatient ->
									if(curPatient?.id == patient.id){
										connectionList.add(curPatient);
									}
								}
							}
						}
					}
				}else{
					//do nothing
				}
			}
			return connectionList;
		}catch(Exception exception){
			throw exception;
		}
	}
	
	
	/**
	 * Search Session Connection
	 * @param params
	 * @param session
	 * @return
	 * @throws Exception
	 */
	def searchSessionConnectionList(params, session) throws Exception{
		ArrayList<Patient> connectionList = new ArrayList<Patient>();
		try{
			if(params && session && session.searchConnection){
				connectionList = Patient.createCriteria().list(params) {
					'in'('id', session.searchConnection?.id)
					if(session.searchType != null && session.searchType != "New"){
						person{
							if(session.searchType != null && session.searchType == "First"){
								order('firstName','asc')
							}else if(session.searchType != null && session.searchType == "Last"){
								order('lastName','asc')
							}else{
								//do nothing
							}
						}
					}
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
	 * Send message to a patient
	 * @param user
	 * @param params
	 * @return
	 */
	def sendMessage(HealpalUser user, params)throws Exception{
		Message msg = null;
		try{
			if(user && params.patientId && params.message){
				Message message = new Message();
				message.messageText = params.message?.toString()?.trim()
				message.patientByPatientFkSender = Patient.findByPerson(user?.person)
				message.patientByPatientFkReceiver = Patient.get(params.patientId)
				message.messageCreated = new Date()
				message.messageSent = new Date()
				message.rowCreated = new Date()
				message.isActive = (short)1
				message.readReceiptRequested = (short)1
				msg  =  message.save();
				if (!message.validate()){
					message.errors.each {println it }
				}else{
					// do nothing
				}
			}else{
				//do nothing
			}
			return msg;
		}catch(Exception exception){
			throw exception;
		}
	}

	/**
	 * Check the Group name already exist or not
	 * @param groupName
	 * @return
	 * @throws Exception
	 */
	def isGroupNameExist(def groupName) throws Exception {
		def message = "false";
		try{
			if(groupName) {
				MessageGroup messageGroup = MessageGroup.findByMessageGroupNameIlike(groupName);
				if(messageGroup) {
					message = "true";
				} else {
					//do nothing
				}
			} else {
				//do nothing
			}
			return message;
		} catch(Exception exception) {
			throw exception;
		}
	}


	/**
	 * Create a message group
	 * @param user
	 * @param params
	 * @return
	 */
	def createGroup(HealpalUser user, params){
		try{
		//	if(params.groupName && user && params.'patientIds[]'){
			
	
			if(params.groupName && user && params.members){
				MessageGroup messageGroup = new MessageGroup();
				messageGroup.withTransaction { status ->
					messageGroup.messageGroupName 	= 	params.groupName?.toString()?.trim()
					messageGroup.isActive 			= 	(short) 1;
					messageGroup.rowCreated 		= 	new Date();
					messageGroup.createdPatient 	= 	Patient.findByPerson(user?.person)
					
					def msgGroup 					= 	messageGroup.save(flush:true)

					if (!messageGroup.validate()){
						messageGroup.errors.each {println it }
					}else{
						//def memberList = params.'patientIds[]'
						def memberList = params.members
						if(memberList){
							memberList?.each {
								PatientMessageGroup patientMessageGroup = 	new PatientMessageGroup();
								patientMessageGroup.messageGroup 		= 	msgGroup;
								patientMessageGroup.patient 			= 	Patient.findByPerson(Person.get(it));//Patient.get(it);
								patientMessageGroup.isActive 			= 	(short) 1;
								patientMessageGroup.rowCreated 			= 	new Date();
								def patientMsgGroup 					= 	patientMessageGroup.save(flush:true)

								if (!patientMessageGroup.validate()){
									patientMessageGroup.errors.each {println it }
								}else{
									//do nothing
								}
							}
						}else{
							//do nothing
						}

						PatientMessageGroup patientMessageGroup 	= 	new PatientMessageGroup();
						patientMessageGroup.messageGroup 			= 	msgGroup;
						patientMessageGroup.patient 				= 	Patient.findByPerson(user?.person)
						patientMessageGroup.isActive 				= 	(short) 1;
						patientMessageGroup.rowCreated 				= 	new Date();
						def patientMsgGroup 						= 	patientMessageGroup.save(flush:true)

						if (!patientMessageGroup.validate()){
							patientMessageGroup.errors.each {println it }
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
	def saveGroupImage(params,request)throws Exception {
		try{
		if(request.getFile('uploadPhoto')){
			def groupId
			CommonsMultipartFile f = request.getFile('uploadPhoto')
			String name =f.getOriginalFilename()
			if(name){
				groupId = MessageGroup.findByMessageGroupName(params.groupName?.toString()?.trim())?.id
				String extension = name.substring(name.lastIndexOf('.') + 1, name.length());
				String fileName = name.substring(0,name.lastIndexOf('.'));
				name =  groupId+"." + extension
			}
			def serveletContext = ServletContextHolder.servletContext
			def storagePath = serveletContext.getRealPath("assets/group-photo/")
			def storagePathDirectory = new File( storagePath )
			if( !storagePathDirectory.exists() ){
				println("creating directory ${storagePath}")
				if(storagePathDirectory.mkdirs()){
					println ("SUCCESS")
				}else{
					println ("FAILED")
				}
			}
			// Store file
			if(!f.isEmpty()){
				f.transferTo( new File("${storagePath}/${name}") )
				println("Saveddddd File: ${storagePath}/${name}")
			}else{
				println "File: ${file.inspect()} was empty"
			}
			MessageGroup photo = MessageGroup.get(groupId)
			if(photo){
				photo.groupPhotoName = name
				photo.rowAltered = new Date()
				photo.isActive = (short)1
			}else{
				photo = new MessageGroup()
				photo.groupPhotoName = name
				photo.rowAltered = new Date()
				photo.isActive = (short)1
			}
			def profile = photo.save(flush:true)
			if (!photo.validate()){
				photo.errors.each {println it }
			}else{
				// do nothing
			}
		}
	}catch(Exception e){
		throw e
	}
	}
}
