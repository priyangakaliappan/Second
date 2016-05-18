<!DOCTYPE html>
<html lang="en">
<head>
<meta name="layout" content="admin">
</head>

<body>
	<div id="tables_page" class="main_container glass">
		<div class="row-fluid title blue-topstripe">
			<h1>
				User Details <small><g:link controller="dashboard"
						action="adminDashboard">Home </g:link> <i
					class="icon-angle-double-right"></i>User Details</small>
			</h1>
		</div>
		<div class="clearfix">&nbsp;</div>
		<div class="row-fluid">
			<div class="widget span12 box">
				<div class="widget-body pad25" style="height: auto;">
					<div class="control-group">
						<div class="controls">
						 
						Search:&nbsp;&nbsp;&nbsp;&nbsp;<input class="datepicker"  type="text" placeholder="mm/dd/yyyy"
									id="searchUser" name="searchUser" readonly="readonly">
									<a href="JavaScript:void(0)" id="search"  class="btn btn-info btn-medium">Search</a>
						</div>
					</div>
					<div class="tab-content">
						<div class="tab-pane active" id="tab1">
						
						
									
									<div class="clearfix">&nbsp;</div>
							<g:render template="view"></g:render>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="clearfix">&nbsp;</div>
		
	</div>
	
	
</body>
</html>

