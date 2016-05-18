/*
 * Author      : Arunkumar
 * Project     : Healpal
 * Date        : 11/10/2015
 * Description : Dashboadrd viewing
 *
 * #   Name             Version   Modified-Date      Description
 * -------------------------------------------------------------------------------------
 * 1   Arunkumar       1.0                          Initial Creation
 */
package com.healpal.care

import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory.Default;
import java.text.DateFormat
import java.text.SimpleDateFormat

/**
 *
 * @author Arunkumar K
 *
 */
class DashboardController {
	static DashboardService dashboardService
	static ConnectionService connectionService
	def ReferralsService referralsService
	def ProfileService profileService;
	def index() {
	}



	/**
	 * Patient dashboard page
	 * @return
	 */
	def view(){
		try{
			authorizeMe(Role.patient);
			HealpalUser user = session.user
			def messageMap = dashboardService.getPatientMessages(Patient.findByPerson(HealpalUser.get(user?.id)?.person)?.id);
			def messageMaps = dashboardService.getPatientMessageCount(Patient.findByPerson(HealpalUser.get(user?.id)?.person)?.id);
			def connectionList = dashboardService.getConnectionList(Patient.findByPerson(HealpalUser.get(user?.id)?.person)?.id);
			def acceptList = dashboardService.getAcceptList(Patient.findByPerson(HealpalUser.get(user?.id)?.person)?.id);
			def messageGroupList = dashboardService.getGroupList(Patient.findByPerson(HealpalUser.get(user?.id)?.person)?.id);
			def newMessageFromGroup = dashboardService.newMessageFromGroup(Patient.findByPerson(HealpalUser.get(user?.id)?.person)?.id);
			def profileCompletion=dashboardService.getProfileCompletion(user);
			//def photoView = dashboardService.getPhoto(Patient.findByPerson(HealpalUser.get(user?.id)?.person)?.id);
			def photoView = dashboardService.getPhoto(HealpalUser.get(user?.id)?.person?.id);
			def photo=ProfilePhoto.findByPatient(Patient.findByPerson(HealpalUser.get(user?.id)?.person))?.profilePhotoPath;
			def groupMessages = dashboardService.getGroupMessages(Patient.findByPerson(HealpalUser.get(user?.id)?.person)?.id);
			[dashActive : 'active', messageMap:messageMap,messageMaps:messageMaps, profileCompletion:profileCompletion,connectionList:connectionList,acceptList:acceptList,photoView:photoView, messageGroupList:messageGroupList,
				newMessageFromGroup:newMessageFromGroup ,expertCount:referralsService.getReceivedCount(session, paramReturn(ReferralCategory.expert)),
				clinicCount:referralsService.getReceivedCount(session, paramReturn(ReferralCategory.trial)),photo:photo,groupMessages:groupMessages]
		}catch(Exception exception){
			exception.printStackTrace()
		}
	}


	def autoRefresh(){
		//HealpalUser user = session.user
		/*def messageSize=0;
		 def messageMap = dashboardService.getPatientMessages(Patient.findByPerson(HealpalUser.get(user?.id)?.person)?.id).size();
		 def newMessageFromGroup = dashboardService.newMessageFromGroup(Patient.findByPerson(HealpalUser.get(user?.id)?.person)?.id).size();
		 messageSize = messageMap +newMessageFromGroup*/
		render (template:'messageNotification')

	}

	def paramReturn(def category){
		params.referralCategory = category
		params.from = "dashboard"
		return params
	}

	/**
	 * Get the patient messages
	 * @return
	 */
	def getMessages(){
		try{
			authorizeMe(Role.patient);
			HealpalUser user = session.user
			LinkedHashMap<Patient, List<Message>> messageMap = dashboardService.getPatientMessages(Patient.findByPerson(HealpalUser.get(user?.id)?.person)?.id);
			session.messageMap = messageMap
			LinkedHashMap<Patient, List<Message>> pageMessageMap = new LinkedHashMap<Patient, List<Message>>();
			int  k = 0;

			for (Map.Entry<Patient, ArrayList<Message>> entry : messageMap.entrySet()) {
				Patient key = entry.getKey();
				ArrayList<Message> value = entry.getValue();
				if(k < 21){
					pageMessageMap.put(key, value);
					k++;
				}
				// now work with key and value...
			}
			params.max = Math.min(params.max ? params.int('max') : 20, 100)

			[messageMap:pageMessageMap, messageMapTotal:messageMap?.size(), offset:0 ,max : params.max]
		}catch(Exception exception){
			exception.printStackTrace();
		}
	}



