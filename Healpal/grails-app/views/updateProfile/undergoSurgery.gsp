<%--<link href="../assets/profile/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="../assets/profile/css/colorbox.css" rel="stylesheet" type="text/css">
	<!-- Custom CSS -->
    <link href="../assets/profile/css/style.css" rel="stylesheet" type="text/css">
    <!-- Custom Fonts -->
    <link href="../assets/profile/css/font-awesome.min.css" rel="stylesheet" type="text/css">--%>
<div class="col-sm-12">
						<div class="profile-box-bg highest-box">
							<div class="col-md-12 col-xs-12 center-align text-center pad-lr-0">
								<div class="icon-box-top"><img src="../assets/icon/e1-icon.jpg" /></div>
								<h2>Did you undergo surgery for your cancer?</h2>
								<div class="box-content2">
									<g:if test="${value == 'Yes'}">
					<div class="changeActive box-content2-bg active" id="1">
				</g:if>
				<g:else>
					<div class="changeActive box-content2-bg" id="1">
				</g:else>
				<%--<g:link controller="updateProfile" action="undergoSurgery" params="[ans: 'Yes']"><h3><span>Yes</span></h3></g:link>
								--%>
				<a class="answer_link" id="Yes" style="cursor: pointer;"><h3><span>Yes</span></h3></a></div>
								</div>
								<div class="box-content2">
									<g:if test="${value == 'No'}">
				<div class="changeActive box-content2-bg active" id="2">
			</g:if>
			<g:else>
				<div class="changeActive box-content2-bg" id="2">
			</g:else>
			<g:link controller="updateProfile" action="undergoSurgery"
				params="[ans: 'No']"><h3><span>No</span></h3></g:link></div>
								</div>
								<div class="box-content2">
									<g:if test="${value == 'Scheduled for surgery'}">
			<div class="changeActive box-content2-bg active" id="3">
		</g:if>
		<g:else>
			<div class="changeActive box-content2-bg" id="3">
		</g:else>
		<g:link controller="updateProfile" action="undergoSurgery"
			params="[ans: 'Scheduled for surgery']"><h3><span>Scheduled for surgery</span></h3></g:link></div>
								</div>
							</div>
							</div>
						</div>
<script src="../js/profile/profile.js"></script>
<script>
					// To open pop up whech click 'Yes' option
		$(document).on('click','.answer_link',function(){
			if($(this).attr('id') != ""){
					var url="../UpdateProfile/surgicalProcedureType?answer="+$(this).attr('id');
					$("#myModal .modal-body").load(url);
				
			}
			});

		</script>