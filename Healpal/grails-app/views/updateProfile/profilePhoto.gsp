<%--<link href="../assets/profile/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="../assets/profile/css/colorbox.css" rel="stylesheet" type="text/css">
	<!-- Custom CSS -->
    <link href="../assets/profile/css/style.css" rel="stylesheet" type="text/css">
    <!-- Custom Fonts -->
    <link href="../assets/profile/css/font-awesome.min.css" rel="stylesheet" type="text/css">--%>
<g:form controller="updateProfile" action="profilePhoto" name="myUpload"
	id="myUpload" enctype="multipart/form-data">
	<div class="col-sm-12">
						<div class="profile-box-bg">
							<div class="text-center">
								<div class="icon-box-top"><img src="../assets/profile/img/user-icon1.jpg" /></div>
								<div class="col-md-12 col-xs-12 pad-lr-0">
									<input type="file" name="uploadPhoto" maxlength="255"
									value="Upload your photo"
									accept="image/*" id="upload_photo" onchange="pressed()" class="upload-photo-btn upload-browse-btn choose-file-btn"/>
									<label id="err_field"></label>
					<h3 class="col-md-12 col-xs-12 center-align browse-text" style="font-family: 'Opensans Light'; font-size:18px;">(Only JPG, JPEG, PNG & GIF files are allowed)</h3>
					<br>
									<g:submitButton name="Save and Continue" class="blue-btn" id="submitPhoto" onclick="return check()"/>
								</div>
								<div class="clearfix"></div>
							</div>
							</div>
						</div>
</g:form>
<script>
	/*
	 * To check valid mime type for uploaded file

	 $( "#myUpload" ).validate({
		  rules: {
			  uploadPhoto: {
		      //required: true,
		      accept: "jpg|jpeg|png|gif"
		          
		    }
		  }
		});

	 */
	
	
	// check for nullable field
	function check(){
		$("#err_field").html("")
		var ext = $('#upload_photo').val().split('.').pop().toLowerCase();
	if($("#upload_photo").val()==""||$("#upload_photo").val()==null){
	$("#err_field").html("Please choose a file")
	return false;
		}
	else if($.inArray(ext, ['gif','png','jpg','jpeg']) == -1){
		$("#err_field").html("Sorry ! Invalid file format")
	return false;
		}
	else{
	return true;
		}
		}
	</script>