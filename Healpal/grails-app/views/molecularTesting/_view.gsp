<%@ page contentType="text/html;charset=UTF-8" %>
<div id="paginations" class="searchList">
<div class="tab-content" style="overflow: auto">
	<div class="tab-pane active" id="tab1">
		<div id="pagination" class="widget-forms clearfix">
			<table id="users"
				class="table table-striped table-bordered  dataTable">
				<thead>
					<tr>
					<util:remoteSortableColumn property="molecularForCancerName"  title="Name" controller="MolecularTesting" action="ajaxPaginate"  
														update="paginations" params="[offset:offset, max: max ,size:total]" style="color: white"/>
			
			<util:remoteSortableColumn property="isActive" title="Status" controller="MolecularTesting" action="ajaxPaginate"  
														update="paginations" params="[offset:offset, max: max ,size:total]" style="color: white"/>
			
			<util:remoteSortableColumn property="rowCreated" title="Created Date" controller="MolecularTesting" action="ajaxPaginate"  
														update="paginations" params="[offset:offset, max: max ,size:total]" style="color: white"/>
			
			<th>Action</th>
			</tr>				</thead>
				<tbody>
				<g:if test='${molecularForCancerList}'>
					<g:each in="${molecularForCancerList}" var="molecular" status="i">
						<tr>
						<td>${molecular?.molecularForCancerName}</td>
						<g:if test="${molecular?.isActive==1}">
						<td>Active</td>
						</g:if><g:else><td>InActive</td></g:else>
						<td><g:formatDate date="${molecular?.rowCreated}" type="datetime"
								style="MEDIUM" /></td>
						<td> <g:link action="edit" params="${[molecularId:molecular.id]}" title="edit"><img src="${resource(dir:'admin/image',file:'edit.png')}"></g:link>&nbsp;
			                 <g:link action="delete" params="${[molecularId:molecular.id ]}" onclick="if(!confirm('Are you sure you want to Delete?'))  return false" title="delete"><img src="${resource(dir:'admin/image',file:'delete.png')}"></g:link></td>
						</tr>
					</g:each>
					</g:if>
					<g:else>
			<tr><td>Sorry, No records here</td></tr>
			</g:else>
				</tbody>
			</table>
		<g:if test="${molecularForCancerListTotal}">
				<util:remotePaginate total="${molecularForCancerListTotal}" update="paginations"
					controller="MolecularTesting" action="ajaxPaginate" max="10"
					params="['size':total,'searchValue':searchValue]"
					pageSizes="[10:'10', 20: '20', 50:'50',100:'100']" />
			</g:if>
		</div>
	</div>
</div>
	</div>
	