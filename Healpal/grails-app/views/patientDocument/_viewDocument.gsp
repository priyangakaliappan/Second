<div class="tab-content" style="overflow: auto">
	<div class="tab-pane active" id="tab1">
		<div id="pagination" class="widget-forms clearfix">
			<table id="users"
				class="table table-striped table-bordered  dataTable">
				<thead>
					<tr style="background-color: #F2F2F0">
						<th>Patient Name</th>
						<th>Medical Document</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<g:if test="${medicalDoc}">
						<g:each in="${medicalDoc}" var="reports">
							<tr>
								<td>
									${reports?.patient?.person?.fullName}
								</td>
								<td>${reports?.fileName}</td>
								<td><a class="btn btn-small modal_link" data-toggle="modal" data-target="#viewdoc" href="" >view</a></td>
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
		</div>
	</div>
	</div>