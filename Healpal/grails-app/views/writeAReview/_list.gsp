<%@ page contentType="text/html;charset=UTF-8" %>
 <%@page import="com.healpal.care.Patient"%>
 <%@page import="com.healpal.care.Person"%>
<div id="pagination">
<div class="tab-content" style="overflow: auto">
	<div class="tab-pane active" id="tab1">
		<div id="pagination" class="widget-forms clearfix">
			<table
				class="table table-striped table-bordered  dataTable">
				<thead>
					<tr>
					<util:remoteSortableColumn property="diagnosis"  title="Diagnosis" controller="WriteAReview" action="ajaxPaginate"  
														update="pagination" params="[offset:offset, max: max ,size:total]" style="color: white"/>
			
			<util:remoteSortableColumn property="isActive" title="Status" controller="WriteAReview" action="ajaxPaginate"  
														update="pagination" params="[offset:offset, max: max ,size:total]" style="color: white"/>
			
			<util:remoteSortableColumn property="rowCreated" title="Created Date" controller="WriteAReview" action="ajaxPaginate"  
														update="pagination" params="[offset:offset, max: max ,size:total]" style="color: white"/>
														
			<util:remoteSortableColumn property="title" title="Title" controller="WriteAReview" action="ajaxPaginate"  
														update="pagination" params="[offset:offset, max: max ,size:total]" style="color: white"/>
			


<util:remoteSortableColumn property="yourReview" title="Your Review" controller="WriteAReview" action="ajaxPaginate"  
														update="pagination" params="[offset:offset, max: max ,size:total]" style="color: white"/>

<util:remoteSortableColumn property="clinicLocation" title="Clinic Location" controller="WriteAReview" action="ajaxPaginate"  
														update="pagination" params="[offset:offset, max: max ,size:total]" style="color: white"/>



			<th>Action</th>
			</tr>
				</thead>
				<tbody>
				<g:if test="${writeAreview}">
						<g:each in="${writeAreview}" var="list">
							<tr>
								<td>
								${list?.diagnosis?.diagnosisName}
								<g:if test="${list?.isActive == 1 }">
									<td>Active</td>
								</g:if>
								<g:else>
									<td>InActive</td>
								</g:else>
								<td>
					<g:formatDate date="${list?.rowCreated}" type="datetime"
								style="MEDIUM" />	
				</td>
				
				<td>
				${list?.reviewTitle}
				</td>
				
				<td>
				${list?.yourReview}
				</td>
				
				<td>
				${list?.clinicLocation}
				</td>
								
									<td>
										<g:link controller="WriteAReview" action="edit" params="${[writeAReviewId:list?.id]}">Edit</g:link>&nbsp;&nbsp;&nbsp;
										<g:if test="${list.approved==0}">
										<g:link controller="WriteAReview" action="approve" params="${[writeAReviewId:list?.id]}" onclick="if(!confirm('Are you sure you want to Approve?'))  return false">UnApprove</g:link>&nbsp;&nbsp;&nbsp;
										</g:if>
										
										<g:elseif test="${list.approved==1}">
										<g:link controller="WriteAReview" action="approve" params="${[writeAReviewId:list?.id]}" onclick="if(!confirm('Already Approved?'))  return false">Approved</g:link>&nbsp;&nbsp;&nbsp;
										</g:elseif>
									</td>
								
								
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
					controller="WriteAReview" action="ajaxPaginate" max="10"
					params="['size':total]"
					pageSizes="[10:'10', 20: '20', 50:'50',100:'100']" />
			</g:if>
		</div>
	</div>
</div>
</div>