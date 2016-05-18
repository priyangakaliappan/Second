<%@ page contentType="text/html;charset=UTF-8" %>
<div id="educations" class="searchList">
<div class="tab-content" style="overflow: auto">
	<div class="tab-pane active" id="tab1">
		<div id="pagination" class="widget-forms clearfix">
			<table id="users"
				class="table table-striped table-bordered  dataTable">
				<thead>
					<tr>
					<util:remoteSortableColumn property="educationType"  title="Name" controller="Education" action="ajaxPaginate"  
														update="educations" params="[offset:offset, max: max ,size:total]" style="color: white"/>
			
			<util:remoteSortableColumn property="isActive" title="Status" controller="Education" action="ajaxPaginate"  
														update="educations" params="[offset:offset, max: max ,size:total]" style="color: white"/>
			
			<util:remoteSortableColumn property="rowCreated" title="Created Date" controller="Education" action="ajaxPaginate"  
														update="educations" params="[offset:offset, max: max ,size:total]" style="color: white"/>
			
			<th>Action</th>
			</tr>
				</thead>
				<g:if test="${educationLists}">
				<tbody>
					<g:each in="${educationLists}" var="educationList" status="i">
						<tr>
						<td>${educationList?.educationType}</td>
						<g:if test="${educationList?.isActive == 1 }">
									<td>Active</td>
								</g:if>
								<g:else>
									<td>InActive</td>
								</g:else>
						<td><g:formatDate date="${educationList?.rowCreated}" type="datetime"
								style="MEDIUM" /></td>
						<td><g:link controller="Education" action="edit" params="${[educationId:educationList?.id]}" title="edit"><img src="${resource(dir:'admin/image',file:'edit.png')}"></g:link>&nbsp;&nbsp;&nbsp;<g:link controller="Education" action="delete"  params="${[educationId:educationList?.id]}" onclick="if(!confirm('Are you sure you want to Delete?'))  return false" title="delete"><img src="${resource(dir:'admin/image',file:'delete.png')}"></g:link>&nbsp;&nbsp;&nbsp;</td>
						
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
			<g:if test="${educationListTotal}">
			
			<util:remotePaginate total="${educationListTotal}" update="educations"
			controller="Education" action="ajaxPaginate" max="10"
			params="['size':total,'searchValue':searchValue]" pageSizes="[10:'10', 20: '20', 50:'50',100:'100']" />
		</g:if>
		</div>
	</div>
</div>
</div>