	def getMessagesCount(){
		try{
			authorizeMe(Role.patient);
			HealpalUser user = session.user
			LinkedHashMap<Patient, List<Message>> messageMaps = dashboardService.getPatientMessageCount(Patient.findByPerson(HealpalUser.get(user?.id)?.person)?.id);

			LinkedHashMap<Patient, List<Message>> pageMessageMap = new LinkedHashMap<Patient, List<Message>>();
			int  k = 0;

			for (Map.Entry<Patient, ArrayList<Message>> entry : messageMaps.entrySet()) {
				Patient key = entry.getKey();
				ArrayList<Message> value = entry.getValue();
				if(k < 21){
					pageMessageMap.put(key, value);
					k++;
				}
				// now work with key and value...
			}
			params.max = Math.min(params.max ? params.int('max') : 20, 100)
			[messageMaps:pageMessageMap, messageMapTotal:messageMaps?.size(), offset:0 ,max : params.max]
		}catch(Exception exception){
			exception.printStackTrace();
		}
	}


	/**
	 * Get the patient messages
	 * @return
	 */
	def getAllMessages(){
		try{
			authorizeMe(Role.patient);
			HealpalUser user = session.user
			LinkedHashMap<Patient, List<Message>> messageMap = dashboardService.getAllMessages(Patient.findByPerson(HealpalUser.get(user?.id)?.person)?.id);
			LinkedHashMap<Patient, List<Message>> pageMessageMap = new LinkedHashMap<Patient, List<Message>>();
			session.allMessageMap = messageMap

			int  k = 0;

			for (Map.Entry<Patient, ArrayList<Message>> entry : messageMap.entrySet()) {
				Patient key = entry.getKey();
				ArrayList<Message> value = entry.getValue();
				if(k < 21){
					pageMessageMap.put(key, value);
					k++;
				}
				// now work with key and value...
			}
			params.max = Math.min(params.max ? params.int('max') : 20, 100)
			[messageMap:pageMessageMap, messageMapTotal:messageMap?.size(), person:session.user?.person,offset:0 ,max : params.max]
		}catch(Exception exception){
			exception.printStackTrace();
		}
	}


	/**
	 * for display all connected patient and their chat messages by passing their id's
	 * @return
	 */
	def viewMessage(){
		def messageList
		def groupMessageList
		def groupName
		def messageGroupId
		def personName
		//ProfilePhoto profilePhoto
		def profilePhoto
		def  patientTo
		def groupPhoto=""
		def newGroupId=""
		try{
			if(session.user){
				HealpalUser user = session.user
				LinkedHashMap<Patient, List<Message>> mess = dashboardService.getPatientMessage(Patient.findByPerson(HealpalUser.get(user?.id)?.person)?.id);
				if(params != null && params.patientId != null && params.patientId != ""){
					personName = Patient.get(params.patientId)?.person
					messageList = dashboardService.getMessageList(params.patientId, Patient.findByPerson(HealpalUser.get(user?.id)?.person)?.id);
					dashboardService.updateMessage(params.patientId, Patient.findByPerson(HealpalUser.get(user?.id)?.person)?.id)
					patientTo = params.patientId
					if(params.passbyAjax){
						render(template:"chatMessages", model:[messageList:messageList,profilePhoto:ProfilePhoto.findByPatient(Patient.get(params.patientId))?.profilePhotoPath,personName:personName,person:session.user?.person, patientTo:patientTo])
					}

				}else if(params != null && params.messageGroupId != null && params.messageGroupId != ""){
					messageGroupId =  params.messageGroupId
					groupName = MessageGroup.get(params.messageGroupId.toLong())?.messageGroupName
					groupMessageList = dashboardService.viewGroupMessage(params.messageGroupId);
					dashboardService.updatePatientViewGroupMessage(params.messageGroupId, Patient.findByPerson(HealpalUser.get(user?.id)?.person)?.id);
					def imgpath = MessageGroup.get(params.messageGroupId.toLong())?.groupPhotoName
					if(imgpath)
					{
						groupPhoto=MessageGroup.get(params.messageGroupId.toLong())?.groupPhotoName
					}
					if(params.passbyAjax){
						render(template:"chatMessages", model:[groupMessageList:groupMessageList,person:session.user?.person,groupName:groupName,groupPhoto:groupPhoto]) //,groupId:messageGroupId,messageGroupId:messageGroupId
					}
				}

				if(params!="" && params.newGroupName!="" && params.newGroupName !=null){
					def messageGroup = MessageGroup.findByMessageGroupName(params.newGroupName)
					newGroupId = messageGroup?.id
					groupName =messageGroup?.messageGroupName
					if(messageGroup?.groupPhotoName){
						groupPhoto=messageGroup?.groupPhotoName}
				}
				if(params.menuMessages){
					LinkedHashMap<Patient, List<Message>> messageMaps = dashboardService.getPatientMessage(Patient.findByPerson(HealpalUser.get(user?.id)?.person)?.id);
					if(messageMaps){
						Set set = messageMaps.entrySet();
						Iterator iterator = set.iterator();
						boolean check = true;
						while(iterator.hasNext()) {
							Map.Entry entry = (Map.Entry)iterator.next();
							if(entry){
								if(check){
									personName = entry.getKey()?.person
									patientTo = entry.getKey()?.id
									profilePhoto = ProfilePhoto.findByPatient(Patient.get(entry.getKey()?.id))?.profilePhotoPath
								}
								check=false;

							}
							messageList = dashboardService.getMessageList(patientTo, Patient.findByPerson(HealpalUser.get(user?.id)?.person)?.id);
						}
					}else{
						def groupList = dashboardService.getAllGroups(Patient.findByPerson(HealpalUser.get(user?.id)?.person)?.id,params);
						if(groupList !=null && groupList!="")
						{
							boolean checkGroup = true;
							groupList.each{
								if(checkGroup){
									messageGroupId = it?.messageGroup?.id
									groupPhoto=it?.messageGroup?.groupPhotoName
									groupName =it?.messageGroup?.messageGroupName
								}
								checkGroup = false;
							}
							groupMessageList = dashboardService.viewGroupMessage(messageGroupId);
						}
					}

				}

				[messagesId:'active',messageList:messageList, patientTo:patientTo, person:session.user?.person, personName:personName, profilePhoto:profilePhoto,groupMessageList:groupMessageList,groupName:groupName,messageGroupId:messageGroupId,groupPhoto:groupPhoto,mess:mess,newGroupId:newGroupId]//,photo:ProfilePhoto.findByPatient(Patient.findByPerson(HealpalUser.get(user?.id)?.person))?.profilePhotoPath,groupId:messageGroupId
			}else{
				redirect controller :'auth' ,action :'doLogout'
			}
		}catch(Exception exception){
			exception.printStackTrace();
		}
	}

