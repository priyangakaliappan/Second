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
								<div class="icon-box-top"><img src="../assets/icon/g1-icon.jpg" /></div>
								<h2>Did you undergo Hormonal therapy ?</h2>
								<div class="box-content2">
									<div class="box-content2-bg" id="hormonal-yes"><g:link controller="Profile" action="g1" params="[question:'Did You Undergo Hormonal therapy',answer:'Yes']"><h3><span>Yes</span></h3></g:link></div>
								</div>
								<div class="box-content2">
									<div class="box-content2-bg" id="hormonal-no"><g:link controller="Profile" action="g1" params="[question:'Did You Undergo Hormonal therapy',answer:'No']"><h3><span>No</span></h3></g:link></div>
								</div>
								<div class="box-content2">
									<div class="box-content2-bg" id="hormonal-scheduled"><g:link controller="Profile" action="g1" params="[question:'Did You Undergo Hormonal therapy',answer:'Scheduled for Hormonal therapy']"><h3><span>Scheduled for Hormonal therapy</span></h3></g:link></div>
								</div>
							</div>
							<div class="clearfix">&nbsp;</div>
							<div class="clearfix">&nbsp;</div>
							<g:link controller="Profile" action="f5" class="back-link"> <i class="back-arrow"></i>Back</g:link>
							</div>
							<div class="container container-950">
			<div class="prograss-bar bar-4-slider pull-left">
				<div class="bar-text">1/4</div>
				<ul>
					<div class="per-text pull-left">50%</div>
					<li class="active"></li>
					<li></li>
					<li></li>
					<li></li>
					<div class="per-text pull-right">70%</div>
				</ul>
				<p>3 more questions for 70% profile completion</p>				
				
			</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
		</div>
						</div>
						</div></div></section>
						<%--<section>
		<div class="container container-950">
			<div class="prograss-bar bar-4-slider pull-left">
				<div class="bar-text">1/4</div>
				<ul>
					<div class="per-text pull-left">50%</div>
					<li class="active"></li>
					<li></li>
					<li></li>
					<li></li>
					<div class="per-text pull-right">70%</div>
				</ul>
				<p>3 more questions for 70% profile completion</p>				
				
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