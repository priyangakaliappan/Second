<%--/**
 *
 * Author  		:Priyanga
 * Project 		: Healpal
 * Date    		: 10/10/2015
 * Description	: hormoneTherapyEdit
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
				Edit Hormone Therapy Drug <small> <g:link controller="dashboard" action="adminDashboard">Home </g:link><i class="icon-angle-double-right"></i> Edit Hormone Therapy Drug</small>
			</h1>
		</div>
		<div class="group">
			<div class="row-fluid">
				<div class="widget widget-padding box span12">
					<div class="widget-body pad25" style="height: auto;">
						<div class="widget-forms clearfix">
								<g:form controller="HormoneTherapy" action="edit" method="post" class="form-horizontal" onSubmit="return doSave();">
									<input type="hidden" name="hormoneId" value="${hormoneTherapy?.id}">
									<h4 class="blue-text">Edit Hormone Therapy Drug</h4>
									<g:if test="${flash.msg}">
										<h6 class="red-text">${flash.msg}</h6>
									</g:if>
									<div id="err"></div>
									<div class="control-group">
										<label class="control-label"><b>Hormone Therapy Drug</b></label>
										<div class="controls">
											<input type="text" class="span7" name="hormoneTherapyName"
												id="hormoneTherapyName" required=""
												placeholder="Enter Hormone Therapy Name"
												value="${hormoneTherapy?.hormoneTherapyName}">
										</div>
									</div>
									<div class="control-group">
										<label class="control-label"><b>Status</b></label>
										<div class="controls">
											<g:radio name="status" value="active" checked="${hormoneTherapy?.isActive==1}" />
											Active
											<g:radio name="status" value="inactive" checked="${hormoneTherapy?.isActive==0}" />
											InActive
										</div>
									</div>
									<div class="control-group">
										<div class="controls">
											<input type="submit" value="Update" class="btn btn-info" />&nbsp;&nbsp;
											<g:link controller="HormoneTherapy" action="cancel" class="btn btn-info">Cancel</g:link>
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
