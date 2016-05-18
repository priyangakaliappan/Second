<%--/**
 *
 * Author  		: Subhapriya
 * Project 		: Healpal
 * Description	: educationCreate
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
	<div id="forms_page" class="main_container glass admin-content">
		<div class="row-fluid title orange-topstripe">
			<h1>
				Send Mail 
			</h1>
			<div class="pull-right"><small> <g:link controller="dashboard"
						action="adminDashboard">Home </g:link><i
					class="icon-angle-double-right"></i> Send Mail
				</small></div>
		</div>

		<div class="group quickmail-cont">
			<div class="row-fluid">
				<div class="widget widget-padding box span12">

					<div class="widget-body" style="height: auto;">
						<div class="widget-forms clearfix">

							<g:form controller="dashboard" class="form-horizontal" method="post">
								<div class="clearfix">&nbsp;&nbsp;</div>
								<g:if test="${flash.msg}">
									<h6 class="red-text">
										${flash.msg}
									</h6>
								</g:if>
								<div id="err"></div>
								<div class="control-group">
									<label class="control-label "><strong>Subject</strong></label>
									<div class="controls">
										<input type="text" class="span7 text-box" name="subject" id="subject" placeholder="" value="">
									</div>
								</div>
								<div class="control-group">
									<label class="control-label"><strong>Body Content <span style="color:red">*</span></strong></label>
									<div class="controls">
										<textarea name="body" id="body" required="" style="width: 300px;height: 80px;"></textarea>
									</div>
								</div>
								<div class="control-group">
									<div class="controls">
										<g:actionSubmit value="Send" action="quickMail"
											class="btn btn-info  mail-orange-btn" />
										&nbsp;&nbsp;
										<g:link controller="dashboard" action="adminDashboard"
											class="btn btn-info mail-orange-btn">Cancel</g:link>
									</div>
								</div>
								<div id="createResult"></div>
							</g:form>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>
</body>
</html>
