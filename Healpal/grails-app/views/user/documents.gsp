<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="layout" content="admin" />
<title>::.. Healpal | User ..::</title>
</head>
<body>
	<div id="forms_page" class="main_container glass">
		<div class="row-fluid title blue-topstripe">
			<h1>
				Patient Documents <small>
				<g:link controller="dashboard" action="adminDashboard" class="blue-text"> Home </g:link> 
				<i class="icon-angle-double-right"></i>Patient Documents</small>
			</h1>
		</div>
		<div class="group">
			<div class="row-fluid">
				<div class="widget widget-padding box span12">
					<div class="widget-body pad25" style="height: auto;">
						<div class="widget-forms clearfix">
							<h4 class="blue-text">Patient Documents</h4>
							<g:if test="${flash.msg}">
								<h6 class="red-text">
									${flash.msg}
								</h6>
							</g:if>
							<table id="users"
								class="table table-striped table-bordered  dataTable">
								<thead>
									<tr>
										<th>Medical Documents</th>
										<th>Action</th>
									</tr>
								</thead>
								<tbody>
									<g:if test="${documents}">
										<g:each in="${documents}" var="report">
											<tr>
												<td>
													${report?.fileName}
												</td>
												<td>
													<g:link controller="user" action="downloadDoc" params="[personId:report?.patient?.person?.id,filePath:report?.filePath,fileName:report?.fileName]">Download</g:link>&nbsp;&nbsp;&nbsp;&nbsp;
													<g:link controller="user" action="sendmail" params="[personId:report?.patient?.person?.id]">Send Mail</g:link>&nbsp;&nbsp;&nbsp;&nbsp;
											</tr>
										</g:each>
									</g:if>
									<g:else>
										<tr>
											<td colspan="5" align="center">No results found</td>
										</tr>
									</g:else>

								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</body>
</html>