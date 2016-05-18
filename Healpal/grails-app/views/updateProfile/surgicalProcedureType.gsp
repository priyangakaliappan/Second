<%--<link href="../assets/profile/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="../assets/profile/css/colorbox.css" rel="stylesheet" type="text/css">
	<!-- Custom CSS -->
    <link href="../assets/profile/css/style.css" rel="stylesheet" type="text/css">
    <!-- Custom Fonts -->
    <link href="../assets/profile/css/font-awesome.min.css" rel="stylesheet" type="text/css">--%>
<div class="col-sm-12">
						<div class="profile-box-bg general-text">
							<g:form controller="updateProfile" action="surgicalProcedureType">
							<div class="icon-box-top text-center"><img src="../assets/icon/e1-icon.jpg" /></div>
							<div class="text-center">
								<h1>What type of surgical procedure did you <br> undergo or are scheduled to undergo?</h1>
									<div class="list-content">
									<div class="col-md-6 col-xs-12 pad-lt-0 m-pad-rt">
										<ul>
											<g:if
								test="${value !=null && value.contains('Axillary Lymph Node Dissection') }">
								<li class="active"><input type="checkbox"
									value="Axillary Lymph Node Dissection" name="ans"
									class="checkboxSelect" id="answer1" checked="checked" />
							</g:if>
							<g:else>
								<li><input type="checkbox"
									value="Axillary Lymph Node Dissection" name="ans"
									class="checkboxSelect" id="answer1" />
							</g:else>
										<label for="answer1" class="selectedLabels">Axillary Lymph Node Dissection</label>
											<g:if
								test="${value !=null && value.contains('Breast Reconstruction (Implant)') }">
								<li class="active"><input type="checkbox"
									value="Breast Reconstruction (Implant)" name="ans"
									class="checkboxSelect" id="answer2" checked="checked" />
							</g:if>
							<g:else>
								<li><input type="checkbox"
									value="Breast Reconstruction (Implant)" name="ans"
									class="checkboxSelect" id="answer2" />
							</g:else>
										<label for="answer2" class="selectedLabels">Breast Reconstruction (Implant)</label>
											<g:if
								test="${value !=null && value.contains('Implant Chemotheraphy port') }">
								<li class="active"><input type="checkbox"
									value="Implant Chemotheraphy port" name="ans"
									class="checkboxSelect" id="answer3" checked="checked" />
							</g:if>
							<g:else>
								<li><input type="checkbox"
									value="Implant Chemotheraphy port" name="ans"
									class="checkboxSelect" id="answer3" />
							</g:else>
										<label for="answer3" class="selectedLabels">Implant Chemotheraphy port</label>
											<g:if test="${value !=null && value.contains('Lumpectomy') }">
								<li class="active"><input type="checkbox"
									value="Lumpectomy" name="ans" class="checkboxSelect"
									id="answer4" checked="checked" />
							</g:if>
							<g:else>
								<li><input type="checkbox" value="Lumpectomy" name="ans"
									class="checkboxSelect" id="answer4" />
							</g:else>
										<label for="answer4" class="selectedLabels">Lumpectomy</label>
											<g:if
								test="${value !=null && value.contains('Sentinal lymph node biopsy') }">
								<li class="active"><input type="checkbox"
									value="Sentinal lymph node biopsy" name="ans"
									class="checkboxSelect" id="answer5" checked="checked" />
							</g:if>
							<g:else>
								<li><input type="checkbox"
									value="Sentinal lymph node biopsy" name="ans"
									class="checkboxSelect" id="answer5" />
							</g:else>
										<label for="answer5" class="selectedLabels">Sentinal lymph node biopsy</label>
								<g:if test="${others !=null }">
								<li class="active"><input type="checkbox" value="Other"
									name="otherz" class="checkboxSelect" id="otherz"
									checked="checked" onclick="otherOption();" />
							</g:if>
							<g:else>
								<li><input type="checkbox" value="Other" name="otherz"
									class="checkboxSelect" id="otherz" onclick="otherOption();" />
							</g:else>
										<label for="otherz" class="selectedLabels">Other</label>
										</ul>
									</div>
									<div class="col-md-6 col-xs-12 pad-rt-0 hidden-xs hidden-sm">
										<ul>
											<g:if
								test="${value !=null && value.contains('Breast REconstruction') }">
								<li class="active"><input type="checkbox"
									value="Breast REconstruction" name="ans" class="checkboxSelect"
									id="answer7" checked="checked" />
							</g:if>
							<g:else>
								<li><input type="checkbox" value="Breast REconstruction"
									name="ans" class="checkboxSelect" id="answer7" />
							</g:else>
										<label for="answer7" class="selectedLabels">Breast Reconstruction</label>

											<g:if
								test="${value !=null && value.contains('Double Mastectomy') }">
								<li class="active"><input type="checkbox"
									value="Double Mastectomy" name="ans" class="checkboxSelect"
									id="answer8" checked="checked" />
							</g:if>
							<g:else>
								<li><input type="checkbox" value="Double Mastectomy"
									name="ans" class="checkboxSelect" id="answer8" />
							</g:else>
										<label for="answer8" class="selectedLabels">Double Mastectomy</label>
											<g:if
								test="${value !=null && value.contains('Long-term catheter') }">
								<li class="active"><input type="checkbox"
									value="Long-term catheter" name="ans" class="checkboxSelect"
									id="answer9" checked="checked" />
							</g:if>
							<g:else>
								<li><input type="checkbox" value="Long-term catheter"
									name="ans" class="checkboxSelect" id="answer9" />
							</g:else>
										<label for="answer9" class="selectedLabels">Long-term catheter</label>
											<g:if test="${value !=null && value.contains('Mastectomy') }">
								<li class="active"><input type="checkbox"
									value="Mastectomy" name="ans" class="checkboxSelect"
									id="answer10" checked="checked" />
							</g:if>
							<g:else>
								<li><input type="checkbox" value="Mastectomy" name="ans"
									class="checkboxSelect" id="answer10" />
							</g:else>
										<label for="answer10" class="selectedLabels">Mastectomy</label>
										<g:if test="${value !=null && value.contains('Surgery') }">
								<li class="active"><input type="checkbox" value="Surgery"
									name="ans" class="checkboxSelect" id="answer11"
									checked="checked" />
							</g:if>
							<g:else>
								<li><input type="checkbox" value="Surgery" name="ans"
									class="checkboxSelect" id="answer11" />
							</g:else>
										<label for="answer11" class="selectedLabels">Surgery</label>
										</ul>
									</div>
								</div>
								<g:if test="${others!=null}">
					<input type="text" name="otherOptions" id="otherOptions"
						value="${others}"
						style="height: 45px; display: inline; width: 500px; font-size: 25px;">
				</g:if>
				<g:else>
					<input type="text" name="otherOptions" id="otherOptions"
						style="height: 45px; display: inline; width: 500px; font-size: 25px;">
				</g:else>
								<div class="clearfix mar-bot-30"></div>
								<p class="multiple-text">( You can select one or multiple choices )</p>
								</div>
								<g:link action="" class="skip-text"><g:submitButton name="NEXT"/></g:link>
								</g:form>
						</div>
					</div>

<script src="../js/profile/profile.js"></script>
<script type="text/javascript">
	/*
	 * to add own answer for other option
	 */
	$(document).ready(function() {
		if ($("#otherz").attr('checked')) {
			$("#otherOptions").show();
		} else {
			$("#otherOptions").hide();
		}
	});
	function otherOption() {
		$("#otherOptions").toggle();
	}
</script>