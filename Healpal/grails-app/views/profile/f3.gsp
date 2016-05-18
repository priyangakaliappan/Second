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
		<g:form action="f3" method="post">
			<div class="col-sm-12">
						<div class="profile-box-bg">
							<div class="text-center">
							<div class="icon-box-top"><img src="../assets/profile/img/f1-icon.jpg" /></div>
								<h3 class="pad-bot-0">Please choose the combination chemotherapy administered to you</h3>
								<div class="list-content">
									<ul>
									<g:if test="${combinationChemotheraphy }">
								<input type="hidden" value="Please choose the combination chemotherapy administered to you" name="question">
								<g:each in="${combinationChemotheraphy}" var="patient">
										<li>
											<input type="checkbox" value="${patient?.combinationChemotherapyDrugsName}" id="${patient?.id}" name="combinechemotherapy" class="checkboxSelect" />
											<label for="${patient?.id}" class="selectedLabels"> ${patient?.combinationChemotherapyDrugsName	} </label>
										</li>
										</g:each></g:if>
									</ul>
									<div class="clearfix mar-bot-20"></div>
									<p>( You can select one or multiple choices )</p>
								</div>
								</div>
								<div class="clearfix">&nbsp;</div>
								<div class="clearfix">&nbsp;</div>
								<g:link controller="Profile" action="f2" class="back-link"><i class="back-arrow"></i>Back</g:link>
					<g:hiddenField name="selectedDrugs" id="selectedDrugs"/>
					<g:link class="skip-text"><g:submitButton name="NEXT" /></g:link>
							</div>
							<div class="container container-950">
			<div class="prograss-bar bar-20-slider pull-left">
				<div class="bar-text">18/19</div>
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
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li></li>
					<div class="per-text pull-right">50%</div>
				</ul>
				<p>1 more questions for 50% profile completion</p>				
				
			</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
		</div>
						</div>
		</g:form></div></div></section>
		<%--<section>
		<div class="container container-950">
			<div class="prograss-bar bar-20-slider pull-left">
				<div class="bar-text">18/19</div>
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
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li></li>
					<div class="per-text pull-right">50%</div>
				</ul>
				<p>1 more questions for 50% profile completion</p>				
				
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
