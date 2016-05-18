<%--/**
 *
 * Author  		:Priyanga
 * Project 		: Healpal
 * Date    		: 10/10/2015
 * Description	: metastaticBreastCancerEdit
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
				Edit Metastatic Breast Cancer <small> <g:link controller="dashboard" action="adminDashboard">Home </g:link><i class="icon-angle-double-right"></i> Edit Metastatic Breast Cancer</small>
			</h1>
		</div>

		<div class="group">
			<div class="row-fluid">
				<div class="widget widget-padding box span12">
					<div class="widget-body pad25" style="height: auto;">
						<div class="widget-forms clearfix">
							
								<g:form controller="MetastaticBreastCancer" action="edit" method="post" class="form-horizontal" onSubmit="return doSave();">
									<input type="hidden" name="metastaticId" value="${metastaticBreastCancer?.id}">
									<h4 class="blue-text">Metastatic Breast Cancer</h4>
									<g:if test="${flash.msg}">
										<h6 class="red-text">${flash.msg}</h6>
									</g:if>
									<div id="err"></div>
									<div class="control-group">
										<label class="control-label"><b>Metastatic Breast Cancer Type</b></label>
										<div class="controls">
											<input type="text" class="span7" name="metastaticName"
												id="metastaticName" required=""
												placeholder="Enter Metastatic Breast Cancer Type"
												value="${metastaticBreastCancer?.metastaticName}">
										</div>
									</div>
									<div class="control-group">
										<label class="control-label"><b>Status</b></label>
										<div class="controls">
											<g:radio name="status" value="active" checked="${metastaticBreastCancer?.isActive==1}" />
											Active
											<g:radio name="status" value="inactive" checked="${metastaticBreastCancer?.isActive==0}" />
											InActive
										</div>
									</div>
									<div class="control-group">
										<div class="controls">
											<input type="submit" value="Update" class="btn btn-info" /> &nbsp;&nbsp;
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
