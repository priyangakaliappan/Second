
<div class="col-sm-12">
	<div class="profile-box-bg">
		<g:form controller="profile" action="ca11" name="treating">
			<div class="col-md-10 col-xs-12 center-align text-center">
				<div class="icon-box-top">
					<img src="../assets/icon/ca11-icon.jpg" />
				</div>
				<h1>
					Name of your treating doctor <br>
					<div class="col-md-9 col-xs-12 center-align text-center">
						<input class="textbox" id="treatingDoctor" type="text"
							name="treatingDoctor"
							placeholder="Please enter your Treating Doctor Name" />
					</div>
				</h1>
				<div class="box-content2">
					<div class="box-content2-bg">
						<g:link controller="profile" action="d1">
							<h3>
								<span>I do not have a treating physician yet</span>
							</h3>
						</g:link>
					</div>
				</div>
				<div class="box-content2">
					<div class="box-content2-bg">
						<g:link controller="profile" action="d1">
							<h3>
								<span>I prefer not to answer</span>
							</h3>
						</g:link>
					</div>
				</div>
				<div class="clearfix"></div>

				<g:submitButton name="Save and Continue" class="pink-btn"
					id="saveTreatingDoctor" />
			</div>
		</g:form>
	</div>
</div>