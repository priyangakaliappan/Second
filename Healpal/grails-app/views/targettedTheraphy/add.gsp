<%--
 *
 * Author  		: Ramesh L
 * Project 		: HealPal
 * Date    		: 10/27/2015
 * Description	: Targetted Terapy Add
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
				Add TargettedTherapy
				<small> <g:link controller="dashboard" action="adminDashboard">Home </g:link><i class="icon-angle-double-right"></i> Add TargettedTherapy</small>
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
							<g:form controller="targettedTheraphy"  class="form-horizontal">
								<h4 class="blue-text">
									Add TargettedTherapy
								</h4>
								<div class="clearfix">&nbsp;&nbsp;</div>
								<div class="control-group">
										<label class="control-label"><b>TargettedTherapy Type</b></label>
										<div class="controls">
										
											<input type="text" class="form-control" name="targetedTheropy" id="targetedTheropy" required="" placeholder="Enter Targetted Terapy">
												<%--<h6><span class="red-text" id="donorNameError"></span></h6>
										--%></div>
										</div>
										<div class="control-group">
										<div class="controls">
											<g:actionSubmit	value="Save" action="create"class="btn btn-info" />&nbsp;&nbsp;
											<g:link action="cancel" class="btn btn-info">Cancel</g:link>
										</div>
										</div>
										
										</g:form>
									</div></div></div></div></div>
		
		</div>
</body>
</html>                                     