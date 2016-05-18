<!--  
 * Author    : Arunkumar K
 * Project   : Healpal
 * File      : view
 * Date      : 23-10-2015
 *
 * #   Name           Version           Modified-Date      Description
 * -------------------------------------------------------------------------------------
 * 1   Arunkumar K    1.0               23-10-2015         Initial Creation
 *
 */-->
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.healpal.care.ReferralCategory" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<meta name="layout" content="care"> 
<title>Healpal</title>
	
</head>
<body>
  
  <g:render template="../template/careMenu"></g:render>
  
  <section class="new-profile-bg">
		<div class="container">
			<div class="row">
				<div class="col-sm-12 col-xs-12">
					<div class="box-content6">
						<div class="col-sm-3 col-xs-12 dashboard-sidebar-left">
							<div class="dark-graybox">
							<div class="new-box-image">
							<g:if test="${photoView}">
												   <img class="img-responsive" src="${resource(dir:'assets/patient-photo',file:photoView)}" width="180px">
												</g:if><g:else>
												  <img class="img-responsive" src="${resource(dir:'assets/patient-photo',file:'noimage.jpg')}">
												</g:else>
												</div>
								<g:link  controller="profile" action="viewProfile" class="view-btn" params="[viewProfile:true]">View Profile</g:link>
								<g:link  controller="profile" action="editProfile" class="edit-btn">Edit Profile</g:link>
							</div>
							
							<div class="dark-graybox1">
        <img
         src="${resource(dir:'assets/images',file:'Dashboard-image1.jpg')}"
         class="img-responsive" />
        <div class="text-center">
         <h2>Spread the Mission</h2>
         <a href="" class="view-profile-btn invite"  data-toggle="modal" data-target="#createGroup">Invite Friends</a>
        </div>
       </div>
						</div>
					
						<div class="col-sm-9 col-xs-12 dashboard-sidebar-right" id="messages">
						
						<g:render template="profileCompletionStatusBar"></g:render>
						
						<div class="box-cont1">
								<div class="box-cont1-titile"><i class="dashboard-message pull-left"></i><p>Messages</p></div>
								<ul>
									<li>
										<div class="col-sm-8 col-xs-12 pull-left">
											<g:if test="${messageMap?.size() > 0 || groupMessages?.size() > 0}">
												You have <g:link controller="dashboard" action="viewMessage" params="[menuMessages:true]">
													<g:if test="${messageMap || groupMessages}">
														<g:set var="messageCount" value="${messageMap?.size() + groupMessages?.size()}"/>
														<%--<g:set var="messageCount" value="${0}"/>
														<g:each in="${messageMap}" status="i" var="messageEntry">
															<g:set var="messageCount" value="${messageCount + messageEntry?.getValue()?.size()}"/>
														</g:each>
													--%></g:if>
												${messageCount} New</g:link> messages
											</g:if>
											<g:else>
												No New Messages
											</g:else>
										</div>
										<div class="col-sm-4 col-xs-12 pull-right text-right">
											<g:link controller="dashboard" action="viewMessage" params="[menuMessages:true]">All Messages</g:link>
										</div>
									</li>
								</ul>
							</div>
							
							<%--<div class="box-cont1">
								<div class="box-cont1-titile"><i class="dashboard-message pull-left"></i><p>Group Messages</p></div>
								<ul>
									<li>
										<div class="col-sm-8 col-xs-12 pull-left">
										<g:if test="${newMessageFromGroup?.size() > 1}">
											You have <g:link controller="dashboard" action="getGroupMessages"> ${newMessageFromGroup?.size()} New</g:link> group messages
										</g:if>
										<g:elseif test="${newMessageFromGroup?.size() > 0}">
											You have <g:link controller="dashboard" action="getGroupMessages"> ${newMessageFromGroup?.size()} New</g:link> group message
										</g:elseif>
										<g:else>
											You don&#146t have new group message
										</g:else>
										</div>
										<div class="col-sm-4 col-xs-12 pull-right text-right">
											<g:link controller="dashboard" action="getAllGroupMessages">View Group List</g:link>
										</div>
									</li>
								</ul>
							</div>--%>
							
							<%--<div class="box-cont1">
								<div class="box-cont1-titile"><i class="dashboard-img pull-left"></i><p>Authentications</p></div>
								<ul>
									<li>
										<div class="col-sm-4 col-xs-12 pad-rt-0"><input type="checkbox" name="text" value=""> Credit Card <div class="orange-text">Verified</div></div>
										<div class="col-sm-4 col-xs-12 pad-rt-0"><input type="checkbox" name="text" value=""> Medical Document <div class="orange-text">Verified</div></div>
										<div class="col-sm-4 col-xs-12 pad-rt-0"><input type="checkbox" name="text" value=""> Phone number <div class="orange-text">Verified</div> </div>
									</li>
								</ul>
							</div>
							--%><div class="box-cont1 ">
								<div class="box-cont1-titile"><i class="dashboard-img1 pull-left"></i><p>Connections</p></div>
								<ul>
									<li>
										<div class="col-sm-8 col-xs-12 pull-left">
											<g:if test="${connectionList?.size() > 0 ||  acceptList.size() > 0}">
												You have <g:link controller="dashboard" action="getNewConnections">${connectionList?.size() + acceptList.size()} New</g:link> Connections
											</g:if>
											<g:else>
												You have 0 New Connections
											</g:else>
										</div>
										<div class="col-sm-4 col-xs-12 pull-right text-right">
											<%--<a href="#">View</a>
										--%>
										<g:link controller="connection" action="list">View</g:link></div>
									</li>
								</ul>
							</div>
							<div class="box-cont1">
								<div class="box-cont1-titile"><div class="pull-left"><i class="dashboard-img2 pull-left"></i><p>Recommendations${session.ca13}</p> </div> 
								<div class="pull-right"><g:link controller="referrals" action="received" class="Referral-btn">View</g:link><g:link controller="referrals" action="provide" class="Referral-btn pull-right">Provide a recommendation</g:link><g:link controller="referrals" action="request" class="Referral-btn">Request a recommendation</g:link></div>	
								</div>
								<ul>
									<li>
										<div class="col-sm-8 col-xs-12 pull-left">
											<div class="col-sm-1 col-xs-2 pull-left pad-lr-0"><i class="dashboard-img3 pull-left"></i></div>
											<div class="col-sm-10 col-xs-10 pull-left pad-lr-0 box-cont2-pad"><p>Cancer Experts</p>You have recommendations to <g:if test="${expertCount !=0 && expertCount >0}"> <g:link controller="referrals" action="received" params="[from:'dashboard',referralCategory:ReferralCategory.expert]"> ${expertCount} </g:link></g:if><g:else> ${expertCount}</g:else> Cancer Experts</div> 
										</div>
									</li>
									<li>
										<div class="col-sm-8 col-xs-12 pull-left">
											<div class="col-sm-1 col-xs-2 pull-left pad-lr-0"><i class="dashboard-img4 pull-left"></i></div>
											<div class="col-sm-10 col-xs-10 pull-left pad-lr-0 box-cont2-pad"><p>Clinical Trials</p>You have recommendations to<g:if test="${clinicCount !=0 && clinicCount >0}"> <g:link controller="referrals" action="received" params="[from:'dashboard',referralCategory:ReferralCategory.trial]"> ${clinicCount} </g:link></g:if><g:else> ${clinicCount}</g:else> Clinical Trials</div> 
										</div>
									</li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Modal -->
	<div class="modal fade" id="createGroup" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<a href="#" class="close-icon" data-dismiss="modal"></a>
				<div class="modal-body">
				<div class="container">
	<span id="groupErr1" style="color: red"></span>
	<g:form class="form-horizontal popup-form" controller="dashboard">
	<h4>Invite your Friends</h4>
		<div class="form-group">
			<label class="control-label col-sm-3">Email id:</label>
			<div class="col-sm-9">
				<input type="text" id="emails" class="form-control" name="emailToInvite" placeholder="Enter Multiple Email using comma"/>
			</div>
		</div>
		
		<div class="form-group">
			<label class="control-label col-sm-3 hidden-xs">&nbsp;</label>
			<div class="col-sm-9">
				
				<g:actionSubmit class="btn btn-orange btn-send" value="Send" action="inviteFriends" onclick="return checkEmailValidation()"/>
				<a href="#" data-dismiss="modal" class="btn btn-orange btn-cancel">Cancel</a>
			</div>
	</g:form>
</div>
				
				</div>

			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->
	
	
	
	
	<script type="text/javascript">

	jQuery(function($){ 

	    // your code goes here

	});
	
	$(document).ready(function(){
		
		
		
$(".header-search-box").hide();
		});

	

	
	

	
		function viewNewMessages(){
			$.ajax({
				async : false,
				type : 'POST',
				url : '../dashboard/getMessages',
				data : {},
				success : function(res) {
					$("#messages").html(res);
				}
			});

			return false;
		}
	</script>
</body>
</html>