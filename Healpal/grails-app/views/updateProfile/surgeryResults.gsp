<%--<link href="../assets/profile/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="../assets/profile/css/colorbox.css" rel="stylesheet" type="text/css">
	<!-- Custom CSS -->
    <link href="../assets/profile/css/style.css" rel="stylesheet" type="text/css">
    <!-- Custom Fonts -->
    <link href="../assets/profile/css/font-awesome.min.css" rel="stylesheet" type="text/css">--%>
<div class="col-sm-12">
						<div class="profile-box-bg general-text">
							<div class="icon-box-top text-center"><img src="../assets/icon/e1-icon.jpg" /></div>
							<div class="text-center">
								<h1>Results of your surgery</h1>
									<div class="list-content">
									<div class="col-md-6 col-xs-12 pad-lt-0 m-pad-rt">
										<ul>
											<g:if test="${value == 'Successful. Results as expected'}">
							<li class="active">
						</g:if>
						<g:else>
							<li>
						</g:else><g:link controller="updateProfile" action="surgeryResults"
							params="[ans: 'Successful. Results as expected']">Successful. Results as expected</g:link></li>
											<g:if
							test="${value == 'No significant impact to daily lifestyle'}">
							<li class="active">
						</g:if>
						<g:else>
							<li>
						</g:else>
						<g:link controller="updateProfile" action="surgeryResults"
							params="[ans: 'No significant impact to daily lifestyle']">No significant impact to daily lifestyle</g:link>
						</li>
											<g:if test="${value =='Severe complications'}">
							<li class="active">
						</g:if>
						<g:else>
							<li>
						</g:else>
						<g:link controller="updateProfile" action="surgeryResults"
							params="[ans: 'Severe complications']">Severe complications</g:link>
						</li>
										</ul>
									</div>
									<div class="col-md-6 col-xs-12 pad-rt-0 hidden-xs hidden-sm">
										<ul>
											<g:if test="${value =='Minimal side effects'}">
							<li class="active">
						</g:if>
						<g:else>
							<li>
						</g:else>
						<g:link controller="updateProfile" action="surgeryResults"
							params="[ans: 'Minimal side effects']">Minimal side effects </g:link>
						</li>
											<g:if test="${value =='Significant side effects'}">
							<li class="active">
						</g:if>
						<g:else>
							<li>
						</g:else>
						<g:link controller="updateProfile" action="surgeryResults"
							params="[ans: 'Significant side effects']">Significant side effects</g:link>
						</li>
											<g:if test="${value =='Significant impact to daily lifestyle'}">
							<li class="active">
						</g:if>
						<g:else>
							<li>
						</g:else>
						<g:link controller="updateProfile" action="surgeryResults"
							params="[ans: 'Significant impact to daily lifestyle']">Significant impact to daily lifestyle</g:link>
						</li>
										</ul>
									</div>
								</div>
								<div class="clearfix mar-bot-30"></div>
								</div>
						</div>
					</div>