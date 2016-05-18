<!--  
 * Author    : Arunkumar K
 * Project   : Healpal
 * File      : care
 * Date      : 23-10-2015
 *
 * #   Name           Version           Modified-Date      Description
 * -------------------------------------------------------------------------------------
 * 1   Arunkumar K    1.0               23-10-2015         Initial Creation
 * 2   Ramesh         1.0               23-11-2015         
 */-->
<!DOCTYPE html>
<%@page import="com.healpal.care.DashboardService"%>
<%@page import="com.healpal.care.Patient"%>
<%@page import="com.healpal.care.HealpalUser"%>
<%@page import="com.healpal.care.Person"%>
<%@page import="java.lang.System"%>
<%@page import="com.healpal.care.PatientChat"%>
<%@page import="com.healpal.care.ConnectionService"%>
<%@page import="com.healpal.care.DashboardController"%>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
<meta name="apple-mobile-web-app-capable" content="yes" />
<title>Healpal | Home ..::</title>
<asset:link rel="shortcut icon" href="../assets/icon/headerLogo.ico"
	type="image/x-icon" />
<!-- Bootstrap Core CSS -->
<link
	href="${resource(dir:'assets/bootstrap/css',file:'bootstrap.min.css')}"
	rel="stylesheet" type="text/css">
<link href="${resource(dir:'assets/css',file:'colorbox.css')}"
	rel="stylesheet" type="text/css">
<!-- Custom CSS -->
<link href="${resource(dir:'assets/new-design/css',file:'new-style.css')}"
	rel="stylesheet" type="text/css">
<link href="${resource(dir:'assets/css',file:'new-style.css')}"
	rel="stylesheet" type="text/css">
<link href="${resource(dir:'css',file:'style.css')}" rel="stylesheet"
	type="text/css">
<!-- Custom Fonts -->
<link href="${resource(dir:'assets/css',file:'font-awesome.min.css')}"
	rel="stylesheet" type="text/css">
<link href="${resource(dir:'css',file:'jquery.tokenize.css')}"
	rel="stylesheet" type="text/css">
<link
	href="${resource(dir:'assets/bootstrap/css',file:'bootstrap.css')}"
	rel="stylesheet">
<link
	href="${resource(dir:'assets/css/datepicker',file:'datepicker.css')}"
	rel="stylesheet">
	<link
	href="${resource(dir:'assets',file:'style_new.css')}"
	rel="stylesheet">
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="../../oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="../../oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
<%--<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
	--%>
<link href="${resource(dir:'assets/progress/css',file:'jquery-ui.css')}"
	rel="stylesheet" type="text/css">
<script type="text/javascript"
	src="${resource(dir:'assets/progress/js',file:'jquery.min.js')}"></script>
<script type="text/javascript"
	src="${resource(dir:'assets/progress/js',file:'jquery-ui.min.js')}"></script>


<script type="text/javascript">
	$("document").ready(function(){
		//alert("call document function");
		autoRefresh();
	});
	function autoRefresh(){
		setTimeout(function() {
			  $.ajax({
			   url : "../Dashboard/autoRefresh",
			   success : function(res) {
				 //  alert(res)
				   //location.reload(true);
				    $("#messagePopUp").html(res);
					// alert(res);
			   }
			  });
			 autoRefresh();
			 }, 15000);
	}

</script>


<%--<script type="text/javascript">
	$("document").ready(function(){
		autoRefresh();
	});
function autoRefresh(){
	var temp = 0;
	$("#messagePopUp").html(temp);
	setTimeout(function() {
		for(var i=0;i<3;i++){
temp = temp + i;
			}
		  $("#messagePopUp").html(temp);
		 autoRefresh();
		 }, 1000);
}

</script>
--%>
<%--<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  <script
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<script type="text/javascript"
		src="http://ajax.googleapis.com/ajax/libs/jqueryui/1/jquery-ui.min.js"></script>
--%>
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
	color: white !important;
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
	position: relative;
	margin-left: -128px;
}

