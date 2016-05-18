<%--<link href="../assets/profile/css/bootstrap.min.css" rel="stylesheet" 
type="text/css">
    <link href="../assets/profile/css/colorbox.css" rel="stylesheet" type="text/css">
	<!-- Custom CSS -->
    <link href="../assets/profile/css/style.css" rel="stylesheet" type="text/css">
    <!-- Custom Fonts -->
    <link href="../assets/profile/css/font-awesome.min.css" rel="stylesheet" type="text/css">
--%><div class="col-sm-12">
						<div class="profile-box-bg">
						<g:form controller="profile" action="ca12" name="treating">
							<div class="col-md-10 col-xs-12 center-align  text-center m-pad-lr">
							<div class="icon-box-top"><img src="../assets/profile/img/ca11-icon.jpg" /></div>
								<h3>Details of your treating doctor </h3>
								<div class="col-md-9 col-xs-12 center-align text-center m-pad-lr"><input class="textbox text-box1 mar-top-0" type="text" id="treatingDoctor" type="text" name="treatingDoctor"  
								placeholder="Please enter your Treating Doctor Name" onKeyPress="return onlyAlphabets(event);"/></div>
								<div
								class="col-md-12 col-xs-12 center-align text-center mar-top-30">
								<g:hiddenField name="doctorId" value="${treatingDoctor}" />
								<div class="col-md-6">
									<input class="textbox text-box1" id="zipcode" type="text" name="zipcode"
										placeholder="Zip code of Physician" maxlength="5"
										onKeyPress="return checkOnlyNumber(event);" />
								</div>
								<div class="col-md-6">
									<input class="textbox text-box1" id="contactNumber" type="text"
										name="contactNumber"
										onKeyPress="return checkOnlyNumber(event);"
										placeholder="Contact number of doctor" maxlength="10" />
								</div>
							</div>
								
								<div class="clearfix"></div>
								<g:submitButton name="Save and Continue" class="blue-btn" id="saveTreatingDoctor"/>
								</div>
								<g:link action="ca10" class="back-link"><i class="back-arrow"></i>Back</g:link>
								</g:form>
							</div>
							
							</div>