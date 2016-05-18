<!DOCTYPE html>
<html lang="en">
<head>
<meta name="layout" content="admin">
</head>
<body>
<div id="forms_page" class="main_container glass">
		<div class="row-fluid title blue-topstripe">
			<h1>
				Edit Molecular Testing
				<small> <g:link controller="dashboard" action="adminDashboard">Home </g:link><i class="icon-angle-double-right"></i> Edit Molecular Testing</small>
			</h1>
		</div>
		
		<div class="group">
			<div class="row-fluid">
				<div class="widget widget-padding box span12">

					<div class="widget-body pad25" style="height: auto;">
						<div class="widget-forms clearfix">
						
							
							<g:form controller="MolecularTesting" action="edit" method="post"
								class="form-horizontal" onSubmit="return doSave();">
								<input type="hidden" name="molecularId" value="${Molecular?.id}">
								<h4 class="blue-text">
									Edit Molecular Testing
								</h4>
								<div class="clearfix">&nbsp;&nbsp;</div>
								<g:if test="${flash.msg}">
						<h6 class="red-text">
									${flash.msg}
								</h6>
								</g:if>
								<div id="err"></div>
								<div class="control-group">
										<label class="control-label"><b>Molecular Testing</b></label>
										<div class="controls">
										<input type="text" class="span7" name="molecularCancerName" value="${Molecular?.molecularForCancerName}" id="molecularForCancerName" required="" placeholder="Enter MolecularForCancer Name">
											
												<%--<h6><span class="red-text" id="donorNameError"></span></h6>
										--%></div>
										<label class="control-label"><b>Status:</b></label>
                                 	  <div class="controls">
									    <g:radio name="status" value="active"
										checked="${Molecular?.isActive==1}" />Active <g:radio
										name="status" value="inactive"
										checked="${Molecular?.isActive==0}" />InActive
								 	        </div>
										</div>
										<div class="control-group">
										   <div class="controls">
											<input type="submit" value="Update" class="btn btn-info" />&nbsp;&nbsp;
											<g:link	 action="cancel" class="btn btn-info">Cancel</g:link>
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
            