<!--  
 * Author    : Arunkumar K
 * Project   : Healpal
 * File      : viewGroupMessage
 * Date      : 23-10-2015
 *
 * #   Name           Version           Modified-Date      Description
 * -------------------------------------------------------------------------------------
 * 1   Arunkumar K    1.0               23-10-2015         Initial Creation
 *
 */-->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="layout" content="care">
<title>::.. Healpal | View Group Message ..::</title>
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
						<g:if test="${messageGroupId}">
							<g:hiddenField name="messageGroupId" id="messageGroupId"
								value="${messageGroupId}" />
						</g:if>
						<div id="messages">
							<h3>Group Messages</h3>
							<div id="messageBody" style="width: 550px; height: 250px;">
								<g:if test="${groupMessageList}">
									<g:each in="${groupMessageList}" status="i" var="message">
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
						<g:textArea name="message" id="messageId" rows="3" cols="60"></g:textArea>
						<div class="clearfix mar-bot-10"></div>
						<a href="" onclick="sendMessage();">Send</a>
						<g:link controller="dashboard" action="getGroupMessages"
							style="padding-left:1em">Cancel</g:link>
					</div>
				</div>
			</div>
		</div>
	</section>
	<script type="text/javascript"
		src="${resource(dir:'assets/js',file:'jquery-1.11.1.js')}"></script>
	<script type="text/javascript"
		src="${resource(dir:'assets/bootstrap/js',file:'bootstrap.min.js')}"></script>
	<script type="text/javascript"
		src="${resource(dir:'assets/js',file:'jquery.colorbox.js')}"></script>
	<script type="text/javascript"
		src="${resource(dir:'assets/js',file:'custom.js')}"></script>
	<script type="text/javascript">
		function sendMessage() {
			var message = $.trim($("#messageId").val());
			var groupId = $.trim($("#messageGroupId").val());
			if (message != null && message != "" && groupId != null
					&& groupId != "") {
				<g:remoteFunction controller="dashboard" action="replyMessage" params="{'message':message, 'groupId':groupId}"/>
			} else {
				//do nothing
			}
		}

		$("document").ready(function() {
			setInterval(function() {
				$.ajax({
					async : false,
					type : 'POST',
					url : '../dashboard/groupMessages',
					data : {
						messageGroupId : $("#messageGroupId").val()
					},
					success : function(res) {
						$("#messageBody").html(res);
					}
				});
			}, 500); // 0.5 seconds

			$("#messageId").click(function() {
				var groupId = $.trim($("#messageGroupId").val());
				if (groupId != null && groupId != "") {
					$.ajax({
						async : false,
						type : 'POST',
						url : '../dashboard/updatePatientViewGroupMessage',
						data : {
							messageGroupId : groupId
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