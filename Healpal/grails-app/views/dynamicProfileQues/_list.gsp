<%@ page contentType="text/html;charset=UTF-8" %>

<div id="questionsList" class="searchList">

<div class="tab-content" style="overflow: auto">
	<div class="tab-pane active" id="tab1">
		<div id="pagination" class="widget-forms clearfix">
			<table id="users"
				class="table table-striped table-bordered  dataTable">
	<thead>
		<tr>
			<util:remoteSortableColumn property="questionText.questionText" title="Question" controller="dynamicProfileQues" action="ajaxPaginate"  
														update="questionsList" params="[offset:offset, max: max ,size:total]" style="color:white;"/>
			
			<util:remoteSortableColumn property="rowCreated" title="Created Date" controller="dynamicProfileQues" action="ajaxPaginate"  
														update="questionsList" params="[offset:offset, max: max ,size:total]" style="color:white;"/>
														
			<util:remoteSortableColumn property="isActive" title="Status" controller="dynamicProfileQues" action="ajaxPaginate"  
														update="questionsList" params="[offset:offset, max: max ,size:total]" style="color:white;"/>											
			
			<th>Action</th>
		</tr>
	</thead>
	<tbody>
		<g:if test="${questions}"> 
		<g:each in="${questions}" var="ques">
			<tr>
				<td>
					${ques?.questionText?.questionText}
				</td>
				<td>
					<g:formatDate date="${ques?.rowCreated}" type="datetime"
								style="MEDIUM" />
				</td>
				<td><g:if test="${ques?.isActive == 1}">Active</g:if> <g:else>InActive</g:else>
				<td><g:link controller="dynamicProfileQues" action="edit"
						params="[quesId : ques?.id]" title="edit"><img src="${resource(dir:'admin/image',file:'edit.png')}"></g:link>
					<g:link controller="dynamicProfileQues" action="doDelete"
						params="[quesId : ques?.id]"
						onclick="if(!confirm('Are you sure you want to Delete?'))  return false" title="delete"><img src="${resource(dir:'admin/image',file:'delete.png')}"></g:link>
				</td>
			</tr>
		</g:each></g:if><g:else>
			<tr><td colspan="4" align="center">No results found </td></tr>
		</g:else>
	</tbody>
</table>


<g:if test="${total}">
	<util:remotePaginate total="${total}" update="questionsList"
		controller="DynamicProfileQues" action="ajaxPaginate" max="${max}"
		params="['size':total,'searchValue':searchValue]"
		pageSizes="[10:'10', 20: '20', 50:'50',100:'100']" />
</g:if>

</div>
</div>
</div>

</div>

















