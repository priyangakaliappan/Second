<%@ page contentType="text/html;charset=UTF-8" %>
<div id="userrolesList" class="searchList">
<div class="tab-content" style="overflow: auto">
	<div class="tab-pane active" id="tab1">
		<div id="pagination" class="widget-forms clearfix">
			<table id="users"
				class="table table-striped table-bordered  dataTable">
	<thead>
		<tr>
			<util:remoteSortableColumn property="healpalUser.userName" title="Username" controller="userRole" action="ajaxPaginate"  
														update="userrolesList" params="[offset:offset, max: max ,size:total]" style="color: white"/>
			
			<util:remoteSortableColumn property="role.authority" title="Role" controller="userRole" action="ajaxPaginate"  
														update="userrolesList" params="[offset:offset, max: max ,size:total]" style="color: white"/>
			
			<util:remoteSortableColumn property="isActive" title="Status" controller="userRole" action="ajaxPaginate"  
														update="userrolesList" params="[offset:offset, max: max ,size:total]" style="color: white"/>
														
			<util:remoteSortableColumn property="rowCreated" title="Created Date" controller="userRole" action="ajaxPaginate"  
														update="userrolesList" params="[offset:offset, max: max ,size:total]" style="color: white" />														
			
			<th>Action</th>
		</tr>
	</thead>
	<tbody>
	<g:if test="${userroles}">
		<g:each in="${userroles}" var="urole">
			<tr>
				<td>
					${urole?.healpalUser?.userName}
				</td>
				<td>
					${urole?.role?.authority}
				</td>
				<td><g:if test="${urole?.isActive == 1}">Active</g:if> <g:else>InActive</g:else>
				</td>
				<td>
					<g:formatDate date="${urole?.rowCreated}" type="datetime"
								style="MEDIUM" />	
				</td>
				<td><g:link controller="userRole" action="edit"
						params="[id : urole?.id]" title="edit"><img src="${resource(dir:'admin/image',file:'edit.png')}"></g:link>
					<g:link controller="userRole" action="delete"
						params="[id : urole?.id ]"
						onclick="if(!confirm('Are you sure you want to Delete?'))  return false" title="delete"><img src="${resource(dir:'admin/image',file:'delete.png')}"></g:link>
				</td>
			</tr>
		</g:each></g:if><g:else>
			<tr><td colspan="5" align="center">No results found </td></tr>
		</g:else>
	</tbody>
</table>


<g:if test="${total}">
	<util:remotePaginate total="${total}" update="userrolesList"
		controller="userRole" action="ajaxPaginate" max="${max}"
		params="['size':total,'searchValue':searchValue]"
		pageSizes="[10:'10', 20: '20', 50:'50',100:'100']" />
</g:if>

</div>
</div>
</div>
</div>


