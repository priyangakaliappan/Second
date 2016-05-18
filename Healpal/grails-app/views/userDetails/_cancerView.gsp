<%@ page contentType="text/html;charset=UTF-8" %>
<div id="cancerDetail">
<div class="tab-content" style="overflow: auto">
	<div class="tab-pane active" id="tab1">
		<div id="pagination" class="widget-forms clearfix">
			<table id="users"
				class="table table-striped table-bordered  dataTable">
				<thead>
					<tr>
			<util:remoteSortableColumn property="userName"  title="Name" controller="userDetails" action="cancerAjaxPaginate"  
														update="cancerDetail" params="[offset:offset, max: max ,size:total]" style="color: white"/>
			<util:remoteSortableColumn property="userName" title="E-mail" controller="userDetails" action="cancerAjaxPaginate"  
														update="cancerDetail" params="[offset:offset, max: max ,size:total]" style="color: white"/>
			<util:remoteSortableColumn property="rowCreated" title="Created Date" controller="userDetails" action="cancerAjaxPaginate"  
														update="cancerDetail" params="[offset:offset, max: max ,size:total]" style="color: white"/>
						</tr>
				</thead>
				<g:if test="${cancerType}">
				<tbody>				
					<g:each in="${cancerType}" var="cancerUser" status="i">
						<tr>
					<td><g:cancer personId ="${cancerUser?.person?.id}"/></td>
					<td>${cancerUser?.userName}</td>
			        <td><g:formatDate date="${cancerUser?.rowCreated}" type="datetime" style="MEDIUM" /></td>
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
			<util:remotePaginate total="${total}" update="cancerDetail"
			controller="userDetails" action="cancerAjaxPaginate" max="10 "
			params="['size':total]" pageSizes="[10:'10', 20: '20', 50:'50',100:'100']" />
		</g:if>
		</div>
	</div>
</div>
</div>