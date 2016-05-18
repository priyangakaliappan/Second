<div class="left-gray-box-cont">
				<g:if test="${previousControl}">
				<div class="next-section  new-previos-section">
					<div class="col-sm-2 col-xs-3 pad-lt-0">
						<g:link action="${preAction}" controller="breastContent" class="round"><i class="fa fa-chevron-left"></i></g:link>
					</div>
					<div class="col-sm-10 col-xs-9 pad-lt-0">
						<h2>Previous Section </h2>
						<p> ${prevTxt}</p>
					</div>
					<div class="clearfix"></div>
				</div>
				</g:if><g:if test="${nextControl}">
				<div class="next-section  new-next-section">
					<div class="col-sm-10 col-xs-9 pad-rt-0">
						<h2 class="text-right">Next Section </h2>
						<p class="text-right"> ${nextTxt}</p>
					</div>
					<div class="col-sm-2 col-xs-3 pad-lt-0">
						<g:link action="${nexAction}" controller="breastContent" class="round"><i class="fa fa-chevron-right"></i></g:link>
					</div>
					<div class="clearfix"></div>
				</div></g:if>
</div>

<div class="left-icons2 mar-top-0"> 
		<ul> <!-- breast-2b -->
			<li> <g:link action="understandingNumber" controller="breastContent" class="simptip-position-top"  data-tooltip="About"><i class="${sectionAbout}"></i></g:link></li>
			<li class="${sectionDiagnosis}"> <g:link action="theTest" controller="breastContent" class="simptip-position-top"  data-tooltip="Diagnosis" > <i class="breast-3"></i></g:link></li>
			<li class="${sectionTreatment}"> <g:link action="knowYourBreastCancerCareTeam" controller="breastContent" class="simptip-position-top"  data-tooltip="Treatment Options" > <i class="breast-4"></i></g:link></li>
			<li class="${sectionPrevention}"> <g:link action="mammorgam" controller="breastContent" class="simptip-position-top"  data-tooltip="Prevention and Early Detection" > <i class="breast-5"></i></g:link></li>
			<li class="${sectionClinical}"> <g:link action="understandingClinicalTrial" controller="breastContent" class="simptip-position-top"  data-tooltip="Clinical Trials" ><i class="breast-6"></i></g:link></li>
			<li class="${sectionLifestyle}"> <g:link action="nutrition" controller="breastContent" class="simptip-position-top"  data-tooltip="Coping Lifestyle" ><i class="breast-7"></i></g:link></li>
		</ul>
</div>