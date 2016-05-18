<%@page import="com.healpal.care.DashboardService"%>
<html lang="en">
<head>
    <meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
	<meta name="apple-mobile-web-app-capable" content="yes"/>
	<title> ::.. Healpal | Home ..:: </title>
      <asset:link rel="shortcut icon" href="../assets/icon/headerLogo.ico" type="image/x-icon"/>
    
    <link
	href="${resource(dir:'assets/new-design/css',file:'bootstrap.min.css')}"
	rel="stylesheet" type="text/css">
	<!-- Custom CSS -->
     <link
	href="${resource(dir:'assets/new-design/css',file:'style.css')}"
	rel="stylesheet" type="text/css">
    <!-- Custom Fonts -->
      <link
	href="${resource(dir:'assets/new-design/css',file:'font-awesome.min.css')}"
	rel="stylesheet" type="text/css">
	
	<link href="../css/style.css" rel="stylesheet" type="text/css">
	<link href="${resource(dir:'css',file:'easy-autocomplete.min.css')}" rel="stylesheet" type="text/css">
	

    <style type="text/css">
    #res.alert, #Err.alert { margin: 10px 0px 0px; font-size: 12px; width: 100%; } 
    
    
    </style>
</head>
<body>
	<header class="header" id="home-index"><!-- header Start here-->
		<div class="container container-header pad-lt-0">
			<div class="col-lg-3 col-md-3 col-sm-7 col-xs-6 logo header-width">
				<g:link controller="home" action="index" class="logo">
					<img class="img-responsive img-ban" src="../assets/new-design/img/logo.png">
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
							<li class="<%=signClass%> header-signin-bar">
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

										<a class="signin-text check-layout" href="#" data-toggle="modal" data-target="#signin">Sign in</a>	
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
	<!--Search start here-->
	<%--<section class="inner-search-bg">
		<div class="container">
			<div class="row">
				<div class="col-lg-3 col-md-3"></div>
				<div class="col-lg-5 col-md-5 col-sm-4 col-xs-12 pad-rt-0 search-text">
					<input type="text" name="textbox" class="search-textbox" placeholder="Search doctors, treatments and reviews"/>
				</div>
				<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12 pad-rt-0 search-w">
					<a href="JavaScript:void(0)" class="search-btn">Search</a>
				</div>
			</div>
		</div>
	</section>
	--%><!--Search end here-->
	<g:render template="signinSignup"></g:render>
	<!--Inner banner end here-->
	<!--Inner page content start here-->
	<g:layoutBody/>
	<!--Inner page content end here-->
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
							</ul>
						</div>
						<div class="col-md-4 col-sm-4 m-pad-lr">
							<h6>My Account</h6>
							<ul>
							<g:if test="${!session.user}">
								<li><a href="#" data-toggle="modal" data-target="#join">Join</a></li>
								<li><a href="#" data-toggle="modal"  data-target="#signin">Sign in</a></li>
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
						    <a class="fb-icon" href="#"></a>
							<a class="twitter-icon" href="#"></a>
							<a class="pinterest-icon" href="#"></a>
							<a class="linkedin-icon" href="#"></a>
						</div>
						<p>&copy;2016 HealPal Inc. All rights reserved.</p>
					</div>
					 
				</div>
			</div>
		</div>
	</footer>
	
	
	<script type="text/javascript" src="../assets/new-design/js/jquery-1.11.1.js"></script>
	<script type="text/javascript" src="../assets/new-design/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${resource(dir:'js/user',file:'login.js')}"></script>
	<script type="text/javascript" src="${resource(dir:'js/user',file:'signup.js')}"></script>
	<script src="../assets/js/logout.js"></script>
	<script type="text/javascript" src="${resource(dir:'assets/js',file:'jquery.easy-autocomplete.min.js')}"></script>
	<script type="text/javascript" src="${resource(dir:'assets/js',file:'sharePage.js')}"></script>
	   <script type="text/javascript" src="${resource(dir:'assets/js/datepicker',file:'bootstrap-datepicker.js')}"></script>  
	   <link href="${resource(dir:'assets/css/datepicker',file:'datepicker.css')}" rel="stylesheet">
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
</body>
</html>
