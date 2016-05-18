<%--/**
 *
 * Author  		: Ramesh
 * Project 		: Healpal
 * Date    		: 09/02/2016 
 * Description	: Share Your Story Edit
 *
 * #      Name         Version   Modified-Date      Description
 * -------------------------------------------------------------------------------------
 * 1   Ramesh      1.0        09/02/2016     Initial Creation
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
				Edit Get Answers <small> <g:link controller="dashboard" action="adminDashboard">Home </g:link><i class="icon-angle-double-right"></i> Edit Get Answer</small>
			</h1>
		</div>
		<div class="group">
			<div class="row-fluid">
				<div class="widget widget-padding box span12">
					<div class="widget-body pad25" style="height: auto;">
						<div class="widget-forms clearfix">
								<g:form controller="GetAnswers" action="edit" method="post" class="form-horizontal">
									<input type="hidden" name="getAnswerID" value="${getAnswerID}">
									<h4 class="blue-text">Edit Get Answers</h4>
									<g:if test="${flash.msg}">
										<h6 class="red-text">${flash.msg}</h6>
									</g:if>
									<div id="err"></div>
									<%--<div class="control-group">
										<label class="control-label"><b>Name${getAnswerID}</b></label>
										<div class="controls">
											<input type="text" class="span7" name="patientName"
												id="getAnswersPatientName" required=""
												placeholder="Enter Name"
												value="${getAnswers?.patientFk?.person?.fullName}">
												
										</div>
									</div>
									--%><div class="control-group">
										<label class="control-label"><b>Question</b></label>
										<div class="controls">
											<input type="text" class="span7" name="yourQuestion"
												id="yourQuestion" readonly="true"
												placeholder="Enter Your Question"
												value="${getAnswers?.yourQuestion}">
												
										</div>
									</div>
									
									
									<div class="control-group">
										<label class="control-label"><b>Answers</b></label>
										<div class="controls">
											<textarea class="span7" name="answers"
												id="answers" required=""
												placeholder="Enter Your Answers"
												>${getAnswers?.answers}</textarea>
										</div>
									</div>
									
									
									<%--<div class="control-group">
										<label class="control-label"><b>Status</b></label>
										<div class="controls">
											<g:radio name="status" value="active" checked="${getAnswers?.isActive==1}" />
											Active
											<g:radio name="status" value="inactive" checked="${getAnswers?.isActive==0}" />
											InActive
										</div>
									</div>
									--%><div class="control-group">
										<div class="controls">
											<input type="submit" value="Update" class="btn btn-info" />&nbsp;&nbsp;
											<g:link controller="getAnswers" action="cancel" class="btn btn-info">Cancel</g:link>
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
