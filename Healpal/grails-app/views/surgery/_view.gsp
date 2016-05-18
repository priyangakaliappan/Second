<%@ page contentType="text/html;charset=UTF-8" %>
<div id="paginationss" class="searchList">
<div class="tab-content" style="overflow: auto">
	<div class="tab-pane active" id="tab1">
		<div id="pagination" class="widget-forms clearfix">
			<table id="users"
				class="table table-striped table-bordered  dataTable">
				<thead>
					<tr>
					<util:remoteSortableColumn property="surgeryType"  title="Name" controller="Surgery" action="ajaxPaginate"  
														update="paginationss" params="[offset:offset, max: max ,size:total]" style="color: white"/>
			
			<util:remoteSortableColumn property="isActive" title="Status" controller="Surgery" action="ajaxPaginate"  
														update="paginationss" params="[offset:offset, max: max ,size:total]" style="color: white"/>
			
			<util:remoteSortableColumn property="rowCreated" title="Created Date" controller="Surgery" action="ajaxPaginate"  
														update="paginationss" params="[offset:offset, max: max ,size:total]" style="color: white"/>
			
			<th>Action</th>
			</tr>				</thead>
				<tbody>
				<g:if test="${surgeryList}">
				<tbody>
	<g:each in="${surgeryList}" var="surgeries" status="i">
		<tr>
			<td>${surgeries.surgeryType}</td>
			<g:if test="${surgeries?.isActive==1}">
						<td>Active</td>
						</g:if>
						<g:else>
						<td>InActive</td>
						</g:else>
			<td><g:formatDate date="${surgeries?.rowCreated}" type="datetime"
								style="MEDIUM" /></td>
			<td><g:link controller="Surgery" action="edit" params="${[surgeryId:surgeries.id]}" title="edit"><img src="${resource(dir:'admin/image',file:'edit.png')}"></g:link>
			&nbsp;&nbsp;&nbsp;<g:link controller="Surgery" action="delete"  params="${[surgeryId:surgeries.id]}" onclick="if(!confirm('Are you sure you want to Delete?'))  return false" title="delete"><img src="${resource(dir:'admin/image',file:'delete.png')}"></g:link>&nbsp;&nbsp;&nbsp;</td>
		</tr>
	</g:each>
</tbody>
				</g:if>
					<g:else>
			<tr><td>Sorry, No records here</td></tr>
			</g:else>
				</tbody>
			</table>
		<g:if test="${surgeryListTotal}">
				<util:remotePaginate total="${surgeryListTotal}" update="paginationss"
					controller="Surgery" action="ajaxPaginate" max="10"
					params="['size':total,'searchValue':searchValue]"
					pageSizes="[10:'10', 20: '20', 50:'50',100:'100']" />
			</g:if>
		</div>
	</div>
</div>
	</div>