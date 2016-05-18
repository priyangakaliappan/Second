<%@page import="java.lang.System"%>
<%@page import="com.healpal.care.Patient"%>
<%@page import="com.healpal.care.HealpalUser"%>
<%@page import="com.healpal.care.Person"%>
<%@page import="java.lang.System"%>
<%@page import="com.healpal.care.PatientChat"%>
<%@page import="com.healpal.care.ConnectionService"%>
<%@page import="com.healpal.care.DashboardController"%>
<%@page import="com.healpal.care.ReferralsService"%>
<%@page import="com.healpal.care.Referrals"%>
<%@page import="com.healpal.care.ReferralCategory"%>


<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
<div id="messagePopUp" class="msg-notify">
	<%
    DashboardController getMessage=new DashboardController();
	def message = getMessage?.view()?.messageMap;
	def photo=getMessage?.view()?.photo
	def mess=getMessage?.getMessagesCount()?.messageMaps
	def groupMessages = getMessage?.view()?.groupMessages;
 %>
	<nav id="colorNav">
		<ul>
			<li class="col-lg-4 col-md-4 pad-rt-0">
				<div>
					<i class="header-mail pull-left"></i>
					<g:if test="${message?.size() != 0 || groupMessages?.size() !=0}">
						<span class="alert-text" id="messageCount"><g:patientMessages
								currentUser="${session.user}" />
						</span>
					</g:if>
				</div>
				<ul class="list_ul message-dropdown drop-tab-menu">
					<li class="message-dropdown-tit"><a href="javascript:void(0)"
						onclick="messages()" id="msgId">Message</a><a href="javascript:void(0)"
						onclick="groupmessages()" id="messagegroupId">Group Message</a></li>
					<g:if test="${mess || groupMessages}">
						<g:if test="${mess}">
							<g:each in="${mess}" var="messageList" status="i">
								<g:hiddenField name="msg" id="viewAllId"
									value="${messageList?.getKey()?.id}" />
								<%def patientPhoto=getMessage?.getPersonsProfileImage(messageList?.getKey()?.person?.id)%>
								<g:if test="${i<5}">
									<li class="message active-msg"
										id="msg+${messageList?.getKey()?.id}">
										<div class="message-cont-left pull-left">
											<g:if test="${patientPhoto}">
												<img
													src="${resource(dir:'assets/patient-photo',file:patientPhoto)}">
											</g:if>
											<g:else>
												<img
													src="${resource(dir:'assets/patient-photo',file:'noimage.jpg')}">
											</g:else>
										</div>
										<div class="pull-left message-cont-right">
											<div class="left_div">
												<h4>
													<div style="color: #f15922">
														${messageList?.getKey()?.person?.fullName}
													</div>
												</h4>
												<g:link controller="dashboard" action="viewMessage"
													params="[patientId:messageList?.getKey()?.id]">
													<h5>

														<g:if
															test="${messageList?.getValue()?.get(0)?.messageText.toString()?.size()<20}">
															<g:if
																test="${messageList?.getValue()?.get(0)?.messageViewed == null || messageList?.getValue()?.get(0)?.messageViewed == ""}">
																<span style="background-color: #e8e8e8;">
																		${messageList?.getValue()?.get(0)?.messageText} (<g:patientNewMessages currentUser="${session.user}" senderId="${messageList?.getKey()?.id}" />)
																</span>
															</g:if>
															<g:else>
																${messageList?.getValue()?.get(0)?.messageText}
															</g:else>
														</g:if>
														<g:elseif
															test="${messageList?.getValue()?.get(0)?.messageText.toString().size()>20}">
															<g:if
																test="${messageList?.getValue()?.get(0)?.messageViewed == null || messageList?.getValue()?.get(0)?.messageViewed == ""}">
																<span style="background-color: #e8e8e8"> ${messageList?.getValue()?.get(0)?.messageText.toString().substring(0, 15).toString()+".. "}
																		(<g:patientNewMessages currentUser="${session.user}" senderId="${messageList?.getKey()?.id}" />)
																</span>
															</g:if>
															<g:else>
																${messageList?.getValue()?.get(0)?.messageText.toString().substring(0, 20).toString()+".."}
															</g:else>
														</g:elseif>
													</h5>
												</g:link>
											</div>
											<div class="right_div date-font">
												<g:formatDate format="MMM dd"
													date="${messageList?.getValue()?.get(0)?.messageSent}" />
											</div>
										</div>


										<div class="clearfix"></div>
									</li>
								</g:if>
							</g:each>
						</g:if>
						<g:if test="${groupMessages}">
							<g:each in="${groupMessages}" var="messageList1" status="j">
								<g:if test="${j<5}">
									<li class="group-message active-msg"
										id="group+${messageList1?.getKey()?.id}">
										<div class="message-cont-left pull-left">
											<g:if test="${messageList1?.getKey()?.groupPhotoName !=null}">
												<img
													src="${resource(dir:'assets/group-photo',file:messageList1?.getKey()?.groupPhotoName)}">
											</g:if>
											<g:else>
												<img
													src="${resource(dir:'assets/patient-photo',file:'noimage.jpg')}">
											</g:else>
										</div>
										<div class="pull-left message-cont-right">
											<div class="left_div">
												<h4 style="color: #f15922">
												<div>${messageList1?.getKey()?.messageGroupName}</div>

												</h4>
												<g:link controller="dashboard" action="viewMessage"
													params="[messageGroupId:messageList1?.getKey()?.id]">
													<h5>
														<%--<g:if test="${messageList?.getKey()?.person?.emailAddress == session.user?.person?.emailAddress}">
															
															
															</g:if>
															<g:else>
																--%>
														<g:if
															test="${messageList1?.getValue()?.get(0)?.messageText.toString()?.size()<15}">
															<span style="background-color: #e8e8e8">
																	${messageList1?.getValue()?.get(0)?.messageText} (${messageList1?.getValue()?.size()})
															</span>
														</g:if>
														<g:elseif
															test="${messageList1?.getValue()?.get(0)?.messageText.toString().size()>=15}">
															<span style="background-color: #e8e8e8">
																	${messageList1?.getValue()?.get(0)?.messageText.toString().substring(0, 13).toString()+".."}
																	(${messageList1?.getValue()?.size()})
															</span>
														</g:elseif>
													</h5>
												</g:link>
											</div>
											<div class="right_div">
												<g:formatDate format="MMM dd"
													date="${messageList1?.getValue()?.get(0)?.messageSent}" />
											</div>
										</div>

										<div class="clearfix"></div>
									</li>
								</g:if>
							</g:each>
						</g:if>
						<li class="viewall-link">
							<div align="center">
								<g:link controller="dashboard" action="viewMessage"
									params="[menuMessages:true]">
									<span style="color: red" id="viewAll">View All</span>
								</g:link>
							</div>

						</li>


					</g:if>
					<g:else>
						<li><span>No New Messages</span></li>
					</g:else>
				</ul>
			</li>
		</ul>
	</nav>



	<%--Accept --%>
	<%
						DashboardController ds=new DashboardController();
						def acceptList=ds.view()?.acceptList
						def connectionList=ds.view()?.connectionList
						
						def referralsList = ReferralsService.getNotifications(session.user);
						%>
	<nav id="colorNav">
		<ul>
			<li class="col-lg-4 col-md-4 pad-rt-0">
				<div>
					<i class="alarm-icon pull-left"></i>
					<g:if
						test="${acceptList?.size() != 0 || referralsList?.size() != 0}">
						<span class="alert-text"> <%=acceptList?.size() + referralsList?.size()%></span>
					</g:if>
				</div>
				<ul class="list_ul message-dropdown">
					<li class="message-dropdown-tit"><a href="#">Notifications</a></li>
					<g:if test="${acceptList || referralsList}">
						<g:each in="${acceptList}" var="newConnection" status="i">
							<g:if test="${i <= 4}">
								<li><g:if test="${i<=3}">

										<g:if test="${newConnection.approveRequest == 1}">

											<div class="message-cont-left pull-left">
												<%def patientFK2Photo=getMessage?.getPersonsProfileImage(newConnection?.patientByPatientFk2?.person?.id)
														%>
												<g:if test="${patientFK2Photo}">
													<img
														src="${resource(dir:'assets/patient-photo',file:patientFK2Photo)}">
												</g:if>
												<g:else>
													<img
														src="${resource(dir:'assets/patient-photo',file:'noimage.jpg')}">
												</g:else>
											</div>
											<div class="pull-left message-cont-right">

												<div class="left_div">
													<h4 style="color: #f15922">
														${newConnection?.patientByPatientFk2?.person?.fullName}
													</h4>
												</div>
												<div class="right_div">
													<h6>
														<g:formatDate format="MMM dd"
															date="${newConnection.rowCreated}" />
													</h6>
												</div>
												<div class="clearfix"></div>
												<%--<div><g:link controller="dashboard" action="approveConnection" params="[connectionId: connection?.id, state: 'approve']" onclick="return approveConnection();">Approve</g:link>
																		<g:link controller="dashboard" action="approveConnection" params="[connectionId: connection?.id, state: 'ignore']" onclick="return ignoreConnection();">Ignore</g:link></div>
																		--%>
												<div>
													<g:link controller="connection" action="list"
														params="[connectionId: newConnection?.id, state: 'ok']">
														<p>Accepted your Invitation to Connect.</p>
													</g:link>
												</div>
											</div>
										</g:if>

										<div class="clearfix"></div>
									</g:if> <%--<g:elseif test="${i==4}">
															<div align="center" style="color: red;">
																<g:link controller="dashboard"
																	action="getNewConnections">
																	<h5>Show All</h5>
																</g:link>
															</div>
														</g:elseif>--%></li>
							</g:if>
						</g:each>


						<!-- Referrals Notification -->
						<g:each in="${referralsList}" var="ref">
							<li>
								<div class="message-cont-left pull-left">
									<%def patientFK2Photo = getMessage?.getPersonsProfileImage(ref?.patientByPatientFkSender?.person?.id)
																%>
									<g:if test="${patientFK2Photo}">
										<img
											src="${resource(dir:'assets/patient-photo',file:patientFK2Photo)}">
									</g:if>
									<g:else>
										<img
											src="${resource(dir:'assets/patient-photo',file:'noimage.jpg')}">
									</g:else>
								</div>
								<div class="pull-left message-cont-right">
									<div class="left_div">
										<h4 style="color: #f15922">
											${ref?.patientByPatientFkSender?.person?.fullName}
										</h4>
									</div>
									<div class="right_div">
										<h6>
											<g:formatDate format="MMM dd" date="${ref.rowCreated}" />
										</h6>
									</div>
									<div class="clearfix"></div>
									<div>
										<g:link controller="referrals" action="received"
											params="[refId: ref?.id]">
											<g:if
												test="${ref?.referralType.equalsIgnoreCase(Referrals.request)}">
												<p>
													has requested for a recommendation for a
													<g:if
														test="${ref?.referralCategory?.categoryName.equalsIgnoreCase(ReferralCategory.expert)}">physician</g:if>
													<g:else>clinical trial</g:else>
												</p>
											</g:if>
											<g:elseif
												test="${ref?.referralType.equalsIgnoreCase(Referrals.provide)}">
												<p>
													has provided a recommendation for a
													<g:if
														test="${ref?.referralCategory?.categoryName.equalsIgnoreCase(ReferralCategory.expert)}">physician</g:if>
													<g:else>clinical trial</g:else>
												</p>
											</g:elseif>

										</g:link>
									</div>
								</div>
								<div class="clearfix"></div>
							</li>
						</g:each>
					</g:if>
					<g:else>
						<li><span>No New Notifications</span></li>
					</g:else>
				</ul>
			</li>
		</ul>
	</nav>


	<%--	connectionList--%>
	<nav id="colorNav">
		<ul>
			<li class="col-lg-4 col-md-4 pad-rt-0">
				<div>
					<i class="header-image1 pull-left"></i>
					<g:if test="${connectionList?.size() != 0}">
						<span class="alert-text" id="connectCountid"> <g:patientConnections
								currentUser="${session.user}" /></span>
					</g:if>
				</div>
				<ul class="list_ul message-dropdown">
					<li class="message-dropdown-tit"><a href="#">Add
							Connections${i}
					</a></li>



					<g:if test="${connectionList}">
						<g:each in="${connectionList}" var="newConnection" status="i">
							<g:if test="${i <= 4}">
								<li id="connecRes1${i}"><g:if test="${i<=3}">
										<g:if test="${newConnection.approveRequest == 0}">

											<%def patientFK1Photo=getMessage?.getPersonsProfileImage(newConnection?.patientByPatientFk1?.person?.id)%>
											<div class="message-cont-left pull-left">
												<g:if test="${patientFK1Photo}">
													<img
														src="${resource(dir:'assets/patient-photo',file:patientFK1Photo)}">
												</g:if>
												<g:else>
													<img
														src="${resource(dir:'assets/patient-photo',file:'noimage.jpg')}">
												</g:else>
											</div>
											<div class="pull-left message-cont-right">

												<div class="left_div">
													<h4 style="color: #f15922">
														${newConnection?.patientByPatientFk1?.person?.fullName}
													</h4>

												</div>
												<div class="right_div">
													<h6>
														<g:formatDate format="MMM dd"
															date="${newConnection.rowCreated}" />
													</h6>
												</div>
												<div class="clearfix"></div>
												<div id="connecRes${i}">
													<p>Sent an Invitation to Connect.</p>
													<div class="pull-left">
														<g:remoteLink
															url="[controller:'dashboard',action:'approveConnection']"
															params="[connectionId: newConnection?.id, state: 'approve']"
															update="connecRes${i }">
															<h5>Approve</h5>
														</g:remoteLink>
													</div>
													<div class="pull-left">
														<g:remoteLink
															url="[controller:'dashboard',action:'approveConnection']"
															params="[connectionId: newConnection?.id, state: 'ignore']"
															update="connecRes1${i}">
															<h5>Ignore</h5>
														</g:remoteLink>
													</div>
												</div>
											</div>

										</g:if>
									</g:if>

									<div class="clearfix"></div>
									<%--
														
														
														<li class="viewall-link">
												<div align="center">
													<g:link controller="dashboard" action="viewMessage" params="[menuMessages:true]">
														<span style="color: red" id="viewAll">View All</span>
													</g:link>
												</div>

											</li>
														
														--%>
									<g:if test="${i==4}">
										<div align="center" style="height: 5px">
											<g:link controller="dashboard" action="getNewConnections">
												<span
													style="color: red; top: 10px; padding: 8px 20px 0px 0px; position: absolute; margin-top: 344px;"
													id="viewAll">View All</span>
											</g:link>
										</div>
									</g:if></li>
							</g:if>
						</g:each>
					</g:if>
					<g:else>
						<li><span>No new Connection Requests</span></li>
					</g:else>
				</ul>
			</li>
		</ul>
	</nav>
</div>
<script type="text/javascript">

$(".group-message").hide();
$("#msgId").addClass('active');
function messages(){
	$(".group-message").hide();
	$("#msgId").addClass('active');
	$("#messagegroupId").removeClass('active');
	$(".message").show();
}
function groupmessages(){
	$(".message").hide();
	$("#msgId").removeClass('active');
	$("#messagegroupId").addClass('active');
	$(".group-message").show();
}
</script>

