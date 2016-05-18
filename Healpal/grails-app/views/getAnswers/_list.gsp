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
					
			<util:remoteSortableColumn property="yourStory" title="Question Related To" controller="GetAnswers" action="ajaxPaginate"  
														update="pagination" params="[offset:offset, max: max ,size:total]" style="color: white"/>
						
			<util:remoteSortableColumn property="yourQuestion" title="Question" controller="GetAnswers" action="ajaxPaginate"  
														update="pagination" params="[offset:offset, max: max ,size:total]" style="color: white"/>
			
			<util:remoteSortableColumn property="yourLocation" title="City /State" controller="GetAnswers" action="ajaxPaginate"  
														update="pagination" params="[offset:offset, max: max ,size:total]" style="color: white"/>
			
			<util:remoteSortableColumn property="rowCreated" title="Created Date" controller="GetAnswers" action="ajaxPaginate"  
														update="pagination" params="[offset:offset, max: max ,size:total]" style="color: white"/>
														
			<util:remoteSortableColumn property="isActive" title="Answer" controller="GetAnswers" action="ajaxPaginate"  
														update="pagination" params="[offset:offset, max: max ,size:total]" style="color: white"/>


			<th>Action</th>
			</tr>
				</thead>
				<tbody>
				<g:if test="${getAnswers}">
						<g:each in="${getAnswers}" var="list">
							<tr>
				<td>
				${list?.yourQuestionIsRelatedTo}
				</td>
					
				<td>
				${list?.yourQuestion}
				</td>	
				<td>
				${list?.yourLocation}
				</td>
							
				<td>		
					<g:formatDate date="${list?.rowCreated}" type="datetime"
								style="MEDIUM" />	
				</td>
				
				<td>
				${list?.answers}
				</td>
		
						   		<td>
										<g:link controller="GetAnswers" action="edit" params="${[getAnswerID:list?.id]}">Answers</g:link><%--&nbsp;&nbsp;&nbsp;
										<g:link controller="GetAnswers" action="approve" params="${[getAnswerID:list?.id]}" onclick="if(!confirm('Are you sure you want to Approve?'))  return false">Approve</g:link>&nbsp;&nbsp;&nbsp;
									--%></td>
								
								
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
					controller="GetAnswers" action="ajaxPaginate" max="10"
					params="['size':total]"
					pageSizes="[10:'10', 20: '20', 50:'50',100:'100']" />
			</g:if>
		</div>
	</div>
</div>
</div>