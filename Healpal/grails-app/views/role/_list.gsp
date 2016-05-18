<%@ page contentType="text/html;charset=UTF-8" %>

<div id="rolesList" class="searchList">

<div class="tab-content" style="overflow: auto">
	<div class="tab-pane active" id="tab1">
		<div id="pagination" class="widget-forms clearfix">
			<table id="users"
				class="table table-striped table-bordered  dataTable">
	<thead>
		<tr>
			<util:remoteSortableColumn property="authority" title="Name" controller="role" action="ajaxPaginate"  
														update="rolesList" params="[offset:offset, max: max ,size:total]" style="color: white"/>
			
			<util:remoteSortableColumn property="isActive" title="Status" controller="role" action="ajaxPaginate"  
														update="rolesList" params="[offset:offset, max: max ,size:total]" style="color: white"/>
														
			<util:remoteSortableColumn property="rowCreated" title="Created Date" controller="role" action="ajaxPaginate"  
														update="rolesList" params="[offset:offset, max: max ,size:total]" style="color: white"/>	
			
			<th>Action</th>
		</tr>
	</thead>
	<tbody>
	<g:if test="${roles}">
		<g:each in="${roles}" var="role">
			<tr>
				<td>
					${role?.authority}
				</td>
				<td><g:if test="${role?.isActive == 1}">Active</g:if> <g:else>InActive</g:else>
				</td>
				<td>
					<g:formatDate date="${role?.rowCreated}" type="datetime"
							style="MEDIUM" />
				</td>
				<td><g:link controller="role" action="edit"
						params="[id : role?.id]" title="edit"><img src="${resource(dir:'admin/image',file:'edit.png')}"></g:link>
					<g:link controller="role" action="delete"
						params="[id : role?.id ]"
						onclick="if(!confirm('Are you sure you want to Delete?'))  return false" title="delete"><img src="${resource(dir:'admin/image',file:'delete.png')}"></g:link>
				</td>
			</tr>
		</g:each>
		</g:if><g:else>
			<tr><td colspan="4" align="center">No results found </td></tr>
		</g:else>
	</tbody>
</table>


<g:if test="${total}">
	<util:remotePaginate total="${total}" update="rolesList"
		controller="role" action="ajaxPaginate" max="${max}"
		params="['size':total,'searchValue':searchValue]"
		pageSizes="[10:'10', 20: '20', 50:'50',100:'100']" />
</g:if>

</div>
</div>
</div>

</div>
