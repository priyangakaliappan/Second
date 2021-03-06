<%@ page contentType="text/html;charset=UTF-8"%>
<div id="usersList" class="searchList">
	<div class="tab-content" style="overflow: auto">
		<div class="tab-pane active" id="tab1">
			<div id="pagination" class="widget-forms clearfix">
				<table id="users"
					class="table table-striped table-bordered  dataTable">
					<thead>
						<tr>
							<util:remoteSortableColumn property="cancerStageLevel"
								title="Name" controller="CancerStage" action="ajaxPaginate"
								update="usersList"
								params="[offset:offset, max: max ,size:total]"
								style="color: white" />
							<util:remoteSortableColumn property="isActive" title="Status"
								controller="CancerStage" action="ajaxPaginate"
								update="usersList"
								params="[offset:offset, max: max ,size:total]"
								style="color: white" />
							<util:remoteSortableColumn property="rowCreated"
								title="Date Created" controller="CancerStage"
								action="ajaxPaginate" update="usersList"
								params="[offset:offset, max: max ,size:total]"
								style="color: white" />

							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<g:if test='${cancerStage}'>
							<g:each in="${cancerStage}" var="stages" status="i">
								<tr>
									<td>
										${stages?.cancerStageLevel}
									</td>
									<g:if test="${stages?.isActive==1}">
										<td>Active</td>
									</g:if>
									<g:else>
										<td>InActive</td>
									</g:else>

									<td><g:formatDate date="${stages?.rowCreated}"
											type="datetime" style="MEDIUM" /></td>
									<td><g:link controller="CancerStage" action="edit"
											params="${[stageId:stages?.id]}" title="edit">
											<img src="${resource(dir:'admin/image',file:'edit.png')}">
										</g:link>&nbsp;&nbsp;&nbsp; <g:link controller="CancerStage"
											action="delete" params="${[stageId:stages?.id]}"
											onclick="if(!confirm('Are you sure you want to Delete?'))  return false"
											title="delete">
											<img src="${resource(dir:'admin/image',file:'delete.png')}">
										</g:link>&nbsp;&nbsp;&nbsp;</td>
								</tr>
							</g:each>
						</g:if>
						<g:else>
							<tr>
								<td colspan="4">No record found</td>
							</tr>
						</g:else>
					</tbody>
				</table>
				<g:if test="${cancerStageTotal}">
					<util:remotePaginate total="${cancerStageTotal}" update="usersList"
						controller="CancerStage" action="ajaxPaginate" max="10"
						params="['size':total,'searchValue':searchValue]"
						pageSizes="[10:'10', 20: '20', 50:'50',100:'100']" />
				</g:if>
			</div>
		</div>
	</div>
</div>
