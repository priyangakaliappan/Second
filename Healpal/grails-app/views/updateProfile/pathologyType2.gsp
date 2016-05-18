<%--<link href="../assets/profile/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="../assets/profile/css/colorbox.css" rel="stylesheet" type="text/css">
	<!-- Custom CSS -->
    <link href="../assets/profile/css/style.css" rel="stylesheet" type="text/css">
    <!-- Custom Fonts -->
    <link href="../assets/profile/css/font-awesome.min.css" rel="stylesheet" type="text/css">--%>
<div class="col-sm-12">
						<div class="profile-box-bg highest-box pad-top-0">
								<div class="col-md-12 col-xs-12 m-pad-lr pad-lr-0">
								<h1>Pathology biopsy tumor type</h1>
								<div class="box-content2">
								<g:if test="${value == 'Ductal carcinoma in situ'}">
					<div class="changeActive box-content2-bg active" id="1">
				</g:if>
				<g:else>
					<div class="changeActive box-content2-bg" id="1">
				</g:else><g:link controller="updateProfile" action="pathologyType2" params="[answer: 'Ductal carcinoma in situ']"><h3><span>Ductal carcinoma <br>in situ</span></h3></g:link></div>
								</div>
								<div class="box-content2">
									<g:if test="${value == 'Invasive or infiltrating Ductal carcinoma'}">
				<div class="changeActive box-content2-bg active" id="2">
			</g:if>
			<g:else>
				<div class="changeActive box-content2-bg" id="2">
			</g:else><g:link controller="updateProfile" action="pathologyType2" params="[answer: 'Invasive or infiltrating Ductal carcinoma']"><h3><span>Invasive or infiltrating Ductal carcinoma</span></h3></g:link></div>
								</div>
								<div class="box-content2">
									<g:if test="${value == 'Invasive or infiltrating Lobular carcinoma'}">
			<div class="changeActive box-content2-bg active" id="3">
		</g:if>
		<g:else>
			<div class="changeActive box-content2-bg" id="3">
		</g:else><g:link controller="updateProfile" action="pathologyType2" params="[answer: 'Invasive or infiltrating Lobular carcinoma']"><h3><span>Invasive or infiltrating Lobular carcinoma</span></h3></g:link></div>
								</div>
								<div class="box-content2">
									<g:if test="${value == 'Inflamma-tory breast cancer'}">
		<div class="changeActive box-content2-bg active" id="4">
	</g:if>
	<g:else>
		<div class="changeActive box-content2-bg" id="4">
	</g:else><g:link controller="updateProfile" action="pathologyType2" params="[answer: 'Inflamma-tory breast cancer']"><h3><span>Inflamma-tory breast cancer</span></h3></g:link></div>
								</div>
								<div class="box-content2">
		<g:if test="${value == 'Paget disease of the nipple'}">
			<div class="changeActive box-content2-bg active" id="5">
		</g:if>
		<g:else>
			<div class="changeActive box-content2-bg" id="5">
		</g:else><g:link controller="updateProfile" action="pathologyType2" params="[answer: 'Paget disease of the nipple']"><h3><span>Paget disease of the nipple</span></h3></g:link></div>
								</div>
								<div class="box-content2">
									<g:if test="${value == 'Phyllodes tumor'}">
		<div class="changeActive box-content2-bg active" id="6">
	</g:if>
	<g:else>
		<div class="changeActive box-content2-bg" id="6">
	</g:else><g:link controller="updateProfile" action="pathologyType2" params="[answer: 'Phyllodes tumor']"><h3><span>Phyllodes<br>tumor</span></h3></g:link></div>
								</div>
								<div class="box-content2">
									<g:if test="${value == 'Angio-sarcoma'}">
		<div class="changeActive box-content2-bg active" id="7">
	</g:if>
	<g:else>
		<div class="changeActive box-content2-bg" id="7">
	</g:else><g:link controller="updateProfile" action="pathologyType2" params="[answer: 'Angio-sarcoma']"><h3><span>Angio-<br>sarcoma</span></h3></g:link></div>
</div>								
<p class="note-text">(Please note: This is a very important question for the match process. If you are not sure or are still awating the results of your biopsy, you can confirm the results and updates the information in your profile.)</p>
							
<script src="../js/profile/profile.js"></script>