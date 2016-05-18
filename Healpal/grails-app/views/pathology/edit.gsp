

<!DOCTYPE html>
<html lang="en">
<head>
<meta name="layout" content="admin">
</head>
<body>
<div id="forms_page" class="main_container glass">
		<div class="row-fluid title blue-topstripe">
			<h1>
				Edit Pathology
				<small> <g:link controller="dashboard" action="adminDashboard">Home </g:link><i class="icon-angle-double-right"></i> Edit Pathology</small>
			</h1>
		</div>
		
		<div class="group">
			<div class="row-fluid">
				<div class="widget widget-padding box span12">

					<div class="widget-body pad25" style="height: auto;">
						<div class="widget-forms clearfix">
						
								
								
                       
							<g:form controller="pathology" action="edit" class="form-horizontal" onSubmit="return doSave();">
								<input type="hidden" name="pathologyId" value="${patho?.id}">
								<h4 class="blue-text">
									Edit Pathology
								</h4>
								<div class="clearfix">&nbsp;&nbsp;</div>
								<g:if test="${flash.msg}">
						<h6 class="red-text">
									${flash.msg}
								</h6>
								</g:if>
								<div id="err"></div>
								<div class="control-group">
										<label class="control-label"><b>TumorType</b></label>
										<div class="controls">
											<input type="text" class="form-control" name="TumorTypes" value="${patho?.tumorTypeName}" id="TumorTypes" required="" placeholder="Enter Tumor Type">
										</div>
										<label class="control-label"><b>Status:</b></label>
                                 	  <div class="controls">
									    <g:radio name="status" value="active"
										checked="${patho?.isActive==1}" />Active <g:radio
										name="status" value="inactive"
										checked="${patho?.isActive==0}" />InActive
								 	        </div>
										
										</div>
										<div class="control-group">
										<div class="controls">
											<input type="submit"	value="Update" class="btn btn-info" />&nbsp;&nbsp;
											<g:link action="cancel" class="btn btn-info">Cancel</g:link>
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