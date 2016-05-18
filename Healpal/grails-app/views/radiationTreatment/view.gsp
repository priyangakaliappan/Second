<%--
 *
 * Author  		: Ramesh L
 * Project 		: Healpal
 * Date    		: 10/28/2015
 * Description	: RadiationTreatment View
 *
 * #      Name         Version   Modified-Date      Description
 * -------------------------------------------------------------------------------------
 * 1     Ramesh L        1.0        10/28/2015       Initial Creation
 *
 */

--%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta name="layout" content="admin">
</head>
<body>
	<div id="tables_page" class="main_container glass">		
			<div class="row-fluid title blue-topstripe">
				<h1>
					Radiation Treatment
					<small><g:link controller="dashboard" action="adminDashboard">Home </g:link>
						<i class="icon-angle-double-right"></i> Radiation Treatment</small><br>
				</h1>
			</div>
		
			<div class="clearfix">&nbsp;</div>
			<div class="row-fluid">
				<div class="widget span12 box">
					<div class="widget-body pad25" style="height: auto;">
					<div class="control-group">
						<div class="controls">
							<g:link controller="radiationTreatment" action="add" class="btn btn-info btn-medium">Add New</g:link>
						</div>
					</div>
						<div class="tab-content">
							<div class="tab-pane active" id="tab1">
								<g:if test="${flash.msg}">
								<h6 class="red-text">
									${flash.msg}
								</h6>
								</g:if>
								<%--<g:render template="viewBloodDonor"></g:render>--%>
								<div class="tab-content" style="overflow: auto">
	<g:render template="viewRadiationTreatment"></g:render>
								
							</div>
						</div>
					</div>
				</div>
				<!-- /widget-body -->
			</div>
			<!-- /widget -->
			<div class="clearfix">&nbsp;</div>
	</div>
	</div>
	<!-- /row-fluid -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
	 <script type="text/javascript" src="${resource(dir:'js/active/admin',file:'bloodDonor.js')}"></script>
    <script type="text/javascript" src="${resource(dir:'js/autoLogout',file:'logout.js')}"></script>
	
	<script type="text/javascript" src="../js/tablesort/sorttable.js"></script>
</body>
</html>

