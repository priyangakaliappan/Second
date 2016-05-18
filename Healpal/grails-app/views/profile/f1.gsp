<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="layout" content="createProfile" />
<title>Insert title here</title>
</head>
<body>
<section>
<div class="container container-950">
<div class="row">
	<div class="col-sm-12">
						<div class="profile-box-bg">
							<div class="col-md-10 col-xs-12 center-align text-center">
								<div class="icon-box-top"><img src="${resource(dir:'assets/icon',file:'f1-icon.jpg')}"/></div>
								<h2>Did you undergo Chemotherapy ?</h2>
								<div class="box-content2">
									<div class="box-content2-bg" id="chemotherapy-yes"><g:link controller="Profile" action="f1"
								params="[question:'Did you undergo Chemotherapy?',answer:'Yes']">
								<h3>
									<span>Yes</span>
								</h3>
							</g:link></div>
								</div>
								<div class="box-content2">
									<div class="box-content2-bg" id="chemotherapy-no"><g:link controller="Profile" action="f1"
								params="[question:'Did you undergo Chemotherapy?',answer:'No']"><h3><span>No</span></h3></g:link></div>
								</div>
								<div class="box-content2">
									<div class="box-content2-bg" id="chemotherapy-scheduled"><g:link controller="Profile" action="f1"
								params="[question:'Did you undergo Chemotherapy?',answer:'Scheduled for Chemo-therapy']"><h3><span>Scheduled for Chemo-therapy</span></h3></g:link></div>
								</div>
							</div>
							<div class="clearfix">&nbsp;</div>
							<div class="clearfix">&nbsp;</div>
								<g:if test="${BackToe1}">
								<g:link controller="Profile" action="e1" class="back-link"><i class="back-arrow"></i>Back</g:link>
								</g:if>
								<g:else>
								<g:link controller="Profile" action="e4" class="back-link"><i class="back-arrow"></i>Back</g:link>
								</g:else>
							</div>
							<div class="container container-950">
			<div class="prograss-bar bar-20-slider pull-left">
				<div class="bar-text">16/19</div>
				<ul>
					<div class="per-text pull-left">20%</div>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li></li>
					<li></li>
					<li></li>
					
					<div class="per-text pull-right">50%</div>
				</ul>
				<p>3 more questions for 50% profile completion</p>				
				
			</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
		</div>
						</div>
						</div></div></section><%--
						<section>
		<div class="container container-950">
			<div class="prograss-bar bar-20-slider pull-left">
				<div class="bar-text">16/19</div>
				<ul>
					<div class="per-text pull-left">20%</div>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li></li>
					<li></li>
					<li></li>
					
					<div class="per-text pull-right">50%</div>
				</ul>
				<p>3 more questions for 50% profile completion</p>				
				
			</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
		</div>
		</section>
--%></body>
</html>