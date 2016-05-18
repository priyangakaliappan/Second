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
						<div class="profile-box-bg pad-top-0">
						<g:form controller="updateProfile" action="ageAtDiagnosis">
							<div class="col-md-12 col-xs-12 center-align  text-center m-pad-lr pad-lr-0">
							<g:form controller="updateProfile" name="d5" class="form-horizontal">
				<h1>Your age at Diagnosis</h1>
					<div class="col-md-7 text-center center-align">
					<input type="text" class="textbox text-box1" id="age" maxlength="3" name="age" 
						value="${value}" readonly="readonly"/>
				</div>
				<div class="clearfix"></div>
				<p class="warn_msg">Sorry, You cannot edit age at diagnosis</p>
					<div class="clearfix mar-bot-20"></div>			
								<g:submitButton name="Save" value="Save and Continue" class="blue-btn" id="saveAge"/>
				</g:form>
								</div>
								
								</g:form>
							</div>
							
							</div></div></div></section>
<%--<script>
	$("#saveAge").click(function(){
		if($("#age").val() == ""){
		alert("Please enter your Age");
		return false;
		}
		else{
		return true;
		}
		});
	</script>--%>