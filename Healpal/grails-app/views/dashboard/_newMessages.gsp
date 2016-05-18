<%@page import="com.healpal.care.DashboardController"%>
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
				<img width="50" src="${resource(dir:'assets/patient-photo',file:'noimage.jpg')}" width="50" height="50">
			</g:else>
		</div>
		<div class="col-md-10 col-xs-10 pad-rt-0">
			<g:if test="${groupName}">
				<h4 style="color: white; font-size: 15px;">
					${groupName}
				</h4>
				<p style="font-size: 13.5px;height:21px;overflow: hidden;">
					<g:groupMembers currentUser="${session.user}" groupName="${groupName}" />
				</p>
			</g:if>
			<g:else>
				<h4 style="color: white; font-size: 15px;">
					${personName?.fullName}
				</h4>
				<p style="font-size: 13.5px;height:21px;overflow: hidden;">
					<g:patientDetails personId="${personName?.id}" />
				</p>
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
					<%
						DashboardController getMessages=new DashboardController();
					    def dates=getMessages.getUniqueDate(message?.rowCreated);
 						if(!map.containsKey(dates) && dates !=null ){
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
<div class="col-sm-3 col-xs-12 linked-profile-right"></div>
<script type="text/javascript">
				var element = document.getElementById('messageLists');
				element.scrollTop = element.scrollHeight; // added design for selecting members 
</script>


