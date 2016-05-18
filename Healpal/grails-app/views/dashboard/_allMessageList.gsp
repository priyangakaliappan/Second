<h3>Messages</h3>
<table width="100%" border="0" cellpadding="5"
	class="right-profile-cont">
	<g:if test="${messageMap}">
		<thead>
			<tr>
				<th width="8%"></th>
				<th width="47%">Patient Name</th>
				<th width="45%">Created Date</th>
			</tr>
		</thead>
		<tbody>
			<g:each in="${messageMap}" status="i" var="messageEntry">
				<g:set var="messageViewed" value="${false}" />
				<g:set var="messageCount" value="${0}" />
				<g:each in="${messageEntry?.getValue()}" status="j" var="message">
					<g:if test="${message?.messageViewed == null}">
						<g:set var="messageCount" value="${messageCount + 1}" />
						<g:set var="messageViewed" value="${true}" />
					</g:if>
				</g:each>
				<tr>
					<td><g:if test="${messageViewed}">
							<g:if
								test="${messageEntry?.getValue()?.get(0)?.patientByPatientFkSender?.person?.firstName == person?.firstName}">
								<g:img dir="images" file="message-read.png" width="36"
									height="36" />
							</g:if>
							<g:else>
								<g:img dir="images" file="message-unread.png" width="36"
									height="36" />
							</g:else>
						</g:if> <g:else>
							<g:img dir="images" file="message-read.png" width="36"
								height="36" />
						</g:else></td>
					<td><g:if test="${messageCount == 0}">
							<g:link controller="dashboard" action="viewAllMessage"
								params="[patientId:messageEntry?.getKey()?.id]">
								${messageEntry?.getKey()?.person?.firstName}
							</g:link>
						</g:if> <g:elseif test="${messageCount > 1}">
							<g:link controller="dashboard" action="viewAllMessage"
								params="[patientId:messageEntry?.getKey()?.id]">
								${messageEntry?.getKey()?.person?.firstName +' ('+ messageCount +')'}
							</g:link>
						</g:elseif> <g:else>
							<g:link controller="dashboard" action="viewAllMessage"
								params="[patientId:messageEntry?.getKey()?.id]">
								${messageEntry?.getKey()?.person?.firstName}
							</g:link>
						</g:else></td>
					<td><g:formatDate format="yyyy-MM-dd HH:mm"
							date="${messageEntry?.getValue()?.get(0)?.messageSent}" /></td>
				</tr>
			</g:each>
		</tbody>
	</g:if>
	<g:else>
		No New Messages
	</g:else>
</table>
<div class="pagination">
	<util:remotePaginate total="${messageMapTotal}" update="messages"
		params="['size':messageMapTotal]" controller="dashboard"
		action="ajaxPaginateAllMessage" />
</div>
<div class="clearfix mar-bot-10"></div>
<g:link controller="dashboard" action="view">Back</g:link>