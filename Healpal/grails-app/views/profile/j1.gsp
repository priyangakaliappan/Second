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
								<div class="icon-box-top"><img src="${resource(dir:'assets/icon',file:'f1-icon.jpg')}"/></div>
								<h2>Did you participate in any clinical trial ?</h2>
								<div class="box-content2">
									<div class="box-content2-bg" id="clinical-yes"><g:link controller="profile" action="j1" params="[optionA: 'Yes']">
								<h3>
									<span>Yes</span>
								</h3>
							</g:link></div>
								</div>
								<div class="box-content2">
									<div class="box-content2-bg" id="clinical-no"><g:link controller="profile" action="j1" params="[optionB: 'No']"><h3><span>No</span></h3></g:link></div>
								</div>
								<div class="box-content2">
									<div class="box-content2-bg" id="clinical-scheduled"><g:link controller="profile" action="j1" params="[optionC: 'Scheduled for clinical trial']"><h3><span>Scheduled for clinical trial</span></h3></g:link></div>
								</div>
							</div>
							<div class="clearfix">&nbsp;</div>
							<div class="clearfix">&nbsp;</div>
					<g:if test="${BackToi1}">
								<g:link controller="profile" action="i1" class="back-link"><i class="back-arrow"></i>Back</g:link>
							</g:if>
							<g:else>
								<g:link controller="profile" action="i2" class="back-link"><i class="back-arrow"></i>Back</g:link>
							</g:else>
							</div>
							<div class="container container-950">
			<div class="prograss-bar bar-4-slider pull-left">
				<div class="bar-text">3/4</div>
				<ul>
					<div class="per-text pull-left">70%</div>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li></li>
					<div class="per-text pull-right">80%</div>
				</ul>
				<p>1 more questions for 80% profile completion</p>				
				
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
					<div class="per-text pull-left">70%</div>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li></li>
					<div class="per-text pull-right">80%</div>
				</ul>
				<p>1 more questions for 80% profile completion</p>				
				
			</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
		</div>
		</section>
		--%><%--<script type="text/javascript" src="${resource(dir:'js',file:'jquery-1.10.2.js')}"></script>
		<script src="${resource (dir:'assets/javascript',file:'clinicalData.js')}"></script>
--%></body>
</html>