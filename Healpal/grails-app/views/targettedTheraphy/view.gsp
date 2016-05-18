<%--
 *
 * Author  		: Ramesh L
 * Project 		: HealPal
 * Date    		: 10/27/2015
 * Description	: Targetted Terapy View
 *
 * #      Name         Version   Modified-Date      Description
 * -------------------------------------------------------------------------------------
 * 1      Ramesh L     1.0       10/27/2015      Initial Creation
 * 
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
					Targetted Therapy
					<small> <g:link controller="DashBoard" action="patientIndex" class="blue-text">Home</g:link>
						<i class="icon-angle-double-right"></i> Targetted Terapy</small><br>
				</h1>
			</div>
		
			<div class="clearfix">&nbsp;</div>
			<div class="row-fluid">
				<div class="widget span12 box">
					<div class="widget-body pad25" style="height: auto;">
					<div class="control-group">
						<div class="controls">
							<g:link controller="targettedTheraphy" action="add" class="btn btn-info btn-medium">Add New</g:link>
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
	<g:render template="viewTargettedTerapy"></g:render>
								
							</div>
						</div>
					</div>
				</div>
				<!-- /widget-body -->
			</div>
			<!-- /widget -->
			<div class="clearfix">&nbsp;</div><%--
		
		<g:else>
			<div class="clearfix">&nbsp;</div>
			<div class="row-fluid">
				<div class="widget span12 box">
					<div class="widget-body pad25" style="height: 500px;">
						<i class="icon-attention-circle" style="color: red"></i><g:message code="patientportal.rolesandprivile.message" />
					</div>
				</div>
			</div>
		</g:else>
	--%></div>
	<!-- /row-fluid -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
	 <script type="text/javascript" src="${resource(dir:'js/active/admin',file:'bloodDonor.js')}"></script>
    <script type="text/javascript" src="${resource(dir:'js/autoLogout',file:'logout.js')}"></script>
	
	<script type="text/javascript" src="../js/tablesort/sorttable.js"></script>
</body>
</html>

			

