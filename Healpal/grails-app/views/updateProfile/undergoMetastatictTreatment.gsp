<%--<link href="../assets/profile/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="../assets/profile/css/colorbox.css" rel="stylesheet" type="text/css">
	<!-- Custom CSS -->
    <link href="../assets/profile/css/style.css" rel="stylesheet" type="text/css">
    <!-- Custom Fonts -->
    <link href="../assets/profile/css/font-awesome.min.css" rel="stylesheet" type="text/css">--%>
<g:form controller="updateProfile" action="undergoMetastatictTreatment" method="post">
			<div class="col-sm-12">
						<div class="profile-box-bg highest-box">
							<div class="text-center">
							<div class="icon-box-top"><img src="../assets/profile/img/f1-icon.jpg" /></div>
								<h3 class="pad-bot-0" style="font-family: Opensans Light; font-size: 22px;">Did you undergo treatment for metastatic  breast cancer. if yes, please choose the treatment administered to you</h3>
								<div class="list-content">
								<g:if test="${metastaticBreastCancer }">
								<input type="hidden" value="Did you undergo treatment for metastatic breast cancer.if yes, please choose the treatment administered to you" name="question">
								<g:each in="${metastaticBreastCancer}" var="patient">
									<div class="col-md-6 col-xs-12 pad-lt-0 t-pad-rt">
										<ul>
										
											<g:if test="${value !=null && value.contains(patient?.metastaticName) }">
											<li class="active">
												<input type="checkbox" value="${patient?.metastaticName}" id="${patient?.id}" name="metastaticBreastCancer" class="checkboxSelect" checked="checked" />
												</g:if>
											<g:else>
											<li>
											<input type="checkbox" value="${patient?.metastaticName}" id="${patient?.id}" name="metastaticBreastCancer" class="checkboxSelect"/>
											</g:else>
												<label for="${patient?.id}" class="selectedLabels"> ${patient?.metastaticName} </label>
											</li>
											
										</ul>
									</div>
									</g:each></g:if>
									<%--<div class="col-md-6 col-xs-12 pad-rt-0 t-pad-lr">
										<ul>
											<li><a href="g1.html">Capecitabine or Xeloda </a></li>
											<li><a href="g1.html">Carboplatin or Paraplatin</a></li>
											<li  class="active"><a href="g1.html">Cyclophosphamide or Cytoxan</a></li>
											<li><a href="g1.html">Doxorubicin or Adriamycin</a></li>
											<li><a href="g1.html">Erubulin or Halaven</a></li>
											<li><a href="g1.html">Cyclophosphamide or Cytoxan</a></li>
											<li><a href="g1.html">Gemcitabine or Gemzar</a></li>
											<li><a href="g1.html">Liposomal doxorubicin or Doxil</a></li>
											<li><a href="g1.html">Paclitaxel or Taxol</a></li>
										</ul>
									</div>
								--%></div>
								<p>( You can select one or multiple choices )</p>
								</div>
					<g:link class="skip-text"> <g:submitButton name="NEXT" /></g:link>
							</div>
						</div>
			
		</g:form>
		<script src="../js/profile/profile.js"></script>