<div id="pagination" class="searchList">
<div class="tab-content" style="overflow: auto">
	<div class="tab-pane active" id="tab1">
		<div id="pagination" class="widget-forms clearfix">
			<table id="users"
				class="table table-striped table-bordered  dataTable">
				<thead>
					<tr>
					<util:remoteSortableColumn property="metastaticName"  title="Name" controller="MetastaticBreastCancer" action="ajaxPaginate"  
														update="pagination" params="[offset:offset, max: max ,size:total]" style="color: white"/>
			
			<util:remoteSortableColumn property="isActive" title="Status" controller="MetastaticBreastCancer" action="ajaxPaginate"  
														update="pagination" params="[offset:offset, max: max ,size:total]" style="color: white"/>
			
			<util:remoteSortableColumn property="rowCreated" title="Created Date" controller="MetastaticBreastCancer" action="ajaxPaginate"  
														update="pagination" params="[offset:offset, max: max ,size:total]" style="color: white"/>
			
			<th>Action</th>
			</tr>
				</thead>
				<tbody>
					<g:if test="${metastaticBreastCancer}">
						<g:each in="${metastaticBreastCancer}" var="reports" status="i">
							<tr>
								<td>
									${reports?.metastaticName}
								</td>
								<g:if test="${reports?.isActive == 1 }">
									<td>Active</td>
								</g:if>
								<g:else>
									<td>InActive</td>
								</g:else>
								<td>
					<g:formatDate date="${reports?.rowCreated}" type="datetime"
								style="MEDIUM" />	
				</td>
								
									<td>
										<g:link controller="MetastaticBreastCancer" action="edit" params="${[metastaticId:reports?.id]}" title="edit"><img src="${resource(dir:'admin/image',file:'edit.png')}"></g:link>&nbsp;&nbsp;&nbsp;
										<g:link controller="MetastaticBreastCancer" action="delete" params="${[metastaticId:reports?.id]}" onclick="if(!confirm('Are you sure you want to Delete?'))  return false" title="delete"><img src="${resource(dir:'admin/image',file:'delete.png')}"></g:link>&nbsp;&nbsp;&nbsp;
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
					controller="MetastaticBreastCancer" action="ajaxPaginate" max="10"
					params="['size':total,'searchValue':searchValue]"
					pageSizes="[10:'10', 20: '20', 50:'50',100:'100']" />
			</g:if>
		</div>
	</div>
</div>
</div>