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
		<g:form action="g2" method="post">
			<div class="col-sm-12">
						<div class="profile-box-bg">
							<div class="icon-box-top text-center"><img src="${resource(dir:'assets/icon',file:'h2-icon.jpg')}" /></div>
							<div class="text-center">
								<h1>Please choose the hormone therapy drug or drugs given to you</h1>
									<div class="list-content">
									<g:if test="${hormoneTherapy }">
									<input type="hidden" value="Please choose the hormone therapy drug or drugs given to you" name="question">
									<g:each in="${hormoneTherapy}" var="patient">
									<div class="col-md-6 col-xs-12 pad-lt-0 m-pad-rt">
										<ul>
											<li>
													<input type="checkbox" value="${patient?.hormoneTherapyName}" id="${patient?.id}" name="hormoneTherapy" class="checkboxSelect" />
													<label for="${patient?.id}"  class="selectedLabels"> ${patient?.hormoneTherapyName} </label>
												</li>
										</ul>
									</div>
									</g:each></g:if>
									<%--<div class="col-md-6 col-xs-12 pad-lt-0 m-pad-rt">
										<ul>
											<li><a href="ca10.html">Private <small>(through employer or Union)</small></a></li>
											<li><a href="ca10.html">Medicaid or other low-income gov.plan</a></li>
											<li><a href="ca10.html">TRICARE <small>(or other military health insurance)</small></a></li>
											<li><a href="ca10.html">National Health Service</a></li>
										</ul>
									</div>
									
								--%></div>
								<div class="clearfix mar-bot-30"></div>
								<p class="multiple-text">( You can select one or multiple choices )</p>
								</div>
								<div class="clearfix">&nbsp;</div>
								<div class="clearfix">&nbsp;</div>
								<g:link controller="profile" action="g1" class="back-link"> <i class="back-arrow"></i>Back</g:link>
						<g:link class="skip-text"> <g:submitButton name="NEXT" /></g:link>
						</div>
						<div class="container container-950">
			<div class="prograss-bar bar-4-slider pull-left">
				<div class="bar-text">2/4</div>
				<ul>
					<div class="per-text pull-left">50%</div>
					<li class="active"></li>
					<li class="active"></li>
					<li></li>
					<li></li>
					<div class="per-text pull-right">70%</div>
				</ul>
				<p>2 more questions for 70% profile completion</p>				
				
			</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
		</div>
					</div>
		</g:form>
		</div></div></section>
		<%--<section>
		<div class="container container-950">
			<div class="prograss-bar bar-4-slider pull-left">
				<div class="bar-text">2/4</div>
				<ul>
					<div class="per-text pull-left">50%</div>
					<li class="active"></li>
					<li class="active"></li>
					<li></li>
					<li></li>
					<div class="per-text pull-right">70%</div>
				</ul>
				<p>2 more questions for 70% profile completion</p>				
				
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