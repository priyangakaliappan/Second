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
		<g:form action="l3" method="POST">
			<div class="col-sm-12">
						<div class="profile-box-bg">
							<div class="icon-box-top text-center"><img src="${resource(dir:'assets/icon',file:'l1-icon.jpg')}" /></div>
							<div class="text-center">
								<h1>Please choose any associated medical conditions</h1>
									<div class="list-content">
									<g:if test="${medicalConditionList}">
								<g:each in="${medicalConditionList}" var="medical">
									<div class="col-md-6 col-xs-12 pad-lt-0 m-pad-rt">
										<ul>
											<li>
											<g:if test="${medical.medicalConditionType == 'Other Cancer; please specify'}">
													<input type="checkbox" value="${medical.medicalConditionType}" id="${medical.id}" name="othercancer" class="checkboxSelect" onclick="cancer();" />
												</g:if>
												<g:elseif test="${medical.medicalConditionType == 'Other Medical Condition'}">
													<input type="checkbox" value="${medical.medicalConditionType}" id="${medical.id}" name="othermedical" class="checkboxSelect" onclick="medical();"/>
												</g:elseif>
												<g:else>
													<input type="checkbox" value="${medical.id}" id="${medical.id}" name="medicalCondition" class="checkboxSelect" />
												</g:else>
												<label for="${medical?.id}" class="selectedLabels"> ${medical.medicalConditionType}</label>
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
								<input type="text" name="otherCancer" id="otherCancer" style="display: inline; font-size: 16px; height: 41px; width: 356px;">
						<input type="text" name="otherMedical" id="otherMedical" style="display: inline; font-size: 16px; height: 41px; width: 356px;">
								<div class="clearfix mar-bot-30"></div>
								
								<p class="multiple-text">( You can select one or multiple choices )</p>
								</div>
								<div class="clearfix">&nbsp;</div>
								<div class="clearfix">&nbsp;</div>
								<g:link action="l1" class="back-link"> <i class="back-arrow"></i>Back</g:link>
					<g:link class="skip-text"> <g:submitButton name="NEXT"/></g:link>
						</div>
						<div class="container container-950">
			<div class="prograss-bar bar-3-slider pull-left">
				<div class="bar-text">3/3</div>
				<ul>
					<div class="per-text pull-left">80%</div>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<div class="per-text pull-right">100%</div>
				</ul>
				<p>0 more questions for 100% profile completion</p>				
				
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
			<div class="prograss-bar bar-3-slider pull-left">
				<div class="bar-text">3/3</div>
				<ul>
					<div class="per-text pull-left">80%</div>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<div class="per-text pull-right">100%</div>
				</ul>
				<p>0 more questions for 100% profile completion</p>				
				
			</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
		</div>
		</section>
	--%><script type="text/javascript">
		$(document).ready(function() {
			$("#otherCancer").hide();
			$("#otherMedical").hide();
		});
		function cancer() {
			$("#otherCancer").toggle();
		}
		function medical(){
			$("#otherMedical").toggle();
			}
		
	</script>
</body>
</html>