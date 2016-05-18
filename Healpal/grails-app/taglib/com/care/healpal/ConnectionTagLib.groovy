/*
 * Author      : Arunkumar K
 * Project     : Healpal
 * Date        : 11/17/2015
 * Description : Get the values using tags
 *
 * #   Name           Version   Modified-Date      Description
 * -------------------------------------------------------------------------------------
 * 1   Arunkumar K    1.0       11/17/2015         Initial Creation
 */

package com.care.healpal

import java.util.ArrayList;

import org.grails.datastore.gorm.finders.MethodExpression.IsNotNull;

import com.healpal.care.ConnectionService;
import com.healpal.care.DashboardService;
import com.healpal.care.HealpalUser;
import com.healpal.care.Message;
import com.healpal.care.Patient;
import com.healpal.care.PatientAddress;
import com.healpal.care.PatientCancerStage;
import com.healpal.care.PatientDiagnosis;
import com.healpal.care.PatientMatchService;
import com.healpal.care.PatientMessageGroup;
import com.healpal.care.Person;
import com.healpal.care.TempQuestionOption;
import com.healpal.care.MessageGroup;
import java.text.DateFormat
import java.text.SimpleDateFormat
/**
 * 
 * @author Arunkumar K
 *
 */
class ConnectionTagLib {

	def dashboardService;
	def patientMatchService;
	def userDetailsService;
	/**
	 * Get the new message count
	 */
	def patientMessages={attrs->
		def loginUser = attrs.get("currentUser")
		if(loginUser){
			def messageSize = 0;
			LinkedHashMap<Patient, ArrayList<Message>> messageMap = dashboardService.getPatientMessages(Patient.findByPerson(HealpalUser.get(loginUser?.id)?.person)?.id);
			def newMessageFromGroup = dashboardService.newMessageFromGroup(Patient.findByPerson(HealpalUser.get(loginUser?.id)?.person)?.id);
			messageSize = messageMap?.size() +newMessageFromGroup?.size();
			/*if(messageMap){
			 Set set = messageMap.entrySet();
			 Iterator iterator = set.iterator();
			 while(iterator.hasNext()) {
			 Map.Entry entry = (Map.Entry)iterator.next();
			 if(entry){
			 ArrayList<Message> messageList = entry.getValue();
			 if(messageList){
			 messageSize = messageSize + messageList?.size();
			 }else{
			 //do nothing
			 }
			 }else{
			 //do nothing
			 }
			 }
			 }else{
			 //do nothing
			 //}*/

			if(messageSize != 0){
				out << messageSize
			}
		}else{
			out << 0
		}
	}

	/**
	 * Get the patient connection count
	 */
	def patientConnections={attrs->
		def loginUser = attrs.get("currentUser")
		if(loginUser){
			def connectionSize = 0;
			def connectionList = dashboardService.getConnectionList(Patient.findByPerson(HealpalUser.get(loginUser?.id)?.person)?.id);
			if(connectionList){
				connectionSize = connectionList?.size();
			}
			if(connectionSize != 0){
				out << connectionSize
			}
		}else{
		}
	}


	/**
	 * Get the patient connection count
	 */
	def patientConnectionsAccepted={attrs->
		def loginUser = attrs.get("currentUser")
		if(loginUser){
			def connectionSize = 0;
			def acceptList = dashboardService.getAcceptList(Patient.findByPerson(HealpalUser.get(loginUser?.id)?.person)?.id);
			if(acceptList){
				connectionSize =  acceptList.size();
			}
			if(connectionSize != 0){
				out << connectionSize
			}
		}else{
		}
	}

	/**
	 * Get the cancer stage
	 */
	def cancerStage = {attrs->
		def patientId = attrs.get("patientId")
		if(patientId){
			def cancerName = patientMatchService.cancerStage(patientId);
			if(cancerName){
				out << cancerName
			}else{
				out << "";
			}
		}
	}

	/**
	 * Get the patient member year
	 */
	def patientmemberYear = {attrs->
		def patientId = attrs.get("patientId")
		if(patientId){
			def year = patientMatchService.getPatientActiveYear(patientId);
			if(year){
				out << "Active member since " + year
			}else{
				out << "";
			}
		}
	}
	
	
	
	/**
	 * Get the cancer patient
	 */

	def cancer = {attrs->
		def personId = attrs.get("personId")
		if(personId){
			def diagnosisName = userDetailsService.getCancerPatient(personId);
			if(diagnosisName){ 
				out << diagnosisName
			}else{
				out << "";
			}
		}
	}
	
	
	
