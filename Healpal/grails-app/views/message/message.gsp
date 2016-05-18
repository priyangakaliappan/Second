<!--  
 * Author    : Arunkumar K
 * Project   : Healpal
 * File      : message
 * Date      : 23-10-2015
 *
 * #   Name           Version           Modified-Date      Description
 * -------------------------------------------------------------------------------------
 * 1   Arunkumar K    1.0               23-10-2015         Initial Creation
 *
 */-->
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="layout" content="main" />
<title>::.. Healpal | Messages ..::</title>
</head>
<body>
	<div class="widget-tabs">
		<ul class="tabs">
			<li class="active"><a href="#tab1" data-toggle="tab" onclick="requestAppointments();">NEW MESSAGE</a></li>
			<li><a href="#tab2" data-toggle="tab" onclick="pastAppointments();">INBOX</a></li>
			<li><a href="#tab3" data-toggle="tab" onclick="upcomingAppointments();">OUTBOX</a></li>
			<li><a href="#tab4" data-toggle="tab" onclick="requestedAppointments();">DELETED MESSAGE</a></li>
		</ul>
	</div>
	<div class="body">
		<g:form name="message" controller="Message">
			<h1>New Messages</h1>
			<g:if test="${addStatus}">
				<span color:"red">${addStatus}</span>
  </g:if>
			<div>
				To : <select name="to" id="to">
					<option value="select">Select here..</option>
					<g:if test="${patientList}">
						<g:each in="${patientList}" var="patient">
							<option value="${patient?.id}">
								${patient?.person?.emailAddress}
							</option>
						</g:each>
					</g:if>
				</select>
			</div>
			<div>
				Message :
				<textarea rows="5" id="message" name="message" style="height: 100px;"></textarea>
			</div>
			<div>
				<g:actionSubmit action="message" value="submit" />

			</div>
		</g:form>
	</div>

</body>
</html>