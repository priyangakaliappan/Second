<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="layout" content="admin" />
<title>::.. Healpal | Users ..::</title>
</head>
<body>
	<div id="tables_page" class="main_container glass admin-content">
		<div class="row-fluid title orange-topstripe">
			<%--<h1>
				Breast Count<small><g:link controller="dashboard"
						action="adminDashboard">Home </g:link> <i
					class="icon-angle-double-right"></i>Breast Count</small>
			</h1>
			--%><h1>
				Lung Cancer
				</h1>
				<div class="pull-right"><small><g:link controller="dashboard"
						action="adminDashboard">Home </g:link> <i
					class="icon-angle-double-right"></i>Lung Cancer </small>
			</h1></div>
		</div>
		<div class="clearfix">&nbsp;</div>
		<div class="row-fluid">
			<div class="widget span12 box">
				<div class="widget-body pad25" style="height: auto;">
					<div class="control-group">
						<div class="controls">
							
						</div>
					</div>
					<div class="tab-content">
						<div class="tab-pane active" id="tab1">
							<g:if test="${flash.msg}">
								<h6 class="red-text">
									${flash.msg}
								</h6>
							</g:if>
							<div id="usersList">
<div class="tab-content" style="overflow: auto">
	<div class="tab-pane active" id="tab1">
		<div id="pagination" class="widget-forms clearfix">
			<table id="users"
				class="table table-striped table-bordered  dataTable">
	<thead>
		<tr>
			<util:remoteSortableColumn property="person.firstName"  title="Name" controller="user" action="ajaxPaginate"  
														update="usersList" params="[offset:offset, max: max ,size:total]" style="color: white"/>
			<util:remoteSortableColumn property="person.emailAddress" title="Email" controller="user" action="ajaxPaginate"  
														update="usersList" params="[offset:offset, max: max ,size:total]" style="color: white"/>
			
			
			<util:remoteSortableColumn property="rowCreated" title="Created Date" controller="user" action="ajaxPaginate"  
														update="usersList" params="[offset:offset, max: max ,size:total]" style="color: white"/>
			
		
		</tr>
	</thead>
	<tbody>
	<g:if test="${lungCancerList}">
		<g:each in="${lungCancerList}" var="user">
			<tr>
				<td>
					${user?.person?.fullName}
				</td>
				<td>
					${user?.person?.emailAddress}
				
				<td>
					<g:formatDate date="${user?.person?.rowCreated}" type="datetime"
								style="MEDIUM" />
				</td>
				
			</tr>
		</g:each>
		</g:if><g:else>
			<tr><td colspan="5" align="center">No results found </td></tr>
		</g:else>
		
	</tbody>
</table>


<g:if test="${total}">
	<util:remotePaginate total="${total}" update="usersList"
		controller="user" action="ajaxPaginate" max="${max}"
		params="['size':total]"
		pageSizes="[10:'10', 20: '20', 50:'50',100:'100']" />
</g:if>

</div>
</div>
</div>
</div>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="clearfix">&nbsp;</div>
	
</body>
</html>