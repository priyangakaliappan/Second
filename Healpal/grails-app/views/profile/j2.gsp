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
							<div class="text-center">
								<div class="icon-box-top"><img src="../assets/icon/h2-icon.jpg" /></div>
								<g:form controller="profile" name="d5" class="form-horizontal">
								<h1>
						Please state the clinical trial you participated in
					</h1>
								<div class="col-md-10 col-xs-12 center-align m-pad-lr">
									<textarea class="textarea" name="participated" id="participate" placeholder="Please type here"></textarea>
									
									<g:actionSubmit value="Next" action="j2"  class="blue-btn" id="participated"/>
								</div>
								<div class="clearfix"></div>
								</g:form>
							</div>
							<div class="clearfix">&nbsp;</div>
							<div class="clearfix">&nbsp;</div>
								<g:link controller="profile" action="j1" class="back-link"> <i class="back-arrow"></i>Back</g:link>
							</div>
							<div class="container container-950">
			<div class="prograss-bar bar-4-slider pull-left">
				<div class="bar-text">4/4</div>
				<ul>
					<div class="per-text pull-left">70%</div>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<div class="per-text pull-right">80%</div>
				</ul>
				<p>0 more questions for 80% profile completion</p>				
				
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
				<div class="bar-text">4/4</div>
				<ul>
					<div class="per-text pull-left">70%</div>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<div class="per-text pull-right">80%</div>
				</ul>
				<p>0 more questions for 80% profile completion</p>				
				
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