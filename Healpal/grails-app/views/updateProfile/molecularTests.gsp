<%--<link href="../assets/profile/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="../assets/profile/css/colorbox.css" rel="stylesheet" type="text/css">
	<!-- Custom CSS -->
    <link href="../assets/profile/css/style.css" rel="stylesheet" type="text/css">
    <!-- Custom Fonts -->
    <link href="../assets/profile/css/font-awesome.min.css" rel="stylesheet" type="text/css">--%>

<div class="col-sm-12">
						<div class="profile-box-bg">
						<g:form controller="updateProfile" action="molecularTests">
							<div class="text-center">
								<div class="icon-box-top"><img src="../assets/profile/img/da10-icon.jpg" /></div>
								<h3 class="pad-bot-0" style="font-family: 'Opensans Light';font-size: 22px;">Please choose which molecular test or tests have been performed</h3>
								<div class="list-content content">
									<ul>
										<g:if
							test="${value != null && value.contains('Oncotype Dx test')}">
							<li class="active"><input type="checkbox"
								value="Oncotype Dx test" name="ans" class="checkboxSelect"
								id="answer1" checked="checked" />
						</g:if>
						<g:else>
							<li><input type="checkbox" value="Oncotype Dx test"
								name="ans" class="checkboxSelect" id="answer1" />
						</g:else>
										<label for="answer1" class="selectedLabels">Oncotype Dx test</label>
										<g:if test="${value !=null && value.contains('MammoPrint test')}">
							<li class="active"><input type="checkbox"
								value="MammoPrint test" name="ans" class="checkboxSelect"
								id="answer2" checked="checked" />
						</g:if>
						<g:else>
							<li><input type="checkbox" value="MammoPrint test"
								name="ans" class="checkboxSelect" id="answer2" />
						</g:else>
										<label for="answer2" class="selectedLabels">MammoPrint test</label>
										<g:if
							test="${value !=null && value.contains('Urokinase plasminogen activator (uPA) and plasminogen activator inhibitor (PAI-I) tests')}">
							<li class="active"><input type="checkbox" id="answer3"
								value="Urokinase plasminogen activator (uPA) and plasminogen activator inhibitor (PAI-I) tests"
								name="ans" class="checkboxSelect" checked="checked" />
						</g:if>
						<g:else>
							<li><input type="checkbox" id="answer3"
								value="Urokinase plasminogen activator (uPA) and plasminogen activator inhibitor (PAI-I) tests"
								name="ans" class="checkboxSelect" />
						</g:else>
										<label for="answer3" class="selectedLabels">Urokinase plasminogen activator (uPA) and plasminogen activator inhibitor (PAI-I) tests</label>
									</ul>
									<div class="clearfix mar-bot-20ssss"></div>
									<p>( You can Select one or multiple choices)</p>
								</div>
							</div>
								<g:link action="" class="skip-text"><g:submitButton name="NEXT"/></g:link>
								</g:form>
							</div>
						</div>
<script src="../js/profile/profile.js"></script>