<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<meta name="layout" content="editLayout"> 
<title>Healpal</title>
<style type="text/css"></style>
</head>
<body>
  
  <g:render template="../template/careMenu"></g:render>
 <section class="new-profile-bg">
		<div class="container">
			<div class="row">
				<div class="col-sm-12">
					<div class="box-content6">
						<div class="col-sm-3 col-xs-12 dashboard-sidebar-left">
							<div class="dark-graybox profile-img">
							<g:if test="${profilePhoto}">
									<g:if test="${viewProfile}">
										<img class="img-responsive" src="${profilePhoto}">
									</g:if>
									<g:else>
										<a class="modal_link" id="updateProfilePhoto" data-toggle="modal" data-target="#myModal" href="">
											<img class="img-responsive" src="${profilePhoto}" width="180px">
										</a>
									</g:else>
								</g:if>
							<g:else>
									<g:if test="${viewProfile}">
										<img class="img-responsive" src="../assets/images/profile-img.jpg">
									</g:if>
									<g:else>
										<a class="modal_link" id="updateProfilePhoto" data-toggle="modal" data-target="#myModal" href="">
										<img class="img-responsive" src="../assets/images/profile-img.jpg">
										</a>
									</g:else>
								</g:else>
								<g:if test="${patientName}">
								<h4>${patientName}</h4>
								</g:if>
							</div>
						</div>
						<div class="col-sm-9 col-xs-12 dashboard-sidebar-right">
						<div class="alert-danger" style="text-align: center;">${flash.msg}</div>
						<%--<table width="100%" border="0" cellpadding="5" class="right-profile-cont">								
								<thead>
									<tr style="background-color: #e8e8e8;">
										<th width="100%">Patient Portal Account</th>
										<th></th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td width="100%">No</td>
										<td></td>
									</tr>
									<tr>
										<td width="90%">Health care system</td>
										<td></td>
									</tr>
								</tbody>
							</table>
							<table width="100%" border="0" cellpadding="5" class="right-profile-cont">
								<thead>
									<tr style="background-color: #e8e8e8;">
										<th width="100%">Blue Button Enabled Account</th>
										<th></th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td width="90%">Not sure</td>
										<td></td>
									</tr>
								</tbody>
							</table>
							--%><table width="100%" border="0" cellpadding="5" class="right-profile-cont">
								<thead>
									<tr style="background-color: #e8e8e8;">
										<th width="100%">About You</th>
										<th></th>
									</tr>
								</thead>
								<tbody>								
								<g:each in="${editAboutYouProfile}" var="editProfileList">
								<g:if test="${editProfileList?.key==question}">
									<tr class="active_row">
									</g:if>
									<g:else>
									<tr>
									</g:else>
										<td width="90%">${editProfileList?.key} - <g:each in="${editProfileList?.value}" var="answer"><g:if test="${editProfileList?.key == 'Select your Date of Birth'}"><g:formatDate date="${answer}" type="date" style="MEDIUM"/></g:if><g:else>${answer}</g:else>   </g:each></td>
										<td width="10%">
										<g:if test="${editPermission}"><a class="modal_link" id="${editProfileList?.key}" data-toggle="modal" data-target="#myModal" href="${editProfileList?.value}" ><button type="button" name="edit" class="blue_edit-btn ">Edit</button></a></g:if>
										<g:else>										
										</g:else>
										</td>
										</tr>
									</g:each>
									</tbody>
							</table>
							<table width="100%" border="0" cellpadding="5" class="right-profile-cont">
								<thead>
									<tr style="background-color: #e8e8e8;">
										<th width="100%">About Your Condition</th>
										<th></th>
									</tr>
								</thead>
								<tbody>
								<g:if test="editAboutYourCondition">
									<g:each in="${editAboutYourCondition}" var="editProfileList">								
									<g:if test="${editProfileList?.key==question}">
									<tr class="active_row">
									</g:if><g:else><tr></g:else>
										<td width="90%">${editProfileList?.key} - <g:each in="${editProfileList?.value}" var="answer"><g:if test="${editProfileList?.key == 'Date of cancer diagnosis'}"><g:formatDate date="${answer}" type="date" style="MEDIUM"/></g:if><g:else>${answer}</g:else></g:each></td>
										<td width="10%">
										<g:if test="${editPermission}"><a class="modal_link" id="${editProfileList?.key}" data-toggle="modal" data-target="#myModal" href="${editProfileList?.value}" ><button type="button" name="edit" class="blue_edit-btn edit-profile-button">Edit</button></a></g:if>
										<g:else></g:else>
										</td>
									</tr>
									</g:each>
									</g:if>
									
								</tbody>
							</table>
							
							
							
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Modal -->
<div class="modal fade profile_popup" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <a href="#" class="close-icon" data-dismiss="modal"></a>
            <div class="modal-body"></div>
            
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>
<!-- /.modal -->

	<script>
		$(document).ready(function(){
			$(".header-search-box").hide();
			$(document).on('click','.modal_link',function(){
			if($(this).attr('id') != ""){
				$("#myModal .modal-body").html('Please wait...');
			var answers = $(this).attr('href').replace(/ /g , "@");
			if($(this).attr('id') == 'Gender identity')	{
				var url="../UpdateProfile/genderIdentity?answers="+answers;
				$("#myModal .modal-body").load(url);
				}	
			else if($(this).attr('id') == 'Select your Race')	{
				var url="../UpdateProfile/Race?answers="+answers;
				$("#myModal .modal-body").load(url);
				}
			else if($(this).attr('id') == 'I am interested in')	{
				var url="../UpdateProfile/personalInterest?answers="+answers;
				$("#myModal .modal-body").load(url);
				}
			else if($(this).attr('id') == 'Stage of cancer')	{
				var url="../UpdateProfile/cancerStage?answers="+answers;
				$("#myModal .modal-body").load(url);
				}
			else if($(this).attr('id') == 'Pathology biopsy tumor type 1')	{
				var url="../UpdateProfile/PathologyType1?answers="+answers;	
				$("#myModal .modal-body").load(url);
				}
			else if($(this).attr('id') == 'Pathology biopsy tumor type 2')	{
				var url="../UpdateProfile/PathologyType2?answers="+answers;
				$("#myModal .modal-body").load(url);
				}
			else if($(this).attr('id') == 'I have undergone molecular testing for my cancer')	{
				var url="../UpdateProfile/undergoneMolecularTesting?answers="+answers;
				$("#myModal .modal-body").load(url);
				}
			else if($(this).attr('id') == 'Please choose which molecular test or tests have been performed')	{
				var url="../UpdateProfile/molecularTests?answers="+answers;
				$("#myModal .modal-body").load(url);
				}
			else if($(this).attr('id') == 'Did you undergo surgery for your cancer?')	{
				var url="../UpdateProfile/undergoSurgery?answers="+answers;
				$("#myModal .modal-body").load(url);
				}
			else if($(this).attr('id') == 'updateProfilePhoto'){
				var url="../UpdateProfile/profilePhoto"
					$("#myModal .modal-body").load(url);
					}
			else if($(this).attr('id') == 'What type of surgical procedure did you Undergo or are scheduled to undergo?')	{
				var url="../UpdateProfile/surgicalProcedureType?answers="+answers;
				$("#myModal .modal-body").load(url);
				}
			else if($(this).attr('id') == 'Results of your surgery')	{
				var url="../UpdateProfile/surgeryResults?answers="+answers;
				$("#myModal .modal-body").load(url);
				}
			else if($(this).attr('id') == 'Date of surgery')	{
				var url="../UpdateProfile/surgeryDate?answers="+answers;
				$("#myModal .modal-body").load(url);
				}
			else if($(this).attr('id') == 'Did you undergo Chemotherapy?')	{
				var url="../UpdateProfile/undergoChemotherapy?answers="+answers;
				$("#myModal .modal-body").load(url);
				}	
			else if($(this).attr('id') == 'Did you undergo treatment for metastatic breast cancer.if yes, please choose the treatment administered to you')	{
				var url="../UpdateProfile/undergoMetastatictTreatment?answers="+answers;
				$("#myModal .modal-body").load(url);
				}	
			else if($(this).attr('id') == 'Did You Undergo Hormonal therapy')	{
				var url="../UpdateProfile/undergoHormonalTherapy?answers="+answers;
				$("#myModal .modal-body").load(url);
				}	
			else if($(this).attr('id') == 'Please choose the hormone therapy drug or drugs given to you')	{
				var url="../UpdateProfile/hormoneTherapyDrugs?answers="+answers;
				$("#myModal .modal-body").load(url);
				}	
			else if($(this).attr('id') == 'Did You Undergo targeted therapy')	{
				var url="../UpdateProfile/UndergoTargetedTherapy?answers="+answers;
				$("#myModal .modal-body").load(url);
				}		
			else if($(this).attr('id') == 'Please choose the targeted therapy or therapies given to you')	{
				var url="../UpdateProfile/targetedTherapies?answers="+answers;
				$("#myModal .modal-body").load(url);
				}	
			else if($(this).attr('id') == 'Did you undergo radiation treatment?')	{
				var url="../UpdateProfile/undergoRadiation?answers="+answers;
				$("#myModal .modal-body").load(url);
				}	
			else if($(this).attr('id') == 'Which type of radiation treatment did you receive or are scheduled to receive?')	{
				var url="../UpdateProfile/radiationTreatments?answers="+answers;
				$("#myModal .modal-body").load(url);
				}	
			else if($(this).attr('id') == 'Did you participate in any clinical trial')	{
				var url="../UpdateProfile/undergoClinicalTrial?answers="+answers;
				$("#myModal .modal-body").load(url);
				}	
			else if($(this).attr('id') == 'Please state the clinical trial you  participated in')	{
				var url="../UpdateProfile/clinicalTrial?answers="+answers;
				$("#myModal .modal-body").load(url);
				}	
			else if($(this).attr('id') == 'Please select the side effects you have experienced during your cancer treatment')	{
				var url="../UpdateProfile/sideEffects?answers="+answers;
				$("#myModal .modal-body").load(url);
				}	
			else if($(this).attr('id') == 'I am a')	{
				var url="../UpdateProfile/IAma?answers="+answers;
				$("#myModal .modal-body").load(url);
				}
			else if($(this).attr('id') == 'Please choose the combination chemotherapy administered to you')	{
				var url="../UpdateProfile/combinationChemotherapy?answers="+answers;
				$("#myModal .modal-body").load(url);
				}
			else if($(this).attr('id') == 'Please choose the chemotherapy drug or drugs given to you')	{
				var url="../UpdateProfile/chemotherapyDrugs?answers="+answers;
				$("#myModal .modal-body").load(url);
				}
			else if($(this).attr('id') == 'Select your Ethnicity')	{
				var url="../UpdateProfile/ethnicity?answers="+answers;
				$("#myModal .modal-body").load(url);
				}
			else if($(this).attr('id') == 'Select your Date of Birth')	{
				var url="../UpdateProfile/dateOfBirth?answers="+answers;
				$("#myModal .modal-body").load(url);
				}
			else if($(this).attr('id') == 'Describe the current status of your cancer')	{
				var url="../UpdateProfile/statusOfCancer?answers="+answers;
				$("#myModal .modal-body").load(url);
				}
			else if($(this).attr('id') == 'Where do you live ?')	{
				var url="../UpdateProfile/whereDoYouLive?answers="+answers;
				$("#myModal .modal-body").load(url);
				}
			else if($(this).attr('id') == 'Type of health insurance')	{
				var url="../UpdateProfile/healthInsurance?answers="+answers;
				$("#myModal .modal-body").load(url);
				}
			else if($(this).attr('id') == 'Do you have any associated medical conditions?')	{
				var url="../UpdateProfile/anyMedicalConditions?answers="+answers;
				$("#myModal .modal-body").load(url);
				}	
			else if($(this).attr('id') == 'State your diagnosis')	{
				var url="../UpdateProfile/stateYourDiagnosis?answers="+answers;
				$("#myModal .modal-body").load(url);
				}
			else if($(this).attr('id') == 'Your age at Diagnosis')	{
				var url="../UpdateProfile/ageAtDiagnosis?answers="+answers;
				$("#myModal .modal-body").load(url);
				}
			else if($(this).attr('id') == 'Date of cancer diagnosis')	{
				var url="../UpdateProfile/dateOfCancerDiagnosis?answers="+answers;
				$("#myModal .modal-body").load(url);
				}
			else if($(this).attr('id') == 'HER 2 positive')	{
				var url="../UpdateProfile/her2Positive?answers="+answers;
				$("#myModal .modal-body").load(url);
				}
			else if($(this).attr('id') == 'ER positive')	{
				var url="../UpdateProfile/erPositive?answers="+answers;
				$("#myModal .modal-body").load(url);
				}
			else if($(this).attr('id') == 'PR positive')	{
				var url="../UpdateProfile/prPositive?answers="+answers;
				$("#myModal .modal-body").load(url);
				}
			else if($(this).attr('id') == 'Please choose any associated medical conditions')	{
				var url="../UpdateProfile/medicalConditions?answers="+answers;
				$("#myModal .modal-body").load(url);
				}
			else if($(this).attr('id') == 'Gender')	{
				var url="../UpdateProfile/myGender?answers="+answers;
				$("#myModal .modal-body").load(url);
				}
			else if($(this).attr('id') == 'Details of your treating doctor')	{
				var url="../UpdateProfile/treatingDoctor?answers="+answers;
				$("#myModal .modal-body").load(url);
				}
			else if($(this).attr('id') == 'Highest level of education')	{
				var url="../UpdateProfile/highestLevelofEducation?answers="+answers;
				$("#myModal .modal-body").load(url);
				}
			else if($(this).attr('id') == 'About you and your Passion')	{
				var url="../UpdateProfile/aboutYourself?answers="+answers;
				$("#myModal .modal-body").load(url);
				}
				}
			
				});	
		});
		</script>
		
		
		
		
		
		
</body>
</html>