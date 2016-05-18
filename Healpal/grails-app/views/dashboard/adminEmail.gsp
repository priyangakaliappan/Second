
<!DOCTYPE html>
<html lang="en">
<head>
<meta name="layout" content="admin">
</head>
<body>
	<div id="tables_page" class="main_container glass admin-content">
		<div class="row-fluid title orange-topstripe">
			<h1>
				View Mail 
			</h1>
			<div class="pull-right"><small> <g:link controller="dashboard"
						action="adminDashboard">Home </g:link> <i
					class="icon-angle-double-right"></i>View Mail
				</small></div>
		</div>
		<div class="row-fluid">
			<div class="widget span12 box">
				<div class="widget-body" style="height: auto;">
				<div class="col-xs-6">
							<div class="dataTables_filter" id="tbl_user_filter">
							<label>Search: <input type="text" class="textbox" aria-controls="tbl_user"></label>
							</div></div>
							<div class="clearfix"></div>
					<div class="tab-content">
						<div class="tab-pane active" id="tab1">
							<div id="pagination">
								<div class="tab-content" style="overflow: auto">
									<div class="tab-pane active" id="tab1">
										<g:render template="adminEmail"></g:render>
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
	</div>
	<!-- /row-fluid -->
</body>
</html>

