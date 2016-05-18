<!--  
 * Author    : Priyanga K
 * Project   : Healpal
 * File      : viewMessage
 * Date      : 23-10-2015
 *
 * #   Name           Version           Modified-Date      Description
 * -------------------------------------------------------------------------------------
 * 1   Priyanga K    1.0               23-10-2015         Initial Creation
 *
 */-->
<%@page import="com.healpal.care.DashboardController"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="layout" content="care">
<title>::.. Healpal | View Message ..::</title>
<style>
.input {
	font-size: 100%;
	width: 400px;
	height: 200px;
	font-family: times;
	border: 1px solid black;
	padding: 2px;
	margin: 2px;
}
</style>
</head>
<body>
	<g:render template="../template/careMenu"></g:render>
	<%
	DashboardController getMessage=new DashboardController();
	def messagess = getMessage?.view()?.messageMap;
	def photo=getMessage?.view()?.photo
	def mess = getMessage?.viewMessage()?.mess
	def groupLists = getMessage?.getAllGroupMessages()?.getAllGroups
%>
	<section class="new-profile-bg">
		<div class="container">
			<div class="row">
				<div class="col-sm-12 col-xs-12">
					<div class="linked-profile" id="messagePage">
						<div class="linked-profile-left">
							<div class="linked-top-box"></div>
							<div class="tab-tilte">
								<a href="javascript:void(0)" class="active" onclick="message()" id="viewMessageId">Message</a>
								<a href="javascript:void(0)" onclick="groupmessage()" id="viewGroupMessageId">Group Message</a>
							</div>
							<div class="linkedin-search search-textbox">
								<i class="fa fa-search"></i> <input type="text" value="" class="text-box" placeholder="Search" id="searchId" onkeyup="searchPerson()">
							</div>
							<div class="linked-profile-list chat-cont-scroll-left chat-pad-top"
								id="scrolldown">
								<g:hiddenField name="patientto" value="${patientTo}" id="patientTo" />
								<g:hiddenField name="messageGroupId" value="${messageGroupId}" id="messageGroupId" />
								<g:hiddenField name="newGroup" value="${newGroupId}" id="new-group" />
								<ul class="nav nav-tabs tabs-left" id="searchConnections">
									<g:if test="${mess}">
										<g:each in="${mess}" var="messageLists" status="i">
											<%def profilePhotoss=getMessage?.getPersonsProfileImage(messageLists?.getKey()?.person?.id)%>
											<li class="viewMessage active-ans" id="${messageLists?.getKey()?.id}"><a href="javascript:void(0)" onclick="patientMessage(this,'')" id="${messageLists?.getKey()?.id}">
													<div class="col-xs-3 pad-lt-0 pad-rt-10">
														<g:if test="${profilePhotoss}">
															<img src="${resource(dir:'assets/patient-photo',file:profilePhotoss)}" width="50" height="50" />
														</g:if>
														<g:else>
															<img src="${resource(dir:'assets/patient-photo',file:'noimage.jpg')}" width="50" height="50" />
														</g:else>
													</div>
													<div class="col-xs-7 pad-lt-0">
														<h4>
															${messageLists?.getKey()?.person?.fullName}
														</h4>
														<p style="font-size: 13.5px;height:21px;overflow: hidden;">
															<g:patientLastMessages currentUser="${session.user}" receiverId="${messageLists?.getKey()?.id}" />
														</p>
													</div>
													<div class="col-xs-2 pad-lr-0 tab-date-last">
														<g:patientLastMessageDate currentUser="${session.user}" receiverId="${messageLists?.getKey()?.id}" />
													</div>
											</a></li>
										</g:each>
									</g:if>
									<g:if test="${groupLists}">
										<g:each in="${groupLists}" var="messageLists1" status="i">
											<%def groupPhoto=getMessage?.getGroupImage(messageLists1?.id)%>
											<li class="viewGroup-message active-ans" id="${messageLists1?.id}"><a href="javascript:void(0)" onclick="patientMessage(this,'group')" id="${messageLists1?.id}">
													<div class="col-xs-3 pad-lt-0 pad-rt-10">
														<g:if test="${groupPhoto}">
															<img src="${resource(dir:'assets/group-photo',file:groupPhoto)}" width="50" height="50" />
														</g:if>
														<g:else>
															<img src="${resource(dir:'assets/patient-photo',file:'noimage.jpg')}" width="50" height="50" />
														</g:else>
													</div>
													<div class="col-xs-7 pad-lt-0">
														<h4>${messageLists1?.messageGroupName}</h4>
														<p style="font-size: 13.5px;height:21px;overflow: hidden;"><g:groupMessages currentUser="${session.user}" groupId="${messageLists1?.id}" /></p>
													</div>
													<div class="col-xs-2 pad-lr-0 tab-date-last">
														<g:groupMessagesDate currentUser="${session.user}" groupId="${messageLists1?.id}" />
													</div>
											</a></li>
										</g:each>
									</g:if>
								</ul>
							</div>
						</div>
						<div class="linked-profile-middle">
							<div class="tab-content">
								<div class="tab-pane active" id="tabcont1">
									<div class="linked-profile-header">
										<div class="col-md-1 col-xs-2 pad-lr-0">
											<g:if test="${profilePhoto}">
												<img src="${resource(dir:'assets/patient-photo',file:profilePhoto)}" width="50" height="50" />
											</g:if>
											<g:elseif test="${groupPhoto}">
												<img src="${resource(dir:'assets/group-photo',file:groupPhoto)}" width="50" height="50" />
											</g:elseif>
											<g:else>
												<img src="${resource(dir:'assets/patient-photo',file:'noimage.jpg')}" width="50" height="50">
											</g:else>
										</div>
										<div class="col-md-10 col-xs-10 pad-rt-0">
											<g:if test="${groupName}">
												<h4 style="color: white; font-size: 15px;"> ${groupName}</h4>
												<p style="font-size: 13.5px;height:21px;overflow: hidden;"><g:groupMembers currentUser="${session.user}" groupName="${groupName}" /></p>
											</g:if>
											<g:else>
												<h4 style="color: white; font-size: 15px;">${personName?.fullName}</h4>
												<p style="font-size: 13.5px;height:21px;overflow: hidden;"><g:patientDetails personId="${personName?.id}" /></p>
											</g:else>
										</div>
										<%--<div class="col-xs-1 pad-lr-0 tab-date-last">&bull;&bull;&bull;</div>--%>
									</div>
									<g:if test="${patientTo}">
										<g:hiddenField name="to" id="patientToId" value="${patientTo}" />
									</g:if>
									<div class="chat-cont-scroll" id="messageLists">
										<g:if test="${messageList}">
											<div class="linked-chat-cont">
												<%HashMap map=new HashMap();%>
												<g:each in="${messageList}" status="i" var="message">
													<% DashboardController getMessages=new DashboardController();
														def dates=getMessages.getUniqueDate(message?.rowCreated);
														if(!map.containsKey(dates) && dates!=null){
														map.put(dates, message?.id);
														}
														%>

													<div class="col-xs-12 linked-chat-cont-m">
														<g:if test="${map.containsValue(message?.id)}">
															<div class="chat-date-text">
																<g:formatDate date="${message?.rowCreated}" format="MMM dd" />
															</div>
														</g:if>
														<g:else>
															<div class="chat-date-text">&nbsp;</div>
														</g:else>
													</div>
													<div class="col-xs-5 linked-chat-cont-l">
														<g:if test="${message?.patientByPatientFkSender?.person?.fullName == person?.fullName}">
															<div class="chat-text">
																${message?.messageText}
															</div>
															<div class="chat-time">
																<g:formatDate format="hh:mm a" date="${message?.rowCreated}" />
															</div>
														</g:if>
														<g:else>
															<div class="chat-text" style="background-color: white;">&nbsp;</div>
															<div class="chat-time" style="background-color: white;">&nbsp;</div>
														</g:else>
													</div>

													<div class="col-xs-5 linked-chat-cont-r pull-right text-right pad-lt-0">
														<g:if test="${message?.patientByPatientFkSender?.person?.fullName != person?.fullName}">
															<div class="chat-text">
																${message?.messageText}
															</div>
															<div class="chat-time">
																<g:formatDate format="hh:mm a" date="${message?.rowCreated}" />
															</div>
														</g:if>
														<g:else>
															<div class="chat-text" style="background-color: white;">&nbsp;</div>
															<div class="chat-time" style="background-color: white;">&nbsp;</div>
														</g:else>
													</div>
												</g:each>
											</div>
										</g:if>


										<g:if test="${groupMessageList}">
											<div class="linked-chat-cont">
												<%HashMap map1=new HashMap();%>
												<g:each in="${groupMessageList}" status="j" var="message1">
													<% DashboardController getMessages1=new DashboardController();
														def dates1=getMessages1.getUniqueDate(message1?.rowCreated);
														if(!map1.containsKey(dates1) && dates1!=null){
														map1.put(dates1, message1?.id);
														}
														%>
													<div class="col-xs-12 linked-chat-cont-m">
														<g:if test="${map1.containsValue(message1?.id)}">
															<div class="chat-date-text">
																<g:formatDate date="${message1?.rowCreated}" format="MMM dd" />
															</div>
														</g:if>
														<g:else>
															<div class="chat-date-text">&nbsp;</div>
														</g:else>
													</div>
													<div class="col-xs-5 linked-chat-cont-l">
														<g:if test="${message1?.patientByPatientFkSender?.person?.firstName == person?.firstName}">
															<div class="chat-text">
																${message1?.messageText}
															</div>
															<div class="chat-time">
																<g:formatDate format="hh:mm a" date="${message1?.rowCreated}" />
															</div>
														</g:if>
														<g:else>
															<div class="chat-text" style="background-color: white;">&nbsp;</div>
															<div class="chat-time" style="background-color: white;">&nbsp;</div>
														</g:else>
													</div>
													<div class="col-xs-5 linked-chat-cont-r pull-right text-right">
														<g:if test="${message1?.patientByPatientFkSender?.person?.firstName != person?.firstName}">
															<div class="chat-text">
																${message1?.patientByPatientFkSender?.person?.firstName+'  '}:
																${message1?.messageText}
															</div>
															<div class="chat-time">
																<g:formatDate format="hh:mm a" date="${message1?.rowCreated}" />
															</div>
														</g:if>
														<g:else>
															<div class="chat-text" style="background-color: white;">&nbsp;</div>
															<div class="chat-time" style="background-color: white;">&nbsp;</div>
														</g:else>
													</div>
												</g:each>

											</div>
										</g:if>
									</div>
								</div>

								<div class="chat-cont-btm chat-link-box">
									<g:textArea name="message" id="textmessage" rows="3" cols="103" maxlength="200"></g:textArea>
									<div>
										<%--<p><a href="javascript:void(0);" id="checkLink" onclick="spellcheck()"> <img src="${resource(dir:'assets/icon',file:'spell-check-disable.png')}"> </a></p>
										--%><h4>
											Click here to<span onclick="sendMessage();">
												<button type="button" name="edit" class="editLink">reply</button>
											</span>
										</h4>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<script type="text/javascript" src="${resource(dir:'js/dashboard',file:'view_message.js')}"></script>
	<script src="../js/dashboard/spellcheck.js"></script>
	<script src="../js/dashboard/csshttprequest.js"></script>
	<link rel="stylesheet" type="text/css" media="screen" href="../css/spellcheck.css" />
 	
	<script type="text/javascript">

		//spell checking
		function spellcheck(){AtD.checkTextAreaCrossAJAX('textmessage', 'checkLink', '<img alt="Spell Check" src="../assets/icon/spell-check-enable.png">');}

		$(".viewMessage:first").addClass("active");
		
		if ($("#patientTo").val() != null && $("#patientTo").val() != ""
				&& $("#patientTo").val() != "undefined") {
			$(".viewMessage").removeClass("active");
			$("#" + $("#patientTo").val()).addClass("active");
		}
		if ($("#messageGroupId").val() != null
				&& $("#messageGroupId").val() != ""
				&& $("#messageGroupId").val() != "undefined") {
			$(".viewMessage").hide();
			$(".viewGroup-message").show();
			$("#viewMessageId").removeClass("active");
			$("#viewGroupMessageId").addClass("active");
			$(".viewGroup-message").removeClass("active");
			$("#" + $("#messageGroupId").val()).addClass("active");
		}
		if ($("#new-group").val() != null && $("#new-group").val() != ""
				&& $("#new-group").val() != "undefined") {
			$(".viewMessage").hide();
			$(".viewGroup-message").show();
			$("#viewMessageId").removeClass("active");
			$(".viewMessage").removeClass("active");
			$("#viewGroupMessageId").addClass("active");
			$(".viewGroup-message").removeClass("active");
			$("#" + $("#new-group").val()).addClass("active");
		}
		
	</script>
</body>
</html>