<%--/**
 *
 * Author  		:Priyanga
 * Project 		: Healpal
 * Date    		: 10/10/2015
 * Description	:surgicalProcedureEdit
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
				Edit SurgicalProcedure<small> <g:link controller="dashboard" action="adminDashboard">Home </g:link><i class="icon-angle-double-right"></i> Edit SurgicalProcedure</small>
			</h1>
		</div>
		<div class="group">
			<div class="row-fluid">
				<div class="widget widget-padding box span12">
					<div class="widget-body pad25" style="height: auto;">
						<div class="widget-forms clearfix">
							<g:if test="surgicalProcedure">
								<g:form controller="SurgicalProcedure" action="edit" method="post" name="patientForm" class="form-horizontal" onSubmit="return doSave();">
									<input type="hidden" name="surgicalProcedureTypeId" value="${surgicalProcedure?.id}">
									<h4 class="blue-text">Edit SurgicalProcedure</h4>
									<g:if test="${flash.msg}">
										<h6 class="red-text">${flash.msg}</h6>
									</g:if>
									<div id="err"></div>
									<div class="control-group">
										<label class="control-label"><b>SurgicalProcedure Type</b></label>
										<div class="controls">
											<input type="text" class="span7" name="surgicalProcedure" id="surgeryType" required="" placeholder="Enter Surgery Type" value="${surgicalProcedure?.surgicalProcedureType}">
										</div>
									</div>
									<div class="control-group">
										<label class="control-label"><b>Status</b></label>
										<div class="controls">
											<g:radio name="status" value="active" checked="${surgicalProcedure?.isActive==1}" />
											Active
											<g:radio name="status" value="inactive" checked="${surgicalProcedure?.isActive==0}" />
											InActive
										</div>
									</div>
									<div class="control-group">
										<div class="controls">
											<input type="submit" value="Update"  class="btn btn-info" />&nbsp;&nbsp;
											<g:link controller="SurgicalProcedure" action="cancel" class="btn btn-info">Cancel</g:link>
										</div>
									</div>
								</g:form>
							</g:if>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
