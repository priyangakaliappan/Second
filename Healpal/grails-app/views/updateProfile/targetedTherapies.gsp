<%--<link href="../assets/profile/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="../assets/profile/css/colorbox.css" rel="stylesheet" type="text/css">
	<!-- Custom CSS -->
    <link href="../assets/profile/css/style.css" rel="stylesheet" type="text/css">
    <!-- Custom Fonts -->
    <link href="../assets/profile/css/font-awesome.min.css" rel="stylesheet" type="text/css">--%>
<div class="col-sm-12">
 <g:form controller="updateProfile" action="targetedTherapies">
						<div class="profile-box-bg general-text">
							<div class="icon-box-top text-center"><img src="${resource(dir:'assets/icon',file:'h2-icon.jpg')}" /></div>
							<div class="text-center">
								<h1>Please choose the targeted therapy or therapies given to you</h1>
									<div class="list-content">
									<div class="col-md-6 col-xs-12 pad-lt-0 m-pad-rt">
										<ul>
											<g:if
								test="${value != null && value.contains('Trastuzumab or Herceptin')}">
								<li class="active"><input type="checkbox"
									value="Trastuzumab or Herceptin" name="answer1"
									class="checkboxSelect" id="answer1" checked="checked" />
							</g:if>
							<g:else>
								<li><input type="checkbox" value="Trastuzumab or Herceptin"
									name="answer1" class="checkboxSelect" id="answer1" />
							</g:else>
											<label for="answer1" class="selectedLabels">Trastuzumab or Herceptin</label></li>
											
											<g:if
								test="${value != null && value.contains('Trastuzumab emtansine or T-DM1, Kadcyla')}">
								<li class="active"><input type="checkbox"
									value="Trastuzumab emtansine or T-DM1, Kadcyla" name="answer2"
									class="checkboxSelect" id="answer2" checked="checked" />
							</g:if>
							<g:else>
								<li><input type="checkbox"
									value="Trastuzumab emtansine or T-DM1, Kadcyla" name="answer2"
									class="checkboxSelect" id="answer2" />
							</g:else>
											<label for="answer2" class="selectedLabels">Trastuzumab emtansine or T-DM1, Kadcyla</label></li>
										</ul>
									</div>
									<div class="col-md-6 col-xs-12 pad-lt-0 m-pad-rt">
										<ul>
											<g:if
								test="${value != null && value.contains('Pertuzumab or Perjeta')}">
								<li class="active"><input type="checkbox"
									value="Pertuzumab or Perjeta" name="answer3"
									class="checkboxSelect" id="answer3" checked="checked" />
							</g:if>
							<g:else>
								<li><input type="checkbox" value="Pertuzumab or Perjeta"
									name="answer3" class="checkboxSelect" id="answer3" />
							</g:else>
										<label for="answer3" class="selectedLabels">Pertuzumab or Perjeta</label></li>
								       <g:if
								test="${value != null && value.contains('Lapatinib or Tykerb')}">
								<li class="active"><input type="checkbox"
									value="Lapatinib or Tykerb" name="answer4"
									class="checkboxSelect" id="answer4" checked="checked" />
							</g:if>
							<g:else>
								<li><input type="checkbox" value="Lapatinib or Tykerb"
									name="answer4" class="checkboxSelect" id="answer4" />
							</g:else>
								        <label for="answer4" class="selectedLabels">Lapatinib or Tykerb</label></li>
										</ul>
									</div>
									
								</div>
								<div class="clearfix mar-bot-30"></div>
								<p class="multiple-text">( You can select one or multiple choices )</p>
								</div>
							<g:link class="skip-text"> <g:submitButton name="NEXT" /></g:link>
						</div>
						</g:form>
						</div>
						
<script src="../js/profile/profile.js"></script>