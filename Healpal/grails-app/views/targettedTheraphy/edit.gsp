<%--
 *
 * Author  		: Ramesh L
 * Project 		: HealPal
 * Date    		: 10/27/2015
 * Description	: Targetted Terapy Edit
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
				Edit TargettedTherapy
				<small> <g:link controller="dashboard" action="adminDashboard">Home </g:link><i class="icon-angle-double-right"></i> Edit TargettedTherapy</small>
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
							<g:form controller="targettedTheraphy"name="patientForm"
								class="form-horizontal">
								<input type="hidden" name=targetedTheropyId value="${TargetedTheropy.id}">
								<h4 class="blue-text">
									Edit TargettedTherapy
								</h4>
								<div class="clearfix">&nbsp;&nbsp;</div>
								<div class="control-group">
										<label class="control-label"><b>TargetedTheropy Type</b></label>
										<div class="controls">
										
											  <input type="text" class="form-control" name="targetedTheropy" value="${TargetedTheropy.targetedTheropyName}" id="targetedTheropy" required="" placeholder="Enter Targeted Theropy">
												<%--<h6><span class="red-text" id="donorNameError"></span></h6>
										--%></div>
										</div>
										<div class="control-group">
										<div class="controls">
											<g:actionSubmit	value="Update" action="update"class="btn btn-info" />&nbsp;&nbsp;
											<g:actionSubmit	value="Cancel" action="cancel" class="btn btn-info" />
										</div>
										</div>
										
										</g:form>
									</div></div></div></div></div>
		
		
		
		</div>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
		 <script type="text/javascript" src="${resource(dir:'js/active/admin',file:'bloodDonor.js')}"></script>
    <script type="text/javascript" src="${resource(dir:'js/autoLogout',file:'logout.js')}"></script>
		<script type="text/javascript" src="../js/tablesort/sorttable.js"></script>
</body>
</html>
            