	/**
	 * Get all the messages
	 * @return
	 */
	def messages(){
		def messageList
		try{
			if(session.user){
				if(params != null && params.patientId != null && params.patientId != ""){
					HealpalUser user = session.user
					messageList = dashboardService.getMessageList(params.patientId, Patient.findByPerson(HealpalUser.get(user?.id)?.person)?.id);
				}else{
					//do nothing
				}
				render(template:"messages", model:[messageList:messageList, patientTo:params.patientId, person:session.user?.person])
			}else{
				render(template:"messages", model:[messageList:messageList, patientTo:params.patientId, person:session.user?.person])
			}
		}catch(Exception exception){
			exception.printStackTrace();
		}
	}


	/**
	 * Get all the messages
	 * @return
	 */
	def groupMessages(){
		def messageList
		try{
			if(session.user){
				if(params != null && params.messageGroupId != null && params.messageGroupId != ""){
					messageList = dashboardService.viewGroupMessage(params.messageGroupId);
				}else{
					//do nothing
				}
				render(template:"groupMessages", model:[messageList:messageList])
			}else{
				render(template:"groupMessages", model:[messageList:messageList])
			}
		}catch(Exception exception){
			exception.printStackTrace();
		}
	}


	/**
	 * Reply message is for send messages
	 * @return
	 */
	def replyMessage(){
		try{
			if(session.user){
				HealpalUser user = session.user
				def messageList=null
				def groupMessageList=null
				def groupPhoto=""
				if(params.message && (params.patientId || params.groupId) && user){
					dashboardService.sendMessage(params, user);
				}else{
					//do nothing
				}
				if(params.message && params.patientId){
					messageList = dashboardService.getMessageList(params.patientId, Patient.findByPerson(HealpalUser.get(user?.id)?.person)?.id);
					render(template:"newMessages", model:[messageList:messageList,person:session.user?.person,profilePhoto:ProfilePhoto.findByPatient(Patient.get(params.patientId))?.profilePhotoPath,personName:Patient.get(params.patientId)?.person,person:session.user?.person,patientTo:params.patientId])
				}
				else if(params.message && params.groupId){
					groupMessageList = dashboardService.viewGroupMessage(params.groupId);
					def groupName = MessageGroup.get(params.groupId.toLong())?.messageGroupName
					def messageGroupId = MessageGroup.get(params.groupId.toLong())?.id
					def imgpath = MessageGroup.get(params.groupId.toLong())?.groupPhotoName
					if(imgpath !=null){
						groupPhoto = imgpath
					}
					render(template:"newMessages", model:[groupMessageList:groupMessageList,person:session.user?.person,groupName:groupName,groupPhoto:groupPhoto]) //,messageGroupId:messageGroupId,groupId:messageGroupId
				}
			}else{
				render ""
			}
		}catch(Exception exception){
			exception.printStackTrace()
		}
	}



