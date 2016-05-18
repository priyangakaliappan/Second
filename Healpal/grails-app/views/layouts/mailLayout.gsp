<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
	<meta name="apple-mobile-web-app-capable" content="yes"/>
    <title> ::.. Healpal | Home ..:: </title>
    <!-- Bootstrap Core CSS -->
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
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="../../oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="../../oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
     <style type="text/css">
    .login-right-cont {
    background-color: #fff;
    border: 1px solid #e7e7e7;
    display: table-cell;
    float: none;
    vertical-align: top;
    
}
    
.col-sm{
padding: 32px 0 0;
margin-left: 200px;
position: relative;
left: 295px;
}
.forgot-btn{
background: #f37021 none repeat scroll 0 0;
    color: #fff;
    font-family: "Opensans Semibold";
    font-size: 12px;
    height: 35px;
    margin-bottom: 38px !important; 
    margin-top: 26px;
}
.link-orange
{
background: #f37021 none repeat scroll 0 0;
    color: #fff;
    font-family: "Opensans Semibold";
    font-size: 12px;
    height: 35px;
   
}
    
    #res.alert, #Err.alert { margin: 10px 0px 0px; font-size: 12px; width: 100%; } 
    
    
    </style>
</head>
<body>
	<header class="header" id="home-index"><!-- header Start here-->
		<div class="container container-header pad-lt-0">
			<div class="col-lg-3 col-md-3 col-sm-6 col-xs-6 logo">
				<g:link controller="home" action="index" class="logo">
					<img class="img-responsive" src="../assets/new-design/img/logo.png">
				</g:link>
			</div>
			<div class="col-lg-9 col-md-5 col-sm-6 col-xs-6 pad-rt-0">
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
					<!-- Collect the nav links, forms, and other content for toggling -->
					<div class="collapse navbar-collapse" id="home-nav">
						<ul class="nav navbar-nav">
							<li class="${learn?:''}"><g:link controller="home" action="learn" >Learn</g:link> </li>
							<li class="${match?:''}"><g:link controller="home" action="match" >Match</g:link> </li>
							<li class="${connect?:''}"><g:link controller="home" action="connect" >Connect</g:link> </li>
							<li class="${fordoctor?:''}"><g:link controller="home" action="fordoctor" >Find a doctor</g:link></li>
							<li class="${writeAReview?:''}"><g:link controller="home" action="writeAReview" >Write a review</g:link></li>
							<li class="pull-right">
								<div class="pull-right">
								<g:link controller="home" action="fordoctor" class="btn btn-default btn-lg ${fordoctor?:''}">For Doctors</g:link>
									<a href="#" data-toggle="modal" data-target="#join" class="btn btn-default btn-lg header-orange-btn">Join</a>
									<a class="signin-text check-layout" href="#" data-toggle="modal" data-target="#signin">Sign in</a>
								</div>
							</li>
						</ul>
					</div>
				</nav>
			</div>
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
	<g:render template="/home/signinSignup"></g:render>
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
								<li><a href="#" data-toggle="modal" data-target="#join">Join</a></li>
								<li><a href="#" data-toggle="modal"  data-target="#signin">Sign in</a></li>
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
	<!-- Footer end here-->
	
	<script type="text/javascript" src="../assets/new-design/js/jquery-1.11.1.js"></script>
	<script type="text/javascript" src="../assets/new-design/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${resource(dir:'js/user',file:'login.js')}"></script>
	<script type="text/javascript" src="${resource(dir:'assets/js',file:'logout.js')}"></script>
	<script type="text/javascript" src="${resource(dir:'js/user',file:'signup.js')}"></script>
	<script type="text/javascript" src="${resource(dir:'assets/js/forgot',file:'forgotPassword.js')}"></script>
	<script src="${resource(dir:'assets/js/forgot',file:'password.js')}"></script>
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