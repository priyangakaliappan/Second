Did You Undergo Hormonal therapy
<%--/**
 *
 * Author  		:Priyanga
 * Project 		: Healpal
 * Date    		: 10/10/2015
 * Description	: chemotherapyDrugsView
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
	<div id="tables_page" class="main_container glass">
		<div class="row-fluid title blue-topstripe"></div>
		<div class="clearfix">&nbsp;</div>
		<div class="row-fluid">
			<div class="widget span12 box">
				<div class="widget-body pad25" style="height: auto;">
					<div class="control-group">
						<div class="controls"></div>
					</div>
					<div class="tab-content">
						<div class="tab-pane active" id="tab1">
<label style="color: red">${flash.msg}</label>
							<g:form class="form-horizontal" enctype="multipart/form-data"
								name="upload" method="post">
								<input type="file" name="filecsv" id="filecsv">
								<g:actionSubmit value="Upload" action="fileUpload" />
							</g:form>


						</div>
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