	/**
	 * View all messages
	 * @return
	 */
	def viewAllMessage(){
		def messageList
		try{
			if(session.user){
				if(params != null && params.patientId != null && params.patientId != ""){
					HealpalUser user = session.user
					messageList = dashboardService.getMessageList(params.patientId, Patient.findByPerson(HealpalUser.get(user?.id)?.person)?.id);
					dashboardService.updateMessage(params.patientId, Patient.findByPerson(HealpalUser.get(user?.id)?.person)?.id)
				}else{
					//do nothing
				}
				[messageList:messageList, patientTo:params.patientId, person:session.user?.person]
			}else{
				redirect controller :'auth' ,action :'doLogout'
			}
		}catch(Exception exception){
			exception.printStackTrace();
		}
	}

	def ajaxPaginateMessage(){
		try{
			HealpalUser healpalUser = session.user;
			int off = Integer.parseInt(params.offset);
			def maxSize = Integer.parseInt(params.max);
			int mSize = off + maxSize ;
			LinkedHashMap<Patient, List<Message>> sessionMap
			if(session.messageMap){
				sessionMap = (LinkedHashMap<Patient, List<Message>>)session.messageMap
			}
			LinkedHashMap<Patient, List<Message>> messageMap = new LinkedHashMap<Patient, List<Message>>();

			LinkedHashMap<Patient, List<Message>> messageMapList = new LinkedHashMap<Patient, List<Message>>();

			ArrayList<Patient> patientList = new ArrayList<Patient>();

			for (Map.Entry<Patient, ArrayList<Message>> entry : sessionMap.entrySet()) {
				Patient key = entry.getKey();
				ArrayList<Message> messageList = entry.getValue();
				messageMap.put(key, messageList);
				patientList.add(key);
			}

			for(int i = off; i< patientList.size(); i++){
				if(i < mSize){
					messageMapList.put(Patient.get(patientList.get(i)?.id), messageMap.get(patientList.get(i)));
				}else{
					//do nothing
				}
			}
			render (template :'messageList' ,model:[messageMap:messageMapList ,messageMapTotal:params.size ,offset:params.offset ,max :params.max])
		}catch(Exception exception){
			exception.printStackTrace();
		}
	}


	def ajaxPaginateAllMessage(){
		try{
			HealpalUser healpalUser = session.user;
			int off = Integer.parseInt(params.offset);
			def maxSize = Integer.parseInt(params.max);
			int mSize = off + maxSize ;
			LinkedHashMap<Patient, List<Message>> sessionMap
			if(session.allMessageMap){
				sessionMap = (LinkedHashMap<Patient, List<Message>>)session.allMessageMap
			}
			LinkedHashMap<Patient, List<Message>> messageMap = new LinkedHashMap<Patient, List<Message>>();

			LinkedHashMap<Patient, List<Message>> messageMapList = new LinkedHashMap<Patient, List<Message>>();

			ArrayList<Patient> patientList = new ArrayList<Patient>();

			for (Map.Entry<Patient, ArrayList<Message>> entry : sessionMap.entrySet()) {
				Patient key = entry.getKey();
				ArrayList<Message> messageList = entry.getValue();
				messageMap.put(key, messageList);
				patientList.add(key);
			}

			for(int i = off; i< patientList.size(); i++){
				if(i < mSize){
					messageMapList.put(Patient.get(patientList.get(i)?.id), messageMap.get(patientList.get(i)));
				}else{
					//do nothing
				}
			}
			render (template :'allMessageList' ,model:[messageMap:messageMapList ,messageMapTotal:params.size ,offset:params.offset ,max :params.max])
		}catch(Exception exception){
			exception.printStackTrace();
		}
	}


	/**
	 * Get Message Group list
	 * @return
	 */
	def getGroupMessages(){
		def groupList
		try{
			HealpalUser user = session.user
			if(user){
				groupList = dashboardService.getGroupList(Patient.findByPerson(HealpalUser.get(user?.id)?.person)?.id);
				session.groupMessageList = groupList
				params.max = Math.min(params.max ? params.int('max') : 20, 100)
				List list = new ArrayList<PatientMessageGroup>();
				for(int i = 0; i < groupList?.size(); i++){
					if(i < 21){
						list.add(groupList.get(i))
					}else{
						//do nothing
					}
				}
				[groupList:list, groupListTotal:groupList?.size(), offset:0 ,max : params.max]
			}else{
				redirect controller :'auth' ,action :'doLogout'
			}
		}catch(Exception exception){
			exception.printStackTrace();
		}
	}


	def getAllGroupMessages(){
		def groupList
		def getAllGroups
		try{
			HealpalUser user = session.user
			if(user){
				params.max = Math.min(params.max ? params.int('max') : 20, 100)
				groupList = dashboardService.getAllGroupList(Patient.findByPerson(HealpalUser.get(user?.id)?.person)?.id);
				getAllGroups = dashboardService.getAllGroups(Patient.findByPerson(HealpalUser.get(user?.id)?.person)?.id,params); // to get all groups
				session.allGroupMessageList = groupList
				List list = new ArrayList<MessageGroup>();
				for(int i = 0; i < groupList?.size(); i++){
					if(i < 21){
						list.add(groupList.get(i))
					}else{
						//do nothing
					}
				}
				[groupList:list, groupListTotal:groupList?.size(), user:session.user, offset:0 ,max : params.max,getAllGroups:getAllGroups]
			}else{
				redirect controller :'auth' ,action :'doLogout'
			}
		}catch(Exception exception){
			exception.printStackTrace();
		}
	}


