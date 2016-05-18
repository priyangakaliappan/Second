<%--<link href="../assets/profile/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="../assets/profile/css/colorbox.css" rel="stylesheet" type="text/css">
	<!-- Custom CSS -->
    <link href="../assets/profile/css/style.css" rel="stylesheet" type="text/css">
    <!-- Custom Fonts -->
    <link href="../assets/profile/css/font-awesome.min.css" rel="stylesheet" type="text/css">--%>
<div class="col-sm-12">
						<div class="profile-box-bg highest-box">
							<div class="col-md-12 col-xs-12 center-align text-center pad-lr-0">
								<div class="icon-box-top"><img src="../assets/profile/img/da10-icon.jpg" /></div>
								<h2>Pathology biopsy tumor type</h2>
								<div class="box-content2">
									<g:if test="${value == 'I know for sure'}">
					<div class="changeActive box-content2-bg active" id="1">
				</g:if>
				<g:else>
					<div class="changeActive box-content2-bg" id="1">
				</g:else><g:link controller="updateProfile" action="pathologyType1"
					params="[ans: 'I know for sure']"><h3><span>I know for sure</span></h3></g:link></div>
								</div>
								<div class="box-content2">
									<g:if test="${value == 'Biopsy performed but I do not know'}">
				<div class="changeActive box-content2-bg active" id="2">
			</g:if>
			<g:else>
				<div class="changeActive box-content2-bg" id="2">
			</g:else><g:link controller="updateProfile" action="pathologyType1"
				params="[ans: 'Biopsy performed but I do not know']"><h3><span>Biopsy performed but I do not know</span></h3></g:link></div>
								</div>
								<div class="box-content2">
									<g:if test="${value == 'Biopsy performed, results awaited'}">
			<div class="changeActive box-content2-bg active" id="3">
		</g:if>
		<g:else>
			<div class="changeActive box-content2-bg" id="3">
		</g:else><g:link controller="updateProfile" action="pathologyType1"
			params="[ans: 'Biopsy performed, results awaited']"><h3><span>Biopsy performed, results awaited</span></h3></g:link></div>
								</div>
							</div>
								<p class="note-text">(Please note: This is a very important question for the match process. If you are not sure or are still awating the results of your biopsy, you can confirm the results and updates the information in your profile.)</p>
							</div>
						</div>

<script src="../js/profile/profile.js"></script>