
<%@page import="com.healpal.care.DashboardService"%>
<html lang="en">

<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
<meta name="apple-mobile-web-app-capable" content="yes" />
<title>Healpal</title>
<asset:link rel="shortcut icon" href="../assets/icon/headerLogo.ico"
	type="image/x-icon" />
<!-- Bootstrap Core CSS -->
<%--
    <link href="assets/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    --%>
<link
	href="${resource(dir:'assets/bootstrap/css',file:'bootstrap.min.css')}"
	rel="stylesheet">
<link href="${resource(dir:'assets/css',file:'colorbox.css')}"
	rel="stylesheet">
<%--
    <link href="assets/css/colorbox.css" rel="stylesheet" type="text/css">
	--%>
<!-- Custom CSS -->
<link href="${resource(dir:'css',file:'style.css')}" rel="stylesheet"
	type="text/css">
<link href="${resource(dir:'css',file:'simptip.min.css')}" rel="stylesheet" type="text/css">	
	
<link href="${resource(dir:'assets/css',file:'new-style.css')}"
	rel="stylesheet">
<link href="${resource(dir:'assets/css',file:'style-breast.css')}"
	rel="stylesheet">
<link href="${resource(dir:'assets/css',file:'responsive2.css')}"
	rel="stylesheet">
<%--<link href="assets/css/style-breast.css" rel="stylesheet" type="text/css">
	<link href="assets/css/responsive2.css" rel="stylesheet" type="text/css">
    --%>
<!-- Custom Fonts -->
<%--<link href="assets/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    --%>
<link href="${resource(dir:'assets/css/',file:'font-awesome.min.css')}"
	rel="stylesheet">
<link href="../assets/new-design/css/style.css" rel="stylesheet"
	type="text/css">
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="../../oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="../../oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

<script type="text/javascript"
	src="${resource(dir:'assets/js',file:'jquery-1.11.1.js')}"></script>
