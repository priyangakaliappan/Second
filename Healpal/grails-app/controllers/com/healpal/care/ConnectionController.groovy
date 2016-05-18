/*
 * Author      : Arunkumar K
 * Project     : Healpal
 * File        : ConnectionController
 * Date        : 13-11-2015
 * Description : Get connection list, send message to a connection, remove connection
 *
 * #   Name           Version           Modified-Date      Description
 * -------------------------------------------------------------------------------------
 * 1   Arunkumar K    1.0               13-11-2015         Initial Creation
 *
 */

package com.healpal.care

/**
 * 
 * @author Arunkumar K
 *
 */
class ConnectionController {
	static ConnectionService connectionService
	static DashboardService dashboardService
	def index() {
	}

	/**
	 * Get all the connections for the current user
	 * @return
	 */
	def list(){
		def connectionList = null;
		try{
			authorizeMe();
			HealpalUser user = session.user
			if(user){
				params.max = Math.min(params.max ? params.int('max') : 20, 100)
				session.searchConnection = null;
				connectionList = connectionService.getConnectionList(user,params);
			}
			
			//HealpalUser user = session.user
			if(params != null && params.connectionId && params.state){
				dashboardService.approveConnection(user, params);
			}else{
				//do nothing
			}
			//redirect(action:'getNewConnections')
			
			
			[connectionList:connectionList,connectActive:'active',total:connectionService.getTotalConnectionList(user)?.size(),offset:0 ,max : params.max]//photo:ProfilePhoto.findByPatient(Patient.findByPerson(HealpalUser.get(user?.id)?.person))?.profilePhotoPath]
		}catch(Exception exception){
			exception.printStackTrace();
		}
	}
	
	/**
	 * For paginate the connection listing page
	 * @return
	 */
	def ajaxPaginateConnection(){
		try{
			if(session.user && session.authority?.equalsIgnoreCase(Role.patient)){
				render (template :'searchConnections' ,model:[connectionList: session.searchConnection != null? connectionService.searchSessionConnectionList(params, session):connectionService.getConnectionList(session.user, params) ,total:params.size ,offset:params.offset ,max :params.max])
			}else{
					//do nothing
			}
		}catch(Exception exception){
			exception.printStackTrace()
			log.error(exception)
		}
	}


	/**
	 * Get all the messages
	 * @return
	 */
	def getMessageList(){
		try{
			authorizeMe();
			HealpalUser user = session.user
			if(user?.person){
			}
		}catch(Exception exception){
		}
	}

	/**
	 * Remove the connection
	 * @return
	 */
	def removeConnection(){
		try{
			authorizeMe();
			HealpalUser user = session.user
			if(params && params.patientId && user?.person){
				connectionService.removeConnection(params.patientId, user);
			}
			redirect action :'list'
		}catch(Exception exception){
		}
	}


	/**
	 * Search the connection for the current user
	 * @return
	 */
	def searchConnections(){
		def connectionList = null;
		try{
			if(session.user){
				//println ":::::::::::::params.selectValue:::::::"+params.selectValue
				//if((params.searchValue != null && params.searchValue != "") || (params.selectValue != null && params.selectValue != "")){
					HealpalUser user = session.user
					params.max = Math.min(params.max ? params.int('max') : 20, 100)
					connectionList = connectionService.searchConnectionList(user, params, session);
					//println "::::::::::::>>>>connectionList>>>>>>>>>>>>>>>>>>"+connectionList?.size()
					render(template:'searchConnections',model:[connectionList:connectionList,total:connectionService.getTotalSearchConnectionList(user, params)?.size(),offset:0 ,max : params.max]);
				//}else{
					//do nothing
				//}
			}else{
				//do nothing
			}
		}catch(Exception exception){
			exception.printStackTrace();
		}
	}

	/**
	 * Send a message
	 * @return
	 */
	def sendMessage(){
		try{
			authorizeMe();
			HealpalUser user = session.user
			if(user && params?.patientId && params.message){
				connectionService.sendMessage(user, params);
			}else{
				//do nothing
			}
			render ""
		}catch(Exception exception){
			exception.printStackTrace();
		}
	}

	/**
	 * Get days or a month for patient connection
	 * @param patientId
	 * @return
	 */
	def getDaysOrMonth(def patientId){
		authorizeMe();
		try{
			return connectionService.getDays(session.user, patientId);
		}catch(Exception exception){
			exception.printStackTrace();
		}
	}

	/**
	 * Check the Group name already exist or not
	 * @return
	 */
	def isGroupNameExist(){
		def isExist = "false";
		if(session.user){
			if(params != null && params.groupName != null && params.groupName != ""){
				isExist = connectionService.isGroupNameExist(params.groupName);
			}else{
				//do nothing
			}
			render isExist;
		}else{
			redirect controller :'auth' ,action :'doLogout'
		}
	}


	/**
	 * Create A group
	 * @return
	 */
	def createGroup(){
			if(session.user){
			HealpalUser user = session.user
			def connectionList = connectionService.searchConnectionList(user, params, session);
			if(request.post)
			{
				if(params != null && params.groupName!=null && !params.groupName !="" && params.members !=null){
					def groupCreated = connectionService.createGroup(session.user, params);
					/*def uploadPhoto = connectionService.saveGroupImage(params,request);*/
				}
				redirect(controller:'Dashboard', action:'viewMessage',params:[newGroupName:params.groupName])
			}
			[connectionList:connectionList]
		}else{
			//do nothing
		}
		//render "-"
	}
	def cancel(){
		redirect(action:'list')
	}

	/**
	 * Authorize and allow to access
	 * @return
	 */
	def authorizeMe(){
		if(session.user && session.authority?.equalsIgnoreCase(Role.patient)){
			// do nothing
		}else{
			redirect controller :'auth' ,action :'doLogout'
		}
	}
	
}
