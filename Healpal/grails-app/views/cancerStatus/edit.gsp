<%--/**
 *
 * Author  		: Subhapriya
 * Project 		: Healpal
 * Description	: cancerStatusEdit
 *
 * #      Name         Version   Modified-Date      Description
 * -------------------------------------------------------------------------------------
 * 1   Subhapriya  		1.0        			       Initial Creation
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
				Edit Cancer Status
				<small> <g:link controller="dashboard" action="adminDashboard">Home </g:link><i class="icon-angle-double-right"></i> Edit Cancer Status</small>
			</h1>
		</div>
		
		<div class="group">
			<div class="row-fluid">
				<div class="widget widget-padding box span12">

					<div class="widget-body pad25" style="height: auto;">
						<div class="widget-forms clearfix">
						
								
								<g:form controller="CancerStatus" action="edit" method="post" onSubmit="return doSave();">
							<%--<g:formRemote name="signupForm" url="[controller: 'CancerStatus', action: 'update']" update="updateResult" class="form-horizontal" id="patient_login_form">
								--%><input type="hidden" name="statusId" value="${cancerStatus?.id}">
								<h4 class="blue-text">
									Edit Cancer Status
								</h4>
								<div class="clearfix">&nbsp;&nbsp;</div>
								<g:if test="${flash.msg}">
						<h6 class="red-text">
									${flash.msg}
								</h6>
								</g:if>
								<div id="err"></div>
								<div class="control-group">
										<label class="control-label"><b>CancerStatus Type</b></label>
										<div class="controls">
											<input type="text"  class="span7" name="cancerStatus" id="cancerStatus" required="" placeholder="Enter Cancer Status Type" value="${cancerStatus?.cancerStatusType}" >
										</div>
										</div>
										<div class="control-group">
       									<label class="control-label"><b>Status</b></label>
      									 <div class="controls">      
											<g:radio name="status" value="active" checked="${cancerStatus?.isActive==1}" />Active       
											<g:radio name="status" value="inactive" checked="${cancerStatus?.isActive==0}" />InActive      
												</div>      
												</div>
										<div class="control-group">
										<div class="controls">
											<%--<actionSubmit class="btn btn-info" action="update" >Update&nbsp;&nbsp;
											--%><input type="submit" value="Update"  class="btn btn-info"/>&nbsp;&nbsp;
											<g:link controller="CancerStatus" action="cancel" class="btn btn-info">Cancel</g:link>
										</div>
										</div>
										<div id="updateResult"></div>
										</g:form>
										
									</div></div></div></div></div>
		
		
		
		</div>
</body>
</html>
