<div id="pagination" class="widget-forms clearfix searchList">
	<table id="users" class="table table-striped table-bordered  dataTable">
		<thead>
			<tr>
				<util:remoteSortableColumn property="subject" title="Subject"
					controller="dashboard" action="ajaxPaginate"
					update="pagination" params="[offset:offset, max: max ,size:total]"
					style="color: white" />
				<util:remoteSortableColumn property="description"
					title="Description" controller="dashboard"
					action="ajaxPaginate" update="pagination"
					params="[offset:offset, max: max ,size:total]" style="color: white" />

				<util:remoteSortableColumn property="rowCreated"
					title="Created Date" controller="dashboard"
					action="ajaxPaginate" update="pagination"
					params="[offset:offset, max: max ,size:total]" style="color: white" />


			</tr>
		</thead>
		<tbody>
			<g:if test="${email}">
				<g:each in="${email}" var="reports">
					<tr>
						<td>
							${reports?.subject}
						</td>
						<td>
							${reports?.bodyText}
						</td>
						<td><g:formatDate date="${reports?.rowCreated}"
								type="datetime" style="MEDIUM" /></td>
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
			controller="dashboard" action="ajaxPaginate" max="10"
			params="['size':total,'searchValue':searchValue]"
			pageSizes="[10:'10', 20: '20', 50:'50',100:'100']" />
	</g:if>
</div>
