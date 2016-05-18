<%--<link href="../assets/profile/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="../assets/profile/css/colorbox.css" rel="stylesheet" type="text/css">
	<!-- Custom CSS -->
    <link href="../assets/profile/css/style.css" rel="stylesheet" type="text/css">
    <!-- Custom Fonts -->
    <link href="../assets/profile/css/font-awesome.min.css" rel="stylesheet" type="text/css">--%>
<div class="col-sm-12">
						<div class="profile-box-bg pad-top-0 gender-img">
							<div class="text-center">
								<h1>Gender</h1>
								<div class="col-md-12 col-xs-12 center-align">
									<div class="col-xs-6 m-pad-lr">
										<g:link controller="updateProfile" action="myGender" class="p-blue-text" params="[genderType:'Male']"><g:if test="${value == 'Male'}">
							<img src="../assets/profile/img/male-img.jpg"
								class="img-border">
						</g:if>
						<g:else>
							<img src="../assets/profile/img/male-img.jpg">
						</g:else><br />Male</g:link>
									</div>
									<div class="col-xs-6 m-pad-lr">
										<g:link controller="updateProfile" action="myGender" class="p-pink-text" params="[genderType:'Female']"><g:if test="${value == 'Female'}">
							<img src="../assets/profile/img/female-img.jpg"
								class="img-border">
						</g:if>
						<g:else>
							<img src="../assets/profile/img/female-img.jpg">
						</g:else><br />Female</g:link>
									</div>
								</div>
								<div class="clearfix mar-bot-20"></div>
							</div>
							</div>
							</div>
