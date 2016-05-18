<!DOCTYPE html>
<html lang="en">
<%@page import="com.healpal.care.DashboardService"%>
<%@page import="com.healpal.care.DashboardController"%>
<head>
    <meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
	<meta name="apple-mobile-web-app-capable" content="yes"/>
	<meta name = "format-detection" content = "telephone=no">
    <meta name="description" content="">
    <meta name="author" content="Mian Zaid Bin Khalid">
    <title> ::.. Healpal | Home ..:: </title>
    <!-- Bootstrap Core CSS -->
    <link href="../assets/profile/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="../assets/profile/css/colorbox.css" rel="stylesheet" type="text/css">
	<!-- Custom CSS -->
    <link href="../assets/profile/css/style.css" rel="stylesheet" type="text/css">
    <!-- Custom Fonts -->
     <link href="../assets/profile/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="../../oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="../../oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="profile-wrapper">
	<img src="../assets/profile/img/l3.jpg" alt="image" align="middle">
	<div class="profile-black-bg">
		<header class="profile-header" id="home-index"><!-- header start here-->
			<div class="container">
				<div class="row">
					<div class="col-sm-12 col-md-10 logo">
						<g:link controller="home" home="index" class="logo">
							<img class="img-responsive" src="../assets/profile/img/logo.png" alt="logo"></g:link>		
					</div>
					<div class="pull-right col-md-2">
					
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
														<ul class="list_ul message-dropdown profile-drop msg-popup profileLayout-drop msg-drop">
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
															<!-- More dropdown options -->
														</ul></li></ul></nav>
																		</div>
				</div>
			</div>
		</header>
		<section>
			<div class="container">
				<div class="row">
					<div class="col-md-10 col-xs-12 center-align text-center">
						<div class="profile-black-pad">
							<h1>Congratulations!</h1>
							<p class="pad-bot-0">Your profile is 100 percent complete.</p>
							<p>However, there is ONE LAST VERY IMPORTANT STEP.</p>
							<div class="clearfix mar-bot-20"></div>
							<div class="white-bor-box">
								<div class="pink-box col-sm-12 pad-lt-0">
									<div class="text-center">100%</div>
								</div>
								<div class="clearfix"></div>
							</div>
							<div class="clearfix mar-top-10"></div>
							<div class="col-sm-3"></div>
							<div class="col-sm-6 text-center"><g:link controller="dashboard" action="view" class="blue-btn">Continue</g:link></div>
							<div class="col-sm-3"></div>
							<div class="clearfix mar-bot-10"></div>
						</div>
					</div>
				</div>
			</div>
		</section>
		<div class="clearfix"></div>
	</div>
</div>
</body>
</html>


