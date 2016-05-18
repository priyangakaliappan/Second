<div class="col-sm-12">
						<div class="profile-box-bg general-text">
							<div class="text-center">
								<div class="icon-box-top"><img src="../assets/icon/h2-icon.jpg" /></div>
								<g:form controller="updateProfile" name="d5" class="form-horizontal">
								<h1>
						Please state the clinical trial you <br /> participated in
					</h1>
								<div class="col-md-12 col-xs-12 center-align m-pad-lr pad-lr-0">
									<textarea class="textarea" name="participated" id="participate" placeholder="Please type here">${value}</textarea>
									
									<g:actionSubmit value="Next" action="clinicalTrial"  class="blue-btn" id="participated"/>
								</div>
								<div class="clearfix"></div>
								</g:form>
							</div>
							</div>
						</div>
							<script src="../js/profile/profile.js"></script>