	def ajaxPaginateGroupMessage(){
		try{
			HealpalUser healpalUser = session.user;
			int off = Integer.parseInt(params.offset);
			def maxSize = Integer.parseInt(params.max);
			int mSize = off + maxSize ;
			List<MessageGroup> sessionList = new ArrayList<MessageGroup>();
			if(session.groupMessageList){
				sessionList = (ArrayList<MessageGroup>)session.groupMessageList
			}else{
				//do nothing
			}
			List list = new ArrayList<MessageGroup>();
			for(int i = off; i < mSize; i++){
				if(i < sessionList?.size()){
					list.add(sessionList.get(i));
				}
			}
			render (template :'groupMessageList' ,model:[groupList:list ,groupListTotal:params.size ,offset:params.offset ,max :params.max])
		}catch(Exception exception){
			exception.printStackTrace();
		}
	}

	def ajaxPaginateAllGroupMessage(){
		try{
			HealpalUser healpalUser = session.user;
			int off = Integer.parseInt(params.offset);
			def maxSize = Integer.parseInt(params.max);
			int mSize = off + maxSize ;
			List<MessageGroup> sessionList = new ArrayList<MessageGroup>();
			if(session.allGroupMessageList){
				sessionList = (ArrayList<MessageGroup>)session.allGroupMessageList
			}else{
				//do nothing
			}
			List list = new ArrayList<MessageGroup>();
			for(int i = off; i < mSize; i++){
				if(i < sessionList?.size()){
					list.add(sessionList.get(i));
				}
			}
			render (template :'allGroupMessageList' ,model:[groupList:list, groupListTotal:params.size, user:session.user, offset:params.offset, max :params.max])
		}catch(Exception exception){
			exception.printStackTrace();
		}
	}



	/**
	 * Get the new connections
	 * @return
	 */
	def getNewConnections(){
		authorizeMe(Role.patient);
		try{
			HealpalUser user = session.user
			def connectionList = dashboardService.getConnectionList(Patient.findByPerson(HealpalUser.get(user?.id)?.person)?.id);
			def acceptList = dashboardService.getAcceptList(Patient.findByPerson(HealpalUser.get(user?.id)?.person)?.id);
			[connectionList:connectionList,acceptList:acceptList]
		}catch(Exception exception){
			exception.printStackTrace();
		}
	}

	/**
	 * Approve connection
	 * @return
	 */
	def approveConnection(){
		try{
			println "DashboardController . approveConnection = connection accept initiated" + params.idno
			def msg
			HealpalUser user = session.user
			if(params != null && params.connectionId && params.state){
				dashboardService.approveConnection(user, params);
				println "params;;;;;;;;;;;;;;;;;;;;;"+params
				//msg = "Accepted"
				//redirect(controller:"connection", action:"list")

			}else{
				//do nothing
			}

			render (template:'/layouts/connected')


		}catch(Exception exception){
			exception.printStackTrace();
		}
	}


	/**
	 * permit connection
	 * @return
	 */
	def permitConnection(){
		try{
			println "DashboardController . approveConnection = connection accept initiated" + params.idno
			def msg
			HealpalUser user = session.user
			if(params != null && params.connectionId && params.state){
				dashboardService.approveConnection(user, params);
				println "params;;;;;;;;;;;;;;;;;;;;;"+params
				//msg = "Accepted"
				redirect(controller:"connection", action:"list")

			}else{
				//do nothing
			}



		}catch(Exception exception){
			exception.printStackTrace();
		}
	}



	/**
	 * View Group messages
	 * @return
	 */
	def viewGroupMessage(){
		def groupMessageList
		try{
			if(session.user){
				if(params.messageGroupId){
					HealpalUser user = session.user
					groupMessageList = dashboardService.viewGroupMessage(params.messageGroupId);
					dashboardService.updatePatientViewGroupMessage(params.messageGroupId, Patient.findByPerson(HealpalUser.get(user?.id)?.person)?.id);
				}else{
					//do nothing
				}
				[groupMessageList:groupMessageList, messageGroupId:params.messageGroupId]
			}else{
				redirect controller :'auth' ,action :'doLogout'
			}
		}catch(Exception exception){
			exception.printStackTrace();
		}
	}


