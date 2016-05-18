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
						<g:form controller="profile" action="d5">
							<div class="col-md-10 col-xs-12 center-align  text-center m-pad-lr">
							<g:form  controller="profile" name="d5" class="form-horizontal">
				<h1>Your age at Diagnosis</h1>
				<g:hiddenField value="${age}" name="age"></g:hiddenField>
					<div class="col-md-7 text-center center-align">
					<input type="text" class="textbox text-box1" id="age" maxlength="3" name="ageId" 
						value="${age} Years" readonly="readonly"/>
				</div>
				<div class="clearfix"></div>
				<p class="warn_msg">( If you have entered any of the dates wrongly, you could click the links below )</p>
				<div class="col-sm-6"><span><g:link controller="profile" action="c2" class="span_link" params="[backTod4:'true']">Date of Birth</g:link></span></div>
				<div class="col-sm-6"><span><g:link controller="profile" action="d4" class="span_link span_1" params="[goToD5:'true']">Date of Cancer Diagnosis</g:link></span></div>
					<div class="clearfix mar-bot-20"></div>			
								<g:actionSubmit	value="Save and Continue" action="d5" class="blue-btn" id="saveAge"/>
				</g:form>
								</div>
								<div class="clearfix">&nbsp;</div>
								<div class="clearfix">&nbsp;</div>
								<g:link controller="profile" action="d4" class="back-link"><i class="back-arrow"></i>Back</g:link>
								</g:form>
							</div>
							<div class="container container-950">
			<div class="prograss-bar bar-20-slider pull-left">
				<div class="bar-text">4/19</div>
				<ul>
					<div class="per-text pull-left">20%</div>
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
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<div class="per-text pull-right">50%</div>
				</ul>
				<p>15 more questions for 50% profile completion</p>				
				
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
			<div class="prograss-bar bar-20-slider pull-left">
				<div class="bar-text">4/19</div>
				<ul>
					<div class="per-text pull-left">20%</div>
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
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<div class="per-text pull-right">50%</div>
				</ul>
				<p>15 more questions for 50% profile completion</p>				
				
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