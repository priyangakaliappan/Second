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
							<div class="icon-box-top text-center"><img src="../assets/icon/e1-icon.jpg" /></div>
							<div class="text-center">
								<h1>Results of your surgery</h1>
									<div class="list-content">
									<div class="col-md-6 col-xs-12 pad-lt-0 m-pad-rt">
										<ul>
											<li  id="surgery-success"><g:link controller="Profile" action="e3" params="[answer: 'Successful. Results as expected']" class="box">Successful. Results as expected</g:link></li>
											<li id="surgery-noimpact"><g:link controller="Profile" action="e3" params="[answer: 'No significant impact to daily lifestyle']" class="box">No significant impact to daily lifestyle</g:link></li>
											<li id="surgery-severe"><g:link controller="Profile" action="e3" params="[answer: 'Severe complications']" class="box">Severe complications</g:link></li>
										</ul>
									</div>
									<div class="col-md-6 col-xs-12 pad-rt-0 hidden-xs hidden-sm">
										<ul>
											<li id="surgery-minimal-effect"><g:link controller="Profile" action="e3" params="[answer: 'Minimal side effects']" class="box">Minimal side effects </g:link></li>
											<li id="surgery-side-effect"><g:link controller="Profile" action="e3" params="[answer: 'Significant side effects']" class="box">Significant side effects</g:link></li>
											<li id="surgery-impact"><g:link controller="Profile" action="e3" params="[answer: 'Significant impact to daily lifestyle']" class="box">Significant impact to daily lifestyle</g:link></li>
										</ul>
									</div>
								</div>
								<div class="clearfix mar-bot-30"></div>
								</div>
								<div class="clearfix">&nbsp;</div>
								<div class="clearfix">&nbsp;</div>
								<g:link controller="Profile" action="e2" class="back-link"><i class="back-arrow"></i>Back</g:link>
						</div>
						<div class="container container-950">
			<div class="prograss-bar bar-20-slider pull-left">
				<div class="bar-text">14/19</div>
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
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<div class="per-text pull-right">50%</div>
				</ul>
				<p>5 more questions for 50% profile completion</p>				
				
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
			<div class="prograss-bar bar-20-slider pull-left">
				<div class="bar-text">14/19</div>
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
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<div class="per-text pull-right">50%</div>
				</ul>
				<p>5 more questions for 50% profile completion</p>				
				
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