<h3>Group Messages</h3>
<table width="100%" border="0" cellpadding="5"
	class="right-profile-cont">
	<g:if test="${groupList}">
		<thead>
			<tr>
				<th width="8%"></th>
				<th width="35%">Group Name</th>
				<th width="25%">Group Creator</th>
				<th width="32%">Created Date</th>
			</tr>
		</thead>
		<tbody>
			<g:each in="${groupList}" status="i" var="messageGroup">
				<tr>
					<td><g:img dir="images" file="message-unread.png" width="36"
							height="36" /></td>
					<td><g:link controller="dashboard" action="viewGroupMessage"
							params="[messageGroupId:messageGroup?.id]">
							${messageGroup?.messageGroupName}
						</g:link></td>
					<td>
						${messageGroup?.createdPatient?.person?.firstName}
					</td>
					<td><g:formatDate format="yyyy-MM-dd HH:mm"
							date="${messageGroup?.rowCreated}" /></td>
				</tr>
			</g:each>
		</tbody>
	</g:if>
	<g:else>
		No Group Messages
	</g:else>
</table>
<div class="pagination">
	<util:remotePaginate total="${groupListTotal}" update="messages"
		params="['size':groupListTotal]" controller="dashboard"
		action="ajaxPaginateGroupMessage" />
</div>
<div class="clearfix mar-bot-10"></div>
<g:link controller="dashboard" action="view">Back</g:link>