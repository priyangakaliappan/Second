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
							<div class="col-md-10 col-xs-12 center-align text-center">
								<div class="icon-box-top"><img src="../assets/profile/img/da10-icon.jpg" /></div>
								<h2>Pathology biopsy tumor type</h2>
								<div class="box-content2">
									<div class="box-content2-bg" id="pathology-iknow"><g:link controller="profile" action="d9" params="[optionA: 'I know for sure']"><h3><span>I know for sure</span></h3></g:link></div>
								</div>
								<div class="box-content2">
									<div class="box-content2-bg" id="pathology-dont-know"><g:link controller="profile" action="d9" params="[optionB: 'Biopsy performed but I do not know']"><h3><span>Biopsy performed but I do not know</span></h3></g:link></div>
								</div>
								<div class="box-content2">
									<div class="box-content2-bg" id="pathology-awaiting"><g:link controller="profile" action="d9" params="[optionC: 'Biopsy performed, results awaited']"><h3><span>Biopsy performed, results awaited</span></h3></g:link></div>
								</div>
							</div>
							
								<p class="note-text">(Please note: This is a very important question for the match process. If you are not sure or are still awating the results of your biopsy, you can confirm the results and updates the information in your profile.)</p>
								<div class="clearfix">&nbsp;</div>
								<div class="clearfix">&nbsp;</div>
								<g:link controller="profile" action="d8" class="back-link"><i class="back-arrow"></i>Back</g:link>
							</div>
							<div class="container container-950">
			<div class="prograss-bar bar-20-slider pull-left">
				<div class="bar-text">8/19</div>
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
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<div class="per-text pull-right">50%</div>
				</ul>
				<p>11 more questions for 50% profile completion</p>				
				
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
				<div class="bar-text">8/19</div>
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
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<div class="per-text pull-right">50%</div>
				</ul>
				<p>11 more questions for 50% profile completion</p>				
				
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