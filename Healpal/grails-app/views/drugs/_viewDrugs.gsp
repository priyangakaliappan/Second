<%@ page contentType="text/html;charset=UTF-8" %>
<div id="drugsList" class="searchList">
<div class="tab-content" style="overflow: auto">
	<div class="tab-pane active" id="tab1">
		<div id="pagination" class="widget-forms clearfix">
			<table id="users"
				class="table table-striped table-bordered  dataTable">
				<thead>
			<tr>
			<util:remoteSortableColumn property="drugName"  title="Name" controller="Drugs" action="ajaxPaginate"  
														update="drugsList" params="[offset:offset, max: max ,size:total]" style="color: white"/>
			
			<util:remoteSortableColumn property="isActive" title="Status" controller="Drugs" action="ajaxPaginate"  
														update="drugsList" params="[offset:offset, max: max ,size:total]" style="color: white"/>
			
			<util:remoteSortableColumn property="rowCreated" title="Created Date" controller="Drugs" action="ajaxPaginate"  
														update="drugsList" params="[offset:offset, max: max ,size:total]" style="color: white"/>
			
			<th>Action</th>
			</tr>
				</thead>
				<tbody>
					<g:if test="${drugList}">
						<g:each in="${drugList}" var="reports">
							<tr>
								<td>
									${reports?.drugName}
								</td>
								<g:if test="${reports?.isActive == 1 }">
									<td>Active</td>
								</g:if>
								<g:else>
									<td>InActive</td>
								</g:else>
								
								<td><g:formatDate date="${reports?.rowCreated}" type="datetime"
								style="MEDIUM" /></td>
									<td>
										<g:link controller="Drugs" action="edit" params="${[drugId:reports?.id]}" title="edit"><img src="${resource(dir:'admin/image',file:'edit.png')}"></g:link>&nbsp;&nbsp;&nbsp;
										<g:link controller="Drugs" action="delete" params="${[drugId:reports?.id]}" onclick="if(!confirm('Are you sure you want to Delete?'))  return false" title="delete"><img src="${resource(dir:'admin/image',file:'delete.png')}"></g:link>&nbsp;&nbsp;&nbsp;
									</td>
								
							</tr>
						</g:each>
					</g:if>
					<g:else>
						<tr>
							<td colspan="3">No Results Found</td>
						</tr>
					</g:else>
				</tbody>
			</table>
			<g:if test="${total}">
				<util:remotePaginate total="${total}" update="pagination"
					controller="Drugs" action="ajaxPaginate" max="10"
					params="['size':total,'searchValue':searchValue]"
					pageSizes="[10:'10', 20: '20', 50:'50',100:'100']" />
			</g:if>
		</div>
	</div>
</div>
</div>