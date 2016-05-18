
<div class="col-sm-12">
						<div class="profile-box-bg highest-box">
						<div class="icon-box-top text-center"><img src="../assets/icon/c7-icon.jpg" /></div>
								<div class="col-md-12 col-xs-12 m-pad-lr pad-lr-0">
								<h1>Select your Race</h1>
								<div class="box-content2">
									<g:link controller="updateProfile" action="race"
				params="[ans:'White']"><g:if test="${value =='White'}">
						<div class="changeActive box-content2-bg active" id="1">
					</g:if>
					<g:else>
						<div class="changeActive box-content2-bg" id="1">
					</g:else><h3><span>White</span></h3></div></g:link>
								</div>
								<div class="box-content2">
									<g:link controller="updateProfile" action="race"
			params="[ans:'Black or African American']"><g:if test="${value =='Black or African American'}">
					<div class="changeActive box-content2-bg active" id="2">
				</g:if>
				<g:else>
					<div class="changeActive box-content2-bg" id="2">
				</g:else><h3><span>Black or African American</span></h3></div></g:link>
								</div>
								<div class="box-content2">
									<g:link controller="updateProfile" action="race" params="[ans:'Asian']"><g:if test="${value == 'Asian'}">
				<div class="changeActive box-content2-bg active" id="3">
			</g:if>
			<g:else>
				<div class="changeActive box-content2-bg" id="3">
			</g:else><h3><span>Asian</span></h3></div></g:link>
								</div>
								<div class="box-content2">
									<g:link controller="updateProfile" action="race"
	params="[ans:'Native Hawaiian or other Islander']"><g:if test="${value == 'Native Hawaiian or other Islander'}">
			<div class="changeActive box-content2-bg active" id="4">
		</g:if>
		<g:else>
			<div class="changeActive box-content2-bg" id="4">
		</g:else><h3><span>Native Hawaiian or other Islander</span></h3></div></g:link>
								</div>
								<div class="box-content2">
									<g:link controller="updateProfile" action="race"
		params="[ans:'American Indian or Alskan Native']"><g:if test="${value == 'American Indian or Alskan Native'}">
				<div class="changeActive box-content2-bg active" id="5">
			</g:if>
			<g:else>
				<div class="changeActive box-content2-bg" id="5">
			</g:else><h3><span>American Indian or Alskan Native</span></h3></div></g:link>
								</div>
								<div class="box-content2">
									<g:link controller="updateProfile" action="race" params="['Mixed Race']"><g:if test="${value == 'Mixed Race'}">
			<div class="changeActive box-content2-bg active" id="6">
		</g:if>
		<g:else>
			<div class="changeActive box-content2-bg" id="6">
		</g:else><h3><span>Mixed Race</span></h3></div></g:link>
								</div>
								<div class="box-content2">
									<g:link controller="updateProfile" action="race"
	params="[ans:'I prefer not to answer']"><g:if test="${value == 'I prefer not to answer'}">
			<div class="changeActive box-content2-bg active" id="7">
		</g:if>
		<g:else>
			<div class="changeActive box-content2-bg" id="7">
		</g:else><h3><span>I prefer not to answer</span></h3></div></g:link>
								</div>
							</div>
							</div>
							</div>
						</div>
<script src="../js/profile/profile.js"></script>