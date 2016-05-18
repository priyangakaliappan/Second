<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="layout" content="profile" />
<title>Insert title here</title>
</head>
<body>
	<div class="body">
		<div class="col-sm-12">
			<div class="profile-box-bg">
				<g:form controller="profile" action="ca12" name="treating">
					<div class="col-md-10 col-xs-12 center-align text-center">
						<div class="icon-box-top">
							<img src="../assets/icon/ca11-icon.jpg" />
						</div>
						<h1>
							Details of your treating doctor<br>
							<div class="col-md-12 col-xs-12 center-align text-center mar-top-30">
								<g:hiddenField name="doctorId" value="${treatingDoctor}" />
								<div class="col-md-6">
									<input class="textbox" id="zipcode" type="text" name="zipcode"
										placeholder="Zip code of Physician" maxlength="6"
										onKeyPress="return checkOnlyNumber(event);" />
								</div>
								<div class="col-md-6">
									<input class="textbox" id="contactNumber" type="text"
										name="contactNumber"
										onKeyPress="return checkOnlyNumber(event);"
										placeholder="Contact number of doctor" maxlength="10" />
								</div>
							</div>
						</h1>
						<div class="clearfix"></div>
						<g:submitButton class="pink-btn  mar-top-30"
							name="Save and Continue" id="saveDoctorDetails" />
					</div>
				</g:form>
				<g:link controller="Profile" action="ca11" class="back-link">
					<i class="back-arrow"></i>Back</g:link>
			</div>
		</div>
	</div>
</body>
</html>