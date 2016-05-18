<div class="tab-content" style="overflow: auto">
	<div class="tab-pane active" id="tab1">
		<div id="pagination" class="widget-forms clearfix">
			<table id="users"
				class="table table-striped table-bordered  dataTable">
				<thead>
					<tr style="background-color: #F2F2F0">
						<th>Ethnicity</th>
						<th>PersonalInterest</th>
						<th>HealthInsurance</th>
						<th>Race</th>
						<th>Education</th>
						<th>Status</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<g:if test="${demography}">
						<g:each in="${demography}" var="reports">
							<tr>
								<td>
									${reports?.ethnicity?.ethnicityName}
								</td>
								<td>
									${reports?.personalInterest?.personalInterestType}
								</td>
								<td>
									${reports?.healthInsurance?.healthInsuranceType}
								</td>
								<td>
									${reports?.race?.raceName}
								</td>
								<td>
									${reports?.education?.educationType}
								</td>
								<g:if test="${reports?.isActive == 1 }">
									<td>Active</td>
								</g:if>
								<g:else>
									<td>InActive</td>
								</g:else>
								<g:if test="${reports?.isActive == 1 }">
									<td><g:link controller="Demographic" action="edit"
											params="${[demographicId:reports?.id]}">Edit</g:link>&nbsp;&nbsp;&nbsp;
										<g:link controller="Demographic" action="delete"
											params="${[demographicId:reports?.id]}">Delete</g:link>&nbsp;&nbsp;&nbsp;
									</td>
								</g:if>
								<g:else>
									<td><g:link controller="Demographic" action="edit"
											params="${[demographicId:reports?.id]}">Edit</g:link>&nbsp;&nbsp;&nbsp;
										<a href="">Delete</a></td>
								</g:else>
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
					controller="HormoneTherapy" action="ajaxPaginate" max="10"
					params="['size':total]"
					pageSizes="[10:'10', 20: '20', 50:'50',100:'100']" />
			</g:if>
		</div>
	</div>
</div>
