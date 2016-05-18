<%--<link href="../assets/profile/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="../assets/profile/css/colorbox.css" rel="stylesheet" type="text/css">
	<!-- Custom CSS -->
    <link href="../assets/profile/css/style.css" rel="stylesheet" type="text/css">
    <!-- Custom Fonts -->
    <link href="../assets/profile/css/font-awesome.min.css" rel="stylesheet" type="text/css">--%>

<div class="col-sm-12">
	<div class="profile-box-bg general-text">
			<g:form controller="updateProfile" action="medicalConditions">
							<div class="icon-box-top text-center"><img src="${resource(dir:'assets/icon',file:'l1-icon.jpg')}" /></div>
							<div class="text-center">
								<h1>Please choose any associated medical conditions</h1>
									<div class="list-content">
									<g:if test="${medicalConditionList}">
								<g:each in="${medicalConditionList}" var="medical">
									<div class="col-md-6 col-xs-12 pad-lt-0 m-pad-rt">
										<ul>
											<g:if
										test="${value != null && value.contains(medical.medicalConditionType)}">
										<li class="active">
											<g:if test="${medical.medicalConditionType == 'Other Cancer; please specify'}">
													<input type="checkbox" value="${medical.medicalConditionType}" id="${medical.id}" name="othercancer" class="checkboxSelect" onclick="otherscancer();" />
												</g:if>
												<g:elseif test="${medical.medicalConditionType == 'Other Medical Condition'}">
													<input type="checkbox" value="${medical.medicalConditionType}" id="${medical.id}" name="othermedical" class="checkboxSelect" onclick="othersmedical();"/>
												</g:elseif>
												<g:else>
													<input type="checkbox" value="${medical.id}" id="${medical.id}" name="medicalCondition" class="checkboxSelect" checked="checked"/>
												</g:else>
												</g:if>
									<g:else>
										<li><g:if
												test="${medical.medicalConditionType == 'Other Cancer ; please specify'}">
												<input type="checkbox"
													value="${medical.medicalConditionType}" id="${medical.id}"
													name="othercancer" class="checkboxSelect"
													onclick="otherscancer();" />
											</g:if> <g:elseif
												test="${medical.medicalConditionType == 'Other Medical Condition'}">
												<input type="checkbox"
													value="${medical.medicalConditionType}" id="${medical.id}"
													name="othermedical" class="checkboxSelect"
													onclick="othersmedical();" />
											</g:elseif> <g:else>
												<input type="checkbox" name="medicalCondition"
													id="${medical.id}" value="${medical.id}"
													class="checkboxSelect">
											</g:else>
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
								<input type="text" name="otherCancer" id="otherCancer" style="height: 45px; ">
						<input type="text" name="otherMedical" id="otherMedical" style="height: 45px; ">
								<div class="clearfix mar-bot-30"></div>
								<p class="multiple-text">( You can select one or multiple choices )</p>
								</div>
					<g:link class="skip-text"><g:submitButton name="NEXT" /> </g:link>
			</g:form>
		</div>

	</div>
<script src="../js/profile/profile.js"></script>
<script type="text/javascript">
	/*
	 * To add own anser for other option
	 */
	$(document).ready(function() {
		$("#otherCancer").hide();
		$("#otherMedical").hide();
	});
	function otherscancer() {
		$("#otherCancer").toggle();
	}
	function othersmedical() {
		$("#otherMedical").toggle();
	}
</script>