</head>
<body>
	<div style="position: relative;">
		<header class="header" id="home-index"><!-- header Start here-->
		<div class="container container-header pad-lt-0">
			<div class="col-lg-3 col-md-3 col-sm-7 col-xs-6 logo header-width">
				<g:link controller="home" action="index" class="logo">
					<img class="img-responsive" src="../assets/new-design/img/logo.png">
				</g:link>
			</div>
			
				<nav class="navbar navbar-default">
					<!-- Brand and toggle get grouped for better mobile display -->
					<div class="navbar-header introduction-header">
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
					
						<ul class="nav navbar-nav intro-nav">
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
		<g:render template="/home/signinSignup"></g:render>

		<g:layoutBody />
		<footer>
			<div class="pre-footer">
				<div class="container">
					<div class="row">
						<div class="col-md-9 center-align">
							<div class="col-md-4 col-sm-4 m-pad-rt">
							<h6>Healpal</h6>
							<ul>
								<li>
								<g:link controller="footer" action="about">About</g:link></li>
								<li><g:link controller="footer" action="team">Team</g:link></li>
								<li><g:link controller="footer" action="contact">Contact</g:link></li>
								<li><g:link controller="footer" action="guidelinesAndPolicies">Guidelines and Policies</g:link></li>
							</ul>
						</div>
						<div class="col-md-4 col-sm-4 m-pad-rt">
							<h6>For Doctors</h6>
							<ul>
								<li><g:link controller="home" action="fordoctor">Claim Your Profile</g:link></li>
								<%--<li><a href="JavaScript:void(0)">Advertise</a></li>
								<li><a href="JavaScript:void(0)">HealPal Top Doctors</a></li>
							--%></ul>
						</div>
						<div class="col-md-4 col-sm-4 m-pad-rt">
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
							<p>The information on this website is generated by our
								members and may not always be accurate because personal
								experiences and results may vary. Your physician should always
								be involved and be your primary contact during your cancer
								treatment.</p>
							<div class="social-icons">
							
								   <a class="fb-icon" href="JavaScript:void(0)"></a> 
								   <a class="twitter-icon" href="JavaScript:void(0)"></a>
								   <a  class="pinterest-icon" href="JavaScript:void(0)"></a> 
								   <a class="linkedin-icon" href="JavaScript:void(0)"></a>
							</div>
							<p>©2016 HealPal Inc. All rights reserved.</p>
						</div>
					</div>
				</div>
			</div>
		</footer><%--<footer>
		<div class="footer-link-row">
			<div class="container">
				<div class="col-sm-4">
					<ul class="links ">
						<li class="top">About</li>
						<li><a href="javascript:void(0)">About HealPal</a></li>
						<li><a href="javascript:void(0)">About Us</a></li>
					</ul>
				</div>
				<div class="col-sm-4">
					<ul class="links ">
						<li class="top">Legal</li>
						<li><a href="javascript:void(0)">Privacy Policy</a></li>
						<li><a href="javascript:void(0)">Terms of Service</a></li>
						<li><a href="javascript:void(0)">Medical Service
								Disclaimer</a></li>
						<li><a href="javascript:void(0)">Security Policy</a></li>

					</ul>
				</div>
				<div class="col-sm-4">
					<ul class="links ">
						<li class="top">Stay in touch</li>
						<li><a href="javascript:void(0)">Contact Us</a></li>
					</ul>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
		<div class="footer-row-tow">
			<div class="container">
				<div class="col-md-12 text-center">
					<p>The information on this website is generated by our members
						and may not always be accurate because personal experiences and
						results may vary. Your physician should always be involved and be
						your primary contact during your cancer treatment.</p>
				</div>
				<div class="col-xs-12 social">
					<ul>
						<li><a href="javascript:void(0)"><span class="linkedin"></span></a></li>
						<li><a href="javascript:void(0)"><span class="twitt"></span></a></li>
						<li><a href="javascript:void(0)"><span class="face"></span></a></li>
					</ul>
				</div>
				<div class="col-xs-12 text-danger copyright">
					<p>&copy;2015 HealPal Inc. All rights reserved.</p>
				</div>
			</div>
		</div>
	</footer>
	--%></div>
	
	
	
	
	
	<div class="modal fade form_popup-mail" id="test" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<button type="button" class="close" data-dismiss="modal"></button>
				<div class="modal-body">
				<div class="container">
	<span id="groupErr1" style="color: red"></span>
	<form class="form-horizontal popup-form">
	<h4>Mail This Page</h4>
		<div class="form-group">
			<label class="control-label col-sm-4 pad-lt-0">Recipient's mail</label>
			<div class="col-sm-8 pad-lt-0">
				<input type="text" id="emails" class="form-control" name="emailToInvite" placeholder="For Multiple recipient seperated by commas"/>
				<%--<small>( For more than one recipient, type addresses seperated by commas )</small>
				
			--%></div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-4 pad-lt-0">Your Name</label>
			<div class="col-sm-8 pad-lt-0">
				<input type="text" id="yourName" class="form-control" name="yourName" placeholder="Your Name"/>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-4 pad-lt-0">Your Email ID</label>
			<div class="col-sm-8 pad-lt-0">
				<input type="email" id="yourMail" class="form-control" name="yourMail" placeholder="Your Email ID"/>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-4 hidden-xs">&nbsp;</label>
			<div class="col-sm-8 pad-lt-0">
				<a href="" class="btn btn-orange btn_sendmail" onclick="return checkEmailValidation()">Send</a>
				<%--<g:actionSubmit class="btn btn-orange btn-send" value="Send" action="inviteFriends" onclick="return checkEmailValidation()"/>
				<a href="#" data-dismiss="modal" class="btn btn-orange btn-cancel">Cancel</a>
			--%></div>
	</div>
	</form>
</div>
				
				</div>

			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->
	
	
	

	<script type="text/javascript" src="${resource(dir:'assets/bootstrap/js',file:'bootstrap.min.js')}"></script>
	<script type="text/javascript" src="${resource(dir:'assets/js',file:'jquery.colorbox.js')}"></script>
	<script type="text/javascript" src="${resource(dir:'js/user',file:'login.js')}"></script>
	<script type="text/javascript" src="${resource(dir:'assets/js',file:'custom.js')}"></script>
	<script type="text/javascript" src="${resource(dir:'assets/js/forgot',file:'forgotPassword.js')}"></script>
	<script src="${resource(dir:'assets/js/forgot',file:'password.js')}"></script>
	<script type="text/javascript" src="${resource(dir:'js/user',file:'signup.js')}"></script>
	<script type="text/javascript" src="${resource(dir:'assets/js',file:'logout.js')}"></script>
	<script type="text/javascript" src="${resource(dir:'assets/new-design/js',file:'custom.js')}"></script>
	<script src="${resource(dir:'js',file:'fb_share.js')}"></script>
	<script src="../js/profile/profile.js"></script>
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
		