	/**
	 * View All Group Messages
	 * @return
	 */
	def viewAllGroupMessages(){
		def groupMessageList
		try{
			if(session.user){
				if(params.messageGroupId){
					HealpalUser user = session.user
					groupMessageList = dashboardService.viewGroupMessage(params.messageGroupId);
					dashboardService.updatePatientViewGroupMessage(params.messageGroupId, Patient.findByPerson(HealpalUser.get(user?.id)?.person)?.id);
				}else{
					//do nothing
				}
				[groupMessageList:groupMessageList, messageGroupId:params.messageGroupId]
			}else{
				redirect controller :'auth' ,action :'doLogout'
			}
		}catch(Exception exception){
			exception.printStackTrace();
		}
	}


	/**
	 * Admin dashboard
	 * @return
	 */
	def adminDashboard(){
		if(session.user && session.authority !=null && (session.authority?.equalsIgnoreCase(Role.admin) || session.authority.equalsIgnoreCase(Role.SuperAdmin))){

			//Over ALL Count
			def patientCountVal=HealpalUser.count


			//LastMonth Count
			def lastMonthCount=HealpalUser.all
			Calendar aCalendar = Calendar.getInstance();
			aCalendar.add(Calendar.MONTH, -1);
			aCalendar.set(Calendar.DATE, 1);
			Date firstDateOfPreviousMonth = aCalendar.getTime();
			// set actual maximum date of previous month
			aCalendar.set(Calendar.DATE,     aCalendar.getActualMaximum(Calendar.DAY_OF_MONTH));
			//read it
			Date lastDateOfPreviousMonth = aCalendar.getTime();
			def firstDateOfPreviousMonth1 = new SimpleDateFormat("yyyy-MM-dd").format(firstDateOfPreviousMonth)
			def	 lastDateOfPreviousMonth2= new SimpleDateFormat("yyyy-MM-dd").format(lastDateOfPreviousMonth);
			def lastMonth = HealpalUser.executeQuery("select ae from HealpalUser ae  where DATE(ae.rowCreated) between DATE('"+firstDateOfPreviousMonth1+"') and DATE('"+lastDateOfPreviousMonth2+"')");



			//JAN-JUN Month Count
			//def sixMonth = Patient.executeQuery("select ae from Patient ae  where DATE(ae.rowCreated) between DATE('"+firstDateOfPreviousMonth1+"') and DATE('"+lastDateOfPreviousMonth2+"')");
			def currentYear = Calendar.getInstance().get(Calendar.YEAR);
			def janFirstDate=currentYear+"-01-01"
			def JunLastDate=currentYear+"-06-30"
			def janToJunMonthCount = HealpalUser.executeQuery("select ae from HealpalUser ae  where DATE(ae.rowCreated) between DATE('"+janFirstDate+"') and DATE('"+JunLastDate+"')");

			//JUL-DEC Month Count
			def julFirstDate=currentYear+"-07-01"
			def decLastDate=currentYear+"-12-31"
			def julToDecMonthCount = HealpalUser.executeQuery("select ae from HealpalUser ae  where DATE(ae.rowCreated) between DATE('"+julFirstDate+"') and DATE('"+decLastDate+"')");
			//Last Six Month Count
			aCalendar.add(Calendar.MONTH, -6);
			aCalendar.set(Calendar.DATE,     aCalendar.getActualMaximum(Calendar.DAY_OF_MONTH));
			Date PreviousMonth = aCalendar.getTime();
			def PreviousMonth1 = new SimpleDateFormat("yyyy-MM-dd").format(PreviousMonth)
			def	 PreviousMonth2= new SimpleDateFormat("yyyy-MM-dd").format(lastDateOfPreviousMonth);



			//Cancer Type Count



			def patientDiagnosisCount=PatientDiagnosis.all
			def	breastCount=0;
			def lungCount=0;
			def colonCount=0;
			def prostateCount=0;
			def skinCount=0;
			def kidneyCount=0;
			def bladderCount=0;
			def nHLCount=0;
			def leukemiaCount=0;
			def endometrialCount=0;
			def stomachCount=0;
			def brainCount=0;
			def ovaryCount=0;
			def otherCount=0;

			/*for(int i=0;i<patientDiagnosisCount?.diagnosis?.diagnosisName?.size();i++)
			 {
			 if("Breast Cancer" == patientDiagnosisCount?.diagnosis?.diagnosisName)
			 {
			 println "patientDiagnosisCount;;;;;;;;;;"+patientDiagnosisCount?.diagnosis?.diagnosisName
			 }
			 }*/

			def patientDiagnosisCount1=PatientDiagnosis.createCriteria().list {

			}
			for(int i=0;i<patientDiagnosisCount1?.diagnosis?.diagnosisName?.size();i++)
			{
				println "patientDiagnosisCount1?.diagnosis?.diagnosisName;;;;;;;;;;"+patientDiagnosisCount1?.diagnosis?.diagnosisName.get(i)
				if(patientDiagnosisCount1?.diagnosis?.diagnosisName.get(i)=="Breast")
				{
					breastCount++;
				}

				if(patientDiagnosisCount1?.diagnosis?.diagnosisName.get(i)=="Lung")
				{
					lungCount++;
				}

				if(patientDiagnosisCount1?.diagnosis?.diagnosisName.get(i)=="Colon")
				{
					colonCount++;
				}

				if(patientDiagnosisCount1?.diagnosis?.diagnosisName.get(i)=="Prostate")
				{
					prostateCount++;
				}

				if(patientDiagnosisCount1?.diagnosis?.diagnosisName.get(i)=="Skin")
				{
					skinCount++;
				}

				if(patientDiagnosisCount1?.diagnosis?.diagnosisName.get(i)=="Kidney")
				{
					kidneyCount++;
				}

				if(patientDiagnosisCount1?.diagnosis?.diagnosisName.get(i)=="Bladder")
				{
					bladderCount++;
				}

				if(patientDiagnosisCount1?.diagnosis?.diagnosisName.get(i)=="NHL")
				{
					nHLCount++;
				}

				if(patientDiagnosisCount1?.diagnosis?.diagnosisName.get(i)=="Leukemia")
				{
					leukemiaCount++;
				}

				if(patientDiagnosisCount1?.diagnosis?.diagnosisName.get(i)=="Endometrial")
				{
					endometrialCount++;
				}

				if(patientDiagnosisCount1?.diagnosis?.diagnosisName.get(i)=="Stomach")
				{
					stomachCount++;
				}

				if(patientDiagnosisCount1?.diagnosis?.diagnosisName.get(i)=="Brain")
				{
					brainCount++;
				}

				if(patientDiagnosisCount1?.diagnosis?.diagnosisName.get(i)=="Ovary")
				{
					ovaryCount++;
				}

				if(patientDiagnosisCount1?.diagnosis?.diagnosisName.get(i)=="Other")
				{
					otherCount++;
				}
			}
			[patientCountVal:patientCountVal,lastMonth:lastMonth.size(),janToJunMonthCount:janToJunMonthCount.size(),julToDecMonthCount:julToDecMonthCount.size()
			]

		}else{
			redirect controller :'auth' ,action :'doLogout'
		}
	}



