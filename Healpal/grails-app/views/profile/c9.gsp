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
		<g:form action="c9" method="POST">
				<div class="col-sm-12">
						<div class="profile-box-bg">
							<div class="icon-box-top text-center"><img src="../assets/profile/img/c9-icon.jpg" /></div>
							<div class="text-center">
								<h1>Type of health insurance</h1>
									<div class="list-content content-list">
									<g:if test="${healthInsurance}">
								<g:each in="${healthInsurance}" var="patient">
									<div class="col-md-6 col-xs-12 pad-lt-0 m-pad-rt">
										<ul>
											<li><input type="checkbox" value="${patient?.id}" id="${patient?.id}" name="healthInsurance" class="checkboxSelect" />
												<label for="${patient?.id}" class="selectedLabels"> ${patient?.healthInsuranceType}</label>
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
								<g:link action="c8" class="back-link"> <i class="back-arrow"></i>Back</g:link>
								<g:link class="skip-text"> <g:submitButton name="NEXT" /></g:link>
						</div>
						<div class="container container-950">
			<div class="prograss-bar pull-left">
				<div class="bar-text">10/12</div>
				<ul>
					<div class="per-text pull-left">0%</div>
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
					<div class="per-text pull-right">20%</div>
				</ul>
				<p>2 more questions for 20% profile completion</p>				
				
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
			<div class="prograss-bar pull-left">
				<div class="bar-text">10/12</div>
				<ul>
					<div class="per-text pull-left">0%</div>
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
					<div class="per-text pull-right">20%</div>
				</ul>
				<p>2 more questions for 20% profile completion</p>				
				
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