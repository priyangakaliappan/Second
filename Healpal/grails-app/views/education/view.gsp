<%--/**
 *
 * Author  		: Subhapriya
 * Project 		: Healpal
 * Description	: educationView
 *
 * #      Name         Version   Modified-Date      Description
 * -------------------------------------------------------------------------------------
 * 1   Subhapriya      1.0        			       Initial Creation
 *
 */
--%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta name="layout" content="admin">
</head>
<body>
	<div id="tables_page" class="main_container glass admin-content">		
			<div class="row-fluid title orange-topstripe">
				<h1>
				Education
				</h1>
				<div class="pull-right"><small> <g:link controller="dashboard" action="adminDashboard">Home </g:link>
						<i class="icon-angle-double-right"></i>Education</small></div>
			</div>
		
			<div class="row-fluid">
				<div class="widget span12 box">
					<div class="widget-body" style="height: auto;">
					<div class="control-group">
						<div class="controls">
							<g:link controller="Education" action="add" class="btn btn-info btn-medium table-btn">Add New</g:link>
						</div></div>
						<div class="col-xs-6">
							<div class="dataTables_filter" id="tbl_user_filter">
								<label>Search: <input type="text" class="textbox" aria-controls="tbl_user"></label>
							</div>
						</div>
						<div class="clearfix"></div>
						<div class="tab-content">
							<div class="tab-pane active" id="tab1">
								<g:if test="${flash.msg}">
								<h6 class="red-text">
									${flash.msg}
								</h6>
								</g:if>
								
								<g:render template="view"></g:render>
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

