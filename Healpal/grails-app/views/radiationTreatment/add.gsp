<%--
 *
 * Author  		: Ramesh L
 * Project 		: Healpal
 * Date    		: 10/28/2015
 * Description	: RadiationTreatment Add
 *
 * #      Name         Version   Modified-Date      Description
 * -------------------------------------------------------------------------------------
 * 1     Ramesh L        1.0        10/28/2015       Initial Creation
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
				Add RadiationTreatment
				<small> <g:link controller="dashboard" action="adminDashboard">Home </g:link><i class="icon-angle-double-right"></i> Add RadiationTreatment</small>
			</h1>
		</div>
		
		<div class="group">
			<div class="row-fluid">
				<div class="widget widget-padding box span12">

					<div class="widget-body pad25" style="height: auto;">
						<div class="widget-forms clearfix">
						<g:if test="${flash.msg}">
						<h6 class="red-text">
									${flash.msg}
								</h6>
								</g:if>
							<g:form controller="RadiationTreatment"  class="form-horizontal">
								<h4 class="blue-text">
									Add RadiationTreatment
								</h4>
								<div class="clearfix">&nbsp;&nbsp;</div>
								<div class="control-group">
										<label class="control-label"><b>RadiationTreatment Type</b></label>
										<div class="controls">
										
											<input type="text"  class="span7" name="radiationTreatmentType" id="radiationTreatmentType" required="" placeholder="Enter RadiationTreatmentType" >
												<%--<h6><span class="red-text" id="donorNameError"></span></h6>
										--%></div>
										</div>
										<div class="control-group">
										<div class="controls">
											<g:actionSubmit	value="Save" action="create"class="btn btn-info" />&nbsp;&nbsp;
											<g:link	value="Cancel" action="cancel" class="btn btn-info">Cancel</g:link>
										</div>
										</div>
										
										</g:form>
									</div></div></div></div></div>
		
		</div>
</body>
</html>
			