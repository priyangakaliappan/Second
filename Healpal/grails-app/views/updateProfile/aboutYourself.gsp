<%--<link href="../assets/profile/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="../assets/profile/css/colorbox.css" rel="stylesheet" type="text/css">
	<!-- Custom CSS -->
    <link href="../assets/profile/css/style.css" rel="stylesheet" type="text/css">
    <!-- Custom Fonts -->
    <link href="../assets/profile/css/font-awesome.min.css" rel="stylesheet" type="text/css">
--%><div class="col-sm-12">
						<div class="profile-box-bg general-text">
							<div class="text-center">
								<div class="icon-box-top"><img src="../assets/profile/img/user-icon1.jpg" /></div>
								<div class="mar-bot-20"></div>
								<g:form controller="updateProfile" action="aboutYourself"
				name="aboutYou">
								<div class="col-md-12 col-xs-12 center-align m-pad-lr pad-lr-0">
									<textarea class="textarea" name="aboutYourself" id="aboutYourself"
							maxlength="255" placeholder="Write few lines about  yourself">${describe}</textarea>
									<input type="text" class="textbox" name="passionate"
							id="passionate" maxlength="100"
							placeholder="The one thing I am most passionate about" value="${passion }">
									<g:submitButton  class="blue-btn" name="save and Continue" id="aboutyou"/>
								</div>
								<div class="clearfix"></div>
								</g:form>
							</div>
							</div>
						</div>

	<script src="../js/profile/profile.js"></script>