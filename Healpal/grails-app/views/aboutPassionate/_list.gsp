<div id="aboutList" class="searchList">
	<div class="tab-content" style="overflow: auto">
		<div class="tab-pane active" id="tab1">
			<div id="pagination" class="widget-forms clearfix">
				<table id="users" class="table table-striped table-bordered  dataTable">
					<thead>
						<tr>
							<util:remoteSortableColumn property="fullName" title="Full Name"
								controller="aboutPassionate" action="ajaxPaginate"
								update="aboutList"
								params="[offset:offset, max: max ,size:total]"
								style="color: white" />
							<util:remoteSortableColumn property="describeAboutYourself"
								title="Describe About Yourself" controller="aboutPassionate"
								action="ajaxPaginate" update="aboutList"
								params="[offset:offset, max: max ,size:total]"
								style="color: white" />

							<util:remoteSortableColumn property="passionateAbout"
								title="Passionate About" controller="aboutPassionate"
								action="ajaxPaginate" update="aboutList"
								params="[offset:offset, max: max ,size:total]"
								style="color: white" />

							<util:remoteSortableColumn property="rowCreated"
								title="Created Date" controller="aboutPassionate"
								action="ajaxPaginate" update="aboutList"
								params="[offset:offset, max: max ,size:total]"
								style="color: white" />

							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<g:if test='${aboutPassionateList}'>
							<g:each in="${aboutPassionateList}" var="abtpass" status="i">
								<tr>
									<td>
										${abtpass?.fullName}
									</td>
									<td>
										${abtpass?.describeAboutYourself}
									</td>
									<td>
										${abtpass?.passionateAbout}
									</td>
									<td><g:formatDate date="${abtpass?.rowCreated}" type="datetime" style="MEDIUM" /></td>
									<td><g:link controller="aboutPassionate" action="edit" params="${[abtpassId:abtpass.id]}" title="edit"><img src="${resource(dir:'admin/image',file:'edit.png')}"></g:link>&nbsp;
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
				<g:if test="${aboutPassionateListTotal}">
					<util:remotePaginate total="${aboutPassionateListTotal}"
						update="aboutList" controller="aboutPassionate"
						action="ajaxPaginate" max="10" params="['size':total,'searchValue':searchValue]"
						pageSizes="[10:'10', 20: '20', 50:'50',100:'100']" />
				</g:if>
			</div>
		</div>
	</div>
</div>
