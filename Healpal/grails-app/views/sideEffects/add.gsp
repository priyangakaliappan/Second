<%--
 *
 * Author  		: Ramesh L
 * Project 		: HealPal
 * Date    		: 10/27/2015
 * Description	: SideEffects Add
 *
 * #      Name         Version   Modified-Date      Description
 * -------------------------------------------------------------------------------------
 * 1      Ramesh L     1.0       10/27/2015      Initial Creation
 * 
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
				Add SideEffects
				<small> <g:link controller="dashboard" action="adminDashboard">Home </g:link><i class="icon-angle-double-right"></i> Add SideEffects</small>
			</h1>
		</div>
		
		<div class="group">
			<div class="row-fluid">
				<div class="widget widget-padding box span12">

					<div class="widget-body pad25" style="height: auto;">
						<div class="widget-forms clearfix">
						
							<g:form controller="SideEffects"  class="form-horizontal" onSubmit="return doSave();">
								<h4 class="blue-text">
									Add SideEffects
								</h4>
								<div class="clearfix">&nbsp;&nbsp;</div>
								<g:if test="${flash.msg}">
						<h6 class="red-text">
									${flash.msg}
								</h6>
								</g:if>
								<div id="err"></div>
								<div class="control-group">
										<label class="control-label"><b>SideEffects Type</b></label>
										<div class="controls">
										
											 <input type="text" class="form-control" name="sideEffectsType" id="sideEffectsType" required="" placeholder="Enter Side Effects Type">
												<%--<h6><span class="red-text" id="donorNameError"></span></h6>
										--%></div>
										</div>
										<div class="control-group">
										<div class="controls">
											<g:actionSubmit	value="Save" action="create"class="btn btn-info" />&nbsp;&nbsp;
											<g:link value="Cancel" action="cancel"
											class="btn btn-info">Cancel</g:link>
										</div>
										</div>
										
										</g:form>
									</div></div></div></div></div>
		
		</div>
</body>
</html>
			