#file_div {
	background: white;
	border: 1px solid white;
	border-radius: 3px;
	font-size: 24px;
}

#upload_photo-error {
	position: absolute;
	top: 144px;
	left: 206px;
	display: block;
	font-size: large;
	color: #f07182;
}

.selectedLabels {
	cursor: pointer;
}

.active_row {
	background-color: #F5F5DC;
}

#err_field {
	position: absolute;
	top: 144px;
	font-size: large;
	color: #f07182;
	left: 294px;
}
</style>
</head>
<body>
	<header class="header dashboard-header" id="home-index">
		<!-- header start here-->
		<div class="container container-header pad-lr-0 header-sub">
			<div class="col-lg-4 col-md-4 col-sm-7 col-xs-10 logo">
				<g:link controller="home" action="index" class="logo">
					<img class="img-responsive"
						src="${resource(dir:'assets/new-design/img',file:'logo.png')}">
				</g:link>
			</div>
			<div class="col-lg-8 col-md-8 col-xs-12 ">
				<!--menu sign in sign up start here-->
				<div class="col-lg-6 col-md-6 col-xs-12 mar-top-20">
					<div class="header-search-box header-search-box-pad">
						<input type="text"
							class="header-search" id="matchSearch"
							placeholder="Search for patient" />
						<div class="clearfix"></div>
					</div>
				</div>
				<div class="col-lg-6 col-md-6 col-xs-12 header-alert pad-rt-0">
					<div
						class="col-lg-7 col-md-7 col-xs-12 dashboard-icons pad-lr-0 mar-top-20">
						<%--Message--%>

						<div>
							<g:render template="../dashboard/messageNotification"></g:render>
						</div>

					</div>

					<%--Account & Settings--%>
					<nav id="colorNav" class="user-menu ">
						<ul>
							<li><a href="#"><div class="welcome-text -icon-home">
									Hi
										<g:getUserName user="${session?.user}" />
										<g:set var="photo"
											value="${DashboardService.getPhoto(session.user)}" />
										<g:if test="${photo}">
											<div class="dashboard-profile-img">
												<img class="img-responsive"
													src="${resource(dir:'assets/patient-photo',file:photo)}">
											</div>
										</g:if>
										<g:else>
											<img class="img-responsive"
												src="${resource(dir:'assets/patient-photo',file:'noimage.jpg')}">
										</g:else>
									</div></a>

								<ul class="list_ul message-dropdown profile-drop msg-popup">
									<li class="message-dropdown-tit"><a href="#">Account &
											Settings</a></li>
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
										<div class="right_div"><g:getPercentage user="${session.user}"/></div></li>
									<!-- More dropdown options -->
								</ul></li>
							<!-- More menu items -->
						</ul>
					</nav>
				</div>
			</div>
		</div>
		<!-- end here-->

	</header>
	<!-- header end here-->
	<div class="fixed-header dashboard-header-sub"></div>
	<g:layoutBody />
	<script type="text/javascript"
		src="${resource(dir:'assets/js',file:'jquery-1.11.1.js')}"></script>
	<script type="text/javascript"
		src="${resource(dir:'assets/bootstrap/js',file:'bootstrap.min.js')}"></script>
	<script type="text/javascript"
		src="${resource(dir:'assets/js',file:'jquery.colorbox.js')}"></script>
	<script type="text/javascript"
		src="${resource(dir:'assets/js',file:'custom.js')}"></script>
	<script type="text/javascript"
		src="${resource(dir:'assets/js',file:'jquery.tokenize.js')}"></script>
	<script type="text/javascript"
		src="${resource(dir:'assets/js',file:'logout.js')}"></script>
	<script type="text/javascript"
		src="${resource(dir:'js/dashboard',file:'message.js')}"></script>
	<script src="../js/profile/profile.js"></script>
	<script
		src="http://jqueryvalidation.org/files/dist/jquery.validate.min.js"></script>
	<script
		src="http://jqueryvalidation.org/files/dist/additional-methods.min.js"></script>

</body>
</html>

