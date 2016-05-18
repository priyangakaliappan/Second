<%@ page contentType="text/html;charset=UTF-8" %>
<div id="healthInsur" class="searchList">
<div class="tab-content" style="overflow: auto">
	<div class="tab-pane active" id="tab1">
		<div id="pagination" class="widget-forms clearfix">
			<table id="users"
				class="table table-striped table-bordered  dataTable">
				<thead>
					<tr>
			<util:remoteSortableColumn property="healthInsuranceType"  title="Name" controller="HealthInsurance" action="ajaxPaginate"  
														update="healthInsur" params="[offset:offset, max: max ,size:total]" style="color: white"/>
			
			<util:remoteSortableColumn property="isActive" title="Status" controller="HealthInsurance" action="ajaxPaginate"  
														update="healthInsur" params="[offset:offset, max: max ,size:total]" style="color: white"/>
			
			<util:remoteSortableColumn property="rowCreated" title="Created Date" controller="HealthInsurance" action="ajaxPaginate"  
														update="healthInsur" params="[offset:offset, max: max ,size:total]" style="color: white"/>
			
			<th>Action</th>
			</tr>
				</thead>
				<g:if test="${healthInsuranceList}">
				<tbody>				
					<g:each in="${healthInsuranceList}" var="healthInsurance" status="i">
						<tr>
						<td>${healthInsurance.healthInsuranceType}</td>
						<g:if test="${healthInsurance?.isActive == 1 }">
									<td>Active</td>
								</g:if>
								<g:else>
									<td>InActive</td>
								</g:else>
			<td><g:formatDate date="${healthInsurance?.rowCreated}" type="datetime"
								style="MEDIUM" /></td>
						<td><g:link controller="HealthInsurance" action="edit" params="${[healthInsuranceId:healthInsurance.id]}" title="edit"><img src="${resource(dir:'admin/image',file:'edit.png')}"></g:link>&nbsp;&nbsp;&nbsp;
<g:link controller="HealthInsurance" action="delete"  params="${[healthInsuranceId:healthInsurance.id]}" onclick="if(!confirm('Are you sure you want to Delete?'))  return false" edit="delete"><img src="${resource(dir:'admin/image',file:'delete.png')}"></g:link>&nbsp;&nbsp;&nbsp;</td>
						
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
			<g:if test="${getHealthInsuranceListTotal}">
			
			<util:remotePaginate total="${getHealthInsuranceListTotal}" update="healthInsur"
			controller="HealthInsurance" action="ajaxPaginate" max="10"
			params="['size':total,'searchValue':searchValue]" pageSizes="[10:'10', 20: '20', 50:'50',100:'100']" />
		</g:if>
		</div>
	</div>
</div>
</div>