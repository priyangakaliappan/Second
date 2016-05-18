
<!DOCTYPE html>
<html lang="en">
<head>
<meta name="layout" content="admin">
</head>
<body>
<div id="forms_page" class="main_container glass">
		<div class="row-fluid title blue-topstripe">
			<h1>
				Add Cancer Stage
				<small> <g:link controller="dashboard" action="adminDashboard">Home </g:link>
					<i class="icon-angle-double-right"></i> Add Cancer Stage</small>
			</h1>
		</div>
		
		<div class="group">
			<div class="row-fluid">
				<div class="widget widget-padding box span12">

					<div class="widget-body pad25" style="height: auto;">
						<div class="widget-forms clearfix">
						
								
							<g:form class="form-horizontal" controller="CancerStage" onSubmit="return doSave();">
								<h4 class="blue-text" >
									Add Cancer Stage
								</h4>
								<div class="clearfix">&nbsp;&nbsp;</div>
								<g:if test="${flash.msg}">
						<h6 class="red-text">
									${flash.msg}
								</h6>
								</g:if>
								<div id="err"></div>
								<div class="control-group">
										<label class="control-label"><b>Cancer Stage</b></label>
										<div class="controls">
										
											<input type="text"  class="span7" name="cancerStage" id="cancerStage" required="" placeholder="Enter cancer stage" value="" >
												<%--<h6><span class="red-text" id="donorNameError"></span></h6>
										--%></div>
										</div>
										<div class="control-group">
										<div class="controls">
											<g:actionSubmit	value="Save" action="create"class="btn btn-info" />&nbsp;&nbsp;
											<g:link	controller="cancerStage" action="cancel" class="btn btn-info">Cancel</g:link>
										</div>
										</div>
										
										</g:form>
									</div></div></div></div></div>
		
		</div>
</body>
</html>
