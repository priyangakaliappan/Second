<%--
 *
 * Author  		: Ramesh L
 * Project 		: HealPal
 * Date    		: 11/03/2015
 * FileName 	: match
 *
 * #      Name         Version   Modified-Date      Description
 * -------------------------------------------------------------------------------------
 * 1      Ramesh L     1.0       11/03/2015      Initial Creation
 * 
 *
 */
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="layout" content="homeLayout" />
<title>Match</title>
</head>
<body>
	<section class="match-banner">
	<div class="m-match-banner" style="background:url(../assets/new-design/img/match-banner.jpg) no-repeat center top; background-size:cover; max-width:100%; height:536px;"></div>
		<div class="container container-1280">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<div class="blue-strip match-strip">
						<h1>Discover a patient most like you.</h1>
						<div class="clearfix"></div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!--Inner banner end here-->
	<!--Inner page content start here-->
	<section class="match-bg">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 text-center">
					<p class="mar-top-70">Our unique matching algorithm will match you with patients who share the same cancer diagnosis and stage with you.</p>
				    <p class="mar-top-10">You are not alone in your cancer journey.</p> 
					<div class="clearfix mar-bot-10"></div>
					<div class="col-lg-4 col-md-4 col-sm-3 col-xs-12"></div>
					<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12 mar-top-10">
					<g:if test="${!session.user}">
						<a href="#" data-toggle="modal" data-target="#join" class="btn-default inner-orange-btn inner-create-btn">Create Your Profile</a>
						</g:if>
						<g:if test="${session.user}">
						<g:link controller="profile" action="editProfile"  class="btn-default inner-orange-btn inner-create-btn">Update your profile</g:link>
						</g:if>
						
						
					</div>
					<div class="col-lg-4 col-md-4 col-sm-3 col-xs-12"></div>
					<div class="clearfix">&nbsp;</div>
					<div class="clearfix">&nbsp;</div>
					<div class="clearfix">&nbsp;</div>
				</div>
			</div>
		</div>
	</section>
	
	
	
	<!--end here-->

</body>
</html>