	/**
	 * Get the patient state
	 */
	def state = {attrs ->
		def patientId = attrs.get("patientId")
		if(patientId){
			Patient patient = Patient.get(patientId?.toString().toLong());
			def stateName = PatientAddress.findByPatientAndIsActive(patient,Short.valueOf("1"))?.address?.state;
			def city = PatientAddress.findByPatientAndIsActive(patient,Short.valueOf("1"))?.address?.city;
			if(stateName && city){
				out << city + ", " +stateName
			}else if(stateName){
				out << stateName
			}else if(city){
				out << city
			}else{
				out << "";
			}
		}
	}
	def patientNewMessages={attrs ->
		def loginUser = attrs.get("currentUser")
		def senderId = attrs.get("senderId")
		def count=0;
		if(loginUser) {
			def msg = Message.createCriteria().list{
				eq("patientByPatientFkSender",Patient.get(senderId?.toString().toLong()))
				eq("patientByPatientFkReceiver",Patient.findByPerson(HealpalUser.get(loginUser?.id.toLong())?.person))
				isNull("messageViewed")
			}
			count = msg.size()
			out << count;
		}else{

		}
	}
	def breastcancer = {attrs ->
		def patientId = attrs.get("patientId")
		if(patientId){
			Patient patient = Patient.get(patientId?.toString().toLong());
			def cancerName = PatientDiagnosis.findByPatientAndIsActive(patient,Short.valueOf("1"))?.diagnosis?.diagnosisName;
			def cancerStatus = TempQuestionOption.findByPatientAndQuestionName(patient,"I am a")?.value;
			if(cancerStatus && cancerName){
				out << cancerName + ", " +cancerStatus
			}else if(cancerStatus){
				out << cancerStatus
			}else if(cancerName){
				out << cancerName
			}else{
				out << "";
			}
		}
	}
	def patientDetails = {attrs ->
		def personId = attrs.get("personId")
		def personDetail=""
		if(personId) {
			PatientAddress address = PatientAddress.findByPatient(Patient.findByPerson(Person.get(personId)))
			if(address){
				def city = address?.address?.city
				def state = address?.address?.state
				personDetail = city+", "+state
			}
			out << personDetail;
		}else{

		}
	}
	def groupMessages={attrs ->
		def loginUser = attrs.get("currentUser");
		def groupId =attrs.getAt("groupId");
		def messageText = ""
		if(loginUser) {
			def messages = Message.createCriteria().list {
				eq('messageGroup',MessageGroup.get(groupId))
				order('rowCreated','asc')
			}
			if(messages){
				messages.each {   messageText= it?.messageText;}
			}
			if(messageText.length()>20){
				messageText=messageText.substring(0, 18)+"..";
			}else{
			}
			out << messageText
		}else{

		}
	}
	def groupMembers= {attrs ->
		def loginUser = attrs.get("currentUser");
		def groupName =attrs.getAt("groupName");
		def members=""
		if(loginUser){
			ArrayList list = new ArrayList();
			def currentPersonId = Patient.findByPerson(HealpalUser.get(loginUser?.id.toLong())?.person)?.person?.id;
			if(groupName){
				def patients = PatientMessageGroup.findAllByMessageGroup(MessageGroup.findByMessageGroupName(groupName))?.patient?.person;
				list.add("You");
				patients.each{
					if(it?.id !=currentPersonId){
						list.add(it?.fullName);
					}
				}
				def arrayToString = list.toString().substring(1,list.toString().length()-1);
				def length = arrayToString.length();
				if(length>80) {
					arrayToString = arrayToString.toString().substring(0, 80)+" ...";
				}else{

				}
				out << arrayToString;
			}
		}
	}
	def patientLastMessages={attrs ->
		def loginUser = attrs.get("currentUser")
		def receiverId = attrs.get("receiverId")
		def lastmsg="";
		ArrayList listofIds = new ArrayList()
		if(loginUser) {
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
					}
				}

				isNull('messageGroup')
				order('rowCreated','asc')
			}
			if(msg) {
				msg.each{ lastmsg = it?.messageText; }
			}
			if(lastmsg.length()>20) {
				lastmsg = lastmsg.toString().substring(0, 18)+"..";
			}
			out << lastmsg;
		}else{

		}
	}
	def groupMessagesDate={attrs->
		def loginUser = attrs.get("currentUser");
		def groupId =attrs.getAt("groupId");
		Date messageSent;
		if(loginUser) {
			def messages = Message.createCriteria().list {
				eq('messageGroup',MessageGroup.get(groupId))
				order('rowCreated','asc')
			}
			if(messages){
				messages.each { messageSent= it?.messageSent;}
			}
			if(messageSent !=null){
				DateFormat sdff = new SimpleDateFormat("MMM dd", Locale.US);
				String frmDateStr = sdff.format(messageSent);
				out << frmDateStr
			}
		}
	}
	def patientLastMessageDate={attrs ->
		def loginUser = attrs.get("currentUser")
		def receiverId = attrs.get("receiverId")
		Date msgSentDate;
		ArrayList listofIds = new ArrayList()
		if(loginUser) {
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
					}
				}

				isNull('messageGroup')
				order('rowCreated','asc')
			}
			if(msg) {
				msg.each{ msgSentDate = it?.rowCreated; }
			}
			if(msgSentDate !=null && msgSentDate!=""){
				DateFormat sdff = new SimpleDateFormat("MMM dd", Locale.US);
				String frmDateStr = sdff.format(msgSentDate);
				out << frmDateStr
			}
		}
	}
}

