<div id="aboutList" class="searchList">
	<div class="tab-content" style="overflow: auto">
		<div class="tab-pane active" id="tab1">
			<div id="pagination" class="widget-forms clearfix">
				<table id="users" class="table table-striped table-bordered  dataTable">
					<thead>
						<tr>
							<util:remoteSortableColumn property="aboutYouName" title="Name"
								controller="AboutYou" action="ajaxPaginate" update="aboutList"
								params="[offset:offset, max: max ,size:total]"
								style="color: white" />

							<util:remoteSortableColumn property="isActive" title="Status"
								controller="AboutYou" action="ajaxPaginate" update="aboutList"
								params="[offset:offset, max: max ,size:total]"
								style="color: white" />

							<util:remoteSortableColumn property="rowCreated"
								title="Created Date" controller="AboutYou" action="ajaxPaginate"
								update="aboutList"
								params="[offset:offset, max: max ,size:total]"
								style="color: white" />

							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<g:if test='${aboutYouList}'>
							<g:each in="${aboutYouList}" var="abt" status="i">
								<tr>
									<td>
										${abt?.aboutYouName}
									</td>
									<g:if test="${abt?.isActive==1}">
										<td>Active</td>
									</g:if>
									<g:else>
										<td>InActive</td>
									</g:else>
									<td><g:formatDate date="${abt?.rowCreated}" type="datetime" style="MEDIUM" /></td>
									<td><g:link controller="aboutYou" action="edit"
											params="${[aboutId:abt.id]}"><img src="${resource(dir:'admin/image',file:'edit.png')}"></g:link>&nbsp; <g:link
											action="delete" params="${[aboutId:abt.id ]}"
											onclick="if(!confirm('Are you sure you want to Delete?'))  return false"><img src="${resource(dir:'admin/image',file:'delete.png')}"></g:link></td>
								</tr>
							</g:each>
						</g:if>
						<g:else>
							<tr>
								<td>Sorry, No records here</td>
							</tr>
						</g:else>
					</tbody>
				</table>
				<g:if test="${aboutYouListTotal}">
					<util:remotePaginate total="${aboutYouListTotal}"
						update="aboutList" controller="AboutYou" action="ajaxPaginate"
						max="10" params="['size':total,'searchValue':searchValue]"
						pageSizes="[10:'10', 20: '20', 50:'50',100:'100']" />
				</g:if>
			</div>
		</div>
	</div>
</div>
