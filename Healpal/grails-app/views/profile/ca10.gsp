<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="layout" content="createProfile" />
<title>Insert title here</title>
<style type="text/css">
	.selectedLabels{ padding:0px;}
</style>
</head>
<body>
<section>
<div class="container container-950">
<div class="row">
	<div class="col-sm-12">
						<div class="profile-box-bg">
						<g:form action="ca10" method="post">
				<input type="hidden" value="I am interested in" name="question">
							<div class="text-center multiple-box">
								<h1 class="m-img-text">I am interested in</h1>
								<div class="clearfix mar-bot-20"></div>
								<g:if test="${personalInterest}">
							<g:each in="${personalInterest}" var="patient">
							<g:if test="${patient?.personalInterestType.contains('Advocacy')}">
								<div class="border col-sm-3 col-xs-12 mar-bot-30 m-pad-lr"><input type="checkbox" value="${patient?.personalInterestType}" id="${patient?.id}" name="answer" class="checkboxSelect" /> 
								<label for="${patient?.id}" class="selectedLabels"><img class="img-responsive" src="../assets/profile/img/advocacy-img.jpg"></label></div>
								</g:if>
								<g:if test="${patient?.personalInterestType.contains('Research')}">
								<div class="border col-sm-3 col-xs-12 mar-bot-30 m-pad-lr"><input type="checkbox" value="${patient?.personalInterestType}" id="${patient?.id}" name="answer" class="checkboxSelect" /> 
								<label for="${patient?.id}" class="selectedLabels"><img class="img-responsive" src="../assets/profile/img/research-img.jpg"></label></div>
								</g:if>
								<g:if test="${patient?.personalInterestType.contains('Alternative Medicine')}">
								<div class="border col-sm-3 col-xs-12 mar-bot-30 m-pad-lr"><input type="checkbox" value="${patient?.personalInterestType}" id="${patient?.id}" name="answer" class="checkboxSelect" />
								<label for="${patient?.id}" class="selectedLabels"><img class="img-responsive" src="../assets/profile/img/medicine-img.jpg"></label></div>
								</g:if>
								<g:if test="${patient?.personalInterestType.contains('Fundraising')}">
								<div class="border col-sm-3 col-xs-12 mar-bot-30 m-pad-lr"><input type="checkbox" value="${patient?.personalInterestType}" id="${patient?.id}" name="answer" class="checkboxSelect" />
								<label for="${patient?.id}" class="selectedLabels"><img class="img-responsive" src="../assets/profile/img/fundraising-img.jpg"></label></div>
								</g:if>
								</g:each>
								</g:if>
								<div class="clearfix"></div>
								<p class="text-regular">( You can choose one or multiple choices )</p>	
								</div>
								<div class="clearfix">&nbsp;</div>
								<div class="clearfix">&nbsp;</div>
								<g:link action="c9" class="back-link"><i class="back-arrow"></i>Back</g:link>
								<%--<a href="ca10.html" class="skip-text">Skip</a>
								--%>
								<g:submitButton name="NEXT" class="skip-text" />
								</g:form>
							</div>
							<div class="container container-950">
			<div class="prograss-bar pull-left">
				<div class="bar-text">11/12</div>
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
					<li class="active"></li>
					<li></li>
					<div class="per-text pull-right">20%</div>
				</ul>
				<p>1 more questions for 20% profile completion</p>				
				
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
			<div class="prograss-bar pull-left">
				<div class="bar-text">11/12</div>
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
					<li class="active"></li>
					<li></li>
					<div class="per-text pull-right">20%</div>
				</ul>
				<p>1 more questions for 20% profile completion</p>				
				
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