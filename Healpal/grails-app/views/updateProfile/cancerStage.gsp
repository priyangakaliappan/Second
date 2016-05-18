<%--<link href="../assets/profile/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="../assets/profile/css/colorbox.css" rel="stylesheet" type="text/css">
	<!-- Custom CSS -->
    <link href="../assets/profile/css/style.css" rel="stylesheet" type="text/css">
    <!-- Custom Fonts -->
    <link href="../assets/profile/css/font-awesome.min.css" rel="stylesheet" type="text/css">
--%><div class="col-sm-12">
						<div class="profile-box-bg pad-top-0 highest-box">
								<div class="col-md-12 col-xs-12 m-pad-lr pad-lr-0">
								<h1>Stage of cancer</h1>
								<div class="box-content2">
								
									<g:link controller="UpdateProfile" action="cancerStage" params="[ans:'I']">
									<g:if test="${value =='I'}">
									<div class="changeActive box-content2-bg active" id="1">
									</g:if>
								<g:else>
								<div class="changeActive box-content2-bg" id="1">
								</g:else>
									<h3><span>I</span></h3></div></g:link>
								</div>
								<div class="box-content2">
									<g:link controller="UpdateProfile" action="cancerStage" params="[ans:'II']">
									
									<g:if test="${value =='II'}">
				<div class="changeActive box-content2-bg active" id="2">
			</g:if>
			<g:else>
				<div class="changeActive box-content2-bg" id="2">
			</g:else><h3><span>II</span></h3></div></g:link>
								</div>
								<div class="box-content2">
									<g:link controller="UpdateProfile" action="cancerStage" params="[ans:'IIA']">
									
									<g:if test="${value =='IIA'}">
			<div class="changeActive box-content2-bg active" id="3">
		</g:if>
		<g:else>
			<div class="changeActive box-content2-bg" id="3">
		</g:else><h3><span>IIA</span></h3></div></g:link>
								</div>
								<div class="box-content2">
									<g:link controller="UpdateProfile" action="cancerStage" params="[ans:'IIB']">
									
									<g:if test="${value =='IIB'}">
		<div class="changeActive box-content2-bg active" id="4">
	</g:if>
	<g:else>
		<div class="changeActive box-content2-bg" id="4">
	</g:else><h3><span>IIB</span></h3></div></g:link>
								</div>
								<div class="box-content2">
									<g:link controller="UpdateProfile" action="cancerStage" params="[ans:'IIIA']">
									
									<g:if test="${value =='IIIA'}">
		<div class="changeActive box-content2-bg active" id="5">
	</g:if>
	<g:else>
		<div class="changeActive box-content2-bg" id="5">
	</g:else><h3><span>IIIA</span></h3></div></g:link>
								</div>
								<div class="box-content2">
									<g:link controller="UpdateProfile" action="cancerStage" params="[ans:'IIIC']">
									
									<g:if test="${value =='IIIC'}">
		<div class="changeActive box-content2-bg active" id="6">
	</g:if>
	<g:else>
		<div class="changeActive box-content2-bg" id="6">
	</g:else><h3><span>IIIC</span></h3></div></g:link>
								</div>
								<div class="box-content2" >
									<g:link controller="UpdateProfile" action="cancerStage" params="[ans:'IV']">
									<g:if test="${value =='IV'}">
		<div class="changeActive box-content2-bg active" id="7">
	</g:if>
	<g:else>
		<div class="changeActive box-content2-bg" id="7">
	</g:else><h3><span>IV</span></h3></div></g:link>
								</div>
								<div class="box-content2">
									<g:link controller="UpdateProfile" action="cancerStage" params="[ans:'Recurrent']">
									
									<g:if test="${value =='Recurrent'}">
		<div class="changeActive box-content2-bg active" id="8">
	</g:if>
	<g:else>
		<div class="changeActive box-content2-bg" id="8">
	</g:else><h3><span>Recurrent</span></h3></div></g:link>
								</div>
								<div class="box-content2">
									<g:link controller="UpdateProfile" action="cancerStage" params="[ans:'Not sure']">
									<g:if test="${value =='Not sure'}">
		<div class="changeActive box-content2-bg active" id="9">
	</g:if>
	<g:else>
		<div class="changeActive box-content2-bg" id="9">
	</g:else><h3><span>Not sure</span></h3></div></g:link>
								</div>
								<div class="box-content2">
									<g:link controller="UpdateProfile" action="cancerStage" params="[ans:'Dont know']">
									
									<g:if test="${value =='Dont know'}">
		<div class="changeActive box-content2-bg active" id="10">
	</g:if>
	<g:else>
		<div class="changeActive box-content2-bg" id="10">
	</g:else><h3><span>Don't know</span></h3></div></g:link>
								</div>
							</div>
							</div>
						</div>
<script src="../js/profile/profile.js"></script>