	/**
	 * 
	 * @return
	 */
	def privacy(){
		try{



		}catch(Exception exception){
			throw exception
		}
	}

	/**
	 * Update the group message read by patient
	 * @return
	 */
	def updatePatientViewGroupMessage(){
		try{
			if(session.user){
				HealpalUser user = session.user
				if(params.messageGroupId && user){
					dashboardService.updatePatientViewGroupMessage(params.messageGroupId, Patient.findByPerson(HealpalUser.get(user?.id)?.person)?.id);
				}else{
					//do nothing
				}
			}else{
				//do nothing
			}
		}catch(Exception exception){
			throw exception
		}
	}


	/**
	 * Update the message read by patient
	 * @return
	 */
	def updatePatientViewMessage(){
		try{
			if(session.user){
				HealpalUser user = session.user
				if(params.patientId && user){
					dashboardService.updateMessage(params.patientId, Patient.findByPerson(HealpalUser.get(user?.id)?.person)?.id);
				}else{
					//do nothing
				}
			}else{
				//do nothing
			}
		}catch(Exception exception){
			throw exception
		}
	}

	/**
	 * 
	 * To get unique date
	 * @return
	 */
	def getUniqueDate(def messageDate){
		try{
			if(session.user){
				Date date = messageDate
				DateFormat sdf
				DateFormat sdff = new SimpleDateFormat("MMM dd, yyyy", Locale.US);
				String frmDateStr = sdff.format(date);
				return frmDateStr;
			}
		}catch(Exception e){
		}
	}

	def getPersonsProfileImage(def profileId){
		if(profileId && profileId!=null){
			def profilePhoto=ProfilePhoto.findByPatient(Patient.findByPerson(Person.get(profileId)))?.profilePhotoPath
			return 	profilePhoto
		}
	}

	def getProfilePhoto(def patientId){
		//def profilePhoto=ProfilePhoto.findByPatient(Patient.get(patientId))
	}
	/**
	 * Check the user and authorize to access
	 * @param whoAmI
	 * @return
	 */
	def authorizeMe(String whoAmI){
		if(session.user && session.authority?.equalsIgnoreCase(whoAmI)){
			//do nothing
		}else{
			redirect controller :'auth' ,action :'doLogout'
		}
	}

	/**
	 * Filter connected members by passing search values
	 * @return
	 */
	def searchConnectedMembers(){
		try{
			def connectionList = null;
			if(session.user){
				HealpalUser user = session.user
				connectionList = connectionService.searchConnectionList(user, params, session);
				def connectedperson = dashboardService.connectionList(Patient.findByPerson(HealpalUser.get(user?.id)?.person)?.id);
				LinkedHashMap<Patient, List<Message>> messageMaps = dashboardService.searchPatients(Patient.findByPerson(HealpalUser.get(user?.id)?.person)?.id,params,connectedperson);
				def groupLists =dashboardService.getAllGroups(Patient.findByPerson(HealpalUser.get(user?.id)?.person)?.id,params) //searchGroups
				render(template:'connectedPatients',model:[mess:messageMaps,groupLists:groupLists])
			}else{
				//do nothing
			}
		}catch(Exception exception){
			exception.printStackTrace();
		}
	}


