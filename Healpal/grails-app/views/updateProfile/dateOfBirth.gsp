<%@ page contentType="text/html;charset=UTF-8"%>
<%--<link href="../assets/profile/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="../assets/profile/css/colorbox.css" rel="stylesheet" type="text/css">
	<!-- Custom CSS -->
    <link href="../assets/profile/css/style.css" rel="stylesheet" type="text/css">
    <!-- Custom Fonts -->
    <link href="../assets/profile/css/font-awesome.min.css" rel="stylesheet" type="text/css">
--%><section>
<div class="container container-950">
<div class="row">
	<div class="col-sm-12">
		<div class="profile-box-bg">
			<g:form controller="updateProfile" action="dateOfBirth" name="">
				<div class="text-center">
					<div class="icon-box-top">
						<img src="../assets/icon/c2-icon.jpg" />
					</div>
					<h1>Select your Date of Birth</h1>
					
					<div class="dob-box">
						<input type="text" name="dob" placeholder="mm/dd/yyyy" class="datepicker date_picker" value="${dateOfBirth}"  id="example2" onKeyPress="return checkOnlyDate(event);">
					<p id="timer" style="color:#ff7170;"></p>
					<g:hiddenField name="diagnosisDate" id="diagnosisDate"
						value="${dateOfDiagnosis}" />
					<g:submitButton name="Save and Continue" class="blue-btn"
						id="editDOB" />
				</div>
				
					</div> 
				</g:form>
			<br/>
			
			
			</div>
	</div>
	</div></div>
</section>
<script type="text/javascript"
	src="${resource(dir:'assets/js/datepicker',file:'bootstrap-datepicker.js')}"></script>
<script src="../js/profile/profile.js"></script>
<script type="text/javascript">
	// To diable future date when the document is ready
	$(document).ready(function() {
		var dateOfDiagnosis = $("#diagnosisDate").val()
		$("#example2").datepicker({
			endDate : dateOfDiagnosis,
			autoclose : true
		});

	});
</script>
