<%--/**
 *
 * Author  		: Subhapriya
 * Project 		: Healpal
 * Description	: surgeryEdit
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
				Edit Surgery
				<small> <g:link controller="dashboard" action="adminDashboard">Home </g:link><i class="icon-angle-double-right"></i> Edit Surgery</small>
			</h1>
		</div>
		
		<div class="group">
			<div class="row-fluid">
				<div class="widget widget-padding box span12">

					<div class="widget-body pad25" style="height: auto;">
						<div class="widget-forms clearfix">
						
								
							<%--<g:formRemote name="signupForm" url="[controller: 'Surgery', action: 'update']" update="updateForm" class="form-horizontal">
								--%>
								<g:form controller="Surgery" action="edit" method="post" class="form-horizontal" onSubmit="return doSave();">
								
								<input type="hidden" name="surgeryId" value="${surgery?.id}">
								<h4 class="blue-text">
									Edit Surgery
								</h4>
								<div class="clearfix">&nbsp;&nbsp;</div>
								<g:if test="${flash.msg}">
						<h6 class="red-text">
									${flash.msg}
								</h6>
								</g:if>
								<div id="err"></div>
								<div class="control-group">
										<label class="control-label"><b>Surgery Type</b></label>
										<div class="controls">
											<input type="text"  class="span7" name="surgerytype" id="surgerytype" required="" placeholder="Enter Surgery Type" value="${surgery?.surgeryType}" >
										</div>
										</div>
										<div class="control-group">
       									<label class="control-label"><b>Status</b></label>
      									 <div class="controls">      
											<g:radio name="status" value="active" checked="${surgery?.isActive==1}" />Active       
											<g:radio name="status" value="inactive" checked="${surgery?.isActive==0}" />InActive      
												</div>      
												</div>
										<div class="control-group">
										<div class="controls">
											<input type="submit"	value="Update" class="btn btn-info" />&nbsp;&nbsp;
											<g:link controller="Surgery" action="cancel" class="btn btn-info">Cancel</g:link>
										</div>
										</div>
										
										</g:form>
										
									</div></div></div></div></div>
		
		
		
		</div>
</body>
</html>
