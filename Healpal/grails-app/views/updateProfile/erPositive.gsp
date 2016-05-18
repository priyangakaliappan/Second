<%--<link href="../assets/profile/css/bootstrap.min.css" rel="stylesheet" 
type="text/css">
    <link href="../assets/profile/css/colorbox.css" rel="stylesheet" type="text/css">
	<!-- Custom CSS -->
    <link href="../assets/profile/css/style.css" rel="stylesheet" type="text/css">
    <!-- Custom Fonts -->
    <link href="../assets/profile/css/font-awesome.min.css" rel="stylesheet" 
type="text/css">
--%><div class="col-sm-12">
						<div class="profile-box-bg highest-box">
							<div class="col-md-12 col-xs-12 center-align text-center pad-lr-0">
								<div class="icon-box-top"><img src="../assets/icon/d6-icon.jpg" /></div>
								<h2>ER positive</h2>
								<div class="box-content2">
									<g:if test="${value == 'Yes'}">
					<div class="changeActive box-content2-bg active" id="1">
				</g:if>
				<g:else>
					<div class="changeActive box-content2-bg" id="1">
				</g:else><g:link controller="updateProfile" action="updatePositive"
								params="[type:'ER',value:'Yes']"><h3><span>Yes</span></h3></g:link></div>
								</div>
								<div class="box-content2">
									<g:if test="${value == 'No'}">
				<div class="changeActive box-content2-bg active" id="2">
			</g:if>
			<g:else>
				<div class="changeActive box-content2-bg" id="2">
			</g:else><g:link controller="updateProfile" action="updatePositive"
								params="[type:'ER',value:'No']"><h3><span>No</span></h3></g:link></div>
								</div>
								<div class="box-content2">
									<g:if test="${value == 'Dont Know'}">
			<div class="changeActive box-content2-bg active" id="3">
		</g:if>
		<g:else>
			<div class="changeActive box-content2-bg" id="3">
		</g:else><g:link controller="updateProfile" action="updatePositive"
								params="[type:'ER',value:'Dont Know']"><h3><span>Don't know</span></h3></g:link></div>
								</div>
							</div>
							</div>
						</div>
	<script type="text/javascript"
		src="${resource(dir:'js',file:'jquery-1.10.2.js')}"></script>
	<script src="${resource(dir:'js/profile',file:'profile.js')}"></script>
<script src="../js/profile/profile.js"></script>