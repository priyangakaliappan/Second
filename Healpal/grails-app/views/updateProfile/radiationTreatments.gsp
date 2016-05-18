<%--<link href="../assets/profile/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="../assets/profile/css/colorbox.css" rel="stylesheet" type="text/css">
	<!-- Custom CSS -->
    <link href="../assets/profile/css/style.css" rel="stylesheet" type="text/css">
    <!-- Custom Fonts -->
    <link href="../assets/profile/css/font-awesome.min.css" rel="stylesheet" type="text/css">--%>
<div class="col-sm-12">
						<div class="profile-box-bg">
							<div class="text-center">
							<div class="icon-box-top"><img src="../assets/icon/i1-icon.jpg" /></div>
								<h3 class="pad-bot-0" style="font-family: 'Opensans Light';font-size: 22px;">Which type of radiation treatment did you receive or are scheduled to receive</h3>
								<div class="list-content">
									<ul>
										<g:if test="${value == 'External radiation' }">
						<li class="active">
					</g:if>
					<g:else>
						<li>
					</g:else>
					<g:link controller="updateProfile" action="radiationTreatments"
						params="[ans: 'External radiation']">External radiation</g:link></li>
										<g:if test="${value == 'Internal radiation' }">
						<li class="active">
					</g:if>
					<g:else>
						<li>
					</g:else>
					<g:link controller="updateProfile" action="radiationTreatments"
						params="[ans: 'Internal radiation']">Internal radiation</g:link></li>
										<g:if test="${value == 'Brachytheraphy' }">
						<li class="active">
					</g:if>
					<g:else>
						<li>
					</g:else>
					<g:link controller="updateProfile" action="radiationTreatments"
						params="[ans: 'Brachytherapy']">Brachytherapy</g:link></li>
										<g:if test="${value == 'Radiation boost' }">
						<li class="active">
					</g:if>
					<g:else>
						<li>
					</g:else>
					<g:link controller="updateProfile" action="radiationTreatments"
						params="[ans: 'Radiation boost']">Radiation boost</g:link></li>
										<g:if
						test="${value == 'Accelerated, hypofractionated whole breast irradiation' }">
						<li class="active">
					</g:if>
					<g:else>
						<li>
					</g:else>
					<g:link controller="updateProfile" action="radiationTreatments"
						params="[ans: 'Accelerated, hypofractionated whole breast irradiation']">Accelerated, hypofractionated whole breast irradiation</g:link></li>
									</ul>
									<div class="clearfix mar-bot-20"></div>
								</div>
								</div>
							</div>
						</div>