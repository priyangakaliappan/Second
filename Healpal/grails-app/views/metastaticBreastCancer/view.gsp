<%--/**
 *
 * Author  		:Priyanga
 * Project 		: Healpal
 * Date    		: 10/10/2015
 * Description	: metastaticBreastCancerView
 *
 * #      Name         Version   Modified-Date      Description
 * -------------------------------------------------------------------------------------
 * 1   Priyanga      1.0        10/10/2015      Initial Creation
 * 2   Priyanga      2.0        10/20/2015       Modification
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
				Metastatic Breast Cancer Types 
			</h1>
			<div class="pull-right"><small><g:link controller="dashboard" action="adminDashboard">Home </g:link><i class="icon-angle-double-right"></i>Metastatic Breast Cancer Types</small></div>
		</div>
		<div class="row-fluid">
			<div class="widget span12 box">
				<div class="widget-body" style="height: auto;">
					<div class="control-group">
						<div class="controls">
							<g:link controller="MetastaticBreastCancer" action="create" class="btn btn-info btn-medium table-btn">Add New</g:link>
						</div>
					</div>
					<div class="col-xs-6">
					<div class="dataTables_filter" id="tbl_user_filter">
					<label>Search: <input type="text" class="textbox" aria-controls="tbl_user"></label>
					</div></div>
					<div class="clearfix"></div>
					<div class="tab-content">
						<div class="tab-pane active" id="tab1">
							<g:if test="${flash.msg}">
								<h6 class="red-text">${flash.msg}</h6>
							</g:if>
							<g:render template="viewMetastatic"></g:render>
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

