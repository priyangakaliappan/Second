<%@ page contentType="text/html;charset=UTF-8" %>
<div id="raceList" class="searchList">
<div class="tab-content" style="overflow: auto">
	<div class="tab-pane active" id="tab1">
		<div id="pagination" class="widget-forms clearfix">
			<table id="users"
				class="table table-striped table-bordered  dataTable">
				<thead>
					<tr>
					<util:remoteSortableColumn property="raceName"  title="Name" controller="Race" action="ajaxPaginate"  
														update="raceList" params="[offset:offset, max: max ,size:total]" style="color: white"/>
			
			<util:remoteSortableColumn property="isActive" title="Status" controller="Race" action="ajaxPaginate"  
														update="raceList" params="[offset:offset, max: max ,size:total]" style="color: white"/>
			
			<util:remoteSortableColumn property="rowCreated" title="Created Date" controller="Race" action="ajaxPaginate"  
														update="raceList" params="[offset:offset, max: max ,size:total]" style="color: white"/>
			
			<th>Action</th>
			</tr>
				</thead>
				<g:if test="${race}">
				<tbody>				
					<g:each in="${race}" var="races" status="i">
						<tr>
					<td>${races.raceName}</td>
					<g:if test="${races?.isActive == 1 }">
								<td>Active</td>
								</g:if>
								<g:else>
									<td>InActive</td>
								</g:else>
			            <td><g:formatDate date="${races?.rowCreated}" type="datetime"
								style="MEDIUM" /></td>
						<td><g:link controller="Race" action="edit" params="${[raceId:races.id]}" title="edit"><img src="${resource(dir:'admin/image',file:'edit.png')}"></g:link>&nbsp;&nbsp;&nbsp;<g:link controller="Race" action="delete"  title="delete" params="${[raceId:races.id]}" onclick="if(!confirm('Are you sure you want to Delete?'))  return false"><img src="${resource(dir:'admin/image',file:'delete.png')}"></g:link>&nbsp;&nbsp;&nbsp;</td>
						
						</tr>
					</g:each>
				</tbody>
				</g:if>
				<g:else>
				<tbody>
				<tr>
				<td colspan="3">
				No Records Found
				</td>
				</tr></tbody>
				</g:else>
			</table>
			<g:if test="${total}">
			<util:remotePaginate total="${total}" update="raceList"
			controller="Race" action="ajaxPaginate" max="10"
			params="['size':total,'searchValue':searchValue]" pageSizes="[10:'10', 20: '20', 50:'50',100:'100']" />
		</g:if>
		</div>
	</div>
</div>
</div>