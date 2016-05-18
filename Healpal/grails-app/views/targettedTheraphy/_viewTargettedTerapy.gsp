<%@ page contentType="text/html;charset=UTF-8" %>

<div class="tab-pane active" id="tab1">
		<div id="pagination" class="widget-forms clearfix">
			<table id="users"
				class="table table-striped table-bordered  dataTable">
				<thead>
					<tr style="background-color: #F2F2F0">
						<th>Targetted Terapy Type</th>
						<th>Status</th>
						<th>Date Created</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
				<g:if test="${therapyList}">
				<g:each in='${therapyList}' var="therapyListView">
						<tr>
						<tr><td>${therapyListView.targetedTheropyName}</td>
						<g:if test="${therapyListView?.isActive==1}">
						<td>Active</td>
						</g:if>
						<g:else>
						<td>InActive</td>
						</g:else>
			<td>	<g:formatDate date="${therapyListView?.rowCreated}" type="datetime"
								style="MEDIUM" /></td>
						<td><g:link controller="targettedTheraphy" action="edit" params="${[therapyId:therapyListView.id]}">Edit</g:link>&nbsp;&nbsp;&nbsp;
						<g:link controller="targettedTheraphy" action="delete"  params="${[therapyId:therapyListView.id]}" onclick="if(!confirm('Are you sure you want to Delete?'))  return false">Delete</g:link>&nbsp;&nbsp;&nbsp;</td>
						
						</tr>
					</g:each>
					</g:if>
					<g:else>
						<th>No Records Found</th>
					</g:else>
				</tbody>
			</table>
			<g:if test="${total}">
			<util:remotePaginate total="${total}" update="pagination"
			controller="HormoneTherapy" action="ajaxPaginate" max="10"
			params="['size':total]" pageSizes="[10:'10', 20: '20', 50:'50',100:'100']" />
		</g:if>
		</div>
	</div>
</div>
