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
								<div class="icon-box-top"><img src="${resource(dir:'assets/icon',file:'g1-icon.jpg')}"/></div>
								<h2>Did you undergo targeted therapy ?</h2>
								<div class="box-content2">
									<div class="box-content2-bg" id="targeted-yes"><g:link controller="profile" action="h1"
								params="[question:'Did You Undergo targeted therapy',answer:'Yes']">
								<h3>
									<span>Yes</span>
								</h3>
							</g:link></div>
								</div>
								<div class="box-content2">
									<div class="box-content2-bg" id="targeted-no"><g:link controller="profile" action="h1"
								params="[question:'Did You Undergo targeted therapy',answer:'No']"><h3><span>No</span></h3></g:link></div>
								</div>
								<div class="box-content2">
									<div class="box-content2-bg" id="targeted-scheduled"><g:link controller="profile" action="h1"
								params="[question:'Did You Undergo targeted therapy',answer:'Scheduled for targeted therapy']"><h3><span>Scheduled for targeted therapy</span></h3></g:link></div>
								</div>
							</div>
							<div class="clearfix">&nbsp;</div>
							<div class="clearfix">&nbsp;</div>
								<g:if test="${fromG1}">
					<g:link controller="profile" action="g1" class="back-link"> <i class="back-arrow"></i>Back</g:link>
				</g:if>
				<g:else>
					<g:link controller="profile" action="g2" class="back-link"> <i class="back-arrow"></i>Back</g:link>
				</g:else>
							</div>
							<div class="container container-950">
			<div class="prograss-bar bar-4-slider pull-left">
				<div class="bar-text">3/4</div>
				<ul>
					<div class="per-text pull-left">50%</div>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li></li>
					<div class="per-text pull-right">70%</div>
				</ul>
				<p>1 more questions for 70% profile completion</p>				
				
			</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
		</div>
						</div></div></div></section>
						<%--<section>
		<div class="container container-950">
			<div class="prograss-bar bar-4-slider pull-left">
				<div class="bar-text">3/4</div>
				<ul>
					<div class="per-text pull-left">50%</div>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li></li>
					<div class="per-text pull-right">70%</div>
				</ul>
				<p>1 more questions for 70% profile completion</p>				
				
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