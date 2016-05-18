<%--<link href="../assets/profile/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="../assets/profile/css/colorbox.css" rel="stylesheet" type="text/css">
	<!-- Custom CSS -->
    <link href="../assets/profile/css/style.css" rel="stylesheet" type="text/css">
    <!-- Custom Fonts -->
    <link href="../assets/profile/css/font-awesome.min.css" rel="stylesheet" type="text/css">--%>
<div class="col-sm-12">
						<div class="profile-box-bg general-text pad-top-0">
							<div class="text-center">
								<div class="col-md-12 col-xs-12 center-align text-center m-pad-lr pad-lr-0">
								<h1>Gender identity (optional)</h1>
								<h2>If you choose to add gender identity, we will display that
					in place of sex on your profile.</h2>
								<div class="box-content2">
									<g:link controller="UpdateProfile" action="genderIdentity" params="[ans:'Female']"><g:if test="${value =='Female'}">
						<div class="changeActive box-content2-bg active" id="1">
					</g:if>
					<g:else>
						<div class="changeActive box-content2-bg" id="1">
					</g:else><h3><span>Female</span></h3></div></g:link>
								</div>
								<div class="box-content2">
									<g:link controller="UpdateProfile" action="genderIdentity" params="[ans:'Male']"><g:if test="${value =='Male'}">
					<div class="changeActive box-content2-bg active" id="2">
				</g:if>
				<g:else>
					<div class="changeActive box-content2-bg" id="2">
				</g:else><h3><span>Male</span></h3></div></g:link>
								</div>
								<div class="box-content2">
									<g:link controller="UpdateProfile" action="genderIdentity" params="[ans:'TransFemaleOrTranswoman']"><g:if test="${value =='TransFemale/ Transwoman'}">
				<div class="changeActive box-content2-bg active" id="3">
			</g:if>
			<g:else>
				<div class="changeActive box-content2-bg" id="3">
			</g:else><h3><span>TransFemale/ Transwoman</span></h3></div></g:link>
								</div>
								<div class="box-content2">
									<g:link controller="UpdateProfile" action="genderIdentity" params="[ans:'TransMaleOrTransman']"><g:if test="${value =='TransMale/ Transman'}">
			<div class="changeActive box-content2-bg active" id="4">
		</g:if>
		<g:else>
			<div class="changeActive box-content2-bg" id="4">
		</g:else><h3><span>TransMale/ Transman</span></h3></div></g:link>
								</div>
								<div class="box-content2">
									<g:link controller="UpdateProfile" action="genderIdentity" params="[ans:'Genderqueer']"><g:if test="${value =='Genderqueer'}">
				<div class="changeActive box-content2-bg active" id="5">
			</g:if>
			<g:else>
				<div class="changeActive box-content2-bg" id="5">
			</g:else><h3><span>Genderqueer</span></h3></div></g:link>
								</div>
								<div class="box-content2">
									<g:link controller="UpdateProfile" action="genderIdentity" params="[ans:'Something else']"><g:if test="${value =='Something else'}">
			<div class="changeActive box-content2-bg active" id="6">
		</g:if>
		<g:else>
			<div class="changeActive box-content2-bg" id="6">
		</g:else><h3><span>Something else</span></h3></div></g:link>
								</div>
							</div>
							</div>
							</div>
						</div>
<script src="../js/profile/profile.js"></script>