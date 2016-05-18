
<div id="statusList" class="searchList">
	<div class="tab-content" style="overflow: auto">
		<div class="tab-pane active" id="tab1">
			<div id="pagination" class="widget-forms clearfix">
				<table id="users"
					class="table table-striped table-bordered  dataTable">
					<thead>
						<tr>
							<util:remoteSortableColumn property="cancerStatusType"
								title="Name" controller="CancerStatus" action="ajaxPaginate"
								update="statusList"
								params="[offset:offset, max: max ,size:total]"
								style="color: white" />

							<util:remoteSortableColumn property="isActive" title="Status"
								controller="CancerStatus" action="ajaxPaginate"
								update="statusList"
								params="[offset:offset, max: max ,size:total]"
								style="color: white" />

							<util:remoteSortableColumn property="rowCreated"
								title="Created Date" controller="CancerStatus"
								action="ajaxPaginate" update="statusList"
								params="[offset:offset, max: max ,size:total]"
								style="color: white" />

							<th>Action</th>
						</tr>
					</thead>
					<g:if test="${statusList}">

						<tbody>
							<g:each in="${statusList}" var="status" status="i">
								<tr>
									<td>
										${status.cancerStatusType}
									</td>
									<g:if test="${status?.isActive == 1 }">
										<td>Active</td>
									</g:if>
									<g:else>
										<td>InActive</td>
									</g:else>
									<td><g:formatDate date="${status?.rowCreated}" type="datetime"
								style="MEDIUM" /></td>
									<td><g:link controller="CancerStatus" action="edit" params="${[statusId:status?.id]}" title="edit"><img src="${resource(dir:'admin/image',file:'edit.png')}"></g:link>
&nbsp;&nbsp;&nbsp;<g:link controller="CancerStatus" action="delete"
											params="${[statusId:status?.id]}"
											onclick="if(!confirm('Are you sure you want to Delete?'))  return false" title="delete"><img src="${resource(dir:'admin/image',file:'delete.png')}"></g:link>
											&nbsp;&nbsp;&nbsp;

								</tr>
							</g:each>
						</tbody>
					</g:if>
					<g:else>
						<tbody>
							<tr>
								<td colspan="3">No Records Found</td>
							</tr>
						</tbody>
					</g:else>
				</table>
				<g:if test="${statusList}">
					<util:remotePaginate total="${cancerStatusTotal}" update="statusList"
						controller="CancerStatus" action="ajaxPaginate" max="10"
						params="['size':total,'searchValue':searchValue]"
						pageSizes="[10:'10', 20: '20', 50:'50',100:'100']" />
				</g:if>
			</div>
		</div>
	</div>
</div>