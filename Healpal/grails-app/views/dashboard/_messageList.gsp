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
				<tr>
					<td><g:img dir="images" file="message-unread.png" width="36"
							height="36" /></td>
					<td><g:if test="${messageEntry?.getValue()?.size() == 1}">
							<g:link controller="dashboard" action="viewMessage"
								params="[patientId:messageEntry?.getKey()?.id]">
								${messageEntry?.getKey()?.person?.firstName}
							</g:link>
						</g:if> <g:else>
							<g:link controller="dashboard" action="viewMessage"
								params="[patientId:messageEntry?.getKey()?.id]">
								${messageEntry?.getKey()?.person?.firstName +' ('+ messageEntry?.getValue()?.size() +')'}
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
		action="ajaxPaginateMessage" />
</div>
<div class="clearfix mar-bot-10"></div>
<g:link controller="dashboard" action="view">Back</g:link>