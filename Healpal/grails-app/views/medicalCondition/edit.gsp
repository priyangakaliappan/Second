<%--/**
 *
 * Author  		: Ramesh
 * Project 		: Healpal
 * Date    		: 10/10/2015
 * Description	: MedicalCondition Update
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
	<div id="forms_page" class="main_container glass">
		<div class="row-fluid title blue-topstripe">
			<h1>
				Edit Medical Condition <small> <g:link controller="dashboard" action="adminDashboard">Home </g:link><i class="icon-angle-double-right"></i> Edit Medical Condition</small>
			</h1>
		</div>
		<div class="group">
			<div class="row-fluid">
				<div class="widget widget-padding box span12">

					<div class="widget-body pad25" style="height: auto;">
						<div class="widget-forms clearfix">
							

							
								<g:form controller="medicalCondition" action="edit" name="patientForm"
									class="form-horizontal" onSubmit="return doSave();">
									<input type="hidden" name="medicalConditionId"
										value="${medicalCondition?.id}">
									<h4 class="blue-text">Edit Medical Condition</h4>
									<div class="clearfix">&nbsp;&nbsp;</div>
									<g:if test="${flash.msg}">
								<h6 class="red-text">
									${flash.msg}
								</h6>
							</g:if>
							<div id="err"></div>
									<div class="control-group">
										<label class="control-label"><b>Medical condition</b></label>
										<div class="controls">

											<input type="text" class="form-control"
												name="medicalConditionType"
												value="${medicalCondition?.medicalConditionType}"
												id="medicalCondition" required=""
												placeholder="Enter MedicalCondition">
										</div>
									</div>
									<div class="control-group">
										<label class="control-label"><b>Status</b></label>
										<div class="controls">
											<g:radio name="status" value="active"
												checked="${medicalCondition?.isActive==1}" />
											Active
											<g:radio name="status" value="inactive"
												checked="${medicalCondition?.isActive==0}" />
											InActive
										</div>
									</div>
									<div class="control-group">
										<div class="controls">
											<input type="submit" value="Update" 
												class="btn btn-info" />
											&nbsp;&nbsp;
											<g:actionSubmit value="Cancel" action="cancel"
												class="btn btn-info" />
										</div>
									</div>

								</g:form>
							
						</div>
					</div>
				</div>
			</div>
		</div>



	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
	<script type="text/javascript"
		src="${resource(dir:'js/active/admin',file:'bloodDonor.js')}"></script>
	<script type="text/javascript"
		src="${resource(dir:'js/autoLogout',file:'logout.js')}"></script>
	<script type="text/javascript" src="../js/tablesort/sorttable.js"></script>
</body>
</html>
