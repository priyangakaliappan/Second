<%--/**
 *
 * Author  		: Subhapriya
 * Project 		: Healpal
 * Description	: personalInterestView
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
	<div id="tables_page" class="main_container glass">		
			<div class="row-fluid title blue-topstripe">
				<h1>
				Personal Interest
					<small><g:link controller="dashboard" action="adminDashboard">Home </g:link>
						<i class="icon-angle-double-right"></i>Personal Interest</small>
				</h1>
			</div>
		
			<div class="clearfix">&nbsp;</div>
			<div class="row-fluid">
				<div class="widget span12 box">
					<div class="widget-body pad25" style="height: auto;">
					<div class="control-group">
						<div class="controls">
							<g:link controller="PersonalInterest" action="add" class="btn btn-info btn-medium">Add New</g:link>
						</div></div>
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
			<div class="clearfix">&nbsp;</div>
		<%--</g:if>
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
</body>
</html>

