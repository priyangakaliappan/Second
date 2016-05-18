<!DOCTYPE html>
<html lang="en">
<head>
<meta name="layout" content="admin">
</head>
<body>
<div id="forms_page" class="main_container glass">
		<div class="row-fluid title blue-topstripe">
			<h1>
				Edit AboutPassionate
				<small> <g:link controller="dashboard" action="adminDashboard">Home </g:link><i class="icon-angle-double-right"></i> Edit  AboutPassionate</small>
			</h1>
		</div>
		
		<div class="group">
			<div class="row-fluid">
				<div class="widget widget-padding box span12">

					<div class="widget-body pad25" style="height: auto;">
						<div class="widget-forms clearfix">
						
							
							
							<g:form controller="aboutPassionate"
								class="form-horizontal" action="edit" method="post" onSubmit="return doSave();">
								<input type="hidden" name="abtpassId" value="${aboutPass?.id}">
								<h4 class="blue-text">
									Edit About/Passionate
								</h4>
								<div class="clearfix">&nbsp;&nbsp;</div>
								<g:if test="${flash.msg}">
						         <h6 class="red-text">
								${flash.msg}
								</h6>
								</g:if>
								<div id="err"></div>
								
									<div class="control-group">
		<label class="control-label"><b>DescribeAboutYourself:</b></label>
		<div class="controls">
			<textarea class="span7" name="describeAboutYourself" value="${aboutPass?.describeAboutYourself}" id="aboutYour" required="" placeholder="Enter Describe About Yourself"></textarea>
		</div>
	   </div>
	  <div class="control-group">
		<label class="control-label"><b>PassionateAbout:</b></label>
		<div class="controls">
			 <textarea class="span7" name="passionateAbout" value="${aboutPass?.passionateAbout}" id="aboutYour" required="" placeholder="Enter Passionate About"></textarea>
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
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
		 <script type="text/javascript" src="${resource(dir:'js/active/admin',file:'bloodDonor.js')}"></script>
    <script type="text/javascript" src="${resource(dir:'js/autoLogout',file:'logout.js')}"></script>
		<script type="text/javascript" src="../js/tablesort/sorttable.js"></script>
</body>
</html>
            