	/**
	 * @return
	 */
	def getConnectionCount(){
		println "DashboardController . getConnectionCount = connection count get initiated"
		HealpalUser user = session.user
		if(user){
			def connectionSize = 0;
			def connectionList = dashboardService.getConnectionList(Patient.findByPerson(user?.person)?.id);
			if(connectionList){
				connectionSize = connectionList?.size()
			}
			if(connectionSize != 0){
				render connectionSize
			}
		}
	}
	/**
	 * To get latest chat message between two patients
	 * @return
	 */
	def lastChatMessage(){
		try{
			HealpalUser loginUser = session.user
			def receiverId
			def lastmsg="";
			ArrayList listofIds = new ArrayList()
			if(loginUser)
			{
				listofIds.add(Patient.get(receiverId));
				listofIds.add(Patient.findByPerson(HealpalUser.get(loginUser?.id.toLong())?.person));
				def msg = Message.createCriteria().list{

					or{
						and{
							eq("patientByPatientFkReceiver",Patient.get(receiverId))
							eq("patientByPatientFkSender",Patient.findByPerson(HealpalUser.get(loginUser?.id.toLong())?.person))
						}
						and{
							eq("patientByPatientFkReceiver",Patient.findByPerson(HealpalUser.get(loginUser?.id.toLong())?.person))
							eq("patientByPatientFkSender",Patient.get(receiverId))
						}}

					isNull('messageGroup')
					order('rowCreated','asc')
				}
				if(msg)
				{
					msg.each{ lastmsg = it?.messageText; }
				}
				if(lastmsg.length()>10)
				{
					lastmsg = lastmsg.toString().substring(0, 10)+"..";
				}
			}
		}catch(Exception e){e.printStackTrace();}
	}
	def getGroupImage(def groupId)
	{
		if(groupId && groupId!=null)
		{
			def groupPhoto=MessageGroup.get(groupId)?.groupPhotoName
			return groupPhoto
		}
	}
	def inviteFriends(){
		try{
			if(session.user){
				def sentEmail=params.emailToInvite//profileService.inviteMail(params)
				if(sentEmail.toString().contains(",")){
					String[] tokens = sentEmail.split(",");
					for(String sendtoMail:tokens){
						profileService.inviteMail(sendtoMail)
					}

				}
				else{
					profileService.inviteMail(sentEmail)
				}
				redirect(controller:'dashboard', action:'view')
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	def quickMail(){
		try{
			if(session.user && session.authority !=null && (session.authority?.equalsIgnoreCase(Role.admin) || session.authority.equalsIgnoreCase(Role.SuperAdmin)))
			{
				println "??????"
				if(request.post){

					def users = HealpalUser.findAllByEnabled(true)
					if(users!=null && users!=""){

						List<String> recipients = users?.userName
						
						dashboardService.shareLink(users?.userName, params)
						
						Email email = new Email();
						email.subject = params.subject
						email.bodyText = params.body
						email.isActive = (short)1
						email.rowCreated = new Date()
						email.save()
						if(!email.save().validate()){println it}
					}
					redirect(action:"adminEmail")
				}
			}
			else{
				redirect controller :'auth' ,action :'doLogout'
			}

		}catch(Exception e){e.printStackTrace();}
	}
	def adminEmail(){
		try{
			if(session.user && session.authority !=null && (session.authority?.equalsIgnoreCase(Role.admin) || session.authority.equalsIgnoreCase(Role.SuperAdmin)))
			{
				params.max = Math.min(params.max ? params.int('max') : 10, 100)
				[email:dashboardService.getEmailList(params),total:Email.list()?.size(),offset:0 ,max : params.max,searchValue:""]
			}else{
				redirect controller :'auth' ,action :'doLogout'
			}

		}catch(Exception e){e.printStackTrace();}
	}
	
	def ajaxPaginate(){
		try{
			render (template :'adminEmail' ,model:[email : dashboardService.getEmailList(params) ,total:dashboardService.getMailSearchCount(params) ,offset:params.offset ,max :params.max,searchValue:params.searchValue])
		}catch(Exception exception){
			exception.printStackTrace()
		}
	}

	def searchValues(){
		try{
			params.max = Math.min(params.max ? params.int('max') :10, 100)
			render(template:"adminEmail",model:[email : dashboardService.getEmailList(params) ,total:dashboardService.getMailSearchCount(params),offset:0 ,max : params.max, searchValue: params.searchValue])
		}catch(Exception exception){
			exception.printStackTrace()
		}
	}
}
