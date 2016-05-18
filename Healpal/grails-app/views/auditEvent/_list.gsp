<%@ page contentType="text/html;charset=UTF-8" %>

<div id="logsList" class="box">

<div class="tab-content" style="overflow: auto">
	<div class="tab-pane active" id="tab1">
		<div id="pagination" class="widget-forms clearfix">
			
			
			
			<table id="example"
				class="table table-striped table-bordered dataTable" aria-describedby="tbl_user_info">
	<thead>
		<tr>
			<util:remoteSortableColumn property="auditEventType.auditEventTypeName" title="Event Description" controller="auditEvent" action="ajaxPaginate"  
														update="logsList" params="[offset:offset, max: max ,size:total]" style="color: white"/>
			
			<util:remoteSortableColumn property="healpalUser.userName" title="Username" controller="auditEvent" action="ajaxPaginate"  
														update="logsList" params="[offset:offset, max: max ,size:total]" style="color: white"/>
			
			<util:remoteSortableColumn property="auditEventTime" title="Event Date" controller="auditEvent" action="ajaxPaginate"  
														update="logsList" params="[offset:offset, max: max ,size:total]" style="color: white"/>
			
		</tr>
	</thead>
	<tbody><g:if test="${logs}">
		<g:each in="${logs}" var="log">
			<tr>
				<td>
					${log?.auditEventType?.auditEventTypeName}
				</td>
				<td>
					${log?.healpalUser?.userName}
				</td>
				<td>
					<g:formatDate date="${log?.rowCreated}" type="datetime"
								style="MEDIUM" />
				</td>
			</tr>
		</g:each></g:if><g:else>
			<tr><td colspan="3" align="center">No results found </td></tr>
		</g:else>
	</tbody>
</table>
<div class="clearfix">&nbsp;</div>

<g:if test="${total}">
	<util:remotePaginate total="${total}" update="logsList"
		controller="auditEvent" action="ajaxPaginate" max="${max}"
		params="['size':total]"
		pageSizes="[10:'10', 20: '20', 50:'50',100:'100']" />
</g:if>




<%--<div class="col-xs-6">
	<div class="dataTables_paginate paging_bootstrap">
		<ul class="pagination">
			<li class="prev disabled"><a href="#">← Previous</a></li>
			<li class="active"><a href="#">1</a></li>
			<li><a href="#">2</a></li>
			<li><a href="#">3</a></li>
			<li><a href="#">4</a></li>
			<li><a href="#">5</a></li>
			<li class="next"><a href="#">Next → </a></li>
		</ul>
	</div>
</div>










--%></div>
</div>
</div>
</div>


	<%--<script type="text/javascript" src="${resource(dir:'admin/js',file:'jquery.dataTables.js')}"></script>
	<link href="${resource(dir:'admin/css',file:'jquery.dataTables.css')}" rel="stylesheet" type="text/css">
	
	<script type="text/javascript">
		$(document).ready(function() {
		$('#example').dataTable();
			var html='<select name="example_length" size="1"><option value="10" selected="selected" style="width:127px; height:10px;">Search By</option><option value="25">Product ID</option><option value="50">Status</option><option value="100">Main Category</option></select> <label><input type="search" class="" placeholder="" aria-controls="example"></label>';
			$('#example_filter').html(html);
		} );
	</script>


















--%>