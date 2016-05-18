<%--
 *
 * Author  		: Ramesh L
 * Project 		: HealPal
 * Date    		: 11/02/2015 
 * FileName 	: profile
 *
 * #      Name         Version   Modified-Date      Description
 * -------------------------------------------------------------------------------------
 * 1      Ramesh L     1.0       11/02/2015      Initial Creation
 * 
 *
 */
--%>
<!DOCTYPE html>
<%@page import="com.healpal.care.DashboardService"%>
<%@page import="com.healpal.care.DashboardController"%>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
<meta name="apple-mobile-web-app-capable" content="yes" />
 <title>  Healpal</title>
     <asset:link rel="shortcut icon" href="../assets/icon/headerLogo.ico" type="image/x-icon"/>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
<!-- Bootstrap Core CSS -->
<%--<link href="../assets/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    
    --%>
<link
	href="${resource(dir:'assets/bootstrap/css',file:'bootstrap.min.css')}"
	rel="stylesheet">
<%--
    <link href="../assets/css/colorbox.css" rel="stylesheet" type="text/css">
    
    --%>
<link href="${resource(dir:'assets/css',file:'new-style.css')}"
	rel="stylesheet">

	<link href="${resource(dir:'css',file:'style.css')}" rel="stylesheet" type="text/css">
<!-- Custom CSS -->
<%--
    <link href="../assets/css/new-style.css" rel="stylesheet" type="text/css">
    --%>
<!-- Custom Fonts -->
<%--<link href="../assets/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    --%>
<link href="${resource(dir:'assets/css/',file:'font-awesome.min.css')}"
	rel="stylesheet">
<link href="${resource(dir:'css',file:'drag-file.css')}" rel="stylesheet">	

<link href="${resource(dir:'assets/bootstrap/css',file:'bootstrap.css')}" rel="stylesheet">
<link href="${resource(dir:'assets/css/datepicker',file:'datepicker.css')}" rel="stylesheet">

<link href="http://fonts.googleapis.com/css?family=Ubuntu" rel="stylesheet"/>
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="../../oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="../../oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
<%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
     --%><script type="text/javascript" src="${resource(dir:'assets/js/forgot',file:'jquery.ziptastic.js')}"></script>
     <script type="text/javascript" src="${resource(dir:'assets/js/forgot',file:'ziptastic.js')}"></script>
<script src="../assets/js/jquery-1.11.1.js"></script>
<script src="../js/profile/profile.js"></script>
<script src="../assets/js/logout.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/mootools/1.3.2/mootools.js"></script>
<script src="../js/profile/Request.File.js"></script>
<script src="../js/profile/Form.MultipleFileInput.js"></script>
<script src="../js/profile/Form.Upload.js"></script>
	

<style>
/*for checkbox highlighted*/
.checkboxSelect {
	position: absolute;
	left: -9999px;
}
/*.checkboxSelect:checked + label {
  		background-color: lime;
  		color: black
	}*/
.highLight {
	background-color: white !important;
	color: #5b5b5b !important;
}

.monthactive {
	background-color: #a0d271 !important;
	color: white  !important;
}
/* for file upload*/
#upload_file {
	float: left;
	display: inline-block;
	width: 188px;
	color: transparent;
}
#fileLabel {
	display: inline-block;
	position: inherit;
	margin-left: -390px;
}
#file_div {
	background: white;
	border: 1px solid white;
	border-radius: 3px;
	font-size: 24px;
}
.uploadItem a {
	float: left;
	display: block;
	background-image: url("../assets/image/delete.png");
}
a.delInputRow {
	background-image: url("../assets/image/delete.png");
}
</style>
</head>
<body>
	<div class="profile-bg">
		<header class="profile-header" id="home-index">
			<!-- header start here-->
			<div class="container">
				<div class="row">
					<div class="col-sm-8 logo">
						<g:link controller="home" home="index" class="logo">
							<img class="img-responsive" src="../assets/image/logo.png">
						</g:link>
						<%--<div class="col-sm-3 col-xs-15 pull-right text-right">
						<g:link controller="Auth" action="doLogout" class="view-profile-btn" >Sign Out</g:link>
						</div>
						--%>
					</div>
					<div class="col-sm-4 col-xs-15">
						<div class="pull-right text-right">
						<g:if test="${session.user}">
							<nav id="colorNav">
								<ul>
									<li>
									<a href="#"><div class="welcome-text -icon-home">Hi! <g:getUserName user="${session?.user}"/>
									<g:set var="photo" value="${DashboardService.getPhoto(session.user)}"/>
									<g:if test="${photo}">
									<img class="img-responsive" src="${resource(dir:'assets/patient-photo',file:photo)}"></g:if>
									<g:else>
									<img class="img-responsive" src="${resource(dir:'assets/patient-photo',file:'noimage.jpg')}">
									</g:else></div></a>

								<ul class="list_ul message-dropdown profile-drop">
									<li class="message-dropdown-tit"><a href="#">Account & Settings</a></li>
									<li><div class="left_div">
											<g:if test="${photo}">
												<i class="drop-prof-img"><img class="logo-icon"
													src="${resource(dir:'assets/patient-photo',file:photo)}"></i>
											</g:if>
											<g:else>
												<i class="drop-prof-img"><img class="logo-icon"
													src="${resource(dir:'assets/patient-photo',file:'noimage.jpg')}"></i>
											</g:else>
											${session?.user?.person?.fullName?.capitalize()}
										</div> 
											<div class="right_div"><g:link controller="Auth" action="doLogout">
												<span style="color: red;">Sign Out</span>
											</g:link></div>
										</li>
										
											<li><div class="left_div">
												<i class="dashboard-icon"></i>Dashboard
											</div>
											<div class="right_div">
												<g:link controller="dashboard" action="view">
													<span style="color: red;">Go</span>
												</g:link>
											</div></li>
									<!-- More dropdown options -->
								</ul></li>
							<!-- More menu items -->
						</ul>
					</nav>
						</g:if>
						</div>
					</div>
				</div>
			</div>
		</header>
		<section>
			<div class="container">
				<div class="row">
					<g:layoutBody />
				</div>
			</div>
		</section>
	</div>
</body>
</html>









