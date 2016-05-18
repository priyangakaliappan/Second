<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<meta name="layout" content="createProfile"/>
<title>Insert title here</title>
</head>
<body>
<section>
<div class="container container-950">
<div class="row">
  	<div class="col-sm-12">
						<div class="profile-box-bg">
							<g:form controller="profile" action="e2">
							<div class="icon-box-top text-center"><img src="../assets/icon/e1-icon.jpg" /></div>
							<div class="text-center">
								<h1>What type of surgical procedure did you undergo or are <br> scheduled to undergo?</h1>
									<div class="list-content">
									<div class="col-md-6 col-xs-12 pad-lt-0 m-pad-rt">
										<ul>
											<li><input type="checkbox" value="Axillary Lymph Node Dissection" name="answer1" class="checkboxSelect" id="answer1"/>
										<label for="answer1"  class="selectedLabels">Axillary Lymph Node Dissection</label>
											<li><input type="checkbox" value="Breast Reconstruction (Implant)" name="answer2" class="checkboxSelect" id="answer2"/>
										<label for="answer2"  class="selectedLabels">Breast Reconstruction (Implant)</label>
											<li><input type="checkbox" value="Implant Chemotheraphy port" name="answer3" class="checkboxSelect" id="answer3"/>
										<label for="answer3"  class="selectedLabels">Implant Chemotheraphy port</label>
											<li><input type="checkbox" value="Lumpectomy" name="answer4" class="checkboxSelect" id="answer4"/>
										<label for="answer4"  class="selectedLabels">Lumpectomy</label>
											<li><input type="checkbox" value="Sentinal lymph node biopsy" name="answer5" class="checkboxSelect" id="answer5"/>
										<label for="answer5"  class="selectedLabels">Sentinal lymph node biopsy</label>
											<li><input type="checkbox" value="Other" name="others" class="checkboxSelect" id="others" onclick="otherOption()"/>
										<label for="others"  class="selectedLabels">Other</label>
										</ul>
									</div>
									<div class="col-md-6 col-xs-12 pad-rt-0 hidden-xs hidden-sm">
										<ul>
											<li><input type="checkbox" value="Breast REconstruction" name="answer7" class="checkboxSelect" id="answer7"/>
										<label for="answer7"  class="selectedLabels">Breast Reconstruction</label>

											<li><input type="checkbox" value="Double Mastectomy" name="answer8" class="checkboxSelect" id="answer8"/>
										<label for="answer8"  class="selectedLabels">Double Mastectomy</label>
											<li><input type="checkbox" value="Long-term catheter" name="answer9" class="checkboxSelect" id="answer9"/>
										<label for="answer9"  class="selectedLabels">Long-term catheter</label>
											<li><input type="checkbox" value="Mastectomy" name="answer10" class="checkboxSelect" id="answer10"/>
										<label for="answer10"  class="selectedLabels">Mastectomy</label>
										<li><input type="checkbox" value="Surgery" name="answer11" class="checkboxSelect" id="answer11"/>
										<label for="answer11"  class="selectedLabels">Surgery</label>
										</ul>
									</div>
								</div>
								<input type="text" name="otherOptions" id="otherOptions" style="display: inline; font-size: 16px; height: 41px; width: 356px;">
								<div class="clearfix mar-bot-30"></div>
								<p class="multiple-text">( You can select one or multiple choices )</p>
								</div>
								<div class="clearfix">&nbsp;</div>
								<div class="clearfix">&nbsp;</div>
								<g:link controller="Profile" action="e1" class="back-link"><i class="back-arrow"></i>Back</g:link>
								<g:link action="" class="skip-text"><g:submitButton name="NEXT"/></g:link>
								</g:form>
						</div>
						<div class="container container-950">
			<div class="prograss-bar bar-20-slider pull-left">
				<div class="bar-text">13/19</div>
				<ul>
					<div class="per-text pull-left">20%</div>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<div class="per-text pull-right">50%</div>
				</ul>
				<p>6 more questions for 50% profile completion</p>				
				
			</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
		</div>
					</div></div></div></section>
					<%--<section>
		<div class="container container-950">
			<div class="prograss-bar bar-20-slider pull-left">
				<div class="bar-text">13/19</div>
				<ul>
					<div class="per-text pull-left">20%</div>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li class="active"></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<div class="per-text pull-right">50%</div>
				</ul>
				<p>6 more questions for 50% profile completion</p>				
				
			</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
			<div class="clearfix">&nbsp;</div>
		</div>
		</section>
					  --%><script type="text/javascript">
		$(document).ready(function() {
			$("#otherOptions").hide();
		});
		function otherOption(){
			$("#otherOptions").toggle();
			}
		
	</script>

</body>
</html>