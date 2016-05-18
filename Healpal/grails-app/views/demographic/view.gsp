<%--/**
 *
 * Author  		: Ramesh
 * Project 		: Healpal
 * Date    		: 10/10/2015
 * Description	: Demographic
 *
 * #      Name         Version   Modified-Date      Description
 * -------------------------------------------------------------------------------------
 * 1   Ramesh      1.0        10/10/2015      Initial Creation
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
				Demography
					<small> <g:link  class="blue-text">Home</g:link>
						<i class="icon-angle-double-right"></i>Demography</small>
				</h1>
			</div>
			<div class="clearfix">&nbsp;</div>
			<div class="row-fluid">
				<div class="widget span12 box">
					<div class="widget-body pad25" style="height: auto;">
						<div class="tab-content">
							<div class="tab-pane active" id="tab1">
								<g:if test="${flash.msg}">
								<h6 class="red-text">
									${flash.msg}
								</h6>
								</g:if><%--
								<g:if test="${hormoneTherapy}">
									--%><g:render template="viewDemographic"></g:render>
								<%--</g:if>
							--%></div>
						</div>
					</div>
				</div>
				<!-- /widget-body -->
			</div>
			<!-- /widget -->
			<div class="clearfix">&nbsp;</div>
	</div>
	<!-- /row-fluid -->
</body>
</html>

