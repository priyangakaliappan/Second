<%@ page contentType="text/html;charset=UTF-8" %>
 <%@page import="com.healpal.care.Patient"%>
 <%@page import="com.healpal.care.Person"%>
 <%@page import="com.healpal.care.Diagnosis"%>
<div id="pagination">
<div class="tab-content" style="overflow: auto">
	<div class="tab-pane active" id="tab1">
		<div id="pagination" class="widget-forms clearfix">
			<table
				class="table table-striped table-bordered  dataTable">
				<thead>
					<tr>
					<util:remoteSortableColumn property="diagnosis"  title="TypeOfCancer" controller="StageOfCancer" action="ajaxPaginate"  
														update="pagination" params="[offset:offset, max: max ,size:total]" style="color: white"/>
			
			<%--<util:remoteSortableColumn property="isActive" title="Status" controller="StageOfCancer" action="ajaxPaginate"  
														update="pagination" params="[offset:offset, max: max ,size:total]" style="color: white"/>
			
			<util:remoteSortableColumn property="rowCreated" title="Created Date" controller="StageOfCancer" action="ajaxPaginate"  
														update="pagination" params="[offset:offset, max: max ,size:total]" style="color: white"/>
			
--%><th>I</th>
<th>II</th>
<th>IIA</th>
<th>IIB</th>
<th>IIIA</th>
<th>IIIB</th>
<th>IIIA</th>
<th>IIIC</th>
<th>IV</th>
<th>REcurrent</th>
<th>Not Sure</th>
<th>Dont Know</th>
			</tr>
				</thead>
				<tbody>
				<%--<g:if test="${shareYourStory}">
						<g:each in="${shareYourStory}" var="list">--%>
							
							
							<g:if test="${diagnosisList}">  <g:each in="${diagnosisList}" var="list">
							<tr><td>${list.diagnosisName}</td></tr>
							 </g:each> 
							 </g:if>
							 
								
				
				<td>
				</td>
				
				<td>
				</td>
				
				<td>
				</td>
				
				<td>
				</td>
								
									<td>
									</td>
								
								
						<%--</g:each>
					</g:if>
					<g:else>
						<tr>
							<td colspan="3">No Results Found</td>
						</tr>
					</g:else>
				--%></tbody>
			</table>
			<g:if test="${total}">
				<util:remotePaginate total="${total}" update="pagination"
					controller="ShareYourStory" action="ajaxPaginate" max="10"
					params="['size':total]"
					pageSizes="[10:'10', 20: '20', 50:'50',100:'100']" />
			</g:if>
		</div>
	</div>
</div>
</div>