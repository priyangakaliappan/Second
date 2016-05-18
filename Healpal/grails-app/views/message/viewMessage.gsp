<!--  
 * Author    : Arunkumar K
 * Project   : Healpal
 * File      : viewMessage
 * Date      : 23-10-2015
 *
 * #   Name           Version           Modified-Date      Description
 * -------------------------------------------------------------------------------------
 * 1   Arunkumar K    1.0               23-10-2015         Initial Creation
 *
 */-->
<%@page import="com.healpal.encryptdecrypt.CryptographyUtil"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="layout" content="main" />
<title>::.. Healpal | View Message ..::</title>
<style type="text/css">
.patientName {
	font-weight: bold;
	color: #7C7C7C;
}
</style>
</head>
<body>
	<div>
		<h1>View Messages</h1>
		<div id="messageBody">
			<g:if test="${patientMessages}">
				<g:each in="${patientMessages}" status="i" var="message">
					<span class="patientName"> ${message.patientByPatientFkSender?.person?.firstName+'  '}
						<g:formatDate format="hh:mm a" date="${message?.rowCreated}" />
					</span>
					<div>
						<span> ${CryptographyUtil.decrypt(message.messageText)}
						</span>
					</div>

				</g:each>
			</g:if>
		</div>
		<g:textArea name="message" id="messageId"></g:textArea>
		<a href="" onclick="sendMessage();">SEND</a>

	</div>

	<script type="text/javascript"
		src="${resource(dir:'assets/js',file:'jquery-1.11.1.js')}"></script>
	<script type="text/javascript">
		function sendMessage() {
			var message = $.trim($("#messageId").val());
			$("#messageId").val("");
			if (message != null && message != "") {
				<g:remoteFunction controller="message" action="replyMessage" params="{'message':message}"/>
			} else {
				//do nothing
			}
		}

		
		$("document").ready(function() {
			setInterval(function() {
				$.ajax({
					async : false,
					type : 'POST',
					url : '../message/getAllMessages',
					data : {},
					success : function(res) {
						$("#messageBody").html(res);
					}
				});
			}, 500); // 0.5 seconds
		});
	</script>
</body>
</html>