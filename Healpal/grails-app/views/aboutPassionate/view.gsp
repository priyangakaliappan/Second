


<!DOCTYPE html>
<html lang="en">
<head>
<meta name="layout" content="admin">
</head>
<body>
	<div id="tables_page" class="main_container glass admin-content">
		<div class="row-fluid title orange-topstripe">
			<h1>Passionate About</h1>
			<div class="pull-right">
				<small> <g:link controller="dashboard" action="adminDashboard">Home </g:link> <i class="icon-angle-double-right"></i>Passionate About </small>
			</div>
		</div>
		<div class="row-fluid">
			<div class="widget-body span12 box">
				<div class="widget-bod" style="height: auto;">
					<div class="col-xs-6">
						<div class="dataTables_filter" id="tbl_user_filter">
							<label>Search: <input type="text" class="textbox" aria-controls="tbl_user"></label>
						</div>
					</div>
					<div class="clearfix"></div>
					<div class="tab-content">
						<div class="tab-pane active" id="tab1">
							<g:if test="${flash.msg}">
								<h6 class="red-text"> ${flash.msg} </h6>
							</g:if>
							<g:render template="list"></g:render>
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

