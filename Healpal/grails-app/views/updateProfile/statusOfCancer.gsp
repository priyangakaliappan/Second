<%--<link href="../assets/profile/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="../assets/profile/css/colorbox.css" rel="stylesheet" type="text/css">
	<!-- Custom CSS -->
    <link href="../assets/profile/css/style.css" rel="stylesheet" type="text/css">
    <!-- Custom Fonts -->
    <link href="../assets/profile/css/font-awesome.min.css" rel="stylesheet" type="text/css">--%>
<div class="col-sm-12">
	<div class="profile-box-bg pad-top-0">
		<div class="text-center">
			<h1>Describe the current status of your cancer</h1>
			<g:if test="${cancerStatusList}">
				<g:each status="i" in="${cancerStatusList}" var="cancer">
					<div class="list-content">
						<ul>
							<g:if test="${value == cancer.cancerStatusType}">
								<li class="active">
							</g:if>
							<g:else>
								<li>
							</g:else>
							<g:link controller="updateProfile" action="statusOfCancer"
								params="${[value:cancer.id]}">
								${cancer.cancerStatusType}
							</g:link>
							</li>
						</ul>
					</div>
				</g:each>
			</g:if>
		</div>
	</div>
</div>
