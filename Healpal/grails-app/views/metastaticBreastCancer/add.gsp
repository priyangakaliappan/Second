<%--/**
 *
 * Author  		:Priyanga
 * Project 		: Healpal
 * Date    		: 10/10/2015
 * Description	: metastaticBreastCancerCreate
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
	<div id="forms_page" class="main_container glass">
		<div class="row-fluid title blue-topstripe">
			<h1>
				Add Metastatic Breast Cancer Type <small> <g:link controller="dashboard" action="adminDashboard">Home </g:link><i class="icon-angle-double-right"></i> Add Metastatic Breast Cancer Type</small>
			</h1>
		</div>
		<div class="group">
			<div class="row-fluid">
				<div class="widget widget-padding box span12">
					<div class="widget-body pad25" style="height: auto;">
						<div class="widget-forms clearfix">
							<g:form controller="MetastaticBreastCancer" name="" class="form-horizontal" onSubmit="return doSave();">
								<h4 class="blue-text">Metastatic Breast Cancer Type</h4>
								<g:if test="${flash.msg}">
									<h6 class="red-text">${flash.msg}</h6>
								</g:if>
								<div id="err"></div>
								<div class="control-group">
									<label class="control-label"><b>Metastatic Breast
											Cancer Type</b></label>
									<div class="controls">
										<input type="text" class="span7" name="metastaticName" id="metastaticName" required="" placeholder="Enter Metastatic Breast Cancer Type">
									</div>
								</div>
								<div class="control-group">
									<div class="controls">
										<g:actionSubmit value="Save" action="save" class="btn btn-info" /> &nbsp;&nbsp;
										<g:link controller="MetastaticBreastCancer" action="cancel" class="btn btn-info">Cancel</g:link>
									</div>
								</div>
							</g:form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
