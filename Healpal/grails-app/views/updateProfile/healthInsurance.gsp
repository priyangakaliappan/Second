<%--<link href="../assets/profile/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="../assets/profile/css/colorbox.css" rel="stylesheet" type="text/css">
	<!-- Custom CSS -->
    <link href="../assets/profile/css/style.css" rel="stylesheet" type="text/css">
    <!-- Custom Fonts -->
    <link href="../assets/profile/css/font-awesome.min.css" rel="stylesheet" type="text/css">--%>

<g:form controller="updateProfile" action="healthInsurance"
	method="POST">
	<div class="col-sm-12">
						<div class="profile-box-bg">
							<div class="icon-box-top text-center"><img src="../assets/profile/img/c9-icon.jpg" /></div>
							<div class="text-center">
								<h1>Type of health insurance</h1>
									<div class="list-content">
									<g:if test="${healthInsurance}">
								<g:each in="${healthInsurance}" var="patient">
									<div class="col-md-6 col-xs-12 pad-lt-0 m-pad-rt">
										<ul>
											<g:if
										test="${value != null && value.contains(patient.healthInsuranceType)}">
										<li class="active"><input type="checkbox"
											value="${patient?.id}" id="${patient?.id}"
											name="healthInsurance" class="checkboxSelect"
											checked="checked" />
									</g:if>
									<g:else>
										<li><input type="checkbox" value="${patient?.id}"
											id="${patient?.id}" name="healthInsurance"
											class="checkboxSelect" />
									</g:else>
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
								<g:link class="skip-text"> <g:submitButton name="NEXT" /></g:link>
						</div>
					</div>
</g:form>
<script src="../js/profile/profile.js"></script>