<%--<link href="../assets/profile/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="../assets/profile/css/colorbox.css" rel="stylesheet" type="text/css">
	<!-- Custom CSS -->
    <link href="../assets/profile/css/style.css" rel="stylesheet" type="text/css">
    <!-- Custom Fonts -->
    <link href="../assets/profile/css/font-awesome.min.css" rel="stylesheet" type="text/css">--%>
<div class="col-sm-12">
						<div class="profile-box-bg pad-top-0">
						<g:form controller="updateProfile" action="personalInterest" method="post">
				<input type="hidden" value="I am interested in" name="question">
							<div class="text-center">
								<h1 class="m-img-text" style=" padding-bottom:35px;">I am interested in</h1>
								<div class="clearfix mar-bot-50"></div>
								<g:if test="${personalInterest}">
							<g:each in="${personalInterest}" var="patient">
							<g:if test="${patient?.personalInterestType.contains('Advocacy')}">
								<div class="border col-sm-3 col-xs-12 mar-bot-30 m-pad-lr"><g:if test="${value != null && value.contains('Advocacy')}">
									<input type="checkbox" value="${patient?.personalInterestType}"
										id="${patient?.id}" name="answer" class="checkboxSelect" checked="checked" />
									<label for="${patient?.id}" class="img-border"
										style="cursor: pointer;">
								</g:if>
								<g:else>
									<input type="checkbox" value="${patient?.personalInterestType}"
										id="${patient?.id}" name="answer" class="checkboxSelect" />
									<label for="${patient?.id}" style="cursor: pointer;">
								</g:else><div class="profile-box-image"><img class="img-responsive" src="../assets/profile/img/advocacy-img.jpg"></div></label></div>
								</g:if>
								<g:if test="${patient?.personalInterestType.contains('Research')}">
								<div class="border col-sm-3 col-xs-12 mar-bot-30 m-pad-lr"><g:if test="${value != null && value.contains('Research')}">
									<input type="checkbox" value="${patient?.personalInterestType}"
										id="${patient?.id}" name="answer" class="checkboxSelect" checked="checked" />
									<label for="${patient?.id}" class="img-border img-bor1"
										style="cursor: pointer;">
								</g:if>
								<g:else>
									<input type="checkbox" value="${patient?.personalInterestType}"
										id="${patient?.id}" name="answer" class="checkboxSelect" />
									<label for="${patient?.id}" style="cursor: pointer;">
								</g:else><div class="profile-box-image"><img class="img-responsive" src="../assets/profile/img/research-img.jpg"></div></label></div>
								</g:if>
								<g:if test="${patient?.personalInterestType.contains('Alternative Medicine')}">
								<div class="border col-sm-3 col-xs-12 mar-bot-30 m-pad-lr"><g:if
									test="${value != null && value.contains('Alternative Medicine')}">
									<input type="checkbox" value="${patient?.personalInterestType}"
										id="${patient?.id}" name="answer" class="checkboxSelect" checked="checked" />
									<label for="${patient?.id}" class="img-border img-bor2"
										style="cursor: pointer;">
								</g:if>
								<g:else>
									<input type="checkbox" value="${patient?.personalInterestType}"
										id="${patient?.id}" name="answer" class="checkboxSelect" />
									<label for="${patient?.id}" style="cursor: pointer;">
								</g:else><div class="profile-box-image"><img class="img-responsive" src="../assets/profile/img/medicine-img.jpg"></div></label></div>
								</g:if>
								<g:if test="${patient?.personalInterestType.contains('Fundraising')}">
								<div class="border col-sm-3 col-xs-12 mar-bot-30 m-pad-lr"><g:if test="${value != null && value.contains('Fundraising')}">
									<input type="checkbox" value="${patient?.personalInterestType}"
										id="${patient?.id}" name="answer" class="checkboxSelect" checked="checked" />
									<label for="${patient?.id}" class="img-border img-bor3"
										style="cursor: pointer;">
								</g:if>
								<g:else>
									<input type="checkbox" value="${patient?.personalInterestType}"
										id="${patient?.id}" name="answer" class="checkboxSelect" />
									<label for="${patient?.id}" style="cursor: pointer;">
								</g:else><div class="profile-box-image"><img class="img-responsive" src="../assets/profile/img/fundraising-img.jpg"></div></label></div>
								</g:if>
								</g:each>
								</g:if>
								<div class="clearfix"></div>
								<p class="text-regular">( You can choose one or multiple choices )</p>	
								</div>
								<%--<a href="ca10.html" class="skip-text">Skip</a>
								--%>
								<g:submitButton name="NEXT" class="skip-text" />
								</g:form>
							</div>
							
							</div>
<script src="../js/profile/profile.js"></script>