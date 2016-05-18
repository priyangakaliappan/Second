<%--<link href="../assets/profile/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="../assets/profile/css/colorbox.css" rel="stylesheet" type="text/css">
	<!-- Custom CSS -->
    <link href="../assets/profile/css/style.css" rel="stylesheet" type="text/css">
    <!-- Custom Fonts -->
    <link href="../assets/profile/css/font-awesome.min.css" rel="stylesheet" type="text/css">
--%><g:form controller="updateProfile" action="chemotherapyDrugs"
	method="post">
	<div class="col-sm-12">
						<div class="profile-box-bg general-text">
							<div class="icon-box-top text-center"><img src="${resource(dir:'assets/icon',file:'f1-icon.jpg')}" /></div>
							<div class="text-center">
								<h1>Please choose the chemotherapy drug <br> or drugs given to
							you</h1>
									<div class="list-content">
									<g:if test="${chemotheraphy }">
								<input type="hidden" value="Please choose the chemotherapy drug or drugs given to you" name="question">
								<g:each in="${chemotheraphy}" var="patient">
									<div class="col-md-6 col-xs-12 pad-lt-0 m-pad-rt">
										<ul>
										<g:if
										test="${value != null && value.contains(patient?.chemotherapyDrugsType) }">
											<li class="active"><input type="checkbox" value="${patient?.chemotherapyDrugsType}" id="${patient?.id}" name="chemotherapy" class="checkboxSelect" checked="checked" />
											</g:if>
									<g:else>
										<li><input type="checkbox"
											value="${patient?.chemotherapyDrugsType}" id="${patient?.id}"
											name="chemotherapy" class="checkboxSelect" />
									</g:else>
												<label for="${patient?.id}" class="selectedLabels"> ${patient?.chemotherapyDrugsType}</label>
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
					<g:link class="skip-text">
						<g:submitButton name="NEXT" /></g:link>
						</div>
					</div>
</g:form>
<script src="../js/profile/profile.js"></script>