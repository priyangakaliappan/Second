<%@ page contentType="text/html;charset=UTF-8" %>
<div id="userDetail">
<div class="tab-content" style="overflow: auto">
	<div class="tab-pane active" id="tab1">
		<div id="pagination" class="widget-forms clearfix">
		 
			<table id="users"
				class="table table-striped table-bordered  dataTable">
				<thead>
					<tr>
			<util:remoteSortableColumn property="person.firstName"  title="Name" controller="userDetails" action="ajaxPaginate"  
														update="userDetail" params="[offset:offset, max: max ,size:total]" style="color: white"/>
			
			<util:remoteSortableColumn property="userName" title="E-mail" controller="userDetails" action="ajaxPaginate"  
														update="userDetail" params="[offset:offset, max: max ,size:total]" style="color: white"/>
														
			<%--<util:remoteSortableColumn property="person.id" title="Cancer Type" controller="userDetails" action="ajaxPaginate"  
				update="userDetail" params="[offset:offset, max: max ,size:total]" style="color: white"/>
			
			--%><util:remoteSortableColumn property="rowCreated" title="Created Date" controller="userDetails" action="ajaxPaginate"  
														update="userDetail" params="[offset:offset, max: max ,size:total]" style="color: white"/>
						</tr>
				</thead>
				
				<g:if test="${userDetails}">
				<tbody>				
					<g:each in="${userDetails}" var="newUser" status="i">
						<tr>
					<td>${newUser?.person?.fullName}</td>
					<td>
						${newUser?.userName}
						</td>
						<%--<td><g:cancer personId ="${newUser?.person?.id}"/></td>
			            --%><td><g:formatDate date="${newUser?.rowCreated}" type="datetime"
								style="MEDIUM" /></td>
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
			<util:remotePaginate total="${total}" update="userDetail"
			controller="userDetails" action="ajaxPaginate" max="${max}"
			params="['size':total]" pageSizes="[10:'10', 20: '20', 50:'50',100:'100']" />
		</g:if>
		</div>
	</div>
</div>
</div>