<%--/**
 *
 * Author  		: Ramesh
 * Project 		: Healpal
 * Date    		: 10/10/2015
 * Description	: MedicalConditionView
 *
 * #      Name         Version   Modified-Date      Description
 * -------------------------------------------------------------------------------------
 * 1      Ramesh      1.0        10/10/2015      Initial Creation
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
				Medical Condition 
			</h1>
			<div class="pull-right"><small><g:link controller="dashboard" action="adminDashboard">Home </g:link><i
					class="icon-angle-double-right"></i> Medical Condition
				</small></div>
		</div>
		
			<div class="row-fluid">
				<div class="widget span12 box">
					<div class="widget-body" style="height: auto;">
					<div class="control-group">
						<div class="controls">
							<g:link controller="medicalCondition" action="add" class="btn btn-info btn-medium table-btn">Add New</g:link>
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
									<h6 class="red-text">
										${flash.msg}
									</h6>
								</g:if>
								<%--<g:render template="viewBloodDonor"></g:render>--%>

								<div class="tab-content" style="overflow: auto">
									<g:render template="view"></g:render>
								</div>

							</div>
						</div>
					</div>
				</div>
				<!-- /widget-body -->
			</div>
			<!-- /widget -->
		
		<%--<g:else>
			<div class="clearfix">&nbsp;</div>
			<div class="row-fluid">
				<div class="widget span12 box">
					<div class="widget-body pad25" style="height: 500px;">
						<i class="icon-attention-circle" style="color: red"></i>
						<g:message code="patientportal.rolesandprivile.message" />
					</div>
				</div>
			</div>
		</g:else>
	--%></div>
	<!-- /row-fluid -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
	<script type="text/javascript"
		src="${resource(dir:'js/active/admin',file:'bloodDonor.js')}"></script>
	<script type="text/javascript"
		src="${resource(dir:'js/autoLogout',file:'logout.js')}"></script>

	<script type="text/javascript" src="../js/tablesort/sorttable.js"></script>
</body>
</html>



