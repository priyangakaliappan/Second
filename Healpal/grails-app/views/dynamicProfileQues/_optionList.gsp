<%@ page contentType="text/html;charset=UTF-8" %>

<span class="red-text">${msg}</span>
<div class="tab-content" style="overflow: auto">
	<div class="tab-pane active" id="tab1">
		<div class="widget-forms clearfix">
			<table id="users" class="table table-striped table-bordered  dataTable">
		<thead>
			<tr>
					<th>Name</th>
					<th>Action</th>
			</tr>
		</thead>
		<tbody><g:if test="${list}">
		<g:each in="${list}" var="op">
			<tr>
				<td>${op?.questionOptions}</td>
				<td>
						<g:remoteLink title="Edit" url="[controller:'dynamicProfileQues',action:'optionEdit']"  update="optionFormId" method="GET" params="[opId:op?.id]">Edit</g:remoteLink> 
						<g:remoteLink title="Delete"
							controller="dynamicProfileQues" action="optionDelete" params="[opId:op?.id]"
							before="if(!confirm('Are you sure you want to Delete?')) return false" update="optionsListId">Delete</g:remoteLink>
				</td>
			</tr>
		</g:each></g:if><g:else>
			<g:hiddenField name="noOption" id="noOptionId" value="no"/>
			<tr><td colspan="2" align="center">No options found </td></tr>
		</g:else>	
		</tbody>
</table>
</div>
</div>
</div>
