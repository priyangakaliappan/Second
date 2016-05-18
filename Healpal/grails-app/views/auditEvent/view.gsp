<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<meta name="layout" content="admin"/>
<title>Insert title here</title>
</head>
<body>
  <div id="tables_page" class="main_container glass admin-content">
		<div class="row-fluid title orange-topstripe">
			<h1>
				Audit Logs 
			</h1>
			<div class="pull-right"><small><g:link controller="dashboard" action="adminDashboard">Home </g:link> <i
					class="icon-angle-double-right"></i>Audit Logs</small></div>
		</div>
		<div class="row-fluid">
			<div class="widget span12 box">
				<div class="widget-body" style="height: auto;">
				<div class="box-header"> </div>
				<div class="control-group">
						<div class="controls">
							<g:link controller="auditEvent" action="clearAll" class="btn btn-info btn-medium table-btn" onclick="if(!confirm('Are you sure you want to Delete?'))  return false">Clear All</g:link>
						</div></div>
						<div class="col-xs-6">
							<div class="dataTables_filter" id="tbl_user_filter">
								<label>Search: <input type="text" class="textbox" aria-controls="tbl_user"></label>
							</div>
						</div>
					<div class="clearfix"></div>
					<div class="tab-content">
						<div class="tab-pane active" id="tab1">
							<g:render template="list"></g:render>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	

	
	
	
	
	
	
	
</body>
</html>

