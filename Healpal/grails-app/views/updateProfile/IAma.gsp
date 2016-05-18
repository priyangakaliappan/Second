<%--<link href="../assets/profile/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="../assets/profile/css/colorbox.css" rel="stylesheet" type="text/css">
	<!-- Custom CSS -->
    <link href="../assets/profile/css/style.css" rel="stylesheet" type="text/css">
    <!-- Custom Fonts -->
    <link href="../assets/profile/css/font-awesome.min.css" rel="stylesheet" type="text/css">--%>

<div class="col-sm-12">
						<div class="profile-box-bg highest-box pad-top-0">
								<div class="col-md-12 col-xs-12 m-pad-lr pad-lr-0">
								<h1>I am a</h1>
								<g:if test="${iamList}">
								<g:each status="i" in="${iamList}" var="iam" >
								<div class="box-content2">
									<g:link controller="updateProfile" action="IAma" params="${[iAm:iam.id]}"><g:if test="${value == iam.aboutYouName }">
								<div class="changeActive box-content2-bg active" id="${iam?.id}">
							</g:if>
							<g:else>
								<div class="changeActive box-content2-bg" id="${iam?.id}">
							</g:else><h3><span>${iam.aboutYouName}</span></h3></div></g:link>
								</div>
								</g:each>
								</g:if>
							</div>
							</div>
						</div>
<script src="../js/profile/profile.js"></script>