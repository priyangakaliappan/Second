<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<meta name="layout" content="createProfile"/>
<title>Insert title here</title>
</head>
<body>
<section>
<div class="container container-950">
<div class="row">
 <div class="col-sm-12">
						<div class="profile-box-bg">
							<div class="text-center">
							<div class="icon-box-top"><img src="../assets/icon/i1-icon.jpg" /></div>
								<h3 class="pad-bot-0">Which type of radiation treatment did you receive or are scheduled to receive</h3>
								<div class="list-content">
									<ul>
										<li><g:link controller="profile" action="i2" params="[Answer: 'External radiation']">External radiation</g:link></li>
										<li><g:link controller="profile" action="i2" params="[Answer: 'Internal radiation']" >Internal radiation</g:link></li>
										<li><g:link controller="profile" action="i2" params="[Answer: 'Brachytherapy']" >Brachytherapy</g:link></li>
										<li><g:link controller="profile" action="i2" params="[Answer: 'Radiation boost']" >Radiation boost</g:link></li>
										<li><g:link controller="profile" action="i2" params="[Answer: 'Accelerated, hypofractionated whole breast irradiation']" >Accelerated, hypofractionated whole breast irradiation</g:link></li>
									</ul>
									<div class="clearfix mar-bot-20"></div>
								</div>
								</div>
								<div class="clearfix">&nbsp;</div>
								<div class="clearfix">&nbsp;</div>
								<g:link controller="profile" action="i1" class="back-link"><i class="back-arrow"></i>Back</g:link>
							</div>
							<div class="container container-950">
			<div class="prograss-bar bar-4-slider pull-left">
				<div class="bar-text">2/4</div>
				<ul>
					<div class="per-text pull-left">70%</div>
					<li class="active"></li>
					<li class="active"></li>
					<li></li>
					<li></li>
					<div class="per-text pull-right">80%</div>
				</ul>
				<p>2 more questions for 80% profile completion</p>				
				
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
				<div class="bar-text">2/4</div>
				<ul>
					<div class="per-text pull-left">70%</div>
					<li class="active"></li>
					<li class="active"></li>
					<li></li>
					<li></li>
					<div class="per-text pull-right">80%</div>
				</ul>
				<p>2 more questions for 80% profile completion</p>				
				
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