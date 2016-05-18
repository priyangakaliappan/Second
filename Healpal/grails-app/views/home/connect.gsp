<%--
 *
 * Author  		: Ramesh L
 * Project 		: HealPal
 * Date    		: 11/03/2015
 * FileName 	: connect
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
<title>Connect</title>
</head>
<body>
	<section class="inner-banner">
		<div class="m-banner" style="background:url(../assets/new-design/img/connect-banner.jpg) no-repeat center top; background-size:cover; max-width:100%; height:588px;"></div>
		<div class="container">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<div class="blue-strip">
						<h1>Learn from experiences of patients most similar to you.</h1>
						<div class="clearfix"></div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!--Inner banner end here-->
	<!--Inner page content start here-->
	<section class="inner-white-bg">
		<div class="container container-1280">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 text-center">
					<p class="mar-top-70">You can connect with patients who are the closest match to you.</p>
					<p>Get recommendations regarding  physicians from your match.</p>
					<p>Get valuable information about treatments that you may have not considered or<br/> known about and that have succeeded for people like you. </p>
					<div class="clearfix mar-bot-30"></div>
					<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12"></div>
					<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
						<g:if test="${!session.user}">
						<a href="#" data-target="#signin" data-toggle="modal" class="btn-default  inner-orange-btn">Connect</a>
						</g:if>
						<g:if test="${session.user}">
						<g:link controller="Connection" action="list" class="btn-default  inner-orange-btn">Connect</g:link>
						</g:if>
					</div>
					<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12"></div>
					<div class="clearfix">&nbsp;</div>
					<div class="clearfix">&nbsp;</div>
					<div class="clearfix">&nbsp;</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>