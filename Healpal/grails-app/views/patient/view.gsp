<!DOCTYPE html>
<html lang="en">
<head>
<meta name="layout" content="admin">
</head>
<body>
	<div id="tables_page" class="main_container glass">		
			<div class="row-fluid title blue-topstripe">
				<h1>
				Patient Profile
					<small><g:link  class="blue-text">Home</g:link>
						<i class="icon-angle-double-right"></i>Patient Profile</small>
				</h1>
			</div>
			<div class="clearfix">&nbsp;</div>
			<div class="row-fluid">
				<div class="widget span12 box">
					<div class="widget-body pad25" style="height: auto;">
					<div class="control-group">
						<div class="controls">
							<g:link controller="Patient" action="add" class="btn btn-info btn-medium">Add</g:link>
						</div></div>
						<div class="tab-content">
							<div class="tab-pane active" id="tab1">
								<g:if test="${flash.msg}">
								<h6 class="red-text">
									${flash.msg}
								</h6>
								</g:if>
								<%--<g:render template="viewBloodDonor"></g:render>--%>
								<div class="tab-content" style="overflow: auto">
	<div class="tab-pane active" id="tab1">
		<div id="pagination" class="widget-forms clearfix">
			<table id="users"
				class="table table-striped table-bordered  dataTable">
				<thead>
					<tr style="background-color: #F2F2F0">
						<th>First Name</th>
						<th>Last Name</th>
						<th>EmailAddress</th>
						<th>Date Created</th>
						<th>Is Active</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<g:each in="${patientList}" var="reports" status="i">
						<tr>
						<td>${reports.person.firstName}</td>
						<td>${reports.person.lastName}</td>
						<td>${reports.person.emailAddress}</td>
						<td>${reports.rowCreated }</td>
						<td>${reports.isActive}</td>
						<td>&nbsp;&nbsp;&nbsp;<g:link controller="Patient" action="edit" params="${[patientId:reports?.id]}">Edit</g:link>&nbsp;&nbsp;&nbsp;<g:link controller="Patient" action="delete"  params="${[patientId:reports?.id,personId: reports?.person?.id]}">Delete</g:link>&nbsp;&nbsp;&nbsp;</td>
						
						</tr>
					</g:each>
				</tbody>
			</table>
		</div>
	</div>
</div>
								
							</div>
						</div>
					</div>
				</div>
				<!-- /widget-body -->
			</div>
			<!-- /widget -->
			<div class="clearfix">&nbsp;</div>
			
	</div>
	<!-- /row-fluid -->
</body>
</html>

