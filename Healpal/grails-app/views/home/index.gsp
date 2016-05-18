<!DOCTYPE html>
<%@page import="com.healpal.care.DashboardService"%>
<html lang="en">

<head>
    <meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
	<meta name="apple-mobile-web-app-capable" content="yes"/>
	<title> ::.. Healpal | Home ..:: </title>
      <asset:link rel="shortcut icon" href="../assets/icon/headerLogo.ico" type="image/x-icon"/>
    <!-- Bootstrap Core CSS -->
    <link href="assets/new-design/css/bootstrap.min.css" rel="stylesheet" type="text/css">
	<!-- Custom CSS -->
    <link href="assets/new-design/css/style.css" rel="stylesheet" type="text/css">
    
    <link href="css/style.css" rel="stylesheet" type="text/css">
    <!-- Custom Fonts -->
    <link href="assets/new-design/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="../../oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="../../oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <style type="text/css">
    
    #res.alert, #Err.alert { margin: 10px 0px 0px; font-size: 12px; width: 100%; } 
    
    
    </style>
</head>
<body>
	<header class="header" id="home-index"><!-- header Start here-->
		<div class="container container-header pad-lt-0">
			<div class="col-lg-3 col-md-3 col-sm-7 col-xs-6 logo header-width">
				<g:link controller="home" action="index" class="logo">
					<img class="img-responsive" src="assets/new-design/img/logo.png">
				</g:link>
			</div>
			
				<nav class="navbar navbar-default">
					<!-- Brand and toggle get grouped for better mobile display -->
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#home-nav">
							<span class="sr-only">Toggle navigation</span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>
					</div>
					<div class="collapse navbar-collapse" id="home-nav">
					<div class="col-lg-9 col-md-5  col-xs-6 pad-rt-0 header-part-width t-pad-lr">
					<!-- Collect the nav links, forms, and other content for toggling -->
					
						<ul class="nav navbar-nav">
							<li class="${learn?:''}"> <g:link controller="home" action="learn" >Learn</g:link> </li>
							<li class="${match?:''}"> <g:link controller="home" action="match" >Match</g:link> </li>
							<li class="${connect?:''}"> <g:link controller="home" action="connect" >Connect</g:link></li>
							<li class="${writeAReview?:'' }"> <g:link controller="home" action="writeAReview" >Write a review</g:link></li>
							<li class="${findreview?:''}"> <g:link controller="home" action="findReview" >Find reviews</g:link></li>
							<g:if test="${session.user}"><g:set var="signClass" value="header-rightside"></g:set></g:if>
							<g:else><g:set var="signClass" value="pull-right"></g:set></g:else>
							<li class="<%=signClass%> header-signin-bar ">
								<div class="pull-right">
								 <g:link controller="home" action="fordoctor" class="btn btn-default btn-lg btn-mar">For Doctors</g:link>
								 <g:if test="${!session.user}">
									<a href="#" data-toggle="modal" data-target="#join" class="btn btn-default btn-lg header-orange-btn">Join</a>
									</g:if>
									<g:if test="${session.user}">
										<li class="logged-menu"><nav id="colorNavIndex">
												<ul>
													<li><a href="#">
															<div class="welcome-text -icon-home">
																Hi! <g:getUserName user="${session?.user}"/>
																
															<!-- 	<g:set var="photo"
																	value="${DashboardService.getPhoto(session.user)}" />
																<g:if test="${photo}">
																	<img class="img-responsive"
																		src="${resource(dir:'assets/patient-photo',file:photo)}">
																</g:if>
																<g:else>
																	<img class="img-responsive"
																		src="${resource(dir:'assets/patient-photo',file:'noimage.jpg')}">
																</g:else> -->
																</div>
									</a>
														<ul class="list_ul message-dropdown profile-drop msg-popup">
															<li class="message-dropdown-tit"><a href="#">Account
																	& Settings</a></li>
															<li><div class="left_div">
																	<g:if test="${photo}">
																		<i class="drop-prof-img"><img class="img-responsive"
																			src="${resource(dir:'assets/patient-photo',file:photo)}"></i>
																	</g:if>
																	<g:else>
																		<i class="drop-prof-img"><img class="img-responsive"
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
											</nav></li>
									</g:if>
									<g:else>

										<a class="signin-text" href="#" data-toggle="modal" data-target="#signin">Sign in</a>	
									</g:else>
									
									
									
								</div>
							</li>
					
					
						</ul>
						
						
						
					</div>
					
					</div>
				</nav>
			
		</div>
	</header><!-- header end here-->
	<div class="fixed-header"></div>
	
	<!-- Banner Start here-->
	<section id="banner">
		<div class="carousel fade-carousel slide" data-ride="carousel" data-interval="4000" id="bs-carousel">
			   <!-- Indicators --><%--
			  <ol class="carousel-indicators">
				<li data-target="#bs-carousel" data-slide-to="0" class="active"></li>
				<li data-target="#bs-carousel" data-slide-to="1"></li>
				<li data-target="#bs-carousel" data-slide-to="2"></li>
				<li data-target="#bs-carousel" data-slide-to="3"></li>
			  </ol>
			--%><div class="carousel-inner">
				<div class="item slides active" style="background:url(assets/new-design/img/banner1.jpg) no-repeat 0px 0px; background-size:cover;"></div>
				<div class="item slides" style="background:url(assets/new-design/img/banner2.jpg) no-repeat 0px 0px; background-size:cover;"></div>
				<div class="item slides" style="background:url(assets/new-design/img/banner3.jpg) no-repeat 0px 0px; background-size:cover;"></div>
				<div class="item slides" style="background:url(assets/new-design/img/banner4.jpg) no-repeat 0px 0px; background-size:cover;"></div>
			</div>
			<div class="banner-cont">
				<div class="container container-1280">
					<div class="row">
						<div class="col-md-5"></div>
						<div class="col-md-7">
							<div class="banner-text">
								<h1>Find the right cancer treatment.</h1>
							</div>	
						</div>
					</div>
				</div>
			</div>	
		</div> 
	</section>
	<!-- Banner end here-->
	
	
	<section class="white-bg white-pad"><%-- style="padding: 0px 0 0px !important;">--%>
		<div class="container container-1280">
			<div class="row">
				<div class="col-md-12">
					<h6>What can HealPal do to help you today ?</h6>
					<div class="list-cont">
						<div class="col-md-4 col-sm-6 pad-lr-0 border-rb tborder-lt">
							<g:link controller="home" action="learn">
								<div class="icon-bg pull-left"><span class="learn-icon"></span></div>
								<div class="list-right-cont pull-left"> 
									<h5>Learn About Your Cancer</h5>
									<p>Precise information explained with easy to understand infographics and videos.</p>
								</div>	
								<div class="clearfix"></div>
							</g:link>
						</div>
						<div class="col-md-4 col-sm-6 pad-lr-0 border-rb">
							<g:link controller="home" action="match">
								<div class="icon-bg pull-left"><span class="discover-icon"></span></div>
								<div class="list-right-cont pull-left"> 
									<h5>Discover Your Match</h5>
									<p>Our unique algorithm matches you with patients most similar to you.</p>
								</div>	
								<div class="clearfix"></div>
							</g:link>
						</div>
						<div class="col-md-4 col-sm-6 pad-lr-0 border-rb border-rt tborder-lt">
							<g:link controller="home" action="connect">
								<div class="icon-bg pull-left"><span class="connect-icon"></span></div>
								<div class="list-right-cont pull-left"> 
									<h5>Connect With Your Match</h5>
									<p>Get valuable information regarding doctors and successful treatments.</p>
								</div>	
								<div class="clearfix"></div>
							</g:link>
						</div>
						<div class="col-md-4 col-sm-6 border-rb border-bot t-bottom-bot pad-lr-0">
							<g:link controller="home" action="getAnswers">
								<div class="icon-bg pull-left"><span class="answer-icon"></span></div>
								<div class="list-right-cont pull-left"> 
									<h5>Get Answers</h5>
									<p>Get personalized answers from patients and cancer experts.</p>
								</div>	
								<div class="clearfix"></div>
							</g:link>
						</div>
						<div class="col-md-4 col-sm-6 border-rb border-bot tborder-lt pad-lr-0">
							<g:link controller="home" action="shareYourStory" >
								<div class="icon-bg pull-left"><span class="story-icon"></span></div>
								<div class="list-right-cont pull-left"> 
									<h5>Share Your Story</h5>
									<p>Give hope and inspiration to those fighting  their own battle against cancer.</p>
								</div>	
								<div class="clearfix"></div>
							</g:link>
						</div>
						<div class="col-md-4 col-sm-6 pad-lr-0 last-box">
							<g:link controller="home" action="writeAReview" >
								<div class="icon-bg pull-left"><span class="write-icon"></span></div>
								<div class="list-right-cont pull-left"> 
									<h5>Write a Review</h5>
									<p>Your review can help others make better decisions.</p>
								</div>	
								<div class="clearfix"></div>
							</g:link>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<section class="light-gray-bg gray-pad">
		<div class="container container-1280">
			<div class="row">
				<div class="col-md-12">
					<h2 class="text-center">Browse Cancer Treatments</h2>
					<ul class="list-view">
					<div class="col-md-12">
						<div class="col-sm-4">
							<li><g:link controller="home" action="cancerTreatments" params="[treatment:'Angiogenesis inhibitors']">Angiogenesis inhibitors</g:link></li>
							<li><g:link controller="home" action="cancerTreatments" params="[treatment:'Biological agents']">Biological agents</g:link></li>
							<li><g:link controller="home" action="cancerTreatments" params="[treatment:'Chemotherapy']">Chemotherapy</g:link></li>
							<%--<li><a href="JavaScript:void(0)">Biopsy</a></li>
							<li><a href="JavaScript:void(0)">Cancer surgery</a></li>--%>
						</div>
						<div class="col-sm-4">							
							<%--<li><a href="JavaScript:void(0)">Central venous access catheter</a></li>--%>
							<li><g:link controller="home" action="cancerTreatments" params="[treatment:'Hormone therapy']">Hormone therapy</g:link></li>
							<li><g:link controller="home" action="cancerTreatments" params="[treatment:'Immunotherapy']">Immunotherapy</g:link></li>
							<li><g:link controller="home" action="cancerTreatments" params="[treatment:'Radiation therapy']">Radiation therapy</g:link></li>						
						</div>
						<%--<div class="col-md-2 col-sm-5 t-browse-cont pad-lr-0">	
							
							<li><a href="JavaScript:void(0)">Radiosurgery</a></li>							
							<li><a href="JavaScript:void(0)">Sentinel lymph node biopsy</a></li>
							
						</div>
					--%><div class="col-md-4 col-sm-4 pad-lr-0 t-browse-cont">							
							<li><g:link controller="home" action="cancerTreatments" params="[treatment:'Stereoactive ablative body radiotherapy (SABR)']">Stereoactive ablative body radiotherapy (SABR)</g:link></li>
							<li><g:link controller="home" action="cancerTreatments" params="[treatment:'Surgery']">Surgery</g:link></li>
							<li><g:link controller="home" action="cancerTreatments" params="[treatment:'Targeted therapy']">Targeted therapy</g:link></li>
							</div>
						</div>
					</ul>
					<div class="clearfix mar-bot-30"></div>
					<div class="text-center"><g:link controller="home" action="cancerTreatments" params="[treatment:'Angiogenesis inhibitors']" class="more-link">View all treatments<span class="blue-arrow"></span></g:link></div>
				</div>
			</div>
		</div>
	</section>
	
	<section class="gray-bg recovery-pad recovery-bg">
		<div class="container container-1280">
			<div class="row">
				<div class="col-md-12 text-center">
					<h2>Take control of your recovery. </h2>
					
					<a class="btn orange-btn orange-btn-mar" href="#" data-toggle="modal" data-target="#signin">Get Started</a>
				</div>
			</div>
		</div>
	</section>	
	<!-- Footer Start here-->
	<footer>
		<div class="pre-footer">
			<div class="container">
				<div class="row">
					<div class="col-md-9 center-align">
						<div class="col-md-4 col-sm-4 m-pad-lr">
							<h6>Healpal</h6>
							<ul>
								<li>
								<g:link controller="footer" action="about">About</g:link></li>
								<li><g:link controller="footer" action="team">Team</g:link></li>
								<li><g:link controller="footer" action="contact">Contact</g:link></li>
								<li><g:link controller="footer" action="guidelinesAndPolicies">Guidelines and Policies</g:link></li>
							</ul>
						</div>
						<div class="col-md-4 col-sm-4 m-pad-lr">
							<h6>For Doctors</h6>
							<ul>
								<li><g:link controller="home" action="fordoctor">Claim Your Profile</g:link></li>
								<%--<li><a href="JavaScript:void(0)">Advertise</a></li>
								<li><a href="JavaScript:void(0)">HealPal Top Doctors</a></li>
							--%></ul>
						</div>
						<div class="col-md-4 col-sm-4 m-pad-lr">
							<h6>My Account</h6>
							<ul>
							<g:if test="${!session.user}">
								<li><a href="#" data-toggle="modal" data-target="#join">Join</a></li>
								<li><a href="#" data-toggle="modal" data-target="#signin">Sign in</a></li>
								</g:if>
								<li><g:link controller="footer" action="termsOfService">Terms of Service</g:link></li>
							</ul>
						</div>
					</div>
				</div>	
			</div>
		</div>
		<div class="footer-bg">
			<div class="container">
				<div class="row">
					<div class="col-md-10 text-center center-align">
						<p>The information on this website is generated by our members and may not always be accurate because personal experiences and results may vary.  Your physician should always be involved and be your primary contact during your cancer treatment.</p>
						<div class="social-icons">
						    <a class="fb-icon" href="JavaScript:void(0)"></a>
							<a class="twitter-icon" href="JavaScript:void(0)"></a>
							<a class="pinterest-icon" href="JavaScript:void(0)"></a>
							<a class="linkedin-icon" href="JavaScript:void(0)"></a>
						</div>
						<p>&copy;2016 HealPal Inc. All rights reserved.</p>
					</div>
				</div>
			</div>
		</div>
	</footer>
	<!-- Footer end here-->
	<g:render template="signinSignup"></g:render>
	 <!-- Modal POPUP-->

	 
	
	 <!--QUERY-->
	<script type="text/javascript" src="assets/new-design/js/jquery-1.11.1.js"></script>
	<script type="text/javascript" src="assets/new-design/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${resource(dir:'js/user',file:'login.js')}"></script>
	<script type="text/javascript" src="${resource(dir:'js/user',file:'signup.js')}"></script>
	<g:if test="${session.user}">
	<script type="text/javascript" src="${resource(dir:'assets/js',file:'logout.js')}"></script>
	</g:if>
	<script type="text/javascript">
	$("#join-acc").click(function(){
		$("#signin").modal('toggle');
		$('div').removeClass("modal-backdrop");
		});

	
		$("#sign-in").click(function(){
		$("#join").modal('toggle');
		$('div').removeClass("modal-backdrop");
		});

		$("#forgotPassword").click(function(){
			$("#signin").modal('toggle');
			$('div').removeClass("modal-backdrop");
			});
	</script>

	

	<script type="text/javascript">
	
	function showSpinner() {
		   $('#gif').show();
	   }
	   function hideSpinner() {
	      $('#gif').hide();
	   }
	   
	   Ajax.Responders.register({
	      onLoading: function() {
	         showSpinner();
	      },
	      onComplete: function() {     
	         if(!Ajax.activeRequestCount) hideSpinner();
	      }
	   });
	   
	</script>
</body></html>
	   
	  
  
