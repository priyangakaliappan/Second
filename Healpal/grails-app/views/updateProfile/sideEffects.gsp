<%--<link href="../assets/profile/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="../assets/profile/css/colorbox.css" rel="stylesheet" type="text/css">
	<!-- Custom CSS -->
    <link href="../assets/profile/css/style.css" rel="stylesheet" type="text/css">
    <!-- Custom Fonts -->
    <link href="../assets/profile/css/font-awesome.min.css" rel="stylesheet" type="text/css">--%>
<g:form controller="updateProfile" action="sideEffects" method="POST">
	<div class="col-sm-12">
						<div class="profile-box-bg">
							<div class="text-center">
							<div class="icon-box-top"><img src="../assets/icon/k1-icon.jpg" /></div>
								<h3 class="pad-bot-0" style="font-family: Opensans Light; font-size: 22px;">Please select the side effects you have experienced during your cancer treatment</h3>
								<div class="list-content">
									<ul>
										<g:if test="${value != null && value.contains('None')}">
							<li class="active"><input type="checkbox" value="None"
								name="answer1" class="checkboxSelect" id="answer1"
								checked="checked" />
						</g:if>
						<g:else>
							<li><input type="checkbox" value="None" name="answer1"
								class="checkboxSelect" id="answer1" />
						</g:else>
										<label for="answer1" class="selectedLabels">None</label></li>
										<g:if
							test="${value != null && value.contains('Not started treatment yet')}">
							<li class="active"><input type="checkbox"
								value="Not started treatment yet" name="answer2"
								class="checkboxSelect" id="answer2" checked="checked" />
						</g:if>
						<g:else>
							<li><input type="checkbox" value="Not started treatment yet"
								name="answer2" class="checkboxSelect" id="answer2" />
						</g:else>
										<label for="answer2" class="selectedLabels">Not started treatment yet</label></li>
										<g:if test="${value != null && value.contains('Early menopause')}">
							<li class="active"><input type="checkbox"
								value="Early menopause" name="answer3" class="checkboxSelect"
								id="answer3" checked="checked" />
						</g:if>
						<g:else>
							<li><input type="checkbox" value="Early menopause"
								name="answer3" class="checkboxSelect" id="answer3" />
						</g:else>
										<label for="answer3" class="selectedLabels">Early menopause</label></li>
										<g:if
							test="${value != null && value.contains('Menopausal symptoms (such as hot flashes and vaginal symptoms)')}">
							<li class="active"><input type="checkbox"
								value="Menopausal symptoms (such as hot flashes and vaginal symptoms)"
								name="answer4" class="checkboxSelect" id="answer4"
								checked="checked" />
						</g:if>
						<g:else>
							<li><input type="checkbox"
								value="Menopausal symptoms (such as hot flashes and vaginal symptoms)"
								name="answer4" class="checkboxSelect" id="answer4" />
						</g:else>
										<label for="answer4" class="selectedLabels">Menopausal symptoms (such as hot flashes and vaginal symptoms)</label></li>
										<g:if
							test="${value != null && value.contains('Fertility issues')}">
							<li class="active"><input type="checkbox"
								value="Fetility issues" name="answer5" class="checkboxSelect"
								id="answer5" checked="checked" />
						</g:if>
						<g:else>
							<li><input type="checkbox" value="Fertility issues"
								name="answer5" class="checkboxSelect" id="answer5" />
						</g:else>
										<label for="answer5" class="selectedLabels">Fertility  issues</label></li>
										<g:if
							test="${value != null && value.contains('Insomnia (trouble sleeping)')}">
							<li class="active"><input type="checkbox"
								value="Insomnia (trouble sleeping)" name="answer7"
								class="checkboxSelect" id="answer7" checked="checked" />
						</g:if>
						<g:else>
							<li><input type="checkbox"
								value="Insomnia (trouble sleeping)" name="answer7"
								class="checkboxSelect" id="answer7" />
						</g:else>
										<label for="answer7" class="selectedLabels">Insomnia (trouble sleeping)</label></li>
										<g:if
							test="${value != null && value.contains('Fear of recurrence (relapse)')}">
							<li class="active"><input type="checkbox"
								value="Fear of recurrence (relapse)" name="answer8"
								class="checkboxSelect" id="answer8" checked="checked" />
						</g:if>
						<g:else>
							<li><input type="checkbox"
								value="Fear of recurrence (relapse)" name="answer8"
								class="checkboxSelect" id="answer8" />
						</g:else>
										<label for="answer8" class="selectedLabels">Fear of recurrence (relapse)</label></li>
										<g:if
							test="${value != null && value.contains('Sexuality and intimacy issues')}">
							<li class="active"><input type="checkbox"
								value="Sexuality and intimacy issues" name="answer9"
								class="checkboxSelect" id="answer9" checked="checked" />
						</g:if>
						<g:else>
							<li><input type="checkbox"
								value="Sexuality and intimacy issues" name="answer9"
								class="checkboxSelect" id="answer9" />
						</g:else>
										<label for="answer9" class="selectedLabels">Sexuality and intimacy issues</label></li>
										<g:if
							test="${value != null && value.contains('Changes in the look and feel of the breast')}">
							<li class="active"><input type="checkbox"
								value="Changes in the look and feel of the breast"
								name="answer10" class="checkboxSelect" id="answer10"
								checked="checked" />
						</g:if>
						<g:else>
							<li><input type="checkbox"
								value="Changes in the look and feel of the breast"
								name="answer10" class="checkboxSelect" id="answer10" />
						</g:else>
										<label for="answer10" class="selectedLabels">Changes in the look and feel of the breast</label></li>
										<g:if test="${value != null && value.contains('Lymphedema')}">
							<li class="active"><input type="checkbox" value="Lymphedema"
								name="answer11" class="checkboxSelect" id="answer11"
								checked="checked" />
						</g:if>
						<g:else>
							<li><input type="checkbox" value="Lymphedema"
								name="answer11" class="checkboxSelect" id="answer11" />
						</g:else>
										<label for="answer11" class="selectedLabels">Lymphedema</label></li>
										<g:if
							test="${value != null && value.contains('Early menopause(including Fertility issues)')}">
							<li class="active"><input type="checkbox"
								value="Early menopause(including Fertility issues)"
								name="answer12" class="checkboxSelect" id="answer12"
								checked="checked" />
						</g:if>
						<g:else>
							<li><input type="checkbox"
								value="Early menopause(including Fertility issues)"
								name="answer12" class="checkboxSelect" id="answer12" />
						</g:else>
										<label for="answer12" class="selectedLabels">Early menopause (including Fertility issues)</label></li>
										<g:if test="${value != null && value.contains('Weight gain')}">
							<li class="active"><input type="checkbox"
								value="Weight gain" name="answer13" class="checkboxSelect"
								id="answer13" checked="checked" />
						</g:if>
						<g:else>
							<li><input type="checkbox" value="Weight gain"
								name="answer13" class="checkboxSelect" id="answer13" />
						</g:else>
										<label for="answer13" class="selectedLabels">Weight gain</label></li>
										<g:if test="${value != null && value.contains('Fatigue')}">
							<li class="active"><input type="checkbox" value="Fatigue"
								name="answer14" class="checkboxSelect" id="answer14"
								checked="checked" />
						</g:if>
						<g:else>
							<li><input type="checkbox" value="Fatigue" name="answer14"
								class="checkboxSelect" id="answer14" />
						</g:else>
										<label for="answer14" class="selectedLabels">Fatigue</label></li>
										<g:if
							test="${value != null && value.contains('Decline in Cognitive function (chemo-brain)')}">
							<li class="active"><input type="checkbox"
								value="Decline in Cognitive function (chemo-brain)"
								name="answer15" class="checkboxSelect" id="answer15"
								checked="checked" />
						</g:if>
						<g:else>
							<li><input type="checkbox"
								value="Decline in Cognitive function (chemo-brain)"
								name="answer15" class="checkboxSelect" id="answer15" />
						</g:else>
										<label for="answer15" class="selectedLabels">Decline in Cognitive function (chemo-brain)</label></li>
									</ul>
									<div class="clearfix mar-bot-20"></div>
									<p>( You can select one or multiple choices )</p>
								</div>
								</div>
							<g:link class="skip-text"><g:submitButton name="NEXT"/></g:link>
							</div>
						</div>
</g:form>
<script src="../js/profile/profile.js"></script>