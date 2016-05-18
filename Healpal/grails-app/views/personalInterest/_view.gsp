<%@ page contentType="text/html;charset=UTF-8" %>
<div id="personal">
<div class="tab-content" style="overflow: auto">
	<div class="tab-pane active" id="tab1">
		<div id="pagination" class="widget-forms clearfix">
			<table id="users"
				class="table table-striped table-bordered  dataTable">
				<thead>
					<tr>
					<util:remoteSortableColumn property="personalInterestType"  title="Name" controller="PersonalInterest" action="ajaxPaginate"  
														update="personal" params="[offset:offset, max: max ,size:total]" style="color: white"/>
			
			<util:remoteSortableColumn property="isActive" title="Status" controller="PersonalInterest" action="ajaxPaginate"  
														update="personal" params="[offset:offset, max: max ,size:total]" style="color: white"/>
			
			<util:remoteSortableColumn property="rowCreated" title="Created Date" controller="PersonalInterest" action="ajaxPaginate"  
														update="personal" params="[offset:offset, max: max ,size:total]" style="color: white"/>
			
			<th>Action</th>
			</tr>
				</thead>
				<g:if test="${personalInterestList}">
				<tbody>
					<g:each in="${personalInterestList}" var="personalInterest" status="i">
						<tr>
						<td>${personalInterest.personalInterestType}</td>
						<g:if test="${personalInterest?.isActive == 1 }">
									<td>Active</td>
								</g:if>
								<g:else>
									<td>InActive</td>
								</g:else>
			<td>			
					<g:formatDate date="${personalInterest?.rowCreated}" type="datetime"
								style="MEDIUM" /></td>
						<td><g:link controller="PersonalInterest" action="edit" params="${[personalInterestId:personalInterest.id]}">Edit</g:link>&nbsp;&nbsp;&nbsp;<g:link controller="PersonalInterest" action="delete"  params="${[personalInterestId:personalInterest.id]}" onclick="if(!confirm('Are you sure you want to Delete?'))  return false">Delete</g:link>&nbsp;&nbsp;&nbsp;</td>
						
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
			<g:if test="${personalInterestListTotal}">
				<util:remotePaginate total="${personalInterestListTotal}" update="personal"
					controller="PersonalInterest" action="ajaxPaginate" max="10"
					params="['size':total]"
					pageSizes="[10:'10', 20: '20', 50:'50',100:'100']" />
			</g:if>
		</div>
	</div>
</div>
</div>