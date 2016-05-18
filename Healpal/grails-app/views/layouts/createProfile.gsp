<!DOCTYPE html>
<html lang="en">
<%@page import="com.healpal.care.DashboardService"%>
<%@page import="com.healpal.care.DashboardController"%>
<head>
    <meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
	<meta name="apple-mobile-web-app-capable" content="yes"/>
    <title> ::.. Healpal | Home ..:: </title>
    <script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
    <!-- Bootstrap Core CSS -->
    
    <link href="../assets/profile/css/bootstrap.min.css" rel="stylesheet" type="text/css"><%--
    <link href="../assets/profile/css/colorbox.css" rel="stylesheet" type="text/css">
	--%><!-- Custom CSS -->
    <link href="../assets/profile/css/style.css" rel="stylesheet" type="text/css">
    <!-- Custom Fonts -->
    <link href="../assets/profile/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="../../oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="../../oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    
    
    <link href="${resource(dir:'css',file:'drag-file.css')}" rel="stylesheet">	

<%--<link href="${resource(dir:'assets/bootstrap/css',file:'bootstrap.css')}" rel="stylesheet">
--%><link href="${resource(dir:'assets/css/datepicker',file:'datepicker.css')}" rel="stylesheet">
    
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
	color: #1b1b1b !important;
}

.monthactive {
	background-color: #a0d271 !important;
	color: white  !important;
}
/* for file upload
/*#upload_file {
	float: left;
	display: inline-block;
	width: 188px;
	color: transparent;
}*/
#upload_file {
font-family: "Opensans regular",sans-serif;
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
#err_field {
	position: absolute;
	top: 52px;
	font-size: large;
	color: #f07182;
	left: 254px;
}
</style>
    
</head>
<body>
	<div class="profile-bg">
		<header class="profile-header" id="home-index"><!-- header start here-->
			<div class="container container-950">
				<div class="row">
					<div class="col-sm-8 profile-logo">
						<g:link controller="home" home="index" class="logo">
							<img class="img-responsive" src="../assets/profile/img/logo.png">
						</g:link>
					</div>
					
					<div class="pull-right">
					
					<nav id="colorNavIndex">
												<ul>
													<li><a href="#">
															<div class="welcome-text -icon-home">
																Hi!  <g:getUserName user="${session?.user}"/> <g:set var="photo" value="${DashboardService.getPhoto(session.user)}"/>
									<g:if test="${photo}">
					<img class="img-responsive" src="${resource(dir:'assets/patient-photo',file:photo)}" width="50px;" style="border-radius: 41px; height:41px;"></g:if>
					<g:else>
											<img class="img-responsive"
												src="${resource(dir:'assets/patient-photo',file:'noimage.jpg')}" width="50px;" style="border-radius: 41px; height:41px;">
										</g:else>
																</div>
									</a>
														<ul  style="left:-18%; top:61px;" class="list_ul message-dropdown profile-drop msg-popup profileLayout-drop message-proflie-dropdown">
															<li class="message-dropdown-tit"><a href="#">Account
																	& Settings</a></li>
															<li><div class="left_div">
																	<g:if test="${photo}">
																		<i class="drop-prof-img"><img class="logo-icon"
																			src="${resource(dir:'assets/patient-photo',file:photo)}"></i>
																	</g:if>
																	<g:else>
																		<i class="drop-prof-img"><img class="logo-icon"
																			src="${resource(dir:'assets/patient-photo',file:'noimage.jpg')}"></i>
																	</g:else>
																	 <g:getUserName user="${session?.user}"/>
																</div>
																<div class="right_div">
																	<g:link controller="Auth" action="doLogout">
																		<span style="color: red;">Sign Out</span>
																	</g:link>
																</div></li>
															<li><div class="left_div">
																	<i class="fa fa-user"></i>Profile
																</div>
																<div class="right_div"><g:getPercentage user="${session.user}"/>
																</div></li>
															<%--<li><div class="left_div">
																	<i class="dashboard-icon"></i>Dashboard
																</div>
																<div class="right_div">
																	<g:link controller="dashboard" action="view">
																		<span style="color: red;">Go</span>
																	</g:link>
																</div></li>
															--%><!-- More dropdown options -->
														</ul></li></ul></nav>

																		</div>		
				
			
		
					
					
					
					<%--<div class="col-sm-4 pull-right"><div class="welcome-text pull-right">Welcome  <g:getUserName user="${session?.user}"/>
					<g:set var="photo" value="${DashboardService.getPhoto(session.user)}"/>
									<g:if test="${photo}">
					<img class="img-responsive" src="${resource(dir:'assets/patient-photo',file:photo)}" width="50px;"></g:if>
					<g:else>
											<img class="img-responsive"
												src="${resource(dir:'assets/patient-photo',file:'noimage.jpg')}" width="50px;">
										</g:else>
					</div></div>
					
				--%></div>
			</div>
		</header>
		<g:layoutBody />
		
				
				</div>
			
</body>
</html>