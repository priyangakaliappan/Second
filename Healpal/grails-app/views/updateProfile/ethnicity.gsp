<div class="col-sm-12">
						<div class="profile-box-bg">
						<div class="icon-box-top text-center"><img src="../assets/icon/c6-icon.jpg" /></div>
							
								<div class="col-md-12 col-xs-12 pad-lr-0">
								<h1>Select your Ethnicity</h1>
								<g:if test="${ethnicityView}">
								<g:each status="i" in="${ethnicityView}" var="ethnicity">
								<div class="box-content2">
									<g:link controller="updateProfile" action="ethnicity"
								params="${[ethnicityId:ethnicity.id]}">
								<g:if test="${value == ethnicity.ethnicityName}">
								<div class="changeActive box-content2-bg active"
									id="${ethnicity?.id}">
							</g:if>
							<g:else>
								<div class="changeActive box-content2-bg" id="${ethnicity?.id}">
							</g:else><h3><span>${ethnicity.ethnicityName}</span></h3></div></g:link>
								</div>
								</g:each>
								</g:if>
							</div>
							</div>
							<br/>
							
						</div>
<script src="../js/profile/profile.js"></script>