<%--/**
 *
 * Author  		: Subhapriya
 * Project 		: Healpal
 * Description	: healthInsuranceCreate
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
<div id="forms_page" class="main_container glass">
		<div class="row-fluid title blue-topstripe">
			<h1>
				Add Health Insurance
				<small> <g:link controller="dashboard" action="adminDashboard">Home </g:link><i class="icon-angle-double-right"></i> Add Health Insurance </small>
			</h1>
		</div>
		
		<div class="group">
			<div class="row-fluid">
				<div class="widget widget-padding box span12">

					<div class="widget-body pad25" style="height: auto;">
						<div class="widget-forms clearfix">
						
							<%--<g:formRemote name="signupForm" url="[controller: 'HealthInsurance', action: 'create']" update="createResult" class="form-horizontal" id="patient_login_form">
								--%>
								<g:form controller="HealthInsurance"  class="form-horizontal" onSubmit="return doSave();">
								<h4 class="blue-text">
									Add Health Insurance
								</h4>
								<div class="clearfix">&nbsp;&nbsp;</div>
								<g:if test="${flash.msg}">
						<h6 class="red-text">
									${flash.msg}
								</h6>
								</g:if>
								<div id="err"></div>
								<div class="control-group">
										<label class="control-label"><b>Health Insurance Type</b></label>
										<div class="controls">
										
											<input type="text"  class="span7" name="healthInsurance" id="healthInsurance" required="" placeholder="Enter Health Insurance Type" value="" >
												<%--<h6><span class="red-text" id="donorNameError"></span></h6>
										--%></div>
										</div>
										<div class="control-group">
										<div class="controls">
											<g:actionSubmit	value="Save" action="create"class="btn btn-info" />&nbsp;&nbsp;
										<g:link controller="HealthInsurance" action="cancel" class="btn btn-info">Cancel</g:link>
										</div>
										</div>
										<div id="createResult"></div>
										</g:form>
									</div></div></div></div></div>
		
		</div>
</body>
</html>
