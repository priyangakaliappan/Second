<%--<link href="../assets/profile/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="../assets/profile/css/colorbox.css" rel="stylesheet" type="text/css">
	<!-- Custom CSS -->
    <link href="../assets/profile/css/style.css" rel="stylesheet" type="text/css">
    <!-- Custom Fonts -->
    <link href="../assets/profile/css/font-awesome.min.css" rel="stylesheet" type="text/css">--%>
<section>
<div class="container container-950">
<div class="row">
	<div class="col-sm-12">
		<div class="profile-box-bg">
			<div class="col-md-12 col-xs-12 center-align text-center">
				<g:form controller="updateProfile" name="diagnosisSave" action="stateYourDiagnosis"
					class="form-horizontal">
					<div class="icon-box-top">
						<img src="../assets/icon/d2-icon.jpg" />
					</div>
					<h1>State your diagnosis</h1>
					<div class="col-md-12 text-center center-align">
						<g:select name="diagnosis" from="${diagnosisList}" id="diagnosis"
							noSelection="['':'Please Select your Condition']" optionKey="id"
							optionValue="diagnosisName"
							class="select-condition select-condition1" value="${value?.id}"/>
					</div>
					<div class="clearfix"></div>
					<g:submitButton name="saveDiagnosis" value="Save and Continue" id="saveDiagnosis" class="blue-btn  mar-top-30"/>
				</g:form>
			</div>
			<br/>
		</div>
	</div>
	</div></div>
</section>
<script>
	// To check nullable field
	$("#saveDiagnosis").click(function() {
		if ($("#diagnosis").val() == "") {
			alert("Please select your Condition");
			return false;
		} else {
			return true;
		}
	});
	</script>