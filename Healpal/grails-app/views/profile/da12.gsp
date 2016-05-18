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
						<g:form controller="profile" action="da12">
							<div class="text-center">
								<div class="icon-box-top"><img src="../assets/profile/img/da10-icon.jpg" /></div>
								<h3 class="pad-bot-0">Please choose which molecular test or tests have been performed</h3>
								<div class="list-content content content-left">
									<ul>
										<li><input type="checkbox" value="Oncotype Dx test" name="answer1" class="checkboxSelect" id="answer1"/>
										<label for="answer1" class="selectedLabels">Oncotype Dx test</label>
										<li><input type="checkbox" value="MammoPrint test" name="answer2" class="checkboxSelect" id="answer2"/>
										<label for="answer2"  class="selectedLabels">MammoPrint test</label>
										<li><input type="checkbox" id="answer3" value="Urokinase plasminogen activator (uPA) and plasminogen activator inhibitor (PAI-I) tests" name="answer3" class="checkboxSelect"/>
										<label for="answer3" class="selectedLabels">Urokinase plasminogen activator (uPA) and plasminogen activator inhibitor (PAI-I) tests</label>
									</ul>
									<div class="clearfix mar-bot-20ssss"></div>
									<p>( You can Select one or multiple choices)</p>
								</div>
							</div>
								<div class="clearfix">&nbsp;</div>
						<div class="clearfix">&nbsp;</div>
								<g:link controller="Profile" action="da11" class="back-link"><i class="back-arrow"></i>Back</g:link>
								<g:link action="" class="skip-text"><g:submitButton name="NEXT"/></g:link>
								</g:form>
							</div>
							<div class="container container-950">
			<div class="prograss-bar bar-20-slider pull-left">
				<div class="bar-text">11/19</div>
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
				<p>8 more questions for 50% profile completion</p>				
				
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
				<div class="bar-text">11/19</div>
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
				<p>8 more questions for 50% profile completion</p>				
				
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