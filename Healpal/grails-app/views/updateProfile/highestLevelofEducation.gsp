<%--<link href="../assets/profile/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="../assets/profile/css/colorbox.css" rel="stylesheet" type="text/css">
	<!-- Custom CSS -->
    <link href="../assets/profile/css/style.css" rel="stylesheet" type="text/css">
    <!-- Custom Fonts -->
    <link href="../assets/profile/css/font-awesome.min.css" rel="stylesheet" type="text/css">--%>

<div class="col-sm-12">
						<div class="profile-box-bg highest-box">
							
							<div class="icon-box-top text-center"><img src="../assets/icon/c8-icon.jpg" /></div>
								<div class="col-md-12 col-xs-12 m-pad-lr pad-lr-0">
								<h1>Highest level of education</h1>
								<g:if test="${education}">
								<g:each status="i" in="${education}" var="patient">
								<div class="box-content2">
									<g:link controller="updateProfile" action="highestLevelofEducation"
								params="${[educationId:patient?.id]}"><g:if
									test="${value !="" && value !=null && value == patient?.educationType}">
									<div class="changeActive box-content2-bg active"
										id="${patient?.id}">
								</g:if>
								<g:else>
									<div class="changeActive box-content2-bg" id="${patient?.id}">
								</g:else><h3><span>${patient?.educationType}</span></h3></div></g:link>
								</div>
								</g:each>
								</g:if>
							</div>
							</div>
							<br/>
							</div>
						
<script src="../js/profile/profile.js"></script>