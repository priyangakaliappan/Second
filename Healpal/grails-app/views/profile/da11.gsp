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
							<div class="col-md-12 col-xs-12 pad-lr-0">
								<div class="icon-box-top text-center"><img src="../assets/icon/da10-icon.jpg" /></div>
								<h2 class="text-center">I have undergone molecular testing for my cancer</h2>
								<div class="box-content2">
									<div class="box-content2-bg" id="molecular-yes"><g:link controller="Profile" action="da11" params="[answer: 'Yes']"><h3><span>Yes</span></h3></g:link></div>
								</div>
								<div class="box-content2">
									<div class="box-content2-bg" id="molecular-no"><g:link controller="Profile" action="da11" params="[answer: 'No']"><h3><span>No</span></h3></g:link></div>
								</div>
								<div class="box-content2">
									<div class="box-content2-bg" id="molecular-notsure"><g:link controller="Profile" action="da11" params="[answer: 'Not sure']"><h3><span>Not sure</span></h3></g:link></div>
								</div>
								<div class="box-content2">
									<div class="box-content2-bg" id="molecular-dont-know"><g:link controller="Profile" action="da11" params="[answer: 'Dont know']"><h3><span>Don't know</span></h3></g:link></div>
								</div>
							</div>
							<div class="clearfix">&nbsp;</div>
						<div class="clearfix">&nbsp;</div>
							<g:if test="${backTod9}">
								<g:link controller="profile" action="d9" class="back-link"><i class="back-arrow"></i>Back</g:link>
								</g:if>
								<g:else>
								<g:link controller="profile" action="da10" class="back-link"><i class="back-arrow"></i>Back</g:link>
								</g:else>
							</div>
								<div class="container container-950">
			<div class="prograss-bar bar-20-slider pull-left">
				<div class="bar-text">10/19</div>
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
				<p>9 more questions for 50% profile completion</p>				
				
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
				<div class="bar-text">10/19</div>
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
				<p>9 more questions for 50% profile completion</p>				
				
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