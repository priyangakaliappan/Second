<%@ page contentType="text/html;charset=UTF-8" %>

<div id="usersList" class="searchList">
<div class="tab-content" style="overflow: auto">
	<div class="tab-pane active" id="tab1">
		<div id="pagination" class="widget-forms clearfix">
			<table id="users"
				class="table table-striped table-bordered  dataTable">
	<thead>
		<tr>
			<util:remoteSortableColumn property="person.firstName"  title="Name" controller="user" action="ajaxPaginate"  
														update="usersList" params="[offset:offset, max: max ,size:total]" style="color: white"/>
			<util:remoteSortableColumn property="person.emailAddress" title="Email" controller="user" action="ajaxPaginate"  
														update="usersList" params="[offset:offset, max: max ,size:total]" style="color: white"/>
			<util:remoteSortableColumn property="enabled" title="Status" controller="user" action="ajaxPaginate"  
														update="usersList" params="[offset:offset, max: max ,size:total]" style="color: white"/>
			
			<util:remoteSortableColumn property="rowCreated" title="Created Date" controller="user" action="ajaxPaginate"  
														update="usersList" params="[offset:offset, max: max ,size:total]" style="color: white"/>
			
			<th>Action</th>
		</tr>
	</thead>
	<tbody>
	<g:if test="${users}">
		<g:each in="${users}" var="user">
			<tr>
				<td>
					${user?.person?.fullName}
				</td>
				<td>
					${user?.userName}
				</td>
				<td><g:if test="${user?.enabled == true}">Active</g:if> <g:else>InActive</g:else>
				</td>
				<td>
					<g:formatDate date="${user?.rowCreated}" type="datetime"
								style="MEDIUM" />
				</td>
				<td><g:link controller="user" action="edit"
						params="[userId : user?.id ,personId : user?.person?.id]" title="edit"><img src="${resource(dir:'admin/image',file:'edit.png')}"></g:link>
					<g:link controller="user" action="doDelete"
						params="[userId : user?.id ,personId : user?.person?.id]"
						onclick="if(!confirm('Are you sure you want to Delete?'))  return false" title="delete"><img src="${resource(dir:'admin/image',file:'delete.png')}"></g:link>
					<%--<g:link controller="user" action="userDocuments"
						params="[personId : user?.person?.id]">View</g:link>
				--%></td>
			</tr>
		</g:each>
		</g:if><g:else>
			<tr><td colspan="5" align="center">No results found </td></tr>
		</g:else>
		
	</tbody>
</table>


<g:if test="${total}">
	<util:remotePaginate total="${total}" update="usersList"
		controller="user" action="ajaxPaginate" max="${max}"
		params="['size':total,'searchValue':searchValue]"
		pageSizes="[10:'10', 20: '20', 50:'50',100:'100']" />
</g:if>

</div>
</div>
</div>
</div>
