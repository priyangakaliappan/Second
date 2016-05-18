<!--  
 * Author    : Arunkumar K
 * Project   : Healpal
 * File      : viewAllMessage
 * Date      : 23-10-2015
 *
 * #   Name           Version           Modified-Date      Description
 * -------------------------------------------------------------------------------------
 * 1   Arunkumar K    1.0               23-10-2015         Initial Creation
 *
 */-->
  <%@page import="com.healpal.care.DashboardController"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="layout" content="care">
<title>::.. Healpal | View All Messages ..::</title>
</head>
<body>
	<g:render template="../template/careMenu"></g:render>
	<%
	DashboardController getMessage=new DashboardController();
	def messagess = getMessage?.view()?.messageMap;
				def photo=getMessage?.view()?.photo
	def patientPhoto=getMessage?.view()?.profilePhoto
	def mess=getMessage?.getMessagesCount()?.messageMaps
%>
	<%--<section class="new-profile-bg">
		<div class="container">
			<div class="row">
				<div class="col-sm-12 col-xs-12">
					<div class="box-content6">
						<div class="col-sm-3 col-xs-12 dashboard-sidebar-left">
							<div class="dark-graybox">
								<div class="new-box-image">
									<g:if test="${photoView}">
										<img class="img-responsive"
											src="${resource(dir:'assets/patient-photo',file:photoView)}">
									</g:if>
									<g:else>
										<img class="img-responsive"
											src="${resource(dir:'assets/patient-photo',file:'noimage.jpg')}">
									</g:else>
								</div>
								<g:link controller="profile" action="viewProfile"
									class="view-btn">View Profile</g:link>
								<g:link controller="profile" action="editProfile"
									class="edit-btn">Edit Profile</g:link>
							</div>
						</div>
						<g:if test="${patientTo}">
							<g:hiddenField name="to" id="patientToId" value="${patientTo}" />
						</g:if>
						<div id="messages">
							<h3>Messages</h3>
							<div id="messageBody" style="width: 550px; height: 250px;">
								<g:if test="${messageList}">
									<g:each in="${messageList}" status="i" var="message">
										<div>
											<g:if
												test="${message?.patientByPatientFkSender?.person?.firstName == person?.firstName}">
												<span
													style="background-color: #cfedfb; line-height: 17px; float: right; padding: 5px 10px; white-space: pre-line; font-size: 13px; font-style: normal; max-width: 40%; display: inline-block; color: #333;">
													${message?.messageText} <br> <g:formatDate
														format="hh:mm a" date="${message?.rowCreated}" />
												</span>
											</g:if>
											<g:else>
												<span
													style="background-color: #F0FFFF; line-height: 17px; float: left; padding: 5px 10px; white-space: pre-line; font-size: 13px; font-style: normal; max-width: 40%; display: inline-block; color: #333;">
													${message?.patientByPatientFkSender?.person?.firstName+'  '}:${message?.messageText}
													<br> <g:formatDate format="hh:mm a"
														date="${message?.rowCreated}" />
												</span>
											</g:else>
											<br>
										</div>
									</g:each>
								</g:if>
							</div>
						</div>
						<g:textArea name="message" id="messageId" rows="3" cols="55"></g:textArea>
						<div class="clearfix mar-bot-10"></div>
						<a href="" onclick="sendMessage();">Send</a>
						<g:link controller="dashboard" action="getAllMessages"
							style="padding-left:1em">Cancel</g:link>
					</div>
				</div>
			</div>
		</div>
	</section>

	--%><section class="new-profile-bg">
		<div class="container">
			<div class="row">
				<div class="col-sm-12 col-xs-12">
					<div class="linked-profile">
						<div class="col-sm-3 col-xs-12 linked-profile-left">
							<div class="linked-top-box">
								<select>
									<option>All Messages</option>
									<option>All Messages1</option>
									<option>All Messages2</option>
									<option>All Messages3</option>
								</select>
								<a href="#" class="edit-btn-bg"><i class="fa fa-pencil-square-o"></i></a>
							</div>
							<div class="linkedin-search"><i class="fa fa-search"></i><input type="text" value="" class="text-box" placeholder="Search"></div>
							<div class="linked-profile-list">
								<ul class="nav nav-tabs tabs-left">
								<g:if test="${mess}">								
									<g:each in="${mess}" var="messageLists" status="i">
										<li class="active-ans" id="${messageLists?.getKey()?.id}">  <%--  class="active" --%>
										<g:link controller="dashboard" action="viewMessage" params="[patientId:messageLists?.getKey()?.id]">
											<div class="col-xs-3 pad-lt-0 pad-rt-10">
											<g:if test="${patientPhoto}">
											<img class="img-responsive" src="${resource(dir:'assets/patient-photo',file:patientPhoto?.profilePhotoPath)}"/>
											</g:if>
											<g:else>
											<img  width="50" src="${resource(dir:'assets/patient-photo',file:'noimage.jpg')}" width="50" height="50">
											</g:else>
											</div>
											<div class="col-xs-7 pad-lt-0"><h4>${messageLists?.getKey()?.person?.fullName}</h4><small>some text goes here</small></div>
											<div class="col-xs-2 pad-lr-0 tab-date-last"><g:formatDate date="${messageLists?.getKey()?.rowCreated}" type="date" style="MEDIUM"/></div>
										</g:link>
									</li>
									</g:each>
									</g:if>
									</ul>
									<%--<li>
										<a href="#tabcont1" data-toggle="tab">
											<div class="col-xs-3 pad-lt-0 pad-rt-10"><img class="img-responsive" src="../assets/images/dashboard-image.jpg"></div>
											<div class="col-xs-7 pad-lt-0"><h4>xxxxxxxxxxxxxxxxxxx</h4><small>some text goes here</small></div>
											<div class="col-xs-2 pad-lr-0 tab-date-last">Nov 30</div>
										</a>
									</li>
								--%>
							</div>							
						</div>
						<div class="col-sm-6 col-xs-12 linked-profile-middle">
							<div class="tab-content">
								<div class="tab-pane active" id="tabcont1">
									<div class="linked-profile-header">
										<div class="col-md-1 col-xs-2 pad-lr-0">
										<%--<img class="img-responsive" src="../assets/images/dashboard-image.jpg">
										--%>
										<g:if test="${patientPhoto}">
											<img class="img-responsive" src="${resource(dir:'assets/patient-photo',file:patientPhoto?.profilePhotoPath)}"/>
											</g:if>
											<g:else>
											<img  width="50" src="${resource(dir:'assets/patient-photo',file:'noimage.jpg')}" width="50" height="50">
											</g:else>
										</div>
										<div class="col-md-10 col-xs-10 pad-rt-0"><h4>${personName?.fullName}</h4><small>some text goes here</small></div>
										<div class="col-xs-1 pad-lr-0 tab-date-last">&bull;&bull;&bull;</div>
									</div>
									<g:if test="${patientTo}">
									<g:hiddenField name="to" id="patientToId" value="${patientTo}" />
									</g:if>
									
									<div class="chat-cont-scroll">
									<g:if test="${messageList}">
									<div class="linked-chat-cont">
									<g:each in="${messageList}" status="i" var="message">
									<div class="col-xs-5 linked-chat-cont-l">	
										<g:if test="${message?.patientByPatientFkSender?.person?.firstName == person?.firstName}">									
												<div class="chat-text">${message?.messageText}</div>
												<div class="chat-time"><g:formatDate
														format="hh:mm a" date="${message?.rowCreated}" /></div>
											</g:if>
											<g:else>
											<div class="chat-text"> </div>
											<div class="chat-time"> </div>
											</g:else>
											</div>
											
											
											<div class="col-xs-2 linked-chat-cont-m">											
											<g:if test="${i==0}"><div class="chat-date-text"><g:formatDate date="${message?.rowCreated}" type="date" style="MEDIUM"/></div></g:if>		
											<g:else>
											
											<%--<g:if test="${j!=0}">
											<div class="chat-date-text"><g:formatDate date="${message?.rowCreated}" type="date" style="MEDIUM"/></div>	
											</g:if>
											<g:else>
											--%>
											<div class="chat-date-text">...</div>
											
											</g:else>
											</div>	
											
											
																					
											<div class="col-xs-5 linked-chat-cont-r text-right">
											<g:if test="${message?.patientByPatientFkSender?.person?.firstName != person?.firstName}">
												<div class="chat-text">${message?.patientByPatientFkSender?.person?.firstName+'  '}:${message?.messageText}</div>
												<div class="chat-time"><g:formatDate
														format="hh:mm a" date="${message?.rowCreated}" /></div>
														</g:if>
														<g:else><div class="chat-text">-</div>
												<div class="chat-time">.</div></g:else>
											</div>
											
											
											</g:each>
											
										</div>
										</g:if>
										
										</div>
									</div>
									<div class="chat-cont-btm">
									<g:textArea name="message" id="messageId" rows="3" cols="60"></g:textArea>
										<div>Click Here to <a href="" onclick="sendMessage();">reply</a> or <a href="#">forward</a></div>
										<div class="chat-cont-btm-right"><a href="#"><i class="fa fa-file-image-o"></i></a><a href="#"><i class="fa fa-upload"></i></a><a href="#"><i class="fa fa-smile-o"></i></a><div><input type="checkbox">&nbsp; Press enter to send</div></div>
									</div>
								</div>
								
							
							
						</div>
						<div class="col-sm-3 col-xs-12 linked-profile-right">
						
						</div>
						
					</div>
				</div>
			</div>
		</div>
	
	</section>
	<script type="text/javascript"
		src="${resource(dir:'assets/js',file:'jquery-1.11.1.js')}"></script>

	<script type="text/javascript">
		function sendMessage() {

			var message = $.trim($("#messageId").val());
			var patientId = $("#patientToId").val();
			$("#messageId").val("");
			if (message != null && message != "") {
				<g:remoteFunction controller="dashboard" action="replyMessage" params="{'message':message, 'patientId':patientId}"/>
			} else {
				//do nothing
			}
		}

		$("document").ready(function() {
			setInterval(function() {
				$.ajax({
					async : false,
					type : 'POST',
					url : '../dashboard/messages',
					data : {
						patientId : $("#patientToId").val()
					},
					success : function(res) {
						$("#messageBody").html(res);
					}
				});
			}, 500); // 0.5 seconds

			$("#messageId").click(function() {
				var patientId = $("#patientToId").val();
				if (patientId != null && patientId != "") {
					$.ajax({
						async : false,
						type : 'POST',
						url : '../dashboard/updatePatientViewMessage',
						data : {
							patientId : patientId
						},
						success : function(res) {

						}
					});
				}
			});
		});
	</script>
	<script type="text/javascript">
	$(document).ready(function(){
$(".header-search-box").hide();
		});
	</